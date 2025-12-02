package com.empresa.capacitacion.controller;

import com.empresa.capacitacion.entity.Curso;
import com.empresa.capacitacion.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private CursoRepository cursoRepo;
    
    @GetMapping("/cursos")
    public ResponseEntity<List<Curso>> listarCursosAPI() {
        return ResponseEntity.ok(cursoRepo.findAll());
    }
}