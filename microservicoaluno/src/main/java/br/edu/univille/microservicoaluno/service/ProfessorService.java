package br.edu.univille.microservicoaluno.service;

import java.util.List;

import br.edu.univille.microservicoaluno.entity.Aluno;
import br.edu.univille.microservicoaluno.entity.Professor;

public interface ProfessorService {

    public List<Professor> getAll();
    Professor create(Professor professor);
    Professor update(String id, Professor professor);
    Professor update(Professor professor);
    public Professor delete(String id);


}