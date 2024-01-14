package composition;

public class MenuItem extends MenuComponent {

    private String mName;
    private double mPrice;

    public MenuItem(String name, double price) {
        mName = name;
        mPrice = price;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public double getPrice() {
        return mPrice;
    }

    @Override
    public void print() {
        System.out.println("   " + mName + ", $" + mPrice);
    }

}
