/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.CategoriaDao;
import controlador.DireccionDao;
import controlador.ImagenDao;
import controlador.NegocioDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.Direccion;
import modelo.Imagen;
import modelo.Negocio;
import modelo.Usuario;
import vista.mercader.VentanaMercader;

/**
 *
 * @author jmcbg
 */
public class actualizarNegocio extends javax.swing.JFrame {

    private Negocio negocio;
    private Imagen nImg = new Imagen();
    private Direccion direccionNegocio = new Direccion();
    private ArrayList<Categoria> listaCategorias;

    public actualizarNegocio(Negocio negocio) {
        this.negocio = negocio;
        initComponents();
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
        titleText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        varNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDescripcion = new javax.swing.JTextArea();
        botonActualizarImagen = new javax.swing.JButton();
        comboCategoria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        botonConfirmarCambios = new javax.swing.JButton();
        botonActualizarDireccion = new javax.swing.JButton();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        titleText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleText.setText("ACTUALIZAR NEGOCIO:");

        jLabel1.setText("NOMBRE");

        jLabel2.setText("DESCRIPCIÓN");

        textAreaDescripcion.setColumns(20);
        textAreaDescripcion.setRows(5);
        jScrollPane1.setViewportView(textAreaDescripcion);

        botonActualizarImagen.setText("Cambiar imagen del negocio");
        botonActualizarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarImagenActionPerformed(evt);
            }
        });

        jLabel3.setText("CATEGORÍA");

        botonConfirmarCambios.setText("CONFIRMAR CAMBIOS");
        botonConfirmarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConfirmarCambiosActionPerformed(evt);
            }
        });

        botonActualizarDireccion.setText("Cambiar imagen del negocio");
        botonActualizarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarDireccionActionPerformed(evt);
            }
        });

        error.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        error.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        error.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(varNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(titleText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1)
                    .addComponent(botonConfirmarCambios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonActualizarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonActualizarDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(titleText)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonActualizarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonActualizarDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonConfirmarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonActualizarDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarDireccionActionPerformed
        DialogoDireccion dialogoDireccion = new DialogoDireccion(this, true, direccionNegocio);
        dialogoDireccion.setVisible(true);
    }//GEN-LAST:event_botonActualizarDireccionActionPerformed

    private void botonConfirmarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConfirmarCambiosActionPerformed
        if (actualizarNegocio(negocio)) {
            this.dispose();
        }
    }//GEN-LAST:event_botonConfirmarCambiosActionPerformed

    private void botonActualizarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarImagenActionPerformed
        new DialogoImagen(this, rootPaneCheckingEnabled, nImg).setVisible(true);
    }//GEN-LAST:event_botonActualizarImagenActionPerformed

    private void cargaInicial() {
        nImg = new Imagen(negocio.getId_img());
        varNombre.setText(negocio.getNombre());
        textAreaDescripcion.setText(negocio.getDescripcion());
        direccionNegocio = DireccionDao.obtenerDireccionNegocio(negocio);
        listaCategorias = controlador.CategoriaDao.obtenerCategorias();
        for (Categoria listaCategoria : listaCategorias) {
            comboCategoria.addItem(listaCategoria.getNombre());
        }
    }

    private boolean actualizarNegocio(Negocio negocio) {
        
        boolean direccionActualizada = DireccionDao.actualizarDireccion(direccionNegocio);
        
        
        
        return false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizarDireccion;
    private javax.swing.JButton botonActualizarImagen;
    private javax.swing.JButton botonConfirmarCambios;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaDescripcion;
    private javax.swing.JLabel titleText;
    private javax.swing.JTextField varNombre;
    // End of variables declaration//GEN-END:variables
}
