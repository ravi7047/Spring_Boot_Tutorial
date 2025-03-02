package com.nareshit.transactionmgmt.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.transactionmgmt.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer>{

}
