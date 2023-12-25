package observer;

import observer.weather.CurrentConditionDisplay;
import observer.weather.StatisticsDisplay;
import observer.weather.WeatherData;

public class Main {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        weatherData.registerObserver(new CurrentConditionDisplay());
        weatherData.registerObserver(new StatisticsDisplay());

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }

}
