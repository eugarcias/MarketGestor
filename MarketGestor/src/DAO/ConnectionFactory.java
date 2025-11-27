package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "2096";

    public static Connection getConnection() {
        try {
            // A linha abaixo força o carregamento do driver do PostgreSQL.
            // Isso resolve problemas em que o driver não é encontrado automaticamente.
            Class.forName("org.postgresql.Driver"); 
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException e) {
            // Este erro acontece se o arquivo .jar do PostgreSQL não estiver no projeto.
            throw new RuntimeException("Driver JDBC do PostgreSQL não encontrado! Verifique as bibliotecas do projeto.", e);
        
        } catch (SQLException e) {
            // ERRO MELHORADO: Agora a mensagem original do SQLException será incluída.
            throw new RuntimeException("Erro de conexão com o banco de dados: " + e.getMessage(), e);
        }
    }
}