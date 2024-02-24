package state.gumball.state;

import state.gumball.GumBallMachine;

public abstract class State {

    protected final GumBallMachine mMachine;

    public State(GumBallMachine machine) {
        mMachine = machine;
    }

    public abstract void insertQuarter();

    public abstract void ejectQuarter();

    public abstract void turnCrank();

    public abstract void dispense();

}
