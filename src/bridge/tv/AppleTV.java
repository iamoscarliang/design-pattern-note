package bridge.tv;

public class AppleTV implements TV {

    @Override
    public void on() {
        System.out.println("Turn on Apple TV!");
    }

    @Override
    public void off() {
        System.out.println("Turn off Apple TV!");
    }

    @Override
    public void turnChannel(int channel) {
        System.out.println("Turn Apple TV channel to " + channel + "!");
    }

}
