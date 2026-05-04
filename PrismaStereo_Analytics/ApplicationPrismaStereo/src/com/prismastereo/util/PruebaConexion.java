package com.prismastereo.util;

import com.prismastereo.dao.VisitaDAO;
import com.prismastereo.model.Visita;

public class PruebaConexion {

    public static void main(String[] args) {
        // 1. Creamos el objeto Visita con datos de prueba
        // fkRed = 1 (Facebook), Navegador, Dispositivo, IP
        Visita nuevaVisita = new Visita(1, "Chrome Mobile", "Smartphone Android", "192.168.1.1");

        // 2. Instanciamos el DAO para realizar la operación
        VisitaDAO dao = new VisitaDAO();

        // 3. Intentamos registrar en la base de datos
        System.out.println("Iniciando prueba de inserción para Prisma Stereo...");
        
        if (dao.registrarVisita(nuevaVisita)) {
            System.out.println("==========================================");
            System.out.println("¡ÉXITO! La visita se registró correctamente.");
            System.out.println("Ya puedes ver el dato en MySQL Workbench.");
            System.out.println("==========================================");
        } else {
            System.err.println("ERROR: No se pudo registrar la visita.");
            System.err.println("Verifica que el servicio de MySQL esté activo.");
        }
    }
}