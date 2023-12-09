/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import dto.Aeropuerto;
import dto.CompanyaAerea;
import dto.VueloBase;
import dto.VueloDiario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import static utils.Archivos.PATH_MUNICIPIOS;
import static utils.Archivos.PATH_COMPANYAAEREA;
import static utils.Archivos.PATH_AEROPUERTO;
import static utils.Archivos.PATH_VUELODIARIO;
import static utils.Archivos.PATH_VUELOSBASE;

/**
 * Son todo lecturas desde archivo, no escrituras.
 * @author laura
 * @param <T>
 */
public class LectorCSV<T> {
    
    
    public HashMap<String, String> readMunicipiosCSV() {
        HashMap<String, String> municipiosHashMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(PATH_MUNICIPIOS))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (datos.length == 2) {
                    municipiosHashMap.put(datos[0], datos[1]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo de municipios", e);
        }
        return municipiosHashMap;
    }

   public HashMap<String, Aeropuerto> readAeropuertoCsv() {
        HashMap<String, Aeropuerto> aeropuertoHashMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(PATH_AEROPUERTO))) {
            br.lines()
                .map(linea -> linea.split(";"))
                .filter(valores -> valores.length == 3)
                .forEach(valores -> aeropuertoHashMap.put(valores[0], new Aeropuerto(valores[0], valores[1], valores[2])));
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo de aeropuertos", e);
        }

        return aeropuertoHashMap;
    }

   public HashMap<String, CompanyaAerea> readCompanyaCsv() {
        HashMap<String, CompanyaAerea> companyaHashMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(PATH_COMPANYAAEREA))) {
            br.lines()
                .map(linea -> linea.split(";"))
                .filter(valores -> valores.length == 7)
                .forEach(valores -> companyaHashMap.put(valores[0], new CompanyaAerea(
                    Integer.parseInt(valores[0]),    
                    valores[1],
                    valores[2],
                    valores[3],
                    valores[4],
                    valores[5],
                    valores[6]
                )));
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo de compañías aéreas", e);
        }

        return companyaHashMap;
    }

    private static final String DATE_FORMAT = "yyyy-MM-dd";

 public HashMap<String, VueloDiario> readVueloDiarioCsv() {
    HashMap<String, VueloDiario> vueloDiarioHashMap = new HashMap<>();

    try (BufferedReader br = new BufferedReader(new FileReader(PATH_VUELODIARIO))) {
        String linea;

        while ((linea = br.readLine()) != null) {
            String[] valores = linea.split(";");
            if (valores.length == 7) {
                try {
                    Date date = new SimpleDateFormat(DATE_FORMAT).parse(valores[1]);
                    Date horaSalida = new SimpleDateFormat("HH:mm:ss").parse(valores[4]);
                    Date horaLlegada = new SimpleDateFormat("HH:mm:ss").parse(valores[5]);

                    VueloDiario vueloDiario = new VueloDiario(
                            valores[0],
                            date,
                            horaSalida,
                            horaLlegada,
                            Integer.parseInt(valores[2]),
                            Float.parseFloat(valores[3])
                    );

                    vueloDiarioHashMap.put(valores[0], vueloDiario);
                } catch (ParseException e) {
                    throw new RuntimeException("Error al parsear la fecha en el archivo de vuelos diarios: " + e.getMessage(), e);
                }
            }
        }
    } catch (IOException e) {
        throw new RuntimeException("Error al leer el archivo de vuelos diarios", e);
    }
    return vueloDiarioHashMap;
}
   public HashMap<String, VueloBase> readVueloBaseCSV() {
        HashMap<String, VueloBase> vueloBaseHashMap = new HashMap<>();

        try {
            List<String> lineas = Files.readAllLines(Path.of(PATH_VUELOSBASE));

            for (String linea : lineas) {
                String[] campos = linea.split(";");
                if (campos.length == 8) {
                    String codigoVuelo = campos[0];
                    String aeropuertoOrigen = campos[1];
                    String aeropuertoDestino = campos[2];
                    int numPlazas = Integer.parseInt(campos[3]);
                    String horaSalidaStr = campos[4];
                    String horaLlegadaStr = campos[5];
                    String diasOpera = campos[6];

                    SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
                    Date horaSalida = formatoHora.parse(horaSalidaStr);
                    Date horaLlegada = formatoHora.parse(horaLlegadaStr);

                    VueloBase vueloBase = new VueloBase(codigoVuelo, aeropuertoOrigen, aeropuertoDestino,
                            numPlazas, horaSalida, horaLlegada, diasOpera);

                    vueloBaseHashMap.put(codigoVuelo, vueloBase);
                } else {
                    // Manejar el formato incorrecto de la línea del CSV
                    System.out.println("Formato incorrecto en línea del CSV: " + linea);
                }
            }
        } catch (IOException | ParseException e) {
            throw new RuntimeException("Error al leer el archivo CSV de vuelos base", e);
        }

        return vueloBaseHashMap;
    }

}
