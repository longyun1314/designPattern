package observer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
/**
 * 统计看板
 */
public class StatisticsDisplay implements Observer, DisplayElement {
    private List<Float> temperature = new ArrayList<Float>();
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
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
    public void update(float temp, float humidity, float presure) {
        temperature.add(temp);
        display();

    }
}
