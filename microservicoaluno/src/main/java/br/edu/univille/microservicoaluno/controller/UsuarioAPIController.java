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
