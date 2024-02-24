package bridge.tv;

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
