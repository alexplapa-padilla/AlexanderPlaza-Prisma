package com.prismastereo.model;

public class Programa {
    private int id;
    private String nombre;
    private String horario;
    private String director;
    private String descripcion;

    // Constructor para tu programación
    public Programa(String nombre, String horario, String director, String descripcion) {
        this.nombre = nombre;
        this.horario = horario;
        this.director = director;
        this.descripcion = descripcion;
    }

    // Getters y Setters (Necesarios para el estándar SENA)
    public String getNombre() { return nombre; }
    public String getHorario() { return horario; }
    public String getDirector() { return director; }
}