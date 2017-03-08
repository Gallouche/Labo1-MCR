package views;

import javax.swing.*;
import java.awt.*;

import timer.TimerChrono;

/**
 * File: NumericClock.java
 * Created by Rochat P-S. & Gallandat T.
 * Date: 09/03/2017
 * Description: Implement the class NumericClock which is a specific type of clock that display the timer in a numeric
 *              way.
 */
public class NumericClock extends Clock {

    private JLabel timerLabel;

    /**
     * Description: create a numeric clock and create a new JLabel to display the timer.
     * @param timer
     */
    public NumericClock(TimerChrono timer){

        super(timer, "Numeric Clock");

        setPreferredSize(new Dimension(200, 30));

        timerLabel = new JLabel("");
        add(timerLabel);
    }

    /**
     * Description: override the paint method by calling the super method and set the text from the JLabel at the
     *              correct time.
     * @param g the Graphics object
     */
    @Override
    public void paint(Graphics g) {

        super.paint(g);
        timerLabel.setText(timer.getHours() + "h " + timer.getMinutes() + "m " + timer.getSeconds() + "s");
    }

}
