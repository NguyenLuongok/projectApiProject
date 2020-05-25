package com.poly.api.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user_table")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;


    @OneToOne
    @JoinColumn(name = "facilityId")
    private Facility facility;

    public User() {
    }

    public User(String username, String email, String password, String address, String phoneNumber,Facility facility) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.facility = facility;
    }
    public User(int userId,String username, String email, String password, String address, String phoneNumber,Facility facility) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.facility = facility;
    }
}
