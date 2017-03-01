package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import timer.TimerChrono;

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


        arabicClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame arabicClockFrame = new JFrame("Arabic Clock");
                arabicClockFrame.getContentPane().setPreferredSize(new Dimension(300, 300));
                AnalogClock arabicClock = new AnalogClock(timer, imagePath1);
                arabicClockFrame.getContentPane().add(arabicClock, BorderLayout.CENTER);
                arabicClockFrame.pack();
                arabicClockFrame.setVisible(true);
                arabicClockFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        System.out.println(timer.getNumberSubscribers());
                        timer.deleteObserver(arabicClock);
                        System.out.println(timer.getNumberSubscribers());
                    }
                });

            }
        });


        romanClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame romanClockFrame = new JFrame("Roman Clock");
                romanClockFrame.getContentPane().setPreferredSize(new Dimension(300, 300));
                AnalogClock romanClock = new AnalogClock(timer, imagePath2);
                romanClockFrame.getContentPane().add(romanClock, BorderLayout.CENTER);
                romanClockFrame.pack();
                romanClockFrame.setVisible(true);
                romanClockFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        timer.deleteObserver(romanClock);
                    }
                });

            }
        });

        numericClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame numericClockFrame = new JFrame("Numeric Clock");
                numericClockFrame.getContentPane().setPreferredSize(new Dimension(200, 30));

                NumericClock numericClock = new NumericClock(timer);

                numericClockFrame.getContentPane().add(numericClock, BorderLayout.CENTER);
                numericClockFrame.pack();
                numericClockFrame.setVisible(true);
                numericClockFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        timer.deleteObserver(numericClock);
                    }
                });

            }
        });

        mixedClockButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame mixedClockFrame = new JFrame("Mixed Clock");
                mixedClockFrame.getContentPane().setPreferredSize(new Dimension(800, 300));

                JPanel jPanel = new JPanel();

                int imageSideLength = Math.min(mixedClockFrame.getPreferredSize().width, mixedClockFrame.getPreferredSize().height);

                AnalogClock arabicClock = new AnalogClock(timer, "clock1.jpg");
                arabicClock.setPreferredSize(new Dimension(imageSideLength, imageSideLength));
                AnalogClock romanClock = new AnalogClock(timer, "clock2.jpg");
                romanClock.setPreferredSize(new Dimension(imageSideLength, imageSideLength));
                NumericClock numericClock = new NumericClock(timer);

                jPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                jPanel.add(arabicClock);
                jPanel.add(romanClock);
                jPanel.add(numericClock);

                mixedClockFrame.getContentPane().add(jPanel, BorderLayout.CENTER);
                mixedClockFrame.pack();
                mixedClockFrame.setVisible(true);
                mixedClockFrame.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                        timer.deleteObserver(arabicClock);
                        timer.deleteObserver(romanClock);
                        timer.deleteObserver(numericClock);
                    }
                });

            }
        });

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { timer.reset(); }
        });

        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }
}