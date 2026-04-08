/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog5121_poe_part1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lab_services_student
 */
public class Login {
    
 // Variables and variable scope
    private User registeredUser;
    private String registrationMessage;
    private String loginStatusMessage;
    
    // Constructor
    public Login() {
        this.registeredUser = null;
        this.registrationMessage = "";
        this.loginStatusMessage = "";
    }
    
    /**
     * Method 1: Boolean checkUserName()
     * This method ensures that any username contains an underscore (_) 
     * and is no more than 5 characters long.
     * 
     * @param username The username to validate
     * @return true if username contains underscore and length <= 5, false otherwise
     */
    public boolean checkUserName(String username) {
        // Using decision structures (if statement)
        if (username == null) {
            return false;
        }
        
        // Using operators (logical AND) and method calls
        boolean containsUnderscore = username.contains("_");
        boolean isValidLength = username.length() <= 5;
        
        // Return the result using logical operator
        return containsUnderscore && isValidLength;
    }
    
    /**
     * Method 2: Boolean checkPasswordComplexity()
     * This method ensures passwords meet the following password complexity rules:
     * - At least eight characters long
     * - Contain a capital letter
     * - Contain a number
     * - Contain a special character
     * 
     * @param password The password to validate
     * @return true if meets all requirements, false otherwise
     */
    public boolean checkPasswordComplexity(String password) {
        // Using decision structure with multiple conditions
        if (password == null || password.length() < 8) {
            return false;
        }
        
        // Variables to track password requirements
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        
        // Using array iteration (characters in string behave like array)
        // Using operators and character checking
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            
            // Using Character class methods
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }
        
        // Using logical operators to combine conditions
        return hasCapital && hasNumber && hasSpecial;
    }
    
    /**
     * Method 3: boolean checkCellPhoneNumber()
     * This method ensures that the cell phone is the correct length 
     * and contains the international country code.
     * 
     * Uses regular expression for South African cell phone validation
     * Pattern: +27 followed by 9 digits (total 12 characters including +)
     * 
     * Reference: Regular expression adapted from 
     * https://www.regexplanet.com/ and Stack Overflow
     * 
     * @param phoneNumber The phone number to validate
     * @return true if valid South African cell number with international code, false otherwise
     */
    public boolean checkCellPhoneNumber(String phoneNumber) {
        // Using decision structure
        if (phoneNumber == null) {
            return false;
        }
        
        // Regular expression for South African cell phone number
        // ^ - start of string
        // \\+ - literal plus sign (escaped)
        // 27 - South African country code
        // [0-9]{9} - exactly 9 digits
        // $ - end of string
        String regex = "^\\+27[0-9]{9}$";
        
        // Using Pattern and Matcher classes (regular expressions)
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        
        return matcher.matches();
    }
    
    /**
     * Method 4: String registerUser()
     * This method returns the necessary registration message including if:
     * - The username is incorrectly formatted
     * - The password does not meet the complexity requirements
     * - The cell phone number is incorrectly formatted
     * 
     * @param username The username to register
     * @param password The password to register
     * @param cellPhoneNumber The cell phone number to register
     * @param firstName User's first name
     * @param lastName User's last name
     * @return Registration status message
     */
    public String registerUser(String username, String password, String cellPhoneNumber,
                               String firstName, String lastName) {
        // Using StringBuilder for efficient string concatenation
        StringBuilder message = new StringBuilder();
        boolean isValid = true;
        
        // Using multiple decision structures
        // Check username format
        if (!checkUserName(username)) {
            message.append("Username is not correctly formatted; please ensure that your username contains an underscore and is not more than five characters in length.\n");
            isValid = false;
        } else {
            message.append("Username successfully captured.\n");
        }
        
        // Check password complexity
        if (!checkPasswordComplexity(password)) {
            message.append("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.\n");
            isValid = false;
        } else {
            message.append("Password successfully captured.\n");
        }
        
        // Check cell phone number
        if (!checkCellPhoneNumber(cellPhoneNumber)) {
            message.append("Cell phone number incorrectly formatted or does not contain International code.\n");
            isValid = false;
        } else {
            message.append("Cell phone number successfully added.\n");
        }
        
        // If all valid, create user object
        if (isValid) {
            registeredUser = new User(username, password, cellPhoneNumber, firstName, lastName);
            message.insert(0, "Registration successful!\n");
        } else {
            message.insert(0, "Registration failed!\n");
        }
        
        registrationMessage = message.toString();
        return registrationMessage;
    }
    
    /**
     * Method 5: boolean checkLoginStatus()
     * This method verifies that the login details entered match 
     * the login details stored when the user registers.
     * 
     * @param username The username to check
     * @param password The password to check
     * @return true if login credentials match registered user, false otherwise
     */
    public boolean checkLoginStatus(String username, String password) {
        // Using decision structure with multiple conditions
        if (registeredUser == null) {
            return false;
        }
        
        // Using String methods equals() for comparison
        boolean usernameMatches = registeredUser.getUsername().equals(username);
        boolean passwordMatches = registeredUser.getPassword().equals(password);
        
        // Using logical AND operator
        return usernameMatches && passwordMatches;
    }
    
    /**
     * Method 6: String returnLoginStatus()
     * This method returns the necessary information for:
     * - A successful login
     * - A failed login
     * 
     * @param username The username to check
     * @param password The password to check
     * @return Login status message
     */
    public String returnLoginStatus(String username, String password) {
        // Using decision structure (if-else)
        if (checkLoginStatus(username, password)) {
            // Using string concatenation with variables
            loginStatusMessage = "Welcome " + registeredUser.getFirstName() + " " + 
                                registeredUser.getLastName() + "! It is great to see you again.";
            return loginStatusMessage;
        } else {
            loginStatusMessage = "Username or password incorrect, please try again.";
            return loginStatusMessage;
        }
    }
    
    // Getter method for registered user
    public User getRegisteredUser() {
        return registeredUser;
    }
}
