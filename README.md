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
- :bridge_at_night: [Bridge](#bridge)
- :hammer: [Builder](#builder)
- :link: [Chain of responsibility](#chain-of-responsibility)
- :money_with_wings: [Flyweight](#flyweight)
- :bus: [Mediator](#mediator)

## :dart: Strategy
Define a set of algorithms and let the object dynamically change the behavior by choosing from multiple algorithms at runtime.

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

Create weapons...

```java
public class SwordBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("Swinging a sword!");
    }

}

public class ArrowBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("Shooting an arrow!");
    }

}
```

Create a king character and set weapons to it...

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

## :bridge_at_night: Bridge
Separate the system into abstraction and implementation, and develop independently of each other.

### Example
In a TV manufacturer, the engineers want to design a remote control interface that can highly integrate with the TV of different models.

```java
public interface TV {

    void on();

    void off();

    void turnChannel(int channel);

}

public abstract class RemoteControl {

    protected TV mTV;
    protected int mCurrentChannel = 0;

    public void setTV(TV tv) {
        mTV = tv;
    }

    public void setChannel(int channel) {
        mCurrentChannel = channel;
        mTV.turnChannel(channel);
    }

    public void on() {
        mTV.on();
    }

    public void off() {
        mTV.off();
    }

}
```

The compony has two types of TV...

```java
public class SonyLCDTV implements TV {

    @Override
    public void on() {
        System.out.println("Turn on Sony LCD TV!");
    }

    @Override
    public void off() {
        System.out.println("Turn off Sony LCD TV!");
    }

    @Override
    public void turnChannel(int channel) {
        System.out.println("Turn Sony LCD TV channel to " + channel + "!");
    }

}

public class SonyLEDTV implements TV {

    @Override
    public void on() {
        System.out.println("Turn on Sony LED TV!");
    }

    @Override
    public void off() {
        System.out.println("Turn off Sony LED TV!");
    }

    @Override
    public void turnChannel(int channel) {
        System.out.println("Turn Sony LED TV channel to " + channel + "!");
    }

}
```

Create a remote control that can handle both types of TV...

```java
public class SonyRemoteControl extends RemoteControl {

    public void nextChannel() {
        setChannel(mCurrentChannel + 1);
    }

    public void previousChannel() {
        setChannel(mCurrentChannel - 1);
    }

}
```

Create the TVs and the remote control...

```java
TV sonyLCDTV = new SonyLCDTV();
TV sonyLEDTV = new SonyLEDTV();

SonyRemoteControl sonyLCDTVRemoteControl = new SonyRemoteControl();
sonyLCDTVRemoteControl.setTV(sonyLCDTV);

SonyRemoteControl sonyLEDTVRemoteControl = new SonyRemoteControl();
 sonyLEDTVRemoteControl.setTV(sonyLEDTV);

sonyLCDTVRemoteControl.setChannel(30);
sonyLEDTVRemoteControl.setChannel(20);
sonyLEDTVRemoteControl.nextChannel();
```

## :hammer: Builder
Building the structure of a complex object step by step.

### Example
In a tourism company, the manager needs a vacation planning system to easily arrange activities during the vacation for their client.

```java
public class Vacation {

    private String mDate;
    private String mHotel;

    private final List<String> mEvents = new ArrayList<>();

    public void setDate(String date) {
        mDate = date;
    }

    public void setHotel(String hotel) {
        mHotel = hotel;
    }

    public void addEvent(String event) {
        mEvents.add(event);
    }

}

public interface Builder {

    Builder setDate(String date);

    Builder setHotel(String hotel);

    Builder addEvent(String event);

    Vacation build();

}
```
Create a vacation planning builder...

```java
public class VacationBuilder implements Builder {

    private Vacation mVacation;

    public VacationBuilder() {
        mVacation = new Vacation();
    }

    @Override
    public Builder setDate(String date) {
        mVacation.setDate(date);
        return this;
    }

    @Override
    public Builder setHotel(String hotel) {
        mVacation.setHotel(hotel);
        return this;
    }

    @Override
    public Builder addEvent(String event) {
        mVacation.addEvent(event);
        return this;
    }

    @Override
    public Vacation build() {
        return mVacation;
    }

}
```

Create a vacation with the builder...

```java
Vacation vacation = new VacationBuilder()
                .setDate("May 1")
                .setHotel("Awesome Hotel")
                .addEvent("Learn Java")
                .addEvent("Learn Design Pattern")
                .build();
```

## :link: Chain of responsibility
Define a chain of handlers, when each handler receives a request, either to process the request or to pass it to the next handler in the chain.

### Example
The community department recently received a lot of emails from the customer. They want to classify all the emails and send the email to the department that can handle them.

```java
public abstract class Handler {

    protected Handler mSuccessor;

    public abstract void handlerRequest(String email);

    public Handler getSuccessor() {
        return mSuccessor;
    }

    public void setSuccessor(Handler handler) {
        mSuccessor = handler;
    }

}
```

Create email handlers to classify spam emails, fans emails, and complaint emails...

```java
public class SpamHandler extends Handler {

    @Override
    public void handlerRequest(String email) {
        if (email.contains("spam")) {
            System.out.println("Delete spam email!");
        } else {
            if (mSuccessor != null) {
                mSuccessor.handlerRequest(email);
            } else {
                System.out.println("Put email to pending email file!");
            }
        }
    }

}

public class FansHandler extends Handler {

    @Override
    public void handlerRequest(String email) {
        if (email.contains("fans")) {
            System.out.println("Send fans email to manager!");
        } else {
            if (mSuccessor != null) {
                mSuccessor.handlerRequest(email);
            } else {
                System.out.println("Put email to pending email file!");
            }
        }
    }

}

public class ComplaintHandler extends Handler {

    @Override
    public void handlerRequest(String email) {
        if (email.contains("complaint")) {
            System.out.println("Send complaint email to legal department!");
        } else {
            if (mSuccessor != null) {
                mSuccessor.handlerRequest(email);
            } else {
                System.out.println("Put email to pending email file!");
            }
        }
    }

}
```

Handler some email send by the customer...

```java
Handler spamHandler = new SpamHandler();
Handler fansHandler = new FansHandler();
Handler complaintHandler = new ComplaintHandler();

spamHandler.setSuccessor(fansHandler);
fansHandler.setSuccessor(complaintHandler);

spamHandler.handlerRequest("This is a spam email");
spamHandler.handlerRequest("This is a fans email");
spamHandler.handlerRequest("This is a complaint email");
```

## :money_with_wings: Flyweight
Reduce the number of objects created and decrease memory being used by sharing common parts of components between multiple objects.

### Example
In an adventure game, the engineers want to design a forest system that contains thousands of trees, each with different colors of leaves. But they find out that as the number of trees getting larger and larger, the computer will quickly run out of memory, since there are too many leaves on the screen, so they need to implement them in an efficient way.

```java
public class Tree {

    private float mX;
    private float mY;

    private final List<Leaf> mLeaves = new ArrayList<>();

    public Tree(float x, float y) {
        mX = x;
        mY = y;
    }

    public void addLeaf(Leaf leaf) {
        mLeaves.add(leaf);
    }

    public void display() {
        System.out.println("Display a tree at (" + mX + ", " + mY + "), with " + mLeaves);
    }

}

public class Leaf {

    private String mColor;

    public Leaf(String color) {
        mColor = color;
    }

    @Override
    public String toString() {
        return mColor + " leaf";
    }

}
```

Create a leaf factory to reuse the same type of leaf...

```java
public class LeafFactory {

    private final Map<String, Leaf> mLeaves = new HashMap<>();

    public Leaf createLeaf(String color) {
        if (mLeaves.containsKey(color)) {
            return mLeaves.get(color);
        } else {
            Leaf leaf = new Leaf(color);
            mLeaves.put(color, leaf);
            return leaf;
        }
    }

}
```

Create the trees with the leaf factory...

```java
LeafFactory factory = new LeafFactory();

Tree greenTree = new Tree(100, 100);
for (int i = 0; i < 3; i++) {
    greenTree.addLeaf(factory.createLeaf("green"));
    greenTree.addLeaf(factory.createLeaf("dark green"));
}

Tree yellowTree = new Tree(200, 300);
for (int i = 0; i < 4; i++) {
    yellowTree.addLeaf(factory.createLeaf("yellow"));
    yellowTree.addLeaf(factory.createLeaf("orange"));
}

greenTree.display();
yellowTree.display();
```

## :bus: Mediator
Redirect the communications between objects via a mediator to decouple them in a loose structure.

### Example
In a house management system, when the alarm is turned off, the system will reboot and check the date. If it's a workday, then turn on the coffee machine and make a cup of coffee. If it's the weekend, then turn on the sprinkler and watering the garden.

```java
public interface DeviceMediator {

    void sendEvent(Event event);

}

public abstract class Device {

    protected DeviceMediator mMediator;

    public void setMediator(DeviceMediator mediator) {
        mMediator = mediator;
    }

    public abstract void onEvent(Event event);

}
```

Create the event...

```java
public enum Event {
    STOP_ALARM,
    TURN_ON_SYSTEM,
    MAKE_COFFEE,
    WATERING_GARDEN,
    CHECK_CALENDER,
    WORKDAY,
    WEEKEND
}
```

Create the device...

```java
public class Alarm extends Device {

    @Override
    public void onEvent(Event event) {
        if (event == Event.STOP_ALARM) {
            System.out.println("Alarm stopped!");
            mMediator.sendEvent(Event.TURN_ON_SYSTEM);
        }
    }

}

public class CoffeeMachine extends Device {

    @Override
    public void onEvent(Event event) {
        if (event == Event.MAKE_COFFEE) {
            System.out.println("Make a cup of coffee!");
        }
    }

}

public class Sprinkler extends Device {

    @Override
    public void onEvent(Event event) {
        if (event == Event.WATERING_GARDEN) {
            System.out.println("Watering the garden!");
        }
    }

}

public class Calendar extends Device {

    private String mDate;

    public Calendar(String date) {
        mDate = date;
    }

    @Override
    public void onEvent(Event event) {
        if (event == Event.CHECK_CALENDER) {
            if (mDate.equals("Saturday") || mDate.equals("Sunday")) {
                mMediator.sendEvent(Event.WEEKEND);
            } else {
                mMediator.sendEvent(Event.WORKDAY);
            }
        }
    }

}
```

Create the device controller

```java
public class DeviceController implements DeviceMediator {

    private Device mAlarm;
    private Device mCoffeeMachine;
    private Device mSprinkler;
    private Device mCalendar;

    public DeviceController(Device alarm, Device coffeeMachine, Device sprinkler, Device calendar) {
        mAlarm = alarm;
        mCoffeeMachine = coffeeMachine;
        mSprinkler = sprinkler;
        mCalendar = calendar;
    }

    @Override
    public void sendEvent(Event event) {
        switch (event) {
            case TURN_ON_SYSTEM:
                mCalendar.onEvent(Event.CHECK_CALENDER);
                break;
            case WORKDAY:
                mCoffeeMachine.onEvent(Event.MAKE_COFFEE);
                break;
            case WEEKEND:
                mSprinkler.onEvent(Event.WATERING_GARDEN);
                break;
        }
    }

}
```

Test the system...

```java
Device alarm = new Alarm();
Device coffeeMachine = new CoffeeMachine();
Device sprinkler = new Sprinkler();
Device calendar = new Calendar("Monday");

DeviceMediator mediator = new DeviceController(alarm, coffeeMachine, sprinkler, calendar);

alarm.setMediator(mediator);
coffeeMachine.setMediator(mediator);
sprinkler.setMediator(mediator);
calendar.setMediator(mediator);

System.out.println("Alarm started!");
alarm.onEvent(Event.STOP_ALARM);
```





