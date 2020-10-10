package com.rmit.sept.tues630.group3.majorproject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String cNumber;
    private String email;

    private Date created_Ap;
    private Date updated_Ap;

    public Appointments() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getcNumber() {
        return cNumber;
    }

    public void setcNumber(String cNumber) {
        this.cNumber = cNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @PrePersist
    protected void onCreate(){
        this.created_Ap = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updated_Ap = new Date();
    }
}
