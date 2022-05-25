package com.hospitalmanagement.Hospitalmanagement.view;

import com.hospitalmanagement.Hospitalmanagement.entity.Department;
import com.hospitalmanagement.Hospitalmanagement.json.Json;

import java.util.Date;

public class DepartmentView {

    private final int depId;

    private final String DepName;

    private final byte status;
    @Json.DateTimeFormat
    private final Date createDate;
    @Json.DateTimeFormat
    private final Date updateDate;

    public DepartmentView(Department department) {
        this.depId = department.getDepId();
        DepName = department.getDepName();
        this.status = department.getStatus();
        this.createDate = department.getCreateDate();
        this.updateDate = department.getUpdateDate();
    }



    public int getDepId() {
        return depId;
    }

    public String getDepName() {
        return DepName;
    }

    public byte getStatus() {
        return status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }
}
