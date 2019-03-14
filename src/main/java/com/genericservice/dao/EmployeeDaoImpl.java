package com.genericservice.dao;

import java.io.Serializable;

import org.hibernate.Query;

import com.genericservice.entity.Employee;

public class EmployeeDaoImpl extends GenericDaoImpl<Employee, Serializable> implements EmployeeDao {

	@Override
	public boolean removeEmployee(Integer id) {
		Query employeeTaskQuery = currentSession().createQuery("from Employee u where :id");
		employeeTaskQuery.setParameter("id", id);
		return employeeTaskQuery.executeUpdate() > 0;
	}

	@Override
	public boolean isEmployeeRegistered(String userName) {

		Query employeeTaskQuery = currentSession().createQuery("select 'A' from Employee u where username=:username");
		employeeTaskQuery.setParameter("username", userName);
		return employeeTaskQuery.list().size() > 0;
	}

	@Override
	public Employee getEmployee(String username) {
		Query query = currentSession().createQuery("from Employee " + "where username=:username");
		query.setParameter("username", username);
		return (Employee) query.uniqueResult();

	}

}
