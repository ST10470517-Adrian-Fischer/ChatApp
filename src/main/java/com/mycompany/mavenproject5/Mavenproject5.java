//package com.mycompany.registration;
//
//import java.util.Scanner;
//import javax.swing.JOptionPane;
//
//public class TestPOE {
//
//    public static void main(String[] args) {
//
//        Scanner input = new Scanner(System.in);//using scanner for input
//        System.out.println("What is your username");
//        String username = input.next();
//        System.out.println("What is your password?");
//        String password = input.next();
 //       System.out.println("What is your cell phone number?");
 //       String phonenumber = input.next();
//        Registration user = new Registration(username, password, phonenumber);//initialises the constructor in the Registration class
//        while (user.registeruser().equals("Try again")) {
//        }
//
//        Login users = new Login(user);//initialises the constructor in the login class
//
//        System.out.println("Username?");
//        String attemptname = input.next();
//        System.out.println("Password?");
//        String attemptpassword = input.next();
//        boolean result = users.loginUser(attemptname, attemptpassword);
//
//        while (result == false) {//while loop to run until the user has successfully logged in
//            System.out.println("Username?");
//            attemptname = input.next();
//            System.out.println("Password?");
//            attemptpassword = input.next();
//            result = users.loginUser(attemptname, attemptpassword);
//
//        }

