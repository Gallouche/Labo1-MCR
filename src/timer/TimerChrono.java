package timer;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import observer.Observable;

/**
 * File: TimerChrono.java
 * Created by Rochat P-S. & Gallandat T.
 * Date: 09/03/2017
 * Description: Implementation of the class TimerChrono as an Observable.
 */
public class TimerChrono extends Observable {

    private Timer timer;

    private int counter;

    private int seconds;
    private int minutes;
    private int hours;

    /**
     * Description: constructor of the TimerChrono class. Create a new timer and redefine the
     *              actionPerformed method.
     */
    public TimerChrono(){

        counter = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;

        // Creates a new timer that increments the counter every second, recalculates the other variables
        // and notify the observers
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                counter++;
                seconds = counter % 60;
                minutes = (counter / 60) % 60;
                hours   = (counter / 3600) % 12;

                notifyObservers();
            }
        });
    }

    /**
     * Description: start the timer.
     */
    public void start(){
        timer.start();
    }

    /**
     * Description: stop the timer.
     */
    public void stop(){
        timer.stop();
    }

    /**
     * Description: reset the timer and notify the observers.
     */
    public void reset(){

        counter = 0;
        seconds = 0;
        minutes = 0;
        hours   = 0;

        notifyObservers();
    }

    /**
     * Description: get the seconds elapsed.
     * @return seconds
     */
    public int getSeconds() { return seconds; }

    /**
     * Description: get the minutes elapsed.
     * @return minutes
     */
    public int getMinutes() { return minutes; }

    /**
     * Description: get the hours elapsed.
     * @return hours
     */
    public int getHours() { return hours; }

    /**
     * Description: swtiche the state of the timer:
     *              - if the timer is running, the timer will stop.
     *              - if the timer is not running, the timer will start.
     */
    public void switchState() {
        if(timer.isRunning()) {
            timer.stop();
        } else  {
            timer.start();
        }
    }
}
