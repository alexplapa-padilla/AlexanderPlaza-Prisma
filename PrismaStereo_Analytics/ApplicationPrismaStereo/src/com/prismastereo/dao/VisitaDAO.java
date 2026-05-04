package com.prismastereo.dao;

import com.prismastereo.model.Visita;
import com.prismastereo.util.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase DAO para gestionar la persistencia de visitas de la emisora.
 * Cumple con el requerimiento de inserción de datos (CRUD).
 */
public class VisitaDAO {

    // SQL para insertar la visita con los nuevos campos de analítica
    private final String SQL_INSERT = "INSERT INTO visitas_oyentes (fk_red, navegador, dispositivo, ip_anonima) VALUES (?, ?, ?, ?)";

    public boolean registrarVisita(Visita visita) {
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            con = Conexion.conectar(); // Llama a tu clase de conexión
            ps = con.prepareStatement(SQL_INSERT);
            
            // Mapeo de parámetros según el modelo de Prisma Stereo
            ps.setInt(1, visita.getFkRed());
            ps.setString(2, visita.getNavegador());
            ps.setString(3, visita.getDispositivo());
            ps.setString(4, visita.getIpAnonima());
            
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0; // Retorna true si se guardó correctamente
            
        } catch (SQLException e) {
            System.err.println("Error al registrar visita en BD: " + e.getMessage());
            return false;
        } finally {
            // Cierre seguro de recursos para evitar fugas de memoria
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                System.err.println("Error al cerrar recursos: " + ex.getMessage());
            }
        }
    }
}