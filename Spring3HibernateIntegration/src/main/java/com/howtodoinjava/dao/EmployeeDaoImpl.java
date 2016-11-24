package com.howtodoinjava.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.howtodoinjava.entity.EmployeeEntity;

@Repository("employeeDAO")
@Transactional
public class EmployeeDaoImpl  extends AHibernateRepository<EmployeeEntity, UUID> implements EmployeeDAO  {

	/*
	@Autowired
	private SessionFactory sessionFactory;
	*/

	public void addEmployee(EmployeeEntity employee) {
		savePO(employee);
	}

	@SuppressWarnings("unchecked")
	public List<EmployeeEntity> getAllEmployees() {
		return findAll();
	}

	public void deleteEmployee(UUID employeeId) {
		deletePOById(employeeId);
	}

}
