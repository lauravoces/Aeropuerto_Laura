/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import app.Inicializaciones;
import dto.Aeropuerto;
import dto.CompanyaAerea;
import dto.Municipio;
import dto.VueloBase;
import dto.VueloDiario;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import static utils.Archivos.PATH_MUNICIPIOS;

/**
 *
 * @author laura
 */
public class Logica {

    private static final int NUMERO_DIAS_PROXIMOS = 7;
    /*METODOS PARA AEROPUERTOS*/

    private static List<Aeropuerto> lstAeropuertos;

    //Precargar la lista con todos los aeropuertos

    /**
     *
     * @return
     */
    public static List<Aeropuerto> getAllAeropuertos() {
        // Llama al método de Inicializaciones para obtener la lista de aeropuertos
        lstAeropuertos = Inicializaciones.getInstance().getLstAeropuertos();
        return lstAeropuertos;
    }

    /**
     *
     * @param codigoIATA
     * @return
     */
    public static Aeropuerto getAeropuertoByCodigoIATA(String codigoIATA) {
        lstAeropuertos = Inicializaciones.getInstance().getLstAeropuertos();
        Aeropuerto valorSalida = null;

        for (Aeropuerto a : lstAeropuertos) {
            if (a.getCodigoIATA().equals(codigoIATA)) {
                valorSalida = a;
                return valorSalida;
            }
        }
        return valorSalida;
    }

    /**
     *
     */
    public static Aeropuerto aeropuertoBase = getAeropuertoByCodigoIATA("OVD");

    /*METODOS PARA LAS COMPAÑIAS*/
    private static List<CompanyaAerea> lstCompanyas = new ArrayList<CompanyaAerea>();

    //Precargar la lista con todas las companyas

    /**
     *
     * @return
     */
    public static List<CompanyaAerea> getAllCompanyas() {
        lstCompanyas = Inicializaciones.getInstance().getLstCompanya();
        return lstCompanyas;
    }

    /**
     *
     * @param codigo
     * @return
     */
    public static CompanyaAerea getCompanyaByCodigo(String codigo) {

        CompanyaAerea valorSalida = null;
        lstCompanyas = Inicializaciones.getInstance().getLstCompanya();
        for (CompanyaAerea a : lstCompanyas) {
            if (a.getCodigo().equals(codigo)) {
                valorSalida = a;
                return valorSalida;

            }
        }
        return valorSalida;
    }

    /**
     *
     * @param prefijo
     * @return
     */
    public static CompanyaAerea getCompanyaByPrefijo(int prefijo) {
        CompanyaAerea valorSalida = null;
        lstCompanyas = Inicializaciones.getInstance().getLstCompanya();
        for (CompanyaAerea a : lstCompanyas) {
            if (a.getPrefijo() == prefijo) {
                valorSalida = a;
                return valorSalida;
            }
        }
        return valorSalida;

    }

    //logica de vuelo base
    private static List<VueloBase> lstVuelosBase = new ArrayList<VueloBase>();

    /**
     *
     * @return
     */
    public static List<VueloBase> getAllVuelosBase() {
        lstVuelosBase = Inicializaciones.getInstance().getListVueloBase();

        return lstVuelosBase;
    }

    /**
     *
     * @param codigo
     * @return
     */
    public static VueloBase getVueloBaseByCodigo(String codigo) {
        VueloBase vueloBaseSalida = null;
        for (VueloBase vb : lstVuelosBase) {
            if (vb.getCodigoVuelo().equals(codigo)) {
                return vueloBaseSalida;
            }
        }
        return vueloBaseSalida;
    }

    /**
     *
     * @param codigoIATA
     * @return
     */
    public static VueloBase getVueloBaseByAeropuertoOrigen(String codigoIATA) {

        return new VueloBase();
    }

    /**
     *
     * @param codigoIATA
     * @return
     */
    public static VueloBase getVueloBaseByAeropuertoDestino(String codigoIATA) {
        return new VueloBase();
    }

