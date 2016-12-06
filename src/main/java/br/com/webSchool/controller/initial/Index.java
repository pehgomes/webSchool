package br.com.webSchool.controller.initial;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.log4j.Logger;

@ManagedBean
@RequestScoped
public class Index {

	private Logger logger = Logger.getLogger(Index.class);
	
	@PostConstruct
	private void init() {
		logger.info("Executado");
	}
	
	public String getMessage() {
		return "Hello World JSF!";
	}
	
	public String register(){
		return "/public/regiter.xhtml"; 
	}
}

