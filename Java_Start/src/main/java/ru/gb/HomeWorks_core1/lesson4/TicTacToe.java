package ru.gb.HomeWorks_core1.lesson4;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/*********
1. Упразднил fieldSizeX и fieldSizeY, вместо этого ввел один fieldSize для длинны и ширины, т.к. предпочтительнее создавать квадратное поле.
2. Создал все условия, чтобы программа одинаково работала с любым размером поля и длинны цепочки,
   в частности переписан метод checkWin (ну собственно это и нужно было в задании).
3. В методе chooseDot добавил игроку возможность выбирать размер поля и длинну цепочки.
4. В метод aiTurn реализовал две логики: во первых, добавил логику проверки "последнего выйгрышного хода" - если есть такое место, поставив в которое свою фишку компьютер выйграет -
   компьютер его найдет и использует, во вторых, если такое место есть для человека - компьютер его найдет и помешает человеку выйграть.
   Есть еще идеи по улучшению "хитрости" компьютера, например проверить свободна ли цепочка клеток в любом направлении, заполнив которую будет выйгрыш -
   её и заполнять (в рандомное место, но внутри цепочки), пока человек не прервет её, либо не наступит выйгрыш, но на данный момент предпочту вовремя сдать ДЗ, чем копаться неделю с кодом)))
5. Прочие мелкие изменения для организации взаимодействия всех методов.

P.S.: Я плохо знаю английский, поэтому взаимодействие с игроком пишу на русском.

*********/

public class TicTacToe {
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char DOT_EMPTY = '.';

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    private static char[][] field;
    private static char dotHuman;
    private static char dotAi;
    private static int fieldSize;
    private static int scoreHuman;
    private static int scoreAi;
    private static int roundCounter;
    private static int winLength;


    public static void main(String[] args) {
        startNewGame();
    }

    private static void startNewGame() {
        while(true) {
            chooseDot();
            playRound();

            System.out.printf("""
                    СЧЕТ:          ЧЕЛОВЕК          КОМПЬЮТЕР
                                      %d                 %d
                    """, scoreHuman, scoreAi);
            System.out.print("Хотите сыграть еще раз? (Y или N) >>>>>");

            if (!scanner.next().toLowerCase(Locale.ROOT).equals("y")){
                System.out.println("Пока!");
                break;
            }
        }
    }

    private static void chooseDot(){
        fieldSize = 0;
        do {
            System.out.println("Выберите размер поля, для этого введите число, соответствующее размеру стороны квадрата (предпочтительно от 3 до 9) >>>>>");
            int a = scanner.nextInt();
            if (a >= 3 && a <= 9) {
                fieldSize = a;
            }
        }while (fieldSize == 0);
        winLength = 0;
        do {
            System.out.println("Введите длинну выйгрышной цепочки >>>>>");
            int b = scanner.nextInt();
            if (b >= 2 && b <= fieldSize) {
                winLength = b;
            }
        }while (winLength == 0);

        System.out.println("Введи 'X' если хочешь играть крестиками или '0', если хочешь играть ноликами >>>>>");

        if (scanner.next().toLowerCase(Locale.ROOT).equals("x")){
            dotHuman = DOT_X;
            dotAi = DOT_O;
        } else {
            dotHuman = DOT_O;
            dotAi = DOT_X;
        }
    }

    private static void playRound() {
        System.out.printf("Раунд %d начался!\n", ++roundCounter);
        initField();
        printField();
        if (dotHuman == DOT_X) {
            humanFirst();
        } else {
            aiFirst();
        }
    }

