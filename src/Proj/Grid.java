package Proj;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;

/**
 * Klasa Grid reprezentuje siatkę w interfejsie graficznym gry. Dziedziczy po JPanel i implementuje ActionListener.
 */
public class Grid extends JPanel implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    /**
     * Metoda odpowiedzialna za rysowanie komponentu graficznego.
     *
     * @param graphics obiekt klasy Graphics, umożliwiający rysowanie elementów graficznych
     */
    public void paintComponent(Graphics graphics) { //metoda z biblioteki swing, która jest wywoływana wewnątrz programu, gdy zostanie stwierdzone, że owa operacja jest konieczna (źródło: https://stackoverflow.com/questions/15544549/how-does-paintcomponent-work)
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial", Font.BOLD, 12));
        graphics.setColor(new Color(150, 150, 150));
        graphics.fillRect(0, 0, 1280, 49);

        int liveCount = 0;

        graphics.setColor(new Color(85, 85, 85)); //ustala kolor kwadratow
        for (int i = 0; i <= 80; i++) { // podzielilem rozdzielczosc x i y naszego okna(1280x720) na 16 czesci uzyskujac 80x45 kwadratow, petla zajmuje sie ich umiejscowieniem
            for (int j = 0; j <= 45; j++) {

                if (SquareControl.colourCoding[i][j][SquareControl.NextEvolution%2] % 2 == 0) {
                    graphics.setColor(new Color(85, 85, 85)); // ustala na jaki kolor zmmieni sie kwadrat kiedy uzytkownik wejdzie w interakcję z siatka
                    graphics.fillRect(i * 16, 50 + j * 16, 14, 14); // zastepuje podstawowy (szary kwadrat) zielonym kwadratem (tworzy go na nim)

                }
                if (SquareControl.colourCoding[i][j][SquareControl.NextEvolution%2] % 2 == 1) {
                    graphics.setColor(new Color(0, 150, 0)); // ustala na jaki kolor zmmieni sie kwadrat kiedy uzytkownik wejdzie w interakcję z siatka
                    graphics.fillRect(i * 16, 50 + j * 16, 14, 14); // zastepuje podstawowy (szary kwadrat) zielonym kwadratem (tworzy go na nim)
                    liveCount++;

                }

            }

        }

        ImageIcon start_button_Icon = new ImageIcon("start_button.png");
        ImageIcon next_button_Icon = new ImageIcon("next_button.png");
        ImageIcon clear_button_Icon = new ImageIcon("clear_button.png");
        ImageIcon stop_button_Icon = new ImageIcon("stop_button.png");
        ImageIcon info_button_Icon = new ImageIcon("info_button.png");
        ImageIcon shapes_button_Icon = new ImageIcon("shapes_button.png");
        ImageIcon acceleration_button_Icon = new ImageIcon("acceleration_button.png");
        //powyzsze 7 linijek tworza ikony dla danego przycisku

        JButton stop_button = new JButton();
        JButton start_button = new JButton();
        start_button.setBounds(0,0, 144,49);
        start_button.setIcon(start_button_Icon);
        start_button.setText("Start");
        start_button.setBackground(Color.lightGray);
        start_button.setBorder(BorderFactory.createEtchedBorder());
        start_button.addActionListener( e -> {
            SquareControl.Clicked_start=1;
            start_button.setBackground(Color.GREEN);
            stop_button.setBackground(Color.lightGray);
        });
        this.add(start_button);


        //powyzsze komendy tworza przycisk w odpowiednim miejscu, ustawiaja jego kolor, napis, obramowanie oraz ikonę, dzieje sie tak samo dla stop, next i clear button

        stop_button.setBounds(145,0, 144,49);
        stop_button.setIcon(stop_button_Icon);
        stop_button.setText("Stop");
        stop_button.setBackground(Color.lightGray);
        stop_button.setBorder(BorderFactory.createEtchedBorder());
        stop_button.addActionListener( e -> {
            SquareControl.Clicked_start=0;
            start_button.setBackground(Color.lightGray);
            stop_button.setBackground(Color.RED);
        });


        this.add(stop_button);

        JButton next_button = new JButton();
        next_button.setBounds(286,0, 144,49);
        next_button.setIcon(next_button_Icon);
        next_button.setText("Next");
        next_button.setBackground(Color.lightGray);
        next_button.setBorder(BorderFactory.createEtchedBorder());
        next_button.addActionListener( e -> SquareControl.Next_step());

        this.add(next_button);

        JButton clear_button = new JButton();
        clear_button.setBounds(427,0,144,49);
        clear_button.setIcon(clear_button_Icon);
        clear_button.setText("Clear");
        clear_button.setBackground(Color.lightGray);
        clear_button.setBorder(BorderFactory.createEtchedBorder());

        clear_button.addActionListener( e-> {
            SquareControl.NextEvolution=1;
            SquareControl.Age_of_simulation=0;
            SquareControl.Clicked_start=0;
            SquareControl.Square_clear();

        });
        this.add(clear_button);



        JButton explanation_button = new JButton();
        explanation_button.setBounds(850,0,144,49);
        explanation_button.setIcon(info_button_Icon);
        explanation_button.setText("About");
        explanation_button.setBackground(Color.lightGray);
        explanation_button.setBorder(BorderFactory.createEtchedBorder());
        explanation_button.addActionListener( e -> Gui.showRulesDialog());
        this.add(explanation_button);


        JButton acceleration_button = new JButton("Acceleration");
        acceleration_button.setBounds(709,0,144,49);
        acceleration_button.setBackground(Color.lightGray);
        acceleration_button.setBorder(BorderFactory.createEtchedBorder());
        acceleration_button.setIcon(acceleration_button_Icon);
        acceleration_button.addActionListener( e -> {
            SquareControl.check_acceleration_button+=1;
            if(SquareControl.check_acceleration_button%4==0)
            {
                MouseInteraction.setSpeedMultiplier(1);
                acceleration_button.setBackground(Color.lightGray);
            }
            else if(SquareControl.check_acceleration_button%4==1)
            {
                MouseInteraction.setSpeedMultiplier(2);
                acceleration_button.setBackground(Color.orange);
            }
            else if(SquareControl.check_acceleration_button%4==2)
            {
                MouseInteraction.setSpeedMultiplier(4);
                acceleration_button.setBackground(Color.yellow);
            }
            else if(SquareControl.check_acceleration_button%4==3)
            {
                MouseInteraction.setSpeedMultiplier(8);
                acceleration_button.setBackground(Color.GREEN);
            }
        });
        this.add(acceleration_button);


        JFrame shapesDialog = new JFrame();

        JButton shapes_button = new JButton("Shapes");
        shapes_button.setBounds(568,0,144,49);
        shapes_button.setBackground(Color.lightGray);
        shapes_button.setBorder(BorderFactory.createEtchedBorder());
        shapes_button.setIcon(shapes_button_Icon);
        shapes_button.addActionListener(e -> {
            shapesDialog.setTitle("Shapes");
            shapesDialog.setSize(400, 300);
            shapesDialog.setLayout(new GridLayout(4, 1));
            shapesDialog.setBackground(Color.lightGray);
            shapesDialog.setVisible(true);
        });
        this.add(shapes_button);

        JButton button = new JButton("Glider");
        button.setBounds(0,0,110,45);
        button.setBackground(Color.lightGray);
        button.setBorder(BorderFactory.createEtchedBorder());
        button.addActionListener( e -> {
            SquareControl.Square_clear(); //czyści caly array
            ReadFromFile.ReadFile(1); //odczytuje współrzędne żywych komórek
            shapesDialog.setVisible(false); //wyłącza okno po naciśnieciu na konkretną opcję

        });
        shapesDialog.add(button);

        JButton button_2 = new JButton("Spaceship");
        button_2.setBounds(120,0,110,45);
        button_2.setBackground(Color.lightGray);
        button_2.setBorder(BorderFactory.createEtchedBorder());
        button_2.addActionListener( e -> {
            SquareControl.Square_clear(); //czyści caly array
            ReadFromFile.ReadFile(2); //odczytuje współrzędne żywych komórek
            shapesDialog.setVisible(false); //wyłącza okno po naciśnieciu na konkretną opcję

        });
        shapesDialog.add(button_2);

        JButton button_3 = new JButton("Diamond");
        button_3.setBounds(120,0,110,45);
        button_3.setBackground(Color.lightGray);
        button_3.setBorder(BorderFactory.createEtchedBorder());
        button_3.addActionListener( e -> {
            SquareControl.Square_clear(); //czyści caly array
            ReadFromFile.ReadFile(3); //odczytuje współrzędne żywych komórek
            shapesDialog.setVisible(false); //wyłącza okno po naciśnieciu na konkretną opcję

        });
        shapesDialog.add(button_3);

        JButton button_4 = new JButton("Randomize (20%)");
        button_4.setBounds(120,0,110,45);
        button_4.setBackground(Color.lightGray);
        button_4.setBorder(BorderFactory.createEtchedBorder());
        button_4.addActionListener( e -> {
            SquareControl.Square_clear(); //czyści caly array
            SquareControl.Random_Generator(); //pojawia komórki w losowych miejscach
            shapesDialog.setVisible(false); //wyłącza okno po naciśnieciu na konkretną opcję

        });
        shapesDialog.add(button_4);


        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Arial", Font.BOLD, 12));
        graphics.drawString("Living \"squares\" count: " + liveCount, getWidth() - 200, 15);
        graphics.drawString("Simulation speed: x" + Math.pow(2, SquareControl.check_acceleration_button%4), getWidth() - 200, 30);
        graphics.drawString("Simulation age: " + SquareControl.Age_of_simulation , getWidth() - 200, 45);
        //powyższe 3 linijki generują teksty, które pokazują statystyki symulacji lub informują o ustawionych przez użytkownika parametrach

    }
}




