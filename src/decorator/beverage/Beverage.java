package decorator.beverage;

public abstract class Beverage {

    private String mDescription;

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public abstract double cost();

}
