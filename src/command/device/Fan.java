package command.device;

public class Fan {

    public static final int OFF = 0;
    public static final int LOW = 1;
    public static final int MEDIUM = 2;
    public static final int HIGH = 3;

    public String mName;
    private int mSpeed = OFF;

    public Fan(String name) {
        mName = name;
    }

    public void off() {
        mSpeed = OFF;
        System.out.println(mName + " fan is off");
    }

    public void low() {
        mSpeed = LOW;
        System.out.println(mName + " fan is on low");
    }

    public void medium() {
        mSpeed = MEDIUM;
        System.out.println(mName + " fan is on medium");
    }

    public void high() {
        mSpeed = HIGH;
        System.out.println(mName + " fan is on high");
    }

    public int getSpeed() {
        return mSpeed;
    }

}
