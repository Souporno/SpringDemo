package com.Prolabs.SpringDemo.service;

import com.Prolabs.SpringDemo.service.dto.Employee;

import java.util.List;

public interface ApiService {

    public List<Employee> getAllEmployees();
    public List<Employee> getEmployeesByCity(String value);
    public List<Employee> getEmployeesByPin(String value);
    public List<Employee> getEmployeesByState(String value);
    public List<Employee> getEmployeesById(Integer id);

    public void deleteEmployeeByID(Integer id);

    public Boolean addEmployee(Employee employee);
}
