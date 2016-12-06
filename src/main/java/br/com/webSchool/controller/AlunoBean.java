package br.com.webSchool.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;

import br.com.webSchool.model.Aluno;
import br.com.webSchool.model.TipoEstadoCivil;
import br.com.webSchool.repository.AlunoService;

@ManagedBean
@SessionScoped
public class AlunoBean extends AbstractFacadeBean<Aluno> {

	private static final long serialVersionUID = 1L;


	@ManagedProperty(value = "#{alunoService}")
	private AlunoService alunoService;

	private Aluno aluno;

	private String stringPode;

	private List<Aluno> listAlunos;

	private boolean searching;

	public void initBean() {
		aluno = new Aluno();
		listAlunos = new ArrayList<Aluno>();
	}

	public String save() {
		alunoService.save(aluno);
		return "/index";
	}
	
	public String defaulEditAluno(){
		defaultUpdate(aluno);
		return "/public/modal.xhtml";
	}

	public void defaultDeletAluno(Aluno aluno) {
		defaultDelet(aluno);
	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Car Edited",((Aluno) event.getObject()).getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void autoCompleteNomeAluno() {
		searching = true;
		listAlunos = alunoService.findByFilter(aluno);
	}

	public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Aluno) event.getObject()).getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public String editar(Aluno aluno){
		 aluno = (Aluno) defaultEdit(aluno);
		 
		 return "/index";
	}
	
	public String getMensagemTable(){
		return listAlunos.size() + " Aluno(s) Encontrado(s)";
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public TipoEstadoCivil[] getEstadoCivis() {
		return TipoEstadoCivil.values();
	}

	public void setAlunoService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	public String getStringPode() {
		return stringPode;
	}

	public void setStringPode(String stringPode) {
		this.stringPode = stringPode;
	}

	public List<Aluno> getListAlunos() {
		return listAlunos;
	}

	public void setListAlunos(List<Aluno> listAlunos) {
		this.listAlunos = listAlunos;
	}

	public boolean isSearching() {
		return searching;
	}

	public void setSearching(boolean searching) {
		this.searching = searching;
	}

}