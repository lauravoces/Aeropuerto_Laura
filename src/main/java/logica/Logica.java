/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import app.Inicializaciones;
import dto.Aeropuerto;
import dto.CompanyaAerea;
import dto.VueloBase;
import dto.VueloDiario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author laura
 */
public class Logica {
    
/*METODOS PARA AEROPUERTOS*/
    
  private static List<Aeropuerto> lstAeropuertos;

  //Precargar la lista con todos los aeropuertos
    public static List<Aeropuerto> getAllAeropuertos() {
        // Llama al método de Inicializaciones para obtener la lista de aeropuertos
        lstAeropuertos = Inicializaciones.getInstance().getLstAeropuertos();
        return lstAeropuertos;
    }

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

    public static Aeropuerto aeropuertoBase = getAeropuertoByCodigoIATA("OVD");

    
    /*METODOS PARA LAS COMPAÑIAS*/
    private static List<CompanyaAerea> lstCompanyas = new ArrayList<CompanyaAerea>();

    public static List<CompanyaAerea> getAllCompanyas() {
        return new ArrayList<CompanyaAerea>();
    }

    public static CompanyaAerea getCompanyaByCodigo(String codigo) {
        CompanyaAerea valorSalida = null;

        return new CompanyaAerea();
    }

    public static CompanyaAerea getCompanyaByPrefijo(int prefijo) {
        CompanyaAerea valorSalida = null;
        for (CompanyaAerea c : lstCompanyas) {

            if (c.getPrefijo() == prefijo) {
                valorSalida = c;
                return valorSalida;
            }
        }
        return valorSalida;

    }

    //logica de vuelo base
    private static List<VueloBase> lstVuelosBase = new ArrayList<VueloBase>();

    public static List<VueloBase> getAllVuelosBase() {
        return new ArrayList<VueloBase>();
    }

    public static VueloBase getVueloBaseByCodigo(String codigo) {
        VueloBase vueloBaseSalida = null;
        for (VueloBase vb : lstVuelosBase) {
            if (vb.getCodigoVuelo().equals(codigo)) {
                return vueloBaseSalida;
            }
        }
        return vueloBaseSalida;
    }

    /*
     public static VueloBase getVueloBaseByDiaSemana(char diaSemana){
         List<VueloBase> VueloBaseByDiaSemana= lstVuelosBase.stream()
                 .filter(v-> v.getDiasOperacion().matches(diaSemana))
                 .toList();
    return new VueloBase();
    }
     */
    public static VueloBase getVueloBaseByAeropuertoOrigen(String codigoIATA) {

        return new VueloBase();
    }

    public static VueloBase getVueloBaseByAeropuertoDestino(String codigoIATA) {
        return new VueloBase();
    }

    //logica vuelos diarios
    private static List<VueloDiario> lstVuelosDiario = new ArrayList<VueloDiario>();

    public static List<VueloDiario> getAllVuelosDiarios() {
        return new ArrayList<VueloDiario>();
    }

    public static VueloDiario getVueloDiarioByCodigoVueloBase(String codigo) {
        return new VueloDiario();
    }

    public static void addCompanyaAerea(CompanyaAerea newComp) {
        lstCompanyas.add(newComp);
    }

    public static void addVueloBase(VueloBase v) {
        lstVuelosBase.add(v);
    }

    public static void updateCompanyaByCodigo(String codigo, CompanyaAerea newComp) {
        CompanyaAerea oldComp = getCompanyaByCodigo(codigo);
        oldComp.setDireccion(newComp.getDireccion());
        oldComp.setMunicipio(newComp.getMunicipio());
        oldComp.setNombre(newComp.getNombre());
        oldComp.setPrefijo(newComp.getPrefijo());
        oldComp.setNumInfoPasajero(newComp.getNumInfoPasajero());
        oldComp.setNumInfoAeropuerto(newComp.getNumInfoAeropuerto());

        //Optional<CompanyaAerea> optValorSalida = new Optional<CompanyaAerea>();
    }

    public static void deleteCompanyaByCodigo(String codigo) {
        CompanyaAerea delComp = getCompanyaByCodigo(codigo);
        lstCompanyas.remove(delComp);

    }
}
