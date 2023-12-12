/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import dto.CompanyaAerea;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import utils.CSV.LectorCSV;

/**
 *
 * @author laura
 */
public class Validaciones {

    /**
     *
     * @param prefijo
     * @return
     */
    public boolean esPrefijoValido(int prefijo) {
        return prefijo >= 0 && prefijo <= 999;
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public boolean esCodigoVueloValido(String codigo) {
        return esCodigoCompaniaValido(codigo.substring(0, 2)) 
                && codigo.substring(2).matches("[0-9]{1,4}");
    }
     
    /**
     *
     * @param numero
     * @return
     */
    public static boolean esEntero(String numero) {
        Pattern patron = Pattern.compile("^-?\\d+$");
        Matcher comprobacion = patron.matcher(numero);
        return comprobacion.matches();
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public static boolean esCodigoCompaniaValido(String codigo) {
        return codigo.length() == 2 && codigo.matches("[A-Z][A-Z0-9]");
    }

    /**
     *
     * @param telefono
     * @return
     */
    public boolean esTelefonoValido(String telefono) {
        return telefono.matches("[0-9]{4,15}");
    }

    /**
     *
     * @param codMunicipio
     * @return
     */
    public boolean esCodigoMunicipioValido(String codMunicipio) {
        return codMunicipio.matches("[0-9]{5}");
    }
    
 //esto era otra positibilidad pero no permite concat

    /**
     *
     * @param dia
     * @return
     */
    public static boolean esDiaSemanaValido(String dia) {
        switch (dia) {
            case Semana.MONDAY:
            case Semana.TUESDAY:
            case Semana.WEDNESDAY:
            case Semana.THURSDAY:
            case Semana.FRIDAY:
            case Semana.SATURDAY:
            case Semana.SUNDAY:
                return true;
            default:
                return false;
        }
    }
    
    /**
     *
     * @param dias
     * @return
     */
    public static boolean esDiaOperativoValido(String dias) {
        return dias != null && dias.length() <= 7 && dias.matches("[LMXJVSD]+");
    }
}