    //Logica Vuelod Diarios
    private static List<VueloDiario> lstVuelosDiario = new ArrayList<VueloDiario>();
    private static List<VueloDiario> lstVuelosLegada = new ArrayList<VueloDiario>();
    private static List<VueloDiario> lstVuelosProximos = new ArrayList<VueloDiario>();
    private static List<VueloBase> lstVueloCompanyaFecha = new ArrayList<VueloBase>();

    /**
     *
     * @return
     */
    public static List<VueloDiario> getAllVuelosDiarios() {
        lstVuelosDiario = Inicializaciones.getInstance().getListVueloDiario();
        return lstVuelosDiario;
    }

    /**
     *
     * @param codigo
     * @return
     */
    public static VueloDiario getVueloDiarioByCodigoVueloBase(String codigo) {
        VueloDiario valorSalida = null;
        lstVuelosDiario = Inicializaciones.getInstance().getListVueloDiario();
        for (VueloDiario a : lstVuelosDiario) {
            if (a.getCodigoVueloBase().equals(codigo)) {
                valorSalida = a;
                return valorSalida;
            }
        }

        return valorSalida;
    }

    /**
     *
     * @param fecha
     * @return
     */
    public List<VueloDiario> obtenerLlegadas(LocalDate fecha) {
        LocalDate hoy = LocalDate.now();

        lstVuelosLegada = Inicializaciones.getInstance().getListVueloDiario()
                .stream()
                .filter(vuelo -> vuelo.getFechaVuelo().equals(fecha) && !vuelo.getFechaVuelo().isBefore(hoy))
                .sorted(Comparator.comparing(VueloDiario::getFechaVuelo))
                .collect(Collectors.toList());

        return lstVuelosLegada;
    }

    /**
     *
     * @param fecha
     * @return
     */
    public List<VueloDiario> obtenerLlegadas2(LocalDate fecha) {
        LocalDateTime hoy = LocalDate.now().atStartOfDay();

        List<VueloDiario> lstVuelosLlegada = Inicializaciones.getInstance().getListVueloDiario()
                .stream()
                .filter(vueloDiario -> vueloDiario.getFechaVuelo().equals(fecha))
                .filter(vueloDiario -> Inicializaciones.getInstance().getListVueloBase().stream()
                .anyMatch(vueloBase -> vueloBase.getCodigoVuelo().equals(vueloDiario.getCodigoVueloBase()) && vueloBase.getAeropuertoDestino().contains("OVD")))
                .peek(vueloDiario -> {
                    LocalDateTime horaLlegadaReal = vueloDiario.getHoraLlegadaReal().atDate(fecha);
                    System.out.println("Debug: Fecha de vuelo: " + vueloDiario.getFechaVuelo() + ", Hora de llegada: " + horaLlegadaReal);
                })
                .filter(vueloDiario -> {
                    LocalDateTime horaLlegadaReal = vueloDiario.getHoraLlegadaReal().atDate(fecha);
                    return !horaLlegadaReal.isBefore(hoy) && !horaLlegadaReal.equals(hoy);
                })
                .sorted(Comparator.comparing(VueloDiario::getHoraLlegadaReal))
                .collect(Collectors.toList());

        return lstVuelosLlegada;
    }

