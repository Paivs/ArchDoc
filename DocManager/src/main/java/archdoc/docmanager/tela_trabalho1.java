/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package archdoc.docmanager;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class tela_trabalho1 extends javax.swing.JInternalFrame {
    
    Point local;
    JFileChooser chooser = new JFileChooser();
    private String[] lista;
    
    private String file = System.getProperty("user.dir") + "\\Parameters\\tiposArquivos.csv";
    
    private String workPath = System.getProperty("user.dir") + "\\workPath";
    private String deli = "_";
    
    private String arquivoLocal = "";
    private ArrayList<String> arquivos = new ArrayList<String>();
    private static boolean atualizou = false;
    
    Connection conexao;
    connect connect = new connect();

    public boolean isAtualizou() {
	return atualizou;
    }

    public void setAtualizou(boolean atualizou) {
	this.atualizou = atualizou;
    }

    public Point getLocal() {
        return local;
    }

    public void setLocal(Point local) { 
        this.local = local;
    }
    
    public tela_trabalho1(boolean atualizou) {
        initComponents();
        setFrameIcon(new ImageIcon(System.getProperty("user.dir") + "\\imgs\\icons\\trab1.png"));
        try{ conexao = connect.connectionMySql();
        }catch(Exception e) { ; }
	
	this.setAtualizou(atualizou);
	
	mudaLista();
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTree2 = new javax.swing.JTree();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        isAuto = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setVisible(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                mudouPosition(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.setToolTipText("Vista de diretório de trabalho");
        jScrollPane1.setViewportView(jTree1);

        jList1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jList1.setToolTipText("Lista de tipos de arquivos permitidos");
        jList1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                atualizaLista(evt);
            }
        });
        jScrollPane2.setViewportView(jList1);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tipos");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Arquivos");

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree2.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree2.setToolTipText("Vista de diretório temporário");
        jScrollPane3.setViewportView(jTree2);

        jButton1.setText("↺");
        jButton1.setToolTipText("Trocar diretórios");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Notas");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Trocar diretório");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton2.setText("Apontar pasta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton3.setText("Mapear arquivos");
        jButton3.setToolTipText("Mapear os arquivos no banco de dados");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        isAuto.setText("Automático");
        isAuto.setToolTipText("Ir automaticamente para os arquivos");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("Notas para o mapeamento de arquivos");
        jScrollPane4.setViewportView(jTextArea1);

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton4.setText("Remover");
        jButton4.setToolTipText("Remover o item selecionado");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(isAuto)
                                .addGap(6, 6, 6)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(isAuto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)))
                .addContainerGap())
        );

        setBounds(0, 0, 807, 777);
    }// </editor-fold>//GEN-END:initComponents

    private void mudouPosition(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_mudouPosition
        // TODO add your handling code here:
        this.setLocation(this.local);
    }//GEN-LAST:event_mudouPosition

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        chooser.setDialogTitle("Selecione uma nova pasta para listar os Arquivos");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
            try {
                if(isAuto.isSelected()){
                    DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
                    DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
                    root.removeAllChildren();
                    model.reload();
                    scanner(new File(chooser.getCurrentDirectory() + "\\" +chooser.getSelectedFile().getName()), jTree1);
                     this.arquivoLocal = chooser.getCurrentDirectory() + "\\" +chooser.getSelectedFile().getName();
                }else{
                    DefaultTreeModel model = (DefaultTreeModel) jTree2.getModel();
                    DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
                    root.removeAllChildren();
                    model.reload();
                    scanner(new File(chooser.getCurrentDirectory() + "\\" +chooser.getSelectedFile().getName()), jTree2);
                    this.arquivoLocal = chooser.getCurrentDirectory() + "\\" +chooser.getSelectedFile().getName();
                }
            } catch (InterruptedException ex) { Logger.getLogger(tela_trabalho1.class.getName()).log(Level.SEVERE, null, ex); }
          }
        else {
           JOptionPane.showMessageDialog(null, "Você precisa selecionar uma pasta apra atualizar o diretório!");
          }   
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTreeModel model = (DefaultTreeModel) jTree2.getModel();
        jTree2.setModel(jTree1.getModel());        
        jTree1.setModel(model);        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void atualizaLista(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_atualizaLista
	mudaLista();
    }//GEN-LAST:event_atualizaLista

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String suf = this.arquivoLocal;

        try{  
            Object root = jTree1.getModel().getRoot();

            int nodes = jTree1.getModel().getChildCount(root);

            for(int i = 0; i < nodes; i++){
                Object arquivo = jTree1.getModel().getChild(root, i);   

                if(jTree1.getModel().getChildCount(arquivo) > 0) {
                    listarArquivos(jTree1.getModel(), suf + "\\" + arquivo.toString(), arquivo);
                }
                else{
                    arquivos.add(suf + "\\" + arquivo.toString());
                }

            }
            
        }catch(Exception e){ System.out.println(e); } 
      
        for(int i = 0; i<arquivos.toArray().length; i++){
            try{
            File file = new File(arquivos.get(i));
            
            String arquivoDeli = file.getName().split(this.deli)[0];
            String revisaoDeli = file.getName().split(this.deli)[1];
            
            if(connect.getNovoArquivo(conexao, arquivoDeli, revisaoDeli).isEmpty()){
                System.out.println("arquivo é novo" + ": " + file.getName());
                
                //connect.mover(file, workPath);
                
                connect.insertArquivos(conexao, arquivoDeli, revisaoDeli, workPath);
                
                //connect.insertHistorizador(conexao, arquivoDeli, revisaoDeli, workPath, 1);
                
            }else if(!connect.getArquivos(conexao, arquivoDeli, revisaoDeli).isEmpty()){
                System.out.println("arquivo removido" + ": " + file.getName());
                
                //connect.apaga(file);
                
                //connect.insertHistorizador(conexao, arquivoDeli, revisaoDeli, workPath, 3);
                
            }else if(!connect.getRev(conexao, arquivoDeli, revisaoDeli).isEmpty()){
                System.out.println("arquivo é revisao nova" + ": " + file.getName());
                
                //connect.mover(file, workPath);
                
                connect.insertArquivos(conexao, arquivoDeli, revisaoDeli, workPath);
                
                //connect.insertHistorizador(conexao, arquivoDeli, revisaoDeli, workPath, 2);


            }else{
                System.out.println("ERRO");
            }
                
                    
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
        System.out.println("----------------");
        System.out.println("");
        
        arquivos.clear();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
        DefaultMutableTreeNode toDelete = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent(); 
        model.removeNodeFromParent(toDelete);
        
        jTree1.grabFocus();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void listarArquivos(javax.swing.tree.TreeModel model, String suf, Object root){
            try{

            int nodes = model.getChildCount(root);

            for(int i = 0; i < nodes; i++){
                Object arquivo = model.getChild(root, i);   

                if(model.getChildCount(arquivo) > 0) {
                    listarArquivos(jTree1.getModel(), suf + "\\" + arquivo.toString(), arquivo);
                }
                else{
                    arquivos.add(suf + "\\" + arquivo.toString());
                }

            }
            
        }catch(Exception e){ System.out.println(e); }   
        }
    
    public void mudaLista(){
	try{
	List<List<String>> lista_local = new ArrayList<>();
	List<String> lista_local_limpa = new ArrayList<>();
	
	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	    String line;
	    while ((line = br.readLine()) != null) {
		String[] values = line.split(";");
		lista_local.add(Arrays.asList(values));
	    }
	}

	
	int linha = 0, coluna = 0;
	
	for(List<String> i : lista_local){
	    for(String w : i){
		coluna++;
		if(linha != 0){
		    if(coluna == 2){
                        if(i.toArray()[coluna].equals("S")){
                            lista_local_limpa.add(w);
                        }
		    }
		}
	    }
	    coluna = 0;
	    linha++;
	}
	
	this.lista = lista_local_limpa.toArray(new String[0]);

	DefaultListModel modo = new DefaultListModel();
	for (int i = 0; i < lista.length; i++)
	{
	    modo.addElement(lista[i]);
	}
	jList1.setModel(modo);
	
	jList1.setModel(modo);
	this.atualizou = false;
    }catch(Exception w){ ; }
    }
    
    public void scanner(File location, JTree lista) throws InterruptedException {
        // creates a file with the location filename

        // result is the variable name for jtree
        DefaultTreeModel model = (DefaultTreeModel) lista.getModel();
        // gets the root of the current model used only once at the starting
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        // function caled
        displayDirectoryContents(location, root);
    }
    public void displayDirectoryContents(File dir, DefaultMutableTreeNode root2) throws InterruptedException {

    DefaultMutableTreeNode newdir = new DefaultMutableTreeNode();

    File[] files = dir.listFiles();

    for (File file : files) {
        if (file == null) {
            JOptionPane.showMessageDialog(null, "Diretório nulo!");
            continue;
        }
        if (file.isDirectory()) {
            // file is a directory that is a folder has been dound

            if (file.listFiles() == null) {
                // skips null files
                continue;
            }

            // gets the current model of the jtree
            DefaultTreeModel model = (DefaultTreeModel) jTree2.getModel();

            // gets the root
            DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();

            // generates a node newdir using filename
            newdir = new DefaultMutableTreeNode(file.getName());

            // adds a node to the root of the jtree
            root2.add(newdir);

            // refresh the model to show the changes
            model.reload();

            // recursively calls the function again to explore the contents
            // folder
            displayDirectoryContents(file, newdir);
        } else {
            // Else part File is not a directory

            // gets the current model of the tree
            DefaultTreeModel model = (DefaultTreeModel) jTree2.getModel();

            // selected node is the position where the new node will be
            // inserted
            DefaultMutableTreeNode selectednode = root2;

            DefaultMutableTreeNode newfile = new DefaultMutableTreeNode(file.getName());

            // inserts a node newfile under selected node which is the root
            model.insertNodeInto(newfile, selectednode, selectednode.getChildCount());

            // refresh the model to show the changes
            model.reload();

        }

    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton isAuto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTree jTree1;
    private javax.swing.JTree jTree2;
    // End of variables declaration//GEN-END:variables
}
