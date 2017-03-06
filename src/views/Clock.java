package views;

import observer.Observer;
import timer.TimerChrono;

import javax.swing.*;

/**
 * File: Clock.java
 * Created by Rochat P-S. & Gallandat T.
 * Date: 09/03/2017
 * Description: implement the class Clock who represent a generic panel for each type of clock. It extends Observer and
 *              will look at TimerChrono.
 */
abstract class Clock extends JPanel implements Observer {

    protected TimerChrono timer;
    private final String name;

    /**
     * Description: Create and add the clock to the timer observers list.
     * @param timer timer to observe
     * @param name name of the clock
     */
    public Clock(TimerChrono timer, String name) {
        this.timer = timer;
        this.name = name;
        timer.addObserver(this);
    }

    /**
     * Description: override of the method update from Observer by calling the method repaint for a component.
     *              it will do the change on the needles or in the digit of the numeric clock.
     */
    @Override
    public void update(){
        repaint();
    }

    /**
     * Description: getter on the name of the panel
     * @return String name
     */
    public String getPanelName() { return name; }
}
