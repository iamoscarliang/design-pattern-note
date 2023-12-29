package factory.pizza;

import factory.ingredient.PizzaIngredientFactory;

public class CheesePizza extends Pizza {

    private PizzaIngredientFactory mIngredientFactory;

    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        mIngredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + getName());
        mDough = mIngredientFactory.createDough();
        mSauce = mIngredientFactory.createSauce();
        mCheese = mIngredientFactory.createCheese();
    }

}
