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
public class VueloDiario {
     private String codigoVueloBase;
    private Date fechaVuelo;
    private Date horaSalidaReal;
    private Date horaLlegadaReal;
    private int numPlazasOcupadas;
    private float precioVuelo;
    //esto solo es para quine quiera, mismo funcionamiento que en 
    //vueloOirgen y vueloDestino
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

    public Date getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(Date fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public Date getHoraSalidaReal() {
        return horaSalidaReal;
    }

    public void setHoraSalidaReal(Date horaSalidaReal) {
        this.horaSalidaReal = horaSalidaReal;
    }

    public Date getHoraLlegadaReal() {
        return horaLlegadaReal;
    }

    public void setHoraLlegadaReal(Date horaLlegadaReal) {
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
    

    public VueloDiario(String codigoVueloDiario, Date fechaVuelo, Date horaSalidaReal, Date horaLlegadaReal, int numPlazasOcupadas, float precioVuelo) {
        this.codigoVueloBase = codigoVueloDiario;
        this.fechaVuelo = fechaVuelo; //va a ser solo la fecha
        this.horaSalidaReal = horaSalidaReal; //va a ser solo la hora
        this.horaLlegadaReal = horaLlegadaReal; //va a ser solo la hora
        this.numPlazasOcupadas = numPlazasOcupadas;
        this.precioVuelo = precioVuelo;
    }

    public VueloDiario(String codigoVueloBase, Date fechaVuelo, Date horaSalidaReal, Date horaLlegadaReal, int numPlazasOcupadas, float precioVuelo, VueloBase vueloBase) {
        this.codigoVueloBase = codigoVueloBase;
        this.fechaVuelo = fechaVuelo;
        this.horaSalidaReal = horaSalidaReal;
        this.horaLlegadaReal = horaLlegadaReal;
        this.numPlazasOcupadas = numPlazasOcupadas;
        this.precioVuelo = precioVuelo;
        this.vueloBase = vueloBase;
    }
    
    
    public VueloDiario(){};
}
