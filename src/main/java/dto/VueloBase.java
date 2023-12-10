/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalTime;
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
    private LocalTime horaOficialSalida;
    private LocalTime horaOficialLlegada;
    private String diasOpera;
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

    public LocalTime getHoraOficialSalida() {
        return horaOficialSalida;
    }

    public void setHoraOficialSalida(LocalTime horaOficialSalida) {
        this.horaOficialSalida = horaOficialSalida;
    }

    public LocalTime getHoraOficialLlegada() {
        return horaOficialLlegada;
    }

    public void setHoraOficialLlegada(LocalTime horaOficialLlegada) {
        this.horaOficialLlegada = horaOficialLlegada;
    }

    public String getDiasOpera() {
        return diasOpera;
    }

    public void setDiasOpera(String diasOpera) {
        this.diasOpera = diasOpera;
    }

    public VueloBase(String codigoVuelo, String aeropuertoOrigen, String aeropuertoDestino, int numPlazas, LocalTime horaOficialSalida, LocalTime horaOficialLlegada, String diasOpera) {
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
