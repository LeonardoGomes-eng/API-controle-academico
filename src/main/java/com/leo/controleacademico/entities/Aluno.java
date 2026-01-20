package com.leo.controleacademico.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Aluno {

    @ManyToMany
    @JoinTable(
            name = "aluno_disciplina",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private List<Disciplina> disciplinas = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int matricula;
    private String curso;

    public Aluno(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
