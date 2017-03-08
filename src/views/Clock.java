package views;

import observer.Observer;
import timer.TimerChrono;

import javax.swing.*;

/**
 * File: Clock.java
 * Created by Rochat P-S. & Gallandat T.
 * Date: 09/03/2017
 * Description: implement the class Clock who represent a generic panel for each type of clock. It extends Observer and
 *              will observe a TimerChrono object.
 */
abstract class Clock extends JPanel implements Observer {

    protected TimerChrono timer;
    private final String name;

    /**
     * Description: Create and add the clock to the timer's observers list.
     * @param timer timer to observe.
     * @param name name of the clock.
     */
    public Clock(TimerChrono timer, String name) {
        this.timer = timer;
        this.name = name;
        timer.addObserver(this);
    }

    /**
     * Description: override of the update method from Observer Interface.
     *              it will update the timer graphic representation by repainting it.
     */
    @Override
    public void update(){
        repaint();
    }

    /**
     * Description: get the name of the panel
     * @return String name
     */
    public String getPanelName() { return name; }
}
