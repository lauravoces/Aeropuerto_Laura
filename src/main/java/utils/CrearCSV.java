/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import dto.Aeropuerto;
import dto.CompanyaAerea;
import dto.VueloBase;
import dto.VueloDiario;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author laura
 */
public class CrearCSV {
    private static final String DATE_FORMAT = "yyyy-MM-dd";


    public static void writeAeropuertoCSV(String ruta, HashMap<String, Aeropuerto> aeropuertoHashMap) {
        try {
            Files.createDirectories(Path.of(ruta).getParent());
            if (!Files.exists(Path.of(ruta))) {
                Files.createFile(Path.of(ruta));
            }

            for (HashMap.Entry<String, Aeropuerto> entry : aeropuertoHashMap.entrySet()) {
                Aeropuerto aeropuerto = entry.getValue();
                String linea = String.format("%s;%s;%s\n", aeropuerto.getCodigoIATA(), aeropuerto.getNombre(), aeropuerto.getCodigoMunicipio());
                Files.writeString(Path.of(ruta), linea, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo CSV de aeropuertos", e);
        }
    }

    public static void writeCompanyaCSV(String ruta, HashMap<String, CompanyaAerea> companyaHashMap) {
        try {
            Files.createDirectories(Path.of(ruta).getParent());
            if (!Files.exists(Path.of(ruta))) {
                Files.createFile(Path.of(ruta));
            }

            for (HashMap.Entry<String, CompanyaAerea> entry : companyaHashMap.entrySet()) {
                CompanyaAerea companyaAerea = entry.getValue();
                String linea = String.format("%d;%s;%s;%s;%s;%s;%s\n",
                        companyaAerea.getPrefijo(), companyaAerea.getCodigo(), companyaAerea.getNombre(),
                        companyaAerea.getDireccion(), companyaAerea.getMunicipio(),
                        companyaAerea.getNumInfoPasajero(), companyaAerea.getNumInfoAeropuerto());
                Files.writeString(Path.of(ruta), linea, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo CSV de compañías aéreas", e);
        }
    }
    
    
public static void writeVueloBaseCSV(String ruta, HashMap<String, VueloBase> vueloBaseHashMap) {
    try {
        Files.createDirectories(Path.of(ruta).getParent());
        if (!Files.exists(Path.of(ruta))) {
            Files.createFile(Path.of(ruta));
        }

        // Open the file once before the loop
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(ruta), StandardOpenOption.APPEND)) {
            int totalVuelos = vueloBaseHashMap.size();
            int vueloCounter = 0;

            for (HashMap.Entry<String, VueloBase> entry : vueloBaseHashMap.entrySet()) {
                VueloBase vueloBase = entry.getValue();
                String horaSalidaStr = new SimpleDateFormat("HH:mm").format(vueloBase.getHoraOficialSalida());
                String horaLlegadaStr = new SimpleDateFormat("HH:mm").format(vueloBase.getHoraOficialLlegada());

                String linea = String.format("%s;%s;%s;%d;%s;%s;%s%s\n",
                        vueloBase.getCodigoVuelo(), vueloBase.getAeropuertoOrigen(),
                        vueloBase.getAeropuertoDestino(), vueloBase.getNumPlazas(), horaSalidaStr,
                        horaLlegadaStr, vueloBase.getDiasOpera(),
                        (vueloCounter++ < totalVuelos - 1) ? "\n" : "");
      
                writer.write(linea);
               
            }
        }
    } catch (IOException e) {
        throw new RuntimeException("Error al escribir en el archivo CSV de vuelos base", e);
    }
}
    
public static void writeVueloDiarioCSV(String ruta, HashMap<String, VueloDiario> vueloDiarioHashMap) {
    try {
        Files.createDirectories(Path.of(ruta).getParent());
        if (!Files.exists(Path.of(ruta))) {
            Files.createFile(Path.of(ruta));
        }
        
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(ruta), StandardOpenOption.APPEND)) {
            int totalVuelos = vueloDiarioHashMap.size();
            int vueloCounter = 0;

            for (HashMap.Entry<String, VueloDiario> entry : vueloDiarioHashMap.entrySet()) {
                VueloDiario vueloDiario = entry.getValue();
                String horaSalidaStr = new SimpleDateFormat("HH:mm").format(vueloDiario.getHoraSalidaReal());
                String horaLlegadaStr = new SimpleDateFormat("HH:mm").format(vueloDiario.getHoraLlegadaReal());
                String fechaStr = new SimpleDateFormat("yyyy-MM-dd").format(vueloDiario.getFechaVuelo());

                String linea = String.format("%s;%s;%s;%.1f;%s;%s;%s\n",
                        vueloDiario.getCodigoVueloBase(), fechaStr,
                        vueloDiario.getNumPlazasOcupadas(), vueloDiario.getPrecioVuelo(),
                        horaSalidaStr, horaLlegadaStr, 
                        (vueloCounter++ < totalVuelos - 1) ? "\n" : "");
                writer.write(linea);
            }
        }
    } catch (IOException e) {
        throw new RuntimeException("Error al escribir en el archivo CSV de vuelos diarios", e);
    }
}


}
