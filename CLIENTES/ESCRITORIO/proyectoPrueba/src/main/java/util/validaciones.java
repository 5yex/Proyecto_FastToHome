/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.time.Clock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author jmcbg
 */
public class validaciones implements Constantes {

    public void validarString() {

    }

    public static boolean validar(String campo, String patron) {

        Pattern p = Pattern.compile(patron);
        Matcher m = p.matcher(campo);

        if (m.matches()) {
            return true;
        }

        return false;
    }
    
    public static boolean validacionDNI(String dni){
        int parteNumerica = Integer.parseInt(dni.substring(0,8));
        System.out.println(parteNumerica);
        int resto = 0;
        String parteLetra = dni.substring(8);
        System.out.println(parteLetra);
        
        String[] arrayLetras = {"T","R","W","A","G","M","Y","F","P","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
        
        resto = parteNumerica % 23;
        
        System.out.println(arrayLetras[resto]);
        
        return parteLetra == arrayLetras[resto];
    }

}
