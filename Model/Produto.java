package Model;

import DAO.ProdutoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

public class Produto {
    
    // Atributos
    private int id_produto;
    private String nome_produto;
    private String descricao_produto;
    private int quantidade_estoque;
    private double preco;
    private Date data_cadastro;
    private Date data_validade;
    // Atributo DAO
    private final ProdutoDAO dao;

    // Construtor vazio
    public Produto() {
        this.dao = new ProdutoDAO(); // Inicializa o objeto DAO em ambos os construtores
    }

    // Construtor com dados
    public Produto(int id_produto, String nome_produto, String descricao_produto, int quantidade_estoque, double preco, 
            Date data_cadastro, Date data_validade) {
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.descricao_produto = descricao_produto;
        this.quantidade_estoque = quantidade_estoque;
        this.preco = preco;
        this.data_cadastro = data_cadastro;
        this.data_validade = data_validade;
        this.dao = new ProdutoDAO(); // Inicializa o objeto DAO em ambos os construtores
    }
    
    /*
        Getters e Setters!
    */
    
    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Date getData_validade() {
        return data_validade;
    }

    public void setData_validade(Date data_validade) {
        this.data_validade = data_validade;
    }
    
    /*
        Interação com o banco de dados!
    */
    
    // Retorna a Lista de Produtos(objetos) pelo ID
    public ArrayList ordenarPorID() {
        return dao.ordenarPorID();
    }
    
    // Retorna a Lista de Produtos(objetos) pelo Preço (mais baratos primeiro)
    public ArrayList ordenarPorPrecoASC() {
        return dao.ordenarPorPrecoASC();
    }

    // Retorna a Lista de Produtos(objetos) pelo Preço (mais caros primeiro)
    public ArrayList ordenarPorPrecoDESC() {
        return dao.ordenarPorPrecoDESC();
    }

    // Retorna a Lista de Produtos(objetos) pelo Nome
    public ArrayList ordenarPorNome() {
        return dao.ordenarPorNome();
    }

    // Retorna a Lista de Produtos(objetos) pela Quantidade
    public ArrayList ordenarPorQuantidade() {
        return dao.ordenarPorQuantidade();
    }

    // Retorna a Lista de Produtos(objetos) pela Validade (mais perto de vencer primeiro)
    public ArrayList ordenarPorValidade() {
        return dao.ordenarPorValidade();
    }
    
    // Cadastra novo produto
    public boolean InsertProdutoBD(String nome_produto, String descricao_produto, int quantidade_estoque, double preco, 
            Date data_cadastro, Date data_validade) throws SQLException {
        int id = this.id_produto;
        Produto objeto = new Produto(id, nome_produto, descricao_produto, quantidade_estoque, preco, data_cadastro, data_validade);
        dao.insertProdutoBD(objeto);
        return true;

    }
    
    // Deleta um produto específico pelo seu ID
    public boolean DeleteProdutoBD(int id) {
        dao.deleteProdutoBD(id);
        return true;
    }
    
    // Edita um produto específico pelo seu ID
    public boolean UpdateProdutoBD(int id_produto, String nome_produto, String descricao_produto, int quantidade_estoque, double preco, Date data_cadastro, Date data_validade) {
        Produto objeto = new Produto(id_produto, nome_produto, descricao_produto, quantidade_estoque, preco, data_cadastro, data_validade);
        dao.updateProdutoBD(objeto);
        return true;
    }
    
    // Carrega dados de um produto específico pelo seu ID
    public Produto carregaProduto(int id) {
        dao.carregaProduto(id);
        return null;
    } 
}
