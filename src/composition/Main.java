package composition;

public class Main {

    public static void main(String[] args) {
        MenuComponent breakfastMenu = new Menu("Breakfast Menu");
        breakfastMenu.add(new MenuItem("Blueberry Pancake", 3.49));
        breakfastMenu.add(new MenuItem("Waffle", 3.59));

        MenuComponent dinnerMenu = new Menu("Dinner Menu");
        dinnerMenu.add(new MenuItem("Fillet Steak", 20.99));
        dinnerMenu.add(new MenuItem("New York Steak", 15.99));

        MenuComponent dessertMenu = new Menu("Dessert Menu");
        dessertMenu.add(new MenuItem("Apple Pie", 1.59));
        dessertMenu.add(new MenuItem("Ice Cream", 2.59));

        MenuComponent allMenu = new Menu("All Menus");
        allMenu.add(breakfastMenu);
        allMenu.add(dinnerMenu);
        dinnerMenu.add(dessertMenu);


        allMenu.print();
    }

}
