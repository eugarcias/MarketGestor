package DAO;

import Model.Produto;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutoDAO {

    public static ArrayList<Produto> MinhaLista = new ArrayList<>();

    public ProdutoDAO() {
    }

    // Retorna o maior ID da tabela
    public int maiorID() throws SQLException {
        int maiorID = 0;

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id_produto) AS id_produto FROM tb_produtos");
            if (res.next()) {
                maiorID = res.getInt("id_produto");
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar maior ID: " + ex.getMessage());
        }

        return maiorID;
    }

    // Conexão com o PostgreSQL
    public Connection getConexao() {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/db_estoque";
            String user = "postgres";
            String password = "2096";

            connection = DriverManager.getConnection(url, user, password);

            if (connection != null) {
                System.out.println("Status: Conectado!");
            }

            return connection;

        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado: " + e.getMessage());
            return null;

        } catch (SQLException e) {
            System.out.println("Não foi possível conectar ao banco.");
            return null;
        }
    }

    // Retorna lista de produtos
    public ArrayList<Produto> getMinhaLista() {

        MinhaLista.clear();

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos ORDER BY id_produto");

            while (res.next()) {

                Produto p = new Produto(
                    res.getInt("id_produto"),
                    res.getString("nome_produto"),
                    res.getString("descricao_produto"),
                    res.getInt("quantidade_estoque"),
                    res.getDouble("preco"),
                    res.getDate("data_cadastro")
                );

                MinhaLista.add(p);
            }

            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro ao listar produtos: " + ex.getMessage());
        }

        return MinhaLista;
    }

    // Inserir novo produto
    public boolean insertProdutoBD(Produto p) {

        String sql = "INSERT INTO tb_produtos (nome_produto, descricao_produto, quantidade_estoque, preco, data_cadastro) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, p.getNome_produto());
            stmt.setString(2, p.getDescricao_produto());
            stmt.setInt(3, p.getQuantidade_estoque());
            stmt.setDouble(4, p.getPreco());
            stmt.setDate(5, p.getData_cadastro());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao inserir produto: " + erro.getMessage());
        }
    }

    // Deletar produto
    public boolean deleteProdutoBD(int id) {
        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM tb_produtos WHERE id_produto = " + id);
            stmt.close();
        } catch (SQLException erro) {
            System.out.println("Erro ao deletar produto: " + erro.getMessage());
        }

        return true;
    }

    // Atualizar produto
    public boolean updateProdutoBD(Produto p) {

        String sql = "UPDATE tb_produtos SET nome_produto = ?, descricao_produto = ?, quantidade_estoque = ?, preco = ? WHERE id_produto = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, p.getNome_produto());
            stmt.setString(2, p.getDescricao_produto());
            stmt.setInt(3, p.getQuantidade_estoque());
            stmt.setDouble(4, p.getPreco());
            stmt.setInt(5, p.getId_produto());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao atualizar produto: " + erro.getMessage());
        }
    }

    // Carregar produto específico
    public Produto carregaProduto(int id) {

        Produto p = new Produto();
        p.setId_produto(id);

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_produtos WHERE id_produto = " + id);

            if (res.next()) {
                p.setNome_produto(res.getString("nome_produto"));
                p.setDescricao_produto(res.getString("descricao_produto"));
                p.setQuantidade_estoque(res.getInt("quantidade_estoque"));
                p.setPreco(res.getDouble("preco"));
                p.setData_cadastro(res.getDate("data_cadastro"));
            }

            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro ao carregar produto: " + erro.getMessage());
        }

        return p;
    }
}
