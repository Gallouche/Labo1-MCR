package views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pierre-samuelrochat on 23.02.17.
 */
public class ArabicClock extends Clock {

    private JPanel p1;

    public ArabicClock(JFrame f){

        p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        f.add(p1);
    }
}
