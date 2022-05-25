/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista.mercader;

import vista.registroNegocio;
import controlador.NegocioDao;
import controlador.PedidoDao;
import controlador.ProductoDao;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import modelo.Negocio;
import modelo.Pedido;
import modelo.Producto;
import modelo.Usuario;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import util.WrapLayout;
import vista.FrameLogin;

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
        initComponents();
        mercader = user;
        negocio = NegocioDao.negocioDeMercader(user);
        mostrarPanelInicio();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonesMenu = new javax.swing.ButtonGroup();
        popupProductos = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        contenido = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        botonInfo = new javax.swing.JMenu();
        botonProductos = new javax.swing.JMenu();
        botonPedidos = new javax.swing.JMenu();

        jMenuItem1.setText("NUEVO PRODUCTO");
        popupProductos.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Mercader");

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setDoubleBuffered(true);

        contenido.setComponentPopupMenu(popupProductos);

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(contenido);

        jMenuBar1.setBackground(new java.awt.Color(255, 102, 0));

        botonInfo.setBackground(new java.awt.Color(255, 102, 0));
        botonInfo.setForeground(new java.awt.Color(255, 255, 255));
        botonInfo.setText("INICIO");
        botonesMenu.add(botonInfo);
        botonInfo.setDoubleBuffered(true);
        botonInfo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonInfoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deselección(evt);
            }
        });
        jMenuBar1.add(botonInfo);

        botonProductos.setBackground(new java.awt.Color(255, 102, 0));
        botonProductos.setForeground(new java.awt.Color(255, 255, 255));
        botonProductos.setText("PRODUCTOS");
        botonesMenu.add(botonProductos);
        botonProductos.setDoubleBuffered(true);
        botonProductos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonProductosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deselección(evt);
            }
        });
        jMenuBar1.add(botonProductos);

        botonPedidos.setText("PEDIDOS");
        botonesMenu.add(botonPedidos);
        botonPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonPedidos.setDoubleBuffered(true);
        botonPedidos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        botonPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonPedidosMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deselección(evt);
            }
        });
        jMenuBar1.add(botonPedidos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deselección(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deselección
        JMenu jm = (JMenu) evt.getComponent();
        jm.setSelected(false);
    }//GEN-LAST:event_deselección

    private void botonProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonProductosMouseClicked
        mostrarProductos();
    }//GEN-LAST:event_botonProductosMouseClicked

    private void botonInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonInfoMouseClicked
        mostrarPanelInicio();
    }//GEN-LAST:event_botonInfoMouseClicked

    private void botonPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonPedidosMouseClicked
        mostrarPedidos();
    }//GEN-LAST:event_botonPedidosMouseClicked

    private void mostrarProductos() {
        interrumpirHilo();
        contenido.removeAll();
        contenido.setLayout(new WrapLayout(FlowLayout.CENTER, 30, 30));
        contenido.add(new panelProductoNuevo());

        ArrayList<Producto> productos = ProductoDao.selecciónProductosNegocio(negocio);
        if (productos != null) {
            for (Producto producto : productos) {
                contenido.add(new panelProducto(producto));
            }
        }

        //no se
        contenido.setComponentPopupMenu(popupProductos);
        contenido.revalidate();
        contenido.repaint();
    }

    private void mostrarPanelInicio() {
        interrumpirHilo();
        contenido.removeAll();
        contenido.setLayout(new WrapLayout(FlowLayout.CENTER, 0, 0));
        contenido.add(new panelInicioM(negocio));
        contenido.revalidate();
        contenido.repaint();
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
                            Thread.sleep(1000);
                            System.out.println(".run() PEDIDOS ACTUALIZADOS");
                        }
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            });
            hiloUpdate.start();
        }

    }
    
    public void confirmarCierre(){
        try{
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e){
                    confirmarSalida();
                }
            });
            this.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
    }
    
    public void confirmarSalida(){
        int valor = JOptionPane.showConfirmDialog(this,"¿Esta seguro de que quiere abandonar esta ventana?", "Advertencia", JOptionPane.YES_NO_OPTION);
        if(valor == JOptionPane.YES_OPTION){
            
            JOptionPane.showMessageDialog(null, "Volverá a la ventana de Logueo", "Hasta luego!", JOptionPane.INFORMATION_MESSAGE);
            new FrameLogin().setVisible(true);
        }
        
    }

    private void mostrarPedidos() {
        /*crearHiloActualizacionDeProductos();
        ActionListener actualizarPedidos = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.err.println("MOSTRANDO LOS PEDIDOS");
                mostrarPedidos();
            }
        };*/
        jScrollPane1.setIgnoreRepaint(true);
        contenido.removeAll();
        contenido.setLayout(new WrapLayout(FlowLayout.CENTER, 30, 30));
        ArrayList<Pedido> pedidos = PedidoDao.seleccionTodosPedidos(negocio);
        if (pedidos != null) {
            for (Pedido pedido : pedidos) {
                contenido.add(new panelPedido(pedido, botonPedidos));
            }
        } else {
            contenido.add(new JLabel("NO HAY PEDIDOS"));
        }

        contenido.revalidate();
        contenido.repaint();

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu botonInfo;
    private javax.swing.JMenu botonPedidos;
    private javax.swing.JMenu botonProductos;
    private javax.swing.ButtonGroup botonesMenu;
    private javax.swing.JPanel contenido;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu popupProductos;
    // End of variables declaration//GEN-END:variables

}
