/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vista.administrador;

import vista.*;
import com.formdev.flatlaf.FlatDarkLaf;
import controlador.DireccionDao;
import controlador.UsuarioDao;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Direccion;
import modelo.Usuario;
import org.mindrot.jbcrypt.BCrypt;
import util.Constantes;
import util.validaciones;

/**
 * Clase que representa al dialogo para actualizar los datos del usuario
 * 
 * @author Jose Miguel Calderón, Jesús Rueda
 * @version 1.0
 */
public class DialogoActualizarDatos extends javax.swing.JDialog implements Constantes {

    private JButton updateInicio;

    private Usuario usuario = new Usuario();
    Direccion direccionUsuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario admin) {
        this.usuario = admin;
    }

    public DialogoActualizarDatos(java.awt.Frame parent, boolean modal, Usuario administrador) {
        super(parent, modal);
        usuario = administrador;
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/recursos/logoIcon.png")).getImage());
        establecerCamposIniciales(usuario);
    }

    public DialogoActualizarDatos(java.awt.Frame parent, boolean modal, Usuario administrador, JButton updateInicio) {
        super(parent, modal);
        this.updateInicio = updateInicio;
        usuario = administrador;
        initComponents();
        establecerCamposIniciales(usuario);
    }

    private boolean validarpassiguales() {

        if (modificarPassCheck.isSelected()) {
            if (validaciones.validar(String.valueOf(passwordField.getPassword()), PATRON_PASS_USUARIO)
                    && String.valueOf(passwordField.getPassword()).compareTo(String.valueOf(passwordConfirmField.getPassword())) == 0) {
                return true;
            } else {
                return false;
            }
        }
        return true;
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
        updateConfirm = new javax.swing.JButton();
        botonModificarDireccion = new javax.swing.JButton();
        infoPass = new javax.swing.JLabel();
        infoConfirmPass = new javax.swing.JLabel();
        passwordAnteriorTxt = new javax.swing.JLabel();
        passwordAnteriorField = new javax.swing.JPasswordField();
        infoPassAnterior = new javax.swing.JLabel();
        modificarPassCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizar usuario");
        setIconImage(null);
        setName("Registro de usuario"); // NOI18N
        setResizable(false);

        titleText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleText.setText("ACTUALIZAR USUARIO.");

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

        passwordField.setEnabled(false);
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

        passwordConfirmField.setEnabled(false);
        passwordConfirmField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordConfirmFieldFocusLost(evt);
            }
        });

        updateConfirm.setBackground(new java.awt.Color(240, 87, 66));
        updateConfirm.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        updateConfirm.setForeground(new java.awt.Color(255, 255, 255));
        updateConfirm.setText("CONFIRMAR MODIFICACIÓN");
        updateConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateConfirmActionPerformed(evt);
            }
        });

        botonModificarDireccion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonModificarDireccion.setText("MODIFICAR DIRECCIÓN");
        botonModificarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarDireccionActionPerformed(evt);
            }
        });

        infoPass.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N

        infoConfirmPass.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N

        passwordAnteriorTxt.setText("Contraseña Anterior:");

        passwordAnteriorField.setEnabled(false);
        passwordAnteriorField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordAnteriorFieldFocusLost(evt);
            }
        });
        passwordAnteriorField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordAnteriorFieldActionPerformed(evt);
            }
        });

        infoPassAnterior.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N

        modificarPassCheck.setText("EDITAR CONTRASEÑA");
        modificarPassCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarPassCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(modificarPassCheck)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(passwordConfirmField)
                            .addComponent(botonModificarDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(emailField)
                            .addComponent(tlfField)
                            .addComponent(passwordField)
                            .addComponent(dniField)
                            .addComponent(apellidosField)
                            .addComponent(nombreField)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(emailTXT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(infoEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(passwordConfirmTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(infoConfirmPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dniTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(infoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nombreTXT)
                                .addGap(51, 51, 51)
                                .addComponent(infoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(apellidosTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(infoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tlfTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(infoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(infoPass, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(passwordAnteriorField)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(titleText)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(passwordAnteriorTxt)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(infoPassAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
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
                    .addComponent(infoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(tlfField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailTXT)
                    .addComponent(infoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(modificarPassCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(passwordAnteriorTxt)
                    .addComponent(infoPassAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordAnteriorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(46, 46, 46)
                .addComponent(botonModificarDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void updateConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateConfirmActionPerformed

        if (validaciones.validar(nombreField.getText(), PATRON_NOMBRES)
                && validaciones.validar(apellidosField.getText(), PATRON_APELLIDOS)
                && validaciones.validacionDNI(dniField.getText())
                && validaciones.validar(tlfField.getText(), PATRON_TELEFONO)
                && validaciones.validar(emailField.getText(), PATRON_EMAIL)
                && validarpassiguales()) {
            if (modificarDatos()) {
                if (updateInicio != null) {
                    updateInicio.doClick();
                }
                JOptionPane.showMessageDialog(this, "Usuario modificado con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }

        } else {
            JOptionPane.showMessageDialog(this, MENSAJE_ERROR_RELLENO_DATOS, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_updateConfirmActionPerformed

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

    private void botonModificarDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarDireccionActionPerformed
        //direccionUsuario = DireccionDao.obtenerDireccionUsuario(usuario);
        DialogoDireccion dialogoDireccion = new DialogoDireccion(this, true, direccionUsuario);
        dialogoDireccion.setVisible(true);
    }//GEN-LAST:event_botonModificarDireccionActionPerformed

    private void passwordAnteriorFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordAnteriorFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordAnteriorFieldFocusLost

    private void passwordAnteriorFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordAnteriorFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordAnteriorFieldActionPerformed

    private void modificarPassCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarPassCheckActionPerformed
        JCheckBox check = (JCheckBox) evt.getSource();
        if (check.isSelected()) {
            passwordAnteriorField.setEnabled(true);
            passwordField.setEnabled(true);
            passwordConfirmField.setEnabled(true);
        } else {
            passwordAnteriorField.setEnabled(false);
            passwordField.setEnabled(false);
            passwordConfirmField.setEnabled(false);
        }
    }//GEN-LAST:event_modificarPassCheckActionPerformed

    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("./recursos/logoIcon.png"));

        return retValue;
    }

    private boolean modificarPassword() {
        String passHash = usuario.getPassword();
        String tFieldPass = String.valueOf(passwordAnteriorField.getPassword());
        if (BCrypt.checkpw(tFieldPass, passHash)) {
            usuario.setPassword(BCrypt.hashpw(new String(passwordField.getPassword()), BCrypt.gensalt(10)));
            return true;
        }
        return false;
    }

    private boolean modificarDatos() {
        Usuario userCopia = usuario;

        if (modificarPassCheck.isSelected()) {
            if (!modificarPassword()) {
                passwordAnteriorTxt.setText("Incorrecta");
                JOptionPane.showMessageDialog(this, "Tu contraseña actual introducida es incorrecta", "Error al actualizar", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        if (DireccionDao.actualizarDireccion(direccionUsuario)) {
            usuario.setNombre(nombreField.getText());
            usuario.setApellidos(apellidosField.getText());
            usuario.setDni(dniField.getText());
            usuario.setTlf(tlfField.getText());
            usuario.setEmail(emailField.getText());

            System.out.println(usuario.getJSON());

            if (UsuarioDao.actualizarUsuario(usuario)) {
                return true;
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo actualizar el usuario", "Error al actualizar", JOptionPane.ERROR_MESSAGE);
                usuario = userCopia;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error, no se actualizó la dirección por lo que no se procedió a actualizar el usuario", "Error al registrar usuario", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private void establecerCamposIniciales(Usuario user) {
        direccionUsuario = DireccionDao.obtenerDireccionUsuario(usuario);
        nombreField.setText(user.getNombre());
        apellidosField.setText(user.getApellidos());
        tlfField.setText(user.getTlf());
        dniField.setText(user.getDni());
        emailField.setText(user.getEmail());
    }

    private void validarCampos() {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apellidosField;
    private javax.swing.JLabel apellidosTXT;
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
    private javax.swing.JLabel infoPassAnterior;
    private javax.swing.JLabel infoTelefono;
    private javax.swing.JCheckBox modificarPassCheck;
    private javax.swing.JTextField nombreField;
    private javax.swing.JLabel nombreTXT;
    private javax.swing.JPasswordField passwordAnteriorField;
    private javax.swing.JLabel passwordAnteriorTxt;
    private javax.swing.JPasswordField passwordConfirmField;
    private javax.swing.JLabel passwordConfirmTxt;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordTxt;
    private javax.swing.JLabel titleText;
    private javax.swing.JTextField tlfField;
    private javax.swing.JLabel tlfTXT;
    private javax.swing.JButton updateConfirm;
    // End of variables declaration//GEN-END:variables

}
