/*
 utile per ottenere chi pertecipa con quale barca a che gara
 */
package prova_scene_builder;

/**
 *
 * @author alex
 */
public class Race {
    /**
     * fk_competition, conterrà l'id della competizione
     * fk_boat, conterrà l'id della barca iscritta alla relativa gara
     */
    int fk_competition,fk_boat;

    /**
     * costruttore di race, dal momento in cui un socio si registra ad una competizione
     * @param fk_competition
     * @param fk_boat 
     */
    public Race(int fk_competition, int fk_boat) {
        this.fk_competition = fk_competition;
        this.fk_boat = fk_boat;
    }

    /**
     * ritorna id della competizione
     * @return fk_competition
     */
    public int getFk_competition() {
        return fk_competition;
    }

    /**
     * setta l'id della competizione
     * @param fk_competition 
     */
    public void setFk_competition(int fk_competition) {
        this.fk_competition = fk_competition;
    }

    /**
     * ritorna l'id della barca
     * @return fk_boat
     */
    public int getFk_boat() {
        return fk_boat;
    }

    /**
     * setta l'id della barca
     * @param fk_boat 
     */
    public void setFk_boat(int fk_boat) {
        this.fk_boat = fk_boat;
    }
    
}
