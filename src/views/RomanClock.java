package views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by pierre-samuelrochat on 24.02.17.
 */
public class RomanClock {
    private JPanel p1;

    public RomanClock(JFrame f){

        p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        f.add(p1);
    }
}
