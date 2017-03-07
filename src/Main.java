import javax.swing.*;
import java.awt.*;
import views.*;
import timer.TimerChrono;

/**
 * File: Main.java
 * Created by Rochat P-S. & Gallandat T.
 * Date: 09/03/2017
 * Description: Implement the class Main who provide the main frame of the program and create the general timer.
 */
public class Main {
    public static void main(String[] args) {

        TimerChrono timer = new TimerChrono();

        JFrame f = new JFrame("Labo1_MCR");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new MainPanel(timer), BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);

    }
}