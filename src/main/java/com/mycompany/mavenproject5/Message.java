/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject5;

/**
 *
 * @author nolaf
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.json.JSONException;

public class Message {

    private String recipientNumber;
    private String message;

    private String MessageID = "";

    private static ArrayList<String> allHashes = new ArrayList<>();

    private static ArrayList<String> allMessageIDs = new ArrayList<>();

    private String MessageHash;
    private static int countSentMessages = 0;
    private static int countStoredMessages = 0;
    private String sender;
    private static ArrayList<String> allrecipientnumbers = new ArrayList<>();

    private static ArrayList<String> allMessages = new ArrayList<>();
    private static StringBuilder allsentMessagedetails = new StringBuilder();
    private static StringBuilder searchedwithMessageID = new StringBuilder();
    private static StringBuilder searchwithrecipientnumber = new StringBuilder();

    public Message(String recipientNumber, String Message, String Messageid, String sender) {
        this.recipientNumber = recipientNumber;
        this.message = Message;
        this.sender = sender;
        this.MessageID = Messageid;
    }

    public Message() {

    }
 public void resetArray() {//this method exists soley to prevent my unit tests from failing due to arrays getting full of values that mess with the output of other unit tests. 
                           //Which is why a few unit tests fail when i run my test file all at once.
allHashes = new ArrayList<>();
    allMessageIDs = new ArrayList<>();
            allrecipientnumbers = new ArrayList<>();
            allMessages = new ArrayList<>();
            
    }
    public ArrayList<String> getHashArrayList() {
        return allHashes;
    }

    public ArrayList<String> getIDArrayList() {
        return allMessageIDs;
    }

    public ArrayList<String> getallMessagesArrayList() {

        return allMessages;
    }

    public ArrayList<String> getrecipientNumberlist() {
        return allrecipientnumbers;
    }

    public boolean checkMessage(String message) {//method to check if the message is correctly sized
        boolean correctMessageformat = false;
        if (message.length() > 250) {
            System.out.println("Message exceeds 250 characters by:" + (message.length() - 250) + ", please reduce size");

        } else {
            correctMessageformat = true;
            System.out.println("Message ready to send");
        }
        return correctMessageformat;

    }

   

    public void setBuilder() {

        countStoredMessages = 0;
        allsentMessagedetails = new StringBuilder();
        searchedwithMessageID = new StringBuilder();
        searchwithrecipientnumber = new StringBuilder();

    }

    public String generateMessageID() {//method to randomly generate a message id for each message created
        MessageID = "";
        for (int i = 0; i < 10; i++) {

            int randomInt = (int) (Math.random() * (9 - 0 + 1)) + 0;//generates a random number betweeon 0 and 10, 10 times
            MessageID += String.valueOf(randomInt);

        }
        return MessageID;
    }

    public boolean checkMessageID(String messageid) {//method to check if the message id is the right length

        boolean correctID = messageid.length() <= 10;

        return correctID;
    }

    public boolean checkRecipientCell(String recipientNumber) {//method to check that the recipient cell number is correctly formatted
        boolean correctCell = false;
        if (recipientNumber.length() <= 13 && recipientNumber.length() > 3) {

            String regex = "^\\+27\\d{1,10}$";//pattern that will be used to check each cell number

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(recipientNumber);

            System.out.println(matcher.matches() ? "Cell number successfully captured" : "Cell number is incorrectly formatted,   or does not contain an international code, please correct the number and try again");

            correctCell = matcher.matches();

        } else {
            System.out.println("Cell number is incorrectly formatted,   or does not contain an international code, please correct the number and try again");
        }

        return correctCell;
    }

    public String createMessageHash(int count) {//method to generate a messahe hash for each message created

        String[] word = message.split(" ");
        String lastword = word[word.length - 1];
        String firstword = word[0];

        MessageHash = MessageID.substring(0, 2) + ":" + String.valueOf(count) + ":" + firstword.toUpperCase() + lastword.toUpperCase();

        return MessageHash;
    }

    public String SentMessage(int choice) {//method to allow the user to select either to send thier message, discard it or store it in a json file

        String response;
        switch (choice) {
            case 0:
                MessageHash = createMessageHash(countSentMessages);
                allHashes.add(MessageHash);

                allMessageIDs.add(MessageID);

                String fulldetails = "Message id:" + MessageID
                        + ":"
                        + "MessageHash: " + MessageHash + ":"
                        + "Recipient phonenumber: " + recipientNumber
                        + ":" + " Sent message:" + message;

                allMessages.add(message);

                allrecipientnumbers.add(recipientNumber);
                countSentMessages++;
                allsentMessagedetails.append(fulldetails).append("\n");
                System.out.println(sender + " sent a message to: " + recipientNumber);
                response = fulldetails + " successfully sent";
                break;
            case 1:

                response = "Successfully discarded";
                System.out.println(response);

                break;
            case 2:
                response = "Message successfully stored";
                System.out.println(response);

                MessageHash = createMessageHash(countStoredMessages);
                countStoredMessages++;
                storeMessage();
                break;
            default:
                response = "Enter a valid action";
                System.out.println(response);
        }

        return response;
    }

    public void storeMessage() {//method that stores your message in a json file
      
        JSONObject newMessage = new JSONObject();
        newMessage.put("MessageID", MessageID);
        newMessage.put("MessageHash", MessageHash);
        newMessage.put("Recipients Number", recipientNumber);
        newMessage.put("messages", message);

        JSONArray messageArray;

        // Reads existing messages if theere are any in the json file
        try {
            String content = new String(Files.readAllBytes(Paths.get("messages.json")));
            JSONObject root = new JSONObject(content);
            messageArray = root.getJSONArray("messages");
        } catch (IOException | JSONException e) {
            // If file doesn't exist or is corrupted, it resets the json file
            messageArray = new JSONArray();
        }

     
        messageArray.put(newMessage);

        // Save updated messages to file
        JSONObject finalObject = new JSONObject();
        finalObject.put("messages", messageArray);

        try (FileWriter file = new FileWriter("messages.json")) {
            file.write(finalObject.toString(2)); 

        } catch (IOException e) {
        }
        
    }

    public String printMessages() {
        String allMessagesText = "";

        try {
            String content = new String(Files.readAllBytes(Paths.get("messages.json")));
            JSONObject jsonObject = new JSONObject(content);
            JSONArray readMessages = jsonObject.getJSONArray("messages");

            StringBuilder allMessages = new StringBuilder();

            for (int j = 0; j < readMessages.length(); j++) {
                JSONObject msg = readMessages.getJSONObject(j);
                allMessages.append(msg.getString("MessageID"))
                        .append(": ")
                        .append(msg.getString("MessageHash"))
                        .append(": ")
                        .append(msg.getString("Recipients Number"))
                        .append(": ")
                        .append(msg.getString("messages"));

                if (j < readMessages.length() - 1) {
                    allMessages.append(" |\n");
                }
            }

            allMessagesText = allMessages.toString();
            System.out.println("Total number of sent  messages  during this run: " + countSentMessages);
        } catch (IOException e) {
        }

        return allMessagesText;
    }

    public void clearAllMessages() {
        try (FileWriter file = new FileWriter("messages.json")) {
            JSONObject empty = new JSONObject();
            empty.put("messages", new JSONArray());
            file.write(empty.toString(2)); // Pretty-print
            System.out.println("All messages cleared.");
            countStoredMessages = 0;
        } catch (IOException e) {
        }
    }

    public int returnTotalMessages() {
        countStoredMessages = 0;
        try {
            String content = new String(Files.readAllBytes(Paths.get("messages.json")));
            JSONObject jsonObject = new JSONObject(content);
            JSONArray readMessages = jsonObject.getJSONArray("messages");
            for (countStoredMessages = 0; countStoredMessages < readMessages.length(); countStoredMessages++) {

            }
        } catch (IOException e) {

        }
        return countStoredMessages;
    }

    public String searchwithMessageID(String messageID) {
        String allcellnumbersandmessages;
        for (int i = 0; i < allMessageIDs.size(); i++) {
            if (allMessageIDs.get(i).equals(messageID)) {
                searchedwithMessageID.append("Recipient:").append(allrecipientnumbers.get(i)).append(" Message sent: ").append(allMessages.get(i)).append("\n");
            }
        }
        allcellnumbersandmessages = searchedwithMessageID.toString();
        return allcellnumbersandmessages;
    }

    public String searchbyrecipient(String phonenumber) {
        String textallmessages;
        for (int i = 0; i < allrecipientnumbers.size(); i++) {
            if (allrecipientnumbers.get(i).equals(phonenumber)) {
                searchwithrecipientnumber.append("Message sent:").append(allMessages.get(i)).append("\n");
            }
        }
        textallmessages = searchwithrecipientnumber.toString();
        return textallmessages;
    }

    public String deleteByhash(String chosenhash) {
        String response;
        for (int i = 0; i < allHashes.size(); i++) {
            if (allHashes.get(i).equals(chosenhash)) {
                allMessages.remove(i);
            }
        }
        response = allMessages.toString();
        return response;
    }

    public String getlongestmessage() {
        String longestMessage = "_";
        String currentLongest;
        for (int i = 0; i < allMessages.size(); i++) {
            currentLongest = allMessages.get(i);
            if (currentLongest.length() > longestMessage.length()) {
                longestMessage = currentLongest;
            }
        }

        return longestMessage;

    }

    public StringBuilder returnallMessagedetails() {
        return allsentMessagedetails;
    }
}
