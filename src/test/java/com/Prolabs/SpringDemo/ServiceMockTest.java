package com.Prolabs.SpringDemo;

import com.Prolabs.SpringDemo.entity.AddressEntity;
import com.Prolabs.SpringDemo.entity.EmployeeEntity;
import com.Prolabs.SpringDemo.repository.AddressRepository;
import com.Prolabs.SpringDemo.repository.EmployeeRepository;
import com.Prolabs.SpringDemo.service.ApiService;
import com.Prolabs.SpringDemo.service.ApiServiceImpl;
import com.Prolabs.SpringDemo.service.dto.Address;
import com.Prolabs.SpringDemo.service.dto.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceMockTest {

    @Mock
    AddressRepository addressRepository;

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    ApiService apiService = new ApiServiceImpl();

    private ArrayList<EmployeeEntity> employeeEntityArrayList = new ArrayList<>();
    private ArrayList<AddressEntity> addressEntityArrayList = new ArrayList<>();
    private EmployeeEntity employeeEntity;
    private AddressEntity addressEntity;
    private Employee employee;

    @Before
    public void setup()
    {

        employeeEntity= new EmployeeEntity(123, "TEST");
        addressEntity= new AddressEntity("TEST","TEST","TEST",employeeEntity);

        addressEntityArrayList.add(addressEntity);
        employeeEntity.setEmployeeAddress(addressEntityArrayList);

        employee = new Employee();
        employee.setEmployeeName("TEST");
        employee.setEmployeeID(123);
        Address address = new Address();
        address.setState("TEST");
        address.setCity("TEST");
        address.setPinCode("700009");
        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        employee.setEmployeeAddressList(addressList);

        employeeEntityArrayList.add(employeeEntity);

    }

    @Test
    public void testAddSuccess()
    {
        when(employeeRepository.save(any())).thenReturn(null);
        boolean res=apiService.addEmployee(employee);

        Assert.assertTrue(res);
    }

    @Test
    public void testDeleteSuccess()
    {
        doNothing().when(employeeRepository).deleteById(any(Integer.class));
        apiService.deleteEmployeeByID(123);

    }

    @Test
    public void testGetAll()
    {
        when(employeeRepository.findAll()).thenReturn(employeeEntityArrayList);
        List<Employee> employeeList=apiService.getAllEmployees();

        Assert.assertFalse(employeeList.isEmpty());
    }

    @Test
    public void testGetByState()
    {
        when(addressRepository.findByState(anyString())).thenReturn(addressEntityArrayList);
        when(employeeRepository.findById(any(Integer.class))).thenReturn(java.util.Optional.ofNullable(employeeEntity));
        List<Employee> employeeList=apiService.getEmployeesByState("TEST");

        Assert.assertFalse(employeeList.isEmpty());
    }
    @Test
    public void testGetByCity()
    {
        when(addressRepository.findByCity(anyString())).thenReturn(addressEntityArrayList);
        when(employeeRepository.findById(any(Integer.class))).thenReturn(java.util.Optional.ofNullable(employeeEntity));
        List<Employee> employeeList=apiService.getEmployeesByCity("TEST");

        Assert.assertFalse(employeeList.isEmpty());
    }
    @Test
    public void testGetByPin()
    {
        when(addressRepository.findByPin(anyString())).thenReturn(addressEntityArrayList);
        when(employeeRepository.findById(any(Integer.class))).thenReturn(java.util.Optional.ofNullable(employeeEntity));
        List<Employee> employeeList=apiService.getEmployeesByPin("TEST");

        Assert.assertFalse(employeeList.isEmpty());
    }

}
