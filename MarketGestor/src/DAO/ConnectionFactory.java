package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/marketgestor?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "Postgres";
    private static final String PASS = "2096";

    public static Connection getConnection (){
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Erro de conexão com o banco de dados: ", e);
        }
    }
}
