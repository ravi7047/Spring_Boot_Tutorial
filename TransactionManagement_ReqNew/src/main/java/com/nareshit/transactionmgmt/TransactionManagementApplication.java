package com.nareshit.transactionmgmt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nareshit.transactionmgmt.model.Employee;
import com.nareshit.transactionmgmt.model.Insurance;
import com.nareshit.transactionmgmt.service.OrganizationService;

@SpringBootApplication
public class TransactionManagementApplication implements CommandLineRunner {

	@Autowired
	private OrganizationService orgService;

	public static void main(String[] args) {
		SpringApplication.run(TransactionManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {



		Employee emp = new Employee();
		emp.setEmpName("Prasad");

		Insurance employeeHealthInsurance = new Insurance();
		employeeHealthInsurance.setHealthInsuranceSchemeName("TopUp");
		employeeHealthInsurance.setCoverageAmount(1000000);

		orgService.onBoardEmployee(emp, employeeHealthInsurance);


	}

}
