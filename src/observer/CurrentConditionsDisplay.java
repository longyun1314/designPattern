package observer;

/**
 * 目前状况看板
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private  float temperature;
    private float humidity;
    private Subject weatherData;
    /**
    将观察者注册到主题上
     */
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }


    @Override
    public void display() {
        System.out.println("current conditions:" + temperature+"F degree and "+humidity);
    }

    /**
     * 通知观察者被调用方法
     * @param temperature 问题
     * @param humidity 湿度
     * @param presure 压力
     */
    @Override
    public void update(float temperature, float humidity, float presure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();

    }
}
