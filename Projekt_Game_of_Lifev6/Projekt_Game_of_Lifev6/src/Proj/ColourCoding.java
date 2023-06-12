package Proj;

public class ColourCoding {
    public static int[][][] colourCoding = new int[81][46][2]; //tablica odpowidajaca za stan kwadratow(0-szary, 1-zielony)
    public static int NextEvolution; //zmienna ktora sprawdza czy trzeba obliczyc kolejny krok
    public static int Clicked_start=0;
    public static int x2_button_pomocnicza=0;
    public static int Age_of_simulation=0;

    static void Next_step() {
        Age_of_simulation++;
        int Neighbours = 0; //zmienna zapisująca ile dana komórka ma sąsiadów
        for (int i = 0; i <= 80; i++) {
            for (int j = 0; j <= 45; j++){ //for dla i,j przechodzi przez cały array zmiennej colourCoding

                if(i!=0 && i!=80 && j!=0 && j!=45) //sprawdza czy nie wychodzimy poza zakres array
                {
                    if(ColourCoding.colourCoding[i+1][j-1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    if(ColourCoding.colourCoding[i+1][j][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    if(ColourCoding.colourCoding[i+1][j+1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    if(ColourCoding.colourCoding[i][j-1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    if(ColourCoding.colourCoding[i][j+1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    if(ColourCoding.colourCoding[i-1][j-1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    if(ColourCoding.colourCoding[i-1][j][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    if(ColourCoding.colourCoding[i-1][j+1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                }
                else if(i==0)//sprawdza czy nie wychodzimy poza zakres array
                {
                    if(j==0)
                    {
                        if(ColourCoding.colourCoding[i][j+1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                        if(ColourCoding.colourCoding[i+1][j+1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                        if(ColourCoding.colourCoding[i+1][j][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    }
                    else if(j==45)
                    {
                        if(ColourCoding.colourCoding[i][j-1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                        if(ColourCoding.colourCoding[i+1][j][ColourCoding.NextEvolution%2]==1) Neighbours++;
                        if(ColourCoding.colourCoding[i+1][j-1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    }
                    else
                    {
                        if(ColourCoding.colourCoding[i][j+1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                        if(ColourCoding.colourCoding[i][j-1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                        if(ColourCoding.colourCoding[i+1][j+1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                        if(ColourCoding.colourCoding[i+1][j][ColourCoding.NextEvolution%2]==1) Neighbours++;
                        if(ColourCoding.colourCoding[i+1][j-1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    }
                }
                else if(i==80)//sprawdza czy nie wychodzimy poza zakres array
                {
                    if(j==0)
                    {
                        if(ColourCoding.colourCoding[i-1][j][ColourCoding.NextEvolution%2]==1) Neighbours++;
                        if(ColourCoding.colourCoding[i-1][j+1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                        if(ColourCoding.colourCoding[i][j+1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    }
                    else if(j==45)
                    {
                        if(ColourCoding.colourCoding[i-1][j-1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                        if(ColourCoding.colourCoding[i-1][j][ColourCoding.NextEvolution%2]==1) Neighbours++;
                        if(ColourCoding.colourCoding[i][j-1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    }
                    else
                    {
                        if(ColourCoding.colourCoding[i-1][j-1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                        if(ColourCoding.colourCoding[i-1][j][ColourCoding.NextEvolution%2]==1) Neighbours++;
                        if(ColourCoding.colourCoding[i-1][j+1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                        if(ColourCoding.colourCoding[i][j-1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                        if(ColourCoding.colourCoding[i][j+1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    }
                }
                else if(j==0)
                {
                    if(ColourCoding.colourCoding[i+1][j][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    if(ColourCoding.colourCoding[i+1][j+1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    if(ColourCoding.colourCoding[i][j+1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    if(ColourCoding.colourCoding[i-1][j][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    if(ColourCoding.colourCoding[i-1][j+1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                }
                else
                {
                    if(ColourCoding.colourCoding[i+1][j-1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    if(ColourCoding.colourCoding[i+1][j][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    if(ColourCoding.colourCoding[i][j-1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    if(ColourCoding.colourCoding[i-1][j-1][ColourCoding.NextEvolution%2]==1) Neighbours++;
                    if(ColourCoding.colourCoding[i-1][j][ColourCoding.NextEvolution%2]==1) Neighbours++;
                }

                if(ColourCoding.colourCoding[i][j][ColourCoding.NextEvolution%2]==1) { //co ma sie stać jeśli dana komórka jest 'żywa' w zależności od liczby sąsiadów
                    if (Neighbours < 2) ColourCoding.colourCoding[i][j][(ColourCoding.NextEvolution + 1)%2] = 0;
                    if (Neighbours == 2 || Neighbours == 3) ColourCoding.colourCoding[i][j][(ColourCoding.NextEvolution + 1)%2] = 1;
                    else if (Neighbours > 3) ColourCoding.colourCoding[i][j][(ColourCoding.NextEvolution + 1)%2] = 0;
                }
                else {//co ma sie stać jeśli dana komórka jest 'martwa' w zależności od liczby sąsiadów
                    if (Neighbours == 3) ColourCoding.colourCoding[i][j][(ColourCoding.NextEvolution + 1)%2] = 1;
                    else ColourCoding.colourCoding[i][j][(ColourCoding.NextEvolution + 1)%2] = 0;
                }

                Neighbours=0; //zeruje zmienna by można ją wykorzystać dla kolejnej komórki w array colourCoding
            }
        }
        ColourCoding.NextEvolution++; //przechodzi na kolejną plansze zmiennej array colourCoding
    }
}