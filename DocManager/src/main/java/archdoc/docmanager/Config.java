/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package archdoc.docmanager;

import com.opencsv.CSVWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author conta
 */
public class Config extends javax.swing.JInternalFrame {

    /**
     * Creates new form tiposArquivos
     */
    private String file = System.getProperty("user.dir") + "\\Parameters\\tiposRev.csv";
    JDesktopPane tela;
    private String[] topo_tabela;
    private String[][] tabela;
    private String[][] tabela_sem_topo;
    private boolean atualizou;
    public static String deli = "_";

    public boolean isAtualizou() {
	return atualizou;
    }

    public void setAtualizou(boolean atualizou) {
	this.atualizou = atualizou;
    }

    public Config(JDesktopPane tela) {
	initComponents();
	setFrameIcon(new ImageIcon(System.getProperty("user.dir") + "\\imgs\\icons\\tipos.png"));

	int lDesk = tela.getWidth();
	int aDesk = tela.getHeight();
	int lIFrame = this.getWidth();
	int aIFrame = this.getHeight();

	this.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);

	this.tela = tela;
	try {
	    atualizaTabela();
	} catch (Exception e) {;
	}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaArquivos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuSalvar = new javax.swing.JMenu();
        separar1 = new javax.swing.JMenu();
        menuCancelar = new javax.swing.JMenu();
        separar2 = new javax.swing.JMenu();
        menuDeletar = new javax.swing.JMenu();
        separar3 = new javax.swing.JMenu();
        menuAdicionar = new javax.swing.JMenu();
        separar4 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setClosable(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(600, 600));
        setMinimumSize(new java.awt.Dimension(600, 600));
        setVisible(true);

        tabelaArquivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "N°", "Rev"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaArquivos.setToolTipText("");
        jScrollPane1.setViewportView(tabelaArquivos);

        menuSalvar.setText("Salvar");
        menuSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSalvarMouseClicked(evt);
            }
        });
        menuSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalvarActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuSalvar);

        separar1.setText("|");
        separar1.setEnabled(false);
        separar1.setFocusable(false);
        jMenuBar1.add(separar1);

        menuCancelar.setText("Cancelar");
        menuCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCancelarMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuCancelar);

        separar2.setText("|");
        separar2.setEnabled(false);
        separar2.setFocusable(false);
        jMenuBar1.add(separar2);

        menuDeletar.setText("Deletar");
        menuDeletar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuDeletarMouseClicked(evt);
            }
        });
        menuDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDeletarActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuDeletar);

        separar3.setText("|");
        separar3.setEnabled(false);
        separar3.setFocusable(false);
        jMenuBar1.add(separar3);

        menuAdicionar.setText("Adicionar");
        menuAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAdicionarMouseClicked(evt);
            }
        });
        menuAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAdicionarActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuAdicionar);

        separar4.setText("|");
        separar4.setEnabled(false);
        separar4.setFocusable(false);
        jMenuBar1.add(separar4);

        jMenu1.setText("Delimitador");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAdicionarActionPerformed
	// TODO add your handling code here:
    }//GEN-LAST:event_menuAdicionarActionPerformed

    private void menuAdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAdicionarMouseClicked
	// TODO add your handling code here:
	try {
	    DefaultTableModel model = (DefaultTableModel) tabelaArquivos.getModel();

	    String[] row = {String.valueOf(tabelaArquivos.getRowCount() + 1), JOptionPane.showInputDialog(tela, "Digite o tipo de arquivo"), "S"};

	    model.addRow(row);

	    tabelaArquivos.setModel(model);

	} catch (Exception e) {;
	}
    }//GEN-LAST:event_menuAdicionarMouseClicked

    private void menuDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDeletarActionPerformed
	// TODO add your handling code here:
    }//GEN-LAST:event_menuDeletarActionPerformed

    private void menuDeletarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuDeletarMouseClicked
	// TODO add your handling code here
	try {
	    DefaultTableModel model = (DefaultTableModel) this.tabelaArquivos.getModel();
	    int[] rows = this.tabelaArquivos.getSelectedRows();
	    for (int i = 0; i < rows.length; i++) {
		model.removeRow(rows[i] - i);
	    }
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(tela, e);
	}
    }//GEN-LAST:event_menuDeletarMouseClicked

    private void menuCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCancelarMouseClicked
	// TODO add your handling code here
	dispose();
    }//GEN-LAST:event_menuCancelarMouseClicked

    private void menuSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalvarActionPerformed

    }//GEN-LAST:event_menuSalvarActionPerformed

    private void menuSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSalvarMouseClicked
	// TODO add your handling code here:

	String tabela[][] = new String[this.tabelaArquivos.getRowCount() + 1][this.tabelaArquivos.getColumnCount()];

	tabela[0] = topo_tabela;

	for (int linha = 0; linha < this.tabelaArquivos.getRowCount(); linha++) {
                
	    for (int coluna = 0; coluna < this.tabelaArquivos.getColumnCount(); coluna++) {
		try {
                    tabela[linha + 1][coluna] = new String((String) this.tabelaArquivos.getValueAt(linha, coluna)).toUpperCase();
		}catch(Exception e) { ; }
	    }
            
	}
        

	try {
	    // create FileWriter object with file as parameter
	    FileWriter outputfile;
	    outputfile = new FileWriter(file);
	    // create CSVWriter object filewriter object as parameter
	    CSVWriter writer = new CSVWriter(outputfile, ';',
		    CSVWriter.NO_QUOTE_CHARACTER,
		    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
		    CSVWriter.DEFAULT_LINE_END);

	    for (String[] w : tabela) {
		writer.writeNext(w);
	    }
	    writer.close();

	} catch (IOException ex) {
	    Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
	}

	dispose();
	this.atualizou = true;
    }//GEN-LAST:event_menuSalvarMouseClicked

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        this.deli = JOptionPane.showInputDialog(null, "Insira o caráter delimitador:", JOptionPane.QUESTION_MESSAGE);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void atualizaTabela() throws FileNotFoundException, IOException {
	List<List<String>> tabela = new ArrayList<>();
	List<String> topo = new ArrayList<>();

	try ( BufferedReader br = new BufferedReader(new FileReader(file))) {
	    String line;
	    while ((line = br.readLine()) != null) {
		String[] values = line.split(";");
		tabela.add(Arrays.asList(values));
	    }
	}

	this.tabela = tabela.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

	int linha = 0, coluna = 0;

	for (List<String> i : tabela) {
	    for (String w : i) {
		coluna++;
		if (linha == 0) {
		    topo.add(w);
		}
	    }
	    coluna = 0;
	    linha++;
	}

	topo_tabela = topo.toArray(new String[0]);
	tabela_sem_topo = tabela.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

	tabela.remove(0);

	String[] tabelaString = topo.toArray(new String[0]);
	String[][] stringArray = tabela.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

	DefaultTableModel modo = new DefaultTableModel(stringArray, tabelaString);
	tabelaArquivos.setModel(modo);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuAdicionar;
    private javax.swing.JMenu menuCancelar;
    private javax.swing.JMenu menuDeletar;
    private javax.swing.JMenu menuSalvar;
    private javax.swing.JMenu separar1;
    private javax.swing.JMenu separar2;
    private javax.swing.JMenu separar3;
    private javax.swing.JMenu separar4;
    private javax.swing.JTable tabelaArquivos;
    // End of variables declaration//GEN-END:variables
}