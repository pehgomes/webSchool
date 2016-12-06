package br.com.webSchool.repository;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.webSchool.model.BaseEntity;

@ManagedBean
public abstract class BaseService<T extends BaseEntity> extends JPAUtils{

	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "meupersistence")
	private EntityManager manager;
	
	public void save(final T object){
		EntityManager em = getEntityManager();
		try{
			em.getTransaction().begin();
			em.persist(object);
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void remove(final Class<?> clazz, final Long id){
		EntityManager em = getEntityManager();
		T t =  ((T) em.find(clazz, id));
		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
		} catch(Exception e ) {
			em.getTransaction().rollback();
		} finally{
			em.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void update(T t){
		EntityManager em = getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(t);
			em.getTransaction().commit();
		} catch (Exception e){
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public BaseEntity findById(final Class<?> clazz, final Long id){
		EntityManager em = getEntityManager();

		T t = (T) em.find(clazz, id);
		em.close();
		
		return t;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> clazz){
		EntityManager em = getEntityManager();
		StringBuilder jpql = new StringBuilder();
		
		String alias = clazz.getSimpleName().substring(0, 2);
		
		jpql.append("SELECT {0} FROM {1} {0} ".replace("{0}", alias).replace("{1}", clazz.getSimpleName())); 
		try{
			return em.createQuery(jpql.toString())
			.getResultList();
		}finally{
			em.close();
		}
	}

}
