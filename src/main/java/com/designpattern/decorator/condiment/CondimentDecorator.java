package com.designpattern.decorator.condiment;

import com.designpattern.decorator.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {

    protected Beverage mBeverage;

    public abstract String getDescription();

}
