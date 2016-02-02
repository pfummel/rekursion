/**
Klasse Test
@author David Nancekievill MATRIKELNUMMER Gruppe 9c
@author Markus Berning MATRIKELNUMMER Gruppe 9c
*/
public class Test {
    public static void main(String[] args) {
    
    char[][] map = {{'#','#','#','#','#'},
                    {'#','S','#',' ',' '},
                    {'#',' ',' ',' ','#'},
                    {'#',' ','#',' ','#'},
                    {'#','#','#','X','#'}};
    Pathfinder pf = new Pathfinder();
    pf.setMap(map);
    System.out.println(pf.searchPath('S','X'));
    }
}
