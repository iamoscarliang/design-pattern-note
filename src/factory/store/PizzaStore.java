package factory.store;

import factory.pizza.Pizza;

public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        return pizza;
    }

    protected abstract Pizza createPizza(String type);

}