    /**
     *
     * @param fecha
     * @return
     */
    public List<VueloDiario> obtenerSalidas2(LocalDate fecha) {
        LocalDateTime hoy = LocalDate.now().atStartOfDay();

        List<VueloDiario> lstVuelosS = Inicializaciones.getInstance().getListVueloDiario()
                .stream()
                .filter(vueloDiario -> vueloDiario.getFechaVuelo().equals(fecha))
                .filter(vueloDiario -> Inicializaciones.getInstance().getListVueloBase().stream()
                .anyMatch(vueloBase -> vueloBase.getCodigoVuelo().equals(vueloDiario.getCodigoVueloBase()) && "OVD".equals(vueloBase.getAeropuertoOrigen())))
                .peek(vueloDiario -> {
                    LocalDateTime horaSalidaReal = vueloDiario.getHoraSalidaReal().atDate(fecha);
                    System.out.println("Debug: Fecha de vuelo: " + vueloDiario.getFechaVuelo() + ", Hora de salida: " + horaSalidaReal);
                })
                .filter(vueloDiario -> {
                    LocalDateTime horaSalidaReal = vueloDiario.getHoraSalidaReal().atDate(fecha);
                    return !horaSalidaReal.isBefore(hoy) && !horaSalidaReal.equals(hoy);
                })
                .sorted(Comparator.comparing(VueloDiario::getHoraSalidaReal))
                .collect(Collectors.toList());

        return lstVuelosS;
    }

    /**
     *
     * @return
     */
    public List<VueloDiario> getProximosVuelos() {
        lstVuelosProximos = Inicializaciones.getInstance().getListVueloDiario();
        LocalDateTime ahora = LocalDateTime.now();

        lstVuelosProximos = lstVuelosProximos.stream()
                .filter(vuelo -> vuelo.getFechaVuelo().isAfter(LocalDate.now())
                && vuelo.getFechaVuelo().isBefore(LocalDate.now().plusDays(NUMERO_DIAS_PROXIMOS)))
                .peek(vuelo -> {
                    LocalDateTime horaSalidaReal = vuelo.getHoraSalidaReal().atDate(vuelo.getFechaVuelo());
                    System.out.println("Debug: Fecha de vuelo: " + vuelo.getFechaVuelo() + ", Hora de salida: " + horaSalidaReal);
                })
                .filter(vuelo -> {
                    LocalDateTime horaSalidaReal = vuelo.getHoraSalidaReal().atDate(vuelo.getFechaVuelo());
                    return !horaSalidaReal.isBefore(ahora) && !horaSalidaReal.equals(ahora);
                })
                .sorted(Comparator.comparing(VueloDiario::getFechaVuelo).thenComparing(VueloDiario::getHoraSalidaReal))
                .collect(Collectors.toList());

        return lstVuelosProximos;
    }

    /**
     *
     * @return
     */
    public List<VueloDiario> getProximasSalidas() {
        lstVuelosProximos = Inicializaciones.getInstance().getListVueloDiario();
        LocalDateTime ahora = LocalDateTime.now();

        lstVuelosProximos = lstVuelosProximos.stream()
                .filter(vuelo -> vuelo.getFechaVuelo().isAfter(LocalDate.now())
                && vuelo.getFechaVuelo().isBefore(LocalDate.now().plusDays(NUMERO_DIAS_PROXIMOS)))
                .peek(vuelo -> {
                    LocalDateTime horaSalidaReal = vuelo.getHoraSalidaReal().atDate(vuelo.getFechaVuelo());
                    System.out.println("Debug: Fecha de vuelo: " + vuelo.getFechaVuelo() + ", Hora de salida: " + horaSalidaReal);
                })
                .filter(vuelo -> {
                    LocalDateTime horaSalidaReal = vuelo.getHoraSalidaReal().atDate(vuelo.getFechaVuelo());
                    return !horaSalidaReal.isBefore(ahora) && !horaSalidaReal.equals(ahora);
                })
                .sorted(Comparator.comparing(VueloDiario::getFechaVuelo).thenComparing(VueloDiario::getHoraSalidaReal))
                .collect(Collectors.toList());

        return lstVuelosProximos;
    }

