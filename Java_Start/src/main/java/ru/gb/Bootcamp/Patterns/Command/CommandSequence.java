package ru.gb.Bootcamp.Patterns.Command;

import java.util.List;

/**
 * Последовательность команд
 */

public class CommandSequence implements Command{
    private List<Command> commands;

    public CommandSequence(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {

        for (Command command : commands) {
            command.execute();
        }
    }
}
