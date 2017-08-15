package pl.chemik77.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFProvider {

	private static EntityManagerFactory entityManagerFactory;

	private EMFProvider() {
	}

	public static EntityManagerFactory getInstance() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("manager1");
		}
		return entityManagerFactory;
	}

	public static void closeEMF() {
		entityManagerFactory.close();
	}
}
