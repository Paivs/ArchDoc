/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archdoc.docmanager;

import java.util.ArrayList;

/**
 *
 * @author conta
 */
public class Manuseio {
   private String[][] arqRev;
   private String[] grupos;
   class ArqRevGru{

	public ArqRevGru(String arquivo, String revisao, String grupo) {
	    this.arquivo = arquivo;
	    this.revisao = revisao;
	    this.grupo = grupo;
	}
       
	public String arquivo; 
	public String revisao;  
	public String grupo; 
    };
   
    ArrayList<ArqRevGru> arqRevGru = new ArrayList<ArqRevGru>();

   public Manuseio(String[][] arqRev, String[] grupos) {
	this.arqRev = arqRev;
	setGrupos(grupos);
    }
   
    private void setGrupos(String[] categorias){
	int index = 0;
	
	ArrayList<String> arq = new ArrayList<String>();
	ArrayList<String> rev = new ArrayList<String>();
	ArrayList<String> grupos = new ArrayList<String>();
	
	for(String cat : categorias){
	
	    for(String[] each : arqRev){
		int isArq = 0;
		for(String i : each){
		    isArq++;
		    if(isArq == 0) arq.add(i);
		    else rev.add(i);
		}
		
	    for(String grupoEx : this.grupos){
		if(arq.get(index).startsWith(grupoEx)){
		    arqRevGru.add(new ArqRevGru(arq.get(index), rev.get(index), grupoEx));
		}
	    }
		
	    index++;
	    }
       }
   }
   
   
}
