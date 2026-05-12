package com.prismastereo.model;

/**
 * CLASE DTO - DATA TRANSFER OBJECT
 * Propósito: Transportar las credenciales de usuario para el inicio de sesión.
 * Requerimiento: GA7-220501096-AA5-EV01
 */
public class LoginDTO {
    
    // Atributos privados para seguridad (Encapsulamiento)
    private String usuario;
    private String contrasena;

    // Constructor vacío (Necesario para que Spring Boot procese el JSON)
    public LoginDTO() {
    }

    // Métodos Getter y Setter (Permiten el acceso a los datos)
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
