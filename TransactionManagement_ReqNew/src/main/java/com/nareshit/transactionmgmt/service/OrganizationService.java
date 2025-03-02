package com.nareshit.transactionmgmt.service;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nareshit.transactionmgmt.model.Audit;
import com.nareshit.transactionmgmt.model.Employee;
import com.nareshit.transactionmgmt.model.Insurance;

@Service
public class OrganizationService {

	@Autowired
	private EmployeeService empService;

	@Autowired
	private InsuranceService insService;


	@Autowired
	private AuditService auditService;

	@Transactional(propagation = Propagation.REQUIRED)
	public void onBoardEmployee(Employee epmpObj, Insurance insObj) {

		Employee employee = empService.saveEmployee(epmpObj);  //T1

		if (employee.getEmpId() != null) {
			//T2
			auditService.updateAudit(new Audit("Employee creation is sucess for " + employee.getEmpName()));
			insObj.setEmpId(employee.getEmpId());

		} else {
			//T2
			auditService.updateAudit(new Audit("Employee creation is Failed for " + employee.getEmpName()));
		}




		if (insObj.getHealthInsuranceSchemeName().length() <= 4) {
			//T3
			auditService.updateAudit(new Audit("Insurance creation is Failed for  with insurance Name ....."
					+ insObj.getHealthInsuranceSchemeName() + ".....For the Employe ...." + employee.getEmpName()));
			throw new RuntimeErrorException(null, "Error in Insurance");
		}

		else {
			//T1

			insService.registerInsurance(insObj);
			//T3
			auditService.updateAudit(new Audit("Insurance creation is Sucess for " + employee.getEmpName()));
		}
	}

}
