/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.administrador;

import com.formdev.flatlaf.FlatDarkLaf;
import controlador.UsuarioDao;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Negocio;
import modelo.Usuario;

/**
 *
 * @author jmcbg
 */
public class VentanaAdministrador extends javax.swing.JFrame {

    Usuario administrador;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaAdministrador(Usuario user) {
        administrador = user;
        initComponents();
        actualizarVentana();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAdministrador = new javax.swing.JPanel();
        labelNombreAdmin = new javax.swing.JLabel();
        labelBienvenido = new javax.swing.JLabel();
        labelInfo = new javax.swing.JLabel();
        barraSuperior = new javax.swing.JMenuBar();
        menuCuenta = new javax.swing.JMenu();
        modificarMenuItem = new javax.swing.JMenuItem();
        menuOperaciones = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(451, 192));

        labelNombreAdmin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNombreAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNombreAdmin.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        labelBienvenido.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        labelBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBienvenido.setText("Bienvenido administrador:");
        labelBienvenido.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelInfo.setText("En la barra superior encontraras las distintas opciones que puedes realizar");

        javax.swing.GroupLayout panelAdministradorLayout = new javax.swing.GroupLayout(panelAdministrador);
        panelAdministrador.setLayout(panelAdministradorLayout);
        panelAdministradorLayout.setHorizontalGroup(
            panelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdministradorLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(labelBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
            .addGroup(panelAdministradorLayout.createSequentialGroup()
                .addGroup(panelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAdministradorLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(labelNombreAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAdministradorLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(labelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panelAdministradorLayout.setVerticalGroup(
            panelAdministradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdministradorLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(labelBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNombreAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(labelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menuCuenta.setText("Mi Cuenta");

        modificarMenuItem.setText("Modificar Datos");
        modificarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarMenuItemActionPerformed(evt);
            }
        });
        menuCuenta.add(modificarMenuItem);

        barraSuperior.add(menuCuenta);

        menuOperaciones.setText("Operaciones");

        jMenuItem2.setText("Nuevo Mercader");
        menuOperaciones.add(jMenuItem2);

        jMenuItem3.setText("Nuevo Administrador");
        menuOperaciones.add(jMenuItem3);

        barraSuperior.add(menuOperaciones);

        setJMenuBar(barraSuperior);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAdministrador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAdministrador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void modificarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarMenuItemActionPerformed
        DialogoModificarDatosAdmin dmod = new DialogoModificarDatosAdmin(this, true, administrador);
        dmod.setVisible(true);
        
        //if(!dmod.isVisible()){
        administrador = dmod.getAdmin();
        actualizarVentana();
        //}
        
    }//GEN-LAST:event_modificarMenuItemActionPerformed

    private void actualizarVentana(){
    administrador = UsuarioDao.obtenerDatosUsuario(administrador);
    labelNombreAdmin.setName(administrador.getNombre());
    
    }
    
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatDarkLaf());

        } catch (UnsupportedLookAndFeelException ex) {

        }
        Usuario user = new Usuario(99, "Pruebas","Hernandez", "54332653Y", "pruebas@pruebas", "123456789", "mercader", 0, "0");
        new VentanaAdministrador(user).setVisible(true);
//        if (conex.testConexion()) {
//            new Login().setVisible(true);
//        } else {
//            showMessageDialog(null, "ERROR DE CONEXION CON EL SERVIDOR", "LOGIN", JOptionPane.ERROR_MESSAGE);
//            System.exit(0);
//        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraSuperior;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JLabel labelBienvenido;
    private javax.swing.JLabel labelInfo;
    private javax.swing.JLabel labelNombreAdmin;
    private javax.swing.JMenu menuCuenta;
    private javax.swing.JMenu menuOperaciones;
    private javax.swing.JMenuItem modificarMenuItem;
    private javax.swing.JPanel panelAdministrador;
    // End of variables declaration//GEN-END:variables
}
