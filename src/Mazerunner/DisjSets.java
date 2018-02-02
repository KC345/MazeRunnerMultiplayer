package Mazerunner;

/**
 * Disjoint set Klasse benutzt union by rank und Pfad kompression.
 * Elemente in den sets beginnen mit 0.
 */
public class DisjSets
{
    /**
     * Konstruktor der benötigten Objekte
     * @param numElements nummer der disjoint sets
     */
    public DisjSets( int numElements )
    {
        s = new int [ numElements ];
        for( int i = 0; i < s.length; i++ )
            s[ i ] = -1;
    }

    /**
     * Vereinige zwei disjoint sets mit der Höhenheuristik.
     * @param root1 Wurzel von set 1.
     * @param root2 Wurzel von set 2.
     */
    public void union( int root1, int root2 )
    {
        if( s[ root2 ] < s[ root1 ] )  // root2 ist tiefer
            s[ root1 ] = root2;        // root2 zur neuen Wurzel machen
        else
        {
            if( s[ root1 ] == s[ root2 ] )
                s[ root1 ]--;          // Update von height wenn gleich
            s[ root2 ] = root1;        // root1 neue Wurzel
        }
    }

    /**
     * Suche mit Pfadkomprimierung.
     * @param x Element nach dem gesucht wird.
     * @return das set welches x enthält.
     */
    public int find( int x )
    {
        if( s[ x ] < 0 )
            return x;
        else
            return s[ x ] = find( s[ x ] );
    }

    public int [ ] s;

    /**
     *Prüfen ob alle Elemente im selben set sind
     * @return true wenn ja, false wenn nicht der Fall
     */
    public boolean allConnected()
    {
        int count = 0 ;
        for(int i = 0 ; i < s.length ; i++)
        {
            if(s[i] < 0)
            {
                count++ ;
            }
            if(count > 1)
            {
                return false ;
            }
        }

        return true ;
    }
}
