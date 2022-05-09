/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista.administrador;

import com.formdev.flatlaf.FlatDarkLaf;
import controlador.UsuarioDao;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Usuario;
import org.mindrot.jbcrypt.BCrypt;
import util.Constantes;
import util.validaciones;

/**
 *
 * @author Jesus
 */
public class DialogoModificarDatosAdmin extends javax.swing.JDialog implements Constantes {

    private Usuario admin = new Usuario();

    /**
     * Creates new form DialogoRegistro
     */
    public DialogoModificarDatosAdmin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public DialogoModificarDatosAdmin(java.awt.Frame parent, boolean modal, Usuario administrador) {
        super(parent, modal);
        admin = administrador;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelRegistro = new javax.swing.JPanel();
        titleText = new javax.swing.JLabel();
        tlfTXT = new javax.swing.JLabel();
        tlfField = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        passwordConfirmTxt = new javax.swing.JLabel();
        passwordConfirmField = new javax.swing.JPasswordField();
        botonActualizar = new javax.swing.JButton();
        infoTelefono = new javax.swing.JLabel();
        infoPass = new javax.swing.JLabel();
        infoConfirmPass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventana Actualizacion de Datos de Administrador");

        titleText.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titleText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleText.setText("ACTUALIZAR DATOS");

        tlfTXT.setText("TELÉFONO");

        tlfField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tlfFieldFocusLost(evt);
            }
        });

        passwordTxt.setText("NUEVA CONTRASEÑA");

        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });

        passwordConfirmTxt.setText("CONFIRMAR CONTRASEÑA");

        passwordConfirmField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordConfirmFieldFocusLost(evt);
            }
        });

        botonActualizar.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        botonActualizar.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        botonActualizar.setText("ACTUALIZAR DATOS");
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelRegistroLayout = new javax.swing.GroupLayout(PanelRegistro);
        PanelRegistro.setLayout(PanelRegistroLayout);
        PanelRegistroLayout.setHorizontalGroup(
            PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistroLayout.createSequentialGroup()
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tlfField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tlfTXT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(passwordConfirmTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelRegistroLayout.createSequentialGroup()
                                    .addComponent(passwordConfirmField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(infoConfirmPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(PanelRegistroLayout.createSequentialGroup()
                                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(infoPass, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        PanelRegistroLayout.setVerticalGroup(
            PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tlfTXT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tlfField, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(infoTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(infoPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordConfirmTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addComponent(passwordConfirmField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(infoConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed

        if (validaciones.validar(nombreField.getText(), PATRON_NOMBRES)
            && validaciones.validar(apellidosField.getText(), PATRON_APELLIDOS)
            && validaciones.validacionDNI(dniField.getText())
            && validaciones.validar(tlfField.getText(), PATRON_TELEFONO)
            && validaciones.validar(emailField.getText(), PATRON_EMAIL)
            && validaciones.validar(String.valueOf(passwordField.getPassword()), PATRON_PASS_USUARIO)
            && String.valueOf(passwordField.getPassword()).compareTo(String.valueOf(passwordConfirmField.getPassword())) == 0) {
            modificarDatosAdmin();
        } else {
            JOptionPane.showMessageDialog(this, MENSAJE_ERROR_RELLENO_DATOS, URL, HEIGHT);
        }
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void passwordConfirmFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordConfirmFieldFocusLost
        if (String.valueOf(passwordField.getPassword()).compareTo(String.valueOf(passwordConfirmField.getPassword())) != 0 || !validaciones.validar(String.valueOf(passwordField.getPassword()), PATRON_PASS_USUARIO)) {
            infoConfirmPass.setForeground(Color.RED);
            infoConfirmPass.setText(MENSAJE_CONFIRMA_PASS);
        } else {
            infoConfirmPass.setText("");
        }
    }//GEN-LAST:event_passwordConfirmFieldFocusLost

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
        if (!validaciones.validar(String.valueOf(passwordField.getPassword()), PATRON_PASS_USUARIO)) {
            infoPass.setForeground(Color.RED);
            infoPass.setText(MENSAJE_PASS_INFO);
        } else {
            infoPass.setText("");
        }
    }//GEN-LAST:event_passwordFieldFocusLost

    private void tlfFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tlfFieldFocusLost
        if (!validaciones.validar(tlfField.getText(), PATRON_TELEFONO)) {
            infoTelefono.setForeground(Color.RED);
            infoTelefono.setText(MENSAJE_TELEFONO_INFO);
        } else {
            infoTelefono.setText("");
        }
    }//GEN-LAST:event_tlfFieldFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {

        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogoModificarDatosAdmin dialog = new DialogoModificarDatosAdmin(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    private void modificarDatosAdmin() {
        admin.getId();
        admin.setNombre(nombreField.getText());
        admin.setDni(dniField.getText());
        admin.setTlf(tlfField.getText());
        admin.setEmail(emailField.getText());
        admin.setPassword(BCrypt.hashpw(new String(passwordField.getPassword()), BCrypt.gensalt(10)));
        admin.setRol("admin");
        System.out.println(admin.getJSON());

        //UsuarioDao.actualizarDatosAdmin(admin);
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelRegistro;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JLabel infoConfirmPass;
    private javax.swing.JLabel infoPass;
    private javax.swing.JLabel infoTelefono;
    private javax.swing.JPasswordField passwordConfirmField;
    private javax.swing.JLabel passwordConfirmTxt;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordTxt;
    private javax.swing.JLabel titleText;
    private javax.swing.JTextField tlfField;
    private javax.swing.JLabel tlfTXT;
    // End of variables declaration//GEN-END:variables
}
