package command.device;

public class Light {

    private String mName;

    public Light(String name) {
        mName = name;
    }

    public void on() {
        System.out.println(mName + " light is on");
    }

    public void off() {
        System.out.println(mName + " light is off");
    }

}
