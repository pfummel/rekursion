/**
Interface für die Methoden searchPath und setMap. 
@author David Nancekievill MATRIKELNUMMER Gruppe 9c
@author Markus Berning MATRIKELNUMMER Gruppe 9c
*/
public interface Simple {
    
    /**
    Methode die rekursiv einen Weg von start nach goal finden soll.
    @param start Anfangszeichen des Weges
    @param goal Endzeichen des Weges
    @return String Gibt das Labyrinth mit dem gefundenen Weg aus.
    */
    public String searchPath(char start, char goal);
    
    /**
    Methode die ein 2x2 Array uebergeben bekommt und so die Map setzen kann.
    @param map 2 dimensionales char-Array welches die map enthaelt.
    */
    public void setMap(char[][] map);
}