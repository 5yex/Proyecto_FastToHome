package com.proyecto.fasttohome;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaciones {

    public static boolean validar(String campo, String patron) {

        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(campo);

        if (m.matches()) {
            return true;
        }

        return false;
    }

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
