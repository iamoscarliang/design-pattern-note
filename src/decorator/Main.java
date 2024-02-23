package decorator;

import decorator.beverage.Beverage;
import decorator.beverage.Espresso;
import decorator.beverage.HouseBlend;
import decorator.condiment.Mocha;
import decorator.condiment.Whip;

public class Main {

    public static void main(String[] args) {
        Beverage houseBlend = new HouseBlend();
        System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());

        Beverage espresso = new Espresso();
        espresso = new Mocha(new Whip(espresso));
        System.out.println(espresso.getDescription() + " $" + espresso.cost());
    }

}
