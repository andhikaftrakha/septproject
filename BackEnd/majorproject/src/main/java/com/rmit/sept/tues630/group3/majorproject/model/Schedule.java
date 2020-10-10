package com.rmit.sept.tues630.group3.majorproject.model;

import java.util.Date;

public class Schedule {

    private String customer;

    private String time;

    private String username;

    private Date appointmentTime;
    private Account account = new Account();

    public Schedule(String customer, Date appointmentTime, String time, String username){
        this.customer = customer;
        this.time = time;
        this.appointmentTime = appointmentTime;
        this.username = username;
    }
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }




}
