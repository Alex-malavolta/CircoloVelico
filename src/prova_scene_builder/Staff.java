/*
 * classe staff, che istanzia un oggetto personale, che gestisce il circolo, ed effettua altre operazioni di gestione soci ecc
 */
package prova_scene_builder;

/**
 *
 * @author alex
 */
public class Staff {
    /**
     * id_staff, all'interno contiene l'id del personale per identificarlo univocamente tra gli altri
     */
    int id_staff;
    /**
     * first_name, contiene il nome del personale
     * last_name, cognone del personale
     * passwd, password del personale utile per il login personale
     */
    String first_name,last_name,passwd;

    /**
     * costruttore di staff, per istanziare un personale, con questi valori
     * @param id_staff
     * @param first_name
     * @param last_name
     * @param passwd 
     */
    public Staff(String first_name, String passwd) {
        this.first_name = first_name;
        this.passwd = passwd;
    }
    
    public Staff(int id_staff, String first_name, String last_name, String passwd) {
        this.id_staff = id_staff;
        this.first_name = first_name;
        this.last_name = last_name;
        this.passwd = passwd;
    }

    /**
     * ritorna l'id del personale
     * @return id_staff
     */
    public int getId_staff() {
        return id_staff;
    }

    /**
     * setta l'id del personale
     * @param id_staff 
     */
    public void setId_staff(int id_staff) {
        this.id_staff = id_staff;
    }

    /**
     * ritorna il First_Name del personale
     * @return first_name
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * setta il First_Name, del personale
     * @param first_name 
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * ritorna Last_Name del personale
     * @return last_name
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * setta last_name di personale
     * @param last_name 
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * ritorna la password di personale
     * @return passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * setta la password di personale
     * @param passwd 
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    
   
}
