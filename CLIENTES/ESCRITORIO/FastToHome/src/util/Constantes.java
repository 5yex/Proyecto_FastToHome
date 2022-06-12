/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package util;

import java.time.LocalDate;

/**
 * Interfaz donde almacenamos las variables constantes y los patrones para las validaciones ademas de otros elementos
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 */
public interface Constantes {

    //COSAS DE FECHAS
    final public static LocalDate FECHA_ACTUAL = LocalDate.now();
    final public static int ANIO_ACTUAL = FECHA_ACTUAL.getYear();

    //REQUERIMIENTOS DE CONEXION
    final public static String NOMBREBD = "molinoAceituna";
    final public static String URL = "jdbc:postgresql://localhost/" + NOMBREBD;
    final public static String USUARIO_POSTGRE = "postgres";
    final public static String PASS_POSTGRE = "admin";

    //ERRORES
    final public String ERROR_ENTRADA_SALIDA = "Error en la entrada y salida de datos.";
    final public String ERROR_FORMATO_NUMERICO = "Error, se necesita un formato numerico.";
    final public String ERROR_SQL = "Error al ejecutar la sentencia SQL";
    final public String ERROR_OBTENCION_KILOS = "No se pudo obtener los kilos totales del usuario";
    final public String ERROR_CALCULO_PRECIO = "No se ha podido calcular el dinero total ganado";

    //MENSAJES DE INFORMACIÓN
    final public String MENSAJE_PASS_INFO = "Al menos 8 caracteres, mayus y número";
    final public String MENSAJE_DNI_INFO = "Introduzca un dni válido (8 números y 1 letra)";
    final public String MENSAJE_NOMBRE_INFO = "Primera letra en mayuscula.";
    final public String MENSAJE_APELLIDO_INFO = "Primera letra en mayuscula.";
    final public String MENSAJE_FECHA = "Dame la fecha (formato: yyyy-mm-dd): ";
    final public String MENSAJE_EMAIL_INFO = "Email inválido";
    final public String MENSAJE_TELEFONO_INFO = "Teléfono inválido";
    final public String MENSAJE_ERROR_RELLENO_DATOS = "Se ha producido un error al rellenar los datos, siga las intrucciones";
    final public String MENSAJE_CONFIRMA_PASS = "La contraseña debe ser igual.";
    
    //PATRONES
    final public String PATRON_CLAVE_USUARIO = "[a-zA-Z0-9-_]{4,20}";
    final public String PATRON_PASS_USUARIO = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,20}$";
    final public String PATRON_ANIO = "^(2020|" + ANIO_ACTUAL + ")$";
    final public String PATRON_PRECIO_KILO = "^0\\.(?!0+$)\\d{1,2}$";
    final public String PATRON_DNI = "(([x-z]|[X-Z]{1})([-]?)(\\d{7})([-]?)([a-z]|[A-Z]{1}))|((\\d{8})([-]?)([a-z]|[A-Z]{1}))";
    final public String PATRON_NOMBRES = "^(([A-ZÁÉÍÓÚÑ]{1}[a-záéíóúüñ]*)(\\s)?)((((((((de)|(del)|(la)|(las)|(los))\\s)?)?){1,2})(([A-ZÁÉÍÑÓ]{1}[a-záéíñóúü\\.]*)(\\s([A-ZÁÉÍÑÓ]{1}[a-záéíñóúü\\.]*))?){1})?)$";
    final public String PATRON_APELLIDOS = "^(([A-ZÁÉÍÓÚÑ]{1}[a-záéíóúüñ]*)(\\s)?)((((((((de)|(del)|(la)|(las)|(los))\\s)?)?){1,2})(([A-ZÁÉÍÑÓ]{1}[a-záéíñóúü\\.]*)(\\s([A-ZÁÉÍÑÓ]{1}[a-záéíñóúü\\.]*))?){1})?)$";
    final public String PATRON_FECHA = "\\d{4}\\-(0?ERR[1-9]|1[012])\\-(0?[012][0-9]|3[01])";
    final public String PATRON_EMAIL = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
    final public String PATRON_TELEFONO = "(\\+34|0034|34)?[ -]*(6|7|9)[ -]*([0-9][ -]*){8}";
    final public String PATRON_COORDENADAS = "^(-?\\d+(.\\d+)?),\\s*(-?\\d+(.\\d+)?)$";
    
    
    //VARIABLES FIJAS (CONSTANTES)
    final public String CLIENTE = "cliente";
    final public String ADMIN = "admin";
    final public String MERCADER = "mercader";
    

}
