package mediator.device;

import mediator.Device;
import mediator.Event;

public class Calendar extends Device {

    private String mDate;

    public Calendar(String date) {
        mDate = date;
    }

    @Override
    public void onEvent(Event event) {
        if (event == Event.CHECK_CALENDER) {
            if (mDate.equals("Saturday") || mDate.equals("Sunday")) {
                mMediator.sendEvent(Event.WEEKEND);
            } else {
                mMediator.sendEvent(Event.WORKDAY);
            }
        }
    }

}
