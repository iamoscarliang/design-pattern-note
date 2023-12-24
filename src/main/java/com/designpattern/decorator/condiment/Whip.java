package com.designpattern.decorator.condiment;

import com.designpattern.decorator.beverage.Beverage;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        mBeverage = beverage;
    }

    @Override
    public String getDescription() {
        return mBeverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return mBeverage.cost() + 0.1;
    }

}
