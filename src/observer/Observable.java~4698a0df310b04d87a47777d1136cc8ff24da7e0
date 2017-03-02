package observer;

import java.util.LinkedList;

/**
 * Created by Gallouche on 24/02/2017.
 */
public abstract class Observable {

    private LinkedList<Observer> observers;

    public Observable() {

        observers = new LinkedList<Observer>();
    }

    public void notifiyObservers() {
        for(Observer o : observers){
            o.update();
        }
    }

    //Test for unsubscribtion when closing windows --------------------------------------------------------------------- DELETE WHEN FINISHED
    public int getNumberSubscribers() { return observers.size(); }

    public void addObserver(Observer o){
        observers.add(o);
    }

    public void deleteObserver(Observer o){
        observers.remove(o);
    }

}
