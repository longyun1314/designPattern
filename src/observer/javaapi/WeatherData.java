package observer.javaapi;


import java.util.Observable;

/**
 * java内置的可观察类，
 */
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measuremnentsChanges();
    }
    private void measuremnentsChanges() {
        // 标记状态已经改变的事实
        setChanged();
        // 通知观察者
        notifyObservers();
    }
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }


}
