package com.Prolabs.SpringDemo.entity;

import com.Prolabs.SpringDemo.service.dto.Employee;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class AddressEntity {

    @Id
    @Column(name = "addressid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    @Column(name = "city")
    private String city;

    @Column(name = "pin")
    private String pin;

    @Column(name = "state")
    private String state;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="employeeid")
    private EmployeeEntity employee;

    public AddressEntity(String city, String pin, String state, EmployeeEntity employee) {
        this.city = city;
        this.pin = pin;
        this.state = state;
        this.employee = employee;
    }

    public AddressEntity() {
    }


    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
}
