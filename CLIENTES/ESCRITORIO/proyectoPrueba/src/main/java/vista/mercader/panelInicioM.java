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
        img.setBorder(new FlatButtonBorder());
        DescripcionNegocio.setText(negocio.getDescripcion());
        nombreNegocio.setText(negocio.getNombre());
        ImageIcon image = imagenesUtil.base64AImagen(ImagenDao.obtenerImagenPorId(new Imagen(negocio.getId_img())));
        img.setIcon(new ImageIcon(image.getImage().getScaledInstance(img.getPreferredSize().width, img.getPreferredSize().height, Image.SCALE_DEFAULT)));
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

        nombreNegocio.setText("Nombre negocio");

        DescripcionNegocio.setText("Descripcion Negocio");
        DescripcionNegocio.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        img.setPreferredSize(new java.awt.Dimension(190, 190));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreNegocio)
                    .addComponent(DescripcionNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(278, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(nombreNegocio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DescripcionNegocio, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        img.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DescripcionNegocio;
    private javax.swing.JLabel img;
    private javax.swing.JLabel nombreNegocio;
    // End of variables declaration//GEN-END:variables

    
}
