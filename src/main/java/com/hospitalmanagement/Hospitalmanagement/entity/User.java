package com.hospitalmanagement.Hospitalmanagement.entity;

import com.hospitalmanagement.Hospitalmanagement.form.UserForm;

import javax.persistence.*;

import java.util.Date;

@Entity
public class User {
    public  static enum Status{
        INACTIVE((byte)0),
        ACTIVE((byte) 1);
        public  final byte value;
        private Status(byte value){this.value=value;}
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UserId;

    private String firstName;

    private String lastName;

    private String nickName;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private String address;

    private String city;

    private String state;

    private String country;

    private String zipCode;

    private Integer type;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Department dep_id;
    private String phone;

    private String email;

    private String password;

    private byte status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;


    public User(Integer userId){
        this.UserId=userId;
    }
    public User(UserForm form){
        this.firstName=form.getFirstName();
        this.lastName= form.getLastName();
        this.nickName= form.getNickName();
        this.dob= form.getDob();
        this.address= form.getAddress();;
        this.city= form.getCity();
        this.state= form.getState();
        this.country= form.getCountry();
        this.zipCode= form.getZipcode();
        this.type=form.getType();
        this.dep_id= new Department(form.getDepartment());
        this.phone=form.getPhone();
        this.email= form.getEmail();;
        this.password=form.getPassword();
        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
        this.status=Status.ACTIVE.value;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Department getDep_id() {
        return dep_id;
    }

    public void setDep_id(Department dep_id) {
        this.dep_id = dep_id;
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

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public User(){

    }

}
