/*
package views;

import javax.swing.*;
import java.awt.*;

*/
/**
 * Created by pierre-samuelrochat on 24.02.17.
 *//*


public class MixedClock extends Clock {

    private AnalogClock arabicClock;
    private AnalogClock romanClock;
    private NumericClock numericClock;
    private int minDimension;

    public MixedClock(String fileName1, String fileName2, JFrame f){

        Dimension d = f.getPreferredSize();
        minDimension = d.width < d.height ? d.width : d.height;

        arabicClock = new AnalogClock(fileName1);
        arabicClock.setPreferredSize(new Dimension(minDimension, minDimension));
        romanClock = new AnalogClock(fileName2);
        romanClock.setPreferredSize(new Dimension(minDimension, minDimension));
        numericClock = new NumericClock();

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(arabicClock);
        add(romanClock);
        add(numericClock);
    }
}*/
