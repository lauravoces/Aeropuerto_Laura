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
import utils.LectorCSV;

/**
 *
 * @author laura
 */
public class Inicializaciones {
    
    private static final Inicializaciones INSTANCE = new Inicializaciones();
    private static HashMap<String, Aeropuerto> aeropuertoHashMap = new HashMap<>();
    private static HashMap<String, CompanyaAerea> companyaHashMap = new HashMap<>();
    private static HashMap<String, VueloBase> vueloBaseHashMap = new HashMap<>();
    private static HashMap<String, VueloDiario> vueloDiarioHashMap = new HashMap<>();
    private static HashMap<String, String> municipiosHashMap = new HashMap<>();

    protected static List<Aeropuerto> lstAeropuertos;   
    protected static List<CompanyaAerea> lstCompanya;
    protected static List<VueloBase>lstVueloBase;
    private Inicializaciones() {
        init();
    }

    private void init() {
        //CREO EL OBJ para leer
        LectorCSV csvReader = new LectorCSV();
        
        municipiosHashMap = csvReader.readMunicipiosCSV();
        
        aeropuertoHashMap= csvReader.readAeropuertoCsv();
        
        vueloBaseHashMap= csvReader.readVueloBaseCSV();
        companyaHashMap= csvReader.readCompanyaCsv();
        
        lstAeropuertos = new ArrayList<>(aeropuertoHashMap.values());
        lstCompanya= new ArrayList<>(companyaHashMap.values());
        lstVueloBase=new ArrayList<>(vueloBaseHashMap.values());
        
    }


    public static Inicializaciones getInstance() {
        return INSTANCE;
    }
     public List<Aeropuerto> getLstAeropuertos() {
        return lstAeropuertos;  // Devuelve directamente la lista cargada
    }
    public List<CompanyaAerea> getLstCompanya() {
        return lstCompanya;
    }
    public List<VueloBase> getListVueloBase(){
        return lstVueloBase;
    }
    
 }
