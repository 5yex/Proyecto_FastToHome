/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Vector;

/**
 * Clase que representa un usuario de la aplicación
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 * @since 1.0
 */
public class Usuario {
    
    /**
     * Número que identifica al usuario en la base de datos
     * 
     * @since 1.0
     */
    private int id;
    
    /**
     * Nombre del usuario
     * 
     * @since 1.0
     */
    private String nombre;
    
    /**
     * Apellidos del usuario
     * 
     * @since 1.0
     */
    private String apellidos;
    
    /**
     * DNI del usuario
     * 
     * @since 1.0
     */
    private String dni;
    
    /**
     * Correo o email del usuario
     * 
     * @since 1.0
     */
    private String email;
    
    /**
     * Número de teléfono del usuario
     * 
     * @since 1.0
     */
    private String tlf;
    
    /**
     * Rol o 'papel' que sigue el usuario
     * 
     * @since 1.0
     */
    private String rol;
    
    /**
     * Número que identifica la dirección del usuario
     * 
     * @since 1.0
     */
    private int id_direccion;
    
    /**
     * Contraseña del usuario
     * 
     * @since 1.0
     */
    private String password;
    
    /**
     * Construye un Usuario con parametos a <code>null</code>
     * 
     * @since 1.0
     * 
     */
    public Usuario() {
    }
    
    /**
     * Construye un Usuario con los parametros indicados
     * 
     * @param id Número que identifica al usuario en la base de datos
     */
    public Usuario(int id) {
        this.id = id;
    }
    
    /**
     * Construye un Usuario con los parametros indicados
     * 
     * @param id Número que identifica al usuario en la base de datos
     * @param nombre Nombre del usuario
     * @param apellidos Apellidos del usuario
     * @param dni DNI del usuario
     * @param email Correo del usuario
     * @param tlf Número de telefono del usuario
     * @param rol Rol que sigue el usuario
     * @param id_direccion Número que identifica la dirección del usuario
     * @param password Contraseña del usuario
     */
    public Usuario(int id, String nombre, String apellidos, String dni, String email, String tlf, String rol, int id_direccion, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.tlf = tlf;
        this.rol = rol;
        this.id_direccion = id_direccion;
        this.password = password;
    }
    
    /**
     * Construye un Usuario con los parametros indicados
     * 
     * @param nombre Nombre del usuario
     * @param apellidos Apellidos del usuario
     * @param dni DNI del usuario
     * @param email Correo del usuario
     * @param tlf Número de telefono del usuario
     * @param rol Rol que sigue el usuario
     * @param id_direccion Número que identifica la dirección del usuario
     * @param password Contraseña del usuario
     */
    public Usuario(String nombre, String apellidos, String dni, String email, String tlf, String rol, int id_direccion, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.email = email;
        this.tlf = tlf;
        this.rol = rol;
        this.id_direccion = id_direccion;
        this.password = password;
    }
    
    /**
     * Construye un Usuario con los parametros indicados
     * 
     * @param email Correo del usuario
     */
    public Usuario(String email) {
        this.email = email;
    }

    /**
     * Construye un Usuario con los parametros indicados
     * 
     * @param email Correo del usuario
     * @param password Contraseña del usuario
     */
    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    /**
     * Devuelve el número que identifica al usuario en la base de datos
     * 
     * @return el número que identifica al usuario en la base de datos
     * @since 1.0
     */
    public int getId() {
        return id;
    }
    
    /**
     * Establece el número que identifica al usuario en la base de datos
     * 
     * @param id Número que identifica al usuario en la base de datos
     * @since 1.0
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Devuelve el nombre del usuario
     * 
     * @return Nombre del usuario
     * @since 1.0
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre del usuario
     * 
     * @param nombre Nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Devuelve el apellido del usuario
     * 
     * @return Apellido del usuario
     * @since 1.0
     */ 
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece el apellido del usuario
     * 
     * @param apellidos Apellido del usuario
     * @since 1.0
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    /**
     * Devuelve el DNI del usuario
     * 
     * @return DNI del usuario
     * @since 1.0
     */
    public String getDni() {
        return dni;
    }
    
    /**
     * Establece el DNI del usuario
     * 
     * @param dni DNI del usuario
     * @since 1.0
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    /**
     * Devuelve el correo del usuario
     * 
     * @return Correo del usuario
     * @since 1.0
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", email=" + email + ", tlf=" + tlf + ", rol=" + rol + ", id_direccion=" + id_direccion + ", password=" + password + '}';
    }

    public int getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     public String getJSON(){
       return new Gson().toJson(this);
    }

    public Object[] getRow() {
                return new Object[]{id, dni, email, nombre, tlf};

    }

}
