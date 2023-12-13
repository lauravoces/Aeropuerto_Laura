/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author laura
 */
public class Validaciones {

    
     public static boolean esTelefonoValido(String telefono) {
       
        String patronTelefono = "^(\\+\\d{1,3})?\\d{9,}$";
        Pattern patron = Pattern.compile(patronTelefono);
        Matcher comprobacion = patron.matcher(telefono);   
        return comprobacion.matches();
    }
    
    public static boolean esFechaValida(String fecha) {
        String patronFecha = "^\\d{4}-\\d{2}-\\d{2}$";
        Pattern patron = Pattern.compile(patronFecha);
        Matcher comprobacion = patron.matcher(fecha);
        return comprobacion.matches();
    }

    
    
    /**
     *
     * @param prefijo
     * @return
     */
    public static boolean esPrefijoValido(String prefijo) {
        try {
            int prefijoNumerico = Integer.parseInt(prefijo);
            return prefijoNumerico >= 0 && prefijoNumerico <= 999;
        } catch (NumberFormatException e) {        
            return false;
        }
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
    
    public static boolean esEntero2(String numero) {
        Pattern patron = Pattern.compile("^\\d{1,4}$"); // Ajustado para permitir de 0 a 9999
        Matcher comprobacion = patron.matcher(numero);
        return comprobacion.matches();
    }
    
    /**
     *
     * @param codigo
     * @return
     */
    public static boolean esCodigoCompaniaValido(String codigo) {
        return codigo.length() == 3 && codigo.matches("[A-Z][A-Z0-9]");
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
