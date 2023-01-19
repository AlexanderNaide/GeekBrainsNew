package ru.gb.Bootcamp.Patterns.Command.Commands;

import ru.gb.Bootcamp.Patterns.Command.Command;
import ru.gb.Bootcamp.Patterns.Command.Light;

/**
 * Выключить свет.
 */

public class TurnOffLight implements Command {

    private Light light;

    public TurnOffLight(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}
