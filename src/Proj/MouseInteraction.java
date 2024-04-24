package Proj;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Klasa MouseInteraction dostarcza funkcjonalności do kontrolowania timera symulacji i zarządzania jego prędkością.
 */
public class MouseInteraction {


    private static Timer timer; //statyczna zmienna timer typu Timer, która jest używana do uruchamiania automatycznego przebiegu symulacji i zarządzania czasem
    private static int speedMultiplier = 1; //statyczna zmienna, przechowująca współczynnik prędkości, który wpływa na opóźnienie timera
    private static int delay = 1000; //statyczna zmienna, przechowująca opóźnienie (w milisekundach) między kolejnymi wykonaniami timera

    /**
     * Uruchamia timer i rozpoczyna postęp symulacji.
     */
    public static void startTimer() { //statyczna metoda, która rozpoczyna działanie timera
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (SquareControl.Clicked_start == 1)
                    SquareControl.Next_step();
            }
        }, 0, delay);
    }

    /**
     * Zatrzymuje timer i zatrzymuje postęp symulacji.
     */
    private static void stopTimer() { //statyczna metoda, która zatrzymuje działanie timera poprzez wywołanie metody cancel() na obiekcie timer
        timer.cancel();
    }

    /**
     * Aktualizuje opóźnienie timera na podstawie współczynnika prędkości.
     */
    private static void updateTimerDelay() { //statyczna metoda, która aktualizuje opóźnienie timera (delay) na podstawie wartości speedMultiplier
        delay = 1000 / speedMultiplier;
        stopTimer();
        startTimer();
    }

    /**
     * Ustawia nową wartość współczynnika prędkości i aktualizuje opóźnienie timera.
     * @param multiplier nowa wartość współczynnika prędkości
     */
    public static void setSpeedMultiplier(int multiplier) { //statyczna metoda, która ustawia nową wartość speedMultiplier i wywołuje updateTimerDelay()
        speedMultiplier = multiplier;
        updateTimerDelay();
    }
}
