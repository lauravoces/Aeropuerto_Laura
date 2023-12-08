/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author laura
 */
public class CompanyaAerea {
     private int prefijo;
    private String codigo;
    private String nombre;
    private String direccion;
    private String municipio;
    private String numInfoPasajero;
    private String numInfoAeropuerto;

    public int getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(int prefijo) {
        this.prefijo = prefijo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getNumInfoPasajero() {
        return numInfoPasajero;
    }

    public void setNumInfoPasajero(String numInfoPasajero) {
        this.numInfoPasajero = numInfoPasajero;
    }

    public String getNumInfoAeropuerto() {
        return numInfoAeropuerto;
    }

    public void setNumInfoAeropuerto(String numInfoAeropuerto) {
        this.numInfoAeropuerto = numInfoAeropuerto;
    }

    public CompanyaAerea(int prefijo, String codigo, String nombre, String direccion, String municipio, String numInfoPasajero, String numInfoAeropuerto) {
        this.prefijo = prefijo;
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.municipio = municipio;
        this.numInfoPasajero = numInfoPasajero;
        this.numInfoAeropuerto = numInfoAeropuerto;
    }
    
    public CompanyaAerea(){};
}
