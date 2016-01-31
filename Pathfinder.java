/**
Klasse Pathfinder
@author David Nancekievill MATRIKELNUMMER Gruppe 9c
@author Markus Berning MATRIKELNUMMER Gruppe 9c
*/
public class Pathfinder implements Simple {

    Pathfinder() {
    }    
    
    private char[][] map;
    
    private int int xStart, yStart, xGoal, yGoal = 0;
    
    public String searchPath(char start, char goal) {
        
        /*
        Ermittelt die Koordinaten der Anfangs- und Endpunkte
        */
        int i, j = 0;
        
        for ( ; i < map.length; i++) {
            for ( ; j < map.length; j++) {
                if (map[i][j] == start) {
                    this.xStart = i;
                    this.yStart = j;
                }
                if (map[i][j] == goal) {
                    this.xGoal = i;
                    this.yGoal = j;
                }
            }
        }
        
        
        
        return;
    }
    
    public void setMap(char[][] map) {
        this.map = map;
    }
    
    public char[][] getMap() {
        return this.map;
    }    
}
