package Proj;

/**
 * Klasa dzięki której program może zostać uruchomiony
 */
public class Main implements Runnable {
    Gui gui = new Gui();

    /**
     * Główna metoda main dzięki której  program może się rozpocząć,
     * tworzymy obiekt Thread i obiekt Main. Metoda "start()" powoduje rozpoczęcie wątku, który wykonuje metodę run która znajduje się niżej.
     * .startTimer() służy do rozpoczęcia działania timera w klasie MouseInteraction
     */
    public static void main(String[] args) {
        new Thread(new Main()).start();
        MouseInteraction.startTimer();


    }

    /** Metoda z pętlą while dzięki której nasz interfejs wyświetla odpowiednie kolory
     */

    @Override //
    public void run() {
        while (true) {
            gui.repaint();
        }
    }

}
