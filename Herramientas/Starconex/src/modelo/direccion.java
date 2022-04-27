/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author JM
 */
public class direccion {
    String calle,numero,bloque,piso,puerta,ciudad,provincia,coordenadas;

    public direccion(String calle, String numero, String bloque, String piso, String puerta, String ciudad, String provincia, String coordenadas) {
        this.calle = calle;
        this.numero = numero;
        this.bloque = bloque;
        this.piso = piso;
        
        this.puerta = puerta;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.coordenadas = coordenadas;
    }

    @Override
    public String toString() {
        return " row('"+calle+"','"+numero+"','"+bloque+"','"+piso+"','"+puerta+"','"+ciudad+"','"+provincia+"','"+coordenadas+"')";
    }

    public direccion() {
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBloque() {
        return bloque;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getPuerta() {
        return puerta;
    }

    public void setPuerta(String puerta) {
        this.puerta = puerta;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }
    
}
