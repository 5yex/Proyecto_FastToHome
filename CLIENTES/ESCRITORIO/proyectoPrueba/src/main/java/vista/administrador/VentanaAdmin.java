/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.administrador;

import com.formdev.flatlaf.FlatLightLaf;
import controlador.NegocioDao;
import controlador.UsuarioDao;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import modelo.Negocio;
import modelo.Usuario;
import vista.DialogoImagen;
import vista.FrameLogin;

/**
 *
 * @author jmcbg
 */
public class VentanaAdmin extends javax.swing.JFrame {

    private Usuario administrador;
    private ArrayList<Usuario> arrayListClientes;
    private ArrayList<Usuario> arrayListAdmins;
    private ArrayList<Usuario> arrayListMercaderes;



    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaAdmin(Usuario user) {
        this.administrador = user;
        initComponents();
        actualizarVentana();
        recargarTablaClientes();
        recargarTablaMercaderes();
        recargarTablaAdmins();


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popUpClientes = new javax.swing.JPopupMenu();
        itemMercader = new javax.swing.JMenuItem();
        itemAdministrador = new javax.swing.JMenuItem();
        popUpAdministrador = new javax.swing.JPopupMenu();
        itemDegradarACliente = new javax.swing.JMenuItem();
        popUpMercaderes = new javax.swing.JPopupMenu();
        itemDegradarAClienteMercader = new javax.swing.JMenuItem();
        panelTableado = new javax.swing.JTabbedPane();
        panelInicioAdmin = new javax.swing.JPanel();
        labelBienvenido = new javax.swing.JLabel();
        labelNombreAdmin = new javax.swing.JLabel();
        botonModificarDatosAdmin = new javax.swing.JButton();
        panelTablaClientes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        busquedaClientes = new javax.swing.JTextField();
        checkBusquedaClientes = new javax.swing.JCheckBox();
        recargarClientes = new javax.swing.JButton();
        panelTablaMercaderes = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaMercaderes = new javax.swing.JTable();
        busquedaMercaderes = new javax.swing.JTextField();
        checkBusquedaMercaderes = new javax.swing.JCheckBox();
        recargarMercaderes = new javax.swing.JButton();
        panelTablaAdmins = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaAdmins = new javax.swing.JTable();
        busquedaAdmins = new javax.swing.JTextField();
        checkBusquedaAdmins = new javax.swing.JCheckBox();
        recargarAdmins = new javax.swing.JButton();

        itemMercader.setText("Hacer mercader a este usuario");
        itemMercader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMercaderActionPerformed(evt);
            }
        });
        popUpClientes.add(itemMercader);

        itemAdministrador.setText("Dar permisos de administración");
        itemAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAdministradorActionPerformed(evt);
            }
        });
        popUpClientes.add(itemAdministrador);

        itemDegradarACliente.setText("Degradar a cliente");
        itemDegradarACliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDegradarAClienteActionPerformed(evt);
            }
        });
        popUpAdministrador.add(itemDegradarACliente);

        itemDegradarAClienteMercader.setText("Degradar a cliente");
        itemDegradarAClienteMercader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDegradarAClienteMercaderActionPerformed(evt);
            }
        });
        popUpMercaderes.add(itemDegradarAClienteMercader);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Mercader");
        setResizable(false);

        panelTableado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelTableado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelTableadoMousePressed(evt);
            }
        });

        labelBienvenido.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        labelBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelBienvenido.setText("Bienvenido administrador:");
        labelBienvenido.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelNombreAdmin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNombreAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonModificarDatosAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        panelInicioAdminLayout.setVerticalGroup(
            panelInicioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInicioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombreAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
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
        tablaClientes.setComponentPopupMenu(popUpClientes);
        jScrollPane2.setViewportView(tablaClientes);

        busquedaClientes.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(checkBusquedaClientes.isSelected())recargarTablaClientes(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(checkBusquedaClientes.isSelected())recargarTablaClientes(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(checkBusquedaClientes.isSelected())recargarTablaClientes(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

            }
        });

        checkBusquedaClientes.setText("Búsqueda por nombre:");
        checkBusquedaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBusquedaClientesActionPerformed(evt);
            }
        });

        recargarClientes.setText("RECARGAR");

        javax.swing.GroupLayout panelTablaClientesLayout = new javax.swing.GroupLayout(panelTablaClientes);
        panelTablaClientes.setLayout(panelTablaClientesLayout);
        panelTablaClientesLayout.setHorizontalGroup(
            panelTablaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(panelTablaClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBusquedaClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(busquedaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recargarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTablaClientesLayout.setVerticalGroup(
            panelTablaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaClientesLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTablaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(busquedaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recargarClientes)
                    .addComponent(checkBusquedaClientes))
                .addContainerGap())
        );

        panelTableado.addTab("CLIENTES", panelTablaClientes);

        tablaMercaderes.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaMercaderes.setComponentPopupMenu(popUpMercaderes);
        jScrollPane4.setViewportView(tablaMercaderes);

        busquedaMercaderes.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(checkBusquedaMercaderes.isSelected())recargarTablaMercaderes(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(checkBusquedaMercaderes.isSelected())recargarTablaMercaderes(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(checkBusquedaMercaderes.isSelected())recargarTablaMercaderes(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

            }
        });

        checkBusquedaMercaderes.setText("Búsqueda por nombre:");
        checkBusquedaMercaderes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBusquedaMercaderesActionPerformed(evt);
            }
        });

        recargarMercaderes.setText("RECARGAR");
        recargarMercaderes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recargarMercaderesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTablaMercaderesLayout = new javax.swing.GroupLayout(panelTablaMercaderes);
        panelTablaMercaderes.setLayout(panelTablaMercaderesLayout);
        panelTablaMercaderesLayout.setHorizontalGroup(
            panelTablaMercaderesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addGroup(panelTablaMercaderesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBusquedaMercaderes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(busquedaMercaderes, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recargarMercaderes, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTablaMercaderesLayout.setVerticalGroup(
            panelTablaMercaderesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaMercaderesLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTablaMercaderesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(busquedaMercaderes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recargarMercaderes)
                    .addComponent(checkBusquedaMercaderes))
                .addContainerGap())
        );

        panelTableado.addTab("MERCADERES", panelTablaMercaderes);

        tablaAdmins.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaAdmins.setComponentPopupMenu(popUpAdministrador);
        jScrollPane5.setViewportView(tablaAdmins);

        busquedaMercaderes.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(checkBusquedaAdmins.isSelected())recargarTablaAdmins();             }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(checkBusquedaAdmins.isSelected())recargarTablaAdmins();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if(checkBusquedaAdmins.isSelected())recargarTablaAdmins(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

            }
        });

        checkBusquedaAdmins.setText("Búsqueda por nombre:");
        checkBusquedaAdmins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBusquedaAdminsActionPerformed(evt);
            }
        });

        recargarAdmins.setText("RECARGAR");
        recargarAdmins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recargarAdminsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTablaAdminsLayout = new javax.swing.GroupLayout(panelTablaAdmins);
        panelTablaAdmins.setLayout(panelTablaAdminsLayout);
        panelTablaAdminsLayout.setHorizontalGroup(
            panelTablaAdminsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5)
            .addGroup(panelTablaAdminsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBusquedaAdmins)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(busquedaAdmins, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recargarAdmins, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTablaAdminsLayout.setVerticalGroup(
            panelTablaAdminsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaAdminsLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTablaAdminsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(busquedaAdmins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recargarAdmins)
                    .addComponent(checkBusquedaAdmins))
                .addContainerGap())
        );

        panelTableado.addTab("ADMININSTRADORES", panelTablaAdmins);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTableado)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTableado, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
            recargarTablaClientes();
            //this.revalidate();
            //this.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al asignar como mercader a este usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_itemMercaderActionPerformed

    private void itemAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAdministradorActionPerformed
        //hacerAdmin
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (UsuarioDao.asignarRolAdministrador(new Usuario(arrayListClientes.get(filaSeleccionada).getId()))) {
            recargarTablaClientes();
        } else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al asignar como administrador a este usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_itemAdministradorActionPerformed

    private void checkBusquedaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBusquedaClientesActionPerformed
        recargarTablaClientes();
    }//GEN-LAST:event_checkBusquedaClientesActionPerformed

    private void checkBusquedaMercaderesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBusquedaMercaderesActionPerformed
        recargarTablaMercaderes();
    }//GEN-LAST:event_checkBusquedaMercaderesActionPerformed

    private void recargarMercaderesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargarMercaderesActionPerformed
        recargarTablaMercaderes();
    }//GEN-LAST:event_recargarMercaderesActionPerformed

    private void checkBusquedaAdminsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBusquedaAdminsActionPerformed
        recargarTablaAdmins();
    }//GEN-LAST:event_checkBusquedaAdminsActionPerformed

    private void recargarAdminsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargarAdminsActionPerformed
        recargarTablaAdmins();

    }//GEN-LAST:event_recargarAdminsActionPerformed

    private void itemDegradarAClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDegradarAClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemDegradarAClienteActionPerformed

    private void itemDegradarAClienteMercaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDegradarAClienteMercaderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemDegradarAClienteMercaderActionPerformed

    private void panelTableadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTableadoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_panelTableadoMousePressed

    private void actualizarVentana() {
        administrador = UsuarioDao.obtenerDatosUsuario(administrador);
        labelNombreAdmin.setText(administrador.getNombre() + "  " + administrador.getApellidos());
    }

    public void recargarTablaClientes() {
        arrayListClientes = UsuarioDao.seleccionUsuariosClientes();
        if (checkBusquedaClientes.isSelected()) {
            recargarTabla(arrayListClientes, tablaClientes, busquedaClientes.getText());
        } else {
            recargarTabla(arrayListClientes, tablaClientes, null);
        }
    }

    public void recargarTablaMercaderes() {
        if (checkBusquedaMercaderes.isSelected()) {
            recargarTabla(UsuarioDao.seleccionUsuariosMercader(), tablaMercaderes, busquedaMercaderes.getText());
        } else {
            recargarTabla(UsuarioDao.seleccionUsuariosMercader(), tablaMercaderes, null);
        }
    }

    public void recargarTablaAdmins() {
        if (checkBusquedaAdmins.isSelected()) {
            recargarTabla(UsuarioDao.seleccionUsuariosAdmin(), tablaAdmins, busquedaAdmins.getText());
        } else {
            recargarTabla(UsuarioDao.seleccionUsuariosAdmin(), tablaAdmins, null);
        }
    }

    public void recargarTabla(ArrayList<Usuario> listaClientes, JTable tabla, String filtroNombre) {
        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla.setAutoCreateRowSorter(true);
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        //busqueda
        if (filtroNombre != null && !filtroNombre.isBlank()) {
            System.out.println("busqueda");
            for (Usuario cliente : listaClientes) {
                String nombreMayus = (cliente.getNombre() + " " + cliente.getApellidos()).toUpperCase();
                String busquedaMayus = filtroNombre.toUpperCase();
                if (nombreMayus.contains(new StringBuffer(busquedaMayus))) {
                    model.addRow(cliente.getRow());
                }
            }
        } else {
            //Mostrar sin busqueda
            for (Usuario cliente : listaClientes) {
                model.addRow(cliente.getRow());
            }
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

    public void confirmarCierre() {
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    confirmarSalida();
                }
            });
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void confirmarSalida() {
        int valor = JOptionPane.showConfirmDialog(this, "¿Esta seguro de que quiere abandonar esta ventana?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if (valor == JOptionPane.YES_OPTION) {

            JOptionPane.showMessageDialog(null, "Volverá a la ventana de Logueo", "Hasta luego!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new FrameLogin().setVisible(true);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonModificarDatosAdmin;
    private javax.swing.JTextField busquedaAdmins;
    private javax.swing.JTextField busquedaClientes;
    private javax.swing.JTextField busquedaMercaderes;
    private javax.swing.JCheckBox checkBusquedaAdmins;
    private javax.swing.JCheckBox checkBusquedaClientes;
    private javax.swing.JCheckBox checkBusquedaMercaderes;
    private javax.swing.JMenuItem itemAdministrador;
    private javax.swing.JMenuItem itemDegradarACliente;
    private javax.swing.JMenuItem itemDegradarAClienteMercader;
    private javax.swing.JMenuItem itemMercader;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelBienvenido;
    private javax.swing.JLabel labelNombreAdmin;
    private javax.swing.JPanel panelInicioAdmin;
    private javax.swing.JPanel panelTablaAdmins;
    private javax.swing.JPanel panelTablaClientes;
    private javax.swing.JPanel panelTablaMercaderes;
    private javax.swing.JTabbedPane panelTableado;
    private javax.swing.JPopupMenu popUpAdministrador;
    private javax.swing.JPopupMenu popUpClientes;
    private javax.swing.JPopupMenu popUpMercaderes;
    private javax.swing.JButton recargarAdmins;
    private javax.swing.JButton recargarClientes;
    private javax.swing.JButton recargarMercaderes;
    private javax.swing.JTable tablaAdmins;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTable tablaMercaderes;
    // End of variables declaration//GEN-END:variables

}
