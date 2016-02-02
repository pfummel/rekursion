/**
Klasse Pathfinder
@author David Nancekievill MATRIKELNUMMER Gruppe 9c
@author Markus Berning MATRIKELNUMMER Gruppe 9c
*/
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
        int i = 0, j = 0;
        
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
        
        initPriority();
        
        move(xStart, yStart);
        
        return "Es wurde ein Weg gefunden!";
    }
    
    private void initPriority() {
        
        int i = 0, j = 0;
        
        this.priority = new int[map.length][map[0].length];
        
        for ( ; i < map.length; i++) {
            for ( ; j < map.length; j++) {
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
        
        while(validMove == false) {
            if(this.priority[x][y] == 2) {
                System.out.println("Ein Weg wurde gefunden.");
            }
        }
        
        //Fragt nach 0 in den umliegenden Feldern.
        while(validMove == false) {
            if(this.priority[x + 1][y] == 0) {
                
                if (!(x == xStart && y == yStart)) { 
                    this.map[x][y] = '.';
                }
                
                validMove = true;         
                move(x + 1, y);            
            }
        }
        
        while(validMove == false) {
            if(this.priority[x - 1][y] == 0) {
                
                if (!(x == xStart && y == yStart)) { 
                    this.map[x][y] = '.';
                }
                
                validMove = true;
                move(x - 1, y);            
            }
        }
        
        while(validMove == false) {
            if(this.priority[x][y + 1] == 0) {
                
                if (!(x == xStart && y == yStart)) { 
                    this.map[x][y] = '.';
                }
                
                validMove = true;
                move(x, y + 1);            
            }
        }
        
        while(validMove == false) {
            if(this.priority[x][y - 1] == 0) {
                
                if (!(x == xStart && y == yStart)) { 
                    this.map[x][y] = '.';
                }
                
                validMove = true;
                move(x, y - 1);            
            }
        }
        
        //Fragt nach 1 und "schon besucht" in den umliegenden Feldern.
        
        while(validMove == false) {
            if(this.priority[x + 1][y] == 1 && this.map[x + 1][y] == '.') {
                this.map[x][y] = ' ';
                
                validMove = true;
                move(x + 1, y);            
            }
        }
        
        while(validMove == false) {
            if(this.priority[x - 1][y] == 1 && this.map[x - 1][y] == '.') {
                this.map[x][y] = ' ';
                
                validMove = true;
                move(x - 1, y);            
            }
        }
        
        while(validMove == false) {
            if(this.priority[x][y + 1] == 1 && this.map[x][y + 1] == '.') {
                this.map[x][y] = ' ';
                
                validMove = true;
                move(x, y + 1);            
            }
        }
        
        while(validMove == false) {
            if(this.priority[x][y - 1] == 1 && this.map[x][y - 1] == '.') {
                this.map[x][y] = ' ';
                
                validMove = true;
                move(x, y - 1);            
            }
        }
    }
    
    public void setMap(char[][] map) {
        this.map = map;
    }
    
    public char[][] getMap() {
        return this.map;
    }    
}
