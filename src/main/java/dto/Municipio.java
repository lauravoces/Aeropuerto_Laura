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

    public Municipio(String codigo, String nombreMunicipio) {
        this.codigo = codigo;
        this.nombreMunicipio = nombreMunicipio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }
}
