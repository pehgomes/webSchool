package br.com.webSchool.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class JPAUtils implements Serializable{

	private static final long serialVersionUID = -8070756638556625493L;

	private EntityManagerFactory emf;
	
	protected EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	public JPAUtils(){
		emf  = Persistence.createEntityManagerFactory("meupersistence");
	}
}