    private boolean codigoCompaniaValido(String compania, VueloBase vueloBase) {
        try {
            int codigoCompaniaInt = Integer.parseInt(compania);
            return vueloBase.getCodigoVuelo().equals(codigoCompaniaInt);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     *
     * @param newComp
     */
    public static void addCompanyaAerea(CompanyaAerea newComp) {
        lstCompanyas.add(newComp);
    }

    /**
     *
     * @param v
     */
    public static void addVueloBase(VueloBase v) {
        lstVuelosBase.add(v);
    }

    /**
     *
     * @param codigo
     * @param newComp
     */
    public static void updateCompanyaByCodigo(String codigo, CompanyaAerea newComp) {
        CompanyaAerea oldComp = getCompanyaByCodigo(codigo);
        oldComp.setDireccion(newComp.getDireccion());
        oldComp.setMunicipio(newComp.getMunicipio());
        oldComp.setNombre(newComp.getNombre());
        oldComp.setPrefijo(newComp.getPrefijo());
        oldComp.setNumInfoPasajero(newComp.getNumInfoPasajero());
        oldComp.setNumInfoAeropuerto(newComp.getNumInfoAeropuerto());

    }

    /**
     *
     * @param codigo
     */
    public static void deleteCompanyaByCodigo(String codigo) {
        CompanyaAerea delComp = getCompanyaByCodigo(codigo);
        lstCompanyas.remove(delComp);

    }

    /**
     *
     * @return
     */
    public static List<Municipio> getAllMunicipios() {
        List<Municipio> lstMunicipios = new ArrayList<>();

        Path filePath = Paths.get(PATH_MUNICIPIOS);

        try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(";");

                if (parts.length >= 2) {
                    String codigo = parts[0].trim();
                    String nombreMunicipio = parts[1].trim();
                    lstMunicipios.add(new Municipio(codigo, nombreMunicipio));
                } else {

                    System.err.println("Invalid format for municipio string: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lstMunicipios;
    }

    /**
     *
     * @param codigo
     * @return
     */
    public static Municipio getMunicipioByCodigo(String codigo) {

        List<Municipio> municipios = getAllMunicipios();

        for (Municipio municipio : municipios) {
            if (municipio.getCodigo().equals(codigo)) {
                return municipio;
            }
        }

        return null;
    }

    /**
     *
     * @param nombre
     * @return
     */
    public static String getCodigoByNombre(String nombre) {
        List<Municipio> municipios = getAllMunicipios();

        for (Municipio municipio : municipios) {
            if (municipio.getNombreMunicipio().equals(nombre)) {
                return municipio.getCodigo();
            }
        }

        return null;
    }
    
    /**
     *
     * @param nombre
     * @return
     */
    public static String getCodigoAeropuerto(String nombre){
         List<Aeropuerto> aeri = getAllAeropuertos();

        for (Aeropuerto a : aeri) {
            if (a.getNombre().equals(nombre)) {
                return a.getCodigoIATA();
            }
        }

        return null;
    }
    
    /**
     *
     * @param nombre
     * @return
     */
    public static String getCodigoCA(String nombre){
         List<CompanyaAerea> aeri = getAllCompanyas();

        for (CompanyaAerea a : aeri) {
            if (a.getNombre().equals(nombre)) {
                return a.getCodigo();
            }
        }

        return null;
    }

    /**
     *
     * @param nombre
     * @return
     */
    public static String getMuniAeropuerto(String nombre){
         List<Aeropuerto> aeri = getAllAeropuertos();

        for (Aeropuerto a : aeri) {
            if (a.getNombre().equals(nombre)) {
                return a.getCodigoMunicipio();
            }
        }

        return null;
    }
    
    /**
     *
     * @param codigoIATA
     * @return
     */
    public static boolean tieneVuelosDiariosAsociados(String codigoIATA) {
        lstVuelosDiario = Inicializaciones.getInstance().getListVueloDiario();

        // Verifica si hay vuelos diarios asociados al aeropuerto de origen o destino
        return lstVuelosDiario.stream()
                .anyMatch(vuelo -> vuelo.getCodigoVueloBase().equals(codigoIATA) || vuelo.getCodigoVueloDiario().equals(codigoIATA));
    }
}
