package br.com.webSchool.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="aluno")
public class Aluno implements BaseEntity{

	private static final long serialVersionUID = 7462349355452572971L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cpf")
	private String cpf;
	
	@Column(name = "rg")
	private String rg;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "matricula")
	private String matricula;
	
	@Column(name = "nome_mae")
	private String nomeMae;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado_civil")
	private TipoEstadoCivil tipoEstadoCivil;
	
	@Column(name = "telefone")
	private String telefone;

	public Aluno(Long id, String nome, String cpf, String rg, String cep, String endereco, String email,
			String matricula, String nomeMae, TipoEstadoCivil tipoEstadoCivil, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.cep = cep;
		this.endereco = endereco;
		this.email = email;
		this.matricula = matricula;
		this.nomeMae = nomeMae;
		this.tipoEstadoCivil = tipoEstadoCivil;
		this.telefone = telefone;
	}
	
	public Aluno(){
		
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public TipoEstadoCivil getTipoEstadoCivil() {
		return tipoEstadoCivil;
	}

	public void setTipoEstadoCivil(TipoEstadoCivil estadoCivilEnum) {
		this.tipoEstadoCivil = estadoCivilEnum;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
