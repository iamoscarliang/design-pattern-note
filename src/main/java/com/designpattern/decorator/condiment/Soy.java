package com.designpattern.decorator.condiment;

import com.designpattern.decorator.beverage.Beverage;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        mBeverage = beverage;
    }

    @Override
    public String getDescription() {
        return mBeverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return mBeverage.cost() + 0.15;
    }

}
