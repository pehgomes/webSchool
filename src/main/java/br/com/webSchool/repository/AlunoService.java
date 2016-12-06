package br.com.webSchool.repository;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import br.com.webSchool.model.Aluno;

@ManagedBean(name = "alunoService")
@ApplicationScoped
public class AlunoService extends BaseService<Aluno> {

	private static final long serialVersionUID = -6091274837887339920L;

	@SuppressWarnings("unchecked")
	public List<Aluno> findByFilter(Aluno aluno) {
		EntityManager em = getEntityManager();

		StringBuilder str = new StringBuilder();

		str.append("SELECT al FROM Aluno al ");
		str.append(" WHERE al.nome LIKE :nome ");

		List<Aluno> alunos = em.createQuery (str.toString()).setParameter("nome", "%"+aluno.getNome()+"%").getResultList();
		return alunos;
	}
	
}
