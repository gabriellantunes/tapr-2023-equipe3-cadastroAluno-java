package br.edu.univille.microservicoaluno.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.univille.microservicoaluno.entity.Aluno;
import br.edu.univille.microservicoaluno.repository.AlunoRepository;
import br.edu.univille.microservicoaluno.service.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService{

    @Autowired
    private AlunoRepository repository;

    @Override
    public List<Aluno> getAll() {

        var iterador = repository.findAll();
        List<Aluno> listaAlunos = new ArrayList<>();

        iterador.forEach(listaAlunos::add);

        /*while(iterador.iterator().hasNext()) {
            var umItem = iterador.iterator().next();
            listaAlunos.add(umItem);
        }*/

        return listaAlunos;
    }
    //Feito 11/11/2023
    //Metodo para criar um aluno
    @Override
    public Aluno create(Aluno aluno) {
        return repository.save(aluno);
    }
    //Metodo para atualizar um aluno
    @Override
    public Aluno update(String id, Aluno aluno) {
        aluno.setId(id); // Garantindo que o ID é o mesmo
        return repository.save(aluno);
    }
    //Metodo para deletar um aluno
    /*@Override
    public void delete(String id) {
        repository.deleteById(id);
    }*/
    @Override
    public Aluno delete(String id) {
        var buscaCarro = repository.findById(id);
        if (buscaCarro.isPresent()){
            var carro = buscaCarro.get();

            repository.delete(carro);

            return carro;
        }
        return null;
    }

}
