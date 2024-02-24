package bridge.tv;

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
