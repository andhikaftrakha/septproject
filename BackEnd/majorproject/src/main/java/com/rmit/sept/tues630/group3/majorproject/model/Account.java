package com.rmit.sept.tues630.group3.majorproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;



@Entity
public class Account {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Your firstName is required")
    private String firstName;
    @NotBlank(message = "Your lastName is required")
    private String lastName;
    @NotBlank(message = "Your address is required")
    private String address;

    @Id
    private String username; //Primary key for this Entity
    private String password;
    private String email;

    private String ac_type;

    @NotBlank(message = "Your phone number is required")
    private String phoneNumber;

    private String services;
    private double workingHours;
    private int workingDays;



    //Constructor for Worker account
    public Account(String fn, String ln, String un, String p, String ph, String services, double workingHours, int workingDays) {
        this.firstName = fn;
        this.lastName = ln;
        this.username = un;
        this.password = p;
        this.services = services;
        this.workingHours = workingHours;
        this.workingDays = workingDays;
        this.phoneNumber = ph;
        String ac_type = "Worker";
        this.ac_type = ac_type;


    }
    //Constructor for Customer account
    public Account(String fn, String ln, String un, String p, String ph, String services) {
        this.firstName = fn;
        this.lastName = ln;
        this.username = un;
        this.password = p;
        this.services = services;
        this.phoneNumber = ph;

        String ac_type = "Customer";
        this.ac_type = ac_type;
    }
    public Account(){

    }
    //Constructor for Admin account
    public Account(String un, String p) {
        this.username = un;
        this.password = p;
        String ac_type = "Admin";
        this.ac_type = ac_type;
    }
    //For Worker to update details as their details may change after a period of time
    public void updateWorkerDetails(String fn, String ln, String a, String c, String g, String ph , String email, String services, double workingHours, int workingDays) {
        this.firstName = fn;
        this.lastName = ln;
        this.address = a;
        this.email = email;
        this.phoneNumber = ph;
        this.services = services;
        this.workingHours = workingHours;
        this.workingDays = workingDays;
    }


    public String getUsername() {
        return this.username;
    }


    public String getPassword() {
        return this.password;
    }


    public String setPassword(String password) { return this.password = password; }

    public String getFirstName() {
        return this.firstName;
    }


    public String getLastName() {
        return this.lastName;
    }


    public String getAddress() {
        return this.address;
    }

    public String getAc_type() { return this.ac_type; }

    public void setAc_type(String ac_type) {
        this.ac_type = ac_type;
    }

    public String getEmail() { return this.email; }


    public String getPhoneNumber() { return this.phoneNumber; }

    public String getServices() { return this.services; }

    public double getWorkingHours() { return this.workingHours; }

    public int getWorkingDays() { return this.workingDays; }
}
