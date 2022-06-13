package services;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public abstract class Conexao {

    public static Connection connection;
    public Statement statement;
    public ResultSet result;
    public static PreparedStatement pst;

    static final String user = "root";
    static final String password = "lgdc2000";
    static final String database = "mydb";

    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    public static boolean check = false;

    public static void connect(){
        try{
            connection = DriverManager.getConnection(url,user,password);
            System.out.println("Conexão feita com sucesso: " + connection);
        }
        catch (SQLException e){
            System.out.println("Erro de conexão: " + e.getMessage());
        }
    }
}
