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
        c_barra = new javax.swing.JMenuBar();
        b_arquivo = new javax.swing.JMenu();
        a_cadastrar_produto = new javax.swing.JMenuItem();
        a_sair = new javax.swing.JMenuItem();
        b_produtos = new javax.swing.JMenu();
        a_gerenciar_produtos = new javax.swing.JMenuItem();
        b_sobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Interface de Teste");

        javax.swing.GroupLayout c_telaLayout = new javax.swing.GroupLayout(c_tela);
        c_tela.setLayout(c_telaLayout);
        c_telaLayout.setHorizontalGroup(
            c_telaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        c_telaLayout.setVerticalGroup(
            c_telaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        b_arquivo.setText("Arquivo");

        a_cadastrar_produto.setText("Cadastrar Produto");
        a_cadastrar_produto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_cadastrar_produtoActionPerformed(evt);
            }
        });
        b_arquivo.add(a_cadastrar_produto);

        a_sair.setText("Sair");
        a_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_sairActionPerformed(evt);
            }
        });
        b_arquivo.add(a_sair);

        c_barra.add(b_arquivo);

        b_produtos.setText("Produtos");

        a_gerenciar_produtos.setText("Gerenciar Produtos");
        a_gerenciar_produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                a_gerenciar_produtosActionPerformed(evt);
            }
        });
        b_produtos.add(a_gerenciar_produtos);

        c_barra.add(b_produtos);

        b_sobre.setText("Sobre");
        c_barra.add(b_sobre);

        setJMenuBar(c_barra);

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

    private void a_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_sairActionPerformed
       int resposta = JOptionPane.showConfirmDialog(this, 
            "Deseja realmente sair do sistema?", 
            "Confirmar Saída", 
            JOptionPane.YES_NO_OPTION);
        
        if (resposta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_a_sairActionPerformed

    private void a_cadastrar_produtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_cadastrar_produtoActionPerformed
//        CadastroProduto objeto = new CadastroProduto();

            CadastroProduto telaCadastro = new CadastroProduto();
        telaCadastro. setVisible(true);
        
    }//GEN-LAST:event_a_cadastrar_produtoActionPerformed

    private void a_gerenciar_produtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_a_gerenciar_produtosActionPerformed
        
        
    }//GEN-LAST:event_a_gerenciar_produtosActionPerformed

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
    private javax.swing.JMenuItem a_cadastrar_produto;
    private javax.swing.JMenuItem a_gerenciar_produtos;
    private javax.swing.JMenuItem a_sair;
    private javax.swing.JMenu b_arquivo;
    private javax.swing.JMenu b_produtos;
    private javax.swing.JMenu b_sobre;
    private javax.swing.JMenuBar c_barra;
    private javax.swing.JDesktopPane c_tela;
    // End of variables declaration//GEN-END:variables
}
