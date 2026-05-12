package com.prismastereo.dao;

import com.prismastereo.util.Conexion;
import java.sql.*;

public class PedidoDAO {

    // 1. Cambia la firma del método para recibir el programa
public void insertar(String nombre, String mensaje, String cancion, String programaId) throws Exception {
    Connection con = Conexion.conectar();
    
    // 2. Cambiamos el '1' por un '?' en el SQL
    String sql = "INSERT INTO peticiones (nombre_oyente, mensaje, cancion_pedida, fecha_envio, fk_programa) VALUES (?, ?, ?, NOW(), ?)";
    
    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, nombre);
        ps.setString(2, mensaje);
        ps.setString(3, cancion);
        // 3. Enviamos el ID del programa a la cuarta posición (fk_programa)
        ps.setInt(4, Integer.parseInt(programaId)); 
        
        ps.executeUpdate();
    } finally {
        if (con != null) con.close();
    }
}
}