package com.example.demo.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AppUser;

@Repository
public class AppUserRepository extends RepositoryBase<AppUser> {

	public AppUserRepository() {
		
	}
	public Iterable<AppUser> getall() {

		Session currentSession = entityManager.unwrap(Session.class);
		Iterable<AppUser> lists = (Iterable<AppUser>) currentSession.createQuery("from AppUser",AppUser.class).getResultList();
		return lists;
	};
}
