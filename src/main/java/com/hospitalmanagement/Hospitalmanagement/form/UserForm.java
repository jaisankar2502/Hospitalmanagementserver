package com.hospitalmanagement.Hospitalmanagement.form;


import com.hospitalmanagement.Hospitalmanagement.json.Json;
import java.util.Date;
import javax.validation.constraints.*;


public class UserForm {
    @Size(max = 30)

    private String firstName;
    @Size(max = 30)

    private String lastName;
    @Size(max = 30)

    private String nickName;
    @Json.DateFormat
    private Date dob;
    @Size(max = 200)

    private String address;
    @Size(max = 50)

    private String city;
    @Size(max = 50)
    private String state;
    @Size(max = 50)

    private String country;
    @Size(max = 8)

    private String zipcode;

    private Integer type;

    private Integer department;
    @Size(max = 20)
    private String phone;

    private String email;


    private String password;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
