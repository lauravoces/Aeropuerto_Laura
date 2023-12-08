/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

/**
 *
 * @author laura
 */
public class VueloBase {
      private String codigoVuelo;
    private String codigoAeropuertoOrigen;
    private String codigoAeropuertoDestino;
    private int numPlazas;
    private Date horaOficialSalida;
    private Date horaOficialLlegada;
    private String diasOpera;
    private Aeropuerto aeropuertoOrigen;
    private Aeropuerto aeropuertoDestino;
     
     /*
     Hay dos maneras de trabajar, o con String de las clases 
     codigoAeropuerto...
     o con los objetos Aeropuerto
     */
    

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public String getAeropuertoOrigen() {
        return codigoAeropuertoOrigen;
    }

    public void setcodigoAeropuertoOrigen(String aeropuertoOrigen) {
        this.codigoAeropuertoOrigen = aeropuertoOrigen;
    }

    public String getAeropuertoDestino() {
        return codigoAeropuertoDestino;
    }

    public void setAeropuertoDestino(String aeropuertoDestino) {
        this.codigoAeropuertoDestino = aeropuertoDestino;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    public Date getHoraOficialSalida() {
        return horaOficialSalida;
    }

    public void setHoraOficialSalida(Date horaOficialSalida) {
        this.horaOficialSalida = horaOficialSalida;
    }

    public Date getHoraOficialLlegada() {
        return horaOficialLlegada;
    }

    public void setHoraOficialLlegada(Date horaOficialLlegada) {
        this.horaOficialLlegada = horaOficialLlegada;
    }

    public String getDiasOpera() {
        return diasOpera;
    }

    public void setDiasOpera(String diasOpera) {
        this.diasOpera = diasOpera;
    }

    public VueloBase(String codigoVuelo, String aeropuertoOrigen, String aeropuertoDestino, int numPlazas, Date horaOficialSalida, Date horaOficialLlegada, String diasOpera) {
        this.codigoVuelo = codigoVuelo;
        this.codigoAeropuertoOrigen = aeropuertoOrigen;
        this.codigoAeropuertoDestino = aeropuertoDestino;
        this.numPlazas = numPlazas;
        this.horaOficialSalida = horaOficialSalida;
        this.horaOficialLlegada = horaOficialLlegada;
        this.diasOpera = diasOpera;
    }

public VueloBase(){};    
    
    
}
