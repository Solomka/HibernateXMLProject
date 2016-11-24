package com.howtodoinjava.service;

import java.util.List;
import java.util.UUID;

import com.howtodoinjava.entity.EmployeeEntity;

public interface EmployeeManager {
	public void addEmployee(EmployeeEntity employee);

	public List<EmployeeEntity> getAllEmployees();

	public void deleteEmployee(UUID employeeId);
}
