package factory.pizza;

import factory.ingredient.PizzaIngredientFactory;

public class ClamPizza extends Pizza {

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        super(ingredientFactory);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + getName());
        mIngredientFactory.createDough();
        mIngredientFactory.createSauce();
        mIngredientFactory.createCheese();
        mIngredientFactory.createClam();
    }

}