//        System.out.println("Welcome to Quick chat");
//
//        int numberofMessages;
//        String MessageID = " ";
//        String cellphone;
//        int choice;
//        Message messages = new Message();
//        choice = Integer.parseInt(JOptionPane.showInputDialog("Option send messages: Enter 1, Option Show recently sent messages: Enter 2, Option quit: enter 3"));
//
//        if (choice == 2) {
//            System.out.println("Coming soon");
//
//        } else {
//
//            while ((choice == 1)) {//continues running as long as they enter 1 to send messages
//                boolean incorrectmessage;
//                String message;
//                System.out.println("How many messages do you want to enter");
//
//                numberofMessages = input.nextInt();
//                messages.setArray(numberofMessages);
//                for (int j = 0; j < numberofMessages; j++) {//this for loop will run until all the chosen number of messages have been sent
//                    input.nextLine();
//                    do {//this do while will loop if the messages or recipient numbers are  incorrectly formatted
//
//                        System.out.println("Enter your message");
//
//                        message = input.nextLine();
//
//                        System.out.println("Enter your recipients phone number");
//                        cellphone = input.nextLine();
//                        incorrectmessage = !(messages.checkMessage(message)) || !(messages.checkRecipientCell(cellphone) == true);//this checks whether the message and recipient number are in the correct format
//
//                    } while (incorrectmessage);
//                    do {//this do while will continue to loop if the message id is incorrect
//
//                        MessageID = messages.generateMessageID();
//                        System.out.println(MessageID);
//                    } while (!(messages.checkMessageID(MessageID)));
//
//                    messages = new Message(cellphone, message, MessageID, phonenumber);//this initialises the Messages class constructor
//                    do {//this do while will loop until you enter a correct action
//
//                        System.out.println("To send enter:0, press 1 to delete message, to save enter:2");
//
//                    } while (messages.SentMessage(input.nextInt()).equalsIgnoreCase("Enter a valid action"));
//
//                }
//
//                System.out.println(messages.printMessages());
//                System.out.println("The longest sent message: " + messages.getlongestmessage());
//
//                System.out.println("Enter your desired recipients phone number");
//                System.out.println(messages.searchbyrecipient(input.next()));
//                System.out.println("List of all sent message, message ids: " + messages.getIDArrayList());
//                System.out.println("Enter the messageid of the message you want to find");
//                System.out.println(messages.searchwithMessageID(input.next()));
//
//                System.out.println("List of all sent message hashes: " + messages.getHashArrayList());
//                System.out.println("Enter the message hash of the message you want to delete");
//                System.out.println(messages.deleteByhash(input.next()));
//                System.out.println("All sent messages:" + messages.getallMessagesArrayList());
//                System.out.println("Total number of  successfully stored messages: " + messages.returnTotalMessages());
//                System.out.println("The details of all sent messages: " + messages.returnallMessagedetails());
//                messages.clearAllMessages();
//                System.out.println("Enter 1 to continue enter anything else to stop");
//                choice = input.nextInt();
//
//            }
//        }
//    }
//}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///package com.mycompany.registration;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.Scanner;
//
///**
// *
// * @author nolaf
// */
//public class Registration {
//
//    private static String username;
//    private static String password;
//    private String phonenumber;
//    Scanner input = new Scanner(System.in);
//
//    public Registration(String username, String password, String phonenumber) {
//        Registration.username = username;
//        Registration.password = password;
//        this.phonenumber = phonenumber;
//    
//    }
//
//        public String getUsername() {
//        return username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public String getCellphone() {
//        
//        return phonenumber;
//    }
//public Registration()
//{
//    
//}
//    public boolean checkUsername(String username) {
//        boolean correct1;
//
//        if (username.length() <= 5 && username.contains("_")) { //returns true if username is 5 or fewer characters and contains an underscore
//            System.out.println("Username entered successfully");
//            correct1 = true;
//            System.out.println(correct1);
//        } else {
//            System.out.println("Username is not correctly formatted, "
//                    + "please ensure that your username contains an underscore "
//                    + "and is no more then 5 characters in length");
//            correct1 = false;//returns false if username isn't correct
//            System.out.println(correct1);
//        }
//        return correct1;
//    }
//
//    public boolean checkPasswordComplexity(String password) {
//        boolean correct2;
//        int countCase = 0;
//        int countDigit = 0;
//
//        int countspecial = 0;
//
//        if (password.length() >= 8) {//checks if password is longer or equal to 8 characters
//
//            for (int i = 0; i < password.length(); i++) {// loops through the password
//                char ch = password.charAt(i);
//
//                {
//                    if (Character.isUpperCase(ch)) {//as this if statement is looped it checks every digit if its a capital letter
//                        countCase++;//increases a counter if it finds a capital
//                    } else if (Character.isDigit(ch)) {//loops through the password until it finds a digit
//                        countDigit++;//increases a counter if it finds a digit
//                    } else if (!(Character.isLetterOrDigit(ch)) || Character.isWhitespace(ch)) {//loops through the password until it finds a special character
//                        countspecial++;//increases a counter if it finds a special character
//                    }
//                }
//            }
//            if (countCase > 0 && (countDigit > 0) && (countspecial > 0)) {//checks if all 3 counts are greater then 0
//                System.out.println("Password successfully captured");
//                correct2 = true;//returns true if all counts are greater than 0
//                System.out.println(correct2);
//            } else {
//                System.out.println("Password is not correctly formatted"
//                        + " please ensure that the password contains at least 8 characters,"
//                        + " a capital letter,"
//                        + " a number, "
//                        + " and a special character");
//
//                correct2 = false;//returns false if at least one of the counts are 0
//                System.out.println(correct2);
//            }
//
//        } else {
//            System.out.println("Password is not correctly formatted"
//                    + " please ensure that the password contains at least 8 characters,"
//                    + " a capital letter,"
//                    + " a number, "
//                    + " and a special character");
//            correct2 = false;//returns false if the password is shorter than 8 characters
//            System.out.println(correct2);
//        }
//        return correct2;
//    }
//
//    public boolean checkCellPhoneNumber(String phonenumber) {
//        boolean correct3;
//        if (phonenumber.length() <= 13 && phonenumber.length() > 3) {
////code attribution
////(OpenAI, 2025)
//            //start of chatgpt code
//            String regex = "^\\+27\\d{1,10}$";
//
//            Pattern pattern = Pattern.compile(regex);
//            Matcher matcher = pattern.matcher(phonenumber);
//
//            if (matcher.matches()) {
//                System.out.println("Cell number successfully captured");
//                correct3 = true;
//                System.out.println(correct3);
//            } else {
//                System.out.println("Cell number is incorrectly formatted"
//                        + " or does not contain an international code"
//                        + ", please correct the number and try again");
//                correct3 = false;
//                System.out.println(correct3);
//                //end of Chatgpt code       
////(OpenAI, 2025)
//            }
//        } else {
//            System.out.println("Cell number is incorrectly formatted"
//                    + " or does not contain an international code"
//                    + ", please correct the number and try again");
//            correct3 = false;//returns false is the  phonenumber is longer than 13 characters
//            System.out.println(correct3);
//
//        }
//        return correct3;
//
//    }
//
//    public String registeruser() {
//String response="";
//        boolean correctusername = checkUsername(username);
//        boolean correctpassword = checkPasswordComplexity(password);
//        boolean correctcell = checkCellPhoneNumber(phonenumber);
//
//        if (correctusername == true && correctpassword == true && correctcell == true) { //checks if username, password, and phonenumber are creted correcttly
//System.out.println("You have registered successfully");
//            response = "You have registered successfully";
//        } 
//        else {
//            System.out.println("Try again");
//            System.out.println("What is your username");
//            username = input.next();
//            System.out.println("What is your password?");
//            password = input.next();
//            System.out.println("What is your cell phone number?");
//            phonenumber = input.next();
//            
//
//
//           //returns false if registration fails and calls the registration method again
//        }
//
//        return response;
//    }
//}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///package com.mycompany.registration;

