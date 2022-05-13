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
public class StaffTest {
    
    public StaffTest() {
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
    public void testGetId_staff() {
        System.out.println("getId_staff");
        Staff instance = new Staff(11, "Sara", "Rossella", "abc");
        int expResult = 11;
        int result = instance.getId_staff();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testSetId_staff() {
        System.out.println("setId_staff");
        int id_staff = 12;
        Staff instance = new Staff(11, "Sara", "Rossella", "abc");
        instance.setId_staff(id_staff);
    }

    @Test
    public void testGetFirst_name() {
        System.out.println("getFirst_name");
        Staff instance = new Staff(11, "Sara", "Rossella", "abc");
        String expResult = "Sara";
        String result = instance.getFirst_name();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testSetFirst_name() {
        System.out.println("setFirst_name");
        String first_name = "Alberta";
        Staff instance = new Staff(11, "Sara", "Rossella", "abc");
        instance.setFirst_name(first_name);
    }

    
    @Test
    public void testGetLast_name() {
        System.out.println("getLast_name");
        Staff instance = new Staff(11, "Sara", "Rossella", "abc");
        String expResult = "Rossella";
        String result = instance.getLast_name();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testSetLast_name() {
        System.out.println("setLast_name");
        String last_name = "Luiginia";
        Staff instance = new Staff(11, "Sara", "Rossella", "abc");
        instance.setLast_name(last_name);
    }

    
    @Test
    public void testGetPasswd() {
        System.out.println("getPasswd");
        Staff instance = new Staff(11, "Sara", "Rossella", "abc");
        String expResult = "abc";
        String result = instance.getPasswd();
        assertEquals(expResult, result);
    }

  
    @Test
    public void testSetPasswd() {
        System.out.println("setPasswd");
        String passwd = "cba";
        Staff instance = new Staff(11, "Sara", "Rossella", "abc");
        instance.setPasswd(passwd);
    }
}
