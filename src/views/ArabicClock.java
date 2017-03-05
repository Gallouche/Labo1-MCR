package views;

import timer.TimerChrono;

import java.awt.*;
import java.awt.Toolkit;

/**
 * Created by pierre-samuelrochat on 01.03.17.
 */
public class ArabicClock extends AnalogClock {

    final String fileName = "clock1.jpg";
    private Image image;

    public ArabicClock(TimerChrono timer) {
        super(timer, "Arabic Clock");
        image = Toolkit.getDefaultToolkit().getImage(fileName);
    }

    Image getImage() { return image; }

}
