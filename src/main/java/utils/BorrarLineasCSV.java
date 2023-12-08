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
public class BorrarLineasCSV {
     public static void borrarLineaCSV(String ruta, String codigoAEliminar) {
        try {
            List<String> lineas = Files.readAllLines(Path.of(ruta));

            // Crear una nueva lista para almacenar las líneas sin la línea a eliminar
            List<String> nuevasLineas = lineas.stream()
                    .filter(linea -> {
                        // Dividir la línea en campos usando el delimitador ";"
                        String[] campos = linea.split(";");
                        // Verificar si el código coincide con el código a eliminar
                        return !campos[1].equals(codigoAEliminar);
                    })
                    .toList();

            // Escribir las líneas actualizadas al archivo
            Files.write(Path.of(ruta), nuevasLineas);
        } catch (IOException e) {
            throw new RuntimeException("Error al borrar la línea del archivo CSV", e);
        }
    }
}
