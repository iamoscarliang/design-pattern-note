package state.gumball.state;

import state.gumball.GumBallMachine;

public class SoldState implements State {

    private final GumBallMachine mMachine;

    public SoldState(GumBallMachine machine) {
        mMachine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we are already giving you a gumball!");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turn the crank!");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice does not get you another gumball!");
    }

    @Override
    public void dispense() {
        mMachine.releaseBall();
        if (mMachine.getCount() > 0) {
            mMachine.setState(mMachine.mNoQuarterState);
        } else {
            System.out.println("Oops, out of gumball!");
            mMachine.setState(mMachine.mSoldOutState);
        }
    }

}
