package com.prismastereo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;
import com.prismastereo.dao.PedidoDAO;

@CrossOrigin(origins = "*") // Esto abre la puerta a las peticiones de React
@RestController
@RequestMapping("/radio/api")
public class PedidoController {

  @PostMapping
public String recibirPedido(@RequestBody Map<String, String> datos) {
    System.err.println("¡PEDIDO RECIBIDO EN PRISMA STEREO!");

    // 1. Capturamos los datos que vienen de App.jsx
    String nombre = datos.get("oyente");
    String mensaje = datos.get("mensaje");
    String cancion = datos.get("cancion_pedida");
    String programaId = datos.get("programa"); 

    try {
        // 2. CREAMOS EL DAO (Debe ir aquí para que no salga error rojo)
        PedidoDAO dao = new PedidoDAO();
        
        // 3. Llamamos al método con los 4 parámetros
        dao.insertar(nombre, mensaje, cancion, programaId);
        
        System.err.println("Datos guardados en la BD correctamente.");
    } catch (Exception e) {
        System.err.println("Error al guardar: " + e.getMessage());
        return "{\"status\": \"error\", \"mensaje\": \"Error en base de datos\"}";
    }

    return "{\"status\": \"ok\", \"mensaje\": \"Pedido recibido y guardado\"}";
}

    @GetMapping
    public String prueba() {
        return "Conexión exitosa con el Backend de Prisma Stereo";
    }
}