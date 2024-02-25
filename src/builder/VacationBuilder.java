package builder;

public class VacationBuilder implements Builder {

    private Vacation mVacation;

    public VacationBuilder() {
        mVacation = new Vacation();
    }

    @Override
    public Builder setDate(String date) {
        mVacation.setDate(date);
        return this;
    }

    @Override
    public Builder setHotel(String hotel) {
        mVacation.setHotel(hotel);
        return this;
    }

    @Override
    public Builder addEvent(String event) {
        mVacation.addEvent(event);
        return this;
    }

    @Override
    public Vacation build() {
        return mVacation;
    }

}
