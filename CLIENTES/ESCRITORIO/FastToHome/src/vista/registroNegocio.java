/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.CategoriaDao;
import controlador.DireccionDao;
import controlador.ImagenDao;
import controlador.NegocioDao;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Categoria;
import modelo.Direccion;
import modelo.Imagen;
import modelo.Negocio;
import modelo.Usuario;
import vista.mercader.VentanaMercader;

/**
 *
 * @author jmcbg
 */
public class registroNegocio extends javax.swing.JFrame {

    private Usuario User;
    private Direccion nDireccion = new Direccion();
    private Imagen nImg = new Imagen();
    private ArrayList<Categoria> listaCategorias;

    /**
     * Creates new form VentanaRegistroNegocio
     *
     * @param user
     */
    public registroNegocio(Usuario user) {
        initComponents();
        this.User = user;
        this.setIconImage(new ImageIcon(getClass().getResource("/recursos/logoIcon.png")).getImage());
        cargaInicial();
        confirmarCierre();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titleText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        varNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDescripcion = new javax.swing.JTextArea();
        botonPedirImagen = new javax.swing.JButton();
        comboCategoria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        botonCompletarRegistro = new javax.swing.JButton();
        botonPedirDireccion = new javax.swing.JButton();
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro Negocio");
        setResizable(false);

        titleText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleText.setText("REGISTRAR NEGOCIO:");

        jLabel1.setText("NOMBRE");

        jLabel2.setText("DESCRIPCIÓN");

        textAreaDescripcion.setColumns(20);
        textAreaDescripcion.setRows(5);
        jScrollPane1.setViewportView(textAreaDescripcion);

        botonPedirImagen.setText("Subir logo del negocio");
        botonPedirImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPedirImagenActionPerformed(evt);
            }
        });

        jLabel3.setText("CATEGORÍA");

        botonCompletarRegistro.setBackground(new java.awt.Color(240, 87, 66));
        botonCompletarRegistro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botonCompletarRegistro.setForeground(new java.awt.Color(255, 255, 255));
        botonCompletarRegistro.setText("COMPLETAR REGISTRO");
        botonCompletarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCompletarRegistroActionPerformed(evt);
            }
        });

        botonPedirDireccion.setText("Añadir dirección del negocio");
        botonPedirDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPedirDireccionActionPerformed(evt);
            }
        });

        error.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
        error.setForeground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        error.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(varNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(titleText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1)
                    .addComponent(botonCompletarRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonPedirImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonPedirDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(titleText)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(varNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonPedirImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonPedirDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCompletarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonPedirDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedirDireccionActionPerformed
        new DialogoDireccion(this, rootPaneCheckingEnabled, nDireccion).setVisible(true);
    }//GEN-LAST:event_botonPedirDireccionActionPerformed

    private void botonCompletarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCompletarRegistroActionPerformed
        if (nuevoNegocio(User)) {
            new VentanaMercader(User).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_botonCompletarRegistroActionPerformed

    private void botonPedirImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPedirImagenActionPerformed
        new DialogoImagen(this, rootPaneCheckingEnabled, nImg).setVisible(true);
    }//GEN-LAST:event_botonPedirImagenActionPerformed

    private void cargaInicial() {
        
        listaCategorias = controlador.CategoriaDao.obtenerCategorias();
        for (Categoria listaCategoria : listaCategorias) {
            comboCategoria.addItem(listaCategoria.getNombre());
        }
        JOptionPane.showMessageDialog(null, User.getNombre() + ", bienvenido al equipo de mercaderes! \n A continuación podrás configurar tu negocio.","Bienvenida mercader", JOptionPane.INFORMATION_MESSAGE);
        textAreaDescripcion.setLineWrap(true);
    }

    private boolean nuevoNegocio(Usuario user) {

        try {

            String nombre = varNombre.getText();
            String descripcion = textAreaDescripcion.getText();

            if (descripcion.length() == 0 | nombre.length() == 0) {
                throw new IOException("Rellena todos los campos");
            }
            if (nDireccion.isValida()) {
                if (nImg.getB64_imagen() != null && !nImg.getB64_imagen().isBlank()) {
                    int id_direccion = DireccionDao.nuevaDireccionDevuelveId(nDireccion);

                    int id_imagen = ImagenDao.nuevaImagenDevuelveId(nImg);

                    if (id_direccion != -1 && id_imagen != -1) {
                        Categoria categoria = new Categoria();
                        categoria.setNombre(comboCategoria.getSelectedItem().toString());
                        int id_categoria = CategoriaDao.ObtenerIdPorNombre(categoria);
                        Negocio negocio = new Negocio();
                        negocio.setNombre(nombre);
                        negocio.setDescripcion(descripcion);
                        negocio.setId_categoria(id_categoria);
                        negocio.setId_mercader(user.getId());
                        negocio.setId_direccion(id_direccion);
                        negocio.setId_img(id_imagen);
                        return NegocioDao.nuevoNegocio(negocio);
                    }
                } else {
                    error.setText("Tienes que subir una imagen");
                    return false;

                }
            } else {
                error.setText("Rellena la direccion");
                return false;

            }
        } catch (NumberFormatException ex) {
            error.setText("Rellena correctamente los campos numéricos");
            return false;
        } catch (IOException ex) {
            error.setText(ex.getMessage());
            return false;
        }
        return true;
    }
    
    public void confirmarCierre() {
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    confirmarSalida();
                }
            });
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void confirmarSalida() {
        Object[] options = {"Si","No"};
        
        int valor = JOptionPane.showOptionDialog(this,"¿Esta seguro de que quiere abandonar esta ventana? \n Tendrá que configurar el negocio de nuevo cuando vuelva a entrar", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,options, options[0]);
        if (valor == JOptionPane.YES_OPTION) {

            JOptionPane.showMessageDialog(null, "Volverá a la ventana de Logueo", "Hasta luego!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new FrameLogin().setVisible(true);
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCompletarRegistro;
    private javax.swing.JButton botonPedirDireccion;
    private javax.swing.JButton botonPedirImagen;
    private javax.swing.JComboBox<String> comboCategoria;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAreaDescripcion;
    private javax.swing.JLabel titleText;
    private javax.swing.JTextField varNombre;
    // End of variables declaration//GEN-END:variables
}
