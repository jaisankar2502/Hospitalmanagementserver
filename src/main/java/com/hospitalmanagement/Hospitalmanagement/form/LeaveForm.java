package com.hospitalmanagement.Hospitalmanagement.form;

import com.hospitalmanagement.Hospitalmanagement.json.Json;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class LeaveForm {
    @NotBlank
    private String leaveDate;
    @NotBlank
    private Integer leaveType;

    @NotBlank
    private String reason;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer depId;



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Integer getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(Integer leaveType) {
        this.leaveType = leaveType;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }
}
