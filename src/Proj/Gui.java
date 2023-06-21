package Proj;

import javax.swing.*;
import java.awt.*;

/**
 * Klasa Gui reprezentuje interfejs graficzny aplikacji, który zawiera okno programu.
 * Dziedziczy po klasie JFrame, która służy do tworzenia interfejsów graficznych.
 */
public class Gui extends JFrame { //dziedziczy biblioteke JFrame ktora sluzy do tworzenia GUI

    /**
     * Konstruktor inicjalizujący interfejs graficzny aplikacji.
     */
    public Gui(){

        ImageIcon windowIcon = new ImageIcon("game.png"); // tworzy ikone ktora bedzie sie wyswietlala w lewym gornym rogu okna programu i precyzuje ktora to ma dokladnie byc

        this.setIconImage(windowIcon.getImage()); // ustawia ikone okna programu

        this.setTitle("Game of Life"); // ustala nazwe wyswietlajacego sie okienka

        this.setSize(1294,775); // ustala rozmiar wyswietlajacego sie okienka

        this.setBackground(new Color(10,12,10)); //ustala kolor tła

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sprawia ze gdy klikamy "X" program sie zamyka a nie tylko minimalizuje

        this.setVisible(true); // sprawia ze okienko jest widoczne

        this.setResizable(false); // false - sprawia ze uzytkownik nie moze zmieniac rozmiaru okienka



        MouseClick mouseClick = new MouseClick();
        this.addMouseListener(mouseClick);


        Grid grid = new Grid(); //tworzy obiekt grid od klasy Grid
        this.setContentPane(grid); //wstawia zawartosc obiektu grid do naszego GUI


    }

    /**
     * Wyświetla okno dialogowe z zasadami symulacji Game of Life.
     */
    public static void showRulesDialog() { //wyświetla okno dialogowe z zasadami symulacji Game of Life

        String[] rules = { //tworzy tablicę napisów, która przechowuje zasady symulacji

                "1. Każda komórka może być martwa (pusta) albo żywa.",
                "2. Jeśli żywa komórka ma mniej niż dwóch żywych sąsiadów, umiera (z powodu samotności).",
                "3. Jeśli żywa komórka ma więcej niż trzy żywych sąsiadów, umiera (z powodu przeludnienia).",
                "4. Jeśli martwa komórka ma dokładnie trzech żywych sąsiadów, ożywa.",
                "5. Pozostałe komórki (żywe) pozostają takie same w następnej generacji.",
                "6. Symulacja przebiega w krokach czasowych (generacjach)."
        };

        ImageIcon[] images = { //tworzy tablicę obiektów ImageIcon, która przechowuje obrazy związane z poszczególnymi zasadami

                new ImageIcon("rule1.png"),
                new ImageIcon("rule2.png"),
                new ImageIcon("rule3.png"),
                new ImageIcon("rule4.png"),
                new ImageIcon("rule5.png"),
                new ImageIcon("rule6.png")
        };

        JPanel panel = new JPanel(new GridBagLayout());  //tworzy panel w układzie siatki dla zawartości okna dialogowego
        GridBagConstraints constraints = new GridBagConstraints(); //obiekt GridBagConstraints przechowuje informacje o preferowanych właściwościach komponentów takich jak pozycja, wyrównanie, rozmiar i marginesy
        constraints.anchor = GridBagConstraints.WEST; //ustawia położenie kotwicy dla komponentu w komórce siatki
        constraints.insets = new Insets(5, 10, 5, 10); //ustawia marginesy wokół komponentu w komórce siatki
        int row = 0;

        JLabel title = new JLabel("Zasady symulacji Game of Life: "); //tworzy etykietę title zawierającą tytuł zasad symulacji
        constraints.gridx = 0; //gridx odnosi się do kolumny siatki, w której ma zostać umieszczony komponent (kolumny indeksowane są od lewej do prawej)
        constraints.gridy = row; //gridy odnosi się do wiersza siatki, w którym ma zostać umieszczony komponent (wiersze indeksowane są od góry do dołu)
        panel.add(title, constraints); //dodaje etykietę title do panelu panel z uwzględnieniem ustawionych wcześniej ograniczeń constraints
        row = 1;

        for (int i = 0; i < rules.length; i++) { //pętla ta tworzy etykietę dla każdego elementu z listy zasad oraz dodaje obrazy do odpowiednich etykiet
            JLabel label = new JLabel(rules[i]);
            JLabel imageLabel = new JLabel(images[i]);

            constraints.gridy = row;
            constraints.gridx = 0;
            panel.add(label, constraints);

            constraints.gridy = row;
            constraints.gridx = 1;
            panel.add(imageLabel, constraints);

            row++;
        }

        JOptionPane.showMessageDialog(null, panel, "Zasady symulacji", JOptionPane.INFORMATION_MESSAGE); //funkcja wyświetlająca okno dialogowe z zadanym komunikatem
    }



}
