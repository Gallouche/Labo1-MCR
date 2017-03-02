package timer;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import observer.Observable;

/**
 * Created by Gallouche on 24/02/2017.
 */
public class TimerChrono extends Observable {

    private Timer timer;

    private int counter;

    private int seconds;
    private int minutes;
    private int hours;

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

    public void start(){
        timer.start();
    }

    public void stop(){ timer.stop(); }

    public void reset(){

        counter = 0;
        seconds = 0;
        minutes = 0;
        hours   = 0;

        notifiyObservers();
    }

    public int getSeconds() { return seconds; }

    public int getMinutes() { return minutes; }

    public int getHours() { return hours; }
}
