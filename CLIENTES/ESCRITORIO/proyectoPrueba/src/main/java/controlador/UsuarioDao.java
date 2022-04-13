/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import static controlador.gestion.hacerConsulta;
import modelo.Peticion;
import modelo.Usuario;

/**
 *
 * @author jmcbg
 */
public class UsuarioDao {
    public boolean nuevoUsuario(Usuario user){
         hacerConsulta(new Peticion("nuevo_usuario", user.getJSON()));
    }
}
