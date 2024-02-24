package state.gumball.state;

import state.gumball.GumBallMachine;

public class HasQuarterState extends State {

    public HasQuarterState(GumBallMachine machine) {
        super(machine);
    }

    @Override
    public void insertQuarter() {
        System.out.println("You cannot inserted another quarter!");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter return!");
        mMachine.setState(mMachine.mNoQuarterState);
    }

    @Override
    public void turnCrank() {
        System.out.println("You turn...");
        mMachine.setState(mMachine.mSoldState);
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispense!");
    }

}
