/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kosti
 */
public class UnoCardTest {
    
    public UnoCardTest() {
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
     * Test of getNumber method, of class UnoCard.
     */
    @Test
    public void GoodtestGetNumber() {
        System.out.println("getNumber");
        UnoCard instance = new UnoCard(UnoCard.Color.RED,UnoCard.Number.FIVE,UnoCard.cardType.NUMBER);
        UnoCard.Number expResult = UnoCard.Number.FIVE;
        UnoCard.Number result = instance.getNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void BadtestGetNumber() {
        System.out.println("getNumber");
        UnoCard instance = new UnoCard(UnoCard.Color.RED,UnoCard.Number.FIVE,UnoCard.cardType.NUMBER);
        UnoCard.Number expResult = UnoCard.Number.FOUR;
        UnoCard.Number result = instance.getNumber();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void BoundarytestGetNumber() {
        System.out.println("getNumber");
        UnoCard instance = new UnoCard(null,null,null);
        UnoCard.Number expResult = UnoCard.Number.FOUR;
        UnoCard.Number result = instance.getNumber();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
   
    

    /**
     * Test of canPlayOn method, of class UnoCard.
     */
    @Test
    public void goodtestCanPlayOn() {
        System.out.println("canPlayOn");
        UnoCard c = new UnoCard(UnoCard.Color.RED,UnoCard.Number.FOUR,UnoCard.cardType.NUMBER);
        UnoCard instance = new UnoCard(UnoCard.Color.RED,UnoCard.Number.FIVE,UnoCard.cardType.NUMBER);
        boolean expResult = true;
        boolean result = instance.canPlayOn(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //   fail("The test case is a prototype.");
    }
    
      /**
     * Test of canPlayOn method, of class UnoCard.
     */
    @Test
    public void badtestCanPlayOn() {
        System.out.println("canPlayOn");
        UnoCard c = new UnoCard(UnoCard.Color.RED,UnoCard.Number.FOUR,UnoCard.cardType.NUMBER);
        UnoCard instance = new UnoCard(UnoCard.Color.YELLOW,UnoCard.Number.FIVE,UnoCard.cardType.NUMBER);
        boolean expResult = false;
        boolean result = instance.canPlayOn(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //   fail("The test case is a prototype.");
    }
    
    
    @Test
    public void boundarytestCanPlayOn() {
        System.out.println("canPlayOn");
        UnoCard c = new UnoCard(null,null,null);
        UnoCard instance = new UnoCard(UnoCard.Color.YELLOW,UnoCard.Number.FIVE,UnoCard.cardType.NUMBER);
        boolean expResult = false;
        boolean result = instance.canPlayOn(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //   fail("The test case is a prototype.");
    }

    
    /**
     * Test of getColor method, of class UnoCard.
     */
    @Test
    public void GoodtestGetColor() {
        System.out.println("getColor");
        UnoCard instance = new UnoCard(UnoCard.Color.RED,UnoCard.Number.FIVE,UnoCard.cardType.NUMBER);
        UnoCard.Color expResult = UnoCard.Color.RED;
        UnoCard.Color result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    
     /**
     * Test of getColor method, of class UnoCard.
     */
    @Test
    public void BadtestGetColor() {
        System.out.println("getColor");
        UnoCard instance = new UnoCard(UnoCard.Color.BLUE,UnoCard.Number.FIVE,UnoCard.cardType.NUMBER);
        UnoCard.Color expResult = UnoCard.Color.RED;
        UnoCard.Color result = instance.getColor();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

     /**
     * Test of getColor method, of class UnoCard.
     */
    @Test
    public void BoundarytestGetColor() {
        System.out.println("getColor");
        UnoCard instance = new UnoCard(null,null,null);
        UnoCard.Color expResult = UnoCard.Color.RED;
        UnoCard.Color result = instance.getColor();
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }
    
    
}
