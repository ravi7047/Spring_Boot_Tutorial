package com.nareshit.transactionmgmt.service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nareshit.transactionmgmt.model.Employee;
import com.nareshit.transactionmgmt.model.Insurance;

@Service
public class OrganizationService {

	@Autowired
	private EmployeeService empService;

	@Autowired
	private InsuranceService insService;


	@Transactional(propagation = Propagation.REQUIRED)
	public void onBoardEmployee(Employee epmpObj, Insurance insObj) {

		empService.saveEmployee(epmpObj);  //DML1

		if (insObj.getHealthInsuranceSchemeName().length() <= 4) {
			throw new RuntimeErrorException(null, "Error in Insurance");
		} else {
			insObj.setEmpId(epmpObj.getEmpId());

			insService.registerInsurance(insObj); //DML2
		}
	}

}
