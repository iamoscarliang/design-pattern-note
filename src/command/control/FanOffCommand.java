package command.control;

import command.device.Fan;

public class FanOffCommand implements Command {

    private Fan mFan;
    private int mPreviousSpeed;

    public FanOffCommand(Fan fan) {
        mFan = fan;
    }

    @Override
    public void execute() {
        mPreviousSpeed = mFan.getSpeed();
        mFan.off();
    }

    @Override
    public void undo() {
        switch (mPreviousSpeed) {
            case Fan.OFF:
                mFan.off();
                break;
            case Fan.LOW:
                mFan.low();
                break;
            case Fan.MEDIUM:
                mFan.medium();
                break;
            case Fan.HIGH:
                mFan.high();
                break;
        }
    }

}
