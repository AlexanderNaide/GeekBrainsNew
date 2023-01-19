package ru.gb.Bootcamp.Patterns.Command.Commands;

import ru.gb.Bootcamp.Patterns.Command.Command;
import ru.gb.Bootcamp.Patterns.Command.MusicBox;

/**
 * Отключить музыкальный центр.
 */

public class TurnOffMusicBox implements Command {

    private MusicBox musicBox;

    public TurnOffMusicBox(MusicBox musicBox){
        this.musicBox = musicBox;
    }

    @Override
    public void execute() {
        musicBox.turnOff();
    }
}
