import javax.swing.*;
import java.awt.*;

import views.*;
import timer.TimerChrono;

/**
 * Created by pierre-samuelrochat on 23.02.17.
 */
public class Main {
    public static void main(String[] args) {

        TimerChrono timer = new TimerChrono();

        JFrame f = new JFrame("");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new MainPanel(timer), BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);

    }
}