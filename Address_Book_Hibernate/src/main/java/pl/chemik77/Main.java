package pl.chemik77;

import java.time.LocalDate;

import pl.chemik77.database.dao.CommonDao;
import pl.chemik77.model.Address;
import pl.chemik77.model.Contact;
import pl.chemik77.model.Person;
import pl.chemik77.utils.EMFProvider;

public class Main {

	public static void main(String[] args) {

		addPerson1();
		addPerson2();
		addPerson3();
		addPerson4();

		EMFProvider.closeEMF();
	}

	private static void addPerson1() {

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

	private static void addPerson2() {

		Person person = new Person("Piotr", "Wojciechowski", LocalDate.parse("1986-05-01"));
		Contact contact = new Contact("woj_piotr@gmail.com", "856 154 895");
		Address address = new Address("Małopanewska", "1", "52-584", "Wrocław");

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

	private static void addPerson3() {

		Person person = new Person("Maria", "Adamczyk", LocalDate.parse("1971-12-11"));
		Contact contact = new Contact("adamczyk32@gmail.com", "825 111 854");
		Address address = new Address("Piłsudskiego", "15/4", "02-484", "Warszawa");

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

	private static void addPerson4() {

		Person person = new Person("Julian", "Zawalny", LocalDate.parse("1990-02-11"));
		Contact contact = new Contact("jzawalny@gmail.com", "502 224 995");
		Address address = new Address("Główna", "152", "02-584", "Warszawa");

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
