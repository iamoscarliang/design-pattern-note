package com.designpattern.decorator;

import com.designpattern.decorator.beverage.Beverage;
import com.designpattern.decorator.beverage.Espresso;
import com.designpattern.decorator.beverage.HouseBlend;
import com.designpattern.decorator.condiment.Mocha;
import com.designpattern.decorator.condiment.Soy;
import com.designpattern.decorator.condiment.Whip;

public class Main {

    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription() + " $" + espresso.cost());

        Beverage houseBlend = new HouseBlend();
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Whip(houseBlend);
        houseBlend = new Soy(houseBlend);
        System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());
    }

}
