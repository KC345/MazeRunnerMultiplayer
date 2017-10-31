/*
 * Maze.java
 * Author: Irene Alvarado
 * Maze object that creates a maze using a
 * disjoint set representing cells and running a modified version of Kruskal's
 * algorithm to remove walls. In the end, the maze walls are drawn as well as a
 * unique path in red dots.
 */
import java.awt.*;
import java.util.Random;

public class Maze
{
    public static final int CELL_WIDTH = 20; // maze square size
    public static final int MARGIN = 50; // buffer between window edge and maze
    private int N;
    private Cell[] cells; // array containing all the cells in the maze


    public Maze(int n)
    {
        N = n;
        cells = new Cell[N * N]; // creates array of Cells

        for (int i = 0; i < N * N; i++) // initializes array with Cell objects
        {
            cells[i] = new Cell();
        }

        if(N > 0)
        {
            makeWalls(); // updates wall information inside each Cell object
            clearWalls(); // destoys wall until a maze is formed
            
        }
    }

    public class Cell // Class representing a cell in a maze.
    {
        int[] walls; // array representing north, south, east, west walls
        int visitedBy; // for running first breath search, saves the cell that
        // visited this cell

        public Cell()
        {
            walls = new int[4];
            visitedBy = -1;
        }
    }

    final int NORTH = 0 ;
    final int SOUTH = 1 ;
    final int EAST = 2 ;
    final int WEST = 3 ;

    public void makeWalls() // fills wall information in Cells, -1 represents a
    // border wall
    {
        for (int i = 0; i < N * N; i++) // set north,south,east,west walls
        {
            cells[i].walls[NORTH] = i - N;
            cells[i].walls[SOUTH] = i + N;
            cells[i].walls[EAST] = i + 1;
            cells[i].walls[WEST] = i - 1;
        }

        for (int i = 0; i < N; i++)
        {
            cells[i].walls[NORTH] = -1; // set in border north cells, north wall to -1
            cells[N * N - i - 1].walls[SOUTH] = -1; // set in border south cells, south
            // wall to -1
        }
        for (int i = 0; i < N * N; i += N)
        {
            cells[N * N - i - 1].walls[EAST] = -1; // set in border east cells, east
            // wall to -1
            cells[i].walls[WEST] = -1; // set in border west cells, west wall to -1
        }
    }

    public void clearWalls() // destroys walls with a modified version of
    // Kruskal's algorithm
    {
        int NumElements = N * N;

        DisjSets ds = new DisjSets(NumElements); // creates a disjoint set to
        // represent cells
        for (int k = 0; k < N * N; k++)
        {
            ds.find(k); // adds each cell to a single set
        }

        Random generator = new Random();
        while (ds.allConnected() == false) // while not all the elements in the
        // set are connected
        {
            int cell1 = generator.nextInt(N * N); // pick a random cell
            int wall = generator.nextInt(4);

            int cell2 = cells[cell1].walls[wall]; // pick a second random cell

            if (cell2 != -1 && cell2 != N * N) // if there exists a wall between
            // these two cells
            {
                if (ds.find(cell1) != ds.find(cell2)) // if cells do not belong to
                // the same set
                {
                    cells[cell1].walls[wall] = N * N; // destroy the wall between
                    // these two cells. N*N will
                    // represent no wall

                    if (wall == NORTH || wall == EAST)
                    {
                        cells[cell2].walls[wall + 1] = N * N;
                    }
                    if (wall == SOUTH || wall == WEST)
                    {
                        cells[cell2].walls[wall - 1] = N * N;
                    }

                    ds.union(ds.find(cell1), ds.find(cell2)); // make a union of the
                    // set of these two cells, through which a path has just been
                    // created
                }
            }
        }
    }

    public void draw(Graphics g) // draws a maze and its solution
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

                if (cells[count].walls[NORTH] != N * N) // if there exists a wall to the
                // north
                {
                    g.drawLine((i * CELL_WIDTH + MARGIN), (j * CELL_WIDTH + MARGIN),
                            ((i + 1) * CELL_WIDTH + MARGIN), (j * CELL_WIDTH + MARGIN));
                }

                if (cells[count].walls[SOUTH] != N * N) // if there exists a wall to the
                // south
                {
                    g.drawLine(i * CELL_WIDTH + MARGIN, (j + 1) * CELL_WIDTH
                            + MARGIN, (i + 1) * CELL_WIDTH + MARGIN, (j + 1) * CELL_WIDTH
                            + MARGIN);
                }

                if (cells[count].walls[EAST] != N * N) // if there exists a wall to the
                // east
                {
                    g.drawLine((i + 1) * CELL_WIDTH + MARGIN, j * CELL_WIDTH
                            + MARGIN, (i + 1) * CELL_WIDTH + MARGIN, (j + 1) * CELL_WIDTH
                            + MARGIN);
                }

                if (cells[count].walls[WEST] != N * N) // if there exists a wall to the
                // west
                {
                    g.drawLine(i * CELL_WIDTH + MARGIN, j * CELL_WIDTH + MARGIN, i
                            * CELL_WIDTH + MARGIN, (j + 1) * CELL_WIDTH + MARGIN);
                }
            }
        }
    }
}