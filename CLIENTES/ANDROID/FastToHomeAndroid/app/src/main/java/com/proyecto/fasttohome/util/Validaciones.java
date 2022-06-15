package com.proyecto.fasttohome.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase donde establecemos las distintos metodos con validaciones de campos que se pueden usar en otras clases
 *
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 */
public class Validaciones {

    /**
     * Valida si el campo introducido cumple el patrón
     *
     * @param campo campo rellenado por el usuario de la aplicación
     * @param patron patron que debe serguir el campo introducido
     * @return true si el campo introducido cumple el patrón
     */
    public static boolean validar(String campo, String patron) {

        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(campo);

        if (m.matches()) {
            return true;
        }

        return false;
    }

    /**
     * Valida que el dni introducido es correcto
     *
     * @param dni DNI a verificar
     * @return true si el dni introducido es correcto
     */
    public static boolean validacionDNI(String dni) {
        dni.toUpperCase();
        if (dni.length() == 9) {
            try {
                int parteNumerica = Integer.parseInt(dni.substring(0, 8));
                System.out.println(parteNumerica);
                int resto = 0;
                String parteLetra = dni.substring(8);
                System.out.println(parteLetra);

                String[] arrayLetras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

                resto = parteNumerica % 23;
                System.out.println(resto);
                System.out.println(arrayLetras[resto]);

                return (parteLetra.compareTo(arrayLetras[resto]) == 0);
            } catch (StringIndexOutOfBoundsException e) {
                return false;
            }
        }
        return false;

    }
}
