package com.leo.controleacademico.controllers;

import com.leo.controleacademico.entities.Disciplina;
import com.leo.controleacademico.services.DisciplinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {
    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService){
        this.disciplinaService = disciplinaService;
    }

    @PostMapping
    public ResponseEntity<Disciplina> criar(@RequestBody Disciplina disciplina){
        Disciplina salvo = disciplinaService.salvar(disciplina);

        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscar(@PathVariable Long id){
        Disciplina procurado = disciplinaService.buscarPorId(id);

        if(procurado == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(procurado);
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> listar(){
        return ResponseEntity.ok(disciplinaService.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Disciplina> deletar(@PathVariable Long id){
        disciplinaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
