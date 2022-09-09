package archdoc.docmanager;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class connect {
    private static Connection conexao_MySql = null;
    private static String localBD = "localhost";
    private static String LINK = "jdbc:mysql://" + localBD + ":3306/archDoc";
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
            pst = con.prepareStatement("select nome, senha from usuario where nome = \"" + name + "\" and senha = \"" + password + "\";");
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
    
    public ArrayList<String[][]> getArquivos(Connection con, String arquivo, String revisao){
        ArrayList<String[][]> arq = new ArrayList<String[][]>();
        ResultSet rs = null;
	String resultado = "";
        try{
            pst = con.prepareStatement("select arquivo, revisao from arquivos where arquivo = \"" + arquivo + "\" and revisao = \"" + revisao + "\";");
            rs = pst.executeQuery();
            
            while(rs.next()){
                try{
                arq.add(new String[][]{ {rs.getString(1)}, {rs.getString(2)} });
                }catch(Exception e){ ; }
            }
            }catch(Exception e) {
                System.out.println(e);
	}

        
        return arq;
    }
    
    public ArrayList<String[][]> getRev(Connection con, String arquivo, String revisao){
        ArrayList<String[][]> arq = new ArrayList<String[][]>();
        ResultSet rs = null;
	String resultado = "";
        try{
            pst = con.prepareStatement("select arquivo, revisao from arquivos where arquivo = \"" + arquivo + "\" and revisao != \"" + revisao + "\";");
            rs = pst.executeQuery();
            
            while(rs.next()){
                try{
                arq.add(new String[][]{ {rs.getString(1)}, {rs.getString(2)} });
                }catch(Exception e){ ; }
            }
            }catch(Exception e) {
                System.out.println(e);
	}

        
        return arq;
    }
        
    public ArrayList<String[][]> getNovoArquivo(Connection con, String arquivo, String revisao){
        ArrayList<String[][]> arq = new ArrayList<String[][]>();
        ResultSet rs = null;
	String resultado = "";
        try{
            pst = con.prepareStatement("select arquivo from arquivos where arquivo = \"" + arquivo + "\";");
            rs = pst.executeQuery();
            
            while(rs.next()){
                try{
                arq.add(new String[][]{ {rs.getString(1)}, {rs.getString(2)} });
                }catch(Exception e){ ; }
            }
            }catch(Exception e) {
                System.out.println(e);
	}

        
        return arq;
    }
    
    public void insertArquivos(Connection con, String arquivo, String revisao, String workpath){
        ResultSet rs = null;
	String resultado = "";
        try{
            pst = con.prepareStatement("insert into arquivos(cod_arquivos, arquivo, revisao, workpath) values (null, \"" + arquivo + "\", \"" + revisao + "\", \"" + revisao + "\", \"" + workpath +"\"");
            rs = pst.executeQuery();
            
        }catch(Exception e) { 
	    resultado = "Erro";
	}
    }
    
    public void insertHistorizador(Connection con, String arquivo, String revisao, String workpath, int acao){
        ResultSet rs = null;
	String resultado = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDateTime now = LocalDateTime.now();  
        
        try{
            pst = con.prepareStatement("insert into historizador(cod_historizador, revisao, arquivo, acao, data_historizador) values (null, \"" + revisao + "\",\"" + arquivo + "\"," + acao + ",\"" + dtf.format(now) + ");");
            rs = pst.executeQuery();
            
        }catch(Exception e) { 
	    resultado = "Erro";
	}
    }
    
    
    
    public void apaga(File arquivo){
        try{
            arquivo.delete();
        }catch(Exception e){
            System.out.println(e);
            
        }
    }
    
    public void mover(String arquivo, String pastaAtual, String pastaDestino){
        Path result = null;
        try{
            Files.move(Paths.get(pastaAtual + "\\" + arquivo), Paths.get(pastaDestino + "\\" + arquivo));
        }catch(Exception e){ ; }
    }
    
    public void mover(File arquivo, String pastaDestino){
        Path result = null;
        try{
            Files.move(Paths.get(arquivo.getAbsolutePath()), Paths.get(pastaDestino + "\\" + arquivo.getName()));
        }catch(Exception e){ ; }
    }
    
}
