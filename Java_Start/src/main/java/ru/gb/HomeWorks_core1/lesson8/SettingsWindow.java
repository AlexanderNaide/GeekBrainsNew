package ru.gb.HomeWorks_core1.lesson8;


import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_HEIGHT = 300;
    private static final int MIN_WIN_LENGTH = 3;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String FIELD_SIZE_PREFIX = "Размер поля: ";
    private static final String WIN_LENGTH_PREFIX = "Длинна выйгрышной цепочки: ";

    private JRadioButton humanVsAi;
    private JRadioButton humanVsHuman;
    private JSlider winLengthSlider;
    private JSlider fieldSizeSlider;
    private GameWindow gameWindow;

    public SettingsWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(gameWindow);
        setResizable(false);
        setTitle("Настройки");
        setLayout(new GridLayout(10, 1));
        JButton buttonStart = new JButton("СТАРТ");
        buttonStart.addActionListener(e -> submitSettings(gameWindow));
        addFieldSize();
        addGameMode();
        add(buttonStart);

    }

    private void addFieldSize(){
        JLabel labelFieldSize = new JLabel(FIELD_SIZE_PREFIX + MIN_FIELD_SIZE);
        JLabel labelWinLength = new JLabel(WIN_LENGTH_PREFIX + MIN_WIN_LENGTH);
        fieldSizeSlider = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        winLengthSlider = new JSlider(MIN_WIN_LENGTH, MIN_FIELD_SIZE, MIN_WIN_LENGTH);//тут исправил микробаг:
        // поменял MAX_FIELD_SIZE на MIN_FIELD_SIZE, иначе получалось, что в окне настроек если к слайдеру fieldSize не прикосаешься ,
        // то значение размера выйгрыша можно выбирать до 10, которое в игре никогда не будет достигнуто

        fieldSizeSlider.addChangeListener(e -> {
            int current = fieldSizeSlider.getValue();
            labelFieldSize.setText(FIELD_SIZE_PREFIX + current);
            winLengthSlider.setMaximum(current);
        });

        winLengthSlider.addChangeListener(e ->
                labelWinLength.setText(WIN_LENGTH_PREFIX + winLengthSlider.getValue())
        );

        add(new JLabel("<html><body><i>Выбор размера поля</i></body></html>"));

        add(labelFieldSize);
        add(fieldSizeSlider);
        add(new JLabel("<html><body><i>Выбор длинны выйгрыша</i></body></html>"));
        add(labelWinLength);
        add(winLengthSlider);

    }

    private void addGameMode(){
        add(new JLabel("<html><body><i>Выбор режима игры</i></body></html>"));
        humanVsAi = new JRadioButton("Человек против компьютера", true);
        humanVsHuman = new JRadioButton("Человек против Человека");
        ButtonGroup group = new ButtonGroup();
        group.add(humanVsAi);
        group.add(humanVsHuman);
        add(humanVsAi);
        add(humanVsHuman);
    }

    private void submitSettings(GameWindow gameWindow){
        int gameMode;
        if (humanVsAi.isSelected()){
            gameMode = GameMap.MODE_VS_AI;
        } else {
            gameMode = GameMap.MODE_VS_HUMAN;
        }
        int fieldSize = fieldSizeSlider.getValue();
        int winLength = winLengthSlider.getValue();
        gameWindow.startGame(gameMode, fieldSize, winLength);
        setVisible(false);

    }

}
