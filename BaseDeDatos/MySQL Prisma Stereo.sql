SELECT 
    p.id_peticion, 
    p.nombre_oyente, 
    p.mensaje, 
    p.cancion_pedida, 
    p.fecha_envio, 
    pr.nombre_franja -- <--- El nombre real de tu columna
FROM prisma_stereo_db.peticiones p
INNER JOIN prisma_stereo_db.programacion pr ON p.fk_programa = pr.id_programa;