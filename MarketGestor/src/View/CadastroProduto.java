package View;

import DAO.ProdutoDAO;
import Model.Produto;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

public class CadastroProduto extends javax.swing.JFrame {

    private Produto objproduto; // cria o v�nculo com o Aluno.java

    public CadastroProduto() {
        initComponents();
        this.objproduto = new Produto();
        c_id.setEditable(false);
        c_data_cadastro.setEditable(false);// carrega objeto vazio de aluno
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        a_nome = new javax.swing.JLabel();
        c_nome = new javax.swing.JTextField();
        a_id = new javax.swing.JLabel();
        c_id = new javax.swing.JTextField();
        a_quantidade = new javax.swing.JLabel();
        c_quantidade = new javax.swing.JTextField();
        a_data_validade = new javax.swing.JLabel();
        c_preço = new javax.swing.JTextField();
        b_cadastrar = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();
        a_preço = new javax.swing.JLabel();
        c_data_validade = new javax.swing.JTextField();
        a_data_cadastro = new javax.swing.JLabel();
        c_data_cadastro = new javax.swing.JTextField();
        a_descrição = new javax.swing.JLabel();
        c_descrição = new javax.swing.JTextField();

        setTitle("Cadastro de Produto");
        setResizable(false);

        a_nome.setText("Nome:");

        c_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_nomeActionPerformed(evt);
            }
        });

        a_id.setText("Id:");

        a_quantidade.setText("Quantidade:");

        c_quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_quantidadeActionPerformed(evt);
            }
        });

        a_data_validade.setText("Data_Validade:");

        c_preço.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_preçoActionPerformed(evt);
            }
        });

        b_cadastrar.setText("Cadastrar");
        b_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cadastrarActionPerformed(evt);
            }
        });

        b_cancelar.setText("Cancelar");
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });

        a_preço.setText("Preço:");

        c_data_validade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_data_validadeActionPerformed(evt);
            }
        });

        a_data_cadastro.setText("Data_Cadastro:");

        c_data_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_data_cadastroActionPerformed(evt);
            }
        });

        a_descrição.setText("Descrição:");

        c_descrição.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_descriçãoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(c_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(a_descrição)
                                                .addComponent(c_descrição, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(c_data_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1))))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(a_data_cadastro)
                                        .addComponent(a_data_validade))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(c_data_validade, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(a_preço))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(c_preço, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(a_quantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(c_id, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(115, 115, 115)
                                .addComponent(a_id))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(b_cancelar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(b_cadastrar))
                                    .addComponent(c_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(a_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(a_nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(a_id)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(a_quantidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(a_preço)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_preço, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(a_data_validade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_data_validade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(a_data_cadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_data_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(a_descrição)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_descrição, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cancelar)
                    .addComponent(b_cadastrar))
                .addGap(52, 52, 52))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void c_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_nomeActionPerformed

    private void c_quantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_quantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_quantidadeActionPerformed

    private void c_preçoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_preçoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_preçoActionPerformed

    private void b_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cadastrarActionPerformed

        try {
                        Produto novoProduto = new Produto();
    
            // Coleta e validação dos dados
            if (this.c_nome.getText().trim().isEmpty()) {
                throw new Mensagens("O nome do produto é obrigatório.");
            }
            novoProduto.setNomeProduto(this.c_nome.getText());
    
            if (this.c_descrição.getText().trim().isEmpty()) {
                throw new Mensagens("A descrição do produto é obrigatória.");
            }
            novoProduto.setDescricaoProduto(this.c_descrição.getText());
            
            try {
                int quantidade = Integer.parseInt(this.c_quantidade.getText());
                if (quantidade < 0) {
                    throw new Mensagens("A quantidade não pode ser negativa.");
                }
                novoProduto.setQuantidadeEstoque(quantidade);
            } catch (NumberFormatException e) {
                throw new Mensagens("O campo 'Quantidade' deve ser um número inteiro.");
            }
    
            try {
                String precoStr = this.c_preço.getText().replace(",", ".");
                double preco = Double.parseDouble(precoStr);
                if (preco <= 0) {
                    throw new Mensagens("O preço deve ser maior que zero.");
                }
                novoProduto.setPreco(preco);
            } catch (NumberFormatException e) {
                throw new Mensagens("O campo 'Preço' deve ser um número válido (ex: 12.99).");
            }
            
            // Lógica para Data de Validade
            if (this.c_data_validade.getText().trim().isEmpty()) {
                throw new Mensagens("A data de validade é obrigatória.");
            }
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataValidade = LocalDate.parse(this.c_data_validade.getText(), formatter);
                novoProduto.setDataValidade(dataValidade);
            } catch (DateTimeParseException e) {
                throw new Mensagens("Formato de Data de Validade inválido. Use dd/MM/yyyy.");
            }
    
            // Enviar os dados para o DAO
            ProdutoDAO dao = new ProdutoDAO();
            if (dao.insertProdutoBD(novoProduto)) {
                JOptionPane.showMessageDialog(rootPane, "Produto Cadastrado com Sucesso!");

                // limpa campos da interface
                this.c_nome.setText("");
                this.c_descrição.setText("");
                this.c_quantidade.setText("");
                this.c_preço.setText("");
                this.c_id.setText("");
                this.c_data_cadastro.setText("");
                this.c_data_validade.setText("");

            }

            

        } 
        
         catch (Mensagens erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage(), "Erro de Validação", JOptionPane.WARNING_MESSAGE);
        } catch (RuntimeException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto:\n" + erro.getMessage(), "Erro de Banco de Dados", JOptionPane.ERROR_MESSAGE);
        }
        
        


    }//GEN-LAST:event_b_cadastrarActionPerformed

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);

    }//GEN-LAST:event_b_cancelarActionPerformed

    private void c_data_validadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_data_validadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_data_validadeActionPerformed

    private void c_data_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_data_cadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_data_cadastroActionPerformed

    private void c_descriçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_descriçãoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_descriçãoActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a_data_cadastro;
    private javax.swing.JLabel a_data_validade;
    private javax.swing.JLabel a_descrição;
    private javax.swing.JLabel a_id;
    private javax.swing.JLabel a_nome;
    private javax.swing.JLabel a_preço;
    private javax.swing.JLabel a_quantidade;
    private javax.swing.JButton b_cadastrar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JTextField c_data_cadastro;
    private javax.swing.JTextField c_data_validade;
    private javax.swing.JTextField c_descrição;
    private javax.swing.JTextField c_id;
    private javax.swing.JTextField c_nome;
    private javax.swing.JTextField c_preço;
    private javax.swing.JTextField c_quantidade;
    // End of variables declaration//GEN-END:variables
}
