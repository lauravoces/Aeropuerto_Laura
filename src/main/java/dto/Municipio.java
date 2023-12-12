/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author laura
 */
public class Municipio {
    private String codigo;
    private String nombreMunicipio;

    /**
     *
     * @param codigo
     * @param nombreMunicipio
     */
    public Municipio(String codigo, String nombreMunicipio) {
        this.codigo = codigo;
        this.nombreMunicipio = nombreMunicipio;
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
     * @return
     */
    public String getNombreMunicipio() {
        return nombreMunicipio;
    }
}
