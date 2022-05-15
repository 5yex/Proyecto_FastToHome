package vista;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import modelo.Direccion;

/**
 *
 * @author 5yex
 */
public class dialogoNuevaDirección extends javax.swing.JDialog {

    Direccion direct;
    //List<Departamento> departamentos = new ArrayList<Departamento>();

    /**
     * Creates new form dialogoNuevoDepartamento
     */
    public dialogoNuevaDirección(java.awt.Frame parent, boolean modal, Direccion direccion) {
        super(parent, modal);
        this.direct = direccion;
        initComponents();
        rellenarDialogo();
        //cargarSelectorDeps(new DepartamentoDAO().mostrarDepartamentos(bd));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelar = new javax.swing.JButton();
        aceptar = new javax.swing.JButton();
        varNumeroTXT = new javax.swing.JTextField();
        varCalle = new javax.swing.JTextField();
        varCiudad = new javax.swing.JTextField();
        laberNumero = new javax.swing.JLabel();
        labelCalle = new javax.swing.JLabel();
        labelCiudad = new javax.swing.JLabel();
        error = new javax.swing.JLabel();
        LabelCP = new javax.swing.JLabel();
        varCP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NEODATIS - INSERTAR DEPARTAMENTO");
        setResizable(false);

        cancelar.setText("CANCELAR");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        aceptar.setText("INSERTAR");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        varNumeroTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varNumeroTXTActionPerformed(evt);
            }
        });

        laberNumero.setText("Número:");

        labelCalle.setText("Calle:");

        labelCiudad.setText("Ciudad:");

        error.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        error.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        error.setText(" ");

        LabelCP.setText("CP:");

        varCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varCPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(error, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelCP)
                            .addComponent(laberNumero))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(varNumeroTXT, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(varCP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCiudad)
                            .addComponent(labelCalle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(varCalle)
                            .addComponent(varCiudad))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varNumeroTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(laberNumero)
                    .addComponent(labelCalle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCiudad)
                    .addComponent(LabelCP)
                    .addComponent(varCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelar)
                    .addComponent(error))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
       if (rellenarDireccion()) {
           this.dispose();
       }
    }//GEN-LAST:event_aceptarActionPerformed

    private void varNumeroTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varNumeroTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varNumeroTXTActionPerformed

    private void varCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varCPActionPerformed

    public void rellenarDialogo(){
        if()
    }
    
    private boolean rellenarDireccion() {
        try {
            int num = Integer.valueOf(varNumeroTXT.getText());
            int cp = Integer.valueOf(varCP.getText());
            String calle = varCalle.getText();
            String ciudad = varCiudad.getText();

            if (calle.length() == 0 | ciudad.length() == 0) {
                throw new IOException("Rellena todos los campos");
            } else {
                direct.setCalle(calle);
                direct.setCiudad(ciudad);
                direct.setCodigo_postal(cp);
                direct.setNumero(num);
            }

        } catch (NumberFormatException ex) {
            error.setText("Rellena correctamente los campos numéricos");
            return false;
        } catch (IOException ex) {
            error.setText(ex.getMessage());
            return false;
        }
        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelCP;
    private javax.swing.JButton aceptar;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel error;
    private javax.swing.JLabel labelCalle;
    private javax.swing.JLabel labelCiudad;
    private javax.swing.JLabel laberNumero;
    private javax.swing.JTextField varCP;
    private javax.swing.JTextField varCalle;
    private javax.swing.JTextField varCiudad;
    private javax.swing.JTextField varNumeroTXT;
    // End of variables declaration//GEN-END:variables

//    private void cargarSelectorDeps(Objects<Departamento> listaDepartamentos) {
//        selectorDeps.addItem(" ");
//        List<String> depsStrings = new ArrayList<String>();
//        for (Departamento departamento : listaDepartamentos) {
//            departamentos.add(departamento);
//            selectorDeps.addItem(departamento.toString());
//        }
//    }
}
