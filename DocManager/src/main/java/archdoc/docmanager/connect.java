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
import static archdoc.docmanager.Config.deli;


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
    
    public ArrayList<String> getAllArquivos(Connection con){
        ArrayList<String> arq = new ArrayList<String>();
        ResultSet rs = null;
	String resultado = "";
        try{
            pst = con.prepareStatement("select arquivo, revisao from arquivos;");
            rs = pst.executeQuery();
            
            while(rs.next()){
                arq.add(rs.getString(1)+ deli + rs.getString(2));
            }
            }catch(Exception e) {
                System.out.println(e);
	}
        
        return arq;
    }
    
    public boolean getArquivos(Connection con, String arquivo, String revisao){
        ArrayList<String[][]> arq = new ArrayList<String[][]>();
        ResultSet rs = null;
	String resultado = "";
        try{
            pst = con.prepareStatement("select arquivo, revisao from arquivos where arquivo = \"" + arquivo + "\" and revisao = \"" + revisao + "\";");
            rs = pst.executeQuery();
            
            while(rs.next()){
                arq.add(new String[][]{ {rs.getString(1)}, {rs.getString(2)} });
                System.out.println(rs.getString(1)+"_"+rs.getString(2));
            }
            }catch(Exception e) {
                System.out.println(e);
	}

        
        return !arq.isEmpty();
    }
    
    public boolean isNewRev(Connection con, String arquivo, String revisao){
        ArrayList<String[][]> arq = new ArrayList<String[][]>();
        ResultSet rs = null;
	String resultado = "";
        try{
            pst = con.prepareStatement("select arquivo, revisao from arquivos where arquivo = \"" + arquivo + "\" and revisao = \"" + revisao + "\";");
            rs = pst.executeQuery();
            
            while(rs.next()){
                arq.add(new String[][]{ {rs.getString(1)}, {rs.getString(2)} });
                System.out.println(rs.getString(1)+"_"+rs.getString(2));
            }
            }catch(Exception e) {
                System.out.println(e);
	}

        //nesse momento já sabemos que o arquivo não é novo, mas ele ainda pode ser uma revisão nova
        
        //procura arquivos com o mesmo nome e revisao igual
        //se ele encontra algo, significa que ele realmente não é único
        //agora se ele não encontra nada, entre suas revisões ele é único
        return arq.isEmpty();
    }
        
    public boolean isNewArq(Connection con, String arquivo, String revisao){
        ArrayList<String[]> arq = new ArrayList<String[]>();
        ResultSet rs = null;
	String resultado = "";
        try{
            pst = con.prepareStatement("select arquivo from arquivos where arquivo = \"" + arquivo + "\";");
            rs = pst.executeQuery();
            
            while(rs.next()){
                arq.add(new String[]{rs.getString(1)});
                System.out.println(rs.getString(1));
            }
            }catch(Exception e) {
                System.out.println(e);
	}

        //o select procura arquivos com o mesmo nome. Se ele encontra algo significa que o arquivo já existe. 
        //mas se ele não encontra nada (isEmpty == true) é porque é novo
        return arq.isEmpty();
    }
    
    
    public void insertArquivos(Connection con, String arquivo, String revisao, String workpath){
        ResultSet rs = null;
	String resultado = "";
        try{
            pst = con.prepareStatement("insert into arquivos(cod_arquivos, arquivo, revisao, workpath) values (null, \"" + arquivo + "\", \"" + revisao + "\", \"" + workpath +"\");");
            pst.execute();
            
        }catch(Exception e) { 
	    System.out.println(e);
	}
    }
    
    
    public void insertHistorizador(Connection con, String arquivo, String cod_arquivos ,String revisao, String workpath, int acao, String acaoDesc){
        ResultSet rs = null;
	String resultado = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDateTime now = LocalDateTime.now();  
        
        try{
            pst = con.prepareStatement("insert into historizador(cod_historizador, cod_arquivos, revisao, arquivo, acao, acaoDesc, data_historizador) values (null, \"" + cod_arquivos + "\", \"" + revisao + "\",\"" + arquivo + "\"," + acao + ",\"" + acaoDesc + "\",\"" + dtf.format(now) + "\");");
            pst.execute();
            
        }catch(Exception e) { 
	    System.out.println(e);
	}
    }
    public void insertHistorizador(Connection con, String arquivo, String revisao, String workpath, int acao, String acaoDesc){
        ResultSet rs = null;
	String resultado = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
        LocalDateTime now = LocalDateTime.now();  
        
        try{
            
            pst = con.prepareStatement("select cod_arquivos from arquivos order by cod_arquivos desc limit 1;");
            rs = pst.executeQuery();
            
            String num = "";
            
            while(rs.next()) num = rs.getString(1);
            if(num.equals("")) num = "null";
            
            pst = con.prepareStatement("insert into historizador(cod_historizador, cod_arquivos, revisao, arquivo, acao, acaoDesc, data_historizador) values (null, \"" + num + "\", \"" + revisao + "\",\"" + arquivo + "\"," + acao + ",\"" + acaoDesc + "\",\"" + dtf.format(now) + "\");");
            pst.execute();
            
        }catch(Exception e) { 
	    System.out.println(e);
	}
    }
    
    
    public void exportar(Connection con, String destino){
        ResultSet rs = null;
	String resultado = "";
        try{
            pst = con.prepareStatement("SELECT arquivo As \"Arquivo\", revisao As \"Revisão\", workPath As \"Pasta\" FROM arquivos INTO OUTFILE \"" + destino + "\" FIELDS TERMINATED BY ';' ENCLOSED BY '\"' LINES TERMINATED BY '\\n';");
            pst.execute();
            
        }catch(Exception e) { 
	    System.out.println(e);
	}
    }
    
    public void criarView(Connection con, String querry){
        try{
            pst = con.prepareStatement(querry);
            pst.execute();
        }catch(Exception e) { 
	    System.out.println(e);
	}
    }
    
    public ArrayList<String> getView(Connection con){
        ArrayList<String> arq = new ArrayList<String>();
        ResultSet rs = null;
	String resultado = "";
        try{
            pst = con.prepareStatement("show tables;");
            rs = pst.executeQuery();
            
            while(rs.next()){
                if(!rs.getString(1).equals("arquivos") && !rs.getString(1).equals("grupo") && !rs.getString(1).equals("historizador") && !rs.getString(1).equals("usuario") ){
                 arq.add(rs.getString(1));
                }
            }
            }catch(Exception e) {
                System.out.println(e);
	}

        return arq;
    }
    
    public void apaga(File arquivo){
        try{
            arquivo.delete();
        }catch(Exception e){
            System.out.println(e);
            
        }
    }
    public void mover(File arquivo, String pastaDestino){
        Path result = null;
        try{
            Files.move(Paths.get(arquivo.getAbsolutePath()), Paths.get(pastaDestino + "\\" + arquivo.getName()));
        }catch(Exception e){ ; }
    }
    public boolean verifica(String arquivo, String workPath){
        return new File(workPath + "\\" + arquivo).exists();
    }
    
}
