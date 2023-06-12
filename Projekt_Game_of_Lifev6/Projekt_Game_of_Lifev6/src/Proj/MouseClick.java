package Proj;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseClick implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        XandYcoordinates.setMx(x);
        XandYcoordinates.setMy(y);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        XandYcoordinates.setMx(x);
        XandYcoordinates.setMy(y);
        if(x>7 && x<1303 && y>79 && y<815) ColourCoding.colourCoding[(x-7)/16][(y-79)/16][ColourCoding.NextEvolution%2]++; //odpowiada za wielkość okna tablicy colourCoding
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
