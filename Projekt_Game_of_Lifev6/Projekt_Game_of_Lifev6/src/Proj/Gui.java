package Proj;

import javax.swing.*;
import java.awt.*;


public class Gui extends JFrame { //dziedziczy biblioteke JFrame ktora sluzy do tworzenia GUI

    public Gui(){

        ImageIcon windowIcon = new ImageIcon("game.png"); // tworzy ikone ktora bedzie sie wyswietlala w lewym gornym rogu okna programu i precyzuje ktora to ma dokladnie byc

        this.setIconImage(windowIcon.getImage()); // ustawia ikone okna programu


        this.setTitle("Game of Life"); // ustala nazwe wyswietlajacego sie okienka

        this.setSize(1294,775); // ustala rozmiar wyswietlajacego sie okienka

        this.setBackground(new Color(10,12,10)); //ustala kolor tła

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sprawia ze gdy klikamy "X" program sie zamyka a nie tylko minimalizuje

        this.setVisible(true); // sprawia ze okienko jest widoczne

        this.setResizable(true); // false - sprawia ze uzytkownik nie moze zmieniac rozmiaru okienka



        Mouse_Inter_1 mouseInter1 = new Mouse_Inter_1(); //tworzy obiekt od klasy Mouse_Inter
        this.addMouseMotionListener(mouseInter1);

        MouseClick mouseClick = new MouseClick();
        this.addMouseListener(mouseClick);


        Grid grid = new Grid(); //tworzy obiekt grid od klasy Grid
        this.setContentPane(grid); //wstawia zawartosc obiektu grid do naszego GUI


    }

    public static void showRulesDialog() {
        String rules = "Zasady symulacji \"Game of Life\":\n" +
                "1. Każda komórka może być martwa (pusta) albo żywa.\n" +
                "2. Jeśli żywa komórka ma mniej niż dwóch żywych sąsiadów, umiera (z powodu samotności).\n" +
                "3. Jeśli żywa komórka ma więcej niż trzech żywych sąsiadów, umiera (z powodu przeludnienia).\n" +
                "4. Jeśli martwa komórka ma dokładnie trzech żywych sąsiadów, ożywa.\n" +
                "5. Pozostałe komórki (żywe) pozostają takie same w następnej generacji.\n" +
                "6. Symulacja przebiega w krokach czasowych (generacjach).\n" +
                "\n" +
                "Dzięki tym zasadom można obserwować ewolucję struktur w zależności od stanu początkowego.";

        JOptionPane.showMessageDialog(null, rules, "Zasady symulacji", JOptionPane.INFORMATION_MESSAGE);
    }

}
