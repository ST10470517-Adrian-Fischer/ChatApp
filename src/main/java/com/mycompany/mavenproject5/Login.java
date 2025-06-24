/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject5;

/**
 *
 * @author nolaf
 */

public class Login {

    private Registration user;

    public Login(Registration user) {
        this.user = user;
    }

    public boolean loginUser(String attemptname, String attemptpassword) {
        boolean correct4;

        if (attemptname.equals(user.getUsername()) && (attemptpassword.equals(user.getPassword()))) {//checks if the entered username and password matches saved password and username
            System.out.println("Welcome " + attemptname + " it is great to see you again");
            correct4 = true;
            System.out.println(returnloginStatus(correct4));

        } else {
            System.out.println("Username or password is incorrect, please try again");

            correct4 = false;//returns false if the password is shorter than 8 characters
            System.out.println(returnloginStatus(correct4));

        }
        return correct4;
    }

    public String returnloginStatus(boolean correct4) {

        return String.valueOf(correct4);//returns whether the user has logged in or not
    }

}

