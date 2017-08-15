package pl.chemik77;

import java.time.LocalDate;

import pl.chemik77.database.dao.CommonDao;
import pl.chemik77.model.Address;
import pl.chemik77.model.Contact;
import pl.chemik77.model.Person;
import pl.chemik77.utils.EMFProvider;

public class Main {

	public static void main(String[] args) {

		addPerson();

		EMFProvider.closeEMF();
	}

	private static void addPerson() {

		Person person = new Person("Anna", "Jezyna", LocalDate.parse("1987-05-01"));
		Contact contact = new Contact("jezyna_anna@gmail.com", "785 154 895");
		Address address = new Address("Opolska", "5/1", "00-584", "Warszawa");

		person.setContact(contact);
		person.setAddress(address);
		contact.setPerson(person);

		CommonDao commonDao = new CommonDao();
		commonDao.beginTransaction();
		commonDao.persist(person);
		commonDao.persist(address);
		commonDao.persist(contact);
		commonDao.closeTransaction();

	}

}
