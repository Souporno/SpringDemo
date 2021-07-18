package com.Prolabs.SpringDemo.service.dto;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private Integer employeeID;
    private String employeeName;
    private List<Address> employeeAddressList = new ArrayList<>();

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<Address> getEmployeeAddressList() {
        return employeeAddressList;
    }

    public void setEmployeeAddressList(List<Address> employeeAddressList) {
        this.employeeAddressList = employeeAddressList;
    }
}
