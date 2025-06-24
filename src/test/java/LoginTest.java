/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import com.mycompany.mavenproject5.Login;
import com.mycompany.mavenproject5.Registration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nolaf
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of loginUser method, of class Login.
     */
    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        Registration user = new Registration("kyl_1", "Q1!qwerty", "+276738463");
        Login instance = new Login(user);
        boolean expResult = true;
    
        boolean result = instance.loginUser("kyl_1", "Q1!qwerty");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of returnloginStatus method, of class Login.
     */
    @Test
    public void testReturnloginStatus() {
        System.out.println("returnloginStatus");
        Registration user = new Registration("kyl_1", "Q1!qwerty", "+276738463");
       Login instance = new Login(user);
      
        String expResult = "true";
        String result = instance.returnloginStatus(instance.loginUser("kyl_1", "Q1!qwerty"));
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    
    }
    
}
