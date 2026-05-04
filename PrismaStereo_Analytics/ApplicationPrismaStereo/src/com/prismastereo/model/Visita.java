package com.prismastereo.model;

/**
 * Clase que representa la entidad Visita en el modelo de Prisma Stereo.
 * Cumple con estándares de nombramiento de variables y clases.
 */
public class Visita {
    // Atributos privados (Encapsulamiento)
    private int idVisita;
    private int fkRed;
    private String navegador;
    private String dispositivo;
    private String ipAnonima;

    // Constructor vacío (Obligatorio para estándares de Java)
    public Visita() {
    }

    // Constructor con parámetros para facilitar el registro
    public Visita(int fkRed, String navegador, String dispositivo, String ipAnonima) {
        this.fkRed = fkRed;
        this.navegador = navegador;
        this.dispositivo = dispositivo;
        this.ipAnonima = ipAnonima;
    }

    // Métodos Getter y Setter (Estándar de codificación)
    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public int getFkRed() {
        return fkRed;
    }

    public void setFkRed(int fkRed) {
        this.fkRed = fkRed;
    }

    public String getNavegador() {
        return navegador;
    }

    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getIpAnonima() {
        return ipAnonima;
    }

    public void setIpAnonima(String ipAnonima) {
        this.ipAnonima = ipAnonima;
    }
}
