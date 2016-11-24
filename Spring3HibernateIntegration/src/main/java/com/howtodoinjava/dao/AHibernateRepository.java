package com.howtodoinjava.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public abstract class AHibernateRepository<T, K> {

	// ***PO.java
	private final Class<T> entityClass;

	@PersistenceContext
	EntityManager entityManager;

	/*
	 * private final CriteriaBuilder criteriaBuilder; private final
	 * CriteriaQuery<ObjectPO> criteriaQuery; private final Root<ObjectPO> root;
	 */
	@SuppressWarnings("unchecked")
	public AHibernateRepository() {
		this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		/*
		 * this.criteriaBuilder = entityManager.getCriteriaBuilder();
		 * this.criteriaQuery = (CriteriaQuery<ObjectPO>)
		 * criteriaBuilder.createQuery(entityClass); this.root =
		 * (Root<ObjectPO>) criteriaQuery.from(entityClass);
		 */
	}

	public void savePO(T entity) {
		entityManager.persist(entity);
		entityManager.flush();
	}

	public T updatePO(T entity) {
		return entityManager.merge(entity);
	}

	/**
	 * return a proxy object with the given identity value
	 * 
	 * @param key
	 * @return
	 */

	public T getReference(K key) {
		return entityManager.getReference(entityClass, key);
	}

	public void deletePO(T entity) {
		entityManager.remove(entity);
	}

	public void deletePOById(K k) {
		T objectPO = getReference(k);
		if (objectPO != null) {
			deletePO(objectPO);
			//return true;
		}
		//return false;
	}
	
	 public List< T > findAll(){
	      return entityManager.createQuery( "from " + entityClass.getName() )
	       .getResultList();
	   }

	public List<T> findAllBySpecification(Specification<T> specification) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery(entityClass);
		Root<T> root = (Root<T>) criteriaQuery.from(entityClass);

		// get predicate from specification
		Predicate predicate = specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		// set predicate and execute query
		criteriaQuery.where(predicate);
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

}