    private static void initField(){
        field = new char[fieldSize][fieldSize];

        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    private static void printField(){
        System.out.print("+");

        for (int i = 0; i < fieldSize * 2 + 1; i++) {
            System.out.print(i % 2 == 0 ? "-" : i / 2 + 1);
        }

        System.out.println();
        for (int i = 0; i < fieldSize; i++) {
            System.out.print(i + 1 + "|");

            for (int j = 0; j < fieldSize; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
        for (int i = 0; i < fieldSize * 2 + 2; i++) {
            System.out.print("_");
        }
        System.out.println();
    }

    private static void humanFirst() {
        while (true){
            humanTurn();
            printField();
            if (gameCheck(dotHuman)) {
                break;
            }
            aiTurn();
            printField();
            if (gameCheck(dotAi)) {
                break;
            }
        }
    }

    private static void aiFirst() {
        while (true){
            aiTurn();
            printField();
            if (gameCheck(dotAi)) {
                break;
            }
            humanTurn();
            printField();
            if (gameCheck(dotHuman)) {
                break;
            }
        }
    }

    private static boolean gameCheck(char dot){
        if (checkWin(dot, field) && dot == dotHuman) {
            System.out.println("Человек победил!");
            scoreHuman++;
            return true;
        } else if (checkWin(dot, field) && dot == dotAi) {
            System.out.println("Компьютер победил!");
            scoreAi++;
            return true;
        }
        return checkDraw();
    }

    private static void aiTurn() {
        int x = 0;
        int y = 0;
        char[][] fieldTask = new char[fieldSize][fieldSize];
        for (int i = 0; i < field.length; i++) {
            fieldTask[i] = Arrays.copyOf(field[i], field[1].length);
        }

        boolean b = false;

        for (int i = 0; i < fieldSize && !b; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (fieldTask[i][j] == DOT_EMPTY){
                    fieldTask[i][j] = dotAi;
                    if (checkWin(dotAi, fieldTask)){
                        x = j;
                        y = i;
                        b = true;
                        break;
                    } else {
                        fieldTask[i][j] = DOT_EMPTY;
                    }
                }
            }
        }

        if (!b ){
            for (int i = 0; i < fieldSize && !b; i++) {
                for (int j = 0; j < fieldSize; j++) {
                    if (fieldTask[i][j] == DOT_EMPTY){
                        fieldTask[i][j] = dotHuman;
                        if (checkWin(dotHuman, fieldTask)){
                            x = j;
                            y = i;
                            b = true;
                            break;
                        } else {
                            fieldTask[i][j] = DOT_EMPTY;
                        }
                    }
                }
            }
        }

        if (!b ){
            do {
                x = random.nextInt(fieldSize);
                y = random.nextInt(fieldSize);
            }while (!isCellValid(y, x));
        }
        field[y][x] = dotAi;

    }

    private static void humanTurn() {
        int x;
        int y;

        do { System.out.println("Введи координаты x & y  >>>>>");

            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y, x));

        field[y][x] = dotHuman;

    }

    private static boolean checkDraw(){
        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                if (field[y][x] == DOT_EMPTY){
                    return false;
                }
            }
        }
        System.out.println("Ничья!");
        return true;
    }

    private static boolean checkWin(char dot, char[][] checkField){
        boolean result = false;
        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                if (checkField[y][x] == dot){
                    if (checkingTheLine(y, x, 0, 1, checkField) ||
                            checkingTheLine(y, x, 1, 0, checkField) ||
                            checkingTheLine(y, x, 1, 1, checkField) ||
                            checkingTheLine(y, x, 1, -1, checkField)) {
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    private static boolean checkingTheLine(int y, int x, int deltaY, int deltaX, char[][] checkField){
        int count = 0;
        for (int i = y, j = x; i < fieldSize && j < fieldSize && i >=0 && j >= 0; i += deltaY, j += deltaX) {
            if (checkField[i][j] == checkField[y][x]){
                count++;
            } else {
                break;
            }
        }
        return count >= winLength;
    }

    private static boolean isCellValid(int y, int x){
        return x >= 0 && y >= 0 && x < fieldSize && y < fieldSize && field[y][x] == DOT_EMPTY;
    }

}
