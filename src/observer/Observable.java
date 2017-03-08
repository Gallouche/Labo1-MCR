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
     * Desciption: calls update on every subscribed object as an observer.
     */
    public void notifyObservers() {
        for(Observer o : observers){
            o.update();
        }
    }

    /**
     * Description: add a new observer if it's not already in the list.
     * @param o the new observer you want to add in the list.
     */
    public void addObserver(Observer o){

        if (!observers.contains(o))
            observers.add(o);
    }

    /**
     * Description: delete an observer from the list if it's in the list.
     * @param o the observer you want to delete from the list.
     */
    public void deleteObserver(Observer o){

        if(observers.contains(o))
            observers.remove(o);
    }

}
