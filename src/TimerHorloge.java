
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Gallouche on 24/02/2017.
 */
public class TimerHorloge extends Observable{
    private Timer timer;
    private int tempsEcoule;

    public TimerHorloge(){
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notifier();
                tempsEcoule++;
            }
        });
    }

    public void start(){
        timer.start();
    }

    public void pause(){
        timer.stop();
    }

    public void restart(){
        timer.restart();
    }
}
