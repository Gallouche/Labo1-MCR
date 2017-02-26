package views;

import javax.swing.*;
import java.awt.*;
import java.awt.Toolkit;
import java.awt.geom.Line2D;



/**
 * Created by pierre-samuelrochat on 25.02.17.
 */
public class AnalogClock extends Clock {

    private String fileName;
    protected Image image;
    protected JPanel jPanel;
    protected JLabel imageLabel;
    private Line2D seconds;
    private Line2D minutes;
    private Line2D hours;



    AnalogClock(String fileName, JFrame frame){
        System.out.println(frame.getContentPane().getWidth());
        System.out.println(frame.getContentPane().getHeight());

        image = Toolkit.getDefaultToolkit().getImage(fileName);
        image = image.getScaledInstance(frame.getContentPane().getPreferredSize().width,
                frame.getContentPane().getPreferredSize().height, Image.SCALE_SMOOTH);
        jPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        setLayout(new FlowLayout());
        add(jPanel);


        Line2D seconds = new Line2D.Float(jPanel.getWidth()/2, jPanel.getHeight()/2, 100, 20);
        //Line2D minutes = new Line2D.Float(100, 100, 250, 260);
        //Line2D hours = new Line2D.Float(100, 100, 250, 260);


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(image, 0, 0, this);


    }

}
