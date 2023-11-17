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
import br.edu.univille.microservicoaluno.service.AlunoService;

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

@RestController
@RequestMapping("/api/v1/alunos")
public class UsuarioAPIController {
    @Autowired
    private AlunoService service;
    
    @GetMapping
    public ResponseEntity<List<Aluno>> listarAlunos() {
        //var listaAlunos = new ArrayList<Aluno>();
        var listaAlunos = service.getAll();

        return 
            new ResponseEntity<List<Aluno>>(listaAlunos, HttpStatus.OK);
    }
    //Feito 11/11/2023
    @PostMapping
    public ResponseEntity<Aluno> criarAluno(@RequestBody Aluno aluno) {
        Aluno novoAluno = service.create(aluno); //vou criar dps no alunoService o metodo create
        return new ResponseEntity<>(novoAluno, HttpStatus.CREATED);
    }
    //Feito 11/11/2023
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable String id, @RequestBody Aluno aluno) {
        Aluno alunoAtualizado = service.update(id, aluno); //vou criar dps no alunoService o metodo update
        return new ResponseEntity<>(alunoAtualizado, HttpStatus.OK);
    }
    //Feito 11/11/2023
    /*@DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable String id) {
        service.delete(id); //vou criar dps no alunoService o metodo delete
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/
    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> removerCarro(@PathVariable("id")  String id){
        if(id == ""  || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var aluno = service.delete(id);
        if(aluno == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return 
            new ResponseEntity<Aluno>
            (aluno, HttpStatus.OK);
    }
    //Feito 11/11/2023
    //Pagina WEB
    @Controller
    public class WebController {

        @GetMapping("/")
        public String home() {
            return "index";
        }
    }
}



/* BACKUP FEITO EM AULA
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
import br.edu.univille.microservicoaluno.service.AlunoService;


@RestController
@RequestMapping("/api/v1/alunos")
public class UsuarioAPIController {
    @Autowired
    private AlunoService service;
    
    @GetMapping
    public ResponseEntity<List<Aluno>> listarAlunos() {
        //var listaAlunos = new ArrayList<Aluno>();
        var listaAlunos = service.getAll();

        return 
            new ResponseEntity<List<Aluno>>(listaAlunos, HttpStatus.OK);
    }
}
*/