package br.edu.univille.microservicoaluno.service;

import java.util.List;

import br.edu.univille.microservicoaluno.entity.Aluno;

public interface AlunoService {
    List<Aluno> getAll();
    Aluno create(Aluno aluno);
    Aluno update(String id, Aluno aluno);
    /*void delete(String id);*/
    public Aluno delete(String id);
}
