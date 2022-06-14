/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.mercader;

import com.formdev.flatlaf.ui.FlatButtonBorder;
import vista.*;
import controlador.ImagenDao;
import controlador.ProductoDao;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Imagen;
import modelo.Producto;
import util.imagenesUtil;
import static util.imagenesUtil.imagenB64Ajlabel;

/**
 * Clase que representa el diálogo de editar producto.
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 * @since 1.0
 */
public class DialogoEditarProducto extends javax.swing.JDialog {

    private Imagen nImg = new Imagen();
    private Producto producto;
    private JButton btActualizar;

    /**
     * Construye un DialogoEditarProducto
     * 
     * @param parent Frame padre del diálogo
     * @param btActualizar Botón de 'RECARGAR PRODUCTOS' de la sección 'PRODUCTOS' de la Ventana Mercader
     * @param product Producto a ser editado
     * @param modal No se puede clickar en la ventana padre si está a true
     */
    public DialogoEditarProducto(JFrame parent, JButton btActualizar, Producto product, boolean modal) {
        super(parent,modal);
        initComponents();
        this.btActualizar = btActualizar;
        this.producto = product;
        establecerIcono();
        cargaInicial();
    }
    
    /**
     * Establece el icono del diálogo
     */
    private void establecerIcono() {
        this.setIconImage(new ImageIcon(getClass().getResource("/recursos/logoIcon.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        NombreTxt = new javax.swing.JLabel();
        DescripcionTXT = new javax.swing.JLabel();
        varNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDescripcion = new javax.swing.JTextArea();
        botonPedirImagen = new javax.swing.JButton();
        txtPrecio = new javax.swing.JLabel();
        precioProducto = new javax.swing.JTextField();
        botonAceptar = new javax.swing.JButton();
        botonCacelar = new javax.swing.JButton();
        imgProducto = new javax.swing.JLabel();
        errorTexto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizar Producto");
        setAlwaysOnTop(true);
        setResizable(false);

        NombreTxt.setText("NOMBRE:");

        DescripcionTXT.setText("DESCRIPCIÓN:");

        varNombre.setBorder(new FlatButtonBorder());

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setToolTipText("");
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setViewportBorder(new FlatButtonBorder());

        textAreaDescripcion.setColumns(20);
        textAreaDescripcion.setMaximumSize(new java.awt.Dimension(188, 84));
        textAreaDescripcion.setMinimumSize(new java.awt.Dimension(188, 84));
        textAreaDescripcion.setPreferredSize(new java.awt.Dimension(188, 84));
        jScrollPane1.setViewportView(textAreaDescripcion);

        botonPedirImagen.setText("ABRIR IMAGEN");
        botonPedirImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPedirImagenActionPerformed(evt);
            }
        });

        txtPrecio.setText("PRECIO:");

        precioProducto.setBorder(new FlatButtonBorder());

        botonAceptar.setText("ACEPTAR");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonCacelar.setText("CANCELAR");
        botonCacelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCacelarActionPerformed(evt);
            }
        });

        imgProducto.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        imgProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgProducto.setText("IMAGEN PRODUCTO");
        imgProducto.setBorder(new FlatButtonBorder()
        );
        imgProducto.setMaximumSize(new java.awt.Dimension(190, 190));
        imgProducto.setMinimumSize(new java.awt.Dimension(190, 190));
        imgProducto.setOpaque(true);
        imgProducto.setPreferredSize(new java.awt.Dimension(190, 190));

        errorTexto.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        errorTexto.setText("  ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(NombreTxt)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(precioProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(varNombre)))
                    .addComponent(txtPrecio)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(botonPedirImagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(errorTexto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(DescripcionTXT)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(botonCacelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imgProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NombreTxt)
                            .addComponent(varNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio)
                            .addComponent(precioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DescripcionTXT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonPedirImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imgProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonCacelar)
                    .addComponent(errorTexto))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        imgProducto.getAccessibleContext().setAccessibleName("IMAGEN OBLIGATORIA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Acción de pulsar el botón 'ABRIR IMAGEN'
     * 
     * @param evt evento
     */
    private void botonPedirImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedirImagenActionPerformed
        new DialogoImagen(this, rootPaneCheckingEnabled, nImg).setVisible(true);
        if(nImg.getB64_imagen() != null && !nImg.getB64_imagen().isBlank()){
            imagenB64Ajlabel(nImg.getB64_imagen(),imgProducto);
        }
    }//GEN-LAST:event_botonPedirImagenActionPerformed
    
    /**
     * Acción de pulsar el botón 'ACEPTAR'
     * 
     * @param evt evento 
     */
    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        
        if (editarProducto()) {
            btActualizar.doClick();
            JOptionPane.showMessageDialog(this, "Se editó el producto con éxito", "Producto Registrado", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_botonAceptarActionPerformed
    
    /**
     * Acción de pulsar el botón 'CANCELAR'
     * 
     * @param evt evento
     */
    private void botonCacelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCacelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCacelarActionPerformed
    
    /**
     * Realiza una carga inicial de los elementos del diálogo
     */
    private void cargaInicial() {
        this.textAreaDescripcion.setLineWrap(true);
        varNombre.setText(producto.getNombre());
        precioProducto.setText(String.valueOf(producto.getPrecio()));
        textAreaDescripcion.setText(producto.getDescripcion());
        new Thread(new Runnable() {
            @Override
            public void run() {
                imagenesUtil.imagenB64Ajlabel(ImagenDao.obtenerImagenPorId(new Imagen(producto.getId_img())), imgProducto);
            }
        }).start();
    }
    
    /**
     * Edita el producto y comprueba si se ha editado correctamente
     * 
     * @return true si se ha editado el producto
     */
    private boolean editarProducto() {

        try {

            String nombre = varNombre.getText();
            String descripcion = textAreaDescripcion.getText();
            double precio = Double.parseDouble(precioProducto.getText());

            if (descripcion.length() == 0 | nombre.length() == 0) {
                throw new IOException("Rellena todos los campos");
            }
            if (nImg.getB64_imagen() != null && !nImg.getB64_imagen().isBlank()) {
                if (producto.getId_img() == 0) {
                    //System.out.println("NO TIENE IMAGEN SE LE AÑADIRÁ UNA NUEVA");
                    int id_imagen = ImagenDao.nuevaImagenDevuelveId(nImg);
                    if (id_imagen != 0) {
                        producto.setId_img(id_imagen);
                    }
                } else {

                    nImg.setId(producto.getId_img());
                    ImagenDao.editarImagenPorId(nImg);

                }
            }

            producto.setDescripcion(descripcion);
            producto.setPrecio(precio);
            producto.setNombre(nombre);
            return ProductoDao.actualizarProducto(producto);

        } catch (NumberFormatException ex) {
            errorTexto.setText("Rellena correctamente los campos numéricos");
            return false;
        } catch (IOException ex) {
            errorTexto.setText(ex.getMessage());
            return false;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DescripcionTXT;
    private javax.swing.JLabel NombreTxt;
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCacelar;
    private javax.swing.JButton botonPedirImagen;
    private javax.swing.JLabel errorTexto;
    private javax.swing.JLabel imgProducto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField precioProducto;
    private javax.swing.JTextArea textAreaDescripcion;
    private javax.swing.JLabel txtPrecio;
    private javax.swing.JTextField varNombre;
    // End of variables declaration//GEN-END:variables
}
