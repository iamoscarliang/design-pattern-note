# design-pattern-note

Design Pattern in Java with real-world examples based on [Head First Design Pattern](https://www.oreilly.com/library/view/head-first-design/9781492077992/)

---

## :pushpin: Content
- :dart: [Strategy](#strategy)
- :eyes: [Observer](#observer)
- :bouquet: [Decorator](#decorator)
- :factory: [Factory](#factory)
- :standing_person: [Singleton](#singleton)
- :joystick: [Command](#command)
- :electric_plug: [Adapter](#adapter)
- :door: [Facade](#facade)
- :clipboard: [Template](#template)
- :repeat: [Iterator](#iterator)
- :deciduous_tree: [Composition](#composition)
- :traffic_light: [State](#state)

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

Create a king character and set different weapons to it...

```java
Character king = new King();

king.setWeaponBehavior(new SwordBehavior());
king.fight();

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

## :standing_person: Singleton
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

## :joystick: Command
Encapsulate a request into an object and lets you pass requests as a method arguments.

### Example
In an appliances control system, the remote controller can control multiple devices' current state.

```java
public interface Command {

    void execute();

}

public class RemoteControl {

    private Command[] mOnCommands = new Command[7];
    private Command[] mOffCommands = new Command[7];

    public RemoteControl() {
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
            mOnCommands[i] = noCommand;
            mOffCommands[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        mOnCommands[slot] = onCommand;
        mOffCommands[slot] = offCommand;
    }

    public void onButtonPressed(int slot) {
        mOnCommands[slot].execute();
    }

    public void offButtonPressed(int slot) {
        mOffCommands[slot].execute();
    }
    //...

}
```

Create a control command over a living room light...

```java
public class Light {

    public void on() {
        System.out.println("Light is on");
    }

    public void off() {
        System.out.println("Light is off");
    }

}

public class LightOnCommand implements Command {

    private Light mLight;

    public LightOnCommand(Light light) {
        mLight = light;
    }

    @Override
    public void execute() {
        mLight.on();
    }

}

public class LightOffCommand implements Command {

    private Light mLight;

    public LightOffCommand(Light light) {
        mLight = light;
    }

    @Override
    public void execute() {
        mLight.off();
    }

}
```

Create a remote controller to turn on and off the lights...

```java
RemoteControl remoteControl = new RemoteControl();

Light livingRoomLight = new Light("Living Room");
LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
remoteControl.onButtonPressed(0);
remoteControl.offButtonPressed(0);
```

## :electric_plug: Adapter
Convert incompatible interfaces to the one clients used. Allowing objects with different interfaces to interact with.

### Example
In a farming game, the player can breed ducks. Now the designer want to add more animals, like turkey, but duck is the only interface the player can interact with...

```java
public interface Duck {

    void quack();

}

public interface Turkey {

    void gobble();

}
```

Create a turkey adapter...

```java
public class TurkeyAdapter implements Duck {

    private Turkey mTurkey;

    public TurkeyAdapter(Turkey turkey) {
        mTurkey = turkey;
    }

    @Override
    public void quack() {
        mTurkey.gobble();
    }

}
```

Now the player can interact with both the duck and the turkey...

```java
Duck duck = new MallardDuck();
Turkey turkey = new WildTurkey();
Duck turkeyAdapter = new TurkeyAdapter(turkey);

duck.quack();
turkeyAdapter.quack();
```

## :door: Facade
Provides a simplified high-level interface to a set of low-level subcomponents.

### Example
In a movie system at a theater, manager need a way to efficiently control all the equipment, like light, screen, projector...

```java
public class Light {

    public void on() {
        System.out.println("Light is on");
    }

    public void off() {
        System.out.println("Light is off");
    }

}

public class Screen {

    public void up() {
        System.out.println("Screen going up");
    }

    public void down() {
        System.out.println("Screen going down");
    }

}

public class Projector {

    public void on() {
        System.out.println("Projector is on");
    }

    public void play(String movie) {
        System.out.println("Play movie: " + movie);
    }

    public void off() {
        System.out.println("Projector is off");
    }

}
```

Create a theater facade to control all the equipment...

```java
public class TheaterFacade {

    private Light mLight;
    private Screen mScreen;
    private Projector mProjector;

    public TheaterFacade(Light light, Screen screen, Projector projector) {
        mLight = light;
        mScreen = screen;
        mProjector = projector;
    }

    public void watchMovie(String movie) {
        mLight.off();
        mScreen.down();
        mProjector.on();
        mProjector.play(movie);
    }

    public void endMovie() {
        mLight.on();
        mScreen.up();
        mProjector.off();
    }

}
```

Play a decent movie with the theater facade...

```java
Light light = new Light();
Screen screen = new Screen();
Projector projector = new Projector();

TheaterFacade theaterFacade = new TheaterFacade(light, screen, projector);
theaterFacade.watchMovie("Lord of the ring");
theaterFacade.endMovie();
```

## :clipboard: Template
Defines a set of algorithms in supertypes and let subtypes override the steps without altering algorithm’s structure.

### Example
In a cafe, the manager want to simplified the process of making beverage, so they create a stand along template to provide step to make each beverage on the menu.

```java
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
```

Create templates for coffee and tea...

```java
public class Coffee extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Dripping coffee through filter!");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk!");
    }

}

public class Tea extends Beverage {

    @Override
    protected void brew() {
        System.out.println("Steeping the tea!");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon!");
    }

}
```

To serve coffee and tea...

```java
Beverage tea = new Tea();
tea.prepare();

Beverage coffee = new Coffee();
coffee.prepare();
```

## :repeat: Iterator
Using an iterator to traverse a collection and access the elements without exposing its underlying structure.

### Example
In a stackhouse restaurant, the manager need to design a menu that can be iterated to display menu items to the customers.

```java
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

    public double getPrice() {
        return mPrice;
    }

}

public interface Menu {

    MenuIterator createIterator();

}

public interface MenuIterator {

    boolean hasNext();

    MenuItem next();

}
```

Create the menu iterator...

```java
public class StackHouseMenuIterator implements MenuIterator {

    private final MenuItem[] mMenuItems;

    private int position = 0;

    public StackHouseMenuIterator(MenuItem[] menuItems) {
        mMenuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        return position < mMenuItems.length && mMenuItems[position] != null;
    }

    @Override
    public MenuItem next() {
        return mMenuItems[position++];
    }

}
```

Create the stackhouse menu with the iterator...

```java
public class StackHouseMenu implements Menu {

    private final MenuItem[] mMenuItems = new MenuItem[2];

    public StackHouseMenu() {
        mMenuItems[0] = new MenuItem("Fillet Steak", 20.99);
        mMenuItems[1] = new MenuItem("New York Steak", 15.99);
    }

    @Override
    public MenuIterator createIterator() {
        return new StackHouseMenuIterator(mMenuItems);
    }

}
```

Display menu items to the customer...

```java
Menu stackHouseMenu = new StackHouseMenu();
printMenu(stackHouseMenu.createIterator());

private static void printMenu(MenuIterator iterator) {
    while (iterator.hasNext()) {
        MenuItem menuItem = iterator.next();
        System.out.println(menuItem.getName() + ", $" + menuItem.getPrice());
    }
}
```

## :deciduous_tree: Composition
 Define a set of objects into tree structures and treat individual objects and composite objects uniformly.

 ### Example
 In a restaurent, the manager need to design a menu that can seperate dinner items and desert items as well as easily add and remove items from it.

 ```java
public abstract class MenuComponent {

    public void add(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }

}
```

Create menu items as a component...

```java
public class MenuItem extends MenuComponent {

    private String mName;
    private double mPrice;

    public MenuItem(String name, double price) {
        mName = name;
        mPrice = price;
    }

    @Override
    public void print() {
        System.out.println("   " + mName + ", $" + mPrice);
    }

}
```

Create the menu also as a component...

```java
public class Menu extends MenuComponent {

    private final List<MenuComponent> mComponents = new ArrayList<>();

    @Override
    public void add(MenuComponent component) {
        mComponents.add(component);
    }

    @Override
    public void remove(MenuComponent component) {
        mComponents.remove(component);
    }

    @Override
    public MenuComponent getChild(int i) {
        return mComponents.get(i);
    }

    @Override
    public void print() {
        for (MenuComponent component : mComponents) {
            component.print();
        }
    }

}
```

Create the dinner menu and the desert menu and combine them...


```java
MenuComponent dinnerMenu = new Menu("Dinner Menu");
dinnerMenu.add(new MenuItem("Fillet Steak", 20.99));
dinnerMenu.add(new MenuItem("New York Steak", 15.99));

MenuComponent dessertMenu = new Menu("Dessert Menu");
dessertMenu.add(new MenuItem("Apple Pie", 1.59));
dessertMenu.add(new MenuItem("Ice Cream", 2.59));

MenuComponent allMenu = new Menu("All Menus");
allMenu.add(dinnerMenu);
dinnerMenu.add(dessertMenu);
allMenu.print();
```

## :traffic_light: State
Define and control a set of states inside an object. Alter its behavior when its internal state changes.

### Example
A candy company design a gum ball machine. To let the machine work properly, the designer implement a set of state controller inside it. When receiving a new requst, the machine will change its internal state to fullfill the request and move on to the next state.

```java
public interface State {

    void insertQuarter();

    void ejectQuarter();

    void turnCrank();

    void dispense();

}
```

Create NoQuarter state, HasQuarter state, and Sold state...

```java
public class NoQuarterState implements State {

    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter!");
        mMachine.setState(mMachine.mHasQuarterState);
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter!");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there is no quarter!");
    }

    @Override
    public void dispense() {
        System.out.println("You need to pay a quarter fist!");
    }

}

public class HasQuarterState implements State {

    @Override
    public void insertQuarter() {
        System.out.println("You cannot inserted another quarter!");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Quarter return!");
        mMachine.setState(mMachine.mNoQuarterState);
    }

    @Override
    public void turnCrank() {
        System.out.println("You turn...");
        mMachine.setState(mMachine.mSoldState);
    }

    @Override
    public void dispense() {
        System.out.println("No gumball dispense!");
    }

}

public class SoldState implements State {

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we are already giving you a gumball!");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turn the crank!");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice does not get you another gumball!");
    }

    @Override
    public void dispense() {
        mMachine.releaseBall();
        if (mMachine.getCount() > 0) {
            mMachine.setState(mMachine.mNoQuarterState);
        } else {
            System.out.println("Oops, out of gumball!");
        }
    }

}
```

Create the gum ball machine and implement the internal state...

```java
public class GumBallMachine {

    public final State mSoldOutState;
    public final State mNoQuarterState;
    public final State mHasQuarterState;

    private State mState;
    private int mCount;

    public GumBallMachine(int initCount) {
        mSoldOutState = new SoldOutState(this);
        mNoQuarterState = new NoQuarterState(this);
        mHasQuarterState = new HasQuarterState(this);

        mCount = initCount;
        mState = mNoQuarterState;
    }

    public int getCount() {
        return mCount;
    }

    public void setState(State state) {
        mState = state;
    }

    public void insertQuarter() {
        mState.insertQuarter();
    }

    public void ejectQuarter() {
        mState.ejectQuarter();
    }

    public void turnCrank() {
        mState.turnCrank();
        mState.dispense();
    }

    public void releaseBall() {
        System.out.println("A gumball rolling out the slot...");
        if (mCount > 0) {
            mCount--;
        }
    }

}
```

Insert a quarter and turn...

```java
GumBallMachine machine = new GumBallMachine(2);
machine.insertQuarter();
machine.turnCrank();
```
