package ru.gb.Bootcamp.Patterns.State;

import static ru.gb.Bootcamp.Patterns.State.DialingState.DIALING_STATE;

public class EnteringNumberState implements State{

    public static final EnteringNumberState ENTERING_NUMBER_STATE = new EnteringNumberState();

    private EnteringNumberState(){
    }

    @Override
    public void updateState(Phone phone) {
        phone.setState(DIALING_STATE);
    }

    @Override
    public String toString() {
        return "ENTERING_NUMBER_STATE";
    }
}
