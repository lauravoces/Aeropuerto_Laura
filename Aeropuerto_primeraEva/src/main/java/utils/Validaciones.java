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

    /**
     * Metodo que valida si una cadena es valida, incluye la posibilidad de añadir un prefijo de pais
     * @param telefono
     * @return
     */
    public static boolean esTelefonoValido(String telefono) {
       
        String patronTelefono = "^(\\+\\d{1,3})?\\d{9,}$";
        Pattern patron = Pattern.compile(patronTelefono);
        Matcher comprobacion = patron.matcher(telefono);   
        return comprobacion.matches();
    }
    
    /**
     * Metodo que valida las fechas en formato yyyy-MM-dd
     * @param fecha
     * @return
     */
    public static boolean esFechaValida(String fecha) {
        String patronFecha = "^\\d{4}-\\d{2}-\\d{2}$";
        Pattern patron = Pattern.compile(patronFecha);
        Matcher comprobacion = patron.matcher(fecha);
        return comprobacion.matches();
    }

    
    
    /**
     * Metodo que valida si el prefijo será entre 0 y 999
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
     * Metodo que valida el formato del codigo de vuelo
     * @param codigo
     * @return
     */
    public boolean esCodigoVueloValido(String codigo) {
        return esCodigoCompaniaValido(codigo.substring(0, 2)) 
                && codigo.substring(2).matches("[0-9]{1,4}");
    }
     
    /**
     * Metodo que valida si el numero es un entero
     * @param numero
     * @return
     */
    public static boolean esEntero(String numero) {
        Pattern patron = Pattern.compile("^-?\\d+$");
        Matcher comprobacion = patron.matcher(numero);
        return comprobacion.matches();
    }
    
    /**
     * Metodo que valida si el string es un numero de 0 a 9999
     * Es usado en los codigos de vuelo diario despues del codigo de compañia
     * @param numero
     * @return
     */
    public static boolean esEntero2(String numero) {
        Pattern patron = Pattern.compile("^\\d{1,4}$"); // Ajustado para permitir de 0 a 9999
        Matcher comprobacion = patron.matcher(numero);
        return comprobacion.matches();
    }
    
    /**
     * Valida el codigo de una compañia cuando vamos a introducirla
     * @param codigo
     * @return
     */
    public static boolean esCodigoCompaniaValido(String codigo) {
        return codigo.length() == 3 && codigo.matches("[A-Z][A-Z0-9]");
    }
    
    /**
     * valida los municipios
     * @param codMunicipio
     * @return
     */
    public boolean esCodigoMunicipioValido(String codMunicipio) {
        return codMunicipio.matches("[0-9]{5}");
    }
    
 //esto era otra positibilidad pero no permite concat

    /**
     * Esto fue un primer intento de validar la semana, al final no lo hice porque no me validaba una cadena concatenada
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
     * Valida que la cadena introducida sea del formato LMX.... lo que esta en matches
     * @param dias
     * @return
     */
    public static boolean esDiaOperativoValido(String dias) {
        return dias != null && dias.length() <= 7 && dias.matches("[LMXJVSD]+");
    }
}
