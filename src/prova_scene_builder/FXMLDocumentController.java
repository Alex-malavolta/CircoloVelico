/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova_scene_builder;

import java.awt.Checkbox;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author alex
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private AnchorPane welcome;
    
    @FXML
    private AnchorPane registrazione;
    
    @FXML
    private AnchorPane log_effettuato;
    
    @FXML
    private AnchorPane rm_boat;
    
    @FXML
    private AnchorPane iscrizione_gara;
    
    @FXML
    private AnchorPane registrazione_barca;
    
    @FXML
    private AnchorPane pagamento_iscrizione;
    
    @FXML
    private AnchorPane pagamento_rimessaggio_b;
    
     @FXML
    private AnchorPane personale_general;
    
     @FXML
    private AnchorPane gest_soc;
     
     @FXML
    private AnchorPane gest_gare;
      @FXML
    private AnchorPane gest_imb;
      
      @FXML
    private AnchorPane gest_pag;
      @FXML
    private AnchorPane ins_gara;
      
      
      @FXML
    private AnchorPane ritenta;
    @FXML
    private ImageView logo;
    
    @FXML                                           
    private TextField username_field;
    
    @FXML
    private PasswordField password_field;
    @FXML
    private Button btn_login;
    @FXML
    private Button log_pers;
    @FXML                                           
    private Label user_name;
    
    @FXML                                          
    private Label warning;
    
    @FXML                                          
    private TextField campo_cf;
    
    @FXML                                           
    private TextField campo_username;
    @FXML                                           
    private TextField campo_password;
    @FXML                                         
    private TextField campo_first_name;
    @FXML                                           
    private TextField campo_last_name;
    @FXML                                          
    private TextField campo_address;
    @FXML                                          
    private TextField campo_credit_card;
    @FXML                                           
    private TextField campo_iban; 
    @FXML                                           
    private TextField text_barca_name;
    @FXML                                           
    private TextField text_barca_lunghezza;
    @FXML                                           
    private TextField text_cf_barca;
    
    @FXML                                           
    private TextField rm_nome_barca;
    
    @FXML                                           
    private TextField rm_cf_barca;
    
    @FXML                                           
    private TextField psw_rm_barca;
    
    @FXML
    private TableView<Competition> tabella;
    @FXML
    private TableColumn<Competition, Integer> id_gara;
    @FXML
    private TableColumn<Competition, String> nome_gara;
    @FXML
    private TableColumn<Competition, Float> prezzo_gara;
    @FXML
    private TableColumn<Competition, String> data_gara;
    @FXML
    private TableColumn<Competition, String> luogo_gara;
    
    @FXML                                           
    private TextField txt_nome_barca;
    
    @FXML                                           
    private TextField txt_id_gara;
    @FXML                                           
    private TextField txt_cf;
    @FXML                                           
    private TextField txt_importo;
    
    @FXML                                          
    private RadioButton cartacredit;
    
    @FXML                                          
    private RadioButton ibann;
    
    
    @FXML                                           
    private RadioButton carta_c_p;                            
    
    @FXML                                           
    private RadioButton iban_p;                            
    
    @FXML                                           
    private TextField cf_pagamento_p;
    
    @FXML                                          
    private TextField txt_lung;
    
    @FXML                                          
    private TextField check_reg_barca;
    
    @FXML                                          
    private TextField psw_convalida_iscr_gara;
    @FXML                                         
    private Label l_lung;
    
    @FXML                                           
    private TextField cf_lung;
    
    @FXML                                           
    private RadioButton cc_lung; 
    
    @FXML                                           
    private RadioButton iban_lung; 
    
    
    @FXML                                     
    private Label nom_pers;
    
    
    @FXML
    private Button btn_new_boat;
    
    ObservableList<Competition> list = FXCollections.observableArrayList();
    
    
    @FXML
    private TextArea txt_cod;
    @FXML
    private TextArea txt_us;
    @FXML
    private TextArea txt_ps;
    @FXML
    private TextArea txt_fn;
    @FXML
    private TextArea txt_ln;
    @FXML
    private TextArea txt_a;
    @FXML
    private TextArea txt_db;
    @FXML
    private TextArea txt_i;
    
    @FXML
    private TextArea id_imb;
    @FXML
    private TextArea nm_boat;
    @FXML
    private TextArea ln_boat;
    @FXML
    private TextArea cod_fis_ut;
    
    @FXML
    private TextArea id_g;
    
    @FXML
    private TextArea nome_gar;
    @FXML
    private TextArea date;
    @FXML
    private TextArea price;
    @FXML
    private TextArea location;
    
    @FXML
    private TextArea id_pag;
    
    @FXML
    private TextArea meth_pag;
    @FXML
    private TextArea type_pag;
    @FXML
    private TextArea impo;
    @FXML
    private TextArea date_pag;
    
    @FXML
    private TextArea cod_f_ut;
    
    @FXML
    private Button btn_removeboat;
    
    @FXML
    private Button btn_iscr_gara;
    
    @FXML                                         
    private Label label_warning_iscr;
    
    @FXML                                           
    private TextField psw_conv_pag;
    
    
    @FXML                                           
    private TextField psw_con_pag_barca;
    
    @FXML                                           
    private TextField cf_gest_soci;
    
    @FXML                                           
    private TextField ig_gest_imb;
    
    @FXML                                          
    private TextField txt_gest_gare;
    
    @FXML                                          
    private TextField txt_id_gara_;
    @FXML                                          
    private TextField txt_prezzo;
    @FXML                                          
    private TextField txt_data;
    @FXML                                          
    private TextField txt_location;
    
    
    @FXML
    private void esegui_login(ActionEvent event) {
        try {
            
            //ottengo username e password dall'utente per eseguire l'accesso
            System.out.println(username_field.getText());
            System.out.println(password_field.getText());
            Socket socketConnection = new Socket("127.0.0.1", 11111);
            BufferedReader inDalServer = new BufferedReader(new InputStreamReader(socketConnection.getInputStream()));
            DataOutputStream outToServer = new DataOutputStream(socketConnection.getOutputStream());
            //QUERY PASSING
            
            outToServer.writeUTF("login");
            outToServer.writeUTF(username_field.getText());
            outToServer.writeUTF(password_field.getText());
            
            String ricevuto_ut = inDalServer.readLine();
            
            String[] results=ricevuto_ut.split(",");
           
            //controlliamo che l'utente sia effettivamente registrato, e che sia all'interno del db
            if(results[0].compareTo("true")==0){
                welcome.setVisible(false);
                log_effettuato.setVisible(true);
                user_name.setText(username_field.getText());
                if(results[1].compareTo("true")==0){
                warning.setText("Devi pagare la quota di iscrizione");
                btn_new_boat.setVisible(false);
                btn_removeboat.setVisible(false);
                btn_iscr_gara.setVisible(false);
                }
            }
            //se non e registrato 
            else{
                 System.out.println("error login controlla username e password");
                 welcome.setVisible(false);
                 ritenta.setVisible(true);
            }
        } catch (Exception e) 
        {System.out.println(e); }
       
    }
    @FXML
    private void ritenta_go(ActionEvent event) {
        ritenta.setVisible(false);
        welcome.setVisible(true);
        
        
    }
    
    //se l'utente vuole inserire una nuova barca attiviamo l'anchorPane per registrare la nuova barca
    @FXML
    private void new_boat(ActionEvent event) {
        log_effettuato.setVisible(false);
        registrazione_barca.setVisible(true);
        
        
    }
    
    //anchorPane per il personale, dove stampa tutti i soci
    @FXML
    private void gest_soci(ActionEvent event) {
      gest_soc.setVisible(true);
     
      personale_general.setVisible(false);
     
       try{
         try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/circolovela","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
            //una connessione per ogni metodo
            //query per restituire tutti i soci del circolo
            String query = "SELECT `codice_fiscale`,`username`,`password`, `first_name`, `last_name`, `address`, `debit_card`,`iban` FROM `socio` WHERE 1"; 
            
            ResultSet aa = stmt.executeQuery(query);
            
            while (aa.next())
            {
                String id_cf = aa.getString("codice_fiscale");
                
               

                String name = aa.getString("username");
                
                String pass = aa.getString("password");
                
                String first_nome = aa.getString("first_name");
                
                String last_nome = aa.getString("last_name");
                
                String address_ = aa.getString("address");
                
                String db_card = aa.getString("debit_card");
                
                String iba = aa.getString("iban");
                
               txt_cod.appendText(id_cf + "\n");
               txt_us.appendText(name + "\n");
               txt_ps.appendText(pass + "\n");
               txt_fn.appendText(first_nome + "\n");
               txt_ln.appendText(last_nome + "\n");
               txt_a.appendText(address_ + "\n");
               txt_db.appendText(db_card + "\n");
               txt_i.appendText(iba + "\n");
               
               
                
            }
            stmt.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
         
     
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
    
    //per ritornare tutte le barche in generale
    @FXML
    private void gest_imbarc(ActionEvent event) {
      gest_imb.setVisible(true);
     
      personale_general.setVisible(false);
     
       
         try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/circolovela","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
            //una connessione per ogni metodo
            
            String query = "SELECT `id_boat`,`name`,`length`, `fk_socio` FROM `boat` WHERE 1"; 
            
            ResultSet aa = stmt.executeQuery(query);
            
            while (aa.next())
            {
                String id_b = aa.getString("id_boat");
                
               

                String nam = aa.getString("name");
                
                
                
                String len = aa.getString("length");
                
                String fksoc = aa.getString("fk_socio");
                
               
                  System.out.println(id_b); 
               
               id_imb.appendText(id_b + "\n");
               nm_boat.appendText(nam + "\n");
               ln_boat.appendText(len + "\n");
               cod_fis_ut.appendText(fksoc + "\n");
              
               
               
                
            }
            stmt.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
         
    
        
        
    }
    
    //ritorna tutte le gare presenti
    @FXML
    private void gest_gar(ActionEvent event) {
      gest_gare.setVisible(true);
     
      personale_general.setVisible(false);
     
       
         try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/circolovela","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
            //una connessione per ogni metodo
            
            String query = "SELECT `id_competition`,`name`,`price`, `date`, `location` FROM `competition` WHERE 1"; 
            
            ResultSet aa = stmt.executeQuery(query);
            
            while (aa.next())
            {
                String id_comp = aa.getString("id_competition");
                
               

                String nam = aa.getString("name");
                
                
                
                String p = aa.getString("price");
                
                String dat = aa.getString("date");
                
               String loc = aa.getString("location");
               
               
               
               id_g.appendText(id_comp + "\n");
               nome_gar.appendText(nam + "\n");
               date.appendText(p + "\n");
               price.appendText(dat + "\n");
               location.appendText(loc + "\n");
               
               
                
            }
            stmt.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
         
    
        
        
    }
    
    //per controllare tutti i pagamenti
    @FXML
    private void gest_pagam(ActionEvent event) {
      gest_pag.setVisible(true);
     
      personale_general.setVisible(false);
     
       
         try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/circolovela","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
            //una connessione per ogni metodo
            
            String query = "SELECT `id_payment`,`method_payment`,`type_payment`, `import`, `date`, `fk_partner` FROM `payment` WHERE 1"; 
            
            ResultSet aa = stmt.executeQuery(query);
            
            while (aa.next())
            {
                String id_p = aa.getString("id_payment");
                
               

                String mp = aa.getString("method_payment");
                
                
                
                String tp = aa.getString("type_payment");
                
                String importo = aa.getString("import");
                
               String dat = aa.getString("date");
               
               String part = aa.getString("fk_partner");
               
               
               id_pag.appendText(id_p + "\n");
               meth_pag.appendText(mp + "\n");
               type_pag.appendText(tp + "\n");
               impo.appendText(importo + "\n");
               date_pag.appendText(dat + "\n");
               cod_f_ut.appendText(part + "\n");
               
                
            }
            stmt.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
         
    
        
        
    }
    
    //anchorPane per il login personale
    @FXML
    private void log_personale(ActionEvent event) {
         try {
            System.out.println(username_field.getText());
            System.out.println(password_field.getText());
            Socket socketConnection = new Socket("127.0.0.1", 11111);
            BufferedReader inDalServer = new BufferedReader(new InputStreamReader(socketConnection.getInputStream()));
            DataOutputStream outToServer = new DataOutputStream(socketConnection.getOutputStream());
            //QUERY PASSING
            
            
            outToServer.writeUTF("login_pers");
            outToServer.writeUTF(username_field.getText());
            outToServer.writeUTF(password_field.getText());
            
            String ricevuto_pers = inDalServer.readLine();
           
            //controllo che il personale sia effettivamente inserito nel db
            if(ricevuto_pers.compareTo("true")==0 ){
                welcome.setVisible(false);
                personale_general.setVisible(true);
                nom_pers.setText(username_field.getText());
            }else{
                
                 System.out.println("error login controlla username e password");   
                 welcome.setVisible(false);
                 ritenta.setVisible(true);
            }
        } catch (Exception e) 
        {System.out.println(e);
        }
       
        
        
    }
    
    //anchorPane per il socio che vuole inserire una nuova barca
    @FXML
    private void go_new_boat(ActionEvent event) {
        log_effettuato.setVisible(false);
        registrazione_barca.setVisible(true);
        try {
            Socket socketConnection = new Socket("127.0.0.1", 11111);
            //QUERY PASSING
            DataOutputStream outToServer = new DataOutputStream(socketConnection.getOutputStream());
            
            outToServer.writeUTF("new_boat");
            outToServer.writeUTF(text_barca_name.getText());
            outToServer.writeUTF(text_barca_lunghezza.getText());
            outToServer.writeUTF(text_cf_barca.getText());
            outToServer.writeUTF(check_reg_barca.getText());
            
            
        } catch (Exception e) 
        {
            System.out.println(e); 
        }
        log_effettuato.setVisible(true);
        registrazione_barca.setVisible(false);
        
    }
    
    //anchorPane per rimuovere la barca dell'utente
    @FXML
    private void remove_boat(ActionEvent event) {
        log_effettuato.setVisible(false);
        rm_boat.setVisible(true);
        
        
    }
    
    @FXML
    private void rimuovi_barca_conferma(ActionEvent event) {
      
        try {
            Socket socketConnection = new Socket("127.0.0.1", 11111);
            //QUERY PASSING
            DataOutputStream outToServer = new DataOutputStream(socketConnection.getOutputStream());
            outToServer.writeUTF("rm_barca");
            outToServer.writeUTF(rm_nome_barca.getText());
            outToServer.writeUTF(rm_cf_barca.getText());
            outToServer.writeUTF(psw_rm_barca.getText());
            
        } catch (Exception e) 
        {
            System.out.println(e); 
        }
        log_effettuato.setVisible(true);
        rm_boat.setVisible(false);
    }
    
    @FXML
    private void iscrivi_gara(ActionEvent event) {
        log_effettuato.setVisible(false);
        iscrizione_gara.setVisible(true);
        
            try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/circolovela","root","");
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery("show databases;");
            System.out.println("Connected");  
            
            //una connessione per ogni metodo
            
            String query = "SELECT `id_competition`, `name`, `price`, `date`, `location` FROM `competition` WHERE 1"; 
            
            ResultSet aa = stmt.executeQuery(query);
            
            while (aa.next())
            {
                String id = aa.getString("id_competition");
                Integer id_c = Integer. parseInt(id);
                
                String name = aa.getString("name");
                
                String prezzo = aa.getString("price");
                float prezzo_c = Float.parseFloat(prezzo);
                
                String data = aa.getString("date");
                
                String location = aa.getString("location");
                
                list.add(new Competition(id_c,name,data,location,prezzo_c));
               
                
            }
            stmt.close();
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        id_gara.setCellValueFactory(new PropertyValueFactory<Competition,Integer>("id_gara"));
        nome_gara.setCellValueFactory(new PropertyValueFactory<Competition,String>("nome_gara"));
        prezzo_gara.setCellValueFactory(new PropertyValueFactory<Competition,Float>("prezzo_gara"));
        data_gara.setCellValueFactory(new PropertyValueFactory<Competition,String>("data_gara"));
        luogo_gara.setCellValueFactory(new PropertyValueFactory<Competition,String>("luogo_gara"));
   
        tabella.setItems(list);
        
    }
    
    //anchorPane per l'iscrizione ad una gara
    @FXML
    private void iscrivi(ActionEvent event) {
        try {
            
            Socket socketConnection = new Socket("127.0.0.1", 11111);
            //QUERY PASSING
            DataOutputStream outToServer = new DataOutputStream(socketConnection.getOutputStream());
            BufferedReader inDalServer = new BufferedReader(new InputStreamReader(socketConnection.getInputStream()));
            //controllo se il socio abbia selezionato i metodi di pagamento
            if(cartacredit.isSelected()){
                outToServer.writeUTF("iscrivi_gara");
                outToServer.writeUTF(txt_nome_barca.getText());
                outToServer.writeUTF(txt_cf.getText());
                outToServer.writeUTF(txt_id_gara.getText());
                outToServer.writeUTF(txt_importo.getText());
                outToServer.writeUTF(psw_convalida_iscr_gara.getText());
                outToServer.writeUTF("1");
            }
            else if(ibann.isSelected()){
                 outToServer.writeUTF("iscrivi_gara");
                outToServer.writeUTF(txt_nome_barca.getText());
                outToServer.writeUTF(txt_cf.getText());
                outToServer.writeUTF(txt_id_gara.getText());
                outToServer.writeUTF(txt_importo.getText());
                outToServer.writeUTF(psw_convalida_iscr_gara.getText());
                outToServer.writeUTF("0");
            }
                
            
            
            String ricevuto_ut = inDalServer.readLine();
            System.out.println(ricevuto_ut); 
            if(ricevuto_ut.equals("error")){
                label_warning_iscr.setText("errore di credenziali durante l'iscrizione alla gara");
            }else if(ricevuto_ut.equals("noterr")){
                label_warning_iscr.setText("");
            }
        } catch (Exception e) 
        {
            System.out.println(e); 
        }
        
        log_effettuato.setVisible(true);
        iscrizione_gara.setVisible(false);
        
        
    }
    
    //anchorPane per la registrazione di un nuovo socio
    @FXML
    private void esegui_registrazione(ActionEvent event) {
        welcome.setVisible(false);
        registrazione.setVisible(true);
        
        
    }
    @FXML
    private void conferma_registrazione(ActionEvent event) {
        try {
            Socket socketConnection = new Socket("127.0.0.1", 11111);
            //QUERY PASSING
            DataOutputStream outToServer = new DataOutputStream(socketConnection.getOutputStream());
            
            outToServer.writeUTF("registration");
            outToServer.writeUTF(campo_cf.getText());
            outToServer.writeUTF(campo_username.getText());
            outToServer.writeUTF(campo_password.getText());
            outToServer.writeUTF(campo_first_name.getText());
            outToServer.writeUTF(campo_last_name.getText());
            outToServer.writeUTF(campo_address.getText());
            outToServer.writeUTF(campo_credit_card.getText());
            outToServer.writeUTF(campo_iban.getText());
            
        } catch (Exception e) 
        {
            System.out.println(e); 
        }
        welcome.setVisible(true);
        registrazione.setVisible(false);
        
    }
    
    
    @FXML
    private void esegui_pagamento_iscizione(ActionEvent event) {
        log_effettuato.setVisible(false);
        pagamento_iscrizione.setVisible(true);
        
        
    }
    
    @FXML
    private void paga_nuova_iscrizione(ActionEvent event) {
        
        try {
            
            Socket socketConnection = new Socket("127.0.0.1", 11111);
            //QUERY PASSING
            DataOutputStream outToServer = new DataOutputStream(socketConnection.getOutputStream());
            BufferedReader inDalServer = new BufferedReader(new InputStreamReader(socketConnection.getInputStream()));
            if(carta_c_p.isSelected()){
                outToServer.writeUTF("pagamento_iscrizione");
                outToServer.writeUTF(cf_pagamento_p.getText());
                outToServer.writeUTF(psw_conv_pag.getText());
                outToServer.writeUTF("1");
            }
            else if(iban_p.isSelected()){
                 outToServer.writeUTF("pagamento_iscrizione");
                outToServer.writeUTF(cf_pagamento_p.getText());
                outToServer.writeUTF(psw_conv_pag.getText());
                outToServer.writeUTF("0");
            }
                
           
            String ricevuto_err = inDalServer.readLine();
            System.out.println(ricevuto_err); 
            if(ricevuto_err.equals("error")){
                
                warning.setText("errore nel pagamento");
            }else{
                warning.setText("");
            }
        } catch (Exception e) 
        {
            System.out.println(e); 
        }
        
        //rendo visibili tutti i bottoni per le opzioni possibili che puo svolgere l'utente
        log_effettuato.setVisible(true);
        btn_new_boat.setVisible(true);
        btn_removeboat.setVisible(true);
        btn_iscr_gara.setVisible(true);
        pagamento_iscrizione.setVisible(false);
        
      
        
    }
    
    @FXML
    private void paga_rimessaggio_barca(ActionEvent event) {
        log_effettuato.setVisible(false);
        pagamento_rimessaggio_b.setVisible(true);
        
        
    }
    
    @FXML
    private void calcola(ActionEvent event) {
        
        float num= Float.parseFloat(txt_lung.getText());
        float calcolo=num*5;
        
        l_lung.setText(Float.toString(calcolo));
    }
    
    
    @FXML
    private void pay_lung(ActionEvent event) {
        try {
            
            Socket socketConnection = new Socket("127.0.0.1", 11111);
            //QUERY PASSING
            DataOutputStream outToServer = new DataOutputStream(socketConnection.getOutputStream());
            BufferedReader inDalServer = new BufferedReader(new InputStreamReader(socketConnection.getInputStream()));
            if(cc_lung.isSelected()){
                outToServer.writeUTF("pagamento_rimessaggio");
                outToServer.writeUTF(cf_lung.getText());
                outToServer.writeUTF(l_lung.getText());
                outToServer.writeUTF(psw_con_pag_barca.getText());
                outToServer.writeUTF("1");
            }
            else if(iban_lung.isSelected()){
                outToServer.writeUTF("pagamento_rimessaggio");
                outToServer.writeUTF(cf_lung.getText());
                outToServer.writeUTF(l_lung.getText());
                outToServer.writeUTF(psw_con_pag_barca.getText());
                outToServer.writeUTF("0");
            }
            
            String ricevuto_err = inDalServer.readLine();
            System.out.println(ricevuto_err); 
            if(ricevuto_err.equals("error")){
                
                warning.setText("errore nel pagamento del rimessaggio");
            }else{
                warning.setText("");
            }
            
            
        } catch (Exception e) 
        {
            System.out.println(e); 
        }
        
        log_effettuato.setVisible(true);
        pagamento_rimessaggio_b.setVisible(false);
        
        
    }
    @FXML
    private void rim_soci(ActionEvent event) {
      
        try {
            Socket socketConnection = new Socket("127.0.0.1", 11111);
            //QUERY PASSING
            DataOutputStream outToServer = new DataOutputStream(socketConnection.getOutputStream());
            
            outToServer.writeUTF("rm_socio");
            outToServer.writeUTF(cf_gest_soci.getText());
            
            
        } catch (Exception e) 
        {
            System.out.println(e); 
        }
        personale_general.setVisible(true);
        gest_soc.setVisible(false);
    }
    @FXML
    private void rim_imbarcazione_gest(ActionEvent event) {
        try {
            Socket socketConnection = new Socket("127.0.0.1", 11111);
            //QUERY PASSING
            DataOutputStream outToServer = new DataOutputStream(socketConnection.getOutputStream());
            
            outToServer.writeUTF("rm_imbarcazione");
            outToServer.writeUTF(ig_gest_imb.getText());
            
            
        } catch (Exception e) 
        {
            System.out.println(e); 
        }
        personale_general.setVisible(true);
        gest_imb.setVisible(false);
    }
    @FXML
    //anchorPane per la rimozione delle gare da parte del socio
    private void rm_gest_gara(ActionEvent event) {
        try {
            Socket socketConnection = new Socket("127.0.0.1", 11111);
            //QUERY PASSING
            DataOutputStream outToServer = new DataOutputStream(socketConnection.getOutputStream());
            outToServer.writeUTF("rm_gara");
            outToServer.writeUTF(txt_gest_gare.getText());
            
            
        } catch (Exception e) 
        {
            System.out.println(e); 
        }
        personale_general.setVisible(true);
        gest_gare.setVisible(false);
    }
    
    @FXML
    private void agg_gara(ActionEvent event) {
       
        ins_gara.setVisible(true);
        gest_gare.setVisible(false);
        
    }
    
    //per inserire una nuova gara da parte del personale
    @FXML
    private void button_registra_gara(ActionEvent event) {
        
           
        
        try {
            Socket socketConnection = new Socket("127.0.0.1", 11111);
            //QUERY PASSING
            
            
            DataOutputStream outToServer = new DataOutputStream(socketConnection.getOutputStream());
            
            outToServer.writeUTF("registration_gara");
            outToServer.writeUTF(txt_id_gara_.getText());
            outToServer.writeUTF(txt_prezzo.getText());
            outToServer.writeUTF(txt_data.getText());
            outToServer.writeUTF(txt_location.getText());
            
            
            
        } catch (Exception e) 
        {
            System.out.println(e); 
        }
        personale_general.setVisible(true);
        ins_gara.setVisible(false);
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
