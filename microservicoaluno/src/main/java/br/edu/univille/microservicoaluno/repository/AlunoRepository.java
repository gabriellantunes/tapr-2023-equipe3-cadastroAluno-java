package br.edu.univille.microservicoaluno.repository;

import br.edu.univille.microservicoaluno.entity.Aluno;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository
    extends CrudRepository<Aluno,String>{
}
