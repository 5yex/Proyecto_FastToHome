/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.mercader;

import com.formdev.flatlaf.ui.FlatButtonBorder;
import controlador.DireccionDao;
import controlador.PedidoDao;
import java.awt.event.ActionListener;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.swing.JButton;
import javax.swing.JMenu;
import modelo.Direccion;
import modelo.Usuario;
import modelo.Pedido;
import modelo.Producto;

/**
 * Clase que representa el panel con la información del pedido
 * 
 * @author Jose Miguel Calderón, Jesus Rueda
 * @versio 1.0
 * @since 1.0
 */
public class PanelPedido extends javax.swing.JPanel {
    private Pedido pedido;
    private ActionListener actualizarPedido;
    private JButton botonPedidos;
    /**
     * Creates new form producto
     */

    /**
     * Construye un PanelPedido
     * 
     * @param pedido objeto de tipo Pedido con la información del pedido
     * @param botonPedidos boton 'ACTUALIZAR' de la sección 'PEDIDOS' de la ventana de mercaderes
     */
    public PanelPedido(Pedido pedido, JButton botonPedidos){
        initComponents();
        this.pedido = pedido;
        this.botonPedidos = botonPedidos;
        mostrarDatos();
    }
    
    /**
     * Construye un PanelPedido
     * 
     * @param pedido objeto de tipo Pedido con la información del pedido
     */
    public PanelPedido(Pedido pedido){
        initComponents();
        this.pedido = pedido;
        mostrarDatos();}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloTransporte = new javax.swing.JLabel();
        pasarEstado = new javax.swing.JButton();
        tituloEstadoPedido = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        tituloIdPedido = new javax.swing.JLabel();
        numPedido = new javax.swing.JLabel();
        tipoTransporte = new javax.swing.JLabel();
        estadoActualPedido = new javax.swing.JLabel();
        verMapa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        infoDireccion = new javax.swing.JTextArea();

        tituloTransporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tituloTransporte.setText("TRANSPORTE:");

        pasarEstado.setBackground(new java.awt.Color(240, 87, 66));
        pasarEstado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pasarEstado.setForeground(new java.awt.Color(255, 255, 255));
        pasarEstado.setText("PASAR ESTADO");
        pasarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasarEstadoActionPerformed(evt);
            }
        });

        tituloEstadoPedido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tituloEstadoPedido.setText("ESTADO PEDIDO:");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        tituloIdPedido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tituloIdPedido.setText("ID PEDIDO:");

        numPedido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        numPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        tipoTransporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tipoTransporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        estadoActualPedido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        estadoActualPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        verMapa.setBackground(new java.awt.Color(240, 87, 66));
        verMapa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        verMapa.setForeground(new java.awt.Color(255, 255, 255));
        verMapa.setLabel("VER MAPA");

        infoDireccion.setColumns(20);
        infoDireccion.setRows(5);
        jScrollPane2.setViewportView(infoDireccion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(numPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tipoTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(estadoActualPedido))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tituloIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tituloTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(tituloEstadoPedido))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pasarEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(verMapa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloEstadoPedido)
                    .addComponent(tituloTransporte)
                    .addComponent(tituloIdPedido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numPedido)
                        .addGap(1, 1, 1))
                    .addComponent(estadoActualPedido, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tipoTransporte, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(verMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pasarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Acción de pulsar el botón 'PASAR ESTADO'
     * 
     * @param evt evento
     */
    private void pasarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasarEstadoActionPerformed
        if(PedidoDao.actualizarEstadoPedido(pedido)){
            pedido = PedidoDao.obtenerPedido(pedido);
            mostrarDatos();
            botonPedidos.doClick();
        }
    }//GEN-LAST:event_pasarEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel estadoActualPedido;
    private javax.swing.JTextArea infoDireccion;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel numPedido;
    private javax.swing.JButton pasarEstado;
    private javax.swing.JLabel tipoTransporte;
    private javax.swing.JLabel tituloEstadoPedido;
    private javax.swing.JLabel tituloIdPedido;
    private javax.swing.JLabel tituloTransporte;
    private javax.swing.JButton verMapa;
    // End of variables declaration//GEN-END:variables
    
    /**
     * Muestra los datos del pedido
     */
    private void mostrarDatos() {
        pasarEstado.addActionListener(actualizarPedido);
        
        pedido.toString();
        numPedido.setText(String.valueOf(pedido.getId_pedido()));
        tipoTransporte.setText(pedido.getTransporte());
        estadoActualPedido.setText(pedido.getEstado());
        
        switch(pedido.getEstado()){
            case "pendiente_pago":
                pasarEstado.setEnabled(false);
                break;
            case "pagado":
                pasarEstado.setEnabled(true);
                break;
            case "en_preparacion":
                pasarEstado.setEnabled(true);
                break;
            case "enviando":
                pasarEstado.setEnabled(false);
                break;
            case "recibido":
                pasarEstado.setEnabled(false);
                break;
                
        }
        
        this.setBorder(new FlatButtonBorder());
    }
    
    public void cargaDireccionPedido(){
        Direccion direccion = DireccionDao.obtenerDireccionUsuario(new Usurio(pedido.getId_usuario()));
    
    }
}
