/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author laura
 */
public class Aeropuerto {
  private String codigoIATA;
    private String nombre;
    private String codigoMunicipio;

    /**
     *
     * @return
     */
    public String getCodigoIATA() {
        return codigoIATA;
    }

    /**
     *
     * @param codigoIATA
     */
    public void setCodigoIATA(String codigoIATA) {
        this.codigoIATA = codigoIATA;
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
    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    /**
     *
     * @param codigoMunicipio
     */
    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    /**
     *
     * @param codigoIATA
     * @param nombre
     * @param codigoMunicipio
     */
    public Aeropuerto(String codigoIATA, String nombre, String codigoMunicipio) {
        this.codigoIATA = codigoIATA;
        this.nombre = nombre;
        this.codigoMunicipio = codigoMunicipio;
    }
    
    /**
     *
     */
    public Aeropuerto(){};
}  

