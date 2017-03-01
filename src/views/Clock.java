package views;

import observer.Observer;
import timer.TimerChrono;

import javax.swing.*;

/**
 * Created by pierre-samuelrochat on 23.02.17.
 */
abstract class Clock extends JPanel implements Observer {

    protected TimerChrono timer;

    public Clock(TimerChrono timer) {
        this.timer = timer;
        timer.addObserver(this);
    }

    @Override
    public void update(){
        repaint();
    }
}
