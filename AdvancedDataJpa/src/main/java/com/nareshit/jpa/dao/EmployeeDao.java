package com.nareshit.jpa.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.jpa.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer>{

	public List<Object[]> findMaxSalariesByDept(List<String> deptNames);
	//Admin,Sales,Marketing

}
