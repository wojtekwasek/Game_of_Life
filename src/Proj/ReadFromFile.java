package Proj;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Klasa {@code ReadFromFile} jest odpowiedzialna za odczyt danych z plików tekstowych
 * i zapisanie ich do odpowiednich tablic w klasie {@code SquareControl}.
 */
public class ReadFromFile {

    /**
     * Odczytuje zawartość pliku tekstowego i zapisuje ją do odpowiadających tablic w klasie {@code SquareControl}.
     *
     * @param a liczba całkowita reprezentująca numer pliku do odczytu.
     */
    public static void ReadFile(int a) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader("Shape"+a+".txt"));


            String line;

            while ((line = reader.readLine()) != null) {
                String[] cords = line.split(" ");

                int x_value = Integer.parseInt(cords[0]);
                int y_value = Integer.parseInt(cords[1]);

                SquareControl.colourCoding[x_value][y_value][(SquareControl.NextEvolution)%2]= 1;

            }
            reader.close();


        } catch (IOException e) {

            e.printStackTrace();
        }



    }


}
