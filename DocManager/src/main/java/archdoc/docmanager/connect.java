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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;


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
            pst = con.prepareStatement("insert into arquivos(arquivo, revisao, workpath) values (\"" + arquivo + "\", \"" + revisao + "\", \"" + workpath +"\");");
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
            System.out.println("erro --------------------------");
            pst = con.prepareStatement("select cod_arquivos from arquivos order by cod_arquivos desc limit 1;");
            rs = pst.executeQuery();
            
            String num = "";
            
            while(rs.next()) num = rs.getString(1);
            if(num.equals("")) num = "null";
            
            pst = con.prepareStatement("insert into historizador(cod_arquivos, revisao, arquivo, acao, acaoDesc, data_historizador) values (\"" + num + "\", \"" + revisao + "\",\"" + arquivo + "\"," + acao + ",\"" + acaoDesc + "\",\"" + dtf.format(now) + "\");");
            pst.execute();
            
        }catch(Exception e) { 
	    System.out.println(e);
	}
    }
    
    
    public void exportar(Connection con, String view, String ext, String destino){
        ResultSet rs = null;
	String resultado = "";
        
        ArrayList<String[]> tabela = new ArrayList<String[]>();
        
        try{
            pst = con.prepareStatement("SELECT * FROM " + view +";");
            rs = pst.executeQuery();
            
            ArrayList<String> linha = new ArrayList<String>();
            
            for(int w = 1; w <= rs.getMetaData().getColumnCount(); w++){
                linha.add(rs.getMetaData().getColumnName(w));
            }
            
            String[] linha_toString = linha.toArray(new String[0]);
            tabela.add(linha_toString);
            linha.clear();
            
            while(rs.next()){
                for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++){
                    linha.add(rs.getString(i));
                }
                
                linha_toString = linha.toArray(new String[0]);
                
                tabela.add(linha_toString);
                
                linha.clear();
            }
            
        }catch(Exception e) { 
	    System.out.println(e);
	}
        
        try{
            
            LocalDate now = java.time.LocalDate.now();
                    
            FileWriter file = new FileWriter(destino + "\\Export_" + now.toString().replace("-", "_") + "." + ext);
            PrintWriter write = new PrintWriter(file);
            
            String valores = "";
            int index = 0;
            
            for(String[] linha : tabela){
                
                valores = "";
                index = 0;
                
                for(String colunas : linha){
                    index++;
                    if(index == 1) valores = colunas;
                    else valores = valores + ";" + colunas;
                }
                
                write.println(valores);
            }
            
            write.close();
            
        } catch(IOException exe){
            System.out.println(exe);
        }
    }
    
    public void analisar(Connection con, String view, int cod){
        ResultSet rs = null;
	String resultado = "";
        
        ArrayList<String[]> tabela = new ArrayList<String[]>();
        
        try{
            pst = con.prepareStatement("SELECT * FROM " + view +";");
            rs = pst.executeQuery();
            
            ArrayList<String> linha = new ArrayList<String>();
            
            for(int w = 1; w <= rs.getMetaData().getColumnCount(); w++){
                linha.add(rs.getMetaData().getColumnName(w));
            }
            
            String[] linha_toString = linha.toArray(new String[0]);
            tabela.add(linha_toString);
            linha.clear();
            
            while(rs.next()){
                for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++){
                    linha.add(rs.getString(i));
                }
                
                linha_toString = linha.toArray(new String[0]);
                
                tabela.add(linha_toString);
                
                linha.clear();
            }
            
        }catch(Exception e) { 
	    System.out.println(e);
	}
        
        try{
            
            LocalDate now = java.time.LocalDate.now();
            String nome = "\\Analise" +"\\Export_toAnalisar_" + cod + "_" + now.toString().replace("-", "_") + ".csv";
                    
            FileWriter file = new FileWriter(System.getProperty("user.dir") + nome);
            PrintWriter write = new PrintWriter(file);
            
            String valores = "";
            int index = 0;
            
            for(String[] linha : tabela){
                
                valores = "";
                index = 0;
                
                for(String colunas : linha){
                    index++;
                    if(index == 1) valores = colunas;
                    else valores = valores + ";" + colunas;
                }
                
                write.println(valores);
            }
            
            write.close();
            
        } catch(IOException exe){
            System.out.println(exe);
        }
    }
    
    public void criarView(Connection con, String querry){
        try{
            if(querry.equals("")) JOptionPane.showMessageDialog(null, "A BUSCA NÃO TEVE NENHUM RETORNO");
            else{
                pst = con.prepareStatement(querry);
                pst.execute();
            }
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
    
    public ArrayList<String[]> getSelectView(Connection con, String view){
        ArrayList<String[]> arq = new ArrayList<String[]>();
        ResultSet rs = null;
	String resultado = "";
        try{
            pst = con.prepareStatement("select * from " + view + ";");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsmd = rs.getMetaData();
            
            while(rs.next()){
                String row = "";
                for(int i = 1; i <= rsmd.getColumnCount(); i++){
                    if(i == 1) row = rs.getString(i);
                    else row = row +";" + rs.getString(i);
                }
                arq.add(row.split(";"));
            }
            
            for(int i = 1; i <= rsmd.getColumnCount(); i++){
                arq.add(new String[]{rsmd.getColumnName(i)});
            }
           
            arq.add(new String[]{String.valueOf(rsmd.getColumnCount())});
            
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
