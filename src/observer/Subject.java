package observer;

/**
 * 主题接口，注册观察者、通知观察者等方法
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver();
}
