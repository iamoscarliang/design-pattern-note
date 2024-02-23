package decorator.condiment;

import decorator.beverage.Beverage;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        super(beverage);
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
