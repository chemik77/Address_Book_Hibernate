package pl.chemik77.database.dao;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.*;

import pl.chemik77.model.Person;

public class CommonDaoTest {

	private CommonDao commonDao = new CommonDao();
	private Person person = new Person("firstName_test", "lastName_test", LocalDate.parse("2000-01-01"));
	private Person person2 = new Person("firstName_test2", "lastName_test2", LocalDate.parse("2000-01-01"));

	@Test
	public void testCommonDao1() {
		EntityManagerFactory entityManagerFactory = commonDao.getEntityManagerFactory();
		boolean active = entityManagerFactory.isOpen();
		assertTrue(active);
	}

	@Test
	public void testCommonDao2() {
		CommonDao commonDao2 = new CommonDao();
		EntityManagerFactory entityManagerFactory = commonDao.getEntityManagerFactory();
		EntityManagerFactory entityManagerFactory2 = commonDao2.getEntityManagerFactory();
		assertEquals(entityManagerFactory2, entityManagerFactory);
	}

	@Test
	public void testBeginTransaction1() {
		commonDao.beginTransaction();
		EntityManager entityManager = commonDao.getEntityManager();
		assertNotNull(entityManager);
	}

	@Test
	public void testBeginTransaction2() {
		commonDao.beginTransaction();
		EntityTransaction transaction = commonDao.getTransaction();
		assertNotNull(transaction);
	}

	@Test
	public void testBeginTransaction3() {
		commonDao.beginTransaction();
		boolean active = commonDao.getTransaction().isActive();
		assertTrue(active);
	}

	@Test
	public void testCloseTransaction() {
		commonDao.beginTransaction();
		commonDao.closeTransaction();
		boolean active = commonDao.getTransaction().isActive();
		assertFalse(active);
	}

	@Test
	public void testCloseTransaction3() {
		commonDao.beginTransaction();
		commonDao.closeTransaction();
		EntityManager entityManager = commonDao.getEntityManager();
		boolean open = entityManager.isOpen();
		assertFalse(open);
	}

	@Test
	public void testPersist() {
		commonDao.beginTransaction();
		commonDao.persist(person);
		Person personInDB = commonDao.getEntityManager().find(Person.class, person.getId());
		commonDao.closeTransaction();
		assertEquals(personInDB, person);
	}

	@Test
	public void testDeleteById() {
		int id = 2;
		addTestRecords();

		commonDao.beginTransaction();
		commonDao.deleteById(Person.class, id);
		commonDao.closeTransaction();

		commonDao.beginTransaction();
		Person deleted = commonDao.getEntityManager().find(Person.class, id);
		assertNull(deleted);
	}

	@Test
	public void testDelete() {
		addTestRecords();

		commonDao.beginTransaction();
		commonDao.delete(person);
		commonDao.closeTransaction();

		commonDao.beginTransaction();
		Person deleted = commonDao.getEntityManager().find(Person.class, person.getId());
		assertNull(deleted);
	}

	@Test
	public void testFindById() {
		addTestRecords();

		commonDao.beginTransaction();
		Person found = commonDao.findById(Person.class, person.getId());
		assertEquals(person.getFirstName(), found.getFirstName());
	}

	@Test
	public void testGetAllRecords() {
		int addedRecords = 2;
		commonDao.beginTransaction();
		commonDao.getEntityManager().createQuery("DELETE FROM Person").executeUpdate();
		commonDao.closeTransaction();

		addTestRecords();

		commonDao.beginTransaction();
		List<Person> allRecords = commonDao.getAllRecords(Person.class);
		int size = allRecords.size();
		assertEquals(addedRecords, size);
	}

	// ------------------------------------------

	private void addTestRecords() {
		commonDao.beginTransaction();
		commonDao.persist(person);
		commonDao.persist(person2);
		commonDao.closeTransaction();
	}
}
