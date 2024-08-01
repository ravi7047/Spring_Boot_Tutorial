package com.nareshit.jpa.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nareshit.jpa.model.CustomType;
import com.nareshit.jpa.model.Person;

@Repository
public interface PersonDao extends CrudRepository<Person, Integer> {

	/*
	 * SaveAll and FindAllById
	 * saveAll(List<Person) ==> Returns List<Person>
	 * findAllById(List<PK>)==> Returns List<Person>
	 */

	/*
	 *
	 * Derived Method ==> Abstract Method will be written by Developer with some Rules
	 *                ===> Based on Abstract method framework will implement
	 *
	 * Rules for Writing Abstract Method
	 *
	 * 1) Input and Output is of Developers Choice
	 * 2) Only Method Name should start with "findBy" keyword .
	 * 3) Follwed by findBy ==> We need to append the property which we need to search
	 * 4) Both findBy and Propertyname all should be Camel Case
	 *
	 *
	 */



	public List<Person> findByFirstName(String firstName);
	//select * from tbl_person where first_name=firstName;


	public Person findByLastNameAndFirstName(String lastName,String firstName);
	//select * from tbl_person where last_name=lastName and first_name=firstName;



	public List<Person> findByLastNameOrFirstName(String lastName,String firstName);
	//select * from tbl_person where last_name=lastName or first_name=firstName;


	public List<Person> findByLastNameOrderByCreatedDateDesc(String lastName);
	//select * from tbl_person where last_name=lastName order by created_date desc;


	public List<Person> findByAgeLessThanEqual(Integer age);
	//select * from tbl_person where age<=age;


	//Like ==> Partial Search ==> % to be added by devloper if we want wildcard search
	//%firstName or firstName% or %firstName%
	public List<Person> findByFirstNameLike(String firstName);
	//select * from tbl_person where first_name like '%firstName%'


	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName,int age);
	//select * from tbl_person where last_name=lastName and age<=age


	//select * from tbl_person where created_date>=startdate and created_date<=endDate
	public List<Person> findByCreatedDateBetween(Date startdate,Date endDate);


	//Named Query
	//Both Implementation and Abstracct Method to be written by developer only
	public List<Person> giveDataByName(String firstName);

	public List<CustomType> giveFewColumns(String firstName);


	//Query -> We are going to write JPQL -> Writing Java Classes and Java proprties
	@Query(value="SELECT p FROM Person p where p.firstName=?1 OR p.email=?2") //Implementation
	List<Person> findPersonInfobyFirstNameorEmail(String firstName,String email); //Abtract Method

	//NativeQuery -> We are going to write SQL -> Writing database tables and database columns
	@Query(value="SELECT * FROM tbl_person p where p.first_name=?1",nativeQuery = true)
	List<Person> findPersonINfobyFirstname(String firstName);



	public List<Person> findByLastName(String lastName,Pageable pageable);
	//PageAble ===> service.findByLastName("vijay",0,10,"ASC","firstName");

}

