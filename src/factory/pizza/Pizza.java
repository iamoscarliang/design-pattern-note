package factory.pizza;

import factory.ingredient.chese.Cheese;
import factory.ingredient.dough.Dough;
import factory.ingredient.sauce.Sauce;

public abstract class Pizza {

    private String mName;

    protected Dough mDough;
    protected Sauce mSauce;
    protected Cheese mCheese;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public abstract void prepare();

    public void bake() {
        System.out.println("Bake for 25 min at 350!");
    }

    public void cut() {
        System.out.println("Cut into diagonal slice!");
    }

    public void box() {
        System.out.println("Place in pizza box!");
    }


}
