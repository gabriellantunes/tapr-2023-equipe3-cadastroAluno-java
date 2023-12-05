package br.edu.univille.microservicoaluno.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.edu.univille.microservicoaluno.entity.Aluno;
import br.edu.univille.microservicoaluno.repository.AlunoRepository;
import br.edu.univille.microservicoaluno.service.AlunoService;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;

@Service
public class AlunoServiceImpl implements AlunoService{

    @Autowired
    private AlunoRepository repository;
    private DaprClient client = new DaprClientBuilder().build();
    @Value("${app.component.topic.aluno}")
    private String TOPIC_NAME;
    @Value("${app.component.service}")
	private String PUBSUB_NAME;

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
        publicarAtualizacao(aluno);
        return repository.save(aluno);
    }
    //Metodo para atualizar um aluno
    @Override
    public Aluno update(String id, Aluno aluno) {
        aluno.setId(id); // Garantindo que o ID é o mesmo
        publicarAtualizacao(aluno);
        return repository.save(aluno);
    }
    //Metodo para deletar um aluno
    /*@Override
    public void delete(String id) {
        repository.deleteById(id);
    }*/
    @Override
    public Aluno delete(String id) {
        var buscaAluno = repository.findById(id);
        if (buscaAluno.isPresent()){
            var aluno = buscaAluno.get();

            repository.delete(aluno);

            return aluno;
        }
        return null;
    }

      //método privado para publicar a atualização
      private void publicarAtualizacao(Aluno aluno){
        client.publishEvent(
					PUBSUB_NAME,
					TOPIC_NAME,
					aluno).block();
    }

}