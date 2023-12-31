package br.edu.univille.microservicoaluno.entity;

import org.springframework.data.annotation.Id;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "aluno")
public class Aluno {
    
    @Id
    @PartitionKey
    @GeneratedValue
    public String id;
    public String nome;
    public int matricula;
    public String professorId;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    public String getprofessorId() {
        return nome;
    }
    public void setprofessorId(String professorId) {
        this.professorId = professorId;
    }
}
