package Observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverTest {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        subject.add(new ConcreteObserverOne());
        subject.add(new ConcreteObserverTwo());
        subject.notifyObserver();
    }
}

//抽象主题
abstract class Subject{
    protected List<Observer> observerList = new ArrayList<Observer>();

    public void add(Observer observer){
        observerList.add(observer);
    }

    public void remove(Observer observer){
        observerList.remove(observer);
    }

    public abstract void notifyObserver();//通知观察者

}

class ConcreteSubject extends Subject{

    public void notifyObserver() {
        System.out.println("目标发生变化");

        for (Object object : observerList) {
            ((Observer) object).response();
        }
    }
}

//抽象观察者
interface Observer{
    void response();
}

class ConcreteObserverOne implements Observer{
    public void response() {
        System.out.println("observer one accept");
    }
}


class ConcreteObserverTwo implements Observer{
    public void response() {
        System.out.println("observer two accept");
    }
}
