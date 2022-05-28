/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.mercader;

import com.formdev.flatlaf.ui.FlatButtonBorder;
import vista.*;
import controlador.CategoriaDao;
import controlador.DireccionDao;
import controlador.ImagenDao;
import controlador.NegocioDao;
import controlador.ProductoDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.Direccion;
import modelo.Imagen;
import modelo.Negocio;
import modelo.Producto;
import modelo.Usuario;
import util.imagenesUtil;
import static util.imagenesUtil.imagenAjlabel;
import vista.mercader.VentanaMercader;

/**
 *
 * @author jmcbg
 */
public class registrarProducto extends javax.swing.JFrame {

    private Imagen nImg = new Imagen();
    private Negocio neg;
    private JButton btActupaizar;

    /**
     * Creates new form VentanaRegistroNegocio
     *
     * @param user
     */
    public registrarProducto(JButton btActupaizar, Negocio neg) {
        initComponents();
        this.btActupaizar=btActupaizar;
        this.neg = neg;
        cargaInicial();
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
        setTitle("NUEVO PRODUCTO");
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

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonCacelar.setText("Cancelar");
        botonCacelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCacelarActionPerformed(evt);
            }
        });

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

    private void botonPedirImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedirImagenActionPerformed
        new DialogoImagen(this, rootPaneCheckingEnabled, nImg).setVisible(true);
        if(nImg.getB64_imagen() != null && !nImg.getB64_imagen().isBlank()){
            imagenAjlabel(nImg.getB64_imagen(),imgProducto);
        }
    }//GEN-LAST:event_botonPedirImagenActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        if(nuevoProducto()){
            btActupaizar.doClick();
            this.dispose();
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonCacelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCacelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonCacelarActionPerformed

    private void cargaInicial() {
//        listaCategorias = controlador.CategoriaDao.obtenerCategorias();
//        for (Categoria listaCategoria : listaCategorias) {
//            comboCategoria.addItem(listaCategoria.getNombre());
//        }
//        JOptionPane.showMessageDialog(null, User.getNombre() + " Bienvenido al equipo de mercaderes! \n A continuación podrás configurar tu negocio");
    }

    private boolean nuevoProducto() {

        try {

            String nombre = varNombre.getText();
            String descripcion = textAreaDescripcion.getText();
            double precio = Double.parseDouble(precioProducto.getText());

            if (descripcion.length() == 0 | nombre.length() == 0) {
                throw new IOException("Rellena todos los campos");
            }
            
                if (nImg.getB64_imagen() != null && !nImg.getB64_imagen().isBlank()) {
                   

                    int id_imagen = ImagenDao.nuevaImagenDevuelveId(nImg);

                    if (id_imagen != -1) {
                        Producto produc = new Producto();
                        produc.setDescripcion(descripcion);
                        produc.setPrecio(precio);
                        produc.setId_img(id_imagen);
                        produc.setNombre(nombre);
                        produc.setId_negocio(neg.getId_negocio());
                        return ProductoDao.nuevoProducto(produc);
                    }
                } else {
                    errorTexto.setText("Tienes que subir una imagen");
                    return false;

                }
           
        } catch (NumberFormatException ex) {
            errorTexto.setText("Rellena correctamente los campos numéricos");
            return false;
        } catch (IOException ex) {
            errorTexto.setText(ex.getMessage());
            return false;
        }
        return true;
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
