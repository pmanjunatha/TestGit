package com.jwt.dao;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


import com.jwt.dao.EmployeeDAOImpl;
import com.jwt.model.Employee;


public class EmployeeDAOImplTest {

	
	@Autowired
	EmployeeDAOImpl employeeDAOImpl;
	
	@Autowired
	Employee employee;
	
	@Test
    public void findById(){
        Assert.assertNotNull(employeeDAOImpl.getEmployee(1));
        Assert.assertNull(employeeDAOImpl.getEmployee(7));
    }
	
	@Test
    public void saveEmployee(){
		employeeDAOImpl.addEmployee(getSampleEmployee());
        Assert.assertEquals(employeeDAOImpl.getAllEmployees().size(), 5);
    }
	
	 @Test
	public void deleteEmployeeBySsn(){
		 employeeDAOImpl.deleteEmployee(5);
	        Assert.assertEquals(employeeDAOImpl.getAllEmployees().size(), 4);
	}
	 
	 @Test
	 public void findAllEmployees(){
	        Assert.assertEquals(employeeDAOImpl.getAllEmployees().size(), 4);
	 }
	
	public Employee getSampleEmployee() {
		
		employee = new Employee();
		employee.setName("abc");
		employee.setAddress("xyz");
		employee.setEmail("abc@gmail.com");
		employee.setTelephone("12345");
		return employee;
	}

}
