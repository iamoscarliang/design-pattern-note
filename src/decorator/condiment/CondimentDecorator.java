package decorator.condiment;

import decorator.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {

    protected Beverage mBeverage;

    public CondimentDecorator(Beverage beverage) {
        mBeverage = beverage;
    }

    public abstract String getDescription();

}
