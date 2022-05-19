/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.administrador;

import controlador.NegocioDao;
import controlador.UsuarioDao;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JMenu;
import modelo.Negocio;
import modelo.Usuario;

/**
 *
 * @author jmcbg
 */
public class VentanaAdmin extends javax.swing.JFrame {

    private Usuario usuario;

   

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaAdmin(Usuario user) {
        usuario = user;
        initComponents();
        cargarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonesMenu = new javax.swing.ButtonGroup();
        filtros = new javax.swing.ButtonGroup();
        contenido = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        radioTodos = new javax.swing.JRadioButton();
        radioClientes = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        botonInfo = new javax.swing.JMenu();
        botonProductos = new javax.swing.JMenu();
        botonOpciones = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Mercader");
        setResizable(false);

        tabla.setAutoCreateRowSorter(true);
        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla.setShowGrid(false);
        jScrollPane1.setViewportView(tabla);

        filtros.add(radioTodos);
        radioTodos.setSelected(true);
        radioTodos.setText("Todos");
        radioTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioTodosActionPerformed(evt);
            }
        });

        filtros.add(radioClientes);
        radioClientes.setText("Clientes");
        radioClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioClientesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radioTodos, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addGap(524, 524, 524))
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(radioClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 102, 0));

        botonInfo.setBackground(new java.awt.Color(255, 102, 0));
        botonInfo.setForeground(new java.awt.Color(255, 255, 255));
        botonInfo.setText("INICIO");
        botonesMenu.add(botonInfo);
        botonInfo.setDoubleBuffered(true);
        botonInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deselección(evt);
            }
        });
        jMenuBar1.add(botonInfo);

        botonProductos.setBackground(new java.awt.Color(255, 102, 0));
        botonProductos.setForeground(new java.awt.Color(255, 255, 255));
        botonProductos.setText("USUARIOS");
        botonesMenu.add(botonProductos);
        botonProductos.setDoubleBuffered(true);
        botonProductos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deselección(evt);
            }
        });
        jMenuBar1.add(botonProductos);

        botonOpciones.setText("NEGOCIOS");
        botonesMenu.add(botonOpciones);
        botonOpciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonOpciones.setDoubleBuffered(true);
        botonOpciones.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonOpciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deselección(evt);
            }
        });
        jMenuBar1.add(botonOpciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deselección(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deselección
       JMenu jm = (JMenu) evt.getComponent();
       jm.setSelected(false);
    }//GEN-LAST:event_deselección

    private void radioTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioTodosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioTodosActionPerformed

    private void radioClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioClientesActionPerformed

 
   
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu botonInfo;
    private javax.swing.JMenu botonOpciones;
    private javax.swing.JMenu botonProductos;
    private javax.swing.ButtonGroup botonesMenu;
    private javax.swing.JPanel contenido;
    private javax.swing.ButtonGroup filtros;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioClientes;
    private javax.swing.JRadioButton radioTodos;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

    private void cargarDatos() {
      ArrayList<Usuario>  users =  UsuarioDao.seleccionUsuarios();
        
    }
}
