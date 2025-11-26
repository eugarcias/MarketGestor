package DAO;

import Model.Produto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {

    private final Connection conexao;

    public ProdutoDAO() {
        this.conexao = ConnectionFactory.getConnection();
    }

    public boolean insertProdutoBD(Produto produto) {
        // SQL corrigido para incluir a coluna data_validade
        String sql = "INSERT INTO market_gestor (nome_produto, descricao_produto, quantidade_estoque, preco, data_cadastro, data_validade) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            
            stmt.setString(1, produto.getNomeProduto());
            stmt.setString(2, produto.getDescricaoProduto());
            stmt.setInt(3, produto.getQuantidadeEstoque());
            stmt.setDouble(4, produto.getPreco());
            stmt.setDate(5, Date.valueOf(java.time.LocalDate.now())); // data_cadastro
            
            // Adiciona a data de validade. Trata o caso de ser nula.
            if (produto.getDataValidade() != null) {
                stmt.setDate(6, Date.valueOf(produto.getDataValidade())); // <-- LINHA ADICIONADA
            } else {
                stmt.setNull(6, java.sql.Types.DATE);
            }

            stmt.execute();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Erro ao salvar produto no banco: " + ex.getMessage(), ex);
        }
    }
}