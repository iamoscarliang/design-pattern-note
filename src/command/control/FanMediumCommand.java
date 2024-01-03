package command.control;

import command.device.Fan;

public class FanMediumCommand implements Command {

    private Fan mFan;
    private int mPreviousSpeed;

    public FanMediumCommand(Fan fan) {
        mFan = fan;
    }

    @Override
    public void execute() {
        mPreviousSpeed = mFan.getSpeed();
        mFan.medium();
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
