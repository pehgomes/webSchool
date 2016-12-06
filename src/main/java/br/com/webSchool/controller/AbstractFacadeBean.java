package br.com.webSchool.controller;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import br.com.webSchool.model.BaseEntity;
import br.com.webSchool.repository.BaseService;

@ManagedBean
public abstract class AbstractFacadeBean<T extends BaseEntity> extends BaseService<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Boolean> beanProperties;

	@PostConstruct
	private void init(){
		initBean();
	}
	
	protected abstract void initBean();
	
	protected  void beforeSave() {}
	
	protected  void afterSave() {}
	
	protected boolean search(Boolean search){
		return search;
	}
	
	protected void defaultDelet(T t){
		Class<?> cl = t.getClass(); 
		remove(cl, t.getId());
	}
	
	protected void defaultUpdate(T t){
		update(t);
	}
	
	protected BaseEntity  defaultEdit(T t){
		Class<?> clazz = t.getClass();
		return findById(clazz, t.getId());
	}
	
	public Map<String, Boolean> getBeanProperties() {
		return beanProperties;
	}

	public void setBeanProperties(Map<String, Boolean> beanProperties) {
		this.beanProperties = beanProperties;
	}
}
