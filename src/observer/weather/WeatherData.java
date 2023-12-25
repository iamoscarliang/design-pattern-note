package observer.weather;


import observer.interfaces.Observable;
import observer.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Observable {

    private float mTemp;
    private float mHumidity;
    private float mPressure;

    private final List<Observer> mObservers = new ArrayList<>();

    public void setMeasurements(float temp, float humidity, float pressure) {
        mTemp = temp;
        mHumidity = humidity;
        mPressure = pressure;
        notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        mObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        mObservers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : mObservers) {
            observer.update(mTemp, mHumidity, mPressure);
        }
    }

}
