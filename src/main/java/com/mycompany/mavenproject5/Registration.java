
package com.mycompany.mavenproject5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;


public class Registration {

    private static String username;
    private static String password;
    private String phonenumber;
    Scanner input = new Scanner(System.in);

    public Registration(String username, String password, String phonenumber) {
        Registration.username = username;
        Registration.password = password;
        this.phonenumber = phonenumber;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCellphone() {

        return phonenumber;
    }

    public Registration() {

    }

    public boolean checkUsername(String username) {
        boolean correct1;

        if (username.length() <= 5 && username.contains("_")) { //returns true if username is 5 or fewer characters and contains an underscore
            System.out.println("Username entered successfully");
            correct1 = true;
            System.out.println(correct1);
        } else {
            System.out.println("Username is not correctly formatted, "
                    + "please ensure that your username contains an underscore "
                    + "and is no more then 5 characters in length");
            correct1 = false;//returns false if username isn't correct
            System.out.println(correct1);
        }
        return correct1;
    }

    public boolean checkPasswordComplexity(String password) {
        boolean correct2;
        int countCase = 0;
        int countDigit = 0;

        int countspecial = 0;

        if (password.length() >= 8) {//checks if password is longer or equal to 8 characters

            for (int i = 0; i < password.length(); i++) {// loops through the password
                char ch = password.charAt(i);

                {
                    if (Character.isUpperCase(ch)) {//as this if statement is looped it checks every digit if its a capital letter
                        countCase++;//increases a counter if it finds a capital
                    } else if (Character.isDigit(ch)) {//loops through the password until it finds a digit
                        countDigit++;//increases a counter if it finds a digit
                    } else if (!(Character.isLetterOrDigit(ch)) || Character.isWhitespace(ch)) {//loops through the password until it finds a special character
                        countspecial++;//increases a counter if it finds a special character
                    }
                }
            }
            if (countCase > 0 && (countDigit > 0) && (countspecial > 0)) {//checks if all 3 counts are greater then 0
                System.out.println("Password successfully captured");
                correct2 = true;//returns true if all counts are greater than 0
                System.out.println(correct2);
            } else {
                System.out.println("Password is not correctly formatted"
                        + " please ensure that the password contains at least 8 characters,"
                        + " a capital letter,"
                        + " a number, "
                        + " and a special character");

                correct2 = false;//returns false if at least one of the counts are 0
                System.out.println(correct2);
            }

        } else {
            System.out.println("Password is not correctly formatted"
                    + " please ensure that the password contains at least 8 characters,"
                    + " a capital letter,"
                    + " a number, "
                    + " and a special character");
            correct2 = false;//returns false if the password is shorter than 8 characters
            System.out.println(correct2);
        }
        return correct2;
    }

    public boolean checkCellPhoneNumber(String phonenumber) {
        boolean correct3;
        if (phonenumber.length() <= 13 && phonenumber.length() > 3) {
//code attribution
//(OpenAI, 2025)
            //start of chatgpt code
            String regex = "^\\+27\\d{1,10}$";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(phonenumber);

            if (matcher.matches()) {
                System.out.println("Cell number successfully captured");
                correct3 = true;
                System.out.println(correct3);
            } else {
                System.out.println("Cell number is incorrectly formatted"
                        + " or does not contain an international code"
                        + ", please correct the number and try again");
                correct3 = false;
                System.out.println(correct3);
                //end of Chatgpt code       
//(OpenAI, 2025)
            }
        } else {
            System.out.println("Cell number is incorrectly formatted"
                    + " or does not contain an international code"
                    + ", please correct the number and try again");
            correct3 = false;//returns false is the  phonenumber is longer than 13 characters
            System.out.println(correct3);

        }
        return correct3;

    }

    public String registeruser() {
        String response = "";
        boolean correctusername = checkUsername(username);
        boolean correctpassword = checkPasswordComplexity(password);
        boolean correctcell = checkCellPhoneNumber(phonenumber);

        if (correctusername == true && correctpassword == true && correctcell == true) { //checks if username, password, and phonenumber are creted correcttly
            System.out.println("You have registered successfully");
            response = "You have registered successfully";
        } else {
            System.out.println("Try again");
            System.out.println("What is your username");
            username = input.next();
            System.out.println("What is your password?");
            password = input.next();
            System.out.println("What is your cell phone number?");
            phonenumber = input.next();

            //returns false if registration fails and calls the registration method again
        }

        return response;
    }
}
