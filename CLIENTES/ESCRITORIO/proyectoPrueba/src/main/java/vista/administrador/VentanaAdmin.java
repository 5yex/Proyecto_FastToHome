/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.administrador;

import com.formdev.flatlaf.FlatLightLaf;
import controlador.NegocioDao;
import controlador.UsuarioDao;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import modelo.Negocio;
import modelo.Usuario;
import vista.DialogoImagen;

/**
 *
 * @author jmcbg
 */
public class VentanaAdmin extends javax.swing.JFrame {

    private Usuario administrador;
    private ArrayList<Usuario> arrayListClientes;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaAdmin(Usuario user) {
        this.administrador = user;
        initComponents();
        recargarTablaClientes(UsuarioDao.obtenerDatosClientes());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        itemMercader = new javax.swing.JMenuItem();
        itemAdministrador = new javax.swing.JMenuItem();
        panelTableado = new javax.swing.JTabbedPane();
        panelInicioAdmin = new javax.swing.JPanel();
        labelBienvenido = new javax.swing.JLabel();
        labelNombreAdmin = new javax.swing.JLabel();
        botonModificarDatosAdmin = new javax.swing.JButton();
        panelTablaClientes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();

        itemMercader.setText("Hacer mercader a este usuario");
        itemMercader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMercaderActionPerformed(evt);
            }
        });
        jPopupMenu1.add(itemMercader);

        itemAdministrador.setText("Dar permisos de administración");
        itemAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAdministradorActionPerformed(evt);
            }
        });
        jPopupMenu1.add(itemAdministrador);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Mercader");
        setResizable(false);

        panelTableado.setBackground(new java.awt.Color(255, 102, 0));
        panelTableado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        labelBienvenido.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        labelBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelBienvenido.setText("Bienvenido administrador:");
        labelBienvenido.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelNombreAdmin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNombreAdmin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        botonModificarDatosAdmin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botonModificarDatosAdmin.setText("MODIFICAR DATOS CUENTA");
        botonModificarDatosAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarDatosAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInicioAdminLayout = new javax.swing.GroupLayout(panelInicioAdmin);
        panelInicioAdmin.setLayout(panelInicioAdminLayout);
        panelInicioAdminLayout.setHorizontalGroup(
            panelInicioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioAdminLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(labelBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelNombreAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonModificarDatosAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        panelInicioAdminLayout.setVerticalGroup(
            panelInicioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioAdminLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(panelInicioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombreAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                .addComponent(botonModificarDatosAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        panelTableado.addTab("INICIO", panelInicioAdmin);

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaClientes.setComponentPopupMenu(jPopupMenu1);
        jScrollPane2.setViewportView(tablaClientes);

        javax.swing.GroupLayout panelTablaClientesLayout = new javax.swing.GroupLayout(panelTablaClientes);
        panelTablaClientes.setLayout(panelTablaClientesLayout);
        panelTablaClientesLayout.setHorizontalGroup(
            panelTablaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaClientesLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelTablaClientesLayout.setVerticalGroup(
            panelTablaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaClientesLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panelTableado.addTab("CLIENTES", panelTablaClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTableado)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTableado)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonModificarDatosAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarDatosAdminActionPerformed
        DialogoModificarDatosAdmin dmod = new DialogoModificarDatosAdmin(this, true, administrador);
        dmod.setVisible(true);

        if (!dmod.isVisible()) {
            administrador = dmod.getAdmin();
            actualizarVentana();
        }
    }//GEN-LAST:event_botonModificarDatosAdminActionPerformed

    private void itemMercaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMercaderActionPerformed
        //hacerMecader
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (UsuarioDao.asignarRolMercader(new Usuario(arrayListClientes.get(filaSeleccionada).getId()))) {
            recargarTablaClientes(UsuarioDao.obtenerDatosClientes());
            this.revalidate();
            this.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al asignar como mercader a este usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_itemMercaderActionPerformed

    private void itemAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAdministradorActionPerformed
        //hacerAdmin
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (UsuarioDao.asignarRolAdministrador(new Usuario(arrayListClientes.get(filaSeleccionada).getId()))) {
            recargarTablaClientes(UsuarioDao.obtenerDatosClientes());
        } else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al asignar como administrador a este usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_itemAdministradorActionPerformed

    private void actualizarVentana() {
        administrador = UsuarioDao.obtenerDatosUsuario(administrador);
        labelNombreAdmin.setText(administrador.getNombre());
    }

    public void recargarTablaClientes(ArrayList<Usuario> listaClientes) {
        arrayListClientes = listaClientes;
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
                null,
                new String[]{
                    "ID", "DNI", "EMAIL", "NOMBRE", "TELÉFONO"
                }
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        //tablaClientes.getColumnModel().getColumn(0).setMaxWidth(60);
        //tablaClientes.getColumnModel().getColumn(2).setMinWidth(100);
        tablaClientes.setAutoCreateRowSorter(true);
        for (Usuario cliente : listaClientes) {
            DefaultTableModel model = (DefaultTableModel) tablaClientes.getModel();
            model.addRow(cliente.getRow());
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(new FlatLightLaf());

                    break;
                }
            }
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogoImagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        new VentanaAdmin(null).setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonModificarDatosAdmin;
    private javax.swing.JMenuItem itemAdministrador;
    private javax.swing.JMenuItem itemMercader;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelBienvenido;
    private javax.swing.JLabel labelNombreAdmin;
    private javax.swing.JPanel panelInicioAdmin;
    private javax.swing.JPanel panelTablaClientes;
    private javax.swing.JTabbedPane panelTableado;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables

}
