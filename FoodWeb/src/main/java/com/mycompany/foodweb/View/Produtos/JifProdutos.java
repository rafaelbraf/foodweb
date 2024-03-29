/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.foodweb.View.Produtos;

import com.mycompany.foodweb.Model.Categoria;
import com.mycompany.foodweb.Model.Produto;
import com.mycompany.foodweb.Service.ProdutoService;
import com.mycompany.foodweb.Service.RestauranteService;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class JifProdutos extends javax.swing.JInternalFrame {
    
    private static JifProdutos internalFrameProdutos;
    private static Long idRestauranteRecuperado;
    
    public static JifProdutos getInstancia(Long idRestaurante) {
        if (internalFrameProdutos == null) {
            internalFrameProdutos = new JifProdutos(idRestaurante);
        }
        idRestauranteRecuperado = idRestaurante;
        return internalFrameProdutos;
    }
    
    public JifProdutos(Long idRestaurante) {
        initComponents();
        
        this.setTitle("Cardápio");
        
        tabelaProdutos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabelaProdutos.getTableHeader().setOpaque(false);
        tabelaProdutos.getTableHeader().setBackground(new Color(32, 136, 203));
        tabelaProdutos.getTableHeader().setForeground(Color.WHITE);
        tabelaProdutos.setRowHeight(25);
        tabelaProdutos.setShowVerticalLines(false);
        
        buttonLimparPesquisa.setVisible(false);
        
        preencherProdutosNaTabela(idRestaurante);
        
    }
    
    public void preencherProdutosNaTabela(Long idRestaurante) {
        
        RestauranteService restauranteService = new RestauranteService();        
        Produto[] listaProdutos = restauranteService.listaProdutosDoRestaurante(idRestaurante);
        DefaultTableModel tabela = (DefaultTableModel) tabelaProdutos.getModel();
        
        tabela.setRowCount(0);
        
        if (listaProdutos == null) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produtos");
        } else {
            
            for (var i = 0; i < listaProdutos.length; i++) {
                
                String categoriasString = "";
                List<Categoria> listaCategorias = listaProdutos[i].getCategorias();
                
                for (var j = 0; j < listaCategorias.size(); j++) {
                    Categoria categoria = listaCategorias.get(j);
                    if (j != listaCategorias.size() - 1) {
                        categoriasString += categoria.getNome() + ", ";
                    } else {
                        categoriasString += categoria.getNome();
                    }
                }

                tabela.addRow(new Object[]{
                    listaProdutos[i].getId(),
                    listaProdutos[i].getNome(),
                    listaProdutos[i].getDescricao(),
                    categoriasString,
                    listaProdutos[i].getPreco(),
                    listaProdutos[i].getQuantidade()
                });

            }
            
            labelTotalDeItens.setText("Total de itens: " + listaProdutos.length);
            
        }
        
    }
    
    public void pesquisaProdutosPorNome(Long idRestaurante, String nome) {
        
        RestauranteService restauranteService = new RestauranteService();
        nome = nome.toLowerCase();
        Produto[] listaDeProdutos = restauranteService.listaProdutosDoRestaurantePorNome(idRestaurante, nome);
        DefaultTableModel tabela = (DefaultTableModel) tabelaProdutos.getModel();
        
        tabela.setRowCount(0);
        
        if (listaDeProdutos != null) {
            
            for (var i = 0; i < listaDeProdutos.length; i++) {
            
                String categoriasString = "";
                List<Categoria> listaDeCategorias = listaDeProdutos[i].getCategorias();

                for (var j = 0; j < listaDeCategorias.size(); j++) {
                    Categoria categoria = listaDeCategorias.get(j);
                    if (j != listaDeCategorias.size() - 1) {
                        categoriasString += categoria.getNome() + ", ";
                    } else {
                        categoriasString += categoria.getNome();
                    }
                }

                tabela.addRow(new Object[] {
                    listaDeProdutos[i].getId(),
                    listaDeProdutos[i].getNome(),
                    listaDeProdutos[i].getDescricao(),
                    categoriasString,
                    listaDeProdutos[i].getPreco(),
                    listaDeProdutos[i].getQuantidade()
                });

                labelTotalDeItens.setText("Total de itens: " + tabela.getRowCount());

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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProdutos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        buttonAdicionarProduto = new javax.swing.JButton();
        buttonEditarProduto = new javax.swing.JButton();
        buttonAtualizarTabelaDeProdutos = new javax.swing.JButton();
        buttonVerProduto = new javax.swing.JButton();
        buttonExcluirProduto = new javax.swing.JButton();
        labelTotalDeItens = new javax.swing.JLabel();
        buttonSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfPesquisarProduto = new javax.swing.JTextField();
        buttonPesquisarProdutos = new javax.swing.JButton();
        buttonLimparPesquisa = new javax.swing.JButton();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        tabelaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Descrição", "Categoria", "Valor Unitário", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProdutos.setFocusable(false);
        tabelaProdutos.setRowHeight(25);
        tabelaProdutos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaProdutos);

        buttonAdicionarProduto.setText("Adicionar");
        buttonAdicionarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAdicionarProdutoMouseClicked(evt);
            }
        });

        buttonEditarProduto.setText("Editar");
        buttonEditarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonEditarProdutoMouseClicked(evt);
            }
        });
        buttonEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarProdutoActionPerformed(evt);
            }
        });

        buttonAtualizarTabelaDeProdutos.setText("Atualizar");
        buttonAtualizarTabelaDeProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAtualizarTabelaDeProdutosMouseClicked(evt);
            }
        });
        buttonAtualizarTabelaDeProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAtualizarTabelaDeProdutosActionPerformed(evt);
            }
        });

        buttonVerProduto.setText("Ver");
        buttonVerProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonVerProdutoMouseClicked(evt);
            }
        });

        buttonExcluirProduto.setText("Excluir");
        buttonExcluirProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonExcluirProdutoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonAdicionarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonVerProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(buttonEditarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonExcluirProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAtualizarTabelaDeProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEditarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(buttonAtualizarTabelaDeProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(buttonVerProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(buttonAdicionarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(buttonExcluirProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap())
        );

        buttonSair.setText("Sair");
        buttonSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSairMouseClicked(evt);
            }
        });

        jLabel1.setText("Pesquisar produtos");

        buttonPesquisarProdutos.setIcon(new javax.swing.ImageIcon("D:\\Projetos\\FoodWeb\\Desktop\\FoodWeb\\assets\\search-icon.png")); // NOI18N
        buttonPesquisarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPesquisarProdutosActionPerformed(evt);
            }
        });

        buttonLimparPesquisa.setText("Limpar pesquisa");
        buttonLimparPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimparPesquisaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(labelTotalDeItens)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonSair))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tfPesquisarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(buttonPesquisarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(buttonLimparPesquisa)
                                .addGap(143, 143, 143)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonPesquisarProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfPesquisarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonLimparPesquisa)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSair)
                    .addComponent(labelTotalDeItens))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSairMouseClicked
        this.dispose();
    }//GEN-LAST:event_buttonSairMouseClicked

    private void buttonAdicionarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAdicionarProdutoMouseClicked
        JifCadastrarProduto internalFrameCadastrarProduto = new JifCadastrarProduto(idRestauranteRecuperado);
        getParent().add(internalFrameCadastrarProduto);
        internalFrameCadastrarProduto.setVisible(true);
        internalFrameCadastrarProduto.setClosable(true);        
    }//GEN-LAST:event_buttonAdicionarProdutoMouseClicked

    private void buttonAtualizarTabelaDeProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAtualizarTabelaDeProdutosMouseClicked
        tfPesquisarProduto.setText("");
        preencherProdutosNaTabela(idRestauranteRecuperado);
    }//GEN-LAST:event_buttonAtualizarTabelaDeProdutosMouseClicked

    private void buttonExcluirProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonExcluirProdutoMouseClicked
        Object[] opcoes = {
            "Sim", "Não"
        };
        
        int opcaoSelecionada = JOptionPane.showOptionDialog(
                null,
                "Tem certeza que deseja excluir o produto selecionado?",
                "Excluir produto",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                opcoes[0]
        );
        
        if (opcaoSelecionada == 0) {
            int linhaSelecionada = tabelaProdutos.getSelectedRow();
            int codigoProduto = 0;

            if (linhaSelecionada != -1) {
                codigoProduto = Integer.parseInt(tabelaProdutos.getValueAt(linhaSelecionada, 0).toString());
            }

            if (codigoProduto != 0) {
                try {
                    ProdutoService produtoService = new ProdutoService();
                    produtoService.excluirProduto(codigoProduto);
                    JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir produto");
                }
            }
        }
        
        preencherProdutosNaTabela(idRestauranteRecuperado);
        
    }//GEN-LAST:event_buttonExcluirProdutoMouseClicked

    private void buttonEditarProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonEditarProdutoMouseClicked
        int linhaSelecionada = tabelaProdutos.getSelectedRow();
        
        if (linhaSelecionada != -1) {
            int codigoProduto = Integer.parseInt(tabelaProdutos.getValueAt(linhaSelecionada, 0).toString());
            if (codigoProduto != 0) {
                JifEditarProduto internalFrameEditarProduto = new JifEditarProduto(idRestauranteRecuperado);
                getParent().add(internalFrameEditarProduto);
                internalFrameEditarProduto.setVisible(true);
                internalFrameEditarProduto.setClosable(true);
                internalFrameEditarProduto.carregaProdutoParaEdicao(codigoProduto);
            }
        }
    }//GEN-LAST:event_buttonEditarProdutoMouseClicked

    private void buttonVerProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonVerProdutoMouseClicked
        // TODO add your handling code here:
        
        int linhaSelecionada = tabelaProdutos.getSelectedRow();
        int codigoProduto = 0;
        
        if (linhaSelecionada != -1) {
            codigoProduto = Integer.parseInt(tabelaProdutos.getValueAt(linhaSelecionada, 0).toString());
            
            if (codigoProduto != 0) {
                
                JifVerProduto internalFrameVerProduto = new JifVerProduto();
                getParent().add(internalFrameVerProduto);
                internalFrameVerProduto.setVisible(true);
                internalFrameVerProduto.setClosable(true);
                internalFrameVerProduto.preencheProdutoPorId(codigoProduto);
                
            }
        } 
        
    }//GEN-LAST:event_buttonVerProdutoMouseClicked

    private void buttonEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonEditarProdutoActionPerformed

    private void buttonPesquisarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisarProdutosActionPerformed
        buttonLimparPesquisa.setVisible(true);
        String nomeDoProduto = tfPesquisarProduto.getText();
        pesquisaProdutosPorNome(idRestauranteRecuperado, nomeDoProduto);
    }//GEN-LAST:event_buttonPesquisarProdutosActionPerformed

    private void buttonAtualizarTabelaDeProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAtualizarTabelaDeProdutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonAtualizarTabelaDeProdutosActionPerformed

    private void buttonLimparPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimparPesquisaActionPerformed
        tfPesquisarProduto.setText("");
        buttonLimparPesquisa.setVisible(false);
        preencherProdutosNaTabela(idRestauranteRecuperado);
    }//GEN-LAST:event_buttonLimparPesquisaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionarProduto;
    private javax.swing.JButton buttonAtualizarTabelaDeProdutos;
    private javax.swing.JButton buttonEditarProduto;
    private javax.swing.JButton buttonExcluirProduto;
    private javax.swing.JButton buttonLimparPesquisa;
    private javax.swing.JButton buttonPesquisarProdutos;
    private javax.swing.JButton buttonSair;
    private javax.swing.JButton buttonVerProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTotalDeItens;
    private javax.swing.JTable tabelaProdutos;
    private javax.swing.JTextField tfPesquisarProduto;
    // End of variables declaration//GEN-END:variables
}
