import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by Gallouche on 24/02/2017.
 */
public abstract class Observable {

    private LinkedList<Observer> observers;

    public Observable(){
        observers = new LinkedList<Observer>();
    }

    public void notifier(){
        for(Observer o : observers){
            o.update();
        }
    }

    public void addObserver(Observer o){
        observers.add(o);
    }

    public void deleteObserver(Observer o){
        observers.remove(o);
    }

    public void deleteObserver(){
        observers.clear();
    }

}
