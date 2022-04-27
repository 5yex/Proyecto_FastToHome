package vista;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import controlador.conexion;
import controlador.usuarioDAO;
import java.awt.Color;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.UnsupportedLookAndFeelException;
import modelo.usuario;
import vista.paneles.informacionUsuario;

public class Login extends javax.swing.JFrame {

    int xMouse, yMouse;
    static conexion conex = new conexion("jmcbg.es", "starconex", "test", "1234");

    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        recordarme = new javax.swing.JCheckBox();
        title = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        userDNI = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        passLabel = new javax.swing.JLabel();
        passTxt = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        loginBtn = new javax.swing.JPanel();
        loginBtnTxt = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        panellado = new javax.swing.JLabel();
        exitBtn = new javax.swing.JPanel();
        exitTxt = new javax.swing.JLabel();
        registrarse = new javax.swing.JPanel();
        registrarsetxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(239, 246, 253));
        bg.setEnabled(false);
        bg.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bgMouseDragged(evt);
            }
        });
        bg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bgMousePressed(evt);
            }
        });
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recordarme.setBackground(new java.awt.Color(239, 246, 253));
        recordarme.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        recordarme.setText("Recordarme");
        recordarme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordarmeActionPerformed(evt);
            }
        });
        bg.add(recordarme, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 110, 30));

        title.setBackground(new java.awt.Color(239, 246, 253));
        title.setFont(new java.awt.Font("Roboto Black", 1, 24)); // NOI18N
        title.setText("INICIAR SESIÓN");
        bg.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        userLabel.setBackground(new java.awt.Color(239, 246, 253));
        userLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        userLabel.setText("DNI");
        bg.add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 70, -1));

        userDNI.setBackground(new java.awt.Color(225, 239, 253));
        userDNI.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        userDNI.setText("1234");
        userDNI.setToolTipText("");
        userDNI.setBorder(null);
        userDNI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userDNIMousePressed(evt);
            }
        });
        userDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userDNIActionPerformed(evt);
            }
        });
        bg.add(userDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 280, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 280, 20));

        passLabel.setBackground(new java.awt.Color(239, 246, 253));
        passLabel.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N
        passLabel.setText("CONTRASEÑA");
        bg.add(passLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 110, -1));

        passTxt.setBackground(new java.awt.Color(225, 239, 253));
        passTxt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        passTxt.setText("1234");
        passTxt.setBorder(null);
        passTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTxtMousePressed(evt);
            }
        });
        bg.add(passTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 280, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 280, 20));

        loginBtn.setBackground(new java.awt.Color(0, 0, 204));

        loginBtnTxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        loginBtnTxt.setForeground(new java.awt.Color(255, 255, 255));
        loginBtnTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginBtnTxt.setText("ENTRAR");
        loginBtnTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loginBtnTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBtnTxtMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loginBtnTxtMousePressed(evt);
            }
        });

        javax.swing.GroupLayout loginBtnLayout = new javax.swing.GroupLayout(loginBtn);
        loginBtn.setLayout(loginBtnLayout);
        loginBtnLayout.setHorizontalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        loginBtnLayout.setVerticalGroup(
            loginBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginBtnTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 280, -1));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/logo.png"))); // NOI18N
        bg.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 180, -1));

        panellado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/images/space.png"))); // NOI18N
        bg.add(panellado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 480));

        exitBtn.setBackground(new java.awt.Color(239, 246, 253));

        exitTxt.setBackground(new java.awt.Color(239, 246, 253));
        exitTxt.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        exitTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exitTxt.setText("X");
        exitTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exitTxt.setPreferredSize(new java.awt.Dimension(40, 40));
        exitTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitTxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitTxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitTxtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exitBtnLayout = new javax.swing.GroupLayout(exitBtn);
        exitBtn.setLayout(exitBtnLayout);
        exitBtnLayout.setHorizontalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        exitBtnLayout.setVerticalGroup(
            exitBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exitTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bg.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, -1, -1));

        registrarse.setBackground(new java.awt.Color(0, 0, 204));

        registrarsetxt.setFont(new java.awt.Font("Roboto Condensed", 1, 14)); // NOI18N
        registrarsetxt.setForeground(new java.awt.Color(255, 255, 255));
        registrarsetxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrarsetxt.setText("REGISTRARSE");
        registrarsetxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        registrarsetxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registrarsetxtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registrarsetxtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registrarsetxtMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                registrarsetxtMousePressed(evt);
            }
        });

        javax.swing.GroupLayout registrarseLayout = new javax.swing.GroupLayout(registrarse);
        registrarse.setLayout(registrarseLayout);
        registrarseLayout.setHorizontalGroup(
            registrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registrarsetxt, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        registrarseLayout.setVerticalGroup(
            registrarseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(registrarsetxt, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        bg.add(registrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 280, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitTxtMouseClicked

    private void exitTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseEntered
        exitBtn.setBackground(Color.red);
        exitTxt.setForeground(Color.white);
    }//GEN-LAST:event_exitTxtMouseEntered

    private void exitTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitTxtMouseExited
        exitBtn.setBackground(new Color(239, 246, 253));
        exitTxt.setForeground(Color.black);
    }//GEN-LAST:event_exitTxtMouseExited

    private void userDNIMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userDNIMousePressed

    }//GEN-LAST:event_userDNIMousePressed

    private void passTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTxtMousePressed

    }//GEN-LAST:event_passTxtMousePressed

    private void recordarmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordarmeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_recordarmeActionPerformed

    private void bgMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_bgMouseDragged

    private void bgMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bgMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_bgMousePressed

    private void loginBtnTxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseExited
        loginBtn.setBackground(Color.BLUE);
    }//GEN-LAST:event_loginBtnTxtMouseExited

    private void loginBtnTxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseEntered
        loginBtn.setBackground(new Color(0, 102, 255));
    }//GEN-LAST:event_loginBtnTxtMouseEntered

    private void loginBtnTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMouseClicked
        //   javax.swing.JOptionPane.showMessageDialog(this, "Intento de login con los datos:\nUsuario: " + userTxt.getText() + "\nContraseña: " + String.valueOf(passTxt.getPassword()), "LOGIN", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_loginBtnTxtMouseClicked

    private void userDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userDNIActionPerformed

    private void registrarsetxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarsetxtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_registrarsetxtMouseClicked

    private void registrarsetxtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarsetxtMouseEntered
        registrarse.setBackground(new Color(0, 102, 255));
    }//GEN-LAST:event_registrarsetxtMouseEntered

    private void registrarsetxtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarsetxtMouseExited
        registrarse.setBackground(Color.BLUE);
    }//GEN-LAST:event_registrarsetxtMouseExited

    private void loginBtnTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnTxtMousePressed
        comenzarConexion();
    }//GEN-LAST:event_loginBtnTxtMousePressed

    private void registrarsetxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarsetxtMousePressed
        //JOptionPane.showOptionDialog(null,new informacionUsuario(conex),);
        JOptionPane.showOptionDialog(null, new informacionUsuario(conex), "Selector de opciones", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"SALIR"}, "SALIR");
    }//GEN-LAST:event_registrarsetxtMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (conex.testConexion()) {
            new Login().setVisible(true);
        } else {
            showMessageDialog(null, "ERROR DE CONEXION CON EL SERVIDOR", "LOGIN", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JPanel exitBtn;
    private javax.swing.JLabel exitTxt;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel loginBtn;
    private javax.swing.JLabel loginBtnTxt;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel panellado;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JCheckBox recordarme;
    private javax.swing.JPanel registrarse;
    private javax.swing.JLabel registrarsetxt;
    private javax.swing.JLabel title;
    private javax.swing.JTextField userDNI;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
/**
     * Método que comienza la conexión e invoca a la pantalla principal,
     * pasandole el usuario que ha iniciado la sesión.
     */
    private void comenzarConexion() {
        usuario userTmp = new usuario(String.valueOf(passTxt.getPassword()), userDNI.getText());
        if (usuarioDAO.validarUsuario(conex, userTmp)) {
            this.dispose();
            VentanaPrincipal vp = new VentanaPrincipal(usuarioDAO.obtenerUsuarioPricipal(conex, userTmp), conex);
            vp.setVisible(true);
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "USUARIO O CONTRASEÑA INCORRECTOS", "LOGIN", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
}
