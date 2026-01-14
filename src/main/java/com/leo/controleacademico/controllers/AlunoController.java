package com.leo.controleacademico.controllers;

import com.leo.controleacademico.entities.Aluno;
import com.leo.controleacademico.services.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno){
        Aluno salvo = alunoService.salvar(aluno);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscar(@PathVariable Long id){
        Aluno procurado = alunoService.buscarPorId(id);

        if(procurado == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(procurado);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listar(){
        return ResponseEntity.ok(alunoService.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Aluno> deletar(@PathVariable Long id){
        alunoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
