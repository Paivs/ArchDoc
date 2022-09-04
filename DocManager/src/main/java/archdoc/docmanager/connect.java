package archdoc.docmanager;
import java.sql.*;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class connect {
    private static Connection conexao_MySql = null;
    private static String localBD = "localhost";
    private static String LINK = "jdbc:mysql://" + localBD + ":3306/archDocs";
    private static final String usuario = "root";
    private static final String senha = "";
    
    PreparedStatement pst;
    
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
    public boolean checkUser(Connection con, String name, String password){
        boolean login = false;
        ResultSet rs = null;
	String resultado = "";
        try{
            pst = con.prepareStatement("select name, password from user where name = \"" + name + "\" and password = \"" + password + "\";");
            rs = pst.executeQuery();
            
            while(rs.next()) resultado = "User: " + rs.getString(1) + " Senha: " + rs.getString(2);
        }catch(Exception e) { 
	    resultado = "Erro";
	}
	
	switch(resultado){
	    case "":
		JOptionPane.showMessageDialog(null, "Erro ao validar suas credenciais", "Menu do usuário", JOptionPane.ERROR_MESSAGE);
                
            login = false;
            
	    break;
	    
	    case "Erro":
		JOptionPane.showMessageDialog(null, "Erro no Banco de Dados", "Menu do usuário", JOptionPane.ERROR_MESSAGE);
		login = false;
	    break;
	    
	    default:
		login = true;
	}
	
	return login;
        
                    
    } 
    
}
