package com.hospitalmanagement.Hospitalmanagement.view;

import com.hospitalmanagement.Hospitalmanagement.entity.LeaveDetails;
import com.hospitalmanagement.Hospitalmanagement.json.Json;

import java.util.Date;

public class LeaveView {


    private  Integer leaveId;
    private  String leaveDate;
    private  Integer leaveType;
    private  String reason;
    private  Integer User;

    private  String Firstname;
    private  String Lastname;
    private  Integer departmentName;
    private byte status;

    private  byte approval;
    @Json.DateTimeFormat
    private  Date createDate;
    @Json.DateTimeFormat
    private  Date updateDate;

    public LeaveView(LeaveDetails leave) {

        leaveId = leave.getLeaveId() ;
        leaveDate = leave.getLeaveDate();
        leaveType = leave.getLeaveType();
        reason = leave.getReason();
        User = leave.getUser().getUserId();

        Firstname = leave.getUser().getFirstName();
        Lastname = leave.getUser().getLastName();
        this.status = leave.getStatus();
        this.createDate = leave.getCreateDate();
        this.updateDate = leave.getUpdateDate();
        this.approval = leave.getApproval();
        departmentName = leave.getDepartment().getDepId();
    }
      public LeaveView(){}
    public Integer getLeaveId() {
        return leaveId;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public Integer getLeaveType() {
        return leaveType;
    }

    public String getReason() {
        return reason;
    }

    public Integer getUser() {
        return User;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public Integer getDepartmentName() {
        return departmentName;
    }

    public byte getStatus() {
        return status;
    }

    public byte getApproval() {
        return approval;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }
}