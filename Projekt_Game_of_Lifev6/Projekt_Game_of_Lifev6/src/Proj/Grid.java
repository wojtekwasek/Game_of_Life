package Proj;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;
import java.lang.Math;


public class Grid extends JPanel implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    private int liveCount = 0;

    public void paintComponent(Graphics graphics) { //metoda z biblioteki swing, która jest wywoływana wewnątrz programu, gdy zostanie stwierdzone, że owa operacja jest konieczna (źródło: https://stackoverflow.com/questions/15544549/how-does-paintcomponent-work)
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial", Font.BOLD, 12));
        graphics.setColor(new Color(150, 150, 150));
        graphics.fillRect(0, 0, 1280, 49);

        liveCount = 0;

        graphics.setColor(new Color(85, 85, 85)); //ustala kolor kwadratow
        for (int i = 0; i <= 80; i++) { // podzielilem rozdzielczosc x i y naszego okna(1280x720) na 16 czesci uzyskujac 80x45 kwadratow, petla zajmuje sie ich umiejscowieniem
            for (int j = 0; j <= 45; j++) {

                if (ColourCoding.colourCoding[i][j][ColourCoding.NextEvolution%2] % 2 == 0) {
                    graphics.setColor(new Color(85, 85, 85)); // ustala na jaki kolor zmmieni sie kwadrat kiedy uzytkownik wejdzie w interakcję z siatka
                    graphics.fillRect(i * 16, 50 + j * 16, 14, 14); // zastepuje podstawowy (szary kwadrat) zielonym kwadratem (tworzy go na nim)

                }
                if (ColourCoding.colourCoding[i][j][ColourCoding.NextEvolution%2] % 2 == 1) {
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
        //powyzsze 5 linijek tworza ikony dla danego przycisku

        JButton stop_button = new JButton();
        JButton start_button = new JButton();
        start_button.setBounds(0,0, 120,49);
        start_button.setIcon(start_button_Icon);
        start_button.setText("Start");
        start_button.setBackground(Color.lightGray);
        start_button.setBorder(BorderFactory.createEtchedBorder());
        start_button.addActionListener( e -> {
            ColourCoding.Clicked_start=1;
            start_button.setBackground(Color.GREEN);
            stop_button.setBackground(Color.lightGray);
        });
        this.add(start_button);


        //powyzsze komendy tworza przycisk w odpowiednim miejscu, ustawiaja jego kolor, napis, obramowanie oraz ikonę, dzieje sie tak samo dla stop, next i clear button

        stop_button.setBounds(121,0, 120,49);
        stop_button.setIcon(stop_button_Icon);
        stop_button.setText("Stop");
        stop_button.setBackground(Color.lightGray);
        stop_button.setBorder(BorderFactory.createEtchedBorder());
        stop_button.addActionListener( e -> {
            ColourCoding.Clicked_start=0;
            start_button.setBackground(Color.lightGray);
            stop_button.setBackground(Color.RED);
        });


        this.add(stop_button);

        JButton next_button = new JButton();
        next_button.setBounds(242,0, 120,49);
        next_button.setIcon(next_button_Icon);
        next_button.setText("Next");
        next_button.setBackground(Color.lightGray);
        next_button.setBorder(BorderFactory.createEtchedBorder());
        next_button.addActionListener( e -> {
            ColourCoding.Next_step();
        });

        this.add(next_button);

        JButton clear_button = new JButton();
        clear_button.setBounds(363,0,120,49);
        clear_button.setIcon(clear_button_Icon);
        clear_button.setText("Clear");
        clear_button.setBackground(Color.lightGray);
        clear_button.setBorder(BorderFactory.createEtchedBorder());

        clear_button.addActionListener( e-> {
            ColourCoding.NextEvolution=1;
            ColourCoding.Age_of_simulation=0;
            ColourCoding.Clicked_start=0;
            for (int i = 0; i <= 80; i++) {
                for (int j = 0; j <= 45; j++) {


                    ColourCoding.colourCoding[i][j][ColourCoding.NextEvolution%2] = 0; // powyzsza petla zmienia wartosc wszystkich pol na 0, czyli gasi wszystkie zapalone kwadraty
                    ColourCoding.colourCoding[i][j][(ColourCoding.NextEvolution+1)%2] = 0;


                }

            }


        });
        this.add(clear_button);



        JButton explanation_button = new JButton();
        explanation_button.setBounds(484,0,120,49);
        explanation_button.setIcon(info_button_Icon);
        explanation_button.setText("About");
        explanation_button.setBackground(Color.lightGray);
        explanation_button.setBorder(BorderFactory.createEtchedBorder());
        explanation_button.addActionListener( e -> {
            Gui.showRulesDialog();
        });
        this.add(explanation_button);


        //AtomicInteger x2_button_pomocnicza= new AtomicInteger();
        JButton x2_button = new JButton("Acceleration");
        x2_button.setBounds(605,0,120,49);
        x2_button.setBackground(Color.lightGray);
        x2_button.setBorder(BorderFactory.createEtchedBorder());
        x2_button.addActionListener( e -> {
            ColourCoding.x2_button_pomocnicza+=1;
            if(ColourCoding.x2_button_pomocnicza%5==0)
            {
                Mouse_Inter_1.setSpeedMultiplier(1);
                x2_button.setBackground(Color.lightGray);
            }
            else if(ColourCoding.x2_button_pomocnicza%5==1)
            {
                Mouse_Inter_1.setSpeedMultiplier(2);
                x2_button.setBackground(Color.orange);
            }
            else if(ColourCoding.x2_button_pomocnicza%5==2)
            {
                Mouse_Inter_1.setSpeedMultiplier(4);
                x2_button.setBackground(Color.yellow);
            }
            else if(ColourCoding.x2_button_pomocnicza%5==3)
            {
                Mouse_Inter_1.setSpeedMultiplier(8);
                x2_button.setBackground(Color.GREEN);
            }
            else
            {
                Mouse_Inter_1.setSpeedMultiplier(16);
                x2_button.setBackground(Color.blue);
            }
        });
        this.add(x2_button);

        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Arial", Font.BOLD, 12));
        graphics.drawString("Liczba \"żywych\" kwadratów: " + liveCount, getWidth() - 200, 15);
        graphics.drawString("Szybkość symulacji: x" + Math.pow(2,ColourCoding.x2_button_pomocnicza%5), getWidth() - 200, 30);
        graphics.drawString("Wiek symulacji: " +ColourCoding.Age_of_simulation , getWidth() - 200, 45);




    }



}
