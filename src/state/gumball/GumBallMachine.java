package state.gumball;

import state.gumball.state.*;

public class GumBallMachine {

    public final State mSoldOutState;
    public final State mNoQuarterState;
    public final State mHasQuarterState;
    public final State mSoldState;

    private State mState;
    private int mCount;

    public GumBallMachine(int initCount) {
        mSoldOutState = new SoldOutState(this);
        mNoQuarterState = new NoQuarterState(this);
        mHasQuarterState = new HasQuarterState(this);
        mSoldState = new SoldState(this);

        mCount = initCount;
        if (initCount > 0) {
            mState = mNoQuarterState;
        } else {
            mState = mSoldOutState;
        }
    }

    public int getCount() {
        return mCount;
    }

    public void setState(State state) {
        mState = state;
    }

    public void insertQuarter() {
        mState.insertQuarter();
    }

    public void ejectQuarter() {
        mState.ejectQuarter();
    }

    public void turnCrank() {
        mState.turnCrank();
        mState.dispense();
    }

    public void releaseBall() {
        System.out.println("A gumball rolling out the slot...");
        if (mCount > 0) {
            mCount--;
        }
    }

}
