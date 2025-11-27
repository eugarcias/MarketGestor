package View;

import DAO.ProdutoDAO;
import Model.Produto;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;

public class CadastroProduto extends javax.swing.JFrame {

    private Produto objproduto; // cria o v�nculo com o Produto.java

    public CadastroProduto() {
        initComponents();
        this.objproduto = new Produto();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        a_preço = new javax.swing.JLabel();
        c_data_validade = new javax.swing.JTextField();
        a_descrição = new javax.swing.JLabel();
        a_nome = new javax.swing.JLabel();
        c_descrição = new javax.swing.JTextField();
        c_nome = new javax.swing.JTextField();
        a_quantidade = new javax.swing.JLabel();
        c_quantidade = new javax.swing.JTextField();
        a_data_validade = new javax.swing.JLabel();
        c_preço = new javax.swing.JTextField();
        b_cadastrar = new javax.swing.JButton();
        b_cancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Produto");
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        a_preço.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a_preço.setForeground(new java.awt.Color(0, 0, 0));
        a_preço.setText("Preço:");

        c_data_validade.setBackground(new java.awt.Color(204, 204, 204));
        c_data_validade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        c_data_validade.setForeground(new java.awt.Color(0, 0, 0));
        c_data_validade.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        c_data_validade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_data_validadeActionPerformed(evt);
            }
        });

        a_descrição.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a_descrição.setForeground(new java.awt.Color(0, 0, 0));
        a_descrição.setText("Descrição:");

        a_nome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a_nome.setForeground(new java.awt.Color(0, 0, 0));
        a_nome.setText("Nome:");

        c_descrição.setBackground(new java.awt.Color(204, 204, 204));
        c_descrição.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        c_descrição.setForeground(new java.awt.Color(0, 0, 0));
        c_descrição.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        c_descrição.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_descriçãoActionPerformed(evt);
            }
        });

        c_nome.setBackground(new java.awt.Color(204, 204, 204));
        c_nome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        c_nome.setForeground(new java.awt.Color(0, 0, 0));
        c_nome.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        c_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_nomeActionPerformed(evt);
            }
        });

        a_quantidade.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a_quantidade.setForeground(new java.awt.Color(0, 0, 0));
        a_quantidade.setText("Quantidade:");

        c_quantidade.setBackground(new java.awt.Color(204, 204, 204));
        c_quantidade.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        c_quantidade.setForeground(new java.awt.Color(0, 0, 0));
        c_quantidade.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        c_quantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_quantidadeActionPerformed(evt);
            }
        });

        a_data_validade.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        a_data_validade.setForeground(new java.awt.Color(0, 0, 0));
        a_data_validade.setText("Data_Validade:");

        c_preço.setBackground(new java.awt.Color(204, 204, 204));
        c_preço.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        c_preço.setForeground(new java.awt.Color(0, 0, 0));
        c_preço.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        c_preço.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_preçoActionPerformed(evt);
            }
        });

        b_cadastrar.setBackground(new java.awt.Color(204, 204, 204));
        b_cadastrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        b_cadastrar.setForeground(new java.awt.Color(0, 0, 0));
        b_cadastrar.setText("Cadastrar");
        b_cadastrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        b_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cadastrarActionPerformed(evt);
            }
        });

        b_cancelar.setBackground(new java.awt.Color(204, 204, 204));
        b_cancelar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        b_cancelar.setForeground(new java.awt.Color(0, 0, 0));
        b_cancelar.setText("Cancelar");
        b_cancelar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 0, 102));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 307, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 50, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(a_data_validade)
                    .addComponent(a_preço)
                    .addComponent(a_quantidade)
                    .addComponent(a_descrição)
                    .addComponent(a_nome)
                    .addComponent(c_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_descrição, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_preço, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(b_cancelar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(b_cadastrar))
                        .addComponent(c_data_validade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(a_nome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(a_descrição)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_descrição, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(a_quantidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(a_preço)
                .addGap(5, 5, 5)
                .addComponent(c_preço, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(a_data_validade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(c_data_validade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_cancelar)
                    .addComponent(b_cadastrar))
                .addContainerGap(127, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(713, 539));
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
            novoProduto.setNome_produto(this.c_nome.getText());
    
            if (this.c_descrição.getText().trim().isEmpty()) {
                throw new Mensagens("A descrição do produto é obrigatória.");
            }
            novoProduto.setDescricao_produto(this.c_descrição.getText());
            
            try {
                int quantidade = Integer.parseInt(this.c_quantidade.getText());
                if (quantidade < 0) {
                    throw new Mensagens("A quantidade não pode ser negativa.");
                }
                novoProduto.setQuantidade_estoque(quantidade);
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
            
            // Data de validade (formato esperado dd/MM/yyyy)
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            if (this.c_data_validade.getText().trim().isEmpty()) {
                throw new Mensagens("A data de validade é obrigatória.");
            } else {
                try {
                    java.util.Date parsed = sdf.parse(this.c_data_validade.getText().trim());
                    Date dataValidade = new java.sql.Date(parsed.getTime());
                    novoProduto.setData_validade(dataValidade);
                } catch (java.text.ParseException ex) {
                    throw new Mensagens("Data de validade inválida. Use o formato dd/MM/yyyy.");
                }
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

    private void c_descriçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_descriçãoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_descriçãoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JLabel a_data_validade;
    private javax.swing.JLabel a_descrição;
    private javax.swing.JLabel a_nome;
    private javax.swing.JLabel a_preço;
    private javax.swing.JLabel a_quantidade;
    private javax.swing.JButton b_cadastrar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.JTextField c_data_validade;
    private javax.swing.JTextField c_descrição;
    private javax.swing.JTextField c_nome;
    private javax.swing.JTextField c_preço;
    private javax.swing.JTextField c_quantidade;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
