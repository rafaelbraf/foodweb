/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.foodweb.View;

import com.mycompany.foodweb.View.Produtos.JifProdutos;
import Util.GerenteDeJanelas;
import com.mycompany.foodweb.Service.ProdutoService;
import com.mycompany.foodweb.Model.Produto;
import com.mycompany.foodweb.View.Pedidos.JifPedidos;

import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Source;

/**
 *
 * @author Rafael
 */
public class Home extends javax.swing.JFrame {   
    
    GerenteDeJanelas gerenteDeJanelas;
    Long idRestauranteRecuperado;
    
    public Home() {
        initComponents();
        this.gerenteDeJanelas = new GerenteDeJanelas(jDesktopPane1);
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    public void pegaIdRestaurante(Long idRestaurante) {        
        idRestauranteRecuperado = idRestaurante;
        System.out.println("pegaidrestaurante - idRestauranteRecuperado: " + idRestauranteRecuperado);
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        buttonPedidos = new javax.swing.JButton();
        buttonCardapio = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton3.setText("Início");

        buttonPedidos.setText("Pedidos");
        buttonPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonPedidosMouseClicked(evt);
            }
        });
        buttonPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPedidosActionPerformed(evt);
            }
        });

        buttonCardapio.setText("Cardápio");
        buttonCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCardapioActionPerformed(evt);
            }
        });

        buttonSair.setText("Sair");
        buttonSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSairMouseClicked(evt);
            }
        });
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 417, Short.MAX_VALUE)
                .addComponent(buttonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(buttonCardapio, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(buttonSair, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                .addContainerGap())
        );

        jDesktopPane1.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPedidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonPedidosActionPerformed

    private void buttonCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCardapioActionPerformed
        
        gerenteDeJanelas.abrirJanelas(JifProdutos.getInstancia(idRestauranteRecuperado));
        
    }//GEN-LAST:event_buttonCardapioActionPerformed

    private void buttonPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPedidosMouseClicked
        
        gerenteDeJanelas.abrirJanelas(JifPedidos.getInstancia(idRestauranteRecuperado));
        
    }//GEN-LAST:event_buttonPedidosMouseClicked

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonSairActionPerformed

    private void buttonSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSairMouseClicked
        // TODO add your handling code here:
        
        Object[] opcoes = {
            "Sim", "Não"
        };
        
        int opcaoSelecionada = JOptionPane.showOptionDialog(
                null,
                "Tem certeza que deseja sair do FoodWeb?",
                "Sair",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.CLOSED_OPTION,
                null,
                opcoes,
                opcoes[0]
        );
        
        if (opcaoSelecionada == 0){
            System.exit(0);
        }
        
    }//GEN-LAST:event_buttonSairMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {

            for (UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        } catch (InstantiationException ex) {
            System.err.println(ex);
        } catch (IllegalAccessException ex) {
            System.err.println(ex);
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println(ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCardapio;
    private javax.swing.JButton buttonPedidos;
    private javax.swing.JButton buttonSair;
    private javax.swing.JButton jButton3;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
