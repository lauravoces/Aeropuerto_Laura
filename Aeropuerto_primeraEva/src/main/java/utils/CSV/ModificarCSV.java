/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils.CSV;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author laura
 */
public class ModificarCSV {
    
    /**
     *
     * @param ruta
     * @param codigoAModificar
     * @param nuevoContenido
     */
    public static void modificarLineaCSV(String ruta, String codigoAModificar, String nuevoContenido) {
        try {
            List<String> lineas = Files.readAllLines(Path.of(ruta));
          
            List<String> nuevasLineas = lineas.stream()
                    .map(linea -> {
                        // Dividir usando el delimitador ";"
                        String[] campos = linea.split(";");                       
                        if (campos[1].equals(codigoAModificar)) {                           
                            return nuevoContenido;
                        } else {
                            //sin cambios
                            return linea;
                        }
                    })
                    .toList();
            //Escribir las líneas actualizadas al archivo
            Files.write(Path.of(ruta), nuevasLineas);
        } catch (IOException e) {
            throw new RuntimeException("Error al modificar la línea del archivo CSV", e);
        }
    }
}
