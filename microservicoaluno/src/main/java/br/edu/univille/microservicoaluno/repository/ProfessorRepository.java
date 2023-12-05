package br.edu.univille.microservicoaluno.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.univille.microservicoaluno.entity.Professor;

@Repository
public interface ProfessorRepository 
    extends CrudRepository<Professor,String>{
    
}