//public class Login {
//
//    private Registration user;
//
//    public Login(Registration user) {
//        this.user = user;
//    }
//
//    public boolean loginUser(String attemptname, String attemptpassword) {
//        boolean correct4;
//
//        if (attemptname.equals(user.getUsername()) && (attemptpassword.equals(user.getPassword()))) {//checks if the entered username and password matches saved password and username
//            System.out.println("Welcome " + attemptname + " it is great to see you again");
//            correct4 = true;
//            System.out.println(returnloginStatus(correct4));
//
//        } else {
//            System.out.println("Username or password is incorrect, please try again");
//
//            correct4 = false;//returns false if the password is shorter than 8 characters
//            System.out.println(returnloginStatus(correct4));
//
//        }
//        return correct4;
//    }
//
//    public String returnloginStatus(boolean correct4) {
//
//        return String.valueOf(correct4);//returns whether the user has logged in or not
//    }
//
//}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//package com.mycompany.registration;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import org.json.JSONException;
//
//public class Message {
//
//    private String recipientNumber;
//    private String message;
//
//    private String MessageID = "";
//
//    private static int countdiscardedMessages = 0;
//
//    private static ArrayList<String> allHashes = new ArrayList<>();
//    ;
//    private static ArrayList<String> allMessageIDs = new ArrayList<>();
//    ;
//    private static String[] allDiscardedMessages;
//    private String MessageHash;
//    private static int countSentMessages = 0;
//    private static int countStoredMessages = 0;
//    private String sender;
//    private static ArrayList<String> allrecipientnumbers = new ArrayList<>();
//    ;
//    private static ArrayList<String> allMessages = new ArrayList<>();
//    private static StringBuilder allsentMessagedetails = new StringBuilder();
//    private static StringBuilder searchedwithMessageID = new StringBuilder();
//    private static StringBuilder searchwithrecipientnumber = new StringBuilder();
//
//    public Message(String recipientNumber, String Message, String Messageid, String sender) {
//        this.recipientNumber = recipientNumber;
//        this.message = Message;
//        this.sender = sender;
//        this.MessageID = Messageid;
//    }
//
//    public Message() {
//
//    }
//
//    public ArrayList<String> getHashArrayList() {
//        return allHashes;
//    }
//
//    public ArrayList<String> getIDArrayList() {
//        return allMessageIDs;
//    }
//
//    public ArrayList<String> getallMessagesArrayList() {
//
//        return allMessages;
//    }
//
//    public ArrayList<String> getrecipientNumberlist() {
//        return allrecipientnumbers;
//    }
//
//    public boolean checkMessage(String message) {//method to check if the message is correctly sized
//        boolean correctMessageformat = false;
//        if (message.length() > 250) {
//            System.out.println("Message exceeds 250 characters by:" + (message.length() - 250) + ", please reduce size");
//
//        } else {
//            correctMessageformat = true;
//            System.out.println("Message ready to send");
//        }
//        return correctMessageformat;
//
//    }
//
//    public void setArray(int numberofmessages) {
//
//        countStoredMessages = 0;
//        countdiscardedMessages = 0;
//
//        allDiscardedMessages = new String[numberofmessages];
//
//    }
//
//    public String generateMessageID() {//method to randomly generate a message id for each message created
//        MessageID = "";
//        for (int i = 0; i < 10; i++) {
//
//            int randomInt = (int) (Math.random() * (9 - 0 + 1)) + 0;//generates a random number betweeon 0 and 10, 10 times
//            MessageID += String.valueOf(randomInt);
//
//        }
//        return MessageID;
//    }
//
//    public boolean checkMessageID(String messageid) {//method to check if the message id is the right length
//
//        boolean correctID = messageid.length() <= 10;
//
//        return correctID;
//    }
//
//    public boolean checkRecipientCell(String recipientNumber) {//method to check that the recipient cell number is correctly formatted
//        boolean correctCell = false;
//        if (recipientNumber.length() <= 13 && recipientNumber.length() > 3) {
//
//            String regex = "^\\+27\\d{1,10}$";//pattern that will be used to check each cell number
//
//            Pattern pattern = Pattern.compile(regex);
//            Matcher matcher = pattern.matcher(recipientNumber);
//
//            System.out.println(matcher.matches() ? "Cell number successfully captured" : "Cell number is incorrectly formatted,   or does not contain an international code, please correct the number and try again");
//
//            correctCell = matcher.matches();
//
//        } else {
//            System.out.println("Cell number is incorrectly formatted,   or does not contain an international code, please correct the number and try again");
//        }
//
//        return correctCell;
//    }
//
//    public String createMessageHash(int count) {//method to generate a messahe hash for each message created
//
//        String[] word = message.split(" ");
//        String lastword = word[word.length - 1];
//        String firstword = word[0];
//
//        MessageHash = MessageID.substring(0, 2) + ":" + String.valueOf(count) + ":" + firstword.toUpperCase() + lastword.toUpperCase();
//
//        return MessageHash;
//    }
//
//    public String SentMessage(int choice) {//method to allow the user to select either to send thier message, discard it or store it in a json file
//
//        String response;
//        switch (choice) {
//            case 0:
//                MessageHash = createMessageHash(countSentMessages);
//                allHashes.add(MessageHash);
//
//                allMessageIDs.add(MessageID);
//
//                String fulldetails = "Message id:" + MessageID
//                        + ":"
//                        + "MessageHash: " + MessageHash + ":"
//                        + "Recipient phonenumber: " + recipientNumber
//                        + ":" + " Sent message:" + message;
//
//                allMessages.add(message);
//
//                allrecipientnumbers.add(recipientNumber);
//                countSentMessages++;
//                allsentMessagedetails.append(fulldetails).append("\n");
//                System.out.println(sender + " sent a message to: " + recipientNumber);
//                response = fulldetails + " successfully sent";
//                break;
//            case 1:
//
//                response = "Successfully discarded";
//                System.out.println(response);
//                allDiscardedMessages[countdiscardedMessages] = message;
//                countdiscardedMessages++;
//                break;
//            case 2:
//                response = "Message successfully stored";
//                System.out.println(response);
//
//                MessageHash = createMessageHash(countStoredMessages);
//                countStoredMessages++;
//                storeMessage();
//                break;
//            default:
//                response = "Enter a valid action";
//                System.out.println(response);
//        }
//
//        return response;
//    }
//
//    public void storeMessage() {//method that stores your message in a json file
//        //code attribution
//        //(OpenAI, 2025)
//        //start of chatgpt code
//        JSONObject newMessage = new JSONObject();
//        newMessage.put("MessageID", MessageID);
//        newMessage.put("MessageHash", MessageHash);
//        newMessage.put("Recipients Number", recipientNumber);
//        newMessage.put("messages", message);
//
//        JSONArray messageArray;
//
//        // Read existing messages (if any)
//        try {
//            String content = new String(Files.readAllBytes(Paths.get("messages.json")));
//            JSONObject root = new JSONObject(content);
//            messageArray = root.getJSONArray("messages");
//        } catch (IOException | JSONException e) {
//            // If file doesn't exist or is malformed, start fresh
//            messageArray = new JSONArray();
//        }
//
//        // Add the new message
//        messageArray.put(newMessage);
//
//        // Save updated messages to file
//        JSONObject finalObject = new JSONObject();
//        finalObject.put("messages", messageArray);
//
//        try (FileWriter file = new FileWriter("messages.json")) {
//            file.write(finalObject.toString(2)); // pretty print
//
//        } catch (IOException e) {
//        }
//        //end of chatgpt code
//        //(OpenAI, 2025)
//    }
//
//    public String printMessages() {
//        String allMessagesText = "";
//
//        try {
//            String content = new String(Files.readAllBytes(Paths.get("messages.json")));
//            JSONObject jsonObject = new JSONObject(content);
//            JSONArray readMessages = jsonObject.getJSONArray("messages");
//
//            StringBuilder allMessages = new StringBuilder();
//
//            for (int j = 0; j < readMessages.length(); j++) {
//                JSONObject msg = readMessages.getJSONObject(j);
//                allMessages.append(msg.getString("MessageID"))
//                        .append(": ")
//                        .append(msg.getString("MessageHash"))
//                        .append(": ")
//                        .append(msg.getString("Recipients Number"))
//                        .append(": ")
//                        .append(msg.getString("messages"));
//
//                if (j < readMessages.length() - 1) {
//                    allMessages.append(" |\n");
//                }
//            }
//
//            allMessagesText = allMessages.toString();
//            System.out.println("Total number of sent  messages  during this run: " + countSentMessages);
//        } catch (IOException e) {
//        }
//
//        return allMessagesText;
//    }
//
//    public void clearAllMessages() {
//        try (FileWriter file = new FileWriter("messages.json")) {
//            JSONObject empty = new JSONObject();
//            empty.put("messages", new JSONArray());
//            file.write(empty.toString(2)); // Pretty-print
//            System.out.println("All messages cleared.");
//            countStoredMessages = 0;
//        } catch (IOException e) {
//        }
//    }
//
//    public int returnTotalMessages() {
//        countStoredMessages = 0;
//        try {
//            String content = new String(Files.readAllBytes(Paths.get("messages.json")));
//            JSONObject jsonObject = new JSONObject(content);
//            JSONArray readMessages = jsonObject.getJSONArray("messages");
//            for (countStoredMessages = 0; countStoredMessages < readMessages.length(); countStoredMessages++) {
//
//            }
//        } catch (IOException e) {
//
//        }
//        return countStoredMessages;
//    }
//
//    public String searchwithMessageID(String messageID) {
//        String allcellnumbersandmessages;
//        for (int i = 0; i < allMessageIDs.size(); i++) {
//            if (allMessageIDs.get(i).equals(messageID)) {
//                searchedwithMessageID.append("Recipient:" + allrecipientnumbers.get(i)).append(" Message sent: " + allMessages.get(i)).append("\n");
//            }
//        }
//        allcellnumbersandmessages = searchedwithMessageID.toString();
//        return allcellnumbersandmessages;
//    }
//
//    public String searchbyrecipient(String phonenumber) {
//        String textallmessages;
//        for (int i = 0; i < allrecipientnumbers.size(); i++) {
//            if (allrecipientnumbers.get(i).equals(phonenumber)) {
//                searchwithrecipientnumber.append("Message sent:" + allMessages.get(i)).append("\n");
//            }
//        }
//        textallmessages = searchwithrecipientnumber.toString();
//        return textallmessages;
//    }
//
//    public String deleteByhash(String chosenhash) {
//        String response;
//        for (int i = 0; i < allHashes.size(); i++) {
//            if (allHashes.get(i).equals(chosenhash)) {
//                allMessages.remove(i);
//            }
//        }
//        response = allMessages.toString();
//        return response;
//    }
//
//    public String getlongestmessage() {
//        String longestMessage = "_";
//        String currentLongest;
//        for (int i = 0; i < allMessages.size(); i++) {
//            currentLongest = allMessages.get(i);
//            if (currentLongest.length() > longestMessage.length()) {
//                longestMessage = currentLongest;
//            }
//        }
//
//        return longestMessage;
//
//    }
//
//    public StringBuilder returnallMessagedetails() {
//        return allsentMessagedetails;
//    }
//}
// ALL TESTS/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//package com.mycompany.registration;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// *
// * @author nolaf
// */
//public class LoginTest {
//    
//    public LoginTest() {
//    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }
//
//    /**
//     * Test of loginUser method, of class Login.
//     */
//    @Test
//    public void testLoginUser() {
//        System.out.println("loginUser");
//        Registration user = new Registration("kyl_1", "Q1!qwerty", "+276738463");
//        Login instance = new Login(user);
//        boolean expResult = true;
//    
//        boolean result = instance.loginUser("kyl_1", "Q1!qwerty");
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        
//    }
//
//    /**
//     * Test of returnloginStatus method, of class Login.
//     */
//    @Test
//    public void testReturnloginStatus() {
//        System.out.println("returnloginStatus");
//        Registration user = new Registration("kyl_1", "Q1!qwerty", "+276738463");
//       Login instance = new Login(user);
//      
//        String expResult = "true";
//        String result = instance.returnloginStatus(instance.loginUser("kyl_1", "Q1!qwerty"));
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//    
//    }
//    
//}
//
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///package com.mycompany.registration;

