package DAO;

import Model.Produto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ProdutoDAO {
    private Connection conexao;

    public ProdutoDAO (){
        this.conexao = ConnectionFactory.getConnection();
    }


}