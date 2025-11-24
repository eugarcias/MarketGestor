package Model;

import java.time.LocalDate;

public class Produto {

    private int idProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private int quantidadeEstoque;
    private double preco;
    private LocalDate dataCadastro;

    public Produto(){

    }

    public Produto(String nomeProduto, String descricaoProduto, int quantidadeEstoque, double preco) {
     this.nomeProduto = nomeProduto;
     this.descricaoProduto = descricaoProduto;
     this.quantidadeEstoque = quantidadeEstoque;
     this.preco = preco;
     this.dataCadastro = LocalDate.now();
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
