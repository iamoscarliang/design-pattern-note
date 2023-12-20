package com.designpattern.observer.weather;

import com.designpattern.observer.interfaces.Observer;

public class CurrentConditionDisplay implements Observer {

    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("Current conditions: "
                + temp + " degree and "
                + humidity + "% humidity and "
                + pressure + " pressure");
    }

}
