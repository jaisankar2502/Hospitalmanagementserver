package com.hospitalmanagement.Hospitalmanagement.entity;

import com.hospitalmanagement.Hospitalmanagement.form.DepartmentForm;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Department {
    public static  enum  Status{
        INACTIVE((byte)0),
        ACTIVE((byte)1);
        public final byte value;
        private Status(byte value){this.value=value;}
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer DepId;

    private String DepName;
    private Integer type;

    private  byte status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;


    public Department(Integer DepId){
        this.DepId=DepId;
    }

    public Department(DepartmentForm form){
        this.DepName=form.getDepName();
        this.type=form.getType();
        Date dt = new Date();
        this.createDate = dt;
        this.updateDate = dt;
        this.status=Status.ACTIVE.value;

    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDepId() {
        return DepId;
    }

    public void setDepId(Integer depId) {
        DepId = depId;
    }

    public String getDepName() {
        return DepName;
    }

    public void setDepName(String depName) {
        DepName = depName;
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
    public Department(){

    }
}
