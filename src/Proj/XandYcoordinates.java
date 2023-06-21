package Proj;

/**
 * Klasa służy do hermetyzacji danych, dzięki niej uzyskujemy dostęp do koordynatów myszy
 */
public class XandYcoordinates {
    private int mx;
    private int my;

    /**
     * Ponizsze funkcje służą do ustawiania koordynatów położenia myszy (settery) i do uzyskania dostępu do nich przez inne klasy (gettery)
     */
    public int getMx() {
        return mx;
    }

    public void setMx(int mx) {
        this.mx = mx;
    }

    public int getMy() {
        return my;
    }

    public void setMy(int my) {
        this.my = my;
    }

}
