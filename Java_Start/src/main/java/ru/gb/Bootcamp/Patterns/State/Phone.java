package ru.gb.Bootcamp.Patterns.State;

import static ru.gb.Bootcamp.Patterns.State.WaitingState.WAITING_STATE;

public class Phone {
    private State state = WAITING_STATE;

    public void switchState(){
        state.updateState(this);
    }

    public State getState() {
        return state;
    }

    void setState(State state) {
        this.state = state;
    }
}
