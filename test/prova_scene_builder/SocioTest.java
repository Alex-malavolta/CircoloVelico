/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova_scene_builder;

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
public class SocioTest {
    
    public SocioTest() {
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

    
    @Test
    public void testGetcodice_fiscale() {
        System.out.println("getcodice_fiscale");
        Socio instance = new Socio("PDZZTJ19R41F932C", "Alby", "aa", "Alberto", "DeLonghi", "Garibaldi", "0000 0000 0000 0000", "IT25H0300203280732447337385");
        String expResult = "PDZZTJ19R41F932C";
        String result = instance.getcodice_fiscale();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testSetcodice_fiscale() {
        System.out.println("setcodice_fiscale");
        String codice_fiscale = "HVWLGL18P02D621D";
        Socio instance =  new Socio("PDZZTJ19R41F932C", "Alby", "aa", "Alberto", "DeLonghi", "Garibaldi", "0000 0000 0000 0000", "IT25H0300203280732447337385");
        instance.setcodice_fiscale(codice_fiscale);
    }

    
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Socio instance = new Socio("PDZZTJ19R41F932C", "Alby", "aa", "Alberto", "DeLonghi", "Garibaldi", "0000 0000 0000 0000", "IT25H0300203280732447337385");
        String expResult = "Alby";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

   
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String Username = "Ercole";
        Socio instance = new Socio("PDZZTJ19R41F932C", "Alby", "aa", "Alberto", "DeLonghi", "Garibaldi", "0000 0000 0000 0000", "IT25H0300203280732447337385");
        instance.setUsername(Username);
    }

    
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Socio instance = new Socio("PDZZTJ19R41F932C", "Alby", "aa", "Alberto", "DeLonghi", "Garibaldi", "0000 0000 0000 0000", "IT25H0300203280732447337385");
        String expResult = "aa";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String Password = "bb";
        Socio instance = new Socio("PDZZTJ19R41F932C", "Alby", "aa", "Alberto", "DeLonghi", "Garibaldi", "0000 0000 0000 0000", "IT25H0300203280732447337385");
        instance.setPassword(Password);
    }

    
    
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Socio instance = new Socio("PDZZTJ19R41F932C", "Alby", "aa", "Alberto", "DeLonghi", "Garibaldi", "0000 0000 0000 0000", "IT25H0300203280732447337385");
        String expResult = "Alberto";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    
    
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String FirstName = "Giuseppe";
        Socio instance = new Socio("PDZZTJ19R41F932C", "Alby", "aa", "Alberto", "DeLonghi", "Garibaldi", "0000 0000 0000 0000", "IT25H0300203280732447337385");
        instance.setFirstName(FirstName);
    }

    
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Socio instance = new Socio("PDZZTJ19R41F932C", "Alby", "aa", "Alberto", "DeLonghi", "Garibaldi", "0000 0000 0000 0000", "IT25H0300203280732447337385");
        String expResult = "DeLonghi";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String LastName = "DeLuigi";
        Socio instance = new Socio("PDZZTJ19R41F932C", "Alby", "aa", "Alberto", "DeLonghi", "Garibaldi", "0000 0000 0000 0000", "IT25H0300203280732447337385");
        instance.setLastName(LastName);
    }

    
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Socio instance = new Socio("PDZZTJ19R41F932C", "Alby", "aa", "Alberto", "DeLonghi", "Garibaldi", "0000 0000 0000 0000", "IT25H0300203280732447337385");
        String expResult = "Garibaldi";
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String Address = "Ameerigo Vespucci";
        Socio instance = new Socio("PDZZTJ19R41F932C", "Alby", "aa", "Alberto", "DeLonghi", "Garibaldi", "0000 0000 0000 0000", "IT25H0300203280732447337385");
        instance.setAddress(Address);   
    }

    
    @Test
    public void testGetDeb_card() {
        System.out.println("getDeb_card");
        Socio instance = new Socio("PDZZTJ19R41F932C", "Alby", "aa", "Alberto", "DeLonghi", "Garibaldi", "0000 0000 0000 0000", "IT25H0300203280732447337385");
        String expResult = "0000 0000 0000 0000";
        String result = instance.getDeb_card();
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testSetDeb_card() {
        System.out.println("setDeb_card");
        String deb_card = "1111 1111 1111 1111";
        Socio instance = new Socio("PDZZTJ19R41F932C", "Alby", "aa", "Alberto", "DeLonghi", "Garibaldi", "0000 0000 0000 0000", "IT25H0300203280732447337385");
        instance.setDeb_card(deb_card);
    }

    
    @Test
    public void testGetIban() {
        System.out.println("getIban");
        Socio instance = new Socio("PDZZTJ19R41F932C", "Alby", "aa", "Alberto", "DeLonghi", "Garibaldi", "0000 0000 0000 0000", "IT25H0300203280732447337385");
        String expResult = "IT25H0300203280732447337385";
        String result = instance.getIban();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testSetIban() {
        System.out.println("setIban");
        String Iban = "IT81L0300203280642588564644";
        Socio instance = new Socio("PDZZTJ19R41F932C", "Alby", "aa", "Alberto", "DeLonghi", "Garibaldi", "0000 0000 0000 0000", "IT25H0300203280732447337385");
        instance.setIban(Iban);
    }
}
