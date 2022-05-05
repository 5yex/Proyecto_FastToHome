/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package util;

import java.time.LocalDate;

/**
 *
 * @author Jesus
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
	final public String MENSAJE_CLAVE_USUARIO = "Clave de usuario (Entre 4 y 20 caracteres ): ";
	final public String MENSAJE_PASS_USUARIO = "Contraseña (Entre 8 y 20 ): ";
	final public String MENSAJE_ANIO_CAMPANIA = "\nDame el año de la campaña (Mayor o igual a 2020 y maximo "+ANIO_ACTUAL+"): ";
	final public String MENSAJE_PRECIO_KILO = "Precio de la aceituna por kilo (pj:0.58 o 0.3): ";
	final public String MENSAJE_DNI = "Introduce el dni de la persona (8 numeros y 1 letra): ";
	final public String MENSAJE_NOMBRE = "Nombre de la persona (de 2 a 15 caracteres): ";
	final public String MENSAJE_EDAD = "Edad (mayor o igual a 18 menor que 99): ";
	final public String MENSAJE_KILOS = "Kilos recogidos (numero con 2 decimales): ";
	final public String MENSAJE_FINCA = "Dame el nombre de la finca: ";
	final public String MENSAJE_FECHA = "Dame la fecha (formato: yyyy-mm-dd): ";
	final public String MENSAJE_ID_RECOLECTOR = "Dame el id del recolector: ";
	final public String MENSAJE_COD_PESADA = "Dame el codigo de la pesada: ";
	final public String MENSAJE_COD_PRECIO = "Dame el codigo del precio: ";
	
	//PATRONES
	final public String PATRON_CLAVE_USUARIO = "[a-zA-Z0-9-_]{4,20}";
	final public String PATRON_PASS_USUARIO = "[a-zA-Z0-9-_]{8,20}";
	final public String PATRON_ANIO = "^(2020|"+ANIO_ACTUAL+")$";
	final public String PATRON_PRECIO_KILO = "^0\\.(?!0+$)\\d{1,2}$";
	final public String PATRON_DNI = "(([x-z]|[X-Z]{1})([-]?)(\\d{7})([-]?)([a-z]|[A-Z]{1}))|((\\d{8})([-]?)([a-z]|[A-Z]{1}))";
	final public String PATRON_NOMBRES = "[A-Za-z ]{2,15}";
	final public String PATRON_EDAD = "^(1[8-9]|[2-9][0-9])$";
	final public String PATRON_KILOS = "^\\d*(\\.\\d{1})?\\d{0,1}$";
	final public String PATRON_FINCA = "^([a-zA-Z ]{3,30})$";
	final public String PATRON_FECHA = "\\d{4}\\-(0?ERR[1-9]|1[012])\\-(0?[012][0-9]|3[01])";
	final public String PATRON_IDENTIFICADOR = "^\\d+$";
        final public Strng PATRON_EMAIL = "/\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b/gi";
}
