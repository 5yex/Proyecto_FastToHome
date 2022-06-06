package vista;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import modelo.Direccion;

/**
 * Clase que representa el diálogo de dirección
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 */
public class DialogoDireccion extends javax.swing.JDialog {

    Direccion direccion;

    /**
     * Construye un nuevo DialogoDireccion con parametros cuyo padre es un Frame.
     *
     * @param parent Frame padre
     * @param modal No se puede clickar en la ventana padre si esta a true
     * @param direccion Objeto de tipo Direccion
     */
    public DialogoDireccion(java.awt.Frame parent, boolean modal, Direccion direccion) {
        super(parent, modal);
        this.direccion = direccion;
        this.setIconImage(new ImageIcon(getClass().getResource("/recursos/logoIcon.png")).getImage());
        initComponents();
        rellenarDialogo();
    }

    /**
     * Contruye un nuevo DialogoDireccion con parametros cuyo padre es un Dialogo.
     *
     * @param parentDialog Dialogo padre
     * @param modal No se puede clickar en la ventana padre si esta a true
     * @param direccion Objeto de tipo Direccion
     */
    public DialogoDireccion(JDialog parentDialog, boolean modal, Direccion direccion) {
        super(parentDialog, modal);
        this.direccion = direccion;
        initComponents();
        rellenarDialogo();
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
        labelCiudad1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        varOtros = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Diálogo Dirección");
        setResizable(false);

        cancelar.setText("CANCELAR");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        aceptar.setText("CONFIRMAR");
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

        labelCiudad1.setText("Otros Datos:");

        varOtros.setColumns(20);
        varOtros.setRows(5);
        varOtros.setPreferredSize(new java.awt.Dimension(232, 70));
        jScrollPane1.setViewportView(varOtros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelCP)
                            .addComponent(laberNumero))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(varCP, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(varNumeroTXT))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCiudad)
                            .addComponent(labelCalle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(varCalle)
                            .addComponent(varCiudad)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(37, 37, 37)
                        .addComponent(cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aceptar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelCiudad1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCiudad1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
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
    
    /**
     * Acción del botón Cancelar
     * 
     * @param evt evento
     */
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed
    
    /**
     * Acción del botón Aceptar
     * 
     * @param evt evento
     */
    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        if (rellenarDireccion(direccion)) {
            this.dispose();
        }
    }//GEN-LAST:event_aceptarActionPerformed

    private void varNumeroTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varNumeroTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varNumeroTXTActionPerformed

    private void varCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varCPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varCPActionPerformed

    public void rellenarDialogo() {
        if (direccion != null) {
            varNumeroTXT.setText(String.valueOf(direccion.getNumero()));
            varCP.setText(String.valueOf(direccion.getCodigo_postal()));
            varCalle.setText(direccion.getCalle());
            varCiudad.setText(direccion.getCiudad());
            varOtros.setText(direccion.getOtros());
        }
    }

    private boolean rellenarDireccion(Direccion direccion) {
        try {
            int num = Integer.valueOf(varNumeroTXT.getText());
            int cp = Integer.valueOf(varCP.getText());
            String calle = varCalle.getText();
            String ciudad = varCiudad.getText();
            String otros = varOtros.getText();

            if (calle.length() == 0 | ciudad.length() == 0) {
                throw new IOException("Rellena todos los campos");
            } else {
                direccion.setCalle(calle);
                direccion.setCiudad(ciudad);
                direccion.setCodigo_postal(cp);
                direccion.setNumero(num);
                direccion.setOtros(otros);
                direccion.setValida(true);
            }

        } catch (NumberFormatException ex) {
            error.setText("Campos Numérico Incorrectos");
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCalle;
    private javax.swing.JLabel labelCiudad;
    private javax.swing.JLabel labelCiudad1;
    private javax.swing.JLabel laberNumero;
    private javax.swing.JTextField varCP;
    private javax.swing.JTextField varCalle;
    private javax.swing.JTextField varCiudad;
    private javax.swing.JTextField varNumeroTXT;
    private javax.swing.JTextArea varOtros;
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
