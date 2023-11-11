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

}