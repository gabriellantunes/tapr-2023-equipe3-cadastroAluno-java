package br.edu.univille.microservicoaluno.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univille.microservicoaluno.entity.Aluno;
import br.edu.univille.microservicoaluno.entity.Professor;
import br.edu.univille.microservicoaluno.service.AlunoService;
import br.edu.univille.microservicoaluno.service.ProfessorService;
import io.dapr.Topic;

//Importações do PostMapping
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//Importações do PutMapping
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Importações do DeleteMapping
import org.springframework.web.bind.annotation.DeleteMapping;

//Metodo para a pagina HTML
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//CRUD - criar, ler, atualizar e deletar

import io.dapr.Topic;
import io.dapr.client.domain.CloudEvent;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/v1/professores")
public class ProfessorAPIController {

    @Autowired
    private ProfessorService service;

    @GetMapping
    public ResponseEntity<List<Professor>> listarProfessores(){
        //var listaProfessores = new ArrayList<Professor>();
        var listaProfessores = service.getAll();
    
        return 
            new ResponseEntity<List<Professor>>(listaProfessores, HttpStatus.OK);        
    }
    @PostMapping
    public ResponseEntity<Professor> criarProfessor(@RequestBody Professor professor) {
        Professor novoProfessor = service.create(professor);
        return new ResponseEntity<>(novoProfessor, HttpStatus.CREATED);
    }    
    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizarProfessor(@PathVariable String id, @RequestBody Professor professor) {
        Professor professorAtualizado = service.update(id, professor);
        return new ResponseEntity<>(professorAtualizado, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    //public ResponseEntity<Professor> removerCarro(@PathVariable("id")  String id){
    public ResponseEntity<Professor> removerProfessor(@PathVariable("id")  String id){
        if(id == ""  || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var professor = service.delete(id);
        if(professor == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return 
            new ResponseEntity<Professor>
            (professor, HttpStatus.OK);
    }
    
    @Topic(name = "${app.component.topic.professor}", pubsubName = "${app.component.service}")
    @PostMapping(path = "/event", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<Professor> atualizarProfessor(@RequestBody(required = false) CloudEvent<Professor> cloudEvent){
        var professor = service.update(cloudEvent.getData());
        return 
            new ResponseEntity<Professor>
            (professor, HttpStatus.OK);
    }

}