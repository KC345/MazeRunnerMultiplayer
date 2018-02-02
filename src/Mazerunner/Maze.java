package Mazerunner;

import java.awt.*;
import java.util.Random;

public class Maze
{
    public static final int ZELLEN_BREITE = 20; // Maze groeße
    public static final int RAND = 50; // buffer zwischen Maze und Window
    private int N;
    private Zelle[] zellen; // Array das alle Zellen im Maze enthält
    public Maze(int n)
    {
        N = n;
        zellen = new Zelle[N * N]; // generiert das Array der Zellen

        for (int i = 0; i < N * N; i++) // Array mit Zellen intialisieren
        {
            zellen[i] = new Zelle();
        }

        if(N > 0)
        {
            makeWaende(); // Updated die Wand informationen innerhalb eines Zellen Objekts.
            clearWaende(); // Entfernt eine Wand solange bis ein Maze geformt ist.

        }
    }

    public class Zelle // Klasse die eine Zelle in einem Maze represäntiert.
    {
        int[] Waende; // Array das die nördlichen, südlichen, östlichen und Westenlichen Wände beinhaltet

        public Zelle()
        {
            Waende = new int[4];
        }
    }

    final int Norden = 0 ;
    final int Sueden = 1 ;
    final int Osten = 2 ;
    final int Westen = 3 ;

    public void makeWaende() // füllt die wand informatationen in die Zellen, -1 stellt eine Außenwand dar f
    {
        for (int i = 0; i < N * N; i++) // nördliche, südliche, östliche und Westenliche wände festlegen
        {
            zellen[i].Waende[Norden] = i - N;
            zellen[i].Waende[Sueden] = i + N;
            zellen[i].Waende[Osten] = i + 1;
            zellen[i].Waende[Westen] = i - 1;
        }

        for (int i = 0; i < N; i++)
        {
            zellen[i].Waende[Norden] = -1; // Grenze im Norden setzten, nördlicher wall auf -1
            zellen[N * N - i - 1].Waende[Sueden] = -1; // Grenze im Süden setzten, südlicher wall auf -1
            // wall to -1
        }

        for (int i = 0; i < N * N; i += N)
        {
            zellen[N * N - i - 1].Waende[Osten] = -1; // Grenze im Osten setzten, östlicher wall auf -1
            // wall to -1
            zellen[i].Waende[Westen] = -1; // Grenze im Westenen setzten, Westenlicher wall auf -1
        }
    }

    public void clearWaende() // Methode um Wände zu zerstören (um ein Maze zu formen)
    {
        int NumElements = N * N;

        DisjSets ds = new DisjSets(NumElements); // Erstellt einen Disjunkt um Zellen zu repräsentieren.
        for (int k = 0; k < N * N; k++)
        {
            ds.find(k); // Fügt jede Zelle zu einem eigenen Set hinzu
        }

        Random generator = new Random();
        while (ds.allConnected() == false) // Wird ausgeführt wenn nicht alle elemente im Set verbunden sind
        {
            int Zelle1 = generator.nextInt(N * N); // zufällige zelle auswählen
            int wall = generator.nextInt(4);

            int Zelle2 = zellen[Zelle1].Waende[wall]; // zweite zufällige zelle auswählen

            if (Zelle2 != -1 && Zelle2 != N * N) // überprüfen ob zwischen den zwei zellen eine Wand existiert
            {
                if (ds.find(Zelle1) != ds.find(Zelle2)) // Wenn die Zellen nicht zum selben Set gehören
                {
                    zellen[Zelle1].Waende[wall] = N * N; // Zerstört die Wand zwischen diesen 2 Zellen,  N*N repräsentiert keine Wand

                    if (wall == Norden || wall == Osten)
                    {
                        zellen[Zelle2].Waende[wall + 1] = N * N;
                    }
                    if (wall == Sueden || wall == Westen)
                    {
                        zellen[Zelle2].Waende[wall - 1] = N * N;
                    }
                    ds.union(ds.find(Zelle1), ds.find(Zelle2));

                }
            }
        }
    }

    public void draw(Graphics g) // Zeichnet das Maze
    {
        g.setColor(Color.BLACK);

        for (int i = 0; i < N; i++)
        {
            int count = i;
            for (int j = 0; j < N; j++)
            {
                if (j != 0)
                {
                    count += N;
                }

                if (zellen[count].Waende[Norden] != N * N) // Abfrage ob im Norden eine Wand existiert
                {
                    g.drawLine((i * ZELLEN_BREITE + RAND), (j * ZELLEN_BREITE + RAND),
                            ((i + 1) * ZELLEN_BREITE + RAND), (j * ZELLEN_BREITE + RAND));
                }

                if (zellen[count].Waende[Sueden] != N * N) // Abfrage ob im Süden eine Wand existiert
                {
                    g.drawLine(i * ZELLEN_BREITE + RAND, (j + 1) * ZELLEN_BREITE
                            + RAND, (i + 1) * ZELLEN_BREITE + RAND, (j + 1) * ZELLEN_BREITE
                            + RAND);
                }

                if (zellen[count].Waende[Osten] != N * N) // Abfrage ob im Osten eine Wand existiert
                {
                    g.drawLine((i + 1) * ZELLEN_BREITE + RAND, j * ZELLEN_BREITE
                            + RAND, (i + 1) * ZELLEN_BREITE + RAND, (j + 1) * ZELLEN_BREITE
                            + RAND);
                }

                if (zellen[count].Waende[Westen] != N * N) // Abfrage ob im Westenen eine Wand existiert
                {
                    g.drawLine(i * ZELLEN_BREITE + RAND, j * ZELLEN_BREITE + RAND, i
                            * ZELLEN_BREITE + RAND, (j + 1) * ZELLEN_BREITE + RAND);
                }
            }
        }
    }
}
