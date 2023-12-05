package br.edu.univille.microservicoaluno.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.microservicoaluno.entity.Aluno;
import br.edu.univille.microservicoaluno.entity.Professor;
import br.edu.univille.microservicoaluno.repository.ProfessorRepository;
import br.edu.univille.microservicoaluno.service.ProfessorService;



@Service
public class ProfessorServiceImpl implements ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    @Override
    public List<Professor> getAll() {

        var iterador = repository.findAll();
        List<Professor> listaProfessores = new ArrayList<>();

        iterador.forEach(listaProfessores::add);

        /*while(iterador.iterator().hasNext()){
            var umItem = iterador.iterator().next();
            listaProfessores.add(umItem);
        }*/

        return listaProfessores;        
    }
    @Override
    public Professor create(Professor professor) {
        return repository.save(professor);
    }
    @Override
    public Professor update(String id, Professor professor) {
        professor.setId(id); // Garantindo que o ID é o mesmo
        return repository.save(professor);
    }
    //Metodo para atualizar um aprofessorluno
    @Override
    public Professor update(Professor professor) {
        return repository.save(professor);
    }

    @Override
    public Professor delete(String id) {
        var buscaCarro = repository.findById(id);
        if (buscaCarro.isPresent()){
            var carro = buscaCarro.get();

            repository.delete(carro);

            return carro;
        }
        return null;
    }
} 