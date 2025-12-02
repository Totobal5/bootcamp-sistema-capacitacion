package com.empresa.capacitacion.controller;

import com.empresa.capacitacion.entity.*;
import com.empresa.capacitacion.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @Autowired CursoRepository cursoRepo;
    @Autowired InscripcionRepository inscripcionRepo;
    @Autowired UsuarioRepository usuarioRepo;

    @GetMapping({"/", "/home"})
    public String home(Authentication auth) {
        if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/admin/cursos";
        }
        return "redirect:/empleado/cursos";
    }

    @GetMapping("/admin/cursos")
    public String panelAdmin(Model model) {
        model.addAttribute("cursos", cursoRepo.findAll());
        model.addAttribute("nuevoCurso", new Curso());
        return "admin_cursos";
    }

    @PostMapping("/admin/cursos/crear")
    public String crearCurso(@ModelAttribute Curso curso) {
        cursoRepo.save(curso);
        return "redirect:/admin/cursos";
    }

    @GetMapping("/empleado/cursos")
    public String panelEmpleado(Model model, Authentication auth) {
        model.addAttribute("cursos", cursoRepo.findAll());
        
        Usuario u = usuarioRepo.findByUsername(auth.getName()).orElse(null);
        model.addAttribute("misInscripciones", inscripcionRepo.findByEmpleado(u));
        
        return "empleado_cursos";
    }

    @PostMapping("/empleado/inscribir/{id}")
    public String inscribir(@PathVariable Long id, Authentication auth) {
        Curso c = cursoRepo.findById(id).orElse(null);
        Usuario u = usuarioRepo.findByUsername(auth.getName()).orElse(null);
        
        if (c != null && u != null) {
            inscripcionRepo.save(new Inscripcion(u, c));
        }
        return "redirect:/empleado/cursos";
    }
}