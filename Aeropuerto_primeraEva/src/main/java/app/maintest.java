/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import static app.Inicializaciones.lstMunicipio;
import dto.Municipio;
import dto.VueloDiario;
import java.time.LocalDate;
import java.util.List;
import logica.Logica;

/**
 *
 * @author laura
 */
public class maintest {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
Logica logica = new Logica();

        // Llama al método getAllMunicipios
        List<Municipio> municipios = logica.getAllMunicipios();

        // Ahora puedes imprimir los municipios para verificar el resultado
        for (Municipio municipio : municipios) {
            System.out.println("Código: " + municipio.getCodigo() + ", Nombre: " + municipio.getNombreMunicipio());
        }
    }
    
  
}