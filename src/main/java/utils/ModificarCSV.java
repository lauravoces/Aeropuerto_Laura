/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author laura
 */
public class ModificarCSV {
    
    public static void modificarLineaCSV(String ruta, String codigoAModificar, String nuevoContenido) {
        try {
            List<String> lineas = Files.readAllLines(Path.of(ruta));

            // Crear una nueva lista para almacenar las líneas modificadas
            List<String> nuevasLineas = lineas.stream()
                    .map(linea -> {
                        // Dividir la línea en campos usando el delimitador ";"
                        String[] campos = linea.split(";");
                        // Verificar si el código coincide con el código a modificar
                        if (campos[1].equals(codigoAModificar)) {
                            // Modificar la línea con el nuevo contenido
                            return nuevoContenido;
                        } else {
                            // Mantener la línea sin cambios
                            return linea;
                        }
                    })
                    .toList();

            // Escribir las líneas actualizadas al archivo
            Files.write(Path.of(ruta), nuevasLineas);
        } catch (IOException e) {
            throw new RuntimeException("Error al modificar la línea del archivo CSV", e);
        }
    }
}
