package com.nareshit.transactionmgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nareshit.transactionmgmt.dao.EmployeeDao;
import com.nareshit.transactionmgmt.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao empDao;

	public Employee saveEmployee(Employee empObj) {
		return empDao.save(empObj);
	}

}
