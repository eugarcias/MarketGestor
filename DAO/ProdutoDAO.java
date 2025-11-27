package DAO;

import Model.Produto;
import java.util.*;
import java.sql.*;


public class ProdutoDAO {

    // (controle para evitar SQL injection)
    private static final Set<String> ALLOWED_ORDER_COLUMNS = Set.of(
        "id_produto", "nome_produto", "preco", "quantidade_estoque", "data_cadastro", "data_validade"
    );

    public ProdutoDAO() {}

    //  CONEXÃO  //
    public Connection getConexao() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "2096"
            );
        } catch (Exception e) {
            System.out.println("Erro de conexão: " + e.getMessage());
            return null;
        }
    }

    //  Helpers de validação  //
    private boolean validaColunaOrdenacao(String coluna) {
        if (coluna == null) return false;
        return ALLOWED_ORDER_COLUMNS.contains(coluna);
    }

    private String validaDirecao(String dir) {
        if (dir == null) return "ASC";
        dir = dir.trim().toUpperCase();
        return dir.equals("DESC") ? "DESC" : "ASC";
    }

    //  Método genérico central  //

    private ArrayList<Produto> listarComFiltroOrdenacao(
        String whereClause,
        String orderBy,
        String orderDir,
        int limit,
        List<Object> params
    ) {
        ArrayList<Produto> lista = new ArrayList<>();

        // valida orderBy
        String orderColumn = (orderBy != null && validaColunaOrdenacao(orderBy)) ? orderBy : "id_produto";
        String orderDirection = validaDirecao(orderDir);

        StringBuilder sql = new StringBuilder("SELECT * FROM market_gestor");
        if (whereClause != null && !whereClause.trim().isEmpty()) {
            sql.append(" WHERE ").append(whereClause);
        }
        sql.append(" ORDER BY ").append(orderColumn).append(" ").append(orderDirection);
        if (limit > 0) sql.append(" LIMIT ").append(limit);

        try (Connection conn = this.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            // setar parâmetros, se houve
            if (params != null) {
                for (int i = 0; i < params.size(); i++) {
                    Object o = params.get(i);
                    int idx = i + 1;
                    if (o instanceof Integer) stmt.setInt(idx, (Integer) o);
                    else if (o instanceof Double) stmt.setDouble(idx, (Double) o);
                    else if (o instanceof java.sql.Date) stmt.setDate(idx, (java.sql.Date) o);
                    else stmt.setString(idx, o == null ? null : o.toString());
                }
            }

            try (ResultSet res = stmt.executeQuery()) {
                while (res.next()) {
                    lista.add(mapearProduto(res));
                }
            }

        } catch (SQLException ex) {
            System.out.println("Erro listarComFiltroOrdenacao: " + ex.getMessage());
        }

        return lista;
    }

    //  ORDENAÇÕES PÚBLICAS  //

    public ArrayList<Produto> ordenarPorPrecoASC() { return listarComFiltroOrdenacao(null, "preco", "ASC", 0, null); }
    public ArrayList<Produto> ordenarPorPrecoDESC() { return listarComFiltroOrdenacao(null, "preco", "DESC", 0, null); }
    public ArrayList<Produto> ordenarPorNome() { return listarComFiltroOrdenacao(null, "nome_produto", "ASC", 0, null); }
    public ArrayList<Produto> ordenarPorQuantidade() { return listarComFiltroOrdenacao(null, "quantidade_estoque", "DESC", 0, null); }
    public ArrayList<Produto> ordenarPorValidade() { return listarComFiltroOrdenacao(null, "data_validade", "ASC", 0, null); }

    //  RELATÓRIOS UNIFICADOS  //
    // Relatório Produtos Vencidos
    public ArrayList<Produto> relatorioProdutosVencidos(String orderBy, String orderDir) {
        return listarComFiltroOrdenacao("data_validade < CURRENT_DATE", orderBy, orderDir, 0, null);
    }

    // Relatório Produtos Prestes a Vencer
    public ArrayList<Produto> relatorioProdutosPrestesAVencer(int dias, String orderBy, String orderDir) {
        // usamos INTERVAL com concat seguro via SQL literal (dias é int vindo do app)
        String where = "data_validade BETWEEN CURRENT_DATE AND CURRENT_DATE + INTERVAL '" + dias + " days'";
        return listarComFiltroOrdenacao(where, orderBy, orderDir, 0, null);
    }

    // Relatório Produtos Mais Caros 
    public ArrayList<Produto> relatorioProdutosMaisCaros(int topN) {
        return listarComFiltroOrdenacao(null, "preco", "DESC", topN, null);
    }

    // Relatório Produtos Mais Baratos 
    public ArrayList<Produto> relatorioProdutosMaisBaratos(int topN) {
        return listarComFiltroOrdenacao(null, "preco", "ASC", topN, null);
    }

    // Estoque baixo 
    public ArrayList<Produto> relatorioEstoqueBaixo(int limite, String orderBy, String orderDir) {
        List<Object> params = List.of(limite);
        return listarComFiltroOrdenacao("quantidade_estoque <= ?", orderBy, orderDir, 0, params);
    }

    // Produtos sem estoque
    public ArrayList<Produto> relatorioSemEstoque(String orderBy, String orderDir) {
        return listarComFiltroOrdenacao("quantidade_estoque = 0", orderBy, orderDir, 0, null);
    }

    // Relatório geral com ordenação passada pela view
    public ArrayList<Produto> relatorioGeral(String orderBy, String orderDir) {
        return listarComFiltroOrdenacao(null, orderBy, orderDir, 0, null);
    }

    //  MÉTRICAS  //
    public double valorTotalEstoque() {
        double total = 0;
        String sql = "SELECT SUM(preco * quantidade_estoque) AS total FROM market_gestor";

        try (Connection conn = this.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet res = stmt.executeQuery(sql)) {
            if (res.next()) total = res.getDouble("total");
        } catch (SQLException ex) {
            System.out.println("Erro valorTotalEstoque: " + ex.getMessage());
        }

        return total;
    }

    public int quantidadeTotalItens() {
        int total = 0;
        String sql = "SELECT SUM(quantidade_estoque) AS total FROM market_gestor";

        try (Connection conn = this.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet res = stmt.executeQuery(sql)) {
            if (res.next()) total = res.getInt("total");
        } catch (SQLException ex) {
            System.out.println("Erro quantidadeTotalItens: " + ex.getMessage());
        }

        return total;
    }

    //  DAR BAIXA NO ESTOQUE  //
    public boolean darBaixaNoEstoque(int id_produto, int qtd) {
        if (qtd <= 0) return false;

        String sqlCheck = "SELECT quantidade_estoque FROM market_gestor WHERE id_produto = ?";
        String sqlUpdate = "UPDATE market_gestor SET quantidade_estoque = quantidade_estoque - ? WHERE id_produto = ?";

        try (Connection conn = this.getConexao();
             PreparedStatement psCheck = conn.prepareStatement(sqlCheck)) {

            psCheck.setInt(1, id_produto);
            try (ResultSet rs = psCheck.executeQuery()) {
                if (!rs.next()) return false; // produto não existe
                int atual = rs.getInt("quantidade_estoque");
                if (atual < qtd) return false; // evita estoque negativo
            }

            try (PreparedStatement psUpdate = conn.prepareStatement(sqlUpdate)) {
                psUpdate.setInt(1, qtd);
                psUpdate.setInt(2, id_produto);
                int updated = psUpdate.executeUpdate();
                return updated > 0;
            }

        } catch (SQLException ex) {
            System.out.println("Erro darBaixaNoEstoque: " + ex.getMessage());
            return false;
        }
    }

    //  CRUD (INSERT / DELETE / UPDATE / LOAD)  //
    public boolean insertProdutoBD(Produto p) {
        String sql = "INSERT INTO market_gestor (nome_produto, descricao_produto, quantidade_estoque, preco, data_validade) " +
                     "VALUES (?,?,?,?,?)";

        try (PreparedStatement stmt = this.getConexao().prepareStatement(sql)) {
            stmt.setString(1, p.getNome_produto());
            stmt.setString(2, p.getDescricao_produto());
            stmt.setInt(3, p.getQuantidade_estoque());
            stmt.setDouble(4, p.getPreco());
            stmt.setDate(5, p.getData_validade());
            stmt.execute();
            return true;
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao inserir produto: " + erro.getMessage());
        }
    }

    public boolean deleteProdutoBD(int id) {
        try (Connection conn = this.getConexao();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM market_gestor WHERE id_produto = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException erro) {
            System.out.println("Erro ao deletar produto: " + erro.getMessage());
            return false;
        }
    }

    public boolean updateProdutoBD(Produto p) {
        String sql = "UPDATE market_gestor SET nome_produto=?, descricao_produto=?, quantidade_estoque=?, preco=?, data_validade=? WHERE id_produto=?";
        try (PreparedStatement stmt = this.getConexao().prepareStatement(sql)) {
            stmt.setString(1, p.getNome_produto());
            stmt.setString(2, p.getDescricao_produto());
            stmt.setInt(3, p.getQuantidade_estoque());
            stmt.setDouble(4, p.getPreco());
            stmt.setDate(5, p.getData_validade());
            stmt.setInt(6, p.getId_produto());
            stmt.execute();
            return true;
        } catch (SQLException erro) {
            throw new RuntimeException("Erro ao atualizar produto: " + erro.getMessage());
        }
    }

    public Produto carregaProduto(int id) {
        Produto p = new Produto();
        p.setId_produto(id);
        String sql = "SELECT * FROM market_gestor WHERE id_produto = ?";

        try (Connection conn = this.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet res = stmt.executeQuery()) {
                if (res.next()) {
                    p = mapearProduto(res);
                }
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao carregar produto: " + erro.getMessage());
        }

        return p;
    }

    //  MAPEAMENTO  //
    private Produto mapearProduto(ResultSet res) throws SQLException {
        return new Produto(
            res.getInt("id_produto"),
            res.getString("nome_produto"),
            res.getString("descricao_produto"),
            res.getInt("quantidade_estoque"),
            res.getDouble("preco"),
            res.getDate("data_cadastro"),
            res.getDate("data_validade")
        );
    }
}


