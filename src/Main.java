import javax.swing.*;
import java.awt.*;
import views.*;

/**
 * Created by pierre-samuelrochat on 23.02.17.
 */
public class Main {
    public static void main(String[] args) {

        JFrame f = new JFrame("");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new MainPanel(f), BorderLayout.CENTER);
        f.pack();
        f.setVisible(true);
    }
}