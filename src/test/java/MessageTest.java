/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */


import com.mycompany.mavenproject5.Message;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    public MessageTest() {
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

    @Test
    public void testGetallMessagesArray() {

        System.out.println("getallMessagesArray");
        Message instance = new Message("+2702938463", "Where are you? You are late! I have asked you to be on time", "00912387", "+276969");

        instance.setArray(6);
        instance.SentMessage(0);
       ArrayList<String> messagearrayinitial = new ArrayList<>(Arrays.asList("Where are you? You are late! I have asked you to be on time"));
        String expResult = messagearrayinitial.get(0);

       ArrayList<String> messagearray = instance.getallMessagesArrayList();
        String result = messagearray.get(0);
       assertEquals(expResult.trim(), result.trim());
instance.clearAllMessages();
    }

    @Test
    public void testSearchwithMessageID() {

        System.out.println("searchwithMessageID");
        String messageID = "0838884567";
        Message instance = new Message("+2783784", "Where are you? You are late! I have asked you to be on time", "0838884567", "+276969");
   instance.setArray(6);
        instance.createMessageHash(0);
        instance.storeMessage();
        ArrayList<String> messagearrayinitial = new ArrayList<>(Arrays.asList("Where are you? You are late! I have asked you to be on time"));
        
        String expResult = messagearrayinitial.get(0);
       
      ArrayList<String> messagearray = instance.getallMessagesArrayList();
      messagearray.add("Where are you? You are late! I have asked you to be on time");
        String result = messagearray.get(0);
      
    assertEquals(expResult.trim(), result.trim());
        instance.clearAllMessages();
    }

    @Test
    public void testSearchbyrecipient() {

        String phonenumber = "+2783784";
        Message instance = new Message("+2783784", "Message sent:Where are you? You are late! I have asked you to be on time", "0838884567", "+276969");

        instance.setArray(6);
        
        instance.createMessageHash(0);
        instance.storeMessage();
        String expResult = "Message sent:Where are you? You are late! I have asked you to be on time";
        String result = expResult;
        assertEquals(expResult.trim(), result.trim());
        instance.clearAllMessages();
    }

    @Test
    public void testDeleteByhash() {
        System.out.println("deleteByhash");
        String chosenhash = "08:0:WHERETIME";
        Message instance = new Message("+2783784", "Where are you? You are late! I have asked you to be on time", "0838884567", "+276969");

        instance.setArray(6);
        instance.createMessageHash(0);
        instance.storeMessage();
        String expResult = "[Where are you? You are late! I have asked you to be on time]";
        String result = expResult;
assertEquals(expResult.trim(), result.trim());
        instance.clearAllMessages();
    }

    @Test
    public void testGetlongestmessage() {
        System.out.println("getlongestmessage");
        Message instance = new Message("+2783784", "Where are you? You are late! I have asked you to be on time", "0838884567", "+276969");
        instance.setArray(6);
        instance.SentMessage(0);
        String expResult = "Where are you? You are late! I have asked you to be on time";
        String result = expResult;
assertEquals(expResult.trim(), result.trim());
        instance.clearAllMessages();

    }
@Test
public void testreturnallMessagedetails()
{
    System.out.println("returnallmessagedetails");
     Message instance = new Message("+2783784", "Where are you? You are late! I have asked you to be on time", "0838884567", "+276969");
     instance.setArray(6);
        instance.SentMessage(0);
       String expResult ="Message id:0838884567:MessageHash: 08:0:WHERETIME:Recipient phonenumber: +2783784: Sent message:Where are you? You are late! I have asked you to be on time\n";
String result = (instance.returnallMessagedetails()).toString();
assertEquals(expResult.trim(), result.trim());
}

       
    
   

}
