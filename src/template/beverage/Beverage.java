package template.beverage;

public abstract class Beverage {

    public final void prepare() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    protected abstract void brew();

    protected abstract void addCondiments();

    protected void boilWater() {
        System.out.println("Boiling water!");
    }

    protected void pourInCup() {
        System.out.println("Pouring into cup!");
    }

}
