package com.poly.api.dto;

import lombok.Data;

@Data
public class UserDto {

    private int userId;
    private String username;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private int facilityId;
    private String facilityName;

    public UserDto() {
    }

    public UserDto(int userId, String username, String email, String password, String address, String phoneNumber, int facilityId, String facilityName) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.facilityId = facilityId;
        this.facilityName = facilityName;
    }
}
