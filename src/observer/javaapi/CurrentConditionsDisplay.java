package observer.javaapi;

import observer.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * java内置的观察者接口，要实现update方法
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private  float temperature;
    private float humidity;
    private Observable weatherData;

    public CurrentConditionsDisplay(Observable weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }


    @Override
    public void display() {
        System.out.println("current conditions:" + temperature+"F degree and "+humidity);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }

    }
}
