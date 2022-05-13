/*
    classe pagamento che conterra i dati relativi a una transazione, che sia o per l'iscrizione della barca al rimessaggio, oppure all'iscrizione della gara
 */
package prova_scene_builder;

/**
 *
 * @author alex
 */
public class Payment {
 /**
  * id_payment, rappresenta l'id del pagamento
  */
 int id_payment;
 /**
  * method_payment, rappresenta il metodo di pagamento, iban o carta di credito
  * type_payment, indica il pagamento a cos'è rideferito, ovvero se l'iscrizione alla gara, o del rimessaggio
  * data, data del pagamento
  * fk_partner, id del socio che ha pagato
  */
 String method_payment,type_payment,date,fk_partner;
 /**
  * importo del pagamento
  */
 float importo;

 /**
  * metoto payment che istanzia un oggetto pagamento con queste variabili
  * @param id_payment
  * @param method_payment
  * @param type_payment
  * @param date
  * @param fk_partner
  * @param importo 
  */
    public Payment(int id_payment, String method_payment, String type_payment, String date, String fk_partner, float importo) {
        this.id_payment = id_payment;
        this.method_payment = method_payment;
        this.type_payment = type_payment;
        this.date = date;
        this.fk_partner = fk_partner;
        this.importo = importo;
    }

    /**
     * metodo che ritorna l'id del pagamento
     * @return id_payment
     */
    public int getId_payment() {
        return id_payment;
    }

    /**
     * setta l'id del pagamento
     * @param id_payment 
     */
    public void setId_payment(int id_payment) {
        this.id_payment = id_payment;
    }

    /**
     * ritorna il metodo di pagamento
     * @return method_payment
     */
    public String getMethod_payment() {
        return method_payment;
    }

    /**
     * metodo che setta il metodo di pagamento
     * @param method_payment 
     */
    public void setMethod_payment(String method_payment) {
        this.method_payment = method_payment;
    }

    /**
     * ritorna il tipo di pagamento
     * @return type_payment
     */
    public String getType_payment() {
        return type_payment;
    }

    /**
     * setta il tipo di pagamento
     * @param type_payment 
     */
    public void setType_payment(String type_payment) {
        this.type_payment = type_payment;
    }

    /**
     * ritorna la data del pagamento
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * setta la data del pagamento
     * @param date 
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * ritorna l'id del socio che ha pagato
     * @return fk_partner
     */
    public String getFk_partner() {
        return fk_partner;
    }

    /**
     * setta l'id di chi ha pagato
     * @param fk_partner 
     */
    public void setFk_partner(String fk_partner) {
        this.fk_partner = fk_partner;
    }

    /**
     * ritorna l'importo del pagamento
     * @return importo
     */
    public float getImporto() {
        return importo;
    }

    /**
     * setta l'importo da pagare
     * @param importo 
     */
    public void setImporto(float importo) {
        this.importo = importo;
    }
 
}
