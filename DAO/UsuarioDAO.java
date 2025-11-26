package DAO;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;

public class UsuarioDAO {

    private Connection conexao;

    public UsuarioDAO() {
        this.conexao = ConnectionFactory.getConnection();
    }

    // ---------------------------------------------------------
    // MÉTODO DE CRIPTOGRAFIA (SHA-256)
    // ---------------------------------------------------------
    private String criptografar(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senha.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao criptografar senha: " + e);
        }
    }

    // ---------------------------------------------------------
    // AUTENTICAR USUÁRIO (COMPARANDO HASH)
    // ---------------------------------------------------------
    public boolean autenticar(String login, String senha) {

        String sql = "SELECT * FROM tb_usuarios WHERE login = ? AND senha = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, login);
            stmt.setString(2, criptografar(senha)); // compara senha criptografada

            ResultSet rs = stmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao autenticar usuário: " + e);
        }
    }

    // ---------------------------------------------------------
    // CADASTRAR USUÁRIO (SALVANDO SENHA CRIPTOGRAFADA)
    // ---------------------------------------------------------
    public void cadastrar(Usuario usuario) {

        String sql = "INSERT INTO tb_usuarios (nome_completo, login, senha) VALUES (?,?,?)";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, usuario.getNomeCompleto());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, criptografar(usuario.getSenha())); // salva hash, não a senha real

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar usuário: " + e);
        }
    }
}
