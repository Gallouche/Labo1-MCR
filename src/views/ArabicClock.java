package views;

import timer.TimerChrono;
import java.awt.*;
import java.awt.Toolkit;

/**
 * File: ArabicClock.java
 * Created by Rochat P-S. & Gallandat T.
 * Date: 09/03/2017
 * Description: Implement the class ArabicClock which is a specific type of clock with arabic number on the
 *              background image.
 */
public class ArabicClock extends AnalogClock {

    final String fileName = "clock1.jpg";
    private Image image;

    /**
     * Description: create an arabic clock and get the background image from the desired file.
     * @param timer timer to observe.
     */
    public ArabicClock(TimerChrono timer) {
        super(timer, "Arabic Clock");
        image = Toolkit.getDefaultToolkit().getImage(fileName);
    }

    /**
     * Description: getter on the background image of the clock.
     * @return Image image
     */
    Image getImage() { return image; }

}
