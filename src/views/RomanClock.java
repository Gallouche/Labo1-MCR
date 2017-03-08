package views;

import timer.TimerChrono;

import java.awt.*;
import java.awt.Toolkit;

/**
 * File: RomanClock.java
 * Created by Rochat P-S. & Gallandat T.
 * Date: 09/03/2017
 * Description: Implement the RomanClock class which is a specific type of clock with roman number on the
 *              background image.
 */
public class RomanClock extends AnalogClock {

    final String fileName = "clock2.jpg";
    private Image image;

    /**
     * Description: create an arabic clock and get the background image from the desired file.
     * @param timer timer to observe.
     */
    public RomanClock(TimerChrono timer) {
        super(timer, "Roman Clock");
        image = Toolkit.getDefaultToolkit().getImage(fileName);
    }

    /**
     * Description: get the background image of the clock.
     * @return Image image
     */
    Image getImage() { return image; }

}

