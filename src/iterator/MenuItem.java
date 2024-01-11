package iterator;

public class MenuItem {

    private String mName;
    private double mPrice;

    public MenuItem(String name, double price) {
        mName = name;
        mPrice = price;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

}
