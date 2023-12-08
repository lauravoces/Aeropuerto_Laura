/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import dto.Aeropuerto;
import dto.CompanyaAerea;
import dto.VueloDiario;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.HashMap;

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

    public static void writeVueloDiarioCSV(String ruta, HashMap<String, VueloDiario> vueloDiarioHashMap) {
        try {
            Files.createDirectories(Path.of(ruta).getParent());
            if (!Files.exists(Path.of(ruta))) {
                Files.createFile(Path.of(ruta));
            }

            for (HashMap.Entry<String, VueloDiario> entry : vueloDiarioHashMap.entrySet()) {
                VueloDiario vueloDiario = entry.getValue();
                String dateStr = new SimpleDateFormat(DATE_FORMAT).format(vueloDiario.getFechaVuelo());
                String horaSalidaStr = new SimpleDateFormat("HH:mm:ss").format(vueloDiario.getHoraSalidaReal());
                String horaLlegadaStr = new SimpleDateFormat("HH:mm:ss").format(vueloDiario.getHoraLlegadaReal());

                String linea = String.format("%d;%s;%s;%s;%s;%d;%f\n",
                        vueloDiario.getCodigoVueloBase(), dateStr, horaSalidaStr, horaLlegadaStr,
                        vueloDiario.getNumPlazasOcupadas(), vueloDiario.getPrecioVuelo());
                Files.writeString(Path.of(ruta), linea, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo CSV de vuelos diarios", e);
        }
    }
}
