package state.gumball.state;

import state.gumball.GumBallMachine;

public class SoldOutState extends State {

    public SoldOutState(GumBallMachine machine) {
        super(machine);
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
