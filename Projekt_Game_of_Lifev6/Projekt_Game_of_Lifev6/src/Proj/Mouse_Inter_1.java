package Proj;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.util.TimerTask;

public class Mouse_Inter_1 implements MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    private static Timer timer;
    private static int speedMultiplier = 1;
    private static int delay = 1000;


    public static void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (ColourCoding.Clicked_start == 1)
                    ColourCoding.Next_step();
            }
        }, 0, delay);
    }

    private static void stopTimer() {
        timer.cancel();
    }

    private static void updateTimerDelay() {
        delay = 1000 / speedMultiplier;
        stopTimer();
        startTimer();
    }

    public static void setSpeedMultiplier(int multiplier) {
        speedMultiplier = multiplier;
        updateTimerDelay();
    }
}
