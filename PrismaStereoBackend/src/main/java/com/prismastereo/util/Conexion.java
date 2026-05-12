package com.prismastereo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Los datos deben coincidir con tu MySQL Workbench
    private static final String URL = "jdbc:mysql://localhost:3306/prisma_stereo_db";
    private static final String USER = "root"; 
    private static final String PASS = "Alexplapa16287582*"; 

    public static Connection conectar() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("¡Conexión Exitosa a Prisma Stereo!");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar: " + e.getMessage());
        }
        return con;
    }
}
