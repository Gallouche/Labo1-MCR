package views;

import observer.Observer;
import timer.TimerChrono;

import javax.swing.*;

/**
 * Created by pierre-samuelrochat on 23.02.17.
 */
abstract class Clock extends JPanel implements Observer {

    protected TimerChrono timer;
    private final String name;

    public Clock(TimerChrono timer, String name) {
        this.timer = timer;
        this.name = name;
        timer.addObserver(this);
    }

    @Override
    public void update(){
        repaint();
    }

    public String getPanelName() { return name; }
}
