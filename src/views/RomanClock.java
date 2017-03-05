package views;

import timer.TimerChrono;

import java.awt.*;
import java.awt.Toolkit;

/**
 * Created by pierre-samuelrochat on 01.03.17.
 */
public class RomanClock extends AnalogClock {

    final String fileName = "clock2.jpg";
    private Image image;

    public RomanClock(TimerChrono timer) {
        super(timer, "Roman Clock");
        image = Toolkit.getDefaultToolkit().getImage(fileName);
    }

    Image getImage() { return image; }

}

