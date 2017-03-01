package views;

import timer.TimerChrono;

import java.awt.*;
import java.awt.Toolkit;
import java.awt.geom.Line2D;

/**
 * Created by pierre-samuelrochat on 25.02.17.
 */
public class AnalogClock extends Clock {

    private Image image;

    private Line2D seconds;
    private Line2D minutes;
    private Line2D hours;

    AnalogClock(TimerChrono timer, String fileName) {

        super(timer);

        image = Toolkit.getDefaultToolkit().getImage(fileName);

        seconds = new Line2D.Float();
        minutes = new Line2D.Float();
        hours = new Line2D.Float();
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        Dimension d = getSize();
        int imageSideLength = d.width < d.height ? d.width : d.height;

        g.drawImage(image, 0, 0, imageSideLength, imageSideLength, this);

        int imageCenterXY = imageSideLength / 2;

        int secondsLength = (int)(imageSideLength * 0.4);
        int minutesLength = (int)(imageSideLength * 0.3);
        int hoursLength   = (int)(imageSideLength * 0.2);

        Graphics2D g2 = (Graphics2D)g;

        Point centerPoint = new Point(imageCenterXY, imageCenterXY);
        Point endPoint;

        endPoint = getEndPoint(timer.getSeconds(), secondsLength, imageSideLength);

        seconds.setLine(centerPoint, endPoint);
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.RED);
        ((Graphics2D)g).draw(seconds);

        endPoint = getEndPoint(timer.getMinutes(), minutesLength, imageSideLength);

        minutes.setLine(centerPoint, endPoint);
        g2.setStroke(new BasicStroke(3));
        g2.setColor(Color.BLUE);
        ((Graphics2D)g).draw(minutes);

        endPoint = getEndPoint(timer.getHours(), hoursLength, imageSideLength);

        hours.setLine(centerPoint, endPoint);
        g2.setStroke(new BasicStroke(4));
        g2.setColor(Color.BLACK);
        ((Graphics2D)g).draw(hours);
    }


    private Point getEndPoint(int time, int needleLength, int imageSideLength) {

        double radians = 2 * Math.PI * (time-15) / 60;
        int x = (int)(imageSideLength / 2 + needleLength * Math.cos(radians));
        int y = (int)(imageSideLength / 2 + needleLength * Math.sin(radians));

        return (new Point(x, y));
    }
}
