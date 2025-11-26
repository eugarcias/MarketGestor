package DAO;

import Model.Produto;
import java.util.*;
import java.sql.*;

public class ProdutoDAO {

    public static ArrayList<Produto> MinhaLista = new ArrayList<>();

    public ProdutoDAO() {}

    // -----------------------------------------
    // CONEXÃO COM O BANCO
    // -----------------------------------------
    public Connection getConexao() {
        try {
            Class.forName("org.postgresql.Driver");

            return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "32462600"
            );

        } catch (Exception e) {
            System.out.println("Erro de conexão: " + e.getMessage());
            return null;
        }
    }

    // -----------------------------------------
    // MAIOR ID
    // -----------------------------------------
    public int maiorID() {
        int maiorID = 0;

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery(
                "SELECT MAX(id_produto) AS id_produto FROM market_gestor"
            );

            if (res.next()) {
                maiorID = res.getInt("id_produto");
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro no maiorID: " + ex.getMessage());
        }

        return maiorID;
    }

    // -----------------------------------------
    // LISTAR TODOS OS PRODUTOS
    // -----------------------------------------
    public ArrayList<Produto> getMinhaLista() {

        MinhaLista.clear();

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery(
                "SELECT * FROM market_gestor ORDER BY id_produto"
            );

            while (res.next()) {

                Produto p = new Produto(
                    res.getInt("id_produto"),
                    res.getString("nome_produto"),
                    res.getString("descricao_produto"),
                    res.getInt("quantidade_estoque"),
                    res.getDouble("preco"),
                    res.getDate("data_cadastro"),
                    res.getDate("data_validade")
                );

                MinhaLista.add(p);
            }

            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro no getMinhaLista: " + ex.getMessage());
        }

        return MinhaLista;
    }

    // -----------------------------------------
    // LISTAR ORDENADO POR DATA DE VALIDADE
    // -----------------------------------------
    public ArrayList<Produto> listarPorValidade() {

        ArrayList<Produto> lista = new ArrayList<>();

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery(
                "SELECT * FROM market_gestor ORDER BY data_validade ASC"
            );

            while (res.next()) {

                Produto p = new Produto(
                    res.getInt("id_produto"),
                    res.getString("nome_produto"),
                    res.getString("descricao_produto"),
                    res.getInt("quantidade_estoque"),
                    res.getDouble("preco"),
                    res.getDate("data_cadastro"),
                    res.getDate("data_validade")
                );

                lista.add(p);
            }

            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Erro listarPorValidade: " + ex.getMessage());
        }

        return lista;
    }

    // -----------------------------------------
    // INSERIR PRODUTO
    // -----------------------------------------
    public boolean insertProdutoBD(Produto p) {

        String sql =
            "INSERT INTO market_gestor (nome_produto, descricao_produto, quantidade_estoque, preco, data_cadastro, data_validade) " +
            "VALUES (?,?,?,?,?,?)";

        try {

            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, p.getNome_produto());
            stmt.setString(2, p.getDescricao_produto());
            stmt.setInt(3, p.getQuantidade_estoque());
            stmt.setDouble(4, p.getPreco());
            stmt.setDate(5, p.getData_cadastro());
            stmt.setDate(6, p.getData_validade());

            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao inserir produto: " + erro.getMessage());
        }
    }

    // -----------------------------------------
    // DELETAR
    // -----------------------------------------
    public boolean deleteProdutoBD(int id) {

        try {
            Statement stmt = this.getConexao().createStatement();
            stmt.executeUpdate("DELETE FROM market_gestor WHERE id_produto = " + id);
            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro ao deletar produto: " + erro.getMessage());
        }

        return true;
    }

    // -----------------------------------------
    // ATUALIZAR
    // -----------------------------------------
    public boolean updateProdutoBD(Produto p) {

        String sql =
            "UPDATE market_gestor SET nome_produto=?, descricao_produto=?, quantidade_estoque=?, preco=?, data_validade=? WHERE id_produto=?";

        try {

            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, p.getNome_produto());
            stmt.setString(2, p.getDescricao_produto());
            stmt.setInt(3, p.getQuantidade_estoque());
            stmt.setDouble(4, p.getPreco());
            stmt.setDate(5, p.getData_validade());
            stmt.setInt(6, p.getId_produto());

            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao atualizar produto: " + erro.getMessage());
        }
    }

    // -----------------------------------------
    // CARREGAR PRODUTO ESPECÍFICO
    // -----------------------------------------
    public Produto carregaProduto(int id) {

        Produto p = new Produto();
        p.setId_produto(id);

        try {

            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery(
                "SELECT * FROM market_gestor WHERE id_produto = " + id
            );

            if (res.next()) {
                p.setNome_produto(res.getString("nome_produto"));
                p.setDescricao_produto(res.getString("descricao_produto"));
                p.setQuantidade_estoque(res.getInt("quantidade_estoque"));
                p.setPreco(res.getDouble("preco"));
                p.setData_cadastro(res.getDate("data_cadastro"));
                p.setData_validade(res.getDate("data_validade"));
            }

            stmt.close();

        } catch (SQLException erro) {
            System.out.println("Erro ao carregar produto: " + erro.getMessage());
        }

        return p;
    }
}

