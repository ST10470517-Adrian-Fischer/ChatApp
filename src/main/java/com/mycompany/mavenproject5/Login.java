
package com.mycompany.mavenproject5;


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

