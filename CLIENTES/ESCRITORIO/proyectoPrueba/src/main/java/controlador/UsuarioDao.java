/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador;
import modelo.Peticion;
import modelo.Usuario;

/**
 *
 * @author jmcbg
 */
public class UsuarioDao {
    public static boolean nuevoUsuario(Usuario user){
         return gestion.hacerConsulta(new Peticion("nuevo_usuario", user.getJSON()));
    }
    public static String obtenerId(Usuario user){
        return gestion.consultaSeleccion(new Peticion("obtener_id_cliente", user.getJSON()));
    }
}
