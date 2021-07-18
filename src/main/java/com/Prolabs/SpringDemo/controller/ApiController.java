package com.Prolabs.SpringDemo.controller;

import com.Prolabs.SpringDemo.service.ApiService;
import com.Prolabs.SpringDemo.service.dto.Employee;
import com.Prolabs.SpringDemo.service.dto.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController()
@RequestMapping(value = "/demo")
public class ApiController {

    @Autowired
    ApiService service;

    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam(required = false) String city, @RequestParam(required = false) String pin, @RequestParam(required = false) String state, @RequestParam(required = false) Integer id)
    {
        List<Employee> employeeList;
        if (Objects.nonNull(id))
        {
            employeeList=service.getEmployeesById(id);
        }
        else if (Objects.nonNull(state) && !state.isEmpty())
        {
            employeeList= service.getEmployeesByState(state);
        }
        else if (Objects.nonNull(city) && !city.isEmpty())
        {
            employeeList=service.getEmployeesByCity(city);
        }
        else if (Objects.nonNull(pin) && !pin.isEmpty())
        {
            employeeList=service.getEmployeesByPin(pin);
        }
        else
        {
            employeeList =service.getAllEmployees();
        }

        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }


    @PostMapping(value = "/employees")
    public ResponseEntity<ResponseMessage> addEmployees(@RequestBody Employee employee)
    {
        String message = (service.addEmployee(employee))?"Added":"Failed";
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage(message);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @PutMapping(value = "/employees/{employeeId}")
    public ResponseEntity<Void> updateEmployees(@PathVariable Integer employeeId)
    {
        //Dummy
        Employee employee = new Employee();
        employee.setEmployeeID(employeeId);
        employee.setEmployeeName("SOU");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "/employees/{employeeId}")
    public ResponseEntity<Void> deleteEmployees(@PathVariable Integer employeeId)
    {
        //Dummy
        service.deleteEmployeeByID(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
