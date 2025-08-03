
package com.mycompany.mavenproject5;

/**
 *
 * @author adrianf
 */
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Chatapp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);//using scanner for input
        System.out.println("What is your username");
        String username = input.next();
        System.out.println("What is your password?");
        String password = input.next();
        System.out.println("What is your cell phone number?");
        String phonenumber = input.next();
        Registration user = new Registration(username, password, phonenumber);//initialises the constructor in the Registration class
        while (user.registeruser().equals("Try again")) {
        }

        Login users = new Login(user);//initialises the constructor in the login class

        System.out.println("Username?");
        String attemptname = input.next();
        System.out.println("Password?");
        String attemptpassword = input.next();
        boolean result = users.loginUser(attemptname, attemptpassword);

        while (result == false) {//while loop to run until the user has successfully logged in
            System.out.println("Username?");
            attemptname = input.next();
            System.out.println("Password?");
            attemptpassword = input.next();
            result = users.loginUser(attemptname, attemptpassword);

        }

        System.out.println("Welcome to Quick chat");

        int numberofMessages;
        String MessageID = " ";
        String cellphone;
        int choice;
        Message messages = new Message();
        choice = Integer.parseInt(JOptionPane.showInputDialog("Option send messages: Enter 1, Option Show recently sent messages: Enter 2, Option quit: enter 3"));

        if (choice == 2) {
            System.out.println("Coming soon");

        } else {

            while ((choice == 1)) {//continues running as long as they enter 1 to send messages
                boolean incorrectmessage;
                String message;
                System.out.println("How many messages do you want to enter");

                numberofMessages = input.nextInt();
                messages.setBuilder();
                for (int j = 0; j < numberofMessages; j++) {//this for loop will run until all the chosen number of messages have been sent
                    input.nextLine();
                    do {//this do while will loop if the messages or recipient numbers are  incorrectly formatted

                        System.out.println("Enter your message");

                        message = input.nextLine();

                        System.out.println("Enter your recipients phone number");
                        cellphone = input.nextLine();
                        incorrectmessage = !(messages.checkMessage(message)) || !(messages.checkRecipientCell(cellphone) == true);//this checks whether the message and recipient number are in the correct format

                    } while (incorrectmessage);
                    do {//this do while will continue to loop if the message id is incorrect

                        MessageID = messages.generateMessageID();
                        System.out.println(MessageID);
                    } while (!(messages.checkMessageID(MessageID)));

                    messages = new Message(cellphone, message, MessageID, phonenumber);//this initialises the Messages class constructor
                    do {//this do while will loop until you enter a correct action

                        System.out.println("To send enter:0, press 1 to delete message, to save enter:2");

                    } while (messages.SentMessage(input.nextInt()).equalsIgnoreCase("Enter a valid action"));

                }

                System.out.println(messages.printMessages());
                System.out.println("The longest sent message: " + messages.getlongestmessage());

                System.out.println("Enter your desired recipients phone number");
                System.out.println(messages.searchbyrecipient(input.next()));
                System.out.println("List of all sent message, message ids: " + messages.getIDArrayList());
                System.out.println("Enter the messageid of the message you want to find");
                System.out.println(messages.searchwithMessageID(input.next()));

                System.out.println("List of all sent message hashes: " + messages.getHashArrayList());
                System.out.println("Enter the message hash of the message you want to delete");
                System.out.println(messages.deleteByhash(input.next()));
                System.out.println("All sent messages:" + messages.getallMessagesArrayList());
                System.out.println("Total number of  successfully stored messages: " + messages.returnTotalMessages());
                System.out.println("The details of all sent messages: " + messages.returnallMessagedetails());
                messages.clearAllMessages();
                System.out.println("Enter 1 to continue enter anything else to stop");
                choice = input.nextInt();

            }
        }
    }
}
