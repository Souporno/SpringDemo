package com.Prolabs.SpringDemo.service;

import com.Prolabs.SpringDemo.entity.AddressEntity;
import com.Prolabs.SpringDemo.entity.EmployeeEntity;
import com.Prolabs.SpringDemo.exceptions.NothingFoundException;
import com.Prolabs.SpringDemo.exceptions.RequestException;
import com.Prolabs.SpringDemo.repository.AddressRepository;
import com.Prolabs.SpringDemo.repository.EmployeeRepository;
import com.Prolabs.SpringDemo.service.dto.Address;
import com.Prolabs.SpringDemo.service.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ApiServiceImpl implements ApiService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AddressRepository addressRepository;

    private static int getSize(Iterable data) {

        if (data instanceof Collection) {
            return ((Collection<?>) data).size();
        }
        int counter = 0;
        for (Object i : data) {
            counter++;
        }
        return counter;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();

        Iterable<EmployeeEntity> employeeEntityList = employeeRepository.findAll();

        if(getSize(employeeEntityList)==0)
        {
            throw new NothingFoundException("No Data Found");
        }

        employeeEntityList.forEach(employeeEntity -> {
            Employee employee = new Employee();
            employee.setEmployeeID(employeeEntity.getEmployeeId());
            employee.setEmployeeName(employeeEntity.getEmployeeName());
            List<Address> addressList = new ArrayList<>();
            employeeEntity.getEmployeeAddress().stream().forEach(addressEntity -> {
                Address address = new Address();
                address.setCity(addressEntity.getCity());
                address.setPinCode(addressEntity.getPin());
                address.setState(addressEntity.getState());
                addressList.add(address);
            });
            employee.setEmployeeAddressList(addressList);
            employeeList.add(employee);
        });

        return employeeList;
    }

    @Override
    public List<Employee> getEmployeesByCity(String value) {
        List<Employee> employeeList = new ArrayList<>();

        Iterable<AddressEntity> addressEntityIterable = addressRepository.findByCity(value.toLowerCase());

        if(getSize(addressEntityIterable)==0)
        {
            throw new NothingFoundException("No Data Found");
        }
        Set<Integer> uniqueEmployeeId = new HashSet<>();
        addressEntityIterable.forEach(addressEntity -> {
            uniqueEmployeeId.add(addressEntity.getEmployee().getEmployeeId());
        });

        uniqueEmployeeId.forEach(id->{
            Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
            if (employeeEntity.isPresent())
            {
                Employee employee = new Employee();
                employee.setEmployeeID(employeeEntity.get().getEmployeeId());
                employee.setEmployeeName(employeeEntity.get().getEmployeeName());
                List<Address> addressList = new ArrayList<>();
                employeeEntity.get().getEmployeeAddress().stream().forEach(addressEntity -> {
                    Address address = new Address();
                    address.setCity(addressEntity.getCity());
                    address.setPinCode(addressEntity.getPin());
                    address.setState(addressEntity.getState());
                    addressList.add(address);
                });
                employee.setEmployeeAddressList(addressList);
                employeeList.add(employee);
            }
        });

        return employeeList;
    }

    @Override
    public List<Employee> getEmployeesByPin(String value) {
        List<Employee> employeeList = new ArrayList<>();

        Iterable<AddressEntity> addressEntityIterable = addressRepository.findByPin(value.toLowerCase());
        if(getSize(addressEntityIterable)==0)
        {
            throw new NothingFoundException("No Data Found");
        }
        Set<Integer> uniqueEmployeeId = new HashSet<>();
        addressEntityIterable.forEach(addressEntity -> {
            uniqueEmployeeId.add(addressEntity.getEmployee().getEmployeeId());
        });

        uniqueEmployeeId.forEach(id->{
            Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
            if (employeeEntity.isPresent())
            {
                Employee employee = new Employee();
                employee.setEmployeeID(employeeEntity.get().getEmployeeId());
                employee.setEmployeeName(employeeEntity.get().getEmployeeName());
                List<Address> addressList = new ArrayList<>();
                employeeEntity.get().getEmployeeAddress().stream().forEach(addressEntity -> {
                    Address address = new Address();
                    address.setCity(addressEntity.getCity());
                    address.setPinCode(addressEntity.getPin());
                    address.setState(addressEntity.getState());
                    addressList.add(address);
                });
                employee.setEmployeeAddressList(addressList);
                employeeList.add(employee);
            }
        });

        return employeeList;
    }

    @Override
    public List<Employee> getEmployeesByState(String value) {
        List<Employee> employeeList = new ArrayList<>();

        Iterable<AddressEntity> addressEntityIterable = addressRepository.findByState(value.toLowerCase());
        if(getSize(addressEntityIterable)==0)
        {
            throw new NothingFoundException("No Data Found");
        }
        Set<Integer> uniqueEmployeeId = new HashSet<>();
        addressEntityIterable.forEach(addressEntity -> {
            uniqueEmployeeId.add(addressEntity.getEmployee().getEmployeeId());
        });

        uniqueEmployeeId.forEach(id->{
            Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
            if (employeeEntity.isPresent())
            {
                Employee employee = new Employee();
                employee.setEmployeeID(employeeEntity.get().getEmployeeId());
                employee.setEmployeeName(employeeEntity.get().getEmployeeName());
                List<Address> addressList = new ArrayList<>();
                employeeEntity.get().getEmployeeAddress().stream().forEach(addressEntity -> {
                    Address address = new Address();
                    address.setCity(addressEntity.getCity());
                    address.setPinCode(addressEntity.getPin());
                    address.setState(addressEntity.getState());
                    addressList.add(address);
                });
                employee.setEmployeeAddressList(addressList);
                employeeList.add(employee);
            }
        });

        return employeeList;
    }

    @Override
    public List<Employee> getEmployeesById(Integer id) {
        List<Employee>employeeList = new ArrayList<>();

        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        if (employeeEntity.isPresent())
        {
            Employee employee = new Employee();
            employee.setEmployeeID(employeeEntity.get().getEmployeeId());
            employee.setEmployeeName(employeeEntity.get().getEmployeeName());
            List<Address> addressList = new ArrayList<>();
            employeeEntity.get().getEmployeeAddress().stream().forEach(addressEntity -> {
                Address address = new Address();
                address.setCity(addressEntity.getCity());
                address.setPinCode(addressEntity.getPin());
                address.setState(addressEntity.getState());
                addressList.add(address);
            });
            employee.setEmployeeAddressList(addressList);
            employeeList.add(employee);
        }
        else {
            throw new NothingFoundException("No Data Found");
        }

        return employeeList;
    }

    @Override
    public void deleteEmployeeByID(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Boolean addEmployee(Employee employee) {
        //JSON
        /*
        {
	"employeeID" : 26,
	"employeeName" : "Abdedeededec",
	"employeeAddressList" : [
		{
			"city": "SOMETffefHING",
			"pinCode": "1234567",
			"state": "BLefefeA"
		}
	]

}
         */
        //Check if employee name and id is present
        if(employee.getEmployeeName().isEmpty() || Objects.isNull(employee.getEmployeeName()))
        {
            throw new RequestException("Name is needed");
        }
        if(Objects.isNull(employee.getEmployeeID()))
        {
            throw new RequestException("Id is needed");
        }

        if (employee.getEmployeeName().length()>250)
        {
            throw new RequestException("Name length should be less than 250");
        }

        List<AddressEntity> addressEntityList = new ArrayList<>();
        EmployeeEntity employeeEntity = new EmployeeEntity(employee.getEmployeeID(),employee.getEmployeeName().toLowerCase());
        employee.getEmployeeAddressList().stream().forEach(address -> {
            //state, pin and city length adherence
            if(address.getState().length()>250 && Objects.nonNull(address.getState()))
            {
                throw new RequestException("Address --> state length should be less or equals than 250");
            }
            if(address.getCity().length()>250 && Objects.nonNull(address.getCity()))
            {
                throw new RequestException("Address --> city length should be less or equals than 250");
            }
            if(address.getPinCode().length()!=6 && Objects.nonNull(address.getPinCode()))
            {
                throw new RequestException("Address --> pin code length should be equals to 7");
            }
            AddressEntity addressEntity = new AddressEntity(address.getCity().toLowerCase(), address.getPinCode().toLowerCase(), address.getState().toLowerCase(),employeeEntity);
            addressEntityList.add(addressEntity);
        });
        employeeEntity.setEmployeeAddress(addressEntityList);

        employeeRepository.save(employeeEntity);
        return true;
    }
}








