package observer;

import java.util.LinkedList;

/**
 * File: Observable.java
 * Created by Rochat P-S. & Gallandat T.
 * Date: 09/03/2017
 * Description: Implementation of an personal Observable class.
 */
public abstract class Observable {

    private LinkedList<Observer> observers;

    public Observable() {

        observers = new LinkedList<Observer>();
    }

    /**
     * Desciption: method who take all observers of this Observable object and call the method update for each.
     */
    public void notifiyObservers() {
        for(Observer o : observers){
            o.update();
        }
    }

    /**
     *
     * @param o the new observer you want to add in the list.
     */
    public void addObserver(Observer o){
        observers.add(o);
    }

    /**
     *
     * @param o the observer you want to delete from the list.
     */
    public void deleteObserver(Observer o){
        observers.remove(o);
    }

}
