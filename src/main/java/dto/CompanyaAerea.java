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

    /**
     *
     * @return
     */
    public int getPrefijo() {
        return prefijo;
    }

    /**
     *
     * @param prefijo
     */
    public void setPrefijo(int prefijo) {
        this.prefijo = prefijo;
    }

    /**
     *
     * @return
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     *
     * @return
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     *
     * @param municipio
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     *
     * @return
     */
    public String getNumInfoPasajero() {
        return numInfoPasajero;
    }

    /**
     *
     * @param numInfoPasajero
     */
    public void setNumInfoPasajero(String numInfoPasajero) {
        this.numInfoPasajero = numInfoPasajero;
    }

    /**
     *
     * @return
     */
    public String getNumInfoAeropuerto() {
        return numInfoAeropuerto;
    }

    /**
     *
     * @param numInfoAeropuerto
     */
    public void setNumInfoAeropuerto(String numInfoAeropuerto) {
        this.numInfoAeropuerto = numInfoAeropuerto;
    }

    /**
     *
     * @param prefijo
     * @param codigo
     * @param nombre
     * @param direccion
     * @param municipio
     * @param numInfoPasajero
     * @param numInfoAeropuerto
     */
    public CompanyaAerea(int prefijo, String codigo, String nombre, String direccion, String municipio, String numInfoPasajero, String numInfoAeropuerto) {
        this.prefijo = prefijo;
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.municipio = municipio;
        this.numInfoPasajero = numInfoPasajero;
        this.numInfoAeropuerto = numInfoAeropuerto;
    }
    
    /**
     *
     */
    public CompanyaAerea(){};
}
