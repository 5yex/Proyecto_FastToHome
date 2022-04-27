/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.contrato;
import modelo.usuario;

/**
 *
 * @author JM
 */
public class contratosDAO {

    public static ArrayList<contrato> obtenerContratos(conexion conexion, modelo.usuario usrTemp) {
        Connection conex = conexion.comenzarConexion();
        ArrayList<contrato> array = new ArrayList<>();
        try {
            //;
            String query = "SELECT id, id_tarifa, fecha, en_vigor, estado_servicio "
                    + "FROM contrato "
                    + "where id_usuario = "
                    + usrTemp.getId();
            ResultSet rs = conex.createStatement().executeQuery(query);
            while (rs.next()) {
                contrato contratoTmp = new contrato();
                contratoTmp.setId(rs.getInt("id"));
                contratoTmp.setId_tarifa(rs.getInt("id_tarifa"));
                contratoTmp.setFecha(rs.getDate("fecha"));
                contratoTmp.setEn_vigor(rs.getBoolean("en_vigor"));
                contratoTmp.setEstado_servicio(contrato.estado_servicio.valueOf(rs.getString("estado_servicio")));                           
                array.add(contratoTmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            System.err.println(usrTemp.toString());
            conexion.terminarConexion();
        }
        return array;
    }
    
    
    public static boolean baja(conexion conexion, int id_contrato) {
        Connection conex = conexion.comenzarConexion();
        try {
            String query = "UPDATE contrato SET en_vigor = false WHERE id = "+id_contrato ;
            PreparedStatement preparedStatement = conex.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.getMessage();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            
            return false;
        } finally {
            conexion.terminarConexion();
        }
        return true;
    }
    
}
