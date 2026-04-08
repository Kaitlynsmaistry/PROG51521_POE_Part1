/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.prog5121_poe_part1;

import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class PROG5121_POE_PART1 {

    public static void main(String[] args) {
        // Variable declarations and initialization
        Scanner scanner = new Scanner(System.in);
        Login loginSystem = new Login();
        boolean registered = false;
        boolean loggedIn = false;
        int loginAttempts = 0;
        final int MAX_LOGIN_ATTEMPTS = 3;
        
        // Display welcome banner - using string operations
        System.out.println("==================================================");
        System.out.println("     WELCOME TO CHAT APP REGISTRATION SYSTEM      ");
        System.out.println("==================================================");
        
        // ========== REGISTRATION PHASE ==========
        System.out.println("\n--- REGISTRATION PHASE ---");
        
        while (!registered) {
            // Using Scanner for console input
            System.out.print("\nEnter username (must contain '_' and be max 5 chars): ");
            String username = scanner.nextLine().trim();
            
            System.out.print("Enter password (min 8 chars, 1 capital, 1 number, 1 special char): ");
            String password = scanner.nextLine();
            
            System.out.print("Enter South African cell phone number (format: +27XXXXXXXXX): ");
            String phoneNumber = scanner.nextLine().trim();
            
            System.out.print("Enter your first name: ");
            String firstName = scanner.nextLine().trim();
            
            System.out.print("Enter your last name: ");
            String lastName = scanner.nextLine().trim();
            
            // Call registerUser method
            String result = loginSystem.registerUser(username, password, phoneNumber, firstName, lastName);
            
            // Display registration result
            System.out.println("\n" + result);
            
            // Check if registration was successful
            if (loginSystem.getRegisteredUser() != null) {
                registered = true;
                System.out.println("\n✓ Registration completed successfully!");
                System.out.println("Please proceed to login.\n");
            } else {
                System.out.println("\n✗ Please correct the errors above and try again.\n");
            }
        }
        
        // ========== LOGIN PHASE ==========
        System.out.println("==================================================");
        System.out.println("                  LOGIN PHASE                     ");
        System.out.println("==================================================");
        
        while (!loggedIn && loginAttempts < MAX_LOGIN_ATTEMPTS) {
            System.out.print("\nEnter username: ");
            String loginUsername = scanner.nextLine().trim();
            
            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();
            
            // Call returnLoginStatus method
            String loginResult = loginSystem.returnLoginStatus(loginUsername, loginPassword);
            System.out.println(loginResult);
            
            // Call checkLoginStatus method
            if (loginSystem.checkLoginStatus(loginUsername, loginPassword)) {
                loggedIn = true;
                System.out.println("\n✓ Login successful! Welcome to Chat App!");
                System.out.println("==================================================");
                System.out.println("     YOU HAVE SUCCESSFULLY LOGGED IN              ");
                System.out.println("==================================================");
            } else {
                loginAttempts++;
                if (loginAttempts < MAX_LOGIN_ATTEMPTS) {
                    System.out.println("Attempts remaining: " + (MAX_LOGIN_ATTEMPTS - loginAttempts));
                }
            }
        }
        
        // Handle failed login attempts
        if (!loggedIn) {
            System.out.println("\n==================================================");
            System.out.println("     TOO MANY FAILED LOGIN ATTEMPTS               ");
            System.out.println("     Please try again later.                      ");
            System.out.println("==================================================");
        }
        
        // Close scanner resource
        scanner.close();
    }
}

