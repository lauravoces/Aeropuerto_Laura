/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import dto.Aeropuerto;
import dto.CompanyaAerea;
import dto.VueloBase;
import dto.VueloDiario;
import java.util.HashMap;
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


    private Inicializaciones() {
        init();
    }

    private void init() {
        LectorCSV csvReader = new LectorCSV();
        municipiosHashMap = csvReader.readMunicipiosCSV();
    }


    protected static Inicializaciones getInstance() {
        return INSTANCE;
    }
}
