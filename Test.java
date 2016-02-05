/**
Klasse Test
@author David Nancekievill MATRIKELNUMMER Gruppe 9c
@author Markus Berning MATRIKELNUMMER Gruppe 9c
*/
public class Test {
    /**
     * main Methode. Objekt Pathfinder wird erstellt und bekommt 
     * eine definierte map uebergeben. Der gefundene Weg wird aus-
     * gegeben.
     * @param args Standardparameter
     */
    public static void main(String[] args) {
        
        char[][] map = {{'#', '#', '#', '#', '#'},
                        {'#', 'S', '#', ' ', ' '},
                        {' ', ' ', ' ', ' ', '#'},
                        {' ', ' ', '#', ' ', '#'},
                        {' ', ' ', '#', ' ', ' '},
                        {'#', '#', '#', ' ', '#'},
                        {'#', ' ', ' ', ' ', '#'},
                        {'#', 'X', '#', ' ', '#'}};
        Pathfinder pf = new Pathfinder();
        pf.setMap(map);
        System.out.println(pf.searchPath('S', 'X'));
    }
}
