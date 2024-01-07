package adapter;

import adapter.duck.Duck;
import adapter.duck.MallardDuck;
import adapter.turkey.Turkey;
import adapter.turkey.WildTurkey;

public class Main {

    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        Turkey turkey = new WildTurkey();
        Duck turkeyAdapter = new TurkeyAdapter(turkey);

        System.out.println("The turkey says...");
        turkey.gobble();
        turkey.fly();

        System.out.println("The duck says...");
        duck.quack();
        duck.fly();

        System.out.println("The turkeyAdapter says...");
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }

}
