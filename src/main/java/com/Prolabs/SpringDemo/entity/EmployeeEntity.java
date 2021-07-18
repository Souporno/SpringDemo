package com.Prolabs.SpringDemo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @Column(name = "employeeid")
    private Integer employeeId;

    @Column(name = "employeename")
    private String employeeName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "employee")
    private List<AddressEntity> employeeAddress;

    public EmployeeEntity(Integer employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public EmployeeEntity() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<AddressEntity> getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(List<AddressEntity> employeeAddress) {
        this.employeeAddress = employeeAddress;
    }
}
