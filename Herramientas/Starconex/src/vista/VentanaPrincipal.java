/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.formdev.flatlaf.FlatDarkLaf;
import controlador.conexion;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.usuario;
import utilidades.WrapLayout;
import vista.paneles.contratosUsuario;
import vista.paneles.direccionUsuario;
import vista.paneles.informacionUsuario;
import vista.paneles.tarifasUsuarios;

/**
 *
 * @author 5yex
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    private modelo.usuario usuarioActual;
    private conexion conex;

    VentanaPrincipal(usuario userTMP, conexion conex) {
        this.usuarioActual = userTMP;
        this.conex = conex;
        initComponents();
        comprobarTipoUsuario();
        userNombre.setText(usuarioActual.getNombre() + " " + usuarioActual.getApellidos());
        cargarTODO();
    }

    public usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton10 = new javax.swing.JButton();
        panelOpciones = new javax.swing.JTabbedPane();
        opcionesPrincipales = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userNombre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        USUARIO = new javax.swing.JScrollPane();
        panelBaseUsuario = new javax.swing.JPanel();
        INSTALADOR = new javax.swing.JScrollPane();
        panelBaseInstalador = new javax.swing.JPanel();
        OPERADOR = new javax.swing.JScrollPane();
        panelBaseOperador = new javax.swing.JPanel();

        jButton10.setText("jButton10");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("STARCONEX GESTI??N");
        setLocationByPlatform(true);
        setMaximumSize(null);
        setMinimumSize(null);
        setName(""); // NOI18N

        panelOpciones.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        panelOpciones.setMaximumSize(null);
        panelOpciones.setName(""); // NOI18N
        panelOpciones.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                panelOpcionesFocusGained(evt);
            }
        });
        panelOpciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelOpcionesMouseClicked(evt);
            }
        });

        opcionesPrincipales.setBackground(new java.awt.Color(204, 204, 255));
        opcionesPrincipales.setMaximumSize(null);
        opcionesPrincipales.setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenid@!");

        userNombre.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        userNombre.setForeground(new java.awt.Color(255, 255, 255));
        userNombre.setText("nombre");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/logo.png"))); // NOI18N
        jLabel2.setToolTipText("");

        javax.swing.GroupLayout opcionesPrincipalesLayout = new javax.swing.GroupLayout(opcionesPrincipales);
        opcionesPrincipales.setLayout(opcionesPrincipalesLayout);
        opcionesPrincipalesLayout.setHorizontalGroup(
            opcionesPrincipalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesPrincipalesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(opcionesPrincipalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, opcionesPrincipalesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        opcionesPrincipalesLayout.setVerticalGroup(
            opcionesPrincipalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesPrincipalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        panelOpciones.addTab("INFO", opcionesPrincipales);

        USUARIO.setBorder(null);
        USUARIO.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        USUARIO.setMaximumSize(null);
        USUARIO.setMinimumSize(null);
        USUARIO.setName(""); // NOI18N

        panelBaseUsuario.setMaximumSize(new java.awt.Dimension(10000000, 10000000));
        panelBaseUsuario.setMinimumSize(new java.awt.Dimension(700, 500));
        panelBaseUsuario.setOpaque(false);

        javax.swing.GroupLayout panelBaseUsuarioLayout = new javax.swing.GroupLayout(panelBaseUsuario);
        panelBaseUsuario.setLayout(panelBaseUsuarioLayout);
        panelBaseUsuarioLayout.setHorizontalGroup(
            panelBaseUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        panelBaseUsuarioLayout.setVerticalGroup(
            panelBaseUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1166, Short.MAX_VALUE)
        );

        USUARIO.setViewportView(panelBaseUsuario);

        panelOpciones.addTab("USUARIO", USUARIO);

        INSTALADOR.setBorder(null);
        INSTALADOR.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        INSTALADOR.setMaximumSize(null);
        INSTALADOR.setMinimumSize(null);
        INSTALADOR.setName(""); // NOI18N

        panelBaseInstalador.setMaximumSize(new java.awt.Dimension(10000000, 10000000));
        panelBaseInstalador.setMinimumSize(new java.awt.Dimension(700, 500));
        panelBaseInstalador.setOpaque(false);

        javax.swing.GroupLayout panelBaseInstaladorLayout = new javax.swing.GroupLayout(panelBaseInstalador);
        panelBaseInstalador.setLayout(panelBaseInstaladorLayout);
        panelBaseInstaladorLayout.setHorizontalGroup(
            panelBaseInstaladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        panelBaseInstaladorLayout.setVerticalGroup(
            panelBaseInstaladorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1166, Short.MAX_VALUE)
        );

        INSTALADOR.setViewportView(panelBaseInstalador);

        panelOpciones.addTab("INSTALADOR", INSTALADOR);

        OPERADOR.setBorder(null);
        OPERADOR.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        OPERADOR.setMaximumSize(null);
        OPERADOR.setMinimumSize(null);
        OPERADOR.setName(""); // NOI18N

        panelBaseOperador.setMaximumSize(new java.awt.Dimension(10000000, 10000000));
        panelBaseOperador.setMinimumSize(new java.awt.Dimension(700, 500));
        panelBaseOperador.setOpaque(false);

        javax.swing.GroupLayout panelBaseOperadorLayout = new javax.swing.GroupLayout(panelBaseOperador);
        panelBaseOperador.setLayout(panelBaseOperadorLayout);
        panelBaseOperadorLayout.setHorizontalGroup(
            panelBaseOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 875, Short.MAX_VALUE)
        );
        panelBaseOperadorLayout.setVerticalGroup(
            panelBaseOperadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1166, Short.MAX_VALUE)
        );

        OPERADOR.setViewportView(panelBaseOperador);

        panelOpciones.addTab("OPERADOR", OPERADOR);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void panelOpcionesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_panelOpcionesFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_panelOpcionesFocusGained

    private void panelOpcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelOpcionesMouseClicked
        cargarTODO();
    }//GEN-LAST:event_panelOpcionesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane INSTALADOR;
    private javax.swing.JScrollPane OPERADOR;
    private javax.swing.JScrollPane USUARIO;
    private javax.swing.JButton jButton10;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel opcionesPrincipales;
    private javax.swing.JPanel panelBaseInstalador;
    private javax.swing.JPanel panelBaseOperador;
    private javax.swing.JPanel panelBaseUsuario;
    private javax.swing.JTabbedPane panelOpciones;
    private javax.swing.JLabel userNombre;
    // End of variables declaration//GEN-END:variables

    private void cargarTODO() {
        panelBaseUsuario.removeAll();
        panelBaseUsuario.setLayout(new WrapLayout(FlowLayout.CENTER, 30, 30));
        panelBaseUsuario.add(new tarifasUsuarios(usuarioActual, conex));
        panelBaseUsuario.add(new contratosUsuario(usuarioActual, conex));
        panelBaseUsuario.add(new informacionUsuario(usuarioActual, conex));
        panelBaseUsuario.add(new direccionUsuario(usuarioActual, conex));
        panelBaseUsuario.revalidate();
        panelBaseUsuario.repaint();
    }

    private void comprobarTipoUsuario() {
        String tipo = usuarioActual.getTipo_usuario().toString();
        //Default, Admin, Operador, Instalador
        switch (tipo) {
            case "Default":
                panelOpciones.setEnabledAt(1, true);
                panelOpciones.setEnabledAt(2, false);
                panelOpciones.setEnabledAt(3, false);
                break;
            case "Instalador":
                panelOpciones.setEnabledAt(1, true);
                panelOpciones.setEnabledAt(2, true);
                panelOpciones.setEnabledAt(3, false);
                break;
            case "Operador":
                panelOpciones.setEnabledAt(1, true);
                panelOpciones.setEnabledAt(2, false);
                panelOpciones.setEnabledAt(3, true);
                break;
            default:
                panelOpciones.setEnabledAt(1, false);
                panelOpciones.setEnabledAt(2, false);
                panelOpciones.setEnabledAt(3, false);
        }
    }
}
