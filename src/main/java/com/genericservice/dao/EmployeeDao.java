package com.genericservice.dao;

import java.io.Serializable;

import com.genericservice.entity.Employee;

public interface EmployeeDao extends GenericDao<Employee, Serializable> {

	public boolean removeEmployee(Integer id);

	public boolean isEmployeeRegistered(String userName);

	public Employee getEmployee(String username);

}
