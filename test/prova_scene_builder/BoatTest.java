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
public class BoatTest {
    
    public BoatTest() {
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
    public void testGetId_boat() {
        System.out.println("getId_boat");
        Boat instance = new Boat(1, "SpingereCavallo",  "PWGRYN96L10", 15);
        int expResult = 1;
        int result = instance.getId_boat();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testSetId_boat() {
        System.out.println("setId_boat");
        int id_boat = 1;
        Boat instance = new Boat(2, "SpingereCavallo",  "PWGRYN96L10", 15);
        instance.setId_boat(id_boat);
    }

    
    @Test
    public void testGetName() {
        System.out.println("getName");
        Boat instance = new Boat(2, "SpingereCavallo",  "PWGRYN96L10", 15);
        String expResult = "SpingereCavallo";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Pippo";
        Boat instance = new Boat(2, "SpingereCavallo",  "PWGRYN96L10", 15);
        instance.setName(name);
    }

    
    @Test
    public void testGetFk_socio() {
        System.out.println("getFk_socio");
        Boat instance = new Boat(2, "SpingereCavallo",  "PWGRYN96L10", 15);
        String expResult = "PWGRYN96L10";
        String result = instance.getFk_socio();
        assertEquals(expResult, result);
    }

    
    @Test
    public void testSetFk_socio() {
        System.out.println("setFk_socio");
        String fk_socio = "YWBPLN98B28";
        Boat instance = new Boat(2, "SpingereCavallo",  "PWGRYN96L10", 15);
        instance.setFk_socio(fk_socio);
    }

    
    @Test
    public void testGetLenght() {
        System.out.println("getLenght");
        Boat instance = new Boat(2, "SpingereCavallo",  "PWGRYN96L10", 15);
        float expResult = 15.0F;
        float result = instance.getLenght();
        assertEquals(expResult, result, 0.0);
    }
    
    
    @Test
    public void testSetLenght() {
        System.out.println("setLenght");
        float lenght = 12.0F;
        Boat instance = new Boat(2, "SpingereCavallo",  "PWGRYN96L10", 15);
        instance.setLenght(lenght);
    }
}
