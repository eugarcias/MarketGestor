package View;
import javax.swing. JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {
    
    
    public TelaPrincipal() {
        initComponents();
        
    }
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        c_tela = new javax.swing.JDesktopPane();
        a_cadastrar_produto = new javax.swing.JButton();
        a_gerenciar_produtos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        a_sobre = new javax.swing.JButton();
        c_logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Interface de Teste");
        setUndecorated(true);

        c_tela.setForeground(new java.awt.Color(105, 96, 236));

        a_cadastrar_produto.setBackground(new java.awt.Color(204, 204, 204));
        a_cadastrar_produto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        a_cadastrar_produto.setForeground(new java.awt.Color(0, 0, 0));
        a_cadastrar_produto.setText("Cadastrar Produto");
        a_cadastrar_produto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        a_cadastrar_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_cadastrar_produtoActionPerformed(evt);
            }
        });

        a_gerenciar_produtos.setBackground(new java.awt.Color(204, 204, 204));
        a_gerenciar_produtos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        a_gerenciar_produtos.setForeground(new java.awt.Color(0, 0, 0));
        a_gerenciar_produtos.setText("Gerenciar Produtos");
        a_gerenciar_produtos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        a_gerenciar_produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_gerenciar_produtosActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("X");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        a_sobre.setBackground(new java.awt.Color(204, 204, 204));
        a_sobre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        a_sobre.setForeground(new java.awt.Color(0, 0, 0));
        a_sobre.setText("Sobre...");
        a_sobre.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        a_sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_sobreActionPerformed(evt);
            }
        });

        c_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logoFINAL.png"))); // NOI18N

        c_tela.setLayer(a_cadastrar_produto, javax.swing.JLayeredPane.DEFAULT_LAYER);
        c_tela.setLayer(a_gerenciar_produtos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        c_tela.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        c_tela.setLayer(a_sobre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        c_tela.setLayer(c_logo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout c_telaLayout = new javax.swing.GroupLayout(c_tela);
        c_tela.setLayout(c_telaLayout);
        c_telaLayout.setHorizontalGroup(
            c_telaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c_telaLayout.createSequentialGroup()
                .addContainerGap(208, Short.MAX_VALUE)
                .addGroup(c_telaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c_telaLayout.createSequentialGroup()
                        .addComponent(c_logo)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c_telaLayout.createSequentialGroup()
                        .addComponent(a_cadastrar_produto)
                        .addGap(74, 74, 74)
                        .addComponent(a_gerenciar_produtos))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, c_telaLayout.createSequentialGroup()
                        .addComponent(a_sobre)
                        .addGap(241, 241, 241)))
                .addGap(155, 155, 155)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        c_telaLayout.setVerticalGroup(
            c_telaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(c_telaLayout.createSequentialGroup()
                .addGroup(c_telaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(c_telaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(c_logo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(c_telaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(a_cadastrar_produto)
                    .addComponent(a_gerenciar_produtos))
                .addGap(3, 3, 3)
                .addComponent(a_sobre)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c_tela)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(c_tela)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void a_cadastrar_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_cadastrar_produtoActionPerformed
        // TODO add your handling code here:
         CadastroProduto telaCadastro = new CadastroProduto();
        telaCadastro. setVisible(true);
    }//GEN-LAST:event_a_cadastrar_produtoActionPerformed

    private void a_gerenciar_produtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_gerenciar_produtosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_a_gerenciar_produtosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void a_sobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_sobreActionPerformed
        // TODO add your handling code here:
    String mensagem = "════════════════════════════════════════\n" +
        "              MARKET GESTOR\n" +
        "       Sistema de Gerenciamento\n" +
        "════════════════════════════════════════\n\n" +
        "Versão: 1.0.0\n\n" +
        "Desenvolvido por:\n" +
        "  • William Gomes\n" +
        "  • Gabriel Salazar\n" +
        "  • Guilherme M. Meira\n" +
        "  • Mauricio Garcia\n" +
        "  • Samuel Gois\n\n" +
        "Descrição:\n" +
        "Sistema para gerenciamento de produtos,\n" +
        "controle de estoque e cadastros.\n\n" +
        "© 2025 - Todos os direitos reservados. ";
    
    JOptionPane.showMessageDialog(this, mensagem, "Sobre o Market Gestor", JOptionPane.INFORMATION_MESSAGE);


        
    }//GEN-LAST:event_a_sobreActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton a_cadastrar_produto;
    private javax.swing.JButton a_gerenciar_produtos;
    private javax.swing.JButton a_sobre;
    private javax.swing.JLabel c_logo;
    private javax.swing.JDesktopPane c_tela;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
