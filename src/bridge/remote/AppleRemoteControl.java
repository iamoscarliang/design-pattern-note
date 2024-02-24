package bridge.remote;

public class AppleRemoteControl extends RemoteControl {

    private int mPreviousChannel;

    @Override
    public void setChannel(int channel) {
        mPreviousChannel = mCurrentChannel;
        super.setChannel(channel);
    }

    public void undoChannel() {
        setChannel(mPreviousChannel);
    }

}
