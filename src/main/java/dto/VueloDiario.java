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

    

    public String getCodigoVueloBase() {
        return codigoVueloBase;
    }

    public void setCodigoVueloBase(String codigoVueloBase) {
        this.codigoVueloBase = codigoVueloBase;
    }

    public VueloBase getVueloBase() {
        return vueloBase;
    }

    public void setVueloBase(VueloBase vueloBase) {
        this.vueloBase = vueloBase;
    }
    
    
    
    public String getCodigoVueloDiario() {
        return codigoVueloBase;
    }

    public void setCodigoVueloDiario(String codigoVueloDiario) {
        this.codigoVueloBase = codigoVueloDiario;
    }

    public LocalDate getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(LocalDate fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public LocalTime getHoraSalidaReal() {
        return horaSalidaReal;
    }

    public void setHoraSalidaReal(LocalTime horaSalidaReal) {
        this.horaSalidaReal = horaSalidaReal;
    }

    public LocalTime getHoraLlegadaReal() {
        return horaLlegadaReal;
    }

    public void setHoraLlegadaReal(LocalTime horaLlegadaReal) {
        this.horaLlegadaReal = horaLlegadaReal;
    }

    public int getNumPlazasOcupadas() {
        return numPlazasOcupadas;
    }

    public void setNumPlazasOcupadas(int numPlazasOcupadas) {
        this.numPlazasOcupadas = numPlazasOcupadas;
    }

    public double getPrecioVuelo() {
        return precioVuelo;
    }

    public void setPrecioVuelo(float precioVuelo) {
        this.precioVuelo = precioVuelo;
    }
    

 
    public VueloDiario(String codigoVuelo, LocalDate fecha, int numPlazas, float precio, LocalTime horaSalida, LocalTime horaLlegada) {
        this.codigoVueloBase = codigoVuelo;
         this.fechaVuelo = fecha;
   
          this.numPlazasOcupadas = numPlazas;
         this.precioVuelo = precio;
        this.horaSalidaReal = horaSalida;
         this.horaLlegadaReal = horaLlegada;
    }
    
    public VueloDiario(){};
    
     // Método para obtener la hora de salida formateada
    public String getHoraSalidaFormatted() {
        if (horaSalidaReal != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            return formatter.format(horaSalidaReal);
        } else {
            return "";
        }
    }

    // Método para obtener la hora de llegada formateada
    public String getHoraLlegadaFormatted() {
        if (horaLlegadaReal != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
            return formatter.format(horaLlegadaReal);
        } else {
            return "";
        }
    }
     
}
