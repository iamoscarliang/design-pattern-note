package factory.pizza;

import factory.ingredient.PizzaIngredientFactory;
import factory.ingredient.clam.Clam;

public class ClamPizza extends Pizza {

    protected Clam mClam;

    private PizzaIngredientFactory mIngredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        mIngredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + getName());
        mDough = mIngredientFactory.createDough();
        mSauce = mIngredientFactory.createSauce();
        mCheese = mIngredientFactory.createCheese();
        mClam = mIngredientFactory.createClam();
    }

}
