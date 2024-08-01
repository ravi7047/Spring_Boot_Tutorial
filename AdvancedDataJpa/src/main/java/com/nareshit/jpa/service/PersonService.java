package com.nareshit.jpa.service;

import com.nareshit.jpa.dao.BookDao;
import com.nareshit.jpa.dao.EmployeeDao;
import com.nareshit.jpa.dao.PersonDao;
import com.nareshit.jpa.model.Book;
import com.nareshit.jpa.model.CustomType;
import com.nareshit.jpa.model.Employee;
import com.nareshit.jpa.model.Person;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

	// Take the reference of PersonDao

	@Autowired
	private PersonDao personDao;

	@Autowired
	private BookDao bookDao;

	@Autowired
	private EmployeeDao empDao;

	public Iterable<Person> saveAllPersons(Iterable<Person> personsList) {
		return personDao.saveAll(personsList);
	}

	public Iterable<Person> findAllById(Iterable<Integer> personIds) {
		return personDao.findAllById(personIds);
	}

	public List<Person> findByFirstName(String firstName) {
		return personDao.findByFirstName(firstName);
	}

	public Person findByLastNameAndFirstName(String lastName, String firstName) {
		return personDao.findByLastNameAndFirstName(lastName, firstName);
	}

	public List<Person> findByLastNameOrFirstName(String lastName, String firstName) {
		return personDao.findByLastNameOrFirstName(lastName, firstName);
	}

	public List<Person> findByLastNameOrderByCreatedDateDesc(String lastName) {
		return personDao.findByLastNameOrderByCreatedDateDesc(lastName);
	}

	public List<Person> findByAgeLessThanEqual(Integer age) {
		return personDao.findByAgeLessThanEqual(age);
	}

	public List<Person> findByFirstNameLike(String firstName) {
		return personDao.findByFirstNameLike(firstName);
	}

	public List<Person> findByLastNameAndAgeLessThanEqual(String lastName, int age) {
		return personDao.findByLastNameAndAgeLessThanEqual(lastName, age);
	}

	public List<Person> findByCreatedDateBetween(Date startdate, Date endDate) {
		return personDao.findByCreatedDateBetween(startdate, endDate);
	}

	public Iterable<Book> saveAllBooks(Iterable<Book> booksData) {
		return bookDao.saveAll(booksData);

	}

	public Iterable<Book> findAllBooks() {
		return bookDao.findAll();
	}

	public Iterable<Book> findByBookName(String bookName) {
		return bookDao.findByBookName(bookName);
	}

	public List<Person> giveDataByName(String firstName) {
		return personDao.giveDataByName(firstName);
	}

	public Iterable<Book> listBooksWithName(String bookName) {
		return bookDao.listBooksWithName(bookName);
	}

	public Iterable<Employee> saveAllEmployees(Iterable<Employee> empList) {
		return empDao.saveAll(empList);
	}
	public Iterable<Employee> getAllEmployees(){
		return empDao.findAll();
	}
	public List<Object[]> findMaxSalariesByDept(List<String> deptNames){
		return empDao.findMaxSalariesByDept(deptNames);
	}
	public List<CustomType> giveFewColumns(String firstName){
		return personDao.giveFewColumns(firstName);
	}

	public List<Person> findPersonInfobyFirstNameorEmail(String firstName,String email)
	{
		return personDao.findPersonInfobyFirstNameorEmail(firstName,email);
	}

	public List<Person> findPersonINfobyFirstname(String firstName){
		return personDao.findPersonINfobyFirstname(firstName);
	}
	public List<Person> findByLastName(String lastName,PageRequest pageRequest){
		return personDao.findByLastName(lastName,pageRequest);

	}
}
