package flyweight;

public class Leaf {

    private String mColor;

    public Leaf(String color) {
        mColor = color;
    }

    public String getColor() {
        return mColor;
    }

    public void setColor(String color) {
        mColor = color;
    }

    @Override
    public String toString() {
        return mColor + " leaf";
    }
}
