/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author JM
 */
public class usuario {

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.dni);
        hash = 89 * hash + Objects.hashCode(this.clave);
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + Objects.hashCode(this.apellidos);
        hash = 89 * hash + Objects.hashCode(this.telefono);
        hash = 89 * hash + Objects.hashCode(this.tipo_usuario);
        hash = 89 * hash + Objects.hashCode(this.direccion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final usuario other = (usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.clave, other.clave)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (this.tipo_usuario != other.tipo_usuario) {
            return false;
        }
        return Objects.equals(this.direccion, other.direccion);
    }
    public enum tipo_usuario {
        Default, Admin, Operador, Instalador
    }

   
    int id;
    String dni, clave, nombre, apellidos, telefono;
    private Enum tipo_usuario;

    @Override
    public String toString() {
        return "usuario{" + "id=" + id + ", dni=" + dni + ", clave=" + clave + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", tipo_usuario=" + tipo_usuario + ", direccion=" + direccion + '}';
    }
    direccion direccion;

    public usuario(String clave, String dni) {
        this.clave = clave;
        this.dni = dni;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Enum getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(Enum tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(direccion direccion) {
        this.direccion = direccion;
    }

    public usuario() {
    }
}
