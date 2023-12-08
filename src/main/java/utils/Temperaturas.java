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

    public Temperaturas(String aeropCodigo,
            String municipioCodigo,
            double minTemp,
            double maxTemperature) {

        this.aeropCodigo = aeropCodigo;
        this.municipioCodigo = municipioCodigo;
        this.minTemp = minTemp;
        this.maxTemp = maxTemperature;
    }
//getters y setters
    public String getAeropCodigo() {
        return aeropCodigo;
    }

    public String getMunicipioCodigo() {
        return municipioCodigo;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }
}
