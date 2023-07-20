package com.epam.training.ediary.view;

import java.io.Console;

import com.epam.training.ediary.domain.Credentials;

public class ConsoleUserView implements UserView{
    /*--properties--*/

    /*--constructors--*/
    public void ConsoleUserView() {}

    /*--methods--*/
    @Override
    public Credentials readCredentials() {

        String username;
        String password;

        Console c
        = System.console();

        System.out.println("Enter username: ");
        username = c.readLine();

        System.out.println("Enter password: ");
        password = c.readLine();

        Credentials credentials = new Credentials();
        credentials.setLoginName(username);
        credentials.setPassword(password);
        return credentials;
    }

    @Override
    public void printInvalidCredentials() {
        System.out.println("Invalid username or password!");
    }
}
