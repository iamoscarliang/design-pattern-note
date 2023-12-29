package factory;

import factory.pizza.Pizza;
import factory.store.ChicagoPizzaStore;
import factory.store.NYPizzaStore;
import factory.store.PizzaStore;

public class Main {

    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza1 = nyStore.orderPizza("cheese");
        System.out.println("Order a " + pizza1.getName());

        System.out.println();

        Pizza pizza2 = nyStore.orderPizza("clam");
        System.out.println("Order a " + pizza2.getName());

        System.out.println();

        Pizza pizza3 = chicagoStore.orderPizza("clam");
        System.out.println("Order a " + pizza3.getName());
    }

}
