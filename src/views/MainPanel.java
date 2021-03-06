package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import timer.TimerChrono;

/**
 * File: MainPanel.java
 * Created by Rochat P-S. & Gallandat T.
 * Date: 09/03/2017
 * Description: Implement the class MainPanel that creates the main panel of the program and creates all the
 *              useful button.
 */
public class MainPanel extends JPanel {

    // Panels that will contain the buttons
    private JPanel p1;
    private JPanel p2;

    // Buttons for clocks creation
    private JButton romanClockButton;
    private JButton arabicClockButton;
    private JButton numericClockButton;
    private JButton mixedClockButton;

    // Buttons for others features
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    private JButton quitButton;

    // The timer used by the clocks
    private TimerChrono timer;


    public MainPanel(TimerChrono timer) {

        final String imagePath1 = "clock1.jpg";
        final String imagePath2 = "clock2.jpg";

        this.timer = timer;

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

        // Definition of behaviour when buttons are pressed

        arabicClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ArabicClock arabicClock = new ArabicClock(timer);
                createFrame(timer, arabicClock);

            }
        });


        romanClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                RomanClock romanClock = new RomanClock(timer);
                createFrame(timer, romanClock);

            }
        });

        numericClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                NumericClock numericClock = new NumericClock(timer);
                createFrame(timer, numericClock);

            }
        });

        mixedClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ArabicClock arabicClock = new ArabicClock(timer);
                RomanClock romanClock = new RomanClock(timer);
                NumericClock numericClock = new NumericClock(timer);
                createFrame(timer, arabicClock, romanClock, numericClock);

            }
        });

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { timer.start(); }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { timer.stop(); }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { timer.reset(); }
        });

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { System.exit(0); }
        });


    }

    /**
     * Description: Create a frame and add the clocks to it.
     *              Define the behaviour when we click on the frame and when we close it.
     * @param timer the timer used by the clocks.
     * @param clocks the clock(s) used to create the frame.
     */
    void createFrame(TimerChrono timer, Clock... clocks) {

        JFrame frame = new JFrame();

        if(clocks.length > 1) {
            frame.setLayout(new FlowLayout(FlowLayout.CENTER));
            frame.setName("Mixed Clock");
        } else {
            frame.setLayout(new BorderLayout());
            frame.setName(clocks[0].getPanelName());
        }

        for (Clock clock : clocks) {
            frame.getContentPane().add(clock);
        }

        // Make the timer switch its state when the frame is clicked
        frame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {

                timer.switchState();

            }
        });

        // Unsubscribe the clock(s) from timer observation when the frame is closed
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {

                for (Clock clock : clocks) {
                    timer.deleteObserver(clock);
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
    }


}