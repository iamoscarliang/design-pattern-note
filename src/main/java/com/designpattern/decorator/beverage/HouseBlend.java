package com.designpattern.decorator.beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        setDescription("House Blend Coffee");
    }

    @Override
    public double cost() {
        return 0.89;
    }

}
