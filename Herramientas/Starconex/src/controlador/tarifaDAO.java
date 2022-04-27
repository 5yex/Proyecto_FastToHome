/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.contrato;
import modelo.tarifa;
import modelo.usuario;

/**
 *
 * @author JM
 */
public class tarifaDAO {

    public static ArrayList<tarifa> obtenerTarifas(conexion conexion) {
        Connection conex = conexion.comenzarConexion();
        ArrayList<tarifa> array = new ArrayList<>();
        try {
            //;
            String query = "SELECT * FROM tarifa ";
            // + usrTemp.getId();
            ResultSet rs = conex.createStatement().executeQuery(query);
            while (rs.next()) {
                tarifa TTmp = new tarifa(rs.getInt("id"), rs.getInt("Precio"), rs.getBoolean("permanencia"), rs.getString("velocidad"));
                array.add(TTmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.terminarConexion();
        }
        return array;
    }

    public static tarifa obtenerTarifa(conexion conexion, int id_tarifa) {
        Connection conex = conexion.comenzarConexion();
        tarifa TTmp = null;
        try {
            String query = "SELECT * FROM tarifa WHERE id = " + id_tarifa;
            ResultSet rs = conex.createStatement().executeQuery(query);
            rs.next();
            TTmp = new tarifa(rs.getInt("id"), rs.getInt("Precio"), rs.getBoolean("permanencia"), rs.getString("velocidad"));

        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.terminarConexion();
        }
        return TTmp;
    }

    public static tarifa contratarTarifa(conexion conexion, usuario user, tarifa tarifa) {
        Connection conex = conexion.comenzarConexion();
        tarifa TTmp = null;
        try {
            String query = "select nuevoContrato(" + user.getId() + "," + tarifa.getId() + ")";
            conex.createStatement().executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.terminarConexion();
        }
        return TTmp;
    }
}
