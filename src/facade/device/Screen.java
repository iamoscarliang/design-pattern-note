package facade.device;

public class Screen {

    private String mName;

    public Screen(String name) {
        mName = name;
    }

    public void up() {
        System.out.println(mName + " screen going up");
    }

    public void down() {
        System.out.println(mName + " screen going down");
    }

}
