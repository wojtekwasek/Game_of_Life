package Proj;

import java.util.Timer;
import java.util.TimerTask;

public class Main implements Runnable {
    Gui gui = new Gui();

    public static void main(String[] args) {
        new Thread(new Main()).start();

        Mouse_Inter_1.startTimer();
    }



    @Override // nadpisuje metode run z biblioteki Runnable
    public void run() {
        while (true){
            gui.repaint();
        }

    }

}
