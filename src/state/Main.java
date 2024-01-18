package state;

import state.gumball.GumBallMachine;

public class Main {

    public static void main(String[] args) {
        GumBallMachine machine = new GumBallMachine(2);

        System.out.println("Gumball Machine has " + machine.getCount() + " gumball!");

        machine.insertQuarter();
        machine.turnCrank();

        System.out.println("Gumball Machine has " + machine.getCount() + " gumball!");

        machine.insertQuarter();
        machine.turnCrank();
        machine.insertQuarter();
        machine.turnCrank();

        System.out.println("Gumball Machine has " + machine.getCount() + " gumball!");
    }

}
