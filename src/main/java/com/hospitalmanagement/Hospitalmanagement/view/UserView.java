package com.hospitalmanagement.Hospitalmanagement.view;

import com.hospitalmanagement.Hospitalmanagement.entity.User;
import com.hospitalmanagement.Hospitalmanagement.json.Json;

import java.util.Collection;
import java.util.Date;

public class UserView {
    private final int userId;
    private final String firstName;
    private final String lastName;
    private final String nickName;
    @Json.DateFormat
    private final Date dob;
    private final String address;
    private final String city;
    private final String state;
    private final String country;
    private final String zipCode;
    private final String email;
    private final String phone;

    private final Integer dep_id;
    private final String depName;
    private final Integer type;
    private final byte status;
    @Json.DateTimeFormat
    private final Date createDate;
    @Json.DateTimeFormat
    private final Date updateDate;

    public Integer getType() {
        return type;
    }

    public UserView(User user) {
        this.userId = user.getUserId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.nickName = user.getNickName();
        this.dob = user.getDob();
        this.address = user.getAddress();
        this.city = user.getCity();
        this.state = user.getState();
        this.country = user.getCountry();
        this.zipCode = user.getZipCode();
        this.dep_id = user.getDep_id().getDepId();
        this.depName = user.getDep_id().getDepName();
        this.status = user.getStatus();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.type = user.getType();
        this.createDate = user.getCreateDate();
        this.updateDate = user.getUpdateDate();
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public Date getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public byte getStatus() {
        return status;
    }

    public Integer getDep_id() {
        return dep_id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getEmail() {

        return email;
    }

    public Date getUpdateDate() {

        return updateDate;
    }

    public String getPhone() {

        return phone;
    }

    public String getDepName() {
        return depName;
    }
}
