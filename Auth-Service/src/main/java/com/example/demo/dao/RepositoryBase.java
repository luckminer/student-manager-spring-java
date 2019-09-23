package com.example.demo.dao;


import javax.persistence.EntityManager;

import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class RepositoryBase<T> {
	@Autowired
	protected EntityManager entityManager;
	
	public T add(T  enity) {

		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(enity);

		return enity;
	};

	public void delete(T enity) {

		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.delete(enity);

	};

	

}
