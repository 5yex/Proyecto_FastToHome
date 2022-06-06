/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.mercader;

import javax.swing.JButton;
import javax.swing.JFrame;
import modelo.Negocio;
import modelo.Producto;

/**
 *
 * @author jmcbg
 */
public class PanelProductoNuevo extends javax.swing.JPanel {
    JButton actualizar;
    Negocio negocio;
    JFrame framePadre;
    /**
     * Creates new form producto
     */
    public PanelProductoNuevo(JFrame parent, JButton actualizar, Negocio negocio) {
        initComponents();
        this.actualizar = actualizar;
        this.negocio = negocio;
        this.framePadre = parent;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonNuevoProducto = new javax.swing.JButton();

        botonNuevoProducto.setBackground(javax.swing.UIManager.getDefaults().getColor("Menu.selectionBackground"));
        botonNuevoProducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botonNuevoProducto.setForeground(new java.awt.Color(255, 255, 255));
        botonNuevoProducto.setText("NUEVO");
        botonNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevoProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(botonNuevoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(botonNuevoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevoProductoActionPerformed
       //new registrarProducto(actualizar,negocio).setVisible(true);
       new DialogoRegistrarProducto(framePadre, actualizar, negocio, true).setVisible(true);
    }//GEN-LAST:event_botonNuevoProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonNuevoProducto;
    // End of variables declaration//GEN-END:variables

   
}
