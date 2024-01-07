package facade.device;

public class Projector {

    private String mName;

    public Projector(String name) {
        mName = name;
    }

    public void on() {
        System.out.println(mName + " projector is on");
    }

    public void play(String movie) {
        System.out.println("Play movie: " + movie);
    }

    public void off() {
        System.out.println(mName + " projector is off");
    }

}
