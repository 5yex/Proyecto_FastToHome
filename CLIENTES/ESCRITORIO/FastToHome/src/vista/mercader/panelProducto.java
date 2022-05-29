/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.mercader;

import com.formdev.flatlaf.ui.FlatButtonBorder;
import controlador.ImagenDao;
import controlador.ProductoDao;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Imagen;
import modelo.Negocio;
import modelo.Producto;
import util.imagenesUtil;

/**
 *
 * @author jmcbg
 */
public class panelProducto extends javax.swing.JPanel {

    private Producto producto;
    JButton btUpdate;

    /**
     * Creates new form producto
     */
    public panelProducto(Producto prod, JButton btUpdate) {
        initComponents();
        this.producto = prod;
        this.btUpdate = btUpdate;
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
        jLabel1 = new javax.swing.JLabel();

        nombreProducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nombreProducto.setText("TITULO PRODUCTO");

        imgProducto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        imgProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgProducto.setText("NO MAGE");
        imgProducto.setMinimumSize(new java.awt.Dimension(155, 155));
        imgProducto.setOpaque(true);
        imgProducto.setPreferredSize(new java.awt.Dimension(155, 155));

        botonEliminarProducto.setPreferredSize(new java.awt.Dimension(45, 45));
        botonEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarProductoActionPerformed(evt);
            }
        });

        botonEditarProducto.setPreferredSize(new java.awt.Dimension(45, 45));
        botonEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarProductoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(imgProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarProductoActionPerformed
        eliminarProducto();
    }//GEN-LAST:event_botonEliminarProductoActionPerformed

    private void botonEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarProductoActionPerformed
        editarProducto();
    }//GEN-LAST:event_botonEditarProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEditarProducto;
    private javax.swing.JButton botonEliminarProducto;
    private javax.swing.JLabel imgProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nombreProducto;
    // End of variables declaration//GEN-END:variables

    private void mostrarDatos() {
        nombreProducto.setText(producto.getNombre());

        new Thread(new Runnable() {
            @Override
            public void run() {
                imagenesUtil.imagenB64Ajlabel(ImagenDao.obtenerImagenPorId(new Imagen(producto.getId_img())), imgProducto);
            }
        }).start();
        
        
        imagenesUtil.imagenProyectoABttton(new ImageIcon(getClass().getResource("/recursos/editar.png")), botonEditarProducto);
        imagenesUtil.imagenProyectoABttton(new ImageIcon(getClass().getResource("/recursos/eliminar.png")), botonEliminarProducto);

        this.setBorder(new FlatButtonBorder());
    }

    private void eliminarProducto() {
        int valor = JOptionPane.showConfirmDialog(this, "¿Esta seguro de que quiere eliminar este producto?", "Confirmar borrado", JOptionPane.YES_NO_OPTION);
        if (valor == JOptionPane.YES_OPTION) {
            //System.out.println(producto.toString());
            if (ProductoDao.borrarProducto(producto)) {
                JOptionPane.showMessageDialog(null, "Se eliminó el producto.", "Producto eliminado", JOptionPane.INFORMATION_MESSAGE);
                /*panelProductos.remove(this);
                panelProductos.revalidate();
                panelProductos.repaint();*/
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto.", "Producto no eliminado", JOptionPane.INFORMATION_MESSAGE);
            }
            btUpdate.doClick();
        }
    }

    private void editarProducto() {
        new editarProducto(btUpdate,producto).setVisible(true);
    }
}
