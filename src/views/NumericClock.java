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

        super(timer);

        timerLabel = new JLabel("");

        setPreferredSize(new Dimension(150, 30));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(timerLabel);
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        timerLabel.setText(timer.getHours() + "h " + timer.getMinutes() + "m " + timer.getSeconds() + "s");
    }

}
