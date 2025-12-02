package com.empresa.capacitacion.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "inscripciones")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario empleado;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    private LocalDate fechaInscripcion;

    public Inscripcion() {}

    public Inscripcion(Usuario empleado, Curso curso) {
        this.empleado = empleado;
        this.curso = curso;
        this.fechaInscripcion = LocalDate.now();
    }

    // Getters y Setters
    public Long getId() { return id; }
    public Usuario getEmpleado() { return empleado; }
    public void setEmpleado(Usuario empleado) { this.empleado = empleado; }
    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
    public LocalDate getFechaInscripcion() { return fechaInscripcion; }
}