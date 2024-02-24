# design-pattern-note

Design Pattern in Java with real-world examples

---

## :pushpin: Content
- :dart: [Strategy](#strategy)
- :eyes: [Observer](#observer)
- :bouquet: [Decorator](#decorator)
- :factory: [Factory](#factory)
- :mens: [Singleton](#singleton)


## :dart: Strategy
Define a set of replaceable algorithms at runtime. Select and replace algorithms independent of the clients that use it.

### Example
In a role-playing game, each player can select a character and their weapon. Each character can use different weapons, but only use one weapon at a time

```java
public interface WeaponBehavior {

    void useWeapon();

}

public abstract class Character {

    private WeaponBehavior mWeaponBehavior;

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        mWeaponBehavior = weaponBehavior;
    }

    public void fight() {
        mWeaponBehavior.useWeapon();
    }
    // ...

}
```

Create a king character and replace different weapons from it...

```java
// Init a king from supertype
Character king = new King();

// Init a sword weapon to the king
king.setWeaponBehavior(new SwordBehavior());
king.fight();

// Init an arrow weapon to the king
king.setWeaponBehavior(new ArrowBehavior());
king.fight(); 
```

## :eyes: Observer
Define a one to many relationships between objects. All of the observers can subscript to a single subject. When the state of the subject changes, notify all the observers that subscript to it.

### Example
In a weather system, the weather display device can subscript to the weather data. When the data changes, send the new data to all the observers.

```java
public interface Subject {

    void registerObserver(Observer observer);

    void notifyObserver();
    // ...

}

public interface Observer {

    void update(float temp, float humidity, float pressure);

}
```

Create a wheater system...

```java
public class WeatherData implements Subject {

    private float mTemp;
    private float mHumidity;
    private float mPressure;

    private final List<Observer> mObservers = new ArrayList<>();

    public void setMeasurements(float temp, float humidity, float pressure) {
        mTemp = temp;
        mHumidity = humidity;
        mPressure = pressure;
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        mObservers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : mObservers) {
            observer.update(mTemp, mHumidity, mPressure);
        }
    }
    // ...

}

public class CurrentConditionDisplay implements Observer {

    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("Current conditions: "
                + temp + " degree and "
                + humidity + "% humidity and "
                + pressure + " pressure");
    }

}
```

Send new data to all the observers...

```java
WeatherData weatherData = new WeatherData();

weatherData.registerObserver(new CurrentConditionDisplay());

weatherData.setMeasurements(80, 65, 30.4f);
weatherData.setMeasurements(82, 70, 29.2f);
```

## :bouquet: Decorator
Dynamically adding behavior to an object without altering its structure.

### Example
In a cafe, baristas need to make all kinds of beverages with different condiments and calculate the cost flexibly.

```java
public abstract class Beverage {

    public abstract double cost();
    //...

}

public abstract class CondimentDecorator extends Beverage {

    protected Beverage mBeverage;

    public CondimentDecorator(Beverage beverage) {
        mBeverage = beverage;
    }

}
```

Create an espresso and some condiments...

```java
public class Espresso extends Beverage {

    @Override
    public double cost() {
        return 1.99;
    }

}

public class Mocha extends CondimentDecorator {

    @Override
    public double cost() {
        return mBeverage.cost() + 0.2;
    }

}

public class Whip extends CondimentDecorator {

    @Override
    public double cost() {
        return mBeverage.cost() + 0.1;
    }

}
```

Make an espresso with some condiments...

```java
Beverage espresso = new Espresso();
espresso = new Mocha(new Whip(espresso));
```

## :factory: Factory
Factory method defines an interface to create objects, but allows subtypes to alter the type of objects that will be created.
Abstract factory defines an interface to create objects without specifying their concrete subtypes.

### Example
In a pizza manufacturing system, each pizza store sells different flavors of pizza that are made with ingredients from different ingredients factories.

```java
public abstract class Pizza {

    protected PizzaIngredientFactory mIngredientFactory;

    public Pizza(PizzaIngredientFactory ingredientFactory) {
        mIngredientFactory = ingredientFactory;
    }

    public abstract void prepare();

}

public interface PizzaIngredientFactory {

    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

}

public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        return pizza;
    }

    protected abstract Pizza createPizza(String type);

}
```

Create a NY pizza store that makes cheese pizza with ingredients from NY factory...

```java
public class CheesePizza extends Pizza {

    @Override
    public void prepare() {
        mIngredientFactory.createDough();
        mIngredientFactory.createSauce();
        mIngredientFactory.createCheese();
    }
    //...

}

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }
    //...

}

public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        Pizza pizza = new CheesePizza(ingredientFactory);
        return pizza;
    }
    //...

}
```

## :mens: Singleton
Ensures only one object of a particular class is ever created and provides a global access to it

### Example

```java
public class Singleton {

    private static Singleton INSTANCE;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }

        return INSTANCE;
    }

}
```

Create a singleton instance...
```java
Singleton singleton = Singleton.getInstance();
```


