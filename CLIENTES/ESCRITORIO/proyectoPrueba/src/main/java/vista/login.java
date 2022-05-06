/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import controlador.UsuarioDao;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Usuario;
import org.mindrot.jbcrypt.BCrypt;
import util.validaciones;

/**
 *
 * @author jmcbg
 */
public class login extends javax.swing.JFrame implements util.Constantes{
    private Boolean passCorrecto;
    private String hash;
    private Usuario user;
    /**
     * Creates new form tests
     */
    public login() {
        initComponents();    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        buttonLogin1 = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        passwordTxt = new javax.swing.JLabel();
        emailTxt = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        buttonLogin = new javax.swing.JButton();
        titleText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio Sesión");
        setResizable(false);

        buttonLogin1.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        buttonLogin1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        buttonLogin1.setText("ENTRAR");
        buttonLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogin1ActionPerformed(evt);
            }
        });

        passwordTxt.setText("CONTRASEÑA");

        emailTxt.setText("CORREO ELECTRÓNICO");

        buttonLogin.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        buttonLogin.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        buttonLogin.setText("REGISTRO");
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        titleText.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titleText.setText("INICIAR SESIÓN");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailField)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(titleText))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(titleText, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(emailTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        new registro().setVisible(true);
    }//GEN-LAST:event_buttonLoginActionPerformed

    private void buttonLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogin1ActionPerformed
        comprobarLogin();
    }//GEN-LAST:event_buttonLogin1ActionPerformed

    private void comprobarLogin() {
        
        String tFieldEmail = emailField.getText();
        String tFieldPass = String.valueOf(passwordField.getPassword());
        
        if(validaciones.validar(tFieldEmail,PATRON_EMAIL) && validaciones.validar(tFieldPass,PATRON_PASS_USUARIO))
        
        user = new Usuario();
        user.setEmail(emailField.getText());
        user = UsuarioDao.getHash(user);
        hash = user.getPassword();
        passCorrecto = BCrypt.checkpw(tFieldPass,hash);
        
        if(passCorrecto){
            System.out.println("vista.login.comprobarLogin()  -   LOGEADO");
            user = UsuarioDao.obtenerDatosUsuario(user);
            String rol = user.getRol();

            switch (rol) {
                case CLIENTE:
                    
                    break;
                case ADMIN:
                    
                    break;
                case MERCADER:
                    
                    break;
                default:
                    throw new AssertionError();
            }
            
        }
       
    }

   /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {

        }
        new login().setVisible(true);
//        if (conex.testConexion()) {
//            new Login().setVisible(true);
//        } else {
//            showMessageDialog(null, "ERROR DE CONEXION CON EL SERVIDOR", "LOGIN", JOptionPane.ERROR_MESSAGE);
//            System.exit(0);
//        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin;
    private javax.swing.JButton buttonLogin1;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailTxt;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordTxt;
    private javax.swing.JLabel titleText;
    // End of variables declaration//GEN-END:variables
}