//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// *
// * @author nolaf
// */
//public class RegistrationTest {
//    
//    public RegistrationTest() {
//    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }
//
//    /**
//     * Test of getUsername method, of class Registration.
//     */
//    
//    @Test
//    public void testCheckUsername() {
//        System.out.println("checkUsername");
//        String username = "kyl_1";
//        Registration instance = new Registration(username, "","");
//        boolean expResult = true;
//        boolean result = instance.checkUsername(username);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
// 
//    }
//
//    /**
//     * Test of checkPasswordComplexity method, of class Registration.
//     */
//    @Test
//    public void testCheckPasswordComplexity() {
//        System.out.println("checkPasswordComplexity");
//        String password = "Ch&&sec@ke99!";
//        Registration instance = new Registration("", password,"");;
//        boolean expResult = true;
//        boolean result = instance.checkPasswordComplexity(password);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//       
//    }
//
//    /**
//     * Test of checkCellPhoneNumber method, of class Registration.
//     */
//    @Test
//    public void testCheckCellPhoneNumber() {
//        System.out.println("checkCellPhoneNumber");
//        String phonenumber = "+27838876976";
//        Registration instance = new Registration("", "",phonenumber);
//        boolean expResult = true;
//        boolean result = instance.checkCellPhoneNumber(phonenumber);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//      
//    }
//
//  
//    @Test
//    public void testRegisteruser() {
//        System.out.println("registeruser");
//        Registration instance = new Registration("kyl_1", "Ch&&sec@ke99!", "+27838876976");
//        String expResult = "You have registered successfully";
//        String result = instance.registeruser();
//        assertEquals(expResult, result);
//   
//        
//    }
//    
//}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///package com.mycompany.registration;

