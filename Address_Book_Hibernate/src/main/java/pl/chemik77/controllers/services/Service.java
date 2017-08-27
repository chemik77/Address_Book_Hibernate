package pl.chemik77.controllers.services;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import pl.chemik77.database.dao.CommonDao;
import pl.chemik77.model.Address;
import pl.chemik77.model.Contact;
import pl.chemik77.model.Person;

public class Service {

	private CommonDao dao;

	public Service() {
		this.dao = new CommonDao();
	}

	public List<Person> getPersonsList() {
		dao.beginTransaction();
		List<Person> allRecords = dao.getAllRecords(Person.class);
		dao.closeTransaction();
		allRecords.sort(new ComparatorC());
		return allRecords;
	}

	public <T> T getRecord(Class<T> cls, int id) {

		dao.beginTransaction();
		T record = dao.findById(cls, id);
		dao.closeTransaction();

		return record;
	}

	public <T> void deleteRecord(Class<T> cls, int id) {
		dao.beginTransaction();
		dao.deleteById(cls, id);
		dao.closeTransaction();
	}

	public void addPerson(HttpServletRequest request) {
		Person person = new Person();
		Contact contact = new Contact();
		Address address = new Address();
		person.setContact(contact);
		person.setAddress(address);

		person.setFirstName(request.getParameter("firstName"));
		person.setLastName(request.getParameter("lastName"));
		person.setBirth(LocalDate.parse(request.getParameter("birth")));

		contact.setEmail(request.getParameter("email"));
		contact.setPhone(request.getParameter("phone"));

		address.setStreet(request.getParameter("street"));
		address.setHouseNo(request.getParameter("houseNo"));
		address.setZipCode(request.getParameter("zipCode"));
		address.setCity(request.getParameter("city"));

		dao.beginTransaction();
		dao.persist(person);
		dao.persist(contact);
		dao.persist(address);
		dao.closeTransaction();
	}

	public void updatePerson(HttpServletRequest request) {
		Person person = new Person();
		Contact contact = new Contact();
		Address address = new Address();
		person.setContact(contact);
		person.setAddress(address);

		person.setId(Integer.parseInt(request.getParameter("personId")));
		person.setFirstName(request.getParameter("firstName"));
		person.setLastName(request.getParameter("lastName"));
		person.setBirth(LocalDate.parse(request.getParameter("birth")));

		contact.setId(Integer.parseInt(request.getParameter("contactId")));
		contact.setEmail(request.getParameter("email"));
		contact.setPhone(request.getParameter("phone"));

		address.setId(Integer.parseInt(request.getParameter("addressId")));
		address.setStreet(request.getParameter("street"));
		address.setHouseNo(request.getParameter("houseNo"));
		address.setZipCode(request.getParameter("zipCode"));
		address.setCity(request.getParameter("city"));

		dao.beginTransaction();
		dao.refresh(person);
		dao.refresh(contact);
		dao.refresh(address);
		dao.closeTransaction();
	}

}

