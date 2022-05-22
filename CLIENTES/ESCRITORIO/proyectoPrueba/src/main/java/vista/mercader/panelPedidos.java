/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista.mercader;

import controlador.PedidoDao;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Negocio;
import modelo.Pedido;

/**
 *
 * @author Jesus
 */
public class panelPedidos extends javax.swing.JPanel {

    /**
     * Creates new form panelPedidos
     */
    public panelPedidos() {
        initComponents();
    }
    
    public panelPedidos(Negocio negocio){
        initComponents();
        recargarTablas(PedidoDao.seleccionTdoosPedidos());
    }
    
    public void recargarTablas(ArrayList<Pedido> listaPedidos){
        
        tablaPagados.setModel(new javax.swing.table.DefaultTableModel(
                null,
                new String[]{
                    "ID_PEDIDO", "ID_USUARIO", "TRANSPORTE", "TOTAL", "FECHA_HORA", "ESTADO"
                }
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        
        tablaEnPreparacion.setModel(new javax.swing.table.DefaultTableModel(
                null,
                new String[]{
                    "ID_PEDIDO", "ID_USUARIO", "TRANSPORTE", "TOTAL", "FECHA_HORA", "ESTADO"
                }
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        
        tablaEnviados.setModel(new javax.swing.table.DefaultTableModel(
                null,
                new String[]{
                    "ID_PEDIDO", "ID_USUARIO", "TRANSPORTE", "TOTAL", "FECHA_HORA", "ESTADO"
                }
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        
        tablaRecibidos.setModel(new javax.swing.table.DefaultTableModel(
                null,
                new String[]{
                    "ID_PEDIDO", "ID_USUARIO", "TRANSPORTE", "TOTAL", "FECHA_HORA", "ESTADO"
                }
        ) {
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        
        for (Pedido pedido: listaPedidos){
            DefaultTableModel model;
            switch (pedido.getEstado()) {
                case "pagado":
                    model = (DefaultTableModel) tablaPagados.getModel();
                    model.addRow(pedido.getRow());
                    break;
                case "en_preparacion":
                    model = (DefaultTableModel) tablaEnPreparacion.getModel();
                    model.addRow(pedido.getRow());
                    break;
                case "enviando":
                    model = (DefaultTableModel) tablaEnviados.getModel();
                    model.addRow(pedido.getRow());
                    break;
                case "recibido":
                    model = (DefaultTableModel) tablaRecibidos.getModel();
                    model.addRow(pedido.getRow());
                    break;
                default:
                    System.out.print("error");
            }
            

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelPagados = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPagados = new javax.swing.JTable();
        panelEnPreparacion = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaEnPreparacion = new javax.swing.JTable();
        panelEnviados = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaEnviados = new javax.swing.JTable();
        panelRecibidos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaRecibidos = new javax.swing.JTable();

        tablaPagados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaPagados);

        javax.swing.GroupLayout panelPagadosLayout = new javax.swing.GroupLayout(panelPagados);
        panelPagados.setLayout(panelPagadosLayout);
        panelPagadosLayout.setHorizontalGroup(
            panelPagadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPagadosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelPagadosLayout.setVerticalGroup(
            panelPagadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPagadosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PAGADOS", panelPagados);

        tablaEnPreparacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaEnPreparacion);

        javax.swing.GroupLayout panelEnPreparacionLayout = new javax.swing.GroupLayout(panelEnPreparacion);
        panelEnPreparacion.setLayout(panelEnPreparacionLayout);
        panelEnPreparacionLayout.setHorizontalGroup(
            panelEnPreparacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnPreparacionLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelEnPreparacionLayout.setVerticalGroup(
            panelEnPreparacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnPreparacionLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("EN_PREPARACION", panelEnPreparacion);

        tablaEnviados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablaEnviados);

        javax.swing.GroupLayout panelEnviadosLayout = new javax.swing.GroupLayout(panelEnviados);
        panelEnviados.setLayout(panelEnviadosLayout);
        panelEnviadosLayout.setHorizontalGroup(
            panelEnviadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnviadosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelEnviadosLayout.setVerticalGroup(
            panelEnviadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnviadosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ENVIADOS", panelEnviados);

        tablaRecibidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tablaRecibidos);

        javax.swing.GroupLayout panelRecibidosLayout = new javax.swing.GroupLayout(panelRecibidos);
        panelRecibidos.setLayout(panelRecibidosLayout);
        panelRecibidosLayout.setHorizontalGroup(
            panelRecibidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRecibidosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelRecibidosLayout.setVerticalGroup(
            panelRecibidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRecibidosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("RECIBIDOS", panelRecibidos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelEnPreparacion;
    private javax.swing.JPanel panelEnviados;
    private javax.swing.JPanel panelPagados;
    private javax.swing.JPanel panelRecibidos;
    private javax.swing.JTable tablaEnPreparacion;
    private javax.swing.JTable tablaEnviados;
    private javax.swing.JTable tablaPagados;
    private javax.swing.JTable tablaRecibidos;
    // End of variables declaration//GEN-END:variables
}
