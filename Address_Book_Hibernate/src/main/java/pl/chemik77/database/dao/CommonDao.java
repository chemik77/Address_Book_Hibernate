package pl.chemik77.database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import pl.chemik77.model.BaseModel;
import pl.chemik77.utils.EMFProvider;

public class CommonDao {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction transaction;

	public CommonDao() {
		entityManagerFactory = EMFProvider.getInstance();
	}

	public void beginTransaction() {
		this.entityManager = entityManagerFactory.createEntityManager();
		this.transaction = entityManager.getTransaction();
		this.transaction.begin();
	}

	public void closeTransaction() {
		this.transaction.commit();
		this.entityManager.close();
	}

	public void persist(BaseModel baseModel) {
		this.entityManager.persist(baseModel);
	}

	public void refresh(BaseModel baseModel) {
		this.entityManager.persist(this.entityManager.merge(baseModel));
	}

	public <T> void deleteById(Class<T> cls, int id) {
		this.entityManager.remove(this.entityManager.find(cls, id));
	}

	public void delete(BaseModel baseModel) {
		this.entityManager.remove(this.entityManager.merge(baseModel));
	}

	public <T> T findById(Class<T> cls, int id) {
		return this.entityManager.find(cls, id);
	}

	public <T> List<T> getAllRecords(Class<T> cls) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(cls);
		Root<T> query = criteriaQuery.from(cls);
		criteriaQuery.select(query);
		TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
		List<T> resultList = typedQuery.getResultList();
		return resultList;
	}

	// ----------------------------------
	// getters

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public EntityTransaction getTransaction() {
		return transaction;
	}
}
