package timer;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import observer.Observable;

/**
 * File: TimerChrono.java
 * Created by Rochat P-S. & Gallandat T.
 * Date: 09/03/2017
 * Description: Implementation of the class TimerChrono as an observable. All the clock will look at him and react
 *              from his call at notify() method to modify their state and update their timer.
 */
public class TimerChrono extends Observable {

    private Timer timer;

    private int counter;

    private int seconds;
    private int minutes;
    private int hours;

    /**
     * Description: constructor of the TimerChrono class. Create a new timer and redefine the
     *              actionPerformed method to match with our implementation. Here the actionPerformed count each "tic"
     *              and store them by seconds, minutes and hours elapse.
     */
    public TimerChrono(){

        counter = 0;
        seconds = 0;
        minutes = 0;
        hours = 0;

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                counter++;
                seconds = counter % 60;
                minutes = (counter / 60) % 60;
                hours   = (counter / 3600) % 12;

                notifiyObservers();
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

        notifiyObservers();
    }

    /**
     * Description: getter on seconds elapse in the current minute.
     * @return seconds in int.
     */
    public int getSeconds() { return seconds; }

    /**
     * Description: getter on minutes elapse in the current hour.
     * @return minutes in int.
     */
    public int getMinutes() { return minutes; }

    /**
     * Description: getter on hours elpase in the current timer.
     * @return hours in int.
     */
    public int getHours() { return hours; }

    /**
     * Description: method to swtich the state of the timer:
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
