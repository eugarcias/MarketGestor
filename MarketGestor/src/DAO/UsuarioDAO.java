package DAO;

import Model.Usuario;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    private final Connection conexao;

    public UsuarioDAO (){
        this.conexao = ConnectionFactory.getConnection();
    }
    
    // Método para gerar hash da senha. MUITO IMPORTANTE para a segurança.
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash da senha", e);
        }
    }

    public boolean autenticar (String login, String senha) {
        // SQL corrigido para usar a tabela "tb_usuarios"
        String sql = "SELECT senha FROM tb_usuarios WHERE login = ?";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, login);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String storedHash = rs.getString("senha");
                    String passwordHash = hashPassword(senha);
                    // Compara o hash da senha digitada com o hash salvo no banco
                    return storedHash.equals(passwordHash);
                }
            }
            return false;
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao autenticar usuário: " + e.getMessage(), e);
        }
    }

    public void cadastrar(Usuario usuario) {
        // SQL corrigido para usar a tabela "tb_usuarios"
        String sql = "INSERT INTO tb_usuarios (nome_completo, login, senha) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, usuario.getNomeCompleto());
            stmt.setString(2, usuario.getLogin());
            // Salva a senha como HASH, não como texto puro
            stmt.setString(3, hashPassword(usuario.getSenha()));

            stmt.execute(); // Bug de execução dupla corrigido

        } catch (SQLException e){
            throw new RuntimeException("Erro ao cadastrar usuário: " + e.getMessage(), e);
        }
    }
}