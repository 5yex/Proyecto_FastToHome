/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista.administrador;

import com.formdev.flatlaf.FlatDarkLaf;
import controlador.DireccionDao;
import controlador.UsuarioDao;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Direccion;
import modelo.Usuario;
import org.mindrot.jbcrypt.BCrypt;
import util.Constantes;
import util.validaciones;
import vista.DialogoDireccion;

/**
 *
 * @author Jesus
 */
public class DialogoModificarDatosAdmin extends javax.swing.JDialog implements Constantes {

    private Usuario admin = new Usuario();
    Direccion direccionAdmin = new Direccion();

    public Usuario getAdmin() {
        return admin;
    }

    public void setAdmin(Usuario admin) {
        this.admin = admin;
    }

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
        establecerCamposIniciales(admin);
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
        infoNombre = new javax.swing.JLabel();
        infoApellido = new javax.swing.JLabel();
        infoDNI = new javax.swing.JLabel();
        infoTelefono = new javax.swing.JLabel();
        infoEmail = new javax.swing.JLabel();
        infoPass = new javax.swing.JLabel();
        infoConfirmPass = new javax.swing.JLabel();
        botonActualizar = new javax.swing.JButton();
        botonModificarDireccion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventana Actualizacion de Datos de Administrador");

        titleText.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titleText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleText.setText("ACTUALIZAR DATOS");

        nombreTXT.setText("NOMBRE");

        nombreField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nombreFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nombreFieldFocusLost(evt);
            }
        });
        nombreField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreFieldActionPerformed(evt);
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
        passwordConfirmField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordConfirmFieldActionPerformed(evt);
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

        botonModificarDireccion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonModificarDireccion.setText("MODIFICAR DATOS DIRECCIÓN");
        botonModificarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarDireccionActionPerformed(evt);
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
                                    .addComponent(apellidosField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(apellidosTXT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addComponent(dniField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tlfField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tlfTXT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addComponent(passwordConfirmField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(infoConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PanelRegistroLayout.createSequentialGroup()
                                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordConfirmTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dniTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                                        .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(nombreTXT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(nombreField, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(infoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(emailTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(botonModificarDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(botonActualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelRegistroLayout.setVerticalGroup(
            PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreTXT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(infoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombreField, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(apellidosTXT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(infoApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(apellidosField, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dniTXT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(infoDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dniField, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tlfTXT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(infoTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tlfField, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTXT)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(infoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PanelRegistroLayout.createSequentialGroup()
                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(passwordTxt)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordConfirmTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordConfirmField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(infoConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonModificarDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            && String.valueOf(passwordField.getPassword()).compareTo(String.valueOf(passwordConfirmField.getPassword())) == 0
            && DireccionDao.actualizarDireccion(direccionAdmin)) {
                modificarDatosAdmin();
        } else {
                JOptionPane.showMessageDialog(this, MENSAJE_ERROR_RELLENO_DATOS, "Error al rellenar los datos del usuario o dirección",JOptionPane.ERROR_MESSAGE);
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

    private void dniFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dniFieldFocusLost
        if (!validaciones.validacionDNI(dniField.getText())) {
            infoDNI.setForeground(Color.RED);
            infoDNI.setText(MENSAJE_DNI_INFO);
        } else {
            infoDNI.setText("");
        }
    }//GEN-LAST:event_dniFieldFocusLost

    private void apellidosFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_apellidosFieldFocusLost
        if (!validaciones.validar(apellidosField.getText(), PATRON_APELLIDOS)) {
            infoApellido.setForeground(Color.RED);
            infoApellido.setText(MENSAJE_APELLIDO_INFO);
        } else {
            infoApellido.setText("");
        }
    }//GEN-LAST:event_apellidosFieldFocusLost

    private void nombreFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreFieldActionPerformed

    private void nombreFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreFieldFocusLost
        if (!validaciones.validar(nombreField.getText(), PATRON_NOMBRES)) {
            infoNombre.setForeground(Color.RED);
            infoNombre.setText(MENSAJE_NOMBRE_INFO);
        } else {
            infoNombre.setText("");
        }
    }//GEN-LAST:event_nombreFieldFocusLost

    private void nombreFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreFieldFocusGained

    private void emailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusLost
        if (!validaciones.validar(emailField.getText(), PATRON_EMAIL)) {
            infoEmail.setForeground(Color.RED);
            infoEmail.setText(MENSAJE_EMAIL_INFO);
        } else {
            infoEmail.setText("");
        }
    }//GEN-LAST:event_emailFieldFocusLost

    private void passwordConfirmFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordConfirmFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordConfirmFieldActionPerformed

    private void botonModificarDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarDireccionActionPerformed
        direccionAdmin = DireccionDao.obtenerDireccionUsuario(admin);
        DialogoDireccion dialogoDireccion  = new DialogoDireccion(this, true, direccionAdmin);
        dialogoDireccion.setVisible(true);
    }//GEN-LAST:event_botonModificarDireccionActionPerformed



    private void modificarDatosAdmin() {
        
        Usuario adminCopia = admin;
        boolean direccionActualizada = DireccionDao.actualizarDireccion(direccionAdmin);
        
        if(direccionActualizada){
        admin.setNombre(nombreField.getText());
        admin.setApellidos(apellidosField.getText());
        admin.setDni(dniField.getText());
        admin.setTlf(tlfField.getText());
        admin.setEmail(emailField.getText());
        admin.setPassword(BCrypt.hashpw(new String(passwordField.getPassword()), BCrypt.gensalt(10)));
        System.out.println(admin.getJSON());
        
        
        if(UsuarioDao.actualizarUsuario(admin)){
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "No se pudo actualizar el administrador", "Error al actualizar", JOptionPane.ERROR_MESSAGE);
            admin = adminCopia;
        }
        }else{
            JOptionPane.showMessageDialog(this, "Error, nose actualizó la dirección por lo que no se procedió a crear el usuario", "Error al registrar usuario", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelRegistro;
    private javax.swing.JTextField apellidosField;
    private javax.swing.JLabel apellidosTXT;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonModificarDireccion;
    private javax.swing.JTextField dniField;
    private javax.swing.JLabel dniTXT;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailTXT;
    private javax.swing.JLabel infoApellido;
    private javax.swing.JLabel infoConfirmPass;
    private javax.swing.JLabel infoDNI;
    private javax.swing.JLabel infoEmail;
    private javax.swing.JLabel infoNombre;
    private javax.swing.JLabel infoPass;
    private javax.swing.JLabel infoTelefono;
    private javax.swing.JTextField nombreField;
    private javax.swing.JLabel nombreTXT;
    private javax.swing.JPasswordField passwordConfirmField;
    private javax.swing.JLabel passwordConfirmTxt;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordTxt;
    private javax.swing.JLabel titleText;
    private javax.swing.JTextField tlfField;
    private javax.swing.JLabel tlfTXT;
    // End of variables declaration//GEN-END:variables

    private void establecerCamposIniciales(Usuario admin) {
        infoNombre.setText(admin.getNombre());
        infoApellido.setText(admin.getApellidos());
        infoTelefono.setText(admin.getTlf());
        infoDNI.setText(admin.getDni());
        infoEmail.setText(admin.getEmail());
    }
}
