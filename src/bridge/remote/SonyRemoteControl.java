package bridge.remote;

public class SonyRemoteControl extends RemoteControl {

    public void nextChannel() {
        setChannel(mCurrentChannel + 1);
    }

    public void previousChannel() {
        setChannel(mCurrentChannel - 1);
    }

}
