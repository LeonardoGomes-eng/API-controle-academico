package com.leo.controleacademico.services;

import com.leo.controleacademico.entities.Disciplina;
import com.leo.controleacademico.repositories.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository){
        this.disciplinaRepository = disciplinaRepository;
    }

    public Disciplina salvar(Disciplina disciplina){
        return disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> listar(){
        return disciplinaRepository.findAll();
    }

    public Disciplina buscarPorId(Long id){
        return disciplinaRepository.findById(id).orElse(null);
    }

    public void deletar(Long id){
        disciplinaRepository.deleteById(id);
    }
}
