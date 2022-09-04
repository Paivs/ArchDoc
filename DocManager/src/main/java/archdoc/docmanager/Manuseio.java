/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archdoc.docmanager;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author conta
 */
public class Manuseio {

    connect criaBD;
    String deli = "";
    String[] arquivos;
    
    public class ArchType{
        String nome;
        String rev;

        public ArchType(String nome, String rev) {
            this.nome = nome;
            this.rev = rev;
        }
        
    }
    
    ArrayList<ArchType> archType = new ArrayList<>();
    
    public Manuseio(ArrayList<String> arquivos, String deli, Connection conexao, String comentario) {
        criaBD = new connect();
        
        this.arquivos = (String[]) arquivos.toArray();
        
        separaArquivoRevisão();
        
    }
    
    private void separaArquivoRevisão(){ 
        for(String i : arquivos){
            
            String nome = i.substring(0, i.indexOf(this.deli));
            String rev = i.substring(i.indexOf(this.deli));
            
            archType.add(new ArchType(nome, rev));
        }
    }
    
    private void enviaBD(){
        for(int i = 0; i < archType.toArray().length; i++){
            archType.indexOf(i);
        }
    }
}
