package com.prismastereo.util;

import com.prismastereo.controller.AuthController;
import com.prismastereo.model.LoginDTO;

/**
 * CLASE DE PRUEBA PARA EL SERVICIO DE AUTENTICACIÓN
 * Evidencia: GA7-220501096-AA5-EV01
 */
public class PruebaAutenticacion {
    public static void main(String[] args) {
        // 1. Instanciar el controlador y el DTO
        AuthController auth = new AuthController();
        LoginDTO datos = new LoginDTO();
        
        System.out.println("=== PRUEBA DE SERVICIO WEB DE AUTENTICACIÓN ===");

        // 2. PRUEBA 1: Autenticación Correcta
        datos.setUsuario("admin");
        datos.setContrasena("12345");
        String resultado1 = auth.autenticarUsuario(datos);
        System.out.println("Prueba con datos correctos: " + resultado1);

        // 3. PRUEBA 2: Autenticación Incorrecta
        datos.setUsuario("usuario_error");
        datos.setContrasena("0000");
        String resultado2 = auth.autenticarUsuario(datos);
        System.out.println("Prueba con datos incorrectos: " + resultado2);
        
        System.out.println("==============================================");
    }
}