package views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pierre-samuelrochat on 24.02.17.
 */
public class NumericClock extends Clock {

    protected JPanel p1;
    protected JLabel imageLabel;

    public NumericClock(JFrame f){

        p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p1.add(new JLabel("Timer"));
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(p1);
        validate();
    }
}
