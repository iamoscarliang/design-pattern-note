package state.gumball.state;

import state.gumball.GumBallMachine;

public class SoldOutState implements State {

    private final GumBallMachine mMachine;

    public SoldOutState(GumBallMachine machine) {
        mMachine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("You cannot insert a quarter, the machine is sold out!");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You cannot eject, you haven't inserted a quarter yet!");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there is no quarter!");
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispensed!");
    }

}
