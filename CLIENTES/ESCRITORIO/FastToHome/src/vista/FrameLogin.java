/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import vista.mercader.VentanaMercader;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import controlador.NegocioDao;
import controlador.UsuarioDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.Negocio;
import modelo.Usuario;
import org.mindrot.jbcrypt.BCrypt;
import util.imagenesUtil;
import vista.administrador.VentanaAdmin;

/**
 * Clase que representa la ventana del Login
 * 
 * @author Jose Miguel Caderón, Jesús Rueda
 * @version 1.0
 */
public class FrameLogin extends javax.swing.JFrame implements util.Constantes {

    /**
     * Creates new form tests
     */
    public FrameLogin() {
        initComponents();
        imagenesUtil.imagenProyectoAjlabel(new ImageIcon(getClass().getResource("/recursos/logoGrandeBlanco.png")), jLabel1);
        this.setIconImage(new ImageIcon(getClass().getResource("/recursos/logoIcon.png")).getImage());
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
        buttonRegistro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio Sesión");
        setResizable(false);

        buttonLogin1.setBackground(new java.awt.Color(240, 87, 66));
        buttonLogin1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        buttonLogin1.setForeground(new java.awt.Color(255, 255, 255));
        buttonLogin1.setText("ENTRAR");
        buttonLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogin1ActionPerformed(evt);
            }
        });

        passwordTxt.setText("CONTRASEÑA");

        emailTxt.setText("CORREO ELECTRÓNICO");

        buttonRegistro.setBackground(new java.awt.Color(240, 87, 66));
        buttonRegistro.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        buttonRegistro.setForeground(new java.awt.Color(255, 255, 255));
        buttonRegistro.setText("REGISTRO");
        buttonRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistroActionPerformed(evt);
            }
        });

        jLabel1.setMaximumSize(new java.awt.Dimension(289, 289));
        jLabel1.setMinimumSize(new java.awt.Dimension(289, 289));
        jLabel1.setPreferredSize(new java.awt.Dimension(289, 289));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar tema", "Tema Claro", "Tema Oscuro" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailField)
                    .addComponent(passwordField)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(buttonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLogin1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistroActionPerformed
        //new PruebaRegistro().setVisible(true);
        //this.dispose();
        new registrarUsuario(this, true).setVisible(true);
    }//GEN-LAST:event_buttonRegistroActionPerformed

    private void buttonLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogin1ActionPerformed
        if(comprobarLogin()){
            this.dispose();
        }      
    }//GEN-LAST:event_buttonLogin1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            int index = ((JComboBox) evt.getSource()).getSelectedIndex();

            if (index == 1) {
                UIManager.setLookAndFeel(new FlatLightLaf());
            }
            if (index == 2) {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            }
            if (index != 0) {
                this.dispose();
                new FrameLogin().setVisible(true);
            }

        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FrameLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private boolean comprobarLogin() {        
        String tFieldEmail = emailField.getText();
        String tFieldPass = String.valueOf(passwordField.getPassword());
        if (tFieldEmail.length() > 0 && tFieldPass.length() > 0) {
            boolean passCorrecto = false;
            Usuario user = new Usuario(tFieldEmail);
            user = UsuarioDao.getHash(user);
            if (user != null) {
                String passHash = user.getPassword();
                passCorrecto = BCrypt.checkpw(tFieldPass, passHash);
                if (passCorrecto) {
                    System.out.println("vista.login.comprobarLogin()  -   LOGEADO");
                    user = UsuarioDao.obtenerDatosUsuario(user);
                    String rol = user.getRol();
                    switch (rol) {
                        case CLIENTE:
                            JOptionPane.showMessageDialog(this, "No está disponible una aplicación de escritorio para los clientes.\n"
                                    + "Si quieres registrar tu negocio y acceder como mercader, solicítalo a los adminsitradores.\n"
                                    + "Si eres un nuevo administrador y no puedes entrar, espera a que un administrador te registre como tal.", "Advertencia.", JOptionPane.INFORMATION_MESSAGE);
                            return false;
                        case ADMIN:
                            this.setEnabled(false);
                            VentanaAdmin ventanaAdmin = new VentanaAdmin(user);
                            ventanaAdmin.setVisible(true);
                            break;
                        case MERCADER:
                            ventanaMercader(user);
                            break;
                        default:
                            throw new AssertionError();       
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "La contraseña introducida no es correcta", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(this, "El usuario introducido no existe", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                return false;
                
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ambos campos deben estar rellenos para iniciar sesion", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    /*public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().
        getImage(ClassLoader.getSystemResource("./recursos/logoIcon.png"));

        return retValue;
    }*/
    private void ventanaMercader(Usuario user) {
        Negocio negocio;
        this.setVisible(false);

        negocio = NegocioDao.negocioDeMercader(user);
        if (negocio == null) {
            new registroNegocio(user).setVisible(true);
        } else {
            new VentanaMercader(user).setVisible(true);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogin1;
    private javax.swing.JButton buttonRegistro;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailTxt;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordTxt;
    // End of variables declaration//GEN-END:variables
}
