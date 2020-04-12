package observer;


import java.util.ArrayList;

/**
 * 主题实现者
 */
public class WeatherData implements Subject {
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    public WeatherData() {
        observers =new ArrayList<Observer>();
    }
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);

    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(observers.contains(o)) {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for(Observer item: observers) {
            item.update(temperature, humidity, pressure);
        }
    }
    /** 每当值发生变化时，通知观察者*/
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measuremnentsChanges();
    }

    private void measuremnentsChanges() {
        notifyObserver();
    }
}
