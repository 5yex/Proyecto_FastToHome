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
import javax.swing.ImageIcon;
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
 * Clase que representa una ventana de administrador
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 */
public class VentanaAdmin extends javax.swing.JFrame {

    private Usuario administrador;
    private ArrayList<Usuario> arrayListClientes;
    private ArrayList<Usuario> arrayListAdmins;
    private ArrayList<Usuario> arrayListMercaderes;

    /**
     * Construye una VentanaAdmin
     * 
     * @param user Usuario de tipo administrador que ha iniciado sesión
     */
    public VentanaAdmin(Usuario user) {
        this.administrador = user;
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/recursos/logoIcon.png")).getImage());
        actualizarVentana();
        confirmarCierre();
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
        itemClienteAMercader = new javax.swing.JMenuItem();
        itemClienteAAdministrador = new javax.swing.JMenuItem();
        popUpAdministrador = new javax.swing.JPopupMenu();
        itemAdminACliente = new javax.swing.JMenuItem();
        popUpMercaderes = new javax.swing.JPopupMenu();
        itemMercaderACliente = new javax.swing.JMenuItem();
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

        itemClienteAMercader.setText("Hacer mercader a este usuario");
        itemClienteAMercader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemClienteAMercaderActionPerformed(evt);
            }
        });
        popUpClientes.add(itemClienteAMercader);

        itemClienteAAdministrador.setText("Dar permisos de administración");
        itemClienteAAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemClienteAAdministradorActionPerformed(evt);
            }
        });
        popUpClientes.add(itemClienteAAdministrador);

        itemAdminACliente.setText("Degradar a cliente");
        itemAdminACliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAdminAClienteActionPerformed(evt);
            }
        });
        popUpAdministrador.add(itemAdminACliente);

        itemMercaderACliente.setText("Degradar a cliente");
        itemMercaderACliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMercaderAClienteActionPerformed(evt);
            }
        });
        popUpMercaderes.add(itemMercaderACliente);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Administrador");
        setMinimumSize(new java.awt.Dimension(878, 665));

        panelTableado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        labelBienvenido.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labelBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelBienvenido.setText("Bienvenido administrador :");
        labelBienvenido.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelNombreAdmin.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelNombreAdmin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelNombreAdmin.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        botonModificarDatosAdmin.setBackground(new java.awt.Color(240, 87, 66));
        botonModificarDatosAdmin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botonModificarDatosAdmin.setForeground(new java.awt.Color(255, 255, 255));
        botonModificarDatosAdmin.setText("MODIFICA TUS DATOS");
        botonModificarDatosAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarDatosAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInicioAdminLayout = new javax.swing.GroupLayout(panelInicioAdmin);
        panelInicioAdmin.setLayout(panelInicioAdminLayout);
        panelInicioAdminLayout.setHorizontalGroup(
            panelInicioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioAdminLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(labelBienvenido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNombreAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonModificarDatosAdmin)
                .addGap(30, 30, 30))
        );
        panelInicioAdminLayout.setVerticalGroup(
            panelInicioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioAdminLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelInicioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelBienvenido)
                    .addComponent(labelNombreAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 303, Short.MAX_VALUE)
                .addComponent(botonModificarDatosAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
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
        recargarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recargarClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTablaClientesLayout = new javax.swing.GroupLayout(panelTablaClientes);
        panelTablaClientes.setLayout(panelTablaClientesLayout);
        panelTablaClientesLayout.setHorizontalGroup(
            panelTablaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(panelTablaClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBusquedaClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(busquedaClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recargarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTablaClientesLayout.setVerticalGroup(
            panelTablaClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaClientesLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
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
                .addComponent(busquedaMercaderes, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recargarMercaderes, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTablaMercaderesLayout.setVerticalGroup(
            panelTablaMercaderesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaMercaderesLayout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
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
                .addComponent(busquedaAdmins, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recargarAdmins, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTablaAdminsLayout.setVerticalGroup(
            panelTablaAdminsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaAdminsLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTablaAdminsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(busquedaAdmins, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recargarAdmins)
                    .addComponent(checkBusquedaAdmins))
                .addContainerGap())
        );

        panelTableado.addTab("ADMINISTRADORES", panelTablaAdmins);

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
    
    /**
     * Acción de pulsar en el botón de 'MODIFICA TUS DATOS'
     * 
     * @param evt evento
     */
    private void botonModificarDatosAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarDatosAdminActionPerformed
        DialogoActualizarDatos dmod = new DialogoActualizarDatos(this, true, administrador);
        dmod.setVisible(true);

        if (!dmod.isVisible()) {
            administrador = dmod.getUsuario();
            actualizarVentana();
        }
    }//GEN-LAST:event_botonModificarDatosAdminActionPerformed
    
    /**
     * Acción de pulsar en el item 'Hacer mercader a este usuario' del popUpClientes
     * 
     * @param evt evento
     */
    private void itemClienteAMercaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemClienteAMercaderActionPerformed
        //hacerMecader
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (UsuarioDao.asignarRolMercader(new Usuario(arrayListClientes.get(filaSeleccionada).getId()))) {
            JOptionPane.showMessageDialog(this, "Se asignó a este usuario como mercader", "Informe", JOptionPane.INFORMATION_MESSAGE);
            recargarTablaClientes();
            recargarTablaMercaderes();
        } else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al asignar como mercader a este usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_itemClienteAMercaderActionPerformed
    
    /**
     * Acción de pulsar en el item 'Dar permisos de administración' del popUpClientes
     * 
     * @param evt evento
     */
    private void itemClienteAAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemClienteAAdministradorActionPerformed
        //hacerAdmin
        int filaSeleccionada = tablaClientes.getSelectedRow();
        if (UsuarioDao.asignarRolAdministrador(new Usuario(arrayListClientes.get(filaSeleccionada).getId()))) {
            JOptionPane.showMessageDialog(this, "Se asignó a este usuario como administrador", "Informe", JOptionPane.INFORMATION_MESSAGE);
            recargarTablaClientes();
            recargarTablaAdmins();
        } else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al asignar como administrador a este usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_itemClienteAAdministradorActionPerformed
    
    /**
     * Acción de hacer check en el checkbox 'Busqueda por nombre' de la seccion 'CLIENTES' 
     * @param evt evento
     */
    private void checkBusquedaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBusquedaClientesActionPerformed
        recargarTablaClientes();
    }//GEN-LAST:event_checkBusquedaClientesActionPerformed
    
    /**
     * Acción de hacer check en el checkbox 'Busqueda por nombre' de la seccion 'MERCADERES' 
     * @param evt evento
     */
    private void checkBusquedaMercaderesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBusquedaMercaderesActionPerformed
        recargarTablaMercaderes();
    }//GEN-LAST:event_checkBusquedaMercaderesActionPerformed
    
    /**
     * Acción de pulsar en la cabecera de la sección 'MERCADERES'
     * @param evt evento
     */
    private void recargarMercaderesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargarMercaderesActionPerformed
        recargarTablaMercaderes();
    }//GEN-LAST:event_recargarMercaderesActionPerformed
    
    /**
     * Acción de hacer check en el checkbox 'Busqueda por nombre' de la seccion 'ADMINISTRADORES' 
     * @param evt evento
     */
    private void checkBusquedaAdminsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBusquedaAdminsActionPerformed
        recargarTablaAdmins();
    }//GEN-LAST:event_checkBusquedaAdminsActionPerformed
    
    /**
     * Acción de pulsar en la cabecera de la sección 'ADMINISTRADORES'
     * @param evt evento
     */
    private void recargarAdminsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargarAdminsActionPerformed
        recargarTablaAdmins();

    }//GEN-LAST:event_recargarAdminsActionPerformed
    
    /**
     * Acción de pulsar en el item 'Degradar a cliente' del popUpAdministrador
     * 
     * @param evt evento
     */
    private void itemAdminAClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAdminAClienteActionPerformed
        //degradar
        int filaSeleccionada = tablaAdmins.getSelectedRow();
        int id_seleccionado = arrayListAdmins.get(filaSeleccionada).getId();

        if (id_seleccionado != administrador.getId()) {
            if (UsuarioDao.asignarRolCliente(new Usuario(id_seleccionado))) {
                JOptionPane.showMessageDialog(this, "Se degradó este admistrador a cliente", "Informe", JOptionPane.INFORMATION_MESSAGE);
                recargarTablaAdmins();
                recargarTablaClientes();
            } else {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error al degradar a cliente a este usuario", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No puedes degradarte a ti mismo", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_itemAdminAClienteActionPerformed
    
    /**
     * Acción de pulsar en el item 'Degradar a cliente' del popUpMercaderes
     * 
     * @param evt evento
     */
    private void itemMercaderAClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMercaderAClienteActionPerformed
        //degradar
        int filaSeleccionada = tablaMercaderes.getSelectedRow();
        if (UsuarioDao.asignarRolCliente(new Usuario(arrayListMercaderes.get(filaSeleccionada).getId()))) {
            JOptionPane.showMessageDialog(this, "Se degradó este mercader a cliente", "Informe", JOptionPane.INFORMATION_MESSAGE);
            recargarTablaClientes();
            recargarTablaMercaderes();
        } else {
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error al degradar a cliente a este usuario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_itemMercaderAClienteActionPerformed
    
    /**
     * Acción de pulsar en la cabecera de la sección 'CLIENTES'
     * @param evt evento
     */
    private void recargarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargarClientesActionPerformed
        recargarTablaClientes();
        recargarTablaMercaderes();
        recargarTablaAdmins();
    }//GEN-LAST:event_recargarClientesActionPerformed
    
    /**
     * Actualiza la ventana de administrador
     */
    private void actualizarVentana() {
        administrador = UsuarioDao.obtenerDatosUsuario(administrador);
        labelNombreAdmin.setText(administrador.getNombre() + " " + administrador.getApellidos());
        
        recargarTablaClientes();
        recargarTablaMercaderes();
        recargarTablaAdmins();
    }
    
    /**
     * Recarga la información de las tabla con la información de los clientes
     */
    public void recargarTablaClientes() {
        arrayListClientes = UsuarioDao.seleccionUsuariosClientes();
        if (checkBusquedaClientes.isSelected()) {
            recargarTabla(arrayListClientes, tablaClientes, busquedaClientes.getText());
        } else {
            recargarTabla(arrayListClientes, tablaClientes, null);
        }
    }
    
    /**
     * Recarga la información de las tabla con la información de los mercaderes
     */
    public void recargarTablaMercaderes() {
        arrayListMercaderes = UsuarioDao.seleccionUsuariosMercader();
        if (checkBusquedaMercaderes.isSelected()) {
            recargarTabla(arrayListMercaderes, tablaMercaderes, busquedaMercaderes.getText());
        } else {
            recargarTabla(arrayListMercaderes, tablaMercaderes, null);
        }
    }

    public void recargarTablaAdmins() {
        arrayListAdmins = UsuarioDao.seleccionUsuariosAdmin();
        if (checkBusquedaAdmins.isSelected()) {
            recargarTabla(arrayListAdmins, tablaAdmins, busquedaAdmins.getText());
        } else {
            recargarTabla(arrayListAdmins, tablaAdmins, null);
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
    private void confirmarCierre() {
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
        Object[] options = {"Si","No"};
        
        int valor = JOptionPane.showOptionDialog(this,"¿Esta seguro de que quiere abandonar esta ventana?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,options, options[0]);
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
    private javax.swing.JMenuItem itemAdminACliente;
    private javax.swing.JMenuItem itemClienteAAdministrador;
    private javax.swing.JMenuItem itemClienteAMercader;
    private javax.swing.JMenuItem itemMercaderACliente;
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
