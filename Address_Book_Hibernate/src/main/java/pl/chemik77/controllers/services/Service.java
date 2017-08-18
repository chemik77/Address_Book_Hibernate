package pl.chemik77.controllers.services;

import java.util.List;

import pl.chemik77.database.dao.CommonDao;
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
		return allRecords;
	}

	public <T> T getRecord(Class<T> cls, int id) {

		dao.beginTransaction();
		T record = dao.findById(cls, id);
		dao.closeTransaction();

		return record;
	}
}
