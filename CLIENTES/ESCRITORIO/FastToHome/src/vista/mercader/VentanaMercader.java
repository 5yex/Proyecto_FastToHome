/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.mercader;

import com.formdev.flatlaf.ui.FlatButtonBorder;
import controlador.ImagenDao;
import vista.registroNegocio;
import controlador.NegocioDao;
import controlador.PedidoDao;
import controlador.ProductoDao;
import controlador.UsuarioDao;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import modelo.Imagen;
import modelo.Negocio;
import modelo.Pedido;
import modelo.Producto;
import modelo.Usuario;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import util.WrapLayout;
import util.imagenesUtil;
import vista.FrameLogin;
import vista.actualizarNegocio;
import vista.administrador.DialogoActualizarDatos;

/**
 *
 * @author jmcbg
 */
public class VentanaMercader extends javax.swing.JFrame {

    private Usuario mercader;
    private Negocio negocio;
//    private final ActionListener actualizarProductos = new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            mostrarProductos();
//        }
//    };
//
//    private final ActionListener actualizarPedidos = new ActionListener() {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            System.err.println("MOSTRANDO LOS PEDIDOS");
//            mostrarPedidos();
//        }
//    };

    Thread hiloUpdate;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaMercader(Usuario user) {
        this.mercader = user;
        this.negocio = NegocioDao.negocioDeMercader(user);
        initComponents();
        inicilizacion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonesPedidos = new javax.swing.ButtonGroup();
        updateInicio = new javax.swing.JButton();
        panelTableado = new javax.swing.JTabbedPane();
        panelInicioAdmin = new javax.swing.JPanel();
        labelBienvenido = new javax.swing.JLabel();
        labelNombreMercader = new javax.swing.JLabel();
        nombreNegocio = new javax.swing.JLabel();
        botonModificarDatosMercader = new javax.swing.JButton();
        imgNegocio = new javax.swing.JLabel();
        btnModificarNegocio = new javax.swing.JButton();
        panelTablaProductos = new javax.swing.JPanel();
        busquedaProductos = new javax.swing.JTextField();
        checkBusquedaProductos = new javax.swing.JCheckBox();
        recargarProductos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelProductos = new javax.swing.JPanel();
        panelTablaPedidos = new javax.swing.JPanel();
        recargarPedidos = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        panelPedidos = new javax.swing.JPanel();
        autoUpdate = new javax.swing.JCheckBox();
        checkTodos = new javax.swing.JRadioButton();
        checkParaPreparar = new javax.swing.JRadioButton();
        checkParaEnviar = new javax.swing.JRadioButton();

        updateInicio.setText("jButton1");
        updateInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateInicioActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Mercader");
        setMinimumSize(new java.awt.Dimension(878, 665));
        setSize(new java.awt.Dimension(678, 465));

        panelTableado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelTableado.setMinimumSize(new java.awt.Dimension(678, 465));
        panelTableado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelTableadoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelTableadoMousePressed(evt);
            }
        });

        labelBienvenido.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelBienvenido.setText("Bienvenido:");
        labelBienvenido.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelNombreMercader.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelNombreMercader.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelNombreMercader.setText("nom");

        nombreNegocio.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        nombreNegocio.setText("Nombre Negocio");

        botonModificarDatosMercader.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botonModificarDatosMercader.setText("MODIFICA TUS DATOS");
        botonModificarDatosMercader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarDatosMercaderActionPerformed(evt);
            }
        });

        imgNegocio.setMaximumSize(new java.awt.Dimension(312, 312));
        imgNegocio.setMinimumSize(new java.awt.Dimension(312, 312));
        imgNegocio.setPreferredSize(new java.awt.Dimension(312, 312));

        btnModificarNegocio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnModificarNegocio.setText("PERSONALIZA TU NEGOCIO");
        btnModificarNegocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarNegocioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInicioAdminLayout = new javax.swing.GroupLayout(panelInicioAdmin);
        panelInicioAdmin.setLayout(panelInicioAdminLayout);
        panelInicioAdminLayout.setHorizontalGroup(
            panelInicioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioAdminLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelInicioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInicioAdminLayout.createSequentialGroup()
                        .addComponent(nombreNegocio)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelInicioAdminLayout.createSequentialGroup()
                        .addGroup(panelInicioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInicioAdminLayout.createSequentialGroup()
                                .addComponent(imgNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                .addGroup(panelInicioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botonModificarDatosMercader, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnModificarNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelInicioAdminLayout.createSequentialGroup()
                                .addComponent(labelBienvenido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNombreMercader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(14, 14, 14))))
        );
        panelInicioAdminLayout.setVerticalGroup(
            panelInicioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInicioAdminLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelInicioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelBienvenido)
                    .addComponent(labelNombreMercader, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(nombreNegocio)
                .addGroup(panelInicioAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInicioAdminLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInicioAdminLayout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(botonModificarDatosMercader, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificarNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );

        panelTableado.addTab("INICIO", panelInicioAdmin);

        busquedaProductos.setMinimumSize(new java.awt.Dimension(4, 22));

        checkBusquedaProductos.setText("Búsqueda por nombre:");
        checkBusquedaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBusquedaProductosActionPerformed(evt);
            }
        });

        recargarProductos.setText("RECARGAR PRODUCTOS");
        recargarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recargarProductosActionPerformed(evt);
            }
        });

        jScrollPane1.setMinimumSize(new java.awt.Dimension(0, 0));

        panelProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panelProductosLayout = new javax.swing.GroupLayout(panelProductos);
        panelProductos.setLayout(panelProductosLayout);
        panelProductosLayout.setHorizontalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
        );
        panelProductosLayout.setVerticalGroup(
            panelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(panelProductos);

        javax.swing.GroupLayout panelTablaProductosLayout = new javax.swing.GroupLayout(panelTablaProductos);
        panelTablaProductos.setLayout(panelTablaProductosLayout);
        panelTablaProductosLayout.setHorizontalGroup(
            panelTablaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(checkBusquedaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(busquedaProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(recargarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelTablaProductosLayout.setVerticalGroup(
            panelTablaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaProductosLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTablaProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recargarProductos)
                    .addComponent(busquedaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkBusquedaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelTableado.addTab("PRODUCTOS", panelTablaProductos);

        recargarPedidos.setText("ACTUALIZAR");
        recargarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recargarPedidosActionPerformed(evt);
            }
        });

        jScrollPane2.setMinimumSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout panelPedidosLayout = new javax.swing.GroupLayout(panelPedidos);
        panelPedidos.setLayout(panelPedidosLayout);
        panelPedidosLayout.setHorizontalGroup(
            panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
        );
        panelPedidosLayout.setVerticalGroup(
            panelPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 395, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(panelPedidos);

        autoUpdate.setText("Auto Actualizar");
        autoUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoUpdateActionPerformed(evt);
            }
        });

        botonesPedidos.add(checkTodos);
        checkTodos.setSelected(true);
        checkTodos.setText("Mostrar Todos");
        checkTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkTodosActionPerformed(evt);
            }
        });

        botonesPedidos.add(checkParaPreparar);
        checkParaPreparar.setText("Para Preparar");
        checkParaPreparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkParaPrepararActionPerformed(evt);
            }
        });

        botonesPedidos.add(checkParaEnviar);
        checkParaEnviar.setText("Para Enviar");
        checkParaEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkParaEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTablaPedidosLayout = new javax.swing.GroupLayout(panelTablaPedidos);
        panelTablaPedidos.setLayout(panelTablaPedidosLayout);
        panelTablaPedidosLayout.setHorizontalGroup(
            panelTablaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaPedidosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(autoUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkParaPreparar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkParaEnviar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(recargarPedidos)
                .addContainerGap())
        );
        panelTablaPedidosLayout.setVerticalGroup(
            panelTablaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaPedidosLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTablaPedidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recargarPedidos)
                    .addComponent(autoUpdate)
                    .addComponent(checkTodos)
                    .addComponent(checkParaPreparar)
                    .addComponent(checkParaEnviar))
                .addGap(7, 7, 7))
        );

        panelTableado.addTab("PEDIDOS", panelTablaPedidos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTableado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTableado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonModificarDatosMercaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarDatosMercaderActionPerformed
        DialogoActualizarDatos dmod = new DialogoActualizarDatos(this, true, mercader, updateInicio);
        dmod.setVisible(true);
    }//GEN-LAST:event_botonModificarDatosMercaderActionPerformed

    private void checkBusquedaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBusquedaProductosActionPerformed

    }//GEN-LAST:event_checkBusquedaProductosActionPerformed

    private void panelTableadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTableadoMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_panelTableadoMousePressed

    private void recargarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargarProductosActionPerformed
        mostrarProductos();
    }//GEN-LAST:event_recargarProductosActionPerformed

    private void recargarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recargarPedidosActionPerformed
        mostrarPedidos();
    }//GEN-LAST:event_recargarPedidosActionPerformed

    private void autoUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoUpdateActionPerformed
        JCheckBox hilo = (JCheckBox) evt.getSource();
        if (hilo.isSelected()) {
            crearHiloActualizacionDeProductos();
        } else {
            interrumpirHilo();
        }
    }//GEN-LAST:event_autoUpdateActionPerformed

    private void checkTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkTodosActionPerformed
        mostrarPedidos();
    }//GEN-LAST:event_checkTodosActionPerformed

    private void checkParaPrepararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkParaPrepararActionPerformed
        mostrarPedidosPagados();

    }//GEN-LAST:event_checkParaPrepararActionPerformed

    private void panelTableadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTableadoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_panelTableadoMouseClicked

    private void btnModificarNegocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarNegocioActionPerformed
        actualizarNegocio dialogoEditarNegocio = new actualizarNegocio(negocio, updateInicio);
        dialogoEditarNegocio.setVisible(true);

    }//GEN-LAST:event_btnModificarNegocioActionPerformed

    private void updateInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateInicioActionPerformed
        negocio = NegocioDao.negocioDeMercader(mercader);
        cargarInicio();

    }//GEN-LAST:event_updateInicioActionPerformed

    private void checkParaEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkParaEnviarActionPerformed
        mostrarPedidosEnPreparacion();
    }//GEN-LAST:event_checkParaEnviarActionPerformed

    private void inicilizacion() {
        confirmarCierre();
        cargarInicio();
        mostrarProductos();
        mostrarPedidos();
        englobarRadioButtons();
    }

    private void cargarInicio() {
        mercader = UsuarioDao.obtenerDatosUsuario(mercader);
        labelNombreMercader.setText(mercader.getNombre() + "  " + mercader.getApellidos());
        nombreNegocio.setText(negocio.getNombre());
        imagenesUtil.imagenB64Ajlabel(ImagenDao.obtenerImagenPorId(new Imagen(negocio.getId_img())), imgNegocio);

    }

    public void mostrarProductos() {
        //interrumpirHilo();
        panelProductos.removeAll();
        panelProductos.setLayout(new WrapLayout(FlowLayout.CENTER, 30, 30));
        panelProductos.add(new panelProductoNuevo(recargarProductos, negocio));

        ArrayList<Producto> productos = ProductoDao.selecciónProductosNegocio(negocio);
        if (productos != null) {
            for (Producto producto : productos) {
                //System.out.print(producto.toString());
                panelProductos.add(new panelProducto(producto, recargarProductos));
            }
        }

        //no se
        panelProductos.revalidate();
        panelProductos.repaint();
    }

    private void interrumpirHilo() {
        if (hiloUpdate != null) {
            hiloUpdate.interrupt();
            hiloUpdate = null;
        }

    }

    private void crearHiloActualizacionDeProductos() {
        if (hiloUpdate == null) {
            hiloUpdate = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            mostrarPedidos();
                            Thread.sleep(2000);
                            System.out.println(".run() PEDIDOS ACTUALIZADOS");
                        }
                    } catch (InterruptedException ex) {
                        System.out.println(".run() HILO ABORTADO");
                    }
                }
            });
            hiloUpdate.start();
        }
    }

    private void mostrarPedidosPagados() {
        //crearHiloActualizacionDeProductos();
        ActionListener actualizarPedidos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.err.println("MOSTRANDO LOS PEDIDOS");
                mostrarPedidos();
            }
        };
        jScrollPane1.setIgnoreRepaint(true);
        panelPedidos.removeAll();
        panelPedidos.setLayout(new WrapLayout(FlowLayout.CENTER, 30, 30));
        ArrayList<Pedido> pedidos = PedidoDao.seleccionPedidosPagados(negocio);
        if (pedidos != null) {
            for (Pedido pedido : pedidos) {
                panelPedidos.add(new panelPedido(pedido, recargarPedidos));
            }
        } else {
            panelPedidos.add(new JLabel("NO HAY PEDIDOS"));
        }

        panelPedidos.revalidate();
        panelPedidos.repaint();

    }

    private void mostrarPedidosEnPreparacion() {
        //crearHiloActualizacionDeProductos();
        ActionListener actualizarPedidos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.err.println("MOSTRANDO LOS PEDIDOS");
                mostrarPedidos();
            }
        };
        jScrollPane1.setIgnoreRepaint(true);
        panelPedidos.removeAll();
        panelPedidos.setLayout(new WrapLayout(FlowLayout.CENTER, 30, 30));
        ArrayList<Pedido> pedidos = PedidoDao.seleccionPedidosEnPreparacion(negocio);
        if (pedidos != null) {
            for (Pedido pedido : pedidos) {
                panelPedidos.add(new panelPedido(pedido, recargarPedidos));
            }
        } else {
            panelPedidos.add(new JLabel("NO HAY PEDIDOS"));
        }

        panelPedidos.revalidate();
        panelPedidos.repaint();

    }

    private void mostrarPedidos() {
        //crearHiloActualizacionDeProductos();
        ActionListener actualizarPedidos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.err.println("MOSTRANDO LOS PEDIDOS");
                mostrarPedidos();
            }
        };
        jScrollPane1.setIgnoreRepaint(true);
        panelPedidos.removeAll();
        panelPedidos.setLayout(new WrapLayout(FlowLayout.CENTER, 30, 30));

        ArrayList<Pedido> pedidos = null;

        if (checkTodos.isSelected()) {
            pedidos = PedidoDao.seleccionPedidosEnPreparacion(negocio);
        } else {
            if (checkParaEnviar.isSelected()) {
                pedidos = PedidoDao.seleccionPedidosEnPreparacion(negocio);
            }
            if (checkParaPreparar.isSelected()) {
                pedidos = PedidoDao.seleccionPedidosPagados(negocio);
            }
        }

        if (pedidos != null) {
            for (Pedido pedido : pedidos) {
                panelPedidos.add(new panelPedido(pedido, recargarPedidos));
            }
        } else {
            panelPedidos.add(new JLabel("NO HAY PEDIDOS"));
        }

        panelPedidos.revalidate();
        panelPedidos.repaint();

    }

    public void englobarRadioButtons() {
        ButtonGroup grupoEstados = new ButtonGroup();
        grupoEstados.add(checkTodos);
        grupoEstados.add(checkParaPreparar);
        grupoEstados.add(checkParaEnviar);
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
        int valor = JOptionPane.showConfirmDialog(this, "¿Esta seguro de que quiere abandonar esta ventana?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if (valor == JOptionPane.YES_OPTION) {

            JOptionPane.showMessageDialog(null, "Volverá a la ventana de Logueo", "Hasta luego!", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            new FrameLogin().setVisible(true);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox autoUpdate;
    private javax.swing.JButton botonModificarDatosMercader;
    private javax.swing.ButtonGroup botonesPedidos;
    private javax.swing.JButton btnModificarNegocio;
    private javax.swing.JTextField busquedaProductos;
    private javax.swing.JCheckBox checkBusquedaProductos;
    private javax.swing.JRadioButton checkParaEnviar;
    private javax.swing.JRadioButton checkParaPreparar;
    private javax.swing.JRadioButton checkTodos;
    private javax.swing.JLabel imgNegocio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelBienvenido;
    private javax.swing.JLabel labelNombreMercader;
    private javax.swing.JLabel nombreNegocio;
    private javax.swing.JPanel panelInicioAdmin;
    private javax.swing.JPanel panelPedidos;
    private javax.swing.JPanel panelProductos;
    private javax.swing.JPanel panelTablaPedidos;
    private javax.swing.JPanel panelTablaProductos;
    private javax.swing.JTabbedPane panelTableado;
    private javax.swing.JButton recargarPedidos;
    private javax.swing.JButton recargarProductos;
    private javax.swing.JButton updateInicio;
    // End of variables declaration//GEN-END:variables

}
