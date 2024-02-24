package bridge.remote;

import bridge.tv.TV;

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
