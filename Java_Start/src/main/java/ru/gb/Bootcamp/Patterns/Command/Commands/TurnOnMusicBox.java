package ru.gb.Bootcamp.Patterns.Command.Commands;

import ru.gb.Bootcamp.Patterns.Command.Command;
import ru.gb.Bootcamp.Patterns.Command.MusicBox;

/**
 * Включить музыкальный центр.
 */

public class TurnOnMusicBox implements Command {

    private MusicBox musicBox;

    public TurnOnMusicBox(MusicBox musicBox){
        this.musicBox = musicBox;
    }

    @Override
    public void execute() {
        musicBox.turnOn();
    }
}
