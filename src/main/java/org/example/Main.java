package org.example;

import java.util.Scanner;

public class Main {

    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "password123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (isEmpty(username, password)) {
            System.out.println("Login failed: username and password are required.");
        } else if (isValidLogin(username, password)) {
            System.out.println("Login successful. Welcome, " + username + "!");
        } else {
            System.out.println("Login failed: incorrect username or password.");
        }

        scanner.close();
    }

    public static boolean isEmpty(String username, String password) {
        return username.isBlank() || password.isBlank();
    }

    public static boolean isValidLogin(String username, String password) {
        return username.equals(CORRECT_USERNAME)
                && password.equals(CORRECT_PASSWORD);
    }
}