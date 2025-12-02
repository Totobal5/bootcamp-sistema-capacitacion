package com.empresa.capacitacion.config;

import com.empresa.capacitacion.entity.*;
import com.empresa.capacitacion.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired UsuarioRepository usuarioRepo;
    @Autowired CursoRepository cursoRepo;
    @Autowired PasswordEncoder encoder;

    @Override
    public void run(String... args) {
        // Crear Admin
        usuarioRepo.save(new Usuario("admin", encoder.encode("1234"), "ADMIN"));
        
        // Crear Empleado
        usuarioRepo.save(new Usuario("juan", encoder.encode("1234"), "EMPLEADO"));

        // Crear Cursos
        cursoRepo.save(new Curso("Java Spring Boot", "Desarrollo Backend", "Prof. Silva", 20));
        cursoRepo.save(new Curso("Seguridad Informática", "Conceptos básicos", "Prof. González", 15));
        cursoRepo.save(new Curso("Gestión Ágil", "Scrum y Kanban", "Prof. Tapia", 30));
        
        System.out.println("--- DATOS INICIALIZADOS ---");
        System.out.println("Admin: admin / 1234");
        System.out.println("Empleado: juan / 1234");
    }
}