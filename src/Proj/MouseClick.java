package Proj;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Proj.VirtualPolymorphismShapeClicked.Square;
import Proj.VirtualPolymorphismShapeClicked.NoWhere;


/**
 * Klasa dzięki której możliwe jest śledzenie położenia myszy na ekranie
 */
public class MouseClick implements MouseListener {

    NoWhere NoWhere_Clicked = new NoWhere();
    XandYcoordinates xandYcoordinates = new XandYcoordinates();

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    /**   @param e Funkcja ktora kontorluje polozenie myszy w naszym oknie i odpowiednio zaświeca kwadraty kiedy się je naciśnie, funkcja odczytuje też koordynaty z pomoca klasy XandUcoordinates
    *
    */

    @Override
    public void mousePressed(MouseEvent e) {
        Square Square_Clicked = new Square();

        int a = e.getX();
        int b = e.getY();

        xandYcoordinates.setMx(a);
        xandYcoordinates.setMy(b);
        int x = xandYcoordinates.getMx();
        int y = xandYcoordinates.getMy();

        NoWhere_Clicked.Clicked();
        if(x>7 && x<1303 && y>79 && y<815) {
            SquareControl.colourCoding[(x - 7) / 16][(y - 79) / 16][SquareControl.NextEvolution % 2]++; //odpowiada za wielkość okna tablicy colourCoding
            Square_Clicked.Clicked();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
