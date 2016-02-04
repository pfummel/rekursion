/**
Klasse Pathfinder
@author David Nancekievill MATRIKELNUMMER Gruppe 9c
@author Markus Berning MATRIKELNUMMER Gruppe 9c
*/

import java.util.Arrays;

public class Pathfinder implements Simple {
    
    /*
    Pathfinder() {
    }
    */   
    
    private char[][] map;
    
    private int[][] priority;
    
    private int xStart, yStart, xGoal, yGoal = 0;
    
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
                    System.out.println(xGoal);
                    System.out.println(yGoal);
                }
            }
        }
        
        initPriority();
        move(xStart, yStart);
        
        return toString();
    }
    
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
    
    private void move(int x, int y) {

   
        boolean validMove = false;
    
        this.priority[x][y] = 1;
        
        
        //Fragt nach dem Ziel
        validMove = isGoal(x, y, validMove);
             
        //Fragt nach 0 in den umliegenden Feldern.
        validMove = isZero(x, y, validMove);
        
        //Fragt nach 1 und "schon besucht" in den umliegenden Feldern.
        validMove = isOne(x, y, validMove);
        
        /*
        
        //Fragt nach dem Ziel
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
        
        //Fragt nach Zero
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
        
        //Fragt nach 1 und schon besucht
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
         */
    }
    
    public void setMap(char[][] map) {
        this.map = map;
    }
    
    public char[][] getMap() {
        return this.map;
    }


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
