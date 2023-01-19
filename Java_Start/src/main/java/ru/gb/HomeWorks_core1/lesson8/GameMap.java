package ru.gb.HomeWorks_core1.lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;

public class GameMap extends JPanel {
    public static final int MODE_VS_AI = 0;
    public static final int MODE_VS_HUMAN = 1;
    private static final int DOT_PLAYER1 = 1;
    private static final int DOT_PLAYER2 = 2;
    private static final int DOT_EMPTY = 0;
    private static final int DOT_PADDING = 7;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_PLAYER1 = 1;
    private static final int STATE_WIN_PLAYER2 = 2;

    public static final Random random = new Random();
    private int stateGameOver;
    private int[][] field;
    private Stone[][] sField;
    private int fieldSize;
    private int winLength;
    private int cellWidth;
    private int cellHeight;
    private boolean isGameOver;
    private boolean isInitialized;
    private int gameMode;
    private int playerNumTurn;

    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;

    public GameMap(){
        isInitialized = false;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
            }
        });
    }

    public void startNewGame(int gameMode, int fieldSize, int winLength) {
        this.gameMode = gameMode;
        this.fieldSize = fieldSize;
        this.winLength = winLength;
        field = new int[fieldSize][fieldSize];
        sField = new Stone[fieldSize][fieldSize];
        isGameOver = false;
        isInitialized = true;
        playerNumTurn = 1;
        repaint();
    }

    private void update(MouseEvent e){
        if (gameMode == 0){

            if (isGameOver || !isInitialized){
                return;
            }
            if (playerTurn(e)){
                return;
            }
            if (gameCheck()){
                return;
            }
            aiTurn();
            repaint();
            gameCheck();

        } else {
            if (isGameOver || !isInitialized){
                return;
            }
            if (playerTurn(e)){
                return;
            }
            gameCheck();
        }
    }

    private int dotPlayer (){
        if (playerNumTurn % 2 == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    private boolean playerTurn(MouseEvent e){
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        if(isCellValid(cellY, cellX) || !isCellEmpty(cellY, cellX)){
            return true;
        }
        if (playerNumTurn % 2 == 1) {
            field[cellY][cellX] = DOT_PLAYER1;
            sField[cellY][cellX] = new Stone(playerNumTurn);

        } else {
            field[cellY][cellX] = DOT_PLAYER2;
            sField[cellY][cellX] = new Stone(playerNumTurn);
        }
        playerNumTurn++;
        repaint();
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render (Graphics g){
        if (!isInitialized){
            return;
        }
        int width = getWidth();
        int height = getHeight();

        cellHeight = height / fieldSize;
        cellWidth = width / fieldSize;
        g.setColor(Color.BLACK);

        for (int i = 0; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }
        for (int i = 0; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }

        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                if (isCellEmpty(y, x)){
                    continue;
                }

                g.drawImage(sField[y][x].getStone(), x * cellWidth + DOT_PADDING,
                        y * cellHeight + DOT_PADDING,
                        cellWidth - DOT_PADDING * 2,
                        cellHeight - DOT_PADDING * 2, null);

            }
        }
        if (isGameOver){
            showGameOverMessage(g);
        }

    }

    private void showGameOverMessage(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, getHeight() / 2 - 55, getWidth(), 110);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times New Roman", Font.BOLD, 32));

        switch (stateGameOver) {
            case STATE_DRAW -> g.drawString("НИЧЬЯ!!!", getWidth() / 3 + 10, getHeight()/2 + 10);
            case STATE_WIN_PLAYER1 -> {
                if (gameMode == 0){
                    g.drawString("ПОБЕДИЛ ЧЕЛОВЕК", 60, getHeight() / 2);
                } else {
                    g.drawString("ПОБЕДИЛ ИГРОК 1", 55, getHeight() / 2);
                }
            }
            case STATE_WIN_PLAYER2 -> {
                if (gameMode == 0){
                    g.drawString("ПОБЕДИЛ КОМПЬЮТЕР", 45, getHeight() / 2);
                } else {
                    g.drawString("ПОБЕДИЛ ИГРОК 2", 50, getHeight() / 2);
                }
            }
        }
        g.setFont(new Font("Times New Roman", Font.BOLD, 16));
        g.drawString("СЧЕТ   " + scorePlayer1 + " : " + scorePlayer2, getWidth() / 2 - 44, getHeight()/2 + 40);
    }

    private boolean gameCheck(){
        int dot = dotPlayer();
        if (checkWin(dot, field) && dot == DOT_PLAYER1) {
            scorePlayer1++;
            this.stateGameOver = STATE_WIN_PLAYER1;
            isGameOver = true;
            repaint();
            return true;
        } else if (checkWin(dot, field) && dot == DOT_PLAYER2) {
            scorePlayer2++;
            this.stateGameOver = STATE_WIN_PLAYER2;
            isGameOver = true;
            repaint();
            return true;
        }
        return checkDraw();
    }

    private boolean checkDraw() {
        for (int y = 0; y < fieldSize; y++) {
            for (int x = 0; x < fieldSize; x++) {
                if (isCellEmpty(y, x)) return false;
            }
        }
        this.stateGameOver = STATE_DRAW;
        isGameOver = true;
        repaint();
        return true;
    }

    private void aiTurn() {

        int x = 0;
        int y = 0;
        int[][] fieldTask = new int[fieldSize][fieldSize];
        for (int i = 0; i < field.length; i++) {
            fieldTask[i] = Arrays.copyOf(field[i], field[1].length);
        }
        boolean b = false;
        for (int i = 0; i < fieldSize && !b; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (fieldTask[i][j] == DOT_EMPTY){
                    fieldTask[i][j] = DOT_PLAYER2;
                    if (checkWin(DOT_PLAYER2, fieldTask)){
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
                        fieldTask[i][j] = DOT_PLAYER1;
                        if (checkWin(DOT_PLAYER1, fieldTask)){
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
            }while (isCellValid(y, x));
        }

        field[y][x] = DOT_PLAYER2;
        sField[y][x] = new Stone(playerNumTurn);
        playerNumTurn++;
        repaint();
    }

    private boolean checkWin(int dot, int[][] checkField){
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

    private boolean checkingTheLine(int y, int x, int deltaY, int deltaX, int[][] checkField){
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

    private boolean isCellValid(int y, int x){
        return x < 0 || y < 0 || x >= fieldSize || y >= fieldSize || field[y][x] != DOT_EMPTY;
    }

    private boolean isCellEmpty(int y, int x){
        return field[y][x] == DOT_EMPTY;
    }

}
