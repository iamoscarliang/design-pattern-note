package factory.ingredient;

import factory.ingredient.clam.Clam;
import factory.ingredient.clam.FreshClam;
import factory.ingredient.chese.Cheese;
import factory.ingredient.chese.ReggianoCheese;
import factory.ingredient.dough.Dough;
import factory.ingredient.dough.ThinDough;
import factory.ingredient.sauce.MarinaraSauce;
import factory.ingredient.sauce.Sauce;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        System.out.println("Add Thin Dough!");
        return new ThinDough();
    }

    @Override
    public Sauce createSauce() {
        System.out.println("Add Marinara Sauce!");
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        System.out.println("Add Reggiano Cheese!");
        return new ReggianoCheese();
    }

    @Override
    public Clam createClam() {
        System.out.println("Add Fresh Clam!");
        return new FreshClam();
    }

}
