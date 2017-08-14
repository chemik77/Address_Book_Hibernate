package pl.chemik77;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.chemik77.model.Address;
import pl.chemik77.model.Contact;
import pl.chemik77.model.Person;

public class Main {

	public static void main(String[] args) {

		addPerson();

	}

	private static void addPerson() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("manager1");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Person person = new Person("Anna", "Jezyna", LocalDate.parse("1987-05-01"));
		Contact contact = new Contact("jezyna_anna@gmail.com", "785 154 895");
		Address address = new Address("Opolska", "5/1", "00-584", "Warszawa");

		person.setContact(contact);
		person.setAddress(address);
		contact.setPerson(person);

		entityManager.getTransaction().begin();
		entityManager.persist(person);
		entityManager.persist(address);
		entityManager.persist(contact);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
