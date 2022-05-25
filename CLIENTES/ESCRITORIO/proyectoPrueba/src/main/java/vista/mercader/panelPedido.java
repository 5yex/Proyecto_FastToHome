/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.mercader;

import com.formdev.flatlaf.ui.FlatButtonBorder;
import controlador.PedidoDao;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenu;
import modelo.Pedido;
import modelo.Producto;

/**
 *
 * @author jmcbg
 */
public class panelPedido extends javax.swing.JPanel {
    private Pedido pedido;
    private ActionListener actualizarPedido;
    private JMenu botonPedidos;
    /**
     * Creates new form producto
     */

    public panelPedido(Pedido pedido, ActionListener actualizarPedido) {
        initComponents();
        this.pedido = pedido;
        this.actualizarPedido = actualizarPedido;
        mostrarDatos();
    }
    
    public panelPedido(Pedido pedido, JMenu botonPedidos){
        initComponents();
        this.pedido = pedido;
        this.botonPedidos = botonPedidos;
        mostrarDatos();
    }

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

        tituloTransporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tituloTransporte.setText("TRANSPORTE:");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tipoTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(estadoActualPedido))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(pasarEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tituloIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tituloTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(tituloEstadoPedido)))
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
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(estadoActualPedido)
                            .addComponent(tipoTransporte))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pasarEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pasarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasarEstadoActionPerformed
        if(PedidoDao.actualizarEstadoPedido(pedido)){
            botonPedidos.doClick();
        }else{
            System.out.println("nO SE PUEDE VISUALIZAR EL NUEVO ESTADO");
        }
        //mostrarDatos();

    }//GEN-LAST:event_pasarEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel estadoActualPedido;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel numPedido;
    private javax.swing.JButton pasarEstado;
    private javax.swing.JLabel tipoTransporte;
    private javax.swing.JLabel tituloEstadoPedido;
    private javax.swing.JLabel tituloIdPedido;
    private javax.swing.JLabel tituloTransporte;
    // End of variables declaration//GEN-END:variables

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
    
    
    
}
