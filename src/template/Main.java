package template;

import template.beverage.Tea;
import template.beverage.Beverage;
import template.beverage.Coffee;

public class Main {

    public static void main(String[] args) {
        Beverage tea = new Tea();
        Beverage coffee = new Coffee();

        System.out.println("Making tea...");
        tea.prepare();

        System.out.println("Making coffee...");
        coffee.prepare();
    }

}
