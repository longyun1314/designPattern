package observer.javaapi;

import observer.DisplayElement;
import observer.Subject;

import java.util.*;

public class StatisticsDisplay implements Observer, DisplayElement {
    private List<Float> temperature = new ArrayList<Float>();
    private Observable weatherData;

    public StatisticsDisplay(Observable weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }
    public Float min() {
        temperature.sort(new Comparator<Float>() {
            @Override
            public int compare(Float o1, Float o2) {
                return o1.compareTo(o2);
                // return o1 > o2 ? 1 : (o1.equals(o2)) ? 0 : -1);
            }
        });
        return temperature.get(0);
    }
    public Float max() {
        temperature.sort(new Comparator<Float>() {
            @Override
            public int compare(Float o1, Float o2) {
                return o2.compareTo(o1);
                // return o1 > o2 ? 1 : (o1.equals(o2)) ? 0 : -1);
            }
        });
        return temperature.get(0);
    }
    public Float average() {
        float sum = 0;
        int len = temperature.size();
        for(Float f : temperature) {
            sum+=f;
        }
        return sum/len;

    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature" +average()+" "+ max() +" "+ min());
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("arg:"+arg);
        if(o instanceof WeatherData) {
            WeatherData weatherData =(WeatherData) o;
            temperature.add(weatherData.getTemperature());
            display();
        }
    }
}
