package builder;

import java.util.ArrayList;
import java.util.List;

public class Vacation {

    private String mDate;
    private String mHotel;

    private final List<String> mEvents = new ArrayList<>();

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getHotel() {
        return mHotel;
    }

    public void setHotel(String hotel) {
        mHotel = hotel;
    }

    public List<String> getEvents() {
        return mEvents;
    }

    public void addEvent(String event) {
        mEvents.add(event);
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "mDate='" + mDate + '\'' +
                ", mHotel='" + mHotel + '\'' +
                ", mEvents=" + mEvents +
                '}';
    }

}
