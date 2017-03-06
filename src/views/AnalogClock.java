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

        //set the dimension of the frame
        setPreferredSize(new Dimension(300, 300));

        seconds = new Line2D.Float();
        minutes = new Line2D.Float();
        hours = new Line2D.Float();
    }

    /**
     * Description: method used for paint the needles
     * @param g
     */
    @Override
    public void paint(Graphics g) {

        super.paint(g);

        Dimension d = getSize();
        int imageSideLength = d.width < d.height ? d.width : d.height;

        g.drawImage(getImage(), 0, 0, imageSideLength, imageSideLength, this);

        Graphics2D g2 = (Graphics2D)g;

        int imageCenterXY = imageSideLength / 2;

        int secondsLength = (int)(imageSideLength * 0.4);
        int minutesLength = (int)(imageSideLength * 0.3);
        int hoursLength   = (int)(imageSideLength * 0.2);

        Point centerPoint = new Point(imageCenterXY, imageCenterXY);
        Point endPoint;

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



    private Point getEndPoint(int time, int needleLength, int imageSideLength, int div) {

        double radians = 2 * Math.PI * (time-15) / div;
        int x = (int)(imageSideLength / 2 + needleLength * Math.cos(radians));
        int y = (int)(imageSideLength / 2 + needleLength * Math.sin(radians));

        return (new Point(x, y));
    }

    abstract Image getImage();
}
