package Proj;

import java.util.Random;
/**
 * Klasa odpowiada za kontrole planszy
 */
public class SquareControl {
    /**
     *  tablica odpowidajaca za stan kwadratow(0-szary, 1-zielony)
     */
    public static int[][][] colourCoding = new int[81][46][2];
    /**
     *  zmienna ktora sprawdza czy trzeba obliczyc kolejny krok
     */
    public static int NextEvolution;
    /**
     *  zmienna która sprawdza czy symulacja ma być się wykonywać w określonym odstępie czasu
     */
    public static int Clicked_start=0;
    /**
     *  zmienna która sprawdza szybkość symulacji
     */
    public static int check_acceleration_button=0;
    /**
     *  zmienna która sprawdza ilość kroków symulacji
     */
    public static int Age_of_simulation=0;
    /**
     *  zmienna która zlicza kliknięcia myszy w całym oknie
     */
    public static int Sum_of_Mouse_Clicks=0;
    /**
     *  zmienna która zlicza kliknięcia myszy na planszy
     */
    public static int Sum_of_Mouse_Clicks_on_the_board=0;
    /**
     *  zmienna która zlicza kliknięcia myszy poza plansza
     */
    public static int Sum_of_Mouse_Clicks_outside_board=0;


    /**
     * Metoda odpowiada za wyczyszczenie planszy
     */
    static void Square_clear(){
        for (int i = 0; i <= 80; i++) {
            for (int j = 0; j <= 45; j++) {
                colourCoding[i][j][SquareControl.NextEvolution%2] = 0;
                colourCoding[i][j][(SquareControl.NextEvolution+1)%2] = 0;
            }

        }
    }

    /**
     * Metoda odpowiada za wypelnienie planszy w 20%
     */
    static void Random_Generator(){
        /*
          UpperBound Zmienna okresla zakres losowanej liczby
          RandomInt losuje zmienna od 0 do @param UpperBound(20%)
         */
        int UpperBound = 4;
        Random rand = new Random();
        int RandomInt;
        for (int i = 0; i <= 80; i++) {
            for (int j = 0; j <= 45; j++) {
                RandomInt = rand.nextInt(UpperBound);
                if(RandomInt==1) colourCoding[i][j][SquareControl.NextEvolution%2] = 1;
            }

        }

    }