//Check for the service by using dummy
//
//
//@Component
//public class ApiServiceImpl implements ApiService{
//    @Override
//    public List<Employee> getAllEmployees() {
//        List<Employee> employeeList = new ArrayList<>();
//        Employee souporno = new Employee();
//        souporno.setEmployeeName("Soup");
//        souporno.setEmployeeID(1);
//
//        Employee projit = new Employee();
//        projit.setEmployeeName("Projit");
//        projit.setEmployeeID(5);
//
//        employeeList.add(souporno);
//        employeeList.add(projit);
//
//        return employeeList;
//    }
//
//    @Override
//    public List<Employee> getEmployeesByCity(String value) {
//        List<Employee> employeeList = new ArrayList<>();
//
//
//        Employee projit = new Employee();
//        projit.setEmployeeName("Projit");
//        projit.setEmployeeID(5);
//
//        employeeList.add(projit);
//
//        return employeeList;
//    }
//
//    @Override
//    public List<Employee> getEmployeesByPin(String value) {
//        List<Employee> employeeList = new ArrayList<>();
//        Employee souporno = new Employee();
//        souporno.setEmployeeName("Soup");
//        souporno.setEmployeeID(1);
//
//        Employee souptik = new Employee();
//        souptik.setEmployeeName("Souptik");
//        souptik.setEmployeeID(5);
//
//        employeeList.add(souporno);
//        employeeList.add(souptik);
//
//        return employeeList;
//    }
//
//    @Override
//    public List<Employee> getEmployeesByState(String value) {
//        List<Employee> employeeList = new ArrayList<>();
//        Employee souporno = new Employee();
//        souporno.setEmployeeName("Soup");
//        souporno.setEmployeeID(1);
//
//        Employee projit = new Employee();
//        projit.setEmployeeName("Projit");
//        projit.setEmployeeID(5);
//
//        Employee souptik = new Employee();
//        souptik.setEmployeeName("Souptik");
//        souptik.setEmployeeID(5);
//
//        employeeList.add(souporno);
//        employeeList.add(projit);
//        employeeList.add(souptik);
//
//        return employeeList;
//    }
//
//    @Override
//    public List<Employee> getEmployeesById(Integer id) {
//        List<Employee> employeeList = new ArrayList<>();
//        Employee souporno = new Employee();
//        souporno.setEmployeeName("Soup");
//        souporno.setEmployeeID(1);
//
//        employeeList.add(souporno);
//
//        return employeeList;
//    }
//
//    @Override
//    public void deleteEmployeeByID(Integer id) {
//
//    }
//
//    @Override
//    public Boolean addEmployee(Employee employee) {
//        return true;
//    }
//}
