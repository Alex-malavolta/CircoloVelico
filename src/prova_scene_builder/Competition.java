/*
 * all'interno della classe competizione stanziano tutte le gare con i relativi dati
 */
package prova_scene_builder;

/**
 *
 * @author alex
 */
public class Competition {
    
    /**
     * id_gara, indice della gara, identificando univocamente la gara
    */
    int id_gara;
    /**
     * nome_gara, nome della gara
     * data_gara, data di quando verrà svolta
     * luogo_gara, dove verrà svolta la gara
     */
    String nome_gara,data_gara,luogo_gara;
    /**
     * prezzo_gara, prezzo iscrizione alla gara
     */
    float prezzo_gara;

    /**
     * costruttore di competizione, al metodo vanno passate queste variabili, istazia una competizione
     * @param id_gara
     * @param nome_gara
     * @param data_gara
     * @param luogo_gara
     * @param prezzo_gara 
     */
    public Competition(int id_gara, String nome_gara, String data_gara, String luogo_gara, float prezzo_gara) {
        this.id_gara = id_gara;
        this.nome_gara = nome_gara;
        this.data_gara = data_gara;
        this.luogo_gara = luogo_gara;
        this.prezzo_gara = prezzo_gara;
    }

    
    /**
     * metodo che ritorna l'id della gara
     * @return id_gara
     */
    public int getId_gara() {
        return id_gara;
    }

    
    /**
     * metodo ritorna il nome della gara
     * @return nome_gara
     */
    public String getNome_gara() {
        return nome_gara;
    }

    /**
     * metodo ritorna la data della gara
     * @return data_gara
     */
    public String getData_gara() {
        return data_gara;
    }

    /**
     * ritorna il luogo della gara
     * @return luogo_gara
     */
    public String getLuogo_gara() {
        return luogo_gara;
    }
    
    /**
     * ritorna il prezzo della gara
     * @return prezzo_gara
     */
    public float getPrezzo_gara() {
        return prezzo_gara;
    }

    /**
     * metodo che setta id gara
     * @param id_gara 
     */
    public void setId_gara(int id_gara) {
        this.id_gara = id_gara;
    }

    /**
     * setta il nome della gara
     * @param nome_gara 
     */
    public void setNome_gara(String nome_gara) {
        this.nome_gara = nome_gara;
    }

    /**
     * setta la data della gara
     * @param data_gara 
     */
    public void setData_gara(String data_gara) {
        this.data_gara = data_gara;
    }

    /**
     * setta il luogo della gara
     * @param luogo_gara 
     */
    public void setLuogo_gara(String luogo_gara) {
        this.luogo_gara = luogo_gara;
    }

    /**
     * setta il prezzo della gara
     * @param prezzo_gara 
     */
    public void setPrezzo_gara(float prezzo_gara) {
        this.prezzo_gara = prezzo_gara;
    }
    
}
