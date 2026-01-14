package com.leo.controleacademico.services;

import com.leo.controleacademico.entities.Aluno;
import com.leo.controleacademico.repositories.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository){
        this.alunoRepository = alunoRepository;
    }

    public Aluno salvar(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listar(){
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id){
        return alunoRepository.findById(id).orElse(null);
    }

    public void deletar(Long id){
        alunoRepository.deleteById(id);
    }
}
