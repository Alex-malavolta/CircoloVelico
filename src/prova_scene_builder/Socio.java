/**
 * classe socio, istanziazione di un socio
 */
package prova_scene_builder;

/**
 *
 * @author alex
 */
public class Socio {
    
    /**
     * codice_fiscale, identificatore univoco di socio
     * Username, username del socio, utile per l'accesso al circolo
     * Password, password di accesso al circolo
     * FirstName, nome del socio
     * LastName, cognome del socio
     * address, indirizzo del socio
     * deb_card, carta di debito del socio
     */
    String codice_fiscale,Username,Password,FirstName,LastName,Address,deb_card,Iban;
    
    /**
     * costruttore di socio, istanzia un socio con i valori inseriti
     * @param codice_fiscale
     * @param Username
     * @param Password
     * @param FirstName
     * @param LastName
     * @param Address
     * @param deb_card
     * @param Iban 
     */
    
    public Socio(String Username, String Password){
        this.Username = Username;
        this.Password = Password;
    }
    public Socio(String codice_fiscale, String Username, String Password, String FirstName,String LastName,String Address,String deb_card,String Iban) {
        this.codice_fiscale = codice_fiscale;
        this.Username = Username;
        this.Password = Password;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Address = Address;
        this.deb_card = deb_card;
        this.Iban = Iban;
    }

    /**
     * metodo che ritorna il codice fiscale del socio
     * @return codice_fiscale
     */
    public String getcodice_fiscale() {
        return codice_fiscale;
    }

    /**
     * setta il codice_fiscale
     * @param codice_fiscale 
     */
    public void setcodice_fiscale(String codice_fiscale) {
        this.codice_fiscale = codice_fiscale;
    }

    /**
     * ritorna l'username del socio
     * @return Username
     */
    public String getUsername() {
        return Username;
    }

    /**
     * setta l'username del socio
     * @param Username 
     */
    public void setUsername(String Username) {
        this.Username = Username;
    }

    /**
     * ritorna la password di socio
     * @return 
     */
    public String getPassword() {
        return Password;
    }

    /**
     * setta la password di socio
     * @param Password 
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * ritorna il FirstName di socio
     * @return FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * setta il FirstName di socio
     * @param FirstName 
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * ritorna il LastName di socio
     * @return LastName
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * setta il LastName di socio
     * @param LastName 
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * ritorna l'address del socio
     * @return Address
     */
    public String getAddress() {
        return Address;
    }

    /**
     * setta l'address di socio
     * @param Address 
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * ritorna la carta di credito del socio
     * @return deb_card
     */
    public String getDeb_card() {
        return deb_card;
    }

    /**
     * setta la carta di credito
     * @param deb_card 
     */
    public void setDeb_card(String deb_card) {
        this.deb_card = deb_card;
    }

    /**
     * ritorna l'iban del socio
     * @return Iban
     */
    public String getIban() {
        return Iban;
    }

    /**
     * setta l'iban del socio
     * @param Iban 
     */
    public void setIban(String Iban) {
        this.Iban = Iban;
    }
}
