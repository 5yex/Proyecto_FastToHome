/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.administrador;

import modelo.Usuario;

/**
 *
 * @author jmcbg
 */
public class panelInicio extends javax.swing.JPanel {
    Usuario userActual;
    
    public panelInicio(Usuario user) {
        initComponents();
        mostarDatos();
    }
    
    private void mostarDatos(){
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelBienvenido = new javax.swing.JLabel();
        varAdminTXT = new javax.swing.JLabel();

        labelBienvenido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelBienvenido.setText("Bienvenido administrador:");
        labelBienvenido.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        varAdminTXT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        varAdminTXT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        varAdminTXT.setText("nomAdmin");
        varAdminTXT.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(labelBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(varAdminTXT)
                .addContainerGap(236, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelBienvenido, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varAdminTXT))
                .addContainerGap(283, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelBienvenido;
    private javax.swing.JLabel varAdminTXT;
    // End of variables declaration//GEN-END:variables
}
