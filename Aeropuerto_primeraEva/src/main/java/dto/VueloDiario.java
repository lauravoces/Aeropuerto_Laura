/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author laura
 */
public class VueloDiario {
     private String codigoVueloBase;
    private LocalDate fechaVuelo;
    private LocalTime horaSalidaReal;
    private LocalTime horaLlegadaReal;
    private int numPlazasOcupadas;
    private float precioVuelo;
    private VueloBase vueloBase;

    /**
     *
     * @return
     */
    public String getCodigoVueloBase() {
        return codigoVueloBase;
    }

    /**
     *
     * @param codigoVueloBase
     */
    public void setCodigoVueloBase(String codigoVueloBase) {
        this.codigoVueloBase = codigoVueloBase;
    }

    /**
     *
     * @return
     */
    public VueloBase getVueloBase() {
        return vueloBase;
    }

    /**
     *
     * @param vueloBase
     */
    public void setVueloBase(VueloBase vueloBase) {
        this.vueloBase = vueloBase;
    }
    
    /**
     *
     * @return
     */
    public String getCodigoVueloDiario() {
        return codigoVueloBase;
    }

    /**
     *
     * @param codigoVueloDiario
     */
    public void setCodigoVueloDiario(String codigoVueloDiario) {
        this.codigoVueloBase = codigoVueloDiario;
    }

    /**
     *
     * @return
     */
    public LocalDate getFechaVuelo() {
        return fechaVuelo;
    }

    /**
     *
     * @param fechaVuelo
     */
    public void setFechaVuelo(LocalDate fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    /**
     *
     * @return
     */
    public LocalTime getHoraSalidaReal() {
        return horaSalidaReal;
    }

    /**
     *
     * @param horaSalidaReal
     */
    public void setHoraSalidaReal(LocalTime horaSalidaReal) {
        this.horaSalidaReal = horaSalidaReal;
    }

    /**
     *
     * @return
     */
    public LocalTime getHoraLlegadaReal() {
        return horaLlegadaReal;
    }

    /**
     *
     * @param horaLlegadaReal
     */
    public void setHoraLlegadaReal(LocalTime horaLlegadaReal) {
        this.horaLlegadaReal = horaLlegadaReal;
    }

    /**
     *
     * @return
     */
    public int getNumPlazasOcupadas() {
        return numPlazasOcupadas;
    }

    /**
     *
     * @param numPlazasOcupadas
     */
    public void setNumPlazasOcupadas(int numPlazasOcupadas) {
        this.numPlazasOcupadas = numPlazasOcupadas;
    }

    /**
     *
     * @return
     */
    public double getPrecioVuelo() {
        return precioVuelo;
    }

    /**
     *
     * @param precioVuelo
     */
    public void setPrecioVuelo(float precioVuelo) {
        this.precioVuelo = precioVuelo;
    }
    
    /**
     *
     * @param codigoVuelo
     * @param fecha
     * @param numPlazas
     * @param precio
     * @param horaSalida
     * @param horaLlegada
     */
    public VueloDiario(String codigoVuelo, LocalDate fecha, int numPlazas, float precio, LocalTime horaSalida, LocalTime horaLlegada) {
        this.codigoVueloBase = codigoVuelo;
         this.fechaVuelo = fecha;
   
          this.numPlazasOcupadas = numPlazas;
         this.precioVuelo = precio;
        this.horaSalidaReal = horaSalida;
         this.horaLlegadaReal = horaLlegada;
    }
    
    /**
     *
     */
    public VueloDiario(){};
    
     // Método para obtener la hora de salida formateada

    /**
     *
     * @return
     */
    public String getHoraSalidaFormatted() {
        if (horaSalidaReal != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            return formatter.format(horaSalidaReal);
        } else {
            return "";
        }
    }

    // Método para obtener la hora de llegada formateada

    /**
     *
     * @return
     */
    public String getHoraLlegadaFormatted() {
        if (horaLlegadaReal != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            return formatter.format(horaLlegadaReal);
        } else {
            return "";
        }
    }
     
}