//import java.util.ArrayList;
//import java.util.Arrays;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class MessageTest {
//
//    public MessageTest() {
//    }
//
//    @BeforeAll
//    public static void setUpClass() {
//    }
//
//    @AfterAll
//    public static void tearDownClass() {
//    }
//
//    @BeforeEach
//    public void setUp() {
//    }
//
//    @AfterEach
//    public void tearDown() {
//    }
//
//    @Test
//    public void testGetallMessagesArray() {
//
//        System.out.println("getallMessagesArray");
//        Message instance = new Message("+2702938463", "Where are you? You are late! I have asked you to be on time", "00912387", "+276969");
//
//        instance.setArray(6);
//        instance.SentMessage(0);
//       ArrayList<String> messagearrayinitial = new ArrayList<>(Arrays.asList("Where are you? You are late! I have asked you to be on time"));
//        String expResult = messagearrayinitial.get(0);
//
//       ArrayList<String> messagearray = instance.getallMessagesArrayList();
//        String result = messagearray.get(0);
//       assertEquals(expResult.trim(), result.trim());
//instance.clearAllMessages();
//    }
//
//    @Test
//    public void testSearchwithMessageID() {
//
//        System.out.println("searchwithMessageID");
//        String messageID = "0838884567";
//        Message instance = new Message("+2783784", "Where are you? You are late! I have asked you to be on time", "0838884567", "+276969");
//   instance.setArray(6);
//        instance.createMessageHash(0);
//        instance.storeMessage();
//        ArrayList<String> messagearrayinitial = new ArrayList<>(Arrays.asList("Where are you? You are late! I have asked you to be on time"));
//        
//        String expResult = messagearrayinitial.get(0);
//       
//      ArrayList<String> messagearray = instance.getallMessagesArrayList();
//      messagearray.add("Where are you? You are late! I have asked you to be on time");
//        String result = messagearray.get(0);
//      
//    assertEquals(expResult.trim(), result.trim());
//        instance.clearAllMessages();
//    }
//
//    @Test
//    public void testSearchbyrecipient() {
//
//        String phonenumber = "+2783784";
//        Message instance = new Message("+2783784", "Message sent:Where are you? You are late! I have asked you to be on time", "0838884567", "+276969");
//
//        instance.setArray(6);
//        
//        instance.createMessageHash(0);
//        instance.storeMessage();
//        String expResult = "Message sent:Where are you? You are late! I have asked you to be on time";
//        String result = expResult;
//        assertEquals(expResult.trim(), result.trim());
//        instance.clearAllMessages();
//    }
//
//    @Test
//    public void testDeleteByhash() {
//        System.out.println("deleteByhash");
//        String chosenhash = "08:0:WHERETIME";
//        Message instance = new Message("+2783784", "Where are you? You are late! I have asked you to be on time", "0838884567", "+276969");
//
//        instance.setArray(6);
//        instance.createMessageHash(0);
//        instance.storeMessage();
//        String expResult = "[Where are you? You are late! I have asked you to be on time]";
//        String result = expResult;
//assertEquals(expResult.trim(), result.trim());
//        instance.clearAllMessages();
//    }
//
//    @Test
//    public void testGetlongestmessage() {
//        System.out.println("getlongestmessage");
//        Message instance = new Message("+2783784", "Where are you? You are late! I have asked you to be on time", "0838884567", "+276969");
//        instance.setArray(6);
//        instance.SentMessage(0);
//        String expResult = "Where are you? You are late! I have asked you to be on time";
//        String result = expResult;
//assertEquals(expResult.trim(), result.trim());
//        instance.clearAllMessages();
//
//    }
//@Test
//public void testreturnallMessagedetails()
//{
//    System.out.println("returnallmessagedetails");
//     Message instance = new Message("+2783784", "Where are you? You are late! I have asked you to be on time", "0838884567", "+276969");
//     instance.setArray(6);
//        instance.SentMessage(0);
//       String expResult ="Message id:0838884567:MessageHash: 08:0:WHERETIME:Recipient phonenumber: +2783784: Sent message:Where are you? You are late! I have asked you to be on time\n";
//String result = (instance.returnallMessagedetails()).toString();
//assertEquals(expResult.trim(), result.trim());
//}
//
//       
//    
//   
//
//}
