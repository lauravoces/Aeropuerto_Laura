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
    
     //Precargar la lista con todas las companyas
    public static List<CompanyaAerea> getAllCompanyas() {
        lstCompanyas = Inicializaciones.getInstance().getLstCompanya();
        return lstCompanyas;
    }

    public static CompanyaAerea getCompanyaByCodigo(String codigo) {
 
        CompanyaAerea valorSalida= null;
        lstCompanyas = Inicializaciones.getInstance().getLstCompanya();
        for(CompanyaAerea a : lstCompanyas){
            if(a.getCodigo().equals(codigo)){
                valorSalida = a;
                return valorSalida;
                
            }
        }
         return valorSalida;
    }

    public static CompanyaAerea getCompanyaByPrefijo(int prefijo) {
        CompanyaAerea valorSalida= null;
        lstCompanyas = Inicializaciones.getInstance().getLstCompanya();
        for(CompanyaAerea a : lstCompanyas){
            if(a.getPrefijo()==prefijo){
                valorSalida = a;
                return valorSalida;
            }
        }
         return valorSalida;

    }

    //logica de vuelo base
    private static List<VueloBase> lstVuelosBase = new ArrayList<VueloBase>();

    public static List<VueloBase> getAllVuelosBase() {
      lstVuelosBase = Inicializaciones.getInstance().getListVueloBase();
   
        return lstVuelosBase;
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

   
    public static VueloBase getVueloBaseByAeropuertoOrigen(String codigoIATA) {

        return new VueloBase();
    }

    public static VueloBase getVueloBaseByAeropuertoDestino(String codigoIATA) {
        return new VueloBase();
    }

    //Logica Vuelod Diarios
    private static List<VueloDiario> lstVuelosDiario = new ArrayList<VueloDiario>();

    public static List<VueloDiario> getAllVuelosDiarios() {
         lstVuelosDiario = Inicializaciones.getInstance().getListVueloDiario();
        return lstVuelosDiario;
    }

    public static VueloDiario getVueloDiarioByCodigoVueloBase(String codigo) {
      VueloDiario valorSalida = null;
      lstVuelosDiario = Inicializaciones.getInstance().getListVueloDiario();
      for(VueloDiario a: lstVuelosDiario){
          if(a.getCodigoVueloBase().equals(codigo)){
              valorSalida=a;
              return valorSalida;
          }
      }
       
        return valorSalida;
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

        
    }

    public static void deleteCompanyaByCodigo(String codigo) {
        CompanyaAerea delComp = getCompanyaByCodigo(codigo);
        lstCompanyas.remove(delComp);

    }
}
