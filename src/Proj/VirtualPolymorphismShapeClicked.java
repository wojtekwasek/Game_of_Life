package Proj;

/**
 * Klasa odpowiada za liczenie kliknięć myszy za pomocą polimorfizmu
 */
public class VirtualPolymorphismShapeClicked {


    public static void main(String[] args) {
        Window Shape1 = new Window();
        Window Clicked_Square = new Square();
        Window NoWhere = new NoWhere();

        Shape1.Clicked();
        Clicked_Square.Clicked();
        NoWhere.Clicked();
    }
    /**
     * Klasa odpowiada za liczenie kliknięć myszy w całym oknie
     */
    public static class Window {
        public void Clicked() {
            SquareControl.Sum_of_Mouse_Clicks++;
        }
    }
    /**
     * Klasa odpowiada za liczenie kliknięć myszy na planszy
     */
    public static class Square extends Window {
        @Override
        public void Clicked() {
            SquareControl.Sum_of_Mouse_Clicks_on_the_board++;

        }

    }
    /**
     * Klasa odpowiada za liczenie kliknięć myszy poza plansza
     */
    public static class NoWhere extends Window {
        @Override
        public void Clicked() {
            SquareControl.Sum_of_Mouse_Clicks_outside_board++;

        }
    }

}