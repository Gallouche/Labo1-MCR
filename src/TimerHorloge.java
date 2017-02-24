
import javax.swing.Timer;

/**
 * Created by Gallouche on 24/02/2017.
 */
public class TimerHorloge extends Observable{
    private Timer timer;

    public TimerHorloge(){
        timer = new Timer();
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
