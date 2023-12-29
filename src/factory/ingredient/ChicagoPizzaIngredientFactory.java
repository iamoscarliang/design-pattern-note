package factory.ingredient;

import factory.ingredient.clam.Clam;
import factory.ingredient.clam.FrozenClam;
import factory.ingredient.chese.Cheese;
import factory.ingredient.chese.MozzarellaCheese;
import factory.ingredient.dough.Dough;
import factory.ingredient.dough.ThickDough;
import factory.ingredient.sauce.PlumTomatoSauce;
import factory.ingredient.sauce.Sauce;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        System.out.println("Add Think Dough!");
        return new ThickDough();
    }

    @Override
    public Sauce createSauce() {
        System.out.println("Add PlumTomato Sauce!");
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        System.out.println("Add Mozzarella Cheese!");
        return new MozzarellaCheese();
    }

    @Override
    public Clam createClam() {
        System.out.println("Add Frozen Clam!");
        return new FrozenClam();
    }

}
