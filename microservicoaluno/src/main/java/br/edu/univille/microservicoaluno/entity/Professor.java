package br.edu.univille.microservicoaluno.entity;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "professor")

public class Professor {

    @Id
    @PartitionKey
    @GeneratedValue
    public String id;
    
    public int matricula;
    public String disciplina;
    public String aula;
    public String formacao;
    public int grade;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
                                                               
    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }    

    public String getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getAula() {
        return aula;
    }
    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getFormacao() {
        return formacao;
    }
        public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
    
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    
}