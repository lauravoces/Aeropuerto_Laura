/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import dto.Aeropuerto;
import dto.CompanyaAerea;
import dto.VueloBase;
import dto.VueloDiario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import utils.CSV.LectorCSV;

/**
 *
 * @author laura
 */
public class Inicializaciones {

    
    //INSTANCIAS DE LOS HASHMAPS. (Referenciados luego como HM)
    private static final Inicializaciones INSTANCIA = new Inicializaciones();
    private static HashMap<String, Aeropuerto> aeropuertoHashMap = new HashMap<>();
    private static HashMap<String, CompanyaAerea> companyaHashMap = new HashMap<>();
    private static HashMap<String, VueloBase> vueloBaseHashMap = new HashMap<>();
    private static HashMap<String, VueloDiario> vueloDiarioHashMap = new HashMap<>();
    private static HashMap<String, String> municipiosHashMap = new HashMap<>();

    /**
     * lista de Aeropuertos
     */
    protected static List<Aeropuerto> lstAeropuertos;

    /**
     * lista de Compañias Aereas
     */
    protected static List<CompanyaAerea> lstCompanya;

    /**
     * lista de Vuelos Base
     */
    protected static List<VueloBase> lstVueloBase;

    /**
     * lista de Vuelos Diarios
     */
    protected static List<VueloDiario> lstVueloDiario;

    /**
     * lista de municipios.
     */
    protected static List<String> lstMunicipio;

    private Inicializaciones() {
        init();
    }

    private void init() {
        //Creo un objeto que me lea los CSV.
        LectorCSV miLectorCSV = new LectorCSV();
        //Leo mis HM para obtener los valores
        municipiosHashMap = miLectorCSV.readMunicipiosCSV();
        aeropuertoHashMap = miLectorCSV.readAeropuertoCsv();
        vueloBaseHashMap = miLectorCSV.readVueloBaseCSV();
        vueloDiarioHashMap = miLectorCSV.readVueloDiarioCsv();
        companyaHashMap = miLectorCSV.readCompanyaCsv();
        //Cargo todo eso en mis ArrayList que serán usandos en Lógica
        lstAeropuertos = new ArrayList<>(aeropuertoHashMap.values());
        lstMunicipio = new ArrayList<>(municipiosHashMap.values());
        lstCompanya = new ArrayList<>(companyaHashMap.values());
        lstVueloBase = new ArrayList<>(vueloBaseHashMap.values());
        lstVueloDiario = new ArrayList<>(vueloDiarioHashMap.values());

    }

    /**
     * Metodo para obtener la instancia
     * @return
     */
    public static Inicializaciones getInstance() {
        return INSTANCIA;
    }

    /**
     * Devuelve directamente la lista cargada
     * @return
     */
    public List<Aeropuerto> getLstAeropuertos() {
        return lstAeropuertos;  
    }

    /**
     * Devuelve directamente la lista cargada
     * @return
     */
    public List<CompanyaAerea> getLstCompanya() {
        return lstCompanya;
    }

    /**
     * Devuelve directamente la lista cargada
     * @return
     */
    public List<VueloBase> getListVueloBase() {
        return lstVueloBase;
    }

    /**
     * Devuelve directamente la lista cargada
     * @return
     */
    public List<VueloDiario> getListVueloDiario() {
        return lstVueloDiario;
    }

    /**
     * Devuelve directamente la lista cargada
     * @return
     */
    public List<String> getListMunicipio() {
        return lstMunicipio;
    }
}
