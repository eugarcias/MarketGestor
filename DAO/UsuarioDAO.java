package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection conexao;

    public UsuarioDAO (){
        this.conexao = ConnectionFactory.getConnection();
    }

    public boolean autenticar (String login, String senha) {
        String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao autenticar usuário: " + e);
        }
    }

    public void cadastrar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome_completo, login, senha) VALUES (?,?, ?)";

        try {

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeCompleto());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());

            stmt.execute();
            stmt.execute();
        } catch (SQLException e){
            throw new RuntimeException("Erro ao cadastrar usuário: " + e)
        }
    }
}