    /**
     * Metoda odpowiada za liczenie nastepnego wygladu calej planszy
     */
    static void Next_step() {
        Age_of_simulation++;
        /*
          zmienna Neighbours zapisująca ile dana komórka ma sąsiadów
         */
        int Neighbours = 0;
        for (int i = 0; i <= 80; i++) {
            for (int j = 0; j <= 45; j++){

                if(i!=0 && i!=80 && j!=0 && j!=45) //sprawdza czy nie wychodzimy poza zakres array
                {
                    if(SquareControl.colourCoding[i+1][j-1][SquareControl.NextEvolution%2]==1) Neighbours++; //sprawdza ile komórka ma sąsiadów
                    if(SquareControl.colourCoding[i+1][j][SquareControl.NextEvolution%2]==1) Neighbours++;
                    if(SquareControl.colourCoding[i+1][j+1][SquareControl.NextEvolution%2]==1) Neighbours++;
                    if(SquareControl.colourCoding[i][j-1][SquareControl.NextEvolution%2]==1) Neighbours++;
                    if(SquareControl.colourCoding[i][j+1][SquareControl.NextEvolution%2]==1) Neighbours++;
                    if(SquareControl.colourCoding[i-1][j-1][SquareControl.NextEvolution%2]==1) Neighbours++;
                    if(SquareControl.colourCoding[i-1][j][SquareControl.NextEvolution%2]==1) Neighbours++;
                    if(SquareControl.colourCoding[i-1][j+1][SquareControl.NextEvolution%2]==1) Neighbours++;
                }
                else if(i==0)//sprawdza ile komórka ma sąsiadów na brzegach
                {
                    if(j==0)
                    {
                        if(SquareControl.colourCoding[i][j+1][SquareControl.NextEvolution%2]==1) Neighbours++;
                        if(SquareControl.colourCoding[i+1][j+1][SquareControl.NextEvolution%2]==1) Neighbours++;
                        if(SquareControl.colourCoding[i+1][j][SquareControl.NextEvolution%2]==1) Neighbours++;
                    }
                    else if(j==45)
                    {
                        if(SquareControl.colourCoding[i][j-1][SquareControl.NextEvolution%2]==1) Neighbours++;
                        if(SquareControl.colourCoding[i+1][j][SquareControl.NextEvolution%2]==1) Neighbours++;
                        if(SquareControl.colourCoding[i+1][j-1][SquareControl.NextEvolution%2]==1) Neighbours++;
                    }
                    else
                    {
                        if(SquareControl.colourCoding[i][j+1][SquareControl.NextEvolution%2]==1) Neighbours++;
                        if(SquareControl.colourCoding[i][j-1][SquareControl.NextEvolution%2]==1) Neighbours++;
                        if(SquareControl.colourCoding[i+1][j+1][SquareControl.NextEvolution%2]==1) Neighbours++;
                        if(SquareControl.colourCoding[i+1][j][SquareControl.NextEvolution%2]==1) Neighbours++;
                        if(SquareControl.colourCoding[i+1][j-1][SquareControl.NextEvolution%2]==1) Neighbours++;
                    }
                }
                else if(i==80)//sprawdza ile komórka ma sąsiadów na brzegach
                {
                    if(j==0)
                    {
                        if(SquareControl.colourCoding[i-1][j][SquareControl.NextEvolution%2]==1) Neighbours++;
                        if(SquareControl.colourCoding[i-1][j+1][SquareControl.NextEvolution%2]==1) Neighbours++;
                        if(SquareControl.colourCoding[i][j+1][SquareControl.NextEvolution%2]==1) Neighbours++;
                    }
                    else if(j==45)
                    {
                        if(SquareControl.colourCoding[i-1][j-1][SquareControl.NextEvolution%2]==1) Neighbours++;
                        if(SquareControl.colourCoding[i-1][j][SquareControl.NextEvolution%2]==1) Neighbours++;
                        if(SquareControl.colourCoding[i][j-1][SquareControl.NextEvolution%2]==1) Neighbours++;
                    }
                    else
                    {
                        if(SquareControl.colourCoding[i-1][j-1][SquareControl.NextEvolution%2]==1) Neighbours++;
                        if(SquareControl.colourCoding[i-1][j][SquareControl.NextEvolution%2]==1) Neighbours++;
                        if(SquareControl.colourCoding[i-1][j+1][SquareControl.NextEvolution%2]==1) Neighbours++;
                        if(SquareControl.colourCoding[i][j-1][SquareControl.NextEvolution%2]==1) Neighbours++;
                        if(SquareControl.colourCoding[i][j+1][SquareControl.NextEvolution%2]==1) Neighbours++;
                    }
                }
                else if(j==0)//sprawdza ile komórka ma sąsiadów na brzegach
                {
                    if(SquareControl.colourCoding[i+1][j][SquareControl.NextEvolution%2]==1) Neighbours++;
                    if(SquareControl.colourCoding[i+1][j+1][SquareControl.NextEvolution%2]==1) Neighbours++;
                    if(SquareControl.colourCoding[i][j+1][SquareControl.NextEvolution%2]==1) Neighbours++;
                    if(SquareControl.colourCoding[i-1][j][SquareControl.NextEvolution%2]==1) Neighbours++;
                    if(SquareControl.colourCoding[i-1][j+1][SquareControl.NextEvolution%2]==1) Neighbours++;
                }
                else //sprawdza ile komórka ma sąsiadów na brzegach
                {
                    if(SquareControl.colourCoding[i+1][j-1][SquareControl.NextEvolution%2]==1) Neighbours++;
                    if(SquareControl.colourCoding[i+1][j][SquareControl.NextEvolution%2]==1) Neighbours++;
                    if(SquareControl.colourCoding[i][j-1][SquareControl.NextEvolution%2]==1) Neighbours++;
                    if(SquareControl.colourCoding[i-1][j-1][SquareControl.NextEvolution%2]==1) Neighbours++;
                    if(SquareControl.colourCoding[i-1][j][SquareControl.NextEvolution%2]==1) Neighbours++;
                }

                if(SquareControl.colourCoding[i][j][SquareControl.NextEvolution%2]==1) { //co ma sie stać jeśli dana komórka jest 'żywa' w zależności od liczby sąsiadów
                    if (Neighbours < 2) SquareControl.colourCoding[i][j][(SquareControl.NextEvolution + 1)%2] = 0; //jeśli jest <2 sąsiadów komórka umiera
                    if (Neighbours == 2 || Neighbours == 3) SquareControl.colourCoding[i][j][(SquareControl.NextEvolution + 1)%2] = 1; //jeśli jest 2 lub 3 sąsiadów komórka ożywa
                    else if (Neighbours > 3) SquareControl.colourCoding[i][j][(SquareControl.NextEvolution + 1)%2] = 0; //jeśli jest >3 sąsiadów komórka umiera przez przeludnienie
                }
                else {//co ma sie stać jeśli dana komórka jest 'martwa' w zależności od liczby sąsiadów
                    if (Neighbours == 3) SquareControl.colourCoding[i][j][(SquareControl.NextEvolution + 1)%2] = 1; //jeśli jest 3 sąsiadów komórka ożywa
                    else SquareControl.colourCoding[i][j][(SquareControl.NextEvolution + 1)%2] = 0; //jeśli jest !3 sąsiadów komórka umiera
                }

                Neighbours=0; //zeruje zmienna by można ją wykorzystać dla kolejnej komórki w array colourCoding
            }
        }
        SquareControl.NextEvolution++; //przechodzi na kolejną plansze zmiennej array colourCoding

    }


}