package com.designpattern.observer.weather;

import com.designpattern.observer.interfaces.Observer;

public class StatisticsDisplay implements Observer {

    private float mMax = Float.NEGATIVE_INFINITY;
    private float mMin = Float.POSITIVE_INFINITY;
    private float mAvg = 0;
    private int mDataCount = 0;

    @Override
    public void update(float temp, float humidity, float pressure) {

        if (temp > mMax) {
            mMax = temp;
        }

        if (temp < mMin) {
            mMin = temp;
        }

        mAvg = (mAvg * mDataCount++ + temp) / mDataCount;

        System.out.println("Avg/Max/Min temperature: " + mAvg + "/" + mMax + "/" + mMin);
    }

}
