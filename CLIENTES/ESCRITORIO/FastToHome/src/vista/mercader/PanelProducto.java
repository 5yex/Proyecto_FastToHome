/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.mercader;

import com.formdev.flatlaf.ui.FlatButtonBorder;
import controlador.ImagenDao;
import controlador.ProductoDao;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Imagen;
import modelo.Producto;
import util.imagenesUtil;

/**
 * Clase que representa el panel con con el contenido del producto
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 * @since 1.0
 */
public class PanelProducto extends javax.swing.JPanel {

    private Producto producto;
    JButton btUpdate;
    JFrame parent;

    /**
     * Construye un PanelProducto
     * 
     * @param parent Frame padre del panel
     * @param prod objeto de tipo Producto con la información del producto
     * @param btUpdate botón 'RECARGAR PRODUCTOS' de la seccion 'PRODUCTOS' de la ventana de mercader
     */
    public PanelProducto(JFrame parent,Producto prod, JButton btUpdate) {
        initComponents();
        this.parent = parent;
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
        labelPrecio = new javax.swing.JLabel();
        botonInfoProducto = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBorder(new FlatButtonBorder());

        nombreProducto.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        nombreProducto.setText("TITULO PRODUCTO");

        imgProducto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        imgProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgProducto.setText("NO MAGE");
        imgProducto.setBorder(new FlatButtonBorder()
        );
        imgProducto.setOpaque(true);
        imgProducto.setPreferredSize(new java.awt.Dimension(155, 159));

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

        labelPrecio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelPrecio.setText("0.0");

        botonInfoProducto.setPreferredSize(new java.awt.Dimension(45, 45));
        botonInfoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInfoProductoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setText("PRECIO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonInfoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imgProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonEditarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonInfoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Acción de pulsar en el icono de eliminar producto
     * 
     * @param evt evento
     */
    private void botonEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarProductoActionPerformed
        eliminarProducto();
    }//GEN-LAST:event_botonEliminarProductoActionPerformed
    
    /**
     * Acción de pulsar en el icono de editar producto
     * 
     * @param evt evento
     */
    private void botonEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarProductoActionPerformed
        editarProducto();
    }//GEN-LAST:event_botonEditarProductoActionPerformed
    
    /**
     * Acción de pulsar en el icono de mostrar la información del producto
     * 
     * @param evt evento
     */
    private void botonInfoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInfoProductoActionPerformed
       JOptionPane.showMessageDialog(null, "Nombre:  "+ producto.getNombre() + "\nPrecio:  "+ producto.getPrecio()+ " €\nDescripción:  "+ producto.getDescripcion(), "Información Producto", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_botonInfoProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEditarProducto;
    private javax.swing.JButton botonEliminarProducto;
    private javax.swing.JButton botonInfoProducto;
    private javax.swing.JLabel imgProducto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelPrecio;
    private javax.swing.JLabel nombreProducto;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Muestra los datos del producto en el Panel
     */
    private void mostrarDatos() {
        nombreProducto.setText(producto.getNombre());
        labelPrecio.setText(String.valueOf(producto.getPrecio()) + " €");
        new Thread(new Runnable() {
            @Override
            public void run() {
                imagenesUtil.imagenB64Ajlabel(ImagenDao.obtenerImagenPorId(new Imagen(producto.getId_img())), imgProducto);
            }
        }).start();
        
        
        imagenesUtil.imagenProyectoABoton(new ImageIcon(getClass().getResource("/recursos/editar.png")), botonEditarProducto);
        imagenesUtil.imagenProyectoABoton(new ImageIcon(getClass().getResource("/recursos/eliminar.png")), botonEliminarProducto);
        imagenesUtil.imagenProyectoABoton(new ImageIcon(getClass().getResource("/recursos/info.png")), botonInfoProducto);

        this.setBorder(new FlatButtonBorder());
    }
    
    /**
     * Muestra el diálogo con la elección de borrar definitivamente el producto o no
     */
    private void eliminarProducto() {
        Object[] options = {"Si","No"};
        
        int valor = JOptionPane.showOptionDialog(this,"¿Esta seguro de que quiere borrar este producto?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,options, options[0]);
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
    
    /**
     * Abre el diálogo encargado de editar el producto
     */
    private void editarProducto() {
        //new editarProducto(btUpdate,producto).setVisible(true);
        new DialogoEditarProducto(parent, btUpdate, producto, true).setVisible(true);
    }
}
