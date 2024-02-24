package factory.pizza;

import factory.ingredient.PizzaIngredientFactory;

public abstract class Pizza {

    private String mName;

    protected PizzaIngredientFactory mIngredientFactory;

    public Pizza(PizzaIngredientFactory ingredientFactory) {
        mIngredientFactory = ingredientFactory;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public abstract void prepare();

}
