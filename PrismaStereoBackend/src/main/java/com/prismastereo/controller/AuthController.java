package com.prismastereo.controller;

import com.prismastereo.model.LoginDTO;

/**
 * SERVICIO WEB PARA REGISTRO E INICIO DE SESIÓN
  */
public class AuthController {

    /**
     * Método que simula el servicio web de autenticación.
     * Recibe un objeto LoginDTO y devuelve el mensaje según el resultado.
     */
    public String autenticarUsuario(LoginDTO datos) {
        
        // Datos de prueba para la validación
        String usuarioCorrecto = "admin";
        String claveCorrecta = "admin";

        // Validación de credenciales según el caso de estudio
        if (usuarioCorrecto.equals(datos.getUsuario()) && claveCorrecta.equals(datos.getContrasena())) {
            // Mensaje requerido por la guía: Autenticación satisfactoria
            return "Autenticación satisfactoria";
        } else {
            // Mensaje requerido por la guía: Error en la autenticación
            return "Error en la autenticación";
        }
    }
}