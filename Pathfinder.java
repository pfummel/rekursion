/**
Klasse Pathfinder
@author David Nancekievill MATRIKELNUMMER Gruppe 9c
@author Markus Berning MATRIKELNUMMER Gruppe 9c
*/

import java.util.Arrays;

public class Pathfinder implements Simple {
   
    /**
     *Zweidimensionales char-Array welches map enthaelt. 
     */	
    private char[][] map;
   
   /**
    * Zweidimensionales char-Array welches die Bewegungsprioritaet enthaelt.
    */ 
    private int[][] priority;
    
    /**
     * Integervariablen fuer die Koordinaten des Starts und des Ziels.
     */
    private int xStart, yStart, xGoal, yGoal = 0;
    
    /**
     * Methode die die Wegfindung einleitet.
     * @param start Der char des Starts
     * @param goal Der char des Ziels
     * @return Gibt den gefundenen Weg in der Map als String zurueck.
     */
    public String searchPath(char start, char goal) {
        
        /*
        Ermittelt die Koordinaten der Anfangs- und Endpunkte
        */
 
        for (int i = 0 ; i < map.length; i++) {
            for (int j = 0 ; j < map[0].length; j++) {
                if (map[i][j] == start) {
                    this.xStart = i;
                    this.yStart = j;
                    
                }
                if (map[i][j] == goal) {
                    this.xGoal = i;
                    this.yGoal = j;
                    //System.out.println(xGoal);
                    //System.out.println(yGoal);
                }
            }
        }
        
        initPriority();
	
        move(xStart, yStart);
        
        return toString();
    }
   /**
    * Initialisiert das Priorityfeld, 3 fuer Waende, 0 fuer freien Weg,
    * das Ziel hat die Prioritaet 2, bereits besuchte Felder tragen die
    * Prioritaet 1.
    */ 
    private void initPriority() {
        
        this.priority = new int[map.length][map[0].length];
        
        for (int i = 0 ; i < map.length; i++) {
            for (int j = 0 ; j < map[0].length; j++) {
                if (this.map[i][j] == '#') {
                    this.priority[i][j] = 3;
                }
                if (this.map[i][j] == ' ') {
                    this.priority[i][j] = 0;
                }                
            }
        }
        this.priority[this.xStart][this.yStart] = 0;
        this.priority[this.xGoal][this.yGoal] = 2;
    }

    /**
     * Fuehrt die Bewegung in Map aus und wird von den isMethoden
     * rekursive aufgerufen.
     * @param x Die X Koordinate der naechsten Bewegung
     * @param y Die Y Koordinate der naechsten Bewegung
     */
    private void move(int x, int y) {
   
        boolean validMove = false;
    
        this.priority[x][y] = 1;
        
        //Fragt nach dem Ziel
        validMove = isGoal(x, y, validMove);
             
        //Fragt nach 0 in den umliegenden Feldern.
        validMove = isZero(x, y, validMove);
        
        //Fragt nach 1 und "schon besucht" in den umliegenden Feldern.
        validMove = isOne(x, y, validMove);
        
    }
    
    /**
     * Setzt die von ausserhalb der Klasse uebergebene map.
     */
    public void setMap(char[][] map) {
        this.map = map;
    }
    
    /**
     * Git die Karte zurueck.
     * @return Die aktuelle map.
     */
    public char[][] getMap() {
        return this.map;
    }

    /**
     * Ueberschreibt die toString Methode des Objektes und gibt
     * die map als String kodiert zurueck.
     */
    public String toString() {
    
        String mapToString = "\n";
        for (int i = 0; i < map.length; i++) {
            for (int n = 0; n < map[0].length; n++) {
                mapToString += map[i][n];
                if (n == map[0].length - 1) {
                    mapToString += "\n";
                }
            }
        }
        mapToString += "\n";
        return mapToString;
    }
    
    /**
     * Ueberprueft ob das Ziel auf einem der naechsten Felder liegt
     * und bewegt sich dann dorthin.
     * @param x X Koordinate der naechsten Bewegung
     * @param y Y Koordinate der naechsten Bewegung
     * @param validMove Boolean ob bereits ein gueltiger Zug gemacht wurde.
     * @return Gibt validMove zurueck, je nachdem  ob ein gueltiger Zug gemacht
     * wurde oder nicht.
     */
    private boolean isGoal(int x, int y, boolean validMove) {
        
         if(validMove == false && ((x + 1) < this.map.length)) {
            if(this.priority[x + 1][y] == 2) {
                this.map[x][y] = '.';
                
                validMove = true;
            }
        }
        if(validMove == false && x - 1 > 0) {
            if(this.priority[x - 1][y] == 2) {
                this.map[x][y] = '.';
                validMove = true;
            }
        }
        if(validMove == false && y + 1 < this.map[0].length) {
            if(this.priority[x][y + 1] == 2) {
                this.map[x][y] = '.';

                validMove = true;
            }
        }
        if(validMove == false && y - 1 > 0) {
            if(this.priority[x][y - 1] == 2) {
                this.map[x][y] = '.';
                
                validMove = true;
            }
        }
        
        return validMove;
    }
    
    /**
     * Fragt ob auf den umliegenden Feldern eine '0' liegt und bewegt sich dann
     * dorthin.  
     * @param x X Koordinate der naechsten Bewegung
     * @param y Y Koordinate der naechsten Bewegung
     * @param validMove Boolean ob bereits ein gueltiger Zug gemacht wurde.
     * @return Gibt validMove zurueck, je nachdem  ob ein gueltiger Zug gemacht
     * wurde oder nicht.
     */
    private boolean isZero(int x, int y, boolean validMove) {
        
        if(validMove == false && x + 1 < this.map.length) {
            if(this.priority[x + 1][y] == 0) {
                
                if (!(x == xStart && y == yStart)) { 
                    this.map[x][y] = '.';
                }
                
                validMove = true;
                move(x + 1, y);
            }
        }
        if(validMove == false && x - 1 > 0) {
            if(this.priority[x - 1][y] == 0) {
                
                if (!(x == xStart && y == yStart)) { 
                    this.map[x][y] = '.';
                }
                
                validMove = true;
                move(x - 1, y);
            }
        }
        if(validMove == false && y + 1 < this.map[0].length) {
            if(this.priority[x][y + 1] == 0) {
                
                if (!(x == xStart && y == yStart)) { 
                    this.map[x][y] = '.';
                }
                
                validMove = true;
                move(x, y + 1);
            }
        }
        if(validMove == false && y - 1 > 0) {
            if(this.priority[x][y - 1] == 0) {
                
                if (!(x == xStart && y == yStart)) { 
                    this.map[x][y] = '.';
                }
                
                validMove = true;
                move(x, y - 1);         
            }
        }
        return validMove;
    }
    
   /**
    * Fragt ob auf den umliegenden Feldern ein '1' liegt und bewegt sich dann
    * dorthin.    
    * @param x X Koordinate der naechsten Bewegung
    * @param y Y Koordinate der naechsten Bewegung
    * @param validMove Boolean ob bereits ein gueltiger Zug gemacht wurde.
    * @return Gibt validMove zurueck, je nachdem  ob ein gueltiger Zug gemacht
    * wurde oder nicht.
    */ 
    private boolean isOne(int x, int y, boolean validMove) {
        
        if(validMove == false && x + 1 < this.map.length) {
            if(this.priority[x + 1][y] == 1 && this.map[x + 1][y] == '.') {
                this.map[x][y] = ' ';
                
                validMove = true;
                move(x + 1, y);         
            }
        }
        if(validMove == false && x - 1 > 0) {
            if(this.priority[x - 1][y] == 1 && this.map[x - 1][y] == '.') {
                this.map[x][y] = ' ';
                
                validMove = true;
                move(x - 1, y);
            }
        }
        if(validMove == false && y + 1 < this.map[0].length) {
            if(this.priority[x][y + 1] == 1 && this.map[x][y + 1] == '.') {
                this.map[x][y] = ' ';
                
                validMove = true;
                move(x, y + 1);            
            }
        }
        if(validMove == false && y - 1 > 0) {
            if(this.priority[x][y - 1] == 1 && this.map[x][y - 1] == '.') {
                this.map[x][y] = ' ';
                
                validMove = true;
                move(x, y - 1);            
            }
        }
        return validMove;
    }    
}
