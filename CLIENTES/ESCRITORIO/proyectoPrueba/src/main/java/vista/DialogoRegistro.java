/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

import controlador.UsuarioDao;
import javax.swing.JOptionPane;
import modelo.Usuario;
import org.mindrot.jbcrypt.BCrypt;
import util.Constantes;
import util.validaciones;

/**
 *
 * @author Jesus
 */
public class DialogoRegistro extends javax.swing.JDialog implements Constantes{
    
    private Usuario newUsuario = new Usuario();

    /**
     * Creates new form DialogoRegistro
     */
    public DialogoRegistro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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
        nombreTXT = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        apellidosTXT = new javax.swing.JLabel();
        apellidosField = new javax.swing.JTextField();
        dniTXT = new javax.swing.JLabel();
        dniField = new javax.swing.JTextField();
        tlfTXT = new javax.swing.JLabel();
        tlfField = new javax.swing.JTextField();
        emailTXT = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        passwordConfirmTxt = new javax.swing.JLabel();
        passwordConfirmField = new javax.swing.JPasswordField();
        registerConfirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleText.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titleText.setText("REGISTRO DE USUARIO");

        nombreTXT.setText("NOMBRE");

        nombreField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreFieldFocusLost(evt);
            }
        });

        apellidosTXT.setText("APELLIDOS");

        apellidosField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                apellidosFieldFocusLost(evt);
            }
        });

        dniTXT.setText("DNI");

        dniField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dniFieldFocusLost(evt);
            }
        });

        tlfTXT.setText("TELÉFONO");

        tlfField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tlfFieldFocusLost(evt);
            }
        });

        emailTXT.setText("CORREO ELECTRÓNICO");

        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFieldFocusLost(evt);
            }
        });

        passwordTxt.setText("CONTRASEÑA");

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

        registerConfirm.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        registerConfirm.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        registerConfirm.setText("CONFIRMAR REGISTRO");
        registerConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerConfirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelRegistroLayout = new javax.swing.GroupLayout(PanelRegistro);
        PanelRegistro.setLayout(PanelRegistroLayout);
        PanelRegistroLayout.setHorizontalGroup(
            PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tlfTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(dniField)
                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dniTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apellidosTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(apellidosField)
                                .addComponent(nombreTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordField)
                                .addComponent(tlfField, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(nombreField)
                                .addComponent(passwordConfirmField)
                                .addComponent(passwordConfirmTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailField)
                                .addComponent(registerConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        PanelRegistroLayout.setVerticalGroup(
            PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreTXT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(apellidosTXT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apellidosField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dniTXT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dniField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tlfTXT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tlfField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailTXT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordConfirmTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordConfirmField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(registerConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registerConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerConfirmActionPerformed
        
        if(validaciones.validar(nombreField.getText(),PATRON_NOMBRES) &&
                validaciones.validar(apellidosField.getText(),PATRON_APELLIDOS) &&
                validaciones.validacionDNI(dniField.getText()) &&
                validaciones.validar(tlfField.getText(), PATRON_TELEFONO) &&
                validaciones.validar(emailField.getText(),PATRON_EMAIL) &&
                validaciones.validar(String.valueOf(passwordField.getPassword()),PATRON_PASS_USUARIO) &&
                String.valueOf(passwordField.getPassword()).compareTo(String.valueOf(passwordConfirmField.getPassword())) == 0
                ){
            registrarUsuario();
        }else{
            JOptionPane.showMessageDialog(this, MENSAJE_ERROR_RELLENO_DATOS, URL, HEIGHT);
        }
    }//GEN-LAST:event_registerConfirmActionPerformed

    private void nombreFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreFieldFocusLost
        /*if(!validaciones.validar(nombreField.getText(),PATRON_NOMBRES)){
            JOptionPane.showMessageDialog(this, MENSAJE_NOMBRE_INFO, "Error", JOptionPane.ERROR_MESSAGE);
        }*/
    }//GEN-LAST:event_nombreFieldFocusLost

    private void apellidosFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_apellidosFieldFocusLost
        /*if(!validaciones.validar(apellidosField.getText(),PATRON_APELLIDOS)){
            JOptionPane.showMessageDialog(this, MENSAJE_APELLIDO_INFO, "Error", JOptionPane.ERROR_MESSAGE);
        }*/
    }//GEN-LAST:event_apellidosFieldFocusLost

    private void dniFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dniFieldFocusLost
        /*if(!validaciones.validacionDNI(dniField.getText())){
            JOptionPane.showMessageDialog(this, MENSAJE_DNI, "Error", JOptionPane.ERROR_MESSAGE);
        }*/
    }//GEN-LAST:event_dniFieldFocusLost

    private void tlfFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tlfFieldFocusLost
        if(!validaciones.validar(tlfField.getText(), PATRON_TELEFONO)){
            JOptionPane.showMessageDialog(this, MENSAJE_TELEFONO_INFO, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tlfFieldFocusLost

    private void emailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusLost
        if(!validaciones.validar(emailField.getText(),PATRON_EMAIL)){
            JOptionPane.showMessageDialog(null, MENSAJE_EMAIL_INFO,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_emailFieldFocusLost

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
        if(!validaciones.validar(String.valueOf(passwordField.getPassword()),PATRON_PASS_USUARIO)){
            JOptionPane.showMessageDialog(null, MENSAJE_PASS_INFO,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_passwordFieldFocusLost

    private void passwordConfirmFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordConfirmFieldFocusLost
        if(String.valueOf(passwordField.getPassword()).compareTo(String.valueOf(passwordConfirmField.getPassword())) != 0 && !validaciones.validar(String.valueOf(passwordField.getPassword()),PATRON_PASS_USUARIO)){
            JOptionPane.showMessageDialog(null, MENSAJE_CONFIRMA_PASS,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_passwordConfirmFieldFocusLost
    

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogoRegistro dialog = new DialogoRegistro(new javax.swing.JFrame(), true);
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
    
    private void registrarUsuario() {
        newUsuario.setNombre(nombreField.getText());
        newUsuario.setDni(dniField.getText());
        newUsuario.setTlf(tlfField.getText());
        newUsuario.setEmail(emailField.getText());
        newUsuario.setPassword(BCrypt.hashpw(new String(passwordField.getPassword()), BCrypt.gensalt(10)));
        newUsuario.setRol("cliente");
        System.out.println(newUsuario.getJSON());
        
        
        UsuarioDao.nuevoUsuario(newUsuario);
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelRegistro;
    private javax.swing.JTextField apellidosField;
    private javax.swing.JLabel apellidosTXT;
    private javax.swing.JTextField dniField;
    private javax.swing.JLabel dniTXT;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailTXT;
    private javax.swing.JTextField nombreField;
    private javax.swing.JLabel nombreTXT;
    private javax.swing.JPasswordField passwordConfirmField;
    private javax.swing.JLabel passwordConfirmTxt;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordTxt;
    private javax.swing.JButton registerConfirm;
    private javax.swing.JLabel titleText;
    private javax.swing.JTextField tlfField;
    private javax.swing.JLabel tlfTXT;
    // End of variables declaration//GEN-END:variables
}
