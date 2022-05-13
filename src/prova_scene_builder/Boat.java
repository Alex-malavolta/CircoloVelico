/*
 * classe boat, utile per la istanziazione delle barche
 */
package prova_scene_builder;

/**
 *
 * @author alex
 */
public class Boat {
    /**
     * id_boat, conterrà l'identificatore della barca
     */
    int id_boat;
    
    /**
     * il name, conterrà il nome della barca, 
     * fk_socio, conterrà l'id del socio che è il propietario della barca
     */
    String name,fk_socio;
    
    /**
     * lenght, rappresenta la lunghezza della barca
     */
    float lenght;

    /**
     * costruttore della barca, ritorna una barca con i dati inseriti nelle variabili +
     * @param id_boat
     * @param name
     * @param fk_socio
     * @param lenght 
     */
    public Boat(int id_boat, String name, String fk_socio, float lenght) {
        this.id_boat = id_boat;
        this.name = name;
        this.fk_socio = fk_socio;
        this.lenght = lenght;
    }

    /**
     * metodo che ritorno l'id della barca
     * @return id_boat
     */
    public int getId_boat() {
        return id_boat;
    }

    /**
     * setta l'id della barca
     * @param id_boat 
     */
    public void setId_boat(int id_boat) {
        this.id_boat = id_boat;
    }

    /**
     * ritorna il nome della barca
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setta il nome della barca
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ritorna l'id del propietario della barca
     * @return fk_socio
     */
    public String getFk_socio() {
        return fk_socio;
    }

    /**
     * setta i'id del socio, propietario dell'imbarcazione
     * @param fk_socio 
     */
    public void setFk_socio(String fk_socio) {
        this.fk_socio = fk_socio;
    }

    /**
     * ritorna la lunghezza della barca
     * @return lenght
     */
    public float getLenght() {
        return lenght;
    }

    /**
     * setta la lunghezza della barca
     * @param lenght 
     */
    public void setLenght(float lenght) {
        this.lenght = lenght;
    }
    
}
