/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.donoso.proyectoprueba;

import static controlador.gestion.hacerConsulta;
import java.io.IOException;
import modelo.Categoria;
import modelo.Peticion;
import modelo.Usuario;


/**
 *
 * @author jmcbg
 */
public class principal {

    public static void main(String[] args) throws IOException {

       Usuario user = new Usuario();
       user.setDni("sdfsf");
       user.setEmail("fasdfa");
       user.setId_direccion(0);
       user.setNombre("pruweasd");
       user.setPassword("pruebas");
       user.setRol("clientes");
       user.setTlf("asdfgsfdg");

        hacerConsulta(new Peticion("", user.));
    }

}
