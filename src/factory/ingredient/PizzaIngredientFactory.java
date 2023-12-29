package factory.ingredient;

import factory.ingredient.clam.Clam;
import factory.ingredient.chese.Cheese;
import factory.ingredient.dough.Dough;
import factory.ingredient.sauce.Sauce;

public interface PizzaIngredientFactory {

    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    Clam createClam();

}
