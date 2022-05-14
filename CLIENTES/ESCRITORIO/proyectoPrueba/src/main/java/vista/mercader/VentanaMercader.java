/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.mercader;

import java.awt.FlowLayout;
import modelo.Negocio;
import modelo.Usuario;

/**
 *
 * @author jmcbg
 */
public class VentanaMercader extends javax.swing.JFrame {

    Usuario mercader;
    Negocio negocio;
    int panelSeleccionado = -99;
    boolean registroPendiente = true;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaMercader(Usuario user) {
        initComponents();
        mercader = user;
        panelCambio();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelBase = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelProductosBase = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Mercader");
        setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        setMinimumSize(new java.awt.Dimension(600, 400));

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jScrollPane1.setBorder(null);

        javax.swing.GroupLayout panelBaseLayout = new javax.swing.GroupLayout(panelBase);
        panelBase.setLayout(panelBaseLayout);
        panelBaseLayout.setHorizontalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );
        panelBaseLayout.setVerticalGroup(
            panelBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelBase);

        jTabbedPane1.addTab("INICIO", jScrollPane1);

        jScrollPane2.setBorder(null);

        javax.swing.GroupLayout panelProductosBaseLayout = new javax.swing.GroupLayout(panelProductosBase);
        panelProductosBase.setLayout(panelProductosBaseLayout);
        panelProductosBaseLayout.setHorizontalGroup(
            panelProductosBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );
        panelProductosBaseLayout.setVerticalGroup(
            panelProductosBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(panelProductosBase);

        jTabbedPane1.addTab("PRODUCTOS", jScrollPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        panelCambio();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void panelCambio() {
        int index = jTabbedPane1.getSelectedIndex();
        if (panelSeleccionado != index) {
            switch (index) {
                case 0:
                    if (registroPendiente) {
                        pruebaRegistroNegocio();
                    }
                    break;
            }

            panelSeleccionado = index;
        }

    }

    public void pruebaRegistroNegocio() {
        panelBase.removeAll();
        panelBase.setLayout(new util.WrapLayout(FlowLayout.CENTER, 30, 30));
        panelBase.add(new panelRegistroNegocio(this));
        panelBase.revalidate();
        panelBase.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelBase;
    private javax.swing.JPanel panelProductosBase;
    // End of variables declaration//GEN-END:variables
}
