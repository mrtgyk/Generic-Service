package com.genericservice.service;

import java.io.Serializable;

import com.genericservice.entity.Employee;

public interface EmployeeService extends GenericService<Employee, Serializable> {

	public boolean removeEmployee(Integer id);

	public boolean isEmployeeRegistered(String userName);

	public Employee getEmployee(String userName);
}
