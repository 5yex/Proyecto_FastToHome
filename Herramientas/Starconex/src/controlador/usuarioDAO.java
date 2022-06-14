/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.TrayIcon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.direccion;
import modelo.usuario;

/**
 *
 * @author 5yex
 */
public class usuarioDAO {

    public static boolean validarUsuario(conexion conexion, modelo.usuario temp) {
        Connection conex = conexion.comenzarConexion();
        try {
            //;
            String query = "SELECT * FROM public.usuario where dni like '" + temp.getDni() + "' and clave like '" + temp.getClave() + "'";
            ResultSet result = conex.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery();
            if (!result.first()) {
                //System.out.println("no hay," + temp.getDni() + temp.getClave());
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.terminarConexion();
        }
        return true;
    }

    public static modelo.usuario obtenerUsuarioPricipal(conexion conexion, modelo.usuario usrTemp) {
        Connection conex = conexion.comenzarConexion();
        try {
            //;
            String query = "SELECT id, dni, clave, nombre, apellidos, telefono, "
                    + "(direccion).calle,(direccion).numero,(direccion).bloque, "
                    + "(direccion).piso,(direccion).puerta,(direccion).ciudad, "
                    + "(direccion).provincia,(direccion).coordenadas, tipo "
                    + "FROM usuario "
                    + "where dni "
                    + "like '" + usrTemp.getDni() + "' and clave like '" + usrTemp.getClave() + "'";
            ResultSet rs = conex.createStatement().executeQuery(query);
            while (rs.next()) {
                usrTemp.setId(rs.getInt("id"));
                usrTemp.setDni(rs.getString("dni"));
                usrTemp.setClave(rs.getString("clave"));
                usrTemp.setNombre(rs.getString("nombre"));
                usrTemp.setApellidos(rs.getString("apellidos"));
                usrTemp.setTelefono(rs.getString("telefono"));
                usrTemp.setTipo_usuario(usuario.tipo_usuario.valueOf(rs.getString("tipo")));

                modelo.direccion dirTmp = new direccion();
                dirTmp.setBloque(rs.getString("bloque"));
                dirTmp.setCalle(rs.getString("calle"));
                dirTmp.setCiudad(rs.getString("ciudad"));
                dirTmp.setCoordenadas(rs.getString("coordenadas"));
                dirTmp.setNumero(rs.getString("numero"));
                dirTmp.setPiso(rs.getString("piso"));
                dirTmp.setProvincia(rs.getString("provincia"));
                dirTmp.setPuerta(rs.getString("puerta"));
                usrTemp.setDireccion(dirTmp);

            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.err.println(usrTemp.toString());
            conexion.terminarConexion();
        }
        return usrTemp;
    }

    public static ArrayList<modelo.usuario> obtenerTodosLosUsuario(conexion conexion) {
        Connection conex = conexion.comenzarConexion();
        ArrayList<modelo.usuario> usuarios = new ArrayList<>();
        try {
            //;
            String query = "SELECT id, dni, clave, nombre, apellidos, telefono, "
                    + "(direccion).calle,(direccion).numero,(direccion).bloque, "
                    + "(direccion).piso,(direccion).puerta,(direccion).ciudad, "
                    + "(direccion).provincia,(direccion).coordenadas, tipo "
                    + "FROM usuario ";

            ResultSet rs = conex.createStatement().executeQuery(query);
            while (rs.next()) {
                usuario usrTemp = new usuario();
                usrTemp.setId(rs.getInt("id"));
                usrTemp.setDni(rs.getString("dni"));
                usrTemp.setClave(rs.getString("clave"));
                usrTemp.setNombre(rs.getString("nombre"));
                usrTemp.setApellidos(rs.getString("apellidos"));
                usrTemp.setTelefono(rs.getString("telefono"));
                usrTemp.setTipo_usuario(usuario.tipo_usuario.valueOf(rs.getString("tipo")));

                modelo.direccion dirTmp = new direccion();
                dirTmp.setBloque(rs.getString("bloque"));
                dirTmp.setCalle(rs.getString("calle"));
                dirTmp.setCiudad(rs.getString("ciudad"));
                dirTmp.setCoordenadas(rs.getString("coordenadas"));
                dirTmp.setNumero(rs.getString("numero"));
                dirTmp.setPiso(rs.getString("piso"));
                dirTmp.setProvincia(rs.getString("provincia"));
                dirTmp.setPuerta(rs.getString("puerta"));
                usrTemp.setDireccion(dirTmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(usuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conexion.terminarConexion();
        }
        return usuarios;
    }

    public static boolean editarUsuario(conexion conexion, usuario usuarioActual) {
        Connection conex = conexion.comenzarConexion();
        try {
            //;
            String query = "UPDATE usuario SET nombre=?, apellidos=?, telefono=?, direccion=" + usuarioActual.getDireccion().toString() + " WHERE dni = ?;";

            PreparedStatement preparedStatement = conex.prepareStatement(query);
            preparedStatement.setString(1, usuarioActual.getNombre());
            preparedStatement.setString(2, usuarioActual.getApellidos());
            preparedStatement.setString(3, usuarioActual.getTelefono());
            preparedStatement.setString(4, usuarioActual.getDni());
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

    public static boolean nuevoUsuario(conexion conexion, usuario usuarioNuevo) {
        Connection conex = conexion.comenzarConexion();
        try {
            //;
            String query = "INSERT INTO usuario(dni, clave, nombre, apellidos, telefono, direccion, tipo) VALUES (?,?,?,?,?,row('','','','','','','',''),'Default');";

            PreparedStatement preparedStatement = conex.prepareStatement(query);
            preparedStatement.setString(1, usuarioNuevo.getDni());
            preparedStatement.setString(2, usuarioNuevo.getClave());
            preparedStatement.setString(3, usuarioNuevo.getNombre());
            preparedStatement.setString(4, usuarioNuevo.getApellidos());
            preparedStatement.setString(5, usuarioNuevo.getTelefono());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.getMessage();

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error al crear el nuevo usuario", JOptionPane.ERROR_MESSAGE);

            return false;
        } finally {
            conexion.terminarConexion();
        }
        return true;
    }

}
