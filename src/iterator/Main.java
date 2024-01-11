package iterator;

import iterator.pancakehouse.PancakeHouseMenu;
import iterator.stackhouse.StackHouseMenu;

public class Main {

    public static void main(String[] args) {
        Menu pancakeHouseMenu = new PancakeHouseMenu();
        Menu stackHouseMenu = new StackHouseMenu();

        System.out.println("Pancake House Menu:");
        printMenu(pancakeHouseMenu.createIterator());

        System.out.println("Stack House Menu:");
        printMenu(stackHouseMenu.createIterator());
    }

    private static void printMenu(MenuIterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.println(menuItem.getName() + ", $" + menuItem.getPrice());
        }
    }

}
