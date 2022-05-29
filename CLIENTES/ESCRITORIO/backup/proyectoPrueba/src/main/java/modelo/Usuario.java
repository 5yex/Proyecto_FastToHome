/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.Vector;

/**
 *
 * @author jmcbg
 */
public class Usuario {

    private int id;
    private String nombre;
    private String apellidos;
    private String dni;
    private String email;
    private String tlf;
    private String rol;
    private int id_direccion;
    private String password;

    public Usuario() {
    }

    public Usuario(int id) {
        this.id = id;
    }

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

    public Usuario(String email) {
        this.email = email;
    }

    public Usuario(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

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