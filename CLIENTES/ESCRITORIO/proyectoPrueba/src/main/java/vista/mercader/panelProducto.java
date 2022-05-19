/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.mercader;

import modelo.Producto;

/**
 *
 * @author jmcbg
 */
public class panelProducto extends javax.swing.JPanel {
    private Producto producto;
    /**
     * Creates new form producto
     */
    public panelProducto(Producto prod) {
        initComponents();
        producto = prod;
        mostrarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreProducto = new javax.swing.JLabel();
        imgProducto = new javax.swing.JLabel();
        botonEliminarProducto = new javax.swing.JButton();
        botonEditarProducto = new javax.swing.JButton();

        nombreProducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nombreProducto.setText("TITULO PRODUCTO");

        imgProducto.setBackground(new java.awt.Color(204, 204, 255));
        imgProducto.setText("IMAGEN PRODUCTO");
        imgProducto.setOpaque(true);

        botonEliminarProducto.setText("DEL");
        botonEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarProductoActionPerformed(evt);
            }
        });

        botonEditarProducto.setText("EDIT");
        botonEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(imgProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonEliminarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(botonEditarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEliminarProductoActionPerformed

    private void botonEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEditarProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEditarProducto;
    private javax.swing.JButton botonEliminarProducto;
    private javax.swing.JLabel imgProducto;
    private javax.swing.JLabel nombreProducto;
    // End of variables declaration//GEN-END:variables

    private void mostrarDatos() {
        nombreProducto.setText(producto.getNombre());
        
    }
}
