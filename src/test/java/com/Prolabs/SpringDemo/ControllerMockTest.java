package com.Prolabs.SpringDemo;

import com.Prolabs.SpringDemo.service.ApiService;
import com.Prolabs.SpringDemo.service.dto.Address;
import com.Prolabs.SpringDemo.service.dto.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ControllerMockTest {

	@MockBean
	private ApiService service;

	@Autowired
	private MockMvc mockMvc;


	@Test
	public void postTest() throws Exception {
		MockHttpServletRequestBuilder builder;
		MvcResult mvcResult;


		Employee employee = new Employee();
		employee.setEmployeeName("TEST");
		employee.setEmployeeID(123);
		Address address = new Address();
		address.setState("TEST");
		address.setCity("TEST");
		address.setPinCode("700009");
		List<Address> addressList = new ArrayList<>();
		addressList.add(address);
		employee.setEmployeeAddressList(addressList);

		ObjectMapper objectMapper = new ObjectMapper();
		String request = objectMapper.writeValueAsString(employee);


		given(service.addEmployee(Mockito.any(Employee.class))).willReturn(true);

		builder = post("/demo/employees")
				.contentType(MediaType.APPLICATION_JSON).content(request);

		mvcResult = mockMvc.perform(builder).andExpect(status().is2xxSuccessful()).andReturn();

		Assert.assertNotNull(mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void postGetState() throws Exception {
		MockHttpServletRequestBuilder builder;
		MvcResult mvcResult;


		Employee employee = new Employee();
		employee.setEmployeeName("TEST");
		employee.setEmployeeID(123);
		Address address = new Address();
		address.setState("TEST");
		address.setCity("TEST");
		address.setPinCode("700009");
		List<Address> addressList = new ArrayList<>();
		addressList.add(address);
		employee.setEmployeeAddressList(addressList);

		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(employee);

		given(service.getEmployeesByState(Mockito.anyString())).willReturn(employeeList);

		builder = get("/demo/employees")
				.queryParam("id","27");

		mvcResult = mockMvc.perform(builder).andExpect(status().is2xxSuccessful()).andReturn();

		Assert.assertNotNull(mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void postGetCity() throws Exception {
		MockHttpServletRequestBuilder builder;
		MvcResult mvcResult;


		Employee employee = new Employee();
		employee.setEmployeeName("TEST");
		employee.setEmployeeID(123);
		Address address = new Address();
		address.setState("TEST");
		address.setCity("TEST");
		address.setPinCode("700122");
		List<Address> addressList = new ArrayList<>();
		addressList.add(address);
		employee.setEmployeeAddressList(addressList);

		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(employee);

		given(service.getEmployeesByCity(Mockito.anyString())).willReturn(employeeList);

		builder = get("/demo/employees")
				.queryParam("id","27");

		mvcResult = mockMvc.perform(builder).andExpect(status().is2xxSuccessful()).andReturn();

		Assert.assertNotNull(mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void postGetPin() throws Exception {
		MockHttpServletRequestBuilder builder;
		MvcResult mvcResult;


		Employee employee = new Employee();
		employee.setEmployeeName("TEST");
		employee.setEmployeeID(456);
		Address address = new Address();
		address.setState("TEST");
		address.setCity("TEST");
		address.setPinCode("700122");
		List<Address> addressList = new ArrayList<>();
		addressList.add(address);
		employee.setEmployeeAddressList(addressList);

		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(employee);

		given(service.getEmployeesByPin(Mockito.anyString())).willReturn(employeeList);

		builder = get("/demo/employees")
				.queryParam("id","27");

		mvcResult = mockMvc.perform(builder).andExpect(status().is2xxSuccessful()).andReturn();

		Assert.assertNotNull(mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void postGetAll() throws Exception {
		MockHttpServletRequestBuilder builder;
		MvcResult mvcResult;


		Employee employee = new Employee();
		employee.setEmployeeName("TEST");
		employee.setEmployeeID(123);
		Address address = new Address();
		address.setState("TEST");
		address.setCity("TEST");
		address.setPinCode("700009");
		List<Address> addressList = new ArrayList<>();
		addressList.add(address);
		employee.setEmployeeAddressList(addressList);

		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(employee);

		given(service.getAllEmployees()).willReturn(employeeList);

		builder = get("/demo/employees");

		mvcResult = mockMvc.perform(builder).andExpect(status().is2xxSuccessful()).andReturn();

		Assert.assertNotNull(mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void deleteTest() throws Exception {
		MockHttpServletRequestBuilder builder;
		MvcResult mvcResult;

		doNothing().when(service).deleteEmployeeByID(any(Integer.class));

		builder = delete("/demo/employees/123");

		mvcResult = mockMvc.perform(builder).andExpect(status().is2xxSuccessful()).andReturn();

		Assert.assertNotNull(mvcResult.getResponse().getContentAsString());
	}

}


