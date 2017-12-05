import java.awt.*;
import java.util.Random;

public class Maze
{
    public static final int CELL_WIDTH = 20; // Maze groeße
    public static final int MARGIN = 50; // buffer zwischen Maze und Window
    private int N;
    private Cell[] cells; // Array das alle Zellen im Maze enthält
    public Maze(int n)
    {
        N = n;
        cells = new Cell[N * N]; // generiert das Array der Zellen

        for (int i = 0; i < N * N; i++) // Array mit Zellen intialisieren
        {
            cells[i] = new Cell();
        }

        if(N > 0)
        {
            makeWalls(); // Updated die Wand informationen innerhalb eines Zellen Objekts.
            clearWalls(); // Entfernt eine Wand solange bis ein Maze geformt ist.

        }
    }

    public class Cell // Klasse die eine Zelle in einem Maze represäntiert.
    {
        int[] walls; // Array das die nördlichen, südlichen, östlichen und westlichen Wände beinhaltet

        public Cell()
        {
            walls = new int[4];
        }
    }

    final int NORTH = 0 ;
    final int SOUTH = 1 ;
    final int EAST = 2 ;
    final int WEST = 3 ;

    public void makeWalls() // füllt die wand informatationen in die Zellen, -1 stellt eine Außenwand dar.
    {
        for (int i = 0; i < N * N; i++) // nördliche, südliche, östliche und westliche wände festlegen
        {
            cells[i].walls[NORTH] = i - N;
            cells[i].walls[SOUTH] = i + N;
            cells[i].walls[EAST] = i + 1;
            cells[i].walls[WEST] = i - 1;
        }

        for (int i = 0; i < N; i++)
        {
            cells[i].walls[NORTH] = -1; // Grenze im Norden setzten, nördlicher wall auf -1
            cells[N * N - i - 1].walls[SOUTH] = -1; // Grenze im Süden setzten, südlicher wall auf -1
            // wall to -1
        }

        for (int i = 0; i < N * N; i += N)
        {
            cells[N * N - i - 1].walls[EAST] = -1; // Grenze im Osten setzten, östlicher wall auf -1
            cells[i].walls[WEST] = -1; // Grenze im Westen setzten, westlicher wall auf -1
        }
    }

    public void clearWalls() // Methode um Wände zu zerstören (um ein Maze zu formen)
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
            int cell1 = generator.nextInt(N * N); // zufällige zelle auswählen
            int wall = generator.nextInt(4);

            int cell2 = cells[cell1].walls[wall]; // zweite zufällige zelle auswählen

            if (cell2 != -1 && cell2 != N * N) // überprüfen ob zwischen den zwei zellen eine Wand existiert
            {
                if (ds.find(cell1) != ds.find(cell2)) // Wenn die Zellen nicht zum selben Set gehören
                {
                    cells[cell1].walls[wall] = N * N; // Zerstört die Wand zwischen diesen 2 Zellen,  N*N repräsentiert keine Wand

                    if (wall == NORTH || wall == EAST)
                    {
                        cells[cell2].walls[wall + 1] = N * N;
                    }
                    if (wall == SOUTH || wall == WEST)
                    {
                        cells[cell2].walls[wall - 1] = N * N;
                    }


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

                if (cells[count].walls[NORTH] != N * N) // Abfrage ob im Norden eine Wand existiert
                {
                    g.drawLine((i * CELL_WIDTH + MARGIN), (j * CELL_WIDTH + MARGIN),
                            ((i + 1) * CELL_WIDTH + MARGIN), (j * CELL_WIDTH + MARGIN));
                }

                if (cells[count].walls[SOUTH] != N * N) // Abfrage ob im Süden eine Wand existiert
                {
                    g.drawLine(i * CELL_WIDTH + MARGIN, (j + 1) * CELL_WIDTH
                            + MARGIN, (i + 1) * CELL_WIDTH + MARGIN, (j + 1) * CELL_WIDTH
                            + MARGIN);
                }

                if (cells[count].walls[EAST] != N * N) // Abfrage ob im Osten eine Wand existiert
                {
                    g.drawLine((i + 1) * CELL_WIDTH + MARGIN, j * CELL_WIDTH
                            + MARGIN, (i + 1) * CELL_WIDTH + MARGIN, (j + 1) * CELL_WIDTH
                            + MARGIN);
                }

                if (cells[count].walls[WEST] != N * N) // Abfrage ob im Westen eine Wand existiert
                {
                    g.drawLine(i * CELL_WIDTH + MARGIN, j * CELL_WIDTH + MARGIN, i
                            * CELL_WIDTH + MARGIN, (j + 1) * CELL_WIDTH + MARGIN);
                }
            }
        }
    }
}
