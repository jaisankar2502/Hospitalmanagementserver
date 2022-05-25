package com.hospitalmanagement.Hospitalmanagement.form;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DepartmentForm {

    @Size(max=50)
    @NotBlank
    private String DepName;
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDepName() {
        return DepName;
    }

    public void setDepName(String depName) {
        DepName = depName;
    }
}
