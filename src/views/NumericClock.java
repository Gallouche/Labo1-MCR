package views;

import javax.swing.*;
import java.awt.*;

import timer.TimerChrono;

/**
 * Created by pierre-samuelrochat on 24.02.17.
 */
public class NumericClock extends Clock {

    private JLabel timerLabel;

    public NumericClock(TimerChrono timer){

        super(timer, "Numeric Clock");

        setPreferredSize(new Dimension(200, 30));

        timerLabel = new JLabel("");
        add(timerLabel);
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        timerLabel.setText(timer.getHours() + "h " + timer.getMinutes() + "m " + timer.getSeconds() + "s");
    }

}
