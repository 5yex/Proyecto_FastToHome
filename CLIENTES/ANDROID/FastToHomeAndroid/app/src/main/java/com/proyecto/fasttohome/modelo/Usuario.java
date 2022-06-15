/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.fasttohome.modelo;

import com.google.gson.Gson;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Vector;

/**
 * Clase que representa un usuario de la aplicación
 *
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 * @since 1.0
 */
public class Usuario implements Serializable{

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
     * Rol establecido para el usuario
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
     * @param rol Rol establecido para un usuario
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
     * @param rol Rol establecido para un usuario
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

    /**
     * Establece el nombre del usuario
     *
     * @param email Nombre del usuario
     * @since 1.0
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve el número de telefono del usuario
     *
     * @return Número de telefono del usuario
     * @since 1.0
     */
    public String getTlf() {
        return tlf;
    }

    /**
     * Estable el número de telefono del usuario
     *
     * @param tlf Número de telefono del usuario
     * @since 1.0
     */
    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    /**
     * Devuelve el rol establecido para un usuario
     *
     * @return Rol establecido para un usuario
     * @since 1.0
     */
    public String getRol() {
        return rol;
    }

    /**
     * Establece un nuevo rol para el usuario
     *
     * @param rol Rol establecido para un usuario
     * @since 1.0
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Devuelve una cadena con los atributos del objeto de tipo Usuario
     *
     * @return Cadena con los atributos del objeto de tipo Usuario
     * @since 1.0
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", email=" + email + ", tlf=" + tlf + ", rol=" + rol + ", id_direccion=" + id_direccion + ", password=" + password + '}';
    }

    /**
     * Devuelve el número que identifica la direccion del usuario en la base de
     * datos
     *
     * @return Número que identifica la direccion del usuario en la base de
     * datos
     * @since 1.0
     */
    public int getId_direccion() {
        return id_direccion;
    }

    /**
     * Establece un número que identifica la direccion del usuario en la base de
     * datos
     *
     * @param id_direccion Número que identifica la direccion del usuario en la
     * base de datos
     * @since 1.0
     */
    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    /**
     * Devuelve la contraseña del usuario
     *
     * @return Contraseña del usuario
     * @since 1.0
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario
     *
     * @param password Contraseña del usuario
     * @since 1.0
     *
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Devuelve el objeto de tipo Usuario en forma de JSon
     *
     * @return el objeto de tipo Categoria en forma de JSon
     * @since 1.0
     */
    public String getJSON() {
        return new Gson().toJson(this);
    }

    /**
     * Devuelve un array de objetos con la información para rellenar la fila de una tabla con información del usuario
     *
     * @return Array de objetos con la información para rellenar la fila de una tabla con información del usuario
     */
    public Object[] getRow() {
        return new Object[]{id, dni, email, nombre, tlf};
    }

}
