/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.foodweb.View.Pedidos;

import com.mycompany.foodweb.Model.Enums.StatusPedido;
import com.mycompany.foodweb.Model.Pedido;
import com.mycompany.foodweb.Service.ClienteService;
import com.mycompany.foodweb.Service.PedidoService;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public final class JifPedidos extends javax.swing.JInternalFrame {

    private static JifPedidos internalFramePedidos;
    private static Long idRestauranteRecuperado;
    
    public static JifPedidos getInstancia(Long idRestaurante) {
        if (internalFramePedidos == null) {
            internalFramePedidos = new JifPedidos(idRestaurante);
        }
        idRestauranteRecuperado = idRestaurante;
        return internalFramePedidos;
    }
    
    public JifPedidos(Long idRestaurante) {
        initComponents();
        this.setTitle("Pedidos");
        this.setSize(1200, 680);
        List<JTable> listaDeTabelas = new ArrayList<>();
        listaDeTabelas.add(tabelaPedidosAguardandoAprovacao);
        listaDeTabelas.add(tabelaPedidosAprovados);
        listaDeTabelas.add(tabelaPedidosAguardandoEntregador);
        listaDeTabelas.add(tabelaPedidosConcluidos);
        listaDeTabelas.add(tabelaPedidosEmAndamento);
        listaDeTabelas.add(tabelaPedidosEmRotaDeEntrega);
        preenchePedidosNaTabela(idRestaurante);
        estilizaTabelas(listaDeTabelas);
    }
    
    public void estilizaTabelas(List<JTable> tabelas) {
        for (int i = 0; i < tabelas.size(); i++) {
            JTable tabela = tabelas.get(i);
            tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
            tabela.getTableHeader().setOpaque(false);
            tabela.getTableHeader().setBackground(new Color(32, 136, 203));
            tabela.getTableHeader().setForeground(Color.WHITE);
            tabela.setRowHeight(25);
            tabela.setShowVerticalLines(false);
        }
    }
    
    public void limpaRegistrosDasTabelas(List<DefaultTableModel> tabelas) {        
        for (int i = 0; i < tabelas.size(); i++) {
            DefaultTableModel tabelaModelo = tabelas.get(i);
            tabelaModelo.setRowCount(0);
        }        
    }
    
    public void adicionaPedidoNaTabela(DefaultTableModel defaultTableModel, Pedido pedido) {
        defaultTableModel.addRow(new Object[] {
            pedido.getId(),
            pedido.getDataHoraPedido(),
            pedido.getStatusPedido()
        });
    }
    
    public List<DefaultTableModel> transformaTabelasParaDefaultTableModel(List<JTable> listaDeTabelas) {
        List<DefaultTableModel> listaDeDefaultTableModel = new ArrayList<>();
        for (int i = 0; i < listaDeTabelas.size(); i++) {
            JTable tabela = listaDeTabelas.get(i);
            DefaultTableModel defaultTableModel = (DefaultTableModel) tabela.getModel();
            listaDeDefaultTableModel.add(defaultTableModel);
        }
        return listaDeDefaultTableModel;
    }
    
    public void defineCellRenderer(List<TableColumn> listaDeTablesColumns) {
        TableCellRenderer renderCelula = new AlinharConteudoCentro();
        for (int i = 0; i < listaDeTablesColumns.size(); i++) {
            TableColumn tableColumn = listaDeTablesColumns.get(i);
            tableColumn.setCellRenderer(renderCelula);
        }
    }
    
    public void preenchePedidosNaTabela(Long idRestaurante) {
        
        PedidoService pedidoService = new PedidoService();
        Pedido[] listaPedidos = pedidoService.listarTodosOsPedidos(idRestaurante);
        
        List<JTable> listaTabelas = new ArrayList<>();
        listaTabelas.add(tabelaPedidosAguardandoAprovacao);
        listaTabelas.add(tabelaPedidosAprovados);
        listaTabelas.add(tabelaPedidosEmAndamento);
        listaTabelas.add(tabelaPedidosEmRotaDeEntrega);
        listaTabelas.add(tabelaPedidosAguardandoEntregador);
        listaTabelas.add(tabelaPedidosConcluidos);
        
        List<DefaultTableModel> listaDeTabelas = transformaTabelasParaDefaultTableModel(listaTabelas);
        
        DefaultTableModel tabelaAguardandoAprovacao = (DefaultTableModel) tabelaPedidosAguardandoAprovacao.getModel();        
        DefaultTableModel tabelaAprovados = (DefaultTableModel) tabelaPedidosAprovados.getModel();        
        DefaultTableModel tabelaEmAndamento = (DefaultTableModel) tabelaPedidosEmAndamento.getModel();        
        DefaultTableModel tabelaEmRotaDeEntrega = (DefaultTableModel) tabelaPedidosEmRotaDeEntrega.getModel();        
        DefaultTableModel tabelaAguardandoEntregador = (DefaultTableModel) tabelaPedidosAguardandoEntregador.getModel();
        DefaultTableModel tabelaConcluidos = (DefaultTableModel) tabelaPedidosConcluidos.getModel();
        
        limpaRegistrosDasTabelas(listaDeTabelas);
        
        TableColumn colunaCodigo = tabelaPedidosAguardandoAprovacao.getColumnModel().getColumn(0);
        TableColumn colunaDataHora = tabelaPedidosAguardandoAprovacao.getColumnModel().getColumn(1);
        TableColumn colunaNomeCliente = tabelaPedidosAguardandoAprovacao.getColumnModel().getColumn(2);
        TableColumn colunaTelefoneCliente = tabelaPedidosAguardandoAprovacao.getColumnModel().getColumn(3);
        TableColumn colunaStatusPedido = tabelaPedidosAguardandoAprovacao.getColumnModel().getColumn(5);
        TableColumn colunaValorTotal = tabelaPedidosAguardandoAprovacao.getColumnModel().getColumn(6);
        
        List<TableColumn> listaDeTableColumns = new ArrayList<>();
        listaDeTableColumns.add(colunaCodigo);
        listaDeTableColumns.add(colunaDataHora);
        listaDeTableColumns.add(colunaNomeCliente);
        listaDeTableColumns.add(colunaTelefoneCliente);
        listaDeTableColumns.add(colunaStatusPedido);
        listaDeTableColumns.add(colunaValorTotal);
        
        defineCellRenderer(listaDeTableColumns);
        
        if (listaPedidos == null) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar pedidos.");
        } else {
            
            for (var i = 0; i < listaPedidos.length; i++) {

                Pedido pedido = listaPedidos[i];
                StatusPedido statusPedido = StatusPedido.valueOf(pedido.getStatusPedido());
                
                switch (statusPedido) {
                    case AGUARDANDO_APROVACAO:
                        adicionaPedidoNaTabela(tabelaAguardandoAprovacao, pedido);
                        break;
                    case APROVADO:
                        adicionaPedidoNaTabela(tabelaAprovados, pedido);
                        break;
                    case EM_PREPARACAO:
                        adicionaPedidoNaTabela(tabelaEmAndamento, pedido);
                        break;
                    case AGUARDANDO_ENTREGADOR:
                        adicionaPedidoNaTabela(tabelaAguardandoEntregador, pedido);
                        break;
                    case EM_ROTA_DE_ENTREGA:
                        adicionaPedidoNaTabela(tabelaEmRotaDeEntrega, pedido);
                        break;
                    case FINALIZADO:
                        adicionaPedidoNaTabela(tabelaConcluidos, pedido);
                        break;
                    default:
                        throw new AssertionError();
                }
                
            }
            
        }
        
    }
    
    class AlinharConteudoCentro extends DefaultTableCellRenderer {
        public AlinharConteudoCentro() {
            setHorizontalAlignment(CENTER);
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPedidosAguardandoAprovacao = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelaPedidosAprovados = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaPedidosEmAndamento = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaPedidosAguardandoEntregador = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaPedidosEmRotaDeEntrega = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaPedidosConcluidos = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1052, 538));

        jButton1.setText("Editar Pedido");

        jButton2.setText("Novo Pedido");

        jLabel1.setText("Pesquisar pedido");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(132, 132, 132))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jButton2)
                    .addContainerGap(887, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 31, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        tabelaPedidosAguardandoAprovacao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data - Hora", "Cliente", "Telefone", "Endereço", "Status", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaPedidosAguardandoAprovacao);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Aguardando aprovação", jPanel2);

        tabelaPedidosAprovados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data - Hora", "Cliente", "Telefone", "Endereço", "Status", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tabelaPedidosAprovados);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Aprovado", jPanel8);

        tabelaPedidosEmAndamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data - Hora", "Cliente", "Telefone", "Endereço", "Status", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabelaPedidosEmAndamento);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Em andamento", jPanel3);

        tabelaPedidosAguardandoEntregador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data - Hora", "Cliente", "Telefone", "Endereço", "Status", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tabelaPedidosAguardandoEntregador);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Aguardando Entregador", jPanel4);

        tabelaPedidosEmRotaDeEntrega.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data - Hora", "Cliente", "Telefone", "Endereço", "Status", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tabelaPedidosEmRotaDeEntrega);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Em Rota de Entrega", jPanel5);

        tabelaPedidosConcluidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Data - Hora", "Cliente", "Telefone", "Endereço", "Status", "Valor Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tabelaPedidosConcluidos);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Concluídos", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabelaPedidosAguardandoAprovacao;
    private javax.swing.JTable tabelaPedidosAguardandoEntregador;
    private javax.swing.JTable tabelaPedidosAprovados;
    private javax.swing.JTable tabelaPedidosConcluidos;
    private javax.swing.JTable tabelaPedidosEmAndamento;
    private javax.swing.JTable tabelaPedidosEmRotaDeEntrega;
    // End of variables declaration//GEN-END:variables
}
