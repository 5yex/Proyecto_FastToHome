/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package mvc.vista;

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

    Direccion bd;
    //List<Departamento> departamentos = new ArrayList<Departamento>();

    /**
     * Creates new form dialogoNuevoDepartamento
     */
    public dialogoNuevaDirección(java.awt.Frame parent, boolean modal, Direccion direccion) {
        super(parent, modal);
        this.bd = direccion;
        initComponents();
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
        codigo = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        oficio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        error = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        salario = new javax.swing.JTextField();

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

        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });

        jLabel1.setText("Número:");

        jLabel2.setText("Calle:");

        jLabel3.setText("Ciudad:");

        error.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        error.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        error.setText(" ");

        jLabel4.setText("CP:");

        salario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salarioActionPerformed(evt);
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
                        .addComponent(error, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(salario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(apellido, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(oficio))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
//        if (insertarEmpleados()) {
//            this.dispose();
//        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

    private void salarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salarioActionPerformed

//    public boolean insertarEmpleados() {
//        try {
//            int cod = Integer.valueOf(codigo.getText());
//            int sal = Integer.valueOf(salario.getText());
//            int com = Integer.valueOf(comision.getText());
//            String apell = apellido.getText();
//            String ofici = oficio.getText();
//            Departamento depart = null;
//            int nDep = selectorDeps.getSelectedIndex();
//
//            if (apell.length() == 0 | ofici.length() == 0) {
//                throw new IOException("Rellena todos los campos");
//            } else {
//                new EmpleadoDAO().insertarEmpleado(bd, new Empleado(cod, apell.toUpperCase(), ofici, new Date(), sal, com, depart));
//                if (selectorDeps.getSelectedIndex() != 0) {
//                    new EmpleadoDAO().asignarDepartamento(bd, cod, departamentos.get(nDep - 1).getDeptNo());
//                };
//            }
//
//        } catch (NumberFormatException ex) {
//            error.setText("Introduce un número");
//            return false;
//        } catch (IOException ex) {
//            error.setText(ex.getMessage());
//            return false;
//        }
//        return true;
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar;
    private javax.swing.JTextField apellido;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField codigo;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField oficio;
    private javax.swing.JTextField salario;
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
