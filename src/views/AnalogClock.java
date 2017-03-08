package views;

import timer.TimerChrono;
import java.awt.*;
import java.awt.geom.Line2D;

/**
 * File: AnalogClock.java
 * Created by Rochat P-S. & Gallandat T.
 * Date: 09/03/2017
 * Description: Implement the AnalogClock class extended from Clock. This class provide the canvas for the analogic
 *              clocks, it takes a timer and a name in parameters.
 */
public abstract class AnalogClock extends Clock {

    //2D line for the representation of the 3 needles
    private Line2D seconds;
    private Line2D minutes;
    private Line2D hours;

    AnalogClock(TimerChrono timer, String name) {

        super(timer, name);

        //Sets the dimensions of the clock
        setPreferredSize(new Dimension(300, 300));

        seconds = new Line2D.Float();
        minutes = new Line2D.Float();
        hours = new Line2D.Float();
    }

    /**
     * Description: paint the background image and the needles.
     * @param g the Graphics object
     */
    @Override
    public void paint(Graphics g) {

        super.paint(g);

        // Get the current size of the panel
        Dimension d = getSize();
        // Set the image side length as the shortest side of the panel
        int imageSideLength = d.width < d.height ? d.width : d.height;

        g.drawImage(getImage(), 0, 0, imageSideLength, imageSideLength, this);

        Graphics2D g2 = (Graphics2D)g;

        int imageCenterXY = imageSideLength / 2;

        // Length of the needles
        int secondsLength = (int)(imageSideLength * 0.4);
        int minutesLength = (int)(imageSideLength * 0.3);
        int hoursLength   = (int)(imageSideLength * 0.2);

        Point centerPoint = new Point(imageCenterXY, imageCenterXY);
        Point endPoint;

        // Drawings of the needles
        endPoint = getEndPoint(timer.getSeconds(), secondsLength, imageSideLength, 60);
        seconds.setLine(centerPoint, endPoint);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.RED);
        ((Graphics2D)g).draw(seconds);

        endPoint = getEndPoint(timer.getMinutes(), minutesLength, imageSideLength, 60);
        minutes.setLine(centerPoint, endPoint);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.BLUE);
        ((Graphics2D)g).draw(minutes);

        endPoint = getEndPoint(timer.getHours(), hoursLength, imageSideLength, 12);
        hours.setLine(centerPoint, endPoint);
        g2.setStroke(new BasicStroke(4));
        g2.setColor(Color.BLACK);
        ((Graphics2D)g).draw(hours);
    }


    /**
     * Description: Calculate the coordinates x and y of the end point and returns the point.
     * @param time the current time in seconds, minutes or hours.
     * @param needleLength
     * @param imageSideLength
     * @param div number of increments (60 for minutes and seconds, 12 for hours).
     * @return Point endPoint
     */
    private Point getEndPoint(int time, int needleLength, int imageSideLength, int div) {

        double radians = 2 * Math.PI * (time-15) / div;
        int x = (int)(imageSideLength / 2 + needleLength * Math.cos(radians));
        int y = (int)(imageSideLength / 2 + needleLength * Math.sin(radians));

        return (new Point(x, y));
    }

    /**
     * Description: Specification of the method getImage used to get the image from subclasses in draw method.
     */
    abstract Image getImage();
}
