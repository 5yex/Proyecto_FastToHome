/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import com.formdev.flatlaf.ui.FlatButtonBorder;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.Imagen;
import util.imagenesUtil;

/**
 * Clase que representa el diálogo de selección de imagen.
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 * @since 1.0
 */
public class DialogoImagen extends javax.swing.JDialog {

    private File imagenSeleccionada;
    private String b64_imagen;
    private Imagen imagen;

    /**
     * Construye un nuevo DialogoImagen cuyo elemento padre es un Frame
     * 
     * @param parent Frame padre del diálogo
     * @param modal No se puede clickar en la ventana padre si está a true
     * @param imagen Imagen a seleccionar
     */
    public DialogoImagen(java.awt.Frame parent, boolean modal, Imagen imagen) {
        super(parent, modal);
        initComponents();
        establecerIcono();
        this.imagen = imagen;
    }
    
    /**
     * Construye un nuevo DialogoImagen cuyo elemento padre es un Diálogo
     * 
     * @param parent Diálogo padre
     * @param modal No se puede clickar en el diálogo padre si está a true
     * @param imagen Imagen a seleccionar
     */
    public DialogoImagen(java.awt.Dialog parent, boolean modal, Imagen imagen) {
        super(parent, modal);
        initComponents();
        establecerIcono();
        this.imagen = imagen;
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

        btnSeleccionarImagen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccionar Imagen");
        setResizable(false);

        btnSeleccionarImagen.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnSeleccionarImagen.setText("SELECCIONAR IMAGEN");
        btnSeleccionarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarImagenActionPerformed(evt);
            }
        });

        jLabel1.setBorder(new FlatButtonBorder());
        jLabel1.setOpaque(true);

        btnAceptar.setText("ACEPTAR");
        btnAceptar.setEnabled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSeleccionarImagen)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSeleccionarImagen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Acción de pulsar el botón de 'SELECCIONAR IMAGEN'
     * 
     * @param evt evento
     */
    private void btnSeleccionarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarImagenActionPerformed
            JFileChooser jf = new JFileChooser();
            jf.setDialogTitle("Seleccionar Imagen");
            jf.setFileFilter(new FileNameExtensionFilter("Imagenes PNG", "png"));
            int seleccion = jf.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                imagenSeleccionada = jf.getSelectedFile();
                jLabel1.setIcon(new ImageIcon(new ImageIcon(imagenSeleccionada.getPath()).getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT)));
                 b64_imagen = imagenesUtil.imagenABase64(imagenSeleccionada); 
                btnAceptar.setEnabled(true);
            }            
           
    }//GEN-LAST:event_btnSeleccionarImagenActionPerformed
    
    /**
     * Acción de pulsar el botón de 'ACEPTAR'
     * 
     * @param evt 
     */
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        imagen.setB64_imagen(b64_imagen);
        this.dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed
    
    /**
     * Acción de pulsar el botón de 'CANCELAR'
     * 
     * @param evt 
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSeleccionarImagen;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
