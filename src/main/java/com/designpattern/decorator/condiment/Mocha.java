package com.designpattern.decorator.condiment;

import com.designpattern.decorator.beverage.Beverage;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        mBeverage = beverage;
    }

    @Override
    public String getDescription() {
        return mBeverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return mBeverage.cost() + 0.2;
    }

}
