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

    public String getCodigoIATA() {
        return codigoIATA;
    }

    public void setCodigoIATA(String codigoIATA) {
        this.codigoIATA = codigoIATA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public Aeropuerto(String codigoIATA, String nombre, String codigoMunicipio) {
        this.codigoIATA = codigoIATA;
        this.nombre = nombre;
        this.codigoMunicipio = codigoMunicipio;
    }
    
    public Aeropuerto(){};
}  

