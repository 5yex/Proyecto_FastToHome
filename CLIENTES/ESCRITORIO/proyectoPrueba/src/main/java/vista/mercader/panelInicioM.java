/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.mercader;

import com.formdev.flatlaf.ui.FlatButtonBorder;
import controlador.ImagenDao;
import java.awt.Image;
import javax.swing.ImageIcon;
import modelo.Imagen;
import modelo.Negocio;
import util.imagenesUtil;

/**
 *
 * @author jmcbg
 */
public class panelInicioM extends javax.swing.JPanel {

    private Negocio negocio;

    /**
     * Creates new form panelInicio
     */
    public panelInicioM(Negocio negocio) {
        initComponents();
        this.negocio = negocio;
        cargaInicial();
    }

    private void cargaInicial() {
        DescripcionNegocio.setText(negocio.getDescripcion());
        nombreNegocio.setText(negocio.getNombre());   
        
        img.setBorder(new FlatButtonBorder());
        imagenesUtil.imagenAjlabel(ImagenDao.obtenerImagenPorId(new Imagen(negocio.getId_img())), img);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreNegocio = new javax.swing.JLabel();
        DescripcionNegocio = new javax.swing.JLabel();
        img = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(612, 437));

        nombreNegocio.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        nombreNegocio.setText("Nombre negocio");

        DescripcionNegocio.setText("Descripcion Negocio");
        DescripcionNegocio.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        img.setPreferredSize(new java.awt.Dimension(271, 271));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DescripcionNegocio, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
                    .addComponent(nombreNegocio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nombreNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DescripcionNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DescripcionNegocio;
    private javax.swing.JLabel img;
    private javax.swing.JLabel nombreNegocio;
    // End of variables declaration//GEN-END:variables

}
