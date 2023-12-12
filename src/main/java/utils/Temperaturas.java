/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author laura
 */
public class Temperaturas {

    private String aeropCodigo;
    private String municipioCodigo;
    private double minTemp;
    private double maxTemp;

    /**
     *
     * @param aeropCodigo
     * @param municipioCodigo
     * @param minTemp
     * @param maxTemperature
     */
    public Temperaturas(String aeropCodigo,
            String municipioCodigo,
            double minTemp,
            double maxTemperature) {

        this.aeropCodigo = aeropCodigo;
        this.municipioCodigo = municipioCodigo;
        this.minTemp = minTemp;
        this.maxTemp = maxTemperature;
    }

    /**
     *
     * @param aeropuertoCodigo
     * @param codigoMunicipio
     * @param temperaturaMaxima
     * @param temperaturaMinima
     */
    public Temperaturas(String aeropuertoCodigo, String codigoMunicipio, String temperaturaMaxima, String temperaturaMinima) {
        this.aeropCodigo = aeropuertoCodigo;
        this.municipioCodigo = codigoMunicipio;

        this.minTemp = (temperaturaMinima != null && !temperaturaMinima.trim().isEmpty()) ? Double.parseDouble(temperaturaMinima.trim()) : 0.0;
        this.maxTemp = (temperaturaMaxima != null && !temperaturaMaxima.trim().isEmpty()) ? Double.parseDouble(temperaturaMaxima.trim()) : 0.0;
    }
//getters y setters

    /**
     *
     * @return
     */
    public String getAeropCodigo() {
        return aeropCodigo;
    }

    /**
     *
     * @return
     */
    public String getMunicipioCodigo() {
        return municipioCodigo;
    }

    /**
     *
     * @return
     */
    public double getMinTemp() {
        return minTemp;
    }

    /**
     *
     * @return
     */
    public double getMaxTemp() {
        return maxTemp;
    }
}
