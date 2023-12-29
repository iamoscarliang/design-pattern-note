package factory.store;

import factory.ingredient.NYPizzaIngredientFactory;
import factory.ingredient.PizzaIngredientFactory;
import factory.pizza.CheesePizza;
import factory.pizza.ClamPizza;
import factory.pizza.Pizza;

public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        Pizza pizza;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        switch (type) {
            case "cheese":
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("New York Cheese Pizza!");
                break;
            case "clam":
                pizza = new ClamPizza(ingredientFactory);
                pizza.setName("New York Clam Pizza!");
                break;
            default:
                throw new IllegalArgumentException("Pizza type noy found!");
        }

        return pizza;
    }

}
