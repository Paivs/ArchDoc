package archdoc.docmanager;
import java.sql.*;
import java.util.Scanner;
public class connect {
    private static Connection conexao_MySql = null;
    private static String localBD = "localhost";
    private static String LINK = "jdbc:mysql://" + localBD + ":3306/archDocs";
    private static final String usuario = "root";
    private static final String senha = "";
    
    //Função para conexão com o banco
    public Connection connectionMySql(){
        try{
            conexao_MySql = DriverManager.getConnection(LINK, usuario, senha);
            System.out.println("Connection Sucess.");
        }
        catch(SQLException e){
            throw new RuntimeException("Connection error.", e);
        }
        return conexao_MySql;    
    }
    
    //Função para inserção de login no BD
    public void insertData(Connection con){
        String name, password;
        
                    
    } 
    
}
