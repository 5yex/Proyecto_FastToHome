/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.donoso.proyectoprueba.principal;
import controlador.UsuarioDao;
import modelo.Usuario;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author jmcbg
 */
public class registro extends javax.swing.JFrame {

    private Usuario newUsuario = new Usuario();

    /**
     * Creates new form tests
     */
    public registro() {
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
        registerConfirm = new javax.swing.JButton();
        nombreField = new javax.swing.JTextField();
        nombreTXT = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        passwordConfirmField = new javax.swing.JPasswordField();
        apellidosField = new javax.swing.JTextField();
        tlfField = new javax.swing.JTextField();
        apellidosTXT = new javax.swing.JLabel();
        dniTXT = new javax.swing.JLabel();
        passwordConfirmTxt = new javax.swing.JLabel();
        dniField = new javax.swing.JTextField();
        tlfTXT = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        emailTXT = new javax.swing.JLabel();

        setDefaultCloseOperation(cerrar());
        setTitle("Inicio Sesión");
        setAlwaysOnTop(true);
        setResizable(false);

        titleText.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titleText.setText("REGISTRO DE USUARIO");

        registerConfirm.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        registerConfirm.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        registerConfirm.setText("CONFIRMAR REGISTRO");
        registerConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerConfirmActionPerformed(evt);
            }
        });

        nombreTXT.setText("NOMBRE");

        passwordTxt.setText("CONTRASEÑA");

        apellidosTXT.setText("APELLIDOS");

        dniTXT.setText("DNI");

        passwordConfirmTxt.setText("CONFIRMAR CONTRASEÑA");

        tlfTXT.setText("TELÉFONO");

        emailTXT.setText("CORREO ELECTRÓNICO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tlfTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(dniField)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dniTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apellidosTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                .addComponent(registerConfirm, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
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
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerConfirmActionPerformed
        registrarUsuario();

    }//GEN-LAST:event_registerConfirmActionPerformed

    private void registrarUsuario() {
        newUsuario.setNombre(nombreField.getText());
        newUsuario.setDni(dniField.getText());
        newUsuario.setTlf(tlfField.getText());
        newUsuario.setEmail(emailField.getText());
        newUsuario.setPassword(BCrypt.hashpw(new String(passwordField.getPassword()), BCrypt.gensalt(10)));
        newUsuario.setRol("cliente");
        System.out.println(newUsuario.getJSON());
        
        
        UsuarioDao.nuevoUsuario(newUsuario);
        principal.lg.setVisible(true);
        this.setVisible(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
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

    private int cerrar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
