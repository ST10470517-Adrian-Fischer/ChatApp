

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

        instance.SentMessage(0);
        ArrayList<String> messagearrayinitial = new ArrayList<>(Arrays.asList("Where are you? You are late! I have asked you to be on time"));
        String expResult = messagearrayinitial.get(0);

        ArrayList<String> messagearray = instance.getallMessagesArrayList();
        String result = messagearray.get(0);
        instance.resetArray();
        assertEquals(expResult.trim(), result.trim());
        instance.clearAllMessages();
    }

    @Test
    public void testSearchwithMessageID() {

        System.out.println("searchwithMessageID");
        Message instance = new Message("+2783784", "Where are you? You are late! I have asked you to be on time", "0838884567", "+276969");

        instance.createMessageHash(0);
        instance.storeMessage();
        ArrayList<String> messagearrayinitial = new ArrayList<>(Arrays.asList("Where are you? You are late! I have asked you to be on time"));

        String expResult = messagearrayinitial.get(0);

        ArrayList<String> messagearray = instance.getallMessagesArrayList();
        messagearray.add("Where are you? You are late! I have asked you to be on time");
        String result = messagearray.get(0);
        instance.resetArray();
        assertEquals(expResult.trim(), result.trim());
        instance.clearAllMessages();
    }

    @Test
    public void testSearchbyrecipient() {

        Message instance = new Message("+2783784", "Where are you? You are late! I have asked you to be on time", "0838884567", "+276969");

        instance.createMessageHash(0);
        instance.SentMessage(0);
        instance.storeMessage();
        String expResult = "Message sent:Where are you? You are late! I have asked you to be on time";
        String result = instance.searchbyrecipient("+2783784");
        instance.resetArray();
        assertEquals(expResult.trim(), result.trim());
        instance.clearAllMessages();
    }

    @Test
    public void testDeleteByhash() {
        System.out.println("deleteByhash");
        Message instance = new Message("+2783784", "Where are you? You are late! I have asked you to be on time", "0838884567", "+276969");

        instance.createMessageHash(1);
        instance.SentMessage(0);
        instance.storeMessage();
        String expResult = "[Where are you? You are late! I have asked you to be on time]";
        String result = instance.deleteByhash("08:1:WHERETIME");
        instance.resetArray();
        assertEquals(expResult.trim(), result.trim());
        instance.clearAllMessages();
    }

    @Test
    public void testGetlongestmessage() {
        System.out.println("getlongestmessage");
        Message instance = new Message("+2783784", "Where are you? You are late! I have asked you to be on time", "0838884567", "+276969");

        instance.SentMessage(0);
        String expResult = "Where are you? You are late! I have asked you to be on time";
        String result = instance.getlongestmessage();
        instance.resetArray();
        assertEquals(expResult.trim(), result.trim());
        instance.clearAllMessages();

    }

    @Test
    public void testreturnallMessagedetails() {
        System.out.println("returnallmessagedetails");
        Message instance = new Message("+2783784", "Where are you? You are late! I have asked you to be on time", "0838884567", "+276969");

        instance.SentMessage(0);
        String expResult = "Message id:0838884567:MessageHash: 08:0:WHERETIME:Recipient phonenumber: +2783784: Sent message:Where are you? You are late! I have asked you to be on time\n";
        String result = (instance.returnallMessagedetails()).toString();
        instance.resetArray();
        assertEquals(expResult.trim(), result.trim());
    }

}
