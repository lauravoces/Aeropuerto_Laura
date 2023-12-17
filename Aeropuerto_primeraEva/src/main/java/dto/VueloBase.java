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

    /**
     *
     * @return
     */
    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    /**
     *
     * @param codigoVuelo
     */
    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    /**
     *
     * @return
     */
    public String getAeropuertoOrigen() {
        return codigoAeropuertoOrigen;
    }

    /**
     *
     * @param aeropuertoOrigen
     */
    public void setcodigoAeropuertoOrigen(String aeropuertoOrigen) {
        this.codigoAeropuertoOrigen = aeropuertoOrigen;
    }

    /**
     *
     * @return
     */
    public String getAeropuertoDestino() {
        return codigoAeropuertoDestino;
    }

    /**
     *
     * @param aeropuertoDestino
     */
    public void setAeropuertoDestino(String aeropuertoDestino) {
        this.codigoAeropuertoDestino = aeropuertoDestino;
    }

    /**
     *
     * @return
     */
    public int getNumPlazas() {
        return numPlazas;
    }

    /**
     *
     * @param numPlazas
     */
    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    /**
     *
     * @return
     */
    public LocalTime getHoraOficialSalida() {
        return horaOficialSalida;
    }

    /**
     *
     * @param horaOficialSalida
     */
    public void setHoraOficialSalida(LocalTime horaOficialSalida) {
        this.horaOficialSalida = horaOficialSalida;
    }

    /**
     *
     * @return
     */
    public LocalTime getHoraOficialLlegada() {
        return horaOficialLlegada;
    }

    /**
     *
     * @param horaOficialLlegada
     */
    public void setHoraOficialLlegada(LocalTime horaOficialLlegada) {
        this.horaOficialLlegada = horaOficialLlegada;
    }

    /**
     *
     * @return
     */
    public String getDiasOpera() {
        return diasOpera;
    }

    /**
     *
     * @param diasOpera
     */
    public void setDiasOpera(String diasOpera) {
        this.diasOpera = diasOpera;
    }

    /**
     *
     * @param codigoVuelo
     * @param aeropuertoOrigen
     * @param aeropuertoDestino
     * @param numPlazas
     * @param horaOficialSalida
     * @param horaOficialLlegada
     * @param diasOpera
     */
    public VueloBase(String codigoVuelo, String aeropuertoOrigen, String aeropuertoDestino, int numPlazas, LocalTime horaOficialSalida, LocalTime horaOficialLlegada, String diasOpera) {
        this.codigoVuelo = codigoVuelo;
        this.codigoAeropuertoOrigen = aeropuertoOrigen;
        this.codigoAeropuertoDestino = aeropuertoDestino;
        this.numPlazas = numPlazas;
        this.horaOficialSalida = horaOficialSalida;
        this.horaOficialLlegada = horaOficialLlegada;
        this.diasOpera = diasOpera;
    }

    /**
     *
     */
    public VueloBase(){};    
    
    
}
