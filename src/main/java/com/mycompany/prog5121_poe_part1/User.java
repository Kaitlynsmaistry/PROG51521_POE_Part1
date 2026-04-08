/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prog5121_poe_part1;

/**
 *
 * @author lab_services_student
 */
public class User {
  // Variables and variable scope - instance variables
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;
    
    // Constructor - Class constructor
    public User(String username, String password, String cellPhoneNumber, 
                String firstName, String lastName) {
        // Using 'this' keyword to distinguish between instance variables and parameters
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    // Getter methods - Accessor methods
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    // Setter methods - Mutator methods
    public void setUsername(String username) {
        this.username = username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
