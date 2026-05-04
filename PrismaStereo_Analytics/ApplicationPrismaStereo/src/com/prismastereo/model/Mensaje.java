package com.prismastereo.model;

public class Mensaje {
    private int id;
    private String oyente;
    private String contenido;
    private String cancion;
    private int fkPrograma; // <--- Este es el "puente" al programa (ej. El Fogón)

    // Constructor actualizado
    public Mensaje(String oyente, String contenido, String cancion, int fkPrograma) {
        this.oyente = oyente;
        this.contenido = contenido;
        this.cancion = cancion;
        this.fkPrograma = fkPrograma;
    }

    // No olvides agregar el Getter y Setter para fkPrograma
    public int getFkPrograma() { return fkPrograma; }
    public void setFkPrograma(int fkPrograma) { this.fkPrograma = fkPrograma; }
}