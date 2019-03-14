package com.genericservice.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.genericservice.dao.EmployeeDao;
import com.genericservice.dao.GenericDao;
import com.genericservice.entity.Employee;

@Service
public class EmployeeServiceImpl extends GenericServiceImpl<Employee, Serializable> implements EmployeeService {

	private EmployeeDao employeeDao;

	public EmployeeServiceImpl() {
	}

	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDaoImpl") GenericDao<Employee, Serializable> genericDao) {
		super(genericDao);
		this.employeeDao = (EmployeeDao) genericDao;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean removeEmployee(Integer id) {
		return employeeDao.removeEmployee(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public boolean isEmployeeRegistered(String userName) {
		return employeeDao.isEmployeeRegistered(userName);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public Employee getEmployee(String userName) {
		return employeeDao.getEmployee(userName);
	}
}
