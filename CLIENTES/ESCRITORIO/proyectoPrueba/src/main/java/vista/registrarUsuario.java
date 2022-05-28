/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista;

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

/**
 *
 * @author Jesus
 */
public class registrarUsuario extends javax.swing.JDialog implements Constantes {

    private Usuario newUsuario = new Usuario();
    Direccion direccionUsuario = new Direccion();

    /**
     * Creates new form DialogoRegistro
     */
    public registrarUsuario(java.awt.Frame parent, boolean modal) {
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

        titleText = new javax.swing.JLabel();
        infoNombre = new javax.swing.JLabel();
        nombreTXT = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        infoApellido = new javax.swing.JLabel();
        apellidosTXT = new javax.swing.JLabel();
        apellidosField = new javax.swing.JTextField();
        infoDNI = new javax.swing.JLabel();
        dniTXT = new javax.swing.JLabel();
        dniField = new javax.swing.JTextField();
        infoTelefono = new javax.swing.JLabel();
        tlfTXT = new javax.swing.JLabel();
        tlfField = new javax.swing.JTextField();
        infoEmail = new javax.swing.JLabel();
        emailTXT = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        passwordConfirmTxt = new javax.swing.JLabel();
        passwordConfirmField = new javax.swing.JPasswordField();
        registerConfirm = new javax.swing.JButton();
        botonIntroducirDireccion = new javax.swing.JButton();
        infoPass = new javax.swing.JLabel();
        infoConfirmPass = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de usuario");
        setName("Registro de usuario"); // NOI18N
        setResizable(false);

        titleText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleText.setText("REGISTRO DE USUARIO.");

        infoNombre.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N

        nombreTXT.setText("Nombre:");

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

        infoApellido.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N

        apellidosTXT.setText("Apellidos:");

        apellidosField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                apellidosFieldFocusLost(evt);
            }
        });

        infoDNI.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N

        dniTXT.setText("Dni:");

        dniField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                dniFieldFocusLost(evt);
            }
        });

        infoTelefono.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N

        tlfTXT.setText("Teléfono:");

        tlfField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tlfFieldFocusLost(evt);
            }
        });

        infoEmail.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N

        emailTXT.setText("Correo electrónico:");

        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFieldFocusLost(evt);
            }
        });

        passwordTxt.setText("Contraseña:");

        passwordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFieldFocusLost(evt);
            }
        });
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        passwordConfirmTxt.setText("Confirmar contraseña:");

        passwordConfirmField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordConfirmFieldFocusLost(evt);
            }
        });

        registerConfirm.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        registerConfirm.setText("CONFIRMAR REGISTRO");
        registerConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerConfirmActionPerformed(evt);
            }
        });

        botonIntroducirDireccion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonIntroducirDireccion.setText("INTRODUCIR DIRECCION");
        botonIntroducirDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIntroducirDireccionActionPerformed(evt);
            }
        });

        infoPass.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N

        infoConfirmPass.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(passwordConfirmTxt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                        .addComponent(infoConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(passwordConfirmField)
                    .addComponent(botonIntroducirDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registerConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailField)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tlfTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(infoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tlfField)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nombreTXT)
                                .addGap(18, 18, 18)
                                .addComponent(infoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(apellidosTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(infoApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(apellidosField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(dniTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                    .addComponent(infoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(dniField, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                    .addComponent(infoPass, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(passwordField, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(emailTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(infoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(titleText)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nombreTXT)
                    .addComponent(infoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(apellidosTXT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apellidosField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dniTXT)
                    .addComponent(infoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dniField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tlfTXT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(infoTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6)
                .addComponent(tlfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailTXT)
                    .addComponent(infoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordTxt)
                    .addComponent(infoPass, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordConfirmTxt)
                    .addComponent(infoConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordConfirmField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 20, Short.MAX_VALUE)
                .addComponent(botonIntroducirDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerConfirmActionPerformed

        if (validaciones.validar(nombreField.getText(), PATRON_NOMBRES)
                && validaciones.validar(apellidosField.getText(), PATRON_APELLIDOS)
                && validaciones.validacionDNI(dniField.getText())
                && validaciones.validar(tlfField.getText(), PATRON_TELEFONO)
                && validaciones.validar(emailField.getText(), PATRON_EMAIL)
                && validaciones.validar(String.valueOf(passwordField.getPassword()), PATRON_PASS_USUARIO)
                && String.valueOf(passwordField.getPassword()).compareTo(String.valueOf(passwordConfirmField.getPassword())) == 0) {
            registrarUsuario();

        } else {
            JOptionPane.showMessageDialog(this, MENSAJE_ERROR_RELLENO_DATOS, URL, HEIGHT);
        }
    }//GEN-LAST:event_registerConfirmActionPerformed

    private void nombreFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreFieldFocusLost
        if (!validaciones.validar(nombreField.getText(), PATRON_NOMBRES)) {
            infoNombre.setForeground(Color.RED);
            infoNombre.setText(MENSAJE_NOMBRE_INFO);
        } else {
            infoNombre.setText("");
        }
    }//GEN-LAST:event_nombreFieldFocusLost

    private void apellidosFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_apellidosFieldFocusLost
        if (!validaciones.validar(apellidosField.getText(), PATRON_APELLIDOS)) {
            infoApellido.setForeground(Color.RED);
            infoApellido.setText(MENSAJE_APELLIDO_INFO);
        } else {
            infoApellido.setText("");
        }
    }//GEN-LAST:event_apellidosFieldFocusLost

    private void dniFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dniFieldFocusLost
        if (!validaciones.validacionDNI(dniField.getText())) {
            infoDNI.setForeground(Color.RED);
            infoDNI.setText(MENSAJE_DNI_INFO);
        } else {
            infoDNI.setText("");
        }
    }//GEN-LAST:event_dniFieldFocusLost

    private void tlfFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tlfFieldFocusLost
        if (!validaciones.validar(tlfField.getText(), PATRON_TELEFONO)) {
            infoTelefono.setForeground(Color.RED);
            infoTelefono.setText(MENSAJE_TELEFONO_INFO);
        } else {
            infoTelefono.setText("");
        }
    }//GEN-LAST:event_tlfFieldFocusLost

    private void emailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusLost
        if (!validaciones.validar(emailField.getText(), PATRON_EMAIL)) {
            infoEmail.setForeground(Color.RED);
            infoEmail.setText(MENSAJE_EMAIL_INFO);
        } else {
            infoEmail.setText("");
        }
    }//GEN-LAST:event_emailFieldFocusLost

    private void passwordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFieldFocusLost
        if (!validaciones.validar(String.valueOf(passwordField.getPassword()), PATRON_PASS_USUARIO)) {
            infoPass.setForeground(Color.RED);
            infoPass.setText(MENSAJE_PASS_INFO);
        } else {
            infoPass.setText("");
        }
    }//GEN-LAST:event_passwordFieldFocusLost

    private void passwordConfirmFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordConfirmFieldFocusLost
        if (String.valueOf(passwordField.getPassword()).compareTo(String.valueOf(passwordConfirmField.getPassword())) != 0 || !validaciones.validar(String.valueOf(passwordField.getPassword()), PATRON_PASS_USUARIO)) {
            infoConfirmPass.setForeground(Color.RED);
            infoConfirmPass.setText(MENSAJE_CONFIRMA_PASS);
        } else {
            infoConfirmPass.setText("");
        }
    }//GEN-LAST:event_passwordConfirmFieldFocusLost

    private void nombreFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nombreFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreFieldFocusGained

    private void nombreFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void botonIntroducirDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIntroducirDireccionActionPerformed
        DialogoDireccion dialogoDireccion = new DialogoDireccion(this, true, direccionUsuario);
        dialogoDireccion.setVisible(true);
    }//GEN-LAST:event_botonIntroducirDireccionActionPerformed

    private void registrarUsuario() {
        if (direccionUsuario.isValida()) {
            int id_direccion = DireccionDao.nuevaDireccionDevuelveId(direccionUsuario);
            if (id_direccion != -1) {
                newUsuario.setNombre(nombreField.getText());
                newUsuario.setApellidos(apellidosField.getText());
                newUsuario.setDni(dniField.getText());
                newUsuario.setTlf(tlfField.getText());
                newUsuario.setEmail(emailField.getText());
                newUsuario.setPassword(BCrypt.hashpw(new String(passwordField.getPassword()), BCrypt.gensalt(10)));
                newUsuario.setRol("cliente");
                //Asignamos la dirección recien creada
                newUsuario.setId_direccion(id_direccion);
                System.out.println(newUsuario.getJSON());

                if (UsuarioDao.nuevoUsuario(newUsuario)) {
                    //si la consulta del nuevo usuario falla, eliminamos el dirección creada para el
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo registrar el usuario con esos datos", "Error al registrar usuario", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error, no insertó una direccion correcta por lo que no se procedió a crear el usuario", "Error al registrar usuario", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Tienes que introducir una direccion", "Error al registrar usuario", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void validarCampos() {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidosField;
    private javax.swing.JLabel apellidosTXT;
    private javax.swing.JButton botonIntroducirDireccion;
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
    private javax.swing.JButton registerConfirm;
    private javax.swing.JLabel titleText;
    private javax.swing.JTextField tlfField;
    private javax.swing.JLabel tlfTXT;
    // End of variables declaration//GEN-END:variables
}
