/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author laura
 */
public class Validaciones {
    
    public boolean esPrefijoValido(int prefijo) {
        return prefijo >= 0 && prefijo <= 999;
    }

    public boolean esCodigoCompaniaValido(String codigo) {
        return codigo.length() == 2 && codigo.matches("[A-Z][A-Z0-9]");
    }

    public boolean esTelefonoValido(String telefono) {
        return telefono.matches("[0-9]{4,15}");
    }

    public boolean esCodigoVueloValido(String codigo) {
        return esCodigoCompaniaValido(codigo.substring(0, 2)) && codigo.substring(2).matches("[0-9]{1,4}");
    }

    public boolean esCodigoMunicipioValido(String codMunicipio) {
        return codMunicipio.matches("[0-9]{5}");
    }

    public boolean sonDiasOperativosValidos(String dias) {
        return dias != null && dias.length() <= 7 && dias.matches("[LMXJVSD]?");
    }

    public boolean esFechaDiaOperativo(Date fecha, String diasOperativos) {
        DateFormat formatoFecha = new SimpleDateFormat("E", new Locale("es", "ES"));
        String diaSemana = formatoFecha.format(fecha).toUpperCase();
        return diasOperativos.contains(diaSemana);
        }
}
