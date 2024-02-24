package factory.pizza;

import factory.ingredient.PizzaIngredientFactory;

public class CheesePizza extends Pizza {

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        super(ingredientFactory);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + getName());
        mIngredientFactory.createDough();
        mIngredientFactory.createSauce();
        mIngredientFactory.createCheese();
    }

}
