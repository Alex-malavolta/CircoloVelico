/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova_scene_builder;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Silvio
 */
public class MultiTest {
    
    public MultiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of run method, of class Multi.
     */    
    
    //int id_boat, String name, String fk_socio, float lenght
    @Test
    public void testNuova_barca() {
        System.out.println("nuova_barca");
        String nome = "CP";
        float lungh = 12.0F;
        String fk_socio = "ddee";
        Boat instance = new Boat(1,"CP","ddee", (float) 12.0);
        assertEquals(instance.getName(), nome);
    }

    
    //String codice_fiscale, String Username, String Password, String FirstName,String LastName,String Address,String deb_card,String Iban
    
    @Test
    public void testRegistration() {
        System.out.println("registration");
        String Cf = "abcd";
        String username = "RECR";
        String password = "YY";
        String nome = "Riccardo";
        String cognome = "Ruberti";
        String indirizzo = "Garibaldi";
        String carta_credito = "2222 2222 2222 2222";
        String iban = "NL04ABNA7451446883";
        Socio instance = new Socio(Cf, username, password, nome, cognome, indirizzo, carta_credito, iban);
        //instance.registration(Cf, username, password, nome, cognome, indirizzo, carta_credito, iban);
        assertEquals(instance.getUsername(), username);
    }

    
    
    //lista per simulare un database di soci
    @Test
    public void testLogin() {
        List<Socio> soci = new ArrayList<Socio>();
        String username = "Silvio";
        String password = "Ronca";
        Socio instance = new Socio(username, password);
        Socio test1 = new Socio("Alberto", "Arcobaleno");
        Socio test2 = new Socio("Silvio", "Ronca");
        soci.add(test1);
        soci.add(test2);
        Boolean isSocio = false;
        for(int i=0; i<soci.size(); i++){
            if(instance.getUsername().equals(soci.get(i).getUsername()) && instance.getPassword().equals(soci.get(i).getPassword()))
               isSocio = true;
        }
         
        if(isSocio)
            System.out.println("login");
        
        else
            System.out.println("Warning socio non presente nell'elenco");
    }

    
    @Test
    public void testLogin_pers() {
        
        List<Staff> personale = new ArrayList<Staff>();
        String username = "Sara";
        String password = "SA";
        Staff instance = new Staff(username, password);
        Staff staff1 = new Staff("Sara", "SA");
        Staff staff2 = new Staff("Alberta", "AA");
        personale.add(staff1);
        personale.add(staff2);
        Boolean isStaff = false;
        for(int i=0; i<personale.size(); i++){
            if(instance.getFirst_name().equals(personale.get(i).getFirst_name()) && instance.getPasswd().equals(personale.get(i).getPasswd()))
               isStaff = true;
        }
         
        if(isStaff)
            System.out.println("login_pers");
        
        else
            System.out.println("Warning personale non presente nell'elenco");
        
    }
    
}
