package ru.gb.Bootcamp.Patterns.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Пульт Управления
 */

public class MyRemoteControl {

    private List<Command> buttons;

    public MyRemoteControl() {
        buttons = new ArrayList<>();
    }

    public void addCommand(int idButton, Command command){
        buttons.add(idButton, command);
    }

    public void pressButton(int idButton){
        buttons.get(idButton).execute();
    }
}
