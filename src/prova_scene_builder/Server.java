/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova_scene_builder;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.Float.parseFloat;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author alex
 */


/**
 * funzione Multi sfrutta i thread per gestire più richieste dai client, e èiù client
 * @author Silvio
 */


class Multi extends Thread{
private Socket s=null;              //istanziazione di un socket chiamato s
DataInputStream infromClient;       //prendo le informazioni dal client
DataOutputStream outVersoClient;    //vado a dare informazioni al client
Multi() throws IOException{


}

Multi(Socket s) throws IOException{
    this.s=s;   
    infromClient = new DataInputStream(s.getInputStream()); 
    outVersoClient = new DataOutputStream(s.getOutputStream());
}


public void run(){  

    
    String action=new String();     //contiene l'azione che il client vuole svolgere
    
    try {
        action = infromClient.readUTF();    
    } catch (IOException ex) {
        Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
    }
    switch(action){
        case "registration":        //se l'utente ha cliccato il bottone registrati
            try {
                
                /**
                 * definizine dei campi utilizzati nella registrazione del cliente
                 */
                String Cf =new String();     
                String nome=new String();   
                String username=new String();                           
                String password=new String();
                String cognome=new String();
                String indirizzo=new String();
                String carta_credito=new String();
                String iban=new String();
                
                
                /**
                 * ricevo dal client tutti i dati inseriti nella textarea dall'utente
                 */
                Cf =infromClient.readUTF();
                username=infromClient.readUTF();
                password=infromClient.readUTF();
                nome=infromClient.readUTF();
                cognome= infromClient.readUTF();
                indirizzo=infromClient.readUTF();
                carta_credito=infromClient.readUTF();
                iban=infromClient.readUTF();
                
                /**
                 * richiamo la funzione ragistration passandogli tutti i vari parametri inseriti dall'utente nella textarea
                 */
                registration(Cf,username,password,nome,cognome,indirizzo,carta_credito,iban);
            } catch (IOException ex) {
            Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
        case "login":   //entriamo nel case login se l'utente ha cliccato il bottone login
            try {
                
                List<String>lista = new ArrayList();
                String username=new String();
                String password=new String();
                //prendo in input le credenziali inserite dall'utente nella textarea
                username=infromClient.readUTF();
                password=infromClient.readUTF();
                String us_pers=username;
                String ps_pers=password;
                
                //dentro la variabile esito_log_ut inserisco il risultando della funzione richiamata login, con gli elementi passati username e password inseriti dall'utente nella pagina di login
                Boolean esito_log_ut=login(username,password);
                lista.add(String.valueOf(esito_log_ut));
                
                //se l'esito e positivi il login e
                if(esito_log_ut== true){
                    //controllo che il socio abbia pagato l'iscrizione annuale, richiamando la funzione warning, passandogli username e passowrd di chi ha effettuato il login
                    Boolean esito_warning=warning(username,password);
                    lista.add(String.valueOf(esito_warning));
                }else{
                    lista.add("false");
                }
                
                String str = "";
		for (String i : lista) {
			str+= i+",";
		}
                outVersoClient.writeBytes(str);
            
                
            } catch (IOException ex) {
            Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            
        case "login_pers":        //se l'utente ha cliccato il bottone login personale, dedicato al personale che gestisce il circolo
            try {
                //prendo in input le credenziali inserite dal personale nella textarea
                String username=new String();
                String password=new String();
                username=infromClient.readUTF();
                password=infromClient.readUTF();
               
                //richiamo la funzione login_personale, per controllare se chi si logga è autorizzato ad accedere ai dati dei soci
                Boolean esito_log_per=login_pers(username,password);
                
                outVersoClient.writeBytes(String.valueOf(esito_log_per));
                
               
                
            } catch (IOException ex) {
            Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            
            
        case"new_boat":           //se l'utente ha cliccato il bottone new boat, dedicato al socio che vuole aggiungere una nuova imbarcazione
            try {
                
                String nome=new String();
                float lungh= 0;
                String fk_socio=new String();
                String pws_reg=new String();
                //prendiamo in input tutti i dati della barca inseriti dall'utente
                nome=infromClient.readUTF();
                lungh=parseFloat(infromClient.readUTF());
                fk_socio=infromClient.readUTF();
                pws_reg=infromClient.readUTF();
                
                //facciamo un controllo per vedere se chi la inserisce e realmente l'utente che si è loggato
                //se è cosi allora inseriamo la barca nella tabella barche, richiamando la funzione nuova_barca
                Boolean res = check_validita(fk_socio,pws_reg);
                if(res==true){
                    nuova_barca(nome,lungh,fk_socio);
                }else{
                    System.out.println("non puoi registrare la barca perche non hai inserito le credenziali corrette");
                }
                
            } catch (IOException ex) {
            Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            
        case "rm_barca":            //se l'utente ha cliccato il bottone remove boat, dedicato al socio che vuole rimuovere una  imbarcazione
            try {
                
                String nome_barca=new String();
              
                String fk_socio=new String();
                
                String psw_sc=new String();
                
                //inseriamo i dati dell'imbarcazione che vogliamo rimuovere, inclusa la password dell'utente per maggiore sicurezza
                nome_barca=infromClient.readUTF();
               
                fk_socio=infromClient.readUTF();
                
                psw_sc=infromClient.readUTF();
                
                //richiamiamo la funzione che toglierà la barca dalla tabella barche
                rm_b(nome_barca,fk_socio,psw_sc);
            } catch (IOException ex) {
            Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            break;
            
        case"iscrivi_gara":             //se l'utente ha cliccato il bottone iscriviti, dedicato al socio che vuole partecipare ad una gara
            try {
            String nome_b=new String();
              
            String id_gara=new String();
            
            String cf=new String();
            
            String importo=new String();
            
            String methodp=new String();
            
            String psw_conv=new String();
            
            //prendo in input i dati per l'iscrizione della barca, come il nome dell'imbarcazione, il codice fiscale dell'utente, l'id gara perchè e possibile che ci siano più gare
            //l'importo della partecipazione alla gara, e la password sempre per la verifica dell'utente
            nome_b=infromClient.readUTF();
            cf=infromClient.readUTF();
            id_gara=infromClient.readUTF();
            importo=infromClient.readUTF();
            psw_conv=infromClient.readUTF();
            methodp=infromClient.readUTF();
            
            //richiamo la funzione check_validita
            Boolean res = check_validita(cf,psw_conv);
            System.out.println(res);
            
            //se
            if(res==true){
                iscriviagara(nome_b,cf,id_gara,importo,methodp);
                outVersoClient.writeBytes("noterr");

            }else{
                    outVersoClient.writeBytes("error");
                    System.out.println("non puoi registrarti alla gara perche non hai inserito le credenziali corrette");
                }
            
            } catch (IOException ex) {
            Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
        case"pagamento_iscrizione":
            try {
            String cf_pagam=new String();
            String psw_conv=new String();
            String methodp=new String();
            
            cf_pagam=infromClient.readUTF();
            psw_conv=infromClient.readUTF();
            methodp=infromClient.readUTF();
            
            
            Boolean giusto=check_validita(cf_pagam,psw_conv);
            if(giusto){
                effettua_nuova_iscrizione(cf_pagam,methodp);
                outVersoClient.writeBytes("noerror");
            }else{
                outVersoClient.writeBytes("error");
            }
            
            
            } catch (IOException ex) {
            Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
        case"pagamento_rimessaggio":
            try {
            String cf_lung=new String();
            String importo=new String();
            String psw_check=new String();
            String methodp=new String();
            
            cf_lung=infromClient.readUTF();
            importo=infromClient.readUTF();
            psw_check=infromClient.readUTF();
            methodp=infromClient.readUTF();
            
            Boolean giusto_check =check_validita(cf_lung,psw_check);
            
            if(giusto_check){
                effettua_pagamento_rimessaggio(cf_lung,importo,methodp);
                outVersoClient.writeBytes("noerror");
            }else{
                outVersoClient.writeBytes("error");
            }
            
            
            } catch (IOException ex) {
            Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
            case "rm_socio":
            try {
                
                String cf=new String();
              
                
                
                
                cf=infromClient.readUTF();
               
                
                
                rm_s(cf);
            } catch (IOException ex) {
            Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            break;
            case "rm_imbarcazione":
            try {
                
                String id=new String();
              
                
                
                
                id=infromClient.readUTF();
               
                
                
                rm_imb(id);
            } catch (IOException ex) {
            Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            break;
            
            case "rm_gara":
            try {
                
                String id=new String();
              
                
                
                
                id=infromClient.readUTF();
               
                
                
                rm_gara(id);
            } catch (IOException ex) {
            Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            break;
            
            case "registration_gara":
            try {
                
                String nome_gara=new String();
                String prezzo=new String();
                String data=new String();
                String location=new String();
                
                
                
                nome_gara=infromClient.readUTF();
                prezzo=infromClient.readUTF();
                data=infromClient.readUTF();
                location=infromClient.readUTF();
                
                
                aggiungi_gara(nome_gara,prezzo,data,location);
                
            } catch (IOException ex) {
            Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            break;
        
    }
    System.out.println("Query: " + action); 
    try {
        System.out.println("Socket Closing");
        s.close();
    } catch (IOException ex) {
        Logger.getLogger(Multi.class.getName()).log(Level.SEVERE, null, ex);
       }
   }

    public void aggiungi_gara(String nome_gara,String prezzo,String data,String location){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/circolovela","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
            //una connessione per ogni metodo
            
            String query = "INSERT INTO `competition`( `name`, `price`, `date`, `location`) VALUES ('"+nome_gara+"',"+prezzo+",'"+data+"','"+location+"')"; 
            stmt.executeUpdate(query);
            stmt.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }







    public Boolean warning(String username,String password){
        
        Boolean warning_ok = null;
        String dat_dbu = null;
        LocalDate today = LocalDate.now();
        
        try
        {
            //parte di codice per connettersi al db
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/circolovela","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
            //una connessione per ogni metodo
            
            //faccio ritornare la tupla, facendo un join delle tabelle pagamenti e socio per vedere la data del pagamento dell'iscrizione al citcolo dell'utente loggato a quando risale
            String query = "SELECT max(date) FROM `payment`JOIN socio on `fk_partner`= socio.codice_fiscale WHERE socio.username='"+username+"' and type_payment='iscrizione'"; 
            
            ResultSet aa = stmt.executeQuery(query);
           
            while (aa.next())
            {
                dat_dbu = aa.getString("max(date)");
                
                   
            }
            stmt.close();
            
            System.out.println(dat_dbu);
            


            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
        //se non ha nessuna data all'interno di pagamenti allora l'utente dovrà pagare la retta di iscrizione
        if(dat_dbu==null){
            warning_ok= true;
        }
        
        //faccio i controlli se dall'ultimo pagamento è passato un anno, e se e scaduto metto a false warning_ok = false;
        else{
            LocalDate dat= LocalDate.parse(dat_dbu);
            LocalDate plusOneYear = dat.plusYears(1);
           
            if(plusOneYear.isAfter(today)){
                warning_ok= false;
            }
             
            else{
                warning_ok= true;
            }
        }
        
        return warning_ok;
    }


    public Boolean check_validita(String fk_soc,String password){
        Boolean ok =false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/circolovela","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
            //una connessione per ogni metodo
            
            String query = "SELECT  `password` FROM `socio` WHERE codice_fiscale='"+fk_soc+"'"; 
            
            ResultSet aa = stmt.executeQuery(query);
           
            while (aa.next())
            {
                String dat_dbu = aa.getString("password");
                
                if(dat_dbu.equals(password)){
                    ok = true;
                }
                
                   
            }
            stmt.close();

            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
      
       
       
        return ok;
    }


    public void nuova_barca(String nome,float lungh,String fk_socio){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/circolovela","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
            //una connessione per ogni metodo
            //inseriamo dentro la tabella barche, la nuova barca inserita dall'utente
            String query = "INSERT INTO `boat`( `name`, `length`, `fk_socio`) VALUES ('"+nome+"',"+lungh+",'"+fk_socio+"')"; 
            stmt.executeUpdate(query);
            stmt.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void iscriviagara(String nome_b,String cf,String id_g,String importo,String methodp){
        LocalDate todaysDate = LocalDate.now();
        try
        {
            //parte di codice per la connessione al db 
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Circolovela","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
            //prelevo l'id_boat, dalla tabella barche dove il nome corrisponde al nome inserito dall'utente, e il codice fiscale del propietario della barca corrisponde a quello inserito dall'utente
            String query = "select id_boat from boat where name='"+nome_b+"'and fk_socio = '"+cf+"';"; 
            ResultSet aa = stmt.executeQuery(query);
            
            while (aa.next())
            {
                int id_b = aa.getInt("id_boat");
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/circolovela","root","");
                Statement stmt2=con.createStatement();  
                ResultSet rs2=stmt.executeQuery("show databases;");
                System.out.println("Connected");
                 
                //una connessione per ogni metodo
            
                //inserisco dentro la tabella race, l'identificativo della gara, e l'identificativo della gara, di chi si e iscritto
                String query2 = "INSERT INTO `race`(`fk_competition`, `fk_boat`) VALUES ("+id_g+","+id_b+")"; 
                //inserisco dentro la tabella pagamenti, inserendo il metodo di pagamento, il tipo di pagamento, l'importo, la data in cui e stato fatto l'iscrizione, e id del socio
                String query3 = "INSERT INTO `payment`(`method_payment`, `type_payment`, `import`, `date`, `fk_partner`) VALUES ('"+methodp+"','Iscrizione Gara',"+Float.parseFloat(importo)+",'"+String.valueOf(todaysDate)+"','"+cf+"')"; 
                //eseguo le query
                stmt.executeUpdate(query2);
                stmt.executeUpdate(query3);
                stmt.close();
            }
            stmt.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
    }



    public void registration(String Cf,String username,String password,String nome,String cognome,String indirizzo ,String carta_credito,String iban){
        Boolean errore=false;      //istanzio una variabile booleana che servirà per verifivare se l'utente che si sta registrando è giua stato inserito nel db
      
       try
        {
            Class.forName("com.mysql.jdbc.Driver"); //Dato il nome completo di una classe, questo metodo tenta di individuare, caricare e collegare la classe
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Circolovela","root","");//stringa di collegamento al server contenente la porta del server mysql, il nome del db
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");  
            System.out.println("Connected");  
            
            //una connessione per ogni metodo
            
            String query = "select codice_fiscale,username from socio;"; //query che ritorna il codice fiscale e username dalla tabella socio
            ResultSet aa = stmt.executeQuery(query);                     //eseguiamo la query 
            
            while (aa.next())
            {
                //assegnamo alle diverse variabili i risultati ottenuti dalla tabella soci del db
                String codice_fisc = aa.getString("codice_fiscale");
                
                String usern = aa.getString("username");
                
                //se l'username e il codice fiscale appena inserito dall'utente che si sta registrando, è gia all'interno del db, impongo errore uguale a true
                if(codice_fisc.equals(Cf) && usern.equals(username)){
                    errore = true;
                }
                
                
            }
            
            //entra qui se l'utente non  è registrato
            if(errore!=true){
                Class.forName("com.mysql.jdbc.Driver");
                Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/circolovela","root","");
                Statement stmt2=con.createStatement();  
                ResultSet rs2=stmt.executeQuery("show databases;");
                System.out.println("Connected");  
            
                //una connessione per ogni metodo
                //inseriamo dentro la tabella socio il nuovo utente registrato
                String query2 = "INSERT INTO `socio`(`codice_fiscale`, `username`, `password`, `first_name`, `last_name`, `address`, `debit_card`, `iban`) VALUES ('"+Cf+"','"+username+"','"+password+"','"+nome+"','"+cognome+"','"+indirizzo+"','"+carta_credito+"','"+iban+"')"; 
                stmt.executeUpdate(query2);
                stmt.close();
            
            }
            //entriamo nell'else se si e verificato l'errore, di conseguenza l'utente era gia registrato
            else{
                
                System.out.println("log gia usato");
            }
            stmt.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    public void rm_b(String n_barca,String fk_socio,String psw_sc){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/circolovela","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
            
            //prima controlliamo l'autenticità dell'utente inserendo il codice fiscale e passoword
            String query = "SELECT codice_fiscale,password FROM socio WHERE codice_fiscale ='"+fk_socio+"'";
            //una connessione per ogni metodo
            ResultSet aa = stmt.executeQuery(query);
            
            while (aa.next())
            {
                String username_log = aa.getString("codice_fiscale");
                String psw_log = aa.getString("password");
                
                //controllo utente
                if(username_log.equals(fk_socio)&&psw_log.equals(psw_sc)){
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/circolovela","root","");
                    Statement stmt1=con.createStatement();  
                    ResultSet rs1=stmt.executeQuery("show databases;");
                    System.out.println("Connected");  
            
                    //una connessione per ogni metodo
                    //cancelliamo la barca dalla tabella che abbia come fk_socio lo stesso di quello che si e loggato e il nome della barca uguale a quella inserita dall'utente
                    String query1 = "DELETE FROM `boat` WHERE fk_socio='"+username_log+"' and name='"+n_barca+"'"; 
                    stmt.executeUpdate(query1);
            
           
             
                    stmt.close();
                    
                }else{
                    System.out.println("rimozione non eseguita");
                }
                
            }
            
           
             
            stmt.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    public Boolean login(String username,String password){
        //istanzio una variabile chiamata login_effettuato per il controllo del login
        Boolean login_effettuato = false;
        try{
        try
        {
            //parte di codice utile per la connessione al db
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/circolovela","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected1");  
            
            //una connessione per ogni metodo
            //query al db per farmi ritornare tutti le tuple che abbiano l'username uguale all'username inserito dall'utente
            String query = "SELECT username,password FROM socio WHERE username ='"+username+"'"; 
            
            ResultSet aa = stmt.executeQuery(query);
            
            while (aa.next())
            {
                //String username_log = "Mala0000";
                //String psw_log = "ml";
                String username_log = aa.getString("username");
                String psw_log = aa.getString("password");
                //controllo che l'username dell'utente e passowrd sia uguale a quelli della tupla restituita
                if(username_log.equals(username)&&psw_log.equals(password)){
                    login_effettuato = true;
                }
                
            }
            stmt.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        }catch(Exception e)
        {
            System.out.println(e);
        }
        return login_effettuato;
        
    }
    
    public Boolean login_pers(String username,String password){
        Boolean login_effettuato_ = null;
        try
        {
            //parte di collegamento al db
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/circolovela","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
            //una connessione per ogni metodo
            //funzionamento uguale per soci, ma utilizziamo la tabella staff dove sono contenuti all'interno tutti i dati e le credanziali dei soci
            String query = "SELECT first_name,passwd FROM staff WHERE first_name ='"+username+"'"; 
            
            ResultSet aa = stmt.executeQuery(query);
           
            while (aa.next())
            {
                String username_log = aa.getString("first_name");
                String psw_log = aa.getString("passwd");
                //verifico che le credenziali inserite siano quelle salvate nel db
                if(username_log.equals(username)&&psw_log.equals(password)){
                    login_effettuato_ = true;
                }else{
                    login_effettuato_ = false;
                }
                
            }
            stmt.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        if(login_effettuato_ == true){
            return true;
        }else{
            return false;
        }
    }
    
    
    
    public void effettua_nuova_iscrizione(String cf_pagam,String methodp){
        LocalDate todaysDate = LocalDate.now();
       try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Circolovela","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
                //una connessione per ogni metodo
                //inserimento della nuova riga nella tabella pagamenti, inserendo tutti i dati necessari come data e l'id di chi ha pagato
                String query = "INSERT INTO `payment`(`method_payment`, `type_payment`, `import`, `date`, `fk_partner`) VALUES ('"+methodp+"','Iscrizione',"+10+",'"+String.valueOf(todaysDate)+"','"+cf_pagam+"')"; 
                stmt.executeUpdate(query);
                stmt.close();
            
         
            stmt.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public void effettua_pagamento_rimessaggio(String cf_pagam,String importo,String methodp){
       //parte di codice per il pagamento del rimessaggio
       LocalDate todaysDate = LocalDate.now();
       try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Circolovela","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
                //una connessione per ogni metodo
                //essendo un pagamento va inserito dentro la tabella pagamenti
                String query = "INSERT INTO `payment`(`method_payment`, `type_payment`, `import`, `date`, `fk_partner`) VALUES ('"+methodp+"','Pagamento Rimessaggio',"+importo+",'"+String.valueOf(todaysDate)+"','"+cf_pagam+"')"; 
                stmt.executeUpdate(query);
                stmt.close();
            
         
            stmt.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void rm_s(String cf){
        //parte di codice per la rimozione del socio, fatto da parte del personale
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Circolovela","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
                //una connessione per ogni metodo
                //rimozione del socio dalla tabella soci, utilizzando il codice fiscale per riconoscerlo univocamente
                String query = "DELETE FROM `socio` WHERE codice_fiscale='"+cf+"'"; 
                stmt.executeUpdate(query);
                stmt.close();
            
         
            stmt.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    public void rm_imb(String id){
        //parte del codice per la rimozione dell'imbarcazione dal circolo
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Circolovela","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
                //una connessione per ogni metodo
                //rimozione della barca dalla tabella barche, utilizzado l'id della barca
                String query = "DELETE FROM `boat` WHERE id_boat='"+id+"'"; 
                stmt.executeUpdate(query);
                stmt.close();
            
         
            stmt.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    public void rm_gara(String id){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Circolovela","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
                //una connessione per ogni metodo
                //rimozione della gara, utilizzato dal personale, utilizzando l'id della gara
                String query = "DELETE FROM `competition` WHERE id_competition='"+id+"'"; 
                stmt.executeUpdate(query);
                stmt.close();
            
         
            stmt.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
 /*   public void firstquery(){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Circolo_Velico","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
            //una connessione per ogni metodo
            
            String query = "select Codice_fiscale, Nome, Cognome from Socio ;"; 
            ResultSet aa = stmt.executeQuery(query);
            
            while (aa.next())
            {
                int Codice_fiscale = aa.getInt("Codice_fiscale");
                String Nome = aa.getString("Nome");
                String Cognome = aa.getString("Cognome");
                //stampare i risultati sui socket
                // print the results
                System.out.format("%s, %s, %s\n", Codice_fiscale, Nome, Cognome);
            }
            stmt.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
*/
}

public class Server {
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        
        //il server rimane in ascolto, in modo da gestire le varie richieste dei thread
        while(true){
         
        ServerSocket ss=new ServerSocket(11111);
        System.out.println("Server is Awaiting"); 
        Socket s=ss.accept();
        Multi t=new Multi(s);
        t.start();
        
        Thread.sleep(2000);
        //launch(args);
        ss.close();
        }  
        
    }
    
}