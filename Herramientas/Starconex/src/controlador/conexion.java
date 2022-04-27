/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author 5yex
 */
public class conexion {

    private String dominio;
    private String database;
    private String usuario;
    private String pass;
    private Connection conn;

    public Connection comenzarConexion() {
        String url = "jdbc:postgresql://" + dominio + "/" + database;
        try {
            conn = DriverManager.getConnection(url, usuario, pass);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return conn;
    }
    
    public void terminarConexion() {
        try {
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public conexion(String dominio, String database, String usuario, String pass) {
        this.dominio = dominio;
        this.database = database;
        this.usuario = usuario;
        this.pass = pass;
    }

    public boolean testConexion() {
        String url = "jdbc:postgresql://serviex.duckdns.org/starconex";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, "test", "1234");
            System.out.println("Conexion correcta! ");
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error en la conexion!!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
