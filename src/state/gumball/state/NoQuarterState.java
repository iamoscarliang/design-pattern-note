package state.gumball.state;

import state.gumball.GumBallMachine;

public class NoQuarterState implements State {

    private final GumBallMachine mMachine;

    public NoQuarterState(GumBallMachine machine) {
        mMachine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter!");
        mMachine.setState(mMachine.mHasQuarterState);
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter!");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there is no quarter!");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay a quarter fist!");
    }

}
