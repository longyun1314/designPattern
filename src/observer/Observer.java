package observer;

/**
 * 观察者接口
 * 只有更新方法
 */
public interface Observer {
    public void update(float temp, float humidity, float presure);
}
