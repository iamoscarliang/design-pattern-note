package builder;

public interface Builder {

    Builder setDate(String date);

    Builder setHotel(String hotel);

    Builder addEvent(String event);

    Vacation build();

}
