package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by pierre-samuelrochat on 11.01.17.
 */
public class MainPanel extends JPanel {

    private JPanel p1;
    private JPanel p2;

    private JButton romanClockButton;
    private JButton arabicClockButton;
    private JButton numericClockButton;
    private JButton mixedClockButton;

    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    private JButton quitButton;


    public MainPanel(JFrame f) {

        p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        romanClockButton = new JButton("Horloge Romaine");
        arabicClockButton = new JButton("Horloge Arabe");
        numericClockButton = new JButton("Horloge Numérique");
        mixedClockButton = new JButton("Horloge Mixte");

        startButton = new JButton("Démarrer");
        stopButton = new JButton("Arrêter");
        resetButton = new JButton("Réinitialiser");
        quitButton = new JButton("Quitter");

        p1.add(romanClockButton);
        p1.add(arabicClockButton);
        p1.add(numericClockButton);
        p1.add(mixedClockButton);

        p2.add(startButton);
        p2.add(stopButton);
        p2.add(resetButton);
        p2.add(quitButton);

        setLayout(new GridLayout(2, 1));

        add(p1);
        add(p2);


        arabicClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame arabicClockFrame = new JFrame("Arabic Clock");
                arabicClockFrame.getContentPane().add(new ArabicClock(arabicClockFrame), BorderLayout.CENTER);
                arabicClockFrame.pack();
                arabicClockFrame.setVisible(true);

            }
        });

        numericClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame numericClockFrame = new JFrame("Numeric Clock");
                numericClockFrame.getContentPane().add(new ArabicClock(numericClockFrame), BorderLayout.CENTER);
                numericClockFrame.pack();
                numericClockFrame.setVisible(true);

            }
        });

        romanClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame romanClockFrame = new JFrame("Roman Clock");
                romanClockFrame.getContentPane().add(new ArabicClock(romanClockFrame), BorderLayout.CENTER);
                romanClockFrame.pack();
                romanClockFrame.setVisible(true);

            }
        });

        mixedClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame mixedClockFrame = new JFrame("Mixed Clock");
                mixedClockFrame.getContentPane().add(new ArabicClock(mixedClockFrame), BorderLayout.CENTER);
                mixedClockFrame.pack();
                mixedClockFrame.setVisible(true);

            }
        });

    }
}