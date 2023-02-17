/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package archdoc.docmanager;

import java.beans.PropertyVetoException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo Paiva
 */
public class View extends javax.swing.JInternalFrame {

    /**
     * Creates new form View
     */
    
    Connection conexao;
    connect connect = new connect();
    
    private String[] lista;
    
    public View(JDesktopPane telaPrincipal) {
        initComponents();
        
        try {
        setMaximum(true);
        } catch (PropertyVetoException e) { ; }
        
        try {
            conexao = connect.connectionMySql();
        } catch (Exception e) {;
        }

        int lDesk = telaPrincipal.getWidth();
        int aDesk = telaPrincipal.getHeight();
        int lIFrame = this.getWidth();
        int aIFrame = this.getHeight();

        this.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);

        setFrameIcon(new ImageIcon(System.getProperty("user.dir") + "\\imgs\\icons\\views.png"));
        
        mudaLista();
        
        jList1.grabFocus();
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
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setTitle("Visualizador");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                fechamento(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Visualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N", "Exemplo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setEnabled(false);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Default", jPanel1);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jTabbedPane1)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fechamento(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_fechamento
        try {
            // TODO add your handling code here:
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_fechamento

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            ArrayList<String[]> cru = connect.getSelectView(conexao, jList1.getSelectedValue());
            String[][] tabela_;
            String[] topo_;

            List<String> topo = new ArrayList<>();
            List<String[]> tmpTopo = new ArrayList();
            
            int column = Integer.parseInt(cru.get(cru.toArray().length - 1)[0]);
            
            
            cru.remove(cru.toArray().length - 1); //remove numero de colunas
            
            int delete = cru.toArray().length - column;
            
            tmpTopo = cru.subList(delete, cru.toArray().length);
            
            
            for (int i = 0; i < tmpTopo.toArray().length; i++) {
                topo.add(tmpTopo.get(i)[0]);
            }
            
            for (int i = 0; i < topo.toArray().length; i++) {
                System.out.println(topo.get(i));
            }
            
            cru.remove(cru.toArray().length - column);
            
            try{
                int tamanho = cru.toArray().length -1;
                int limite = (tamanho - column + 1);
                
                for (int i = tamanho; i > limite; i--) {
                    System.out.println("REMOVENDO: " + cru.get(i)[0]);
                    System.out.println("INDEX: " + i);
                    System.out.println("| - |");
                    cru.remove(i);
                }
                
            }catch(Exception e){System.out.println(e);}


            tabela_ = cru.toArray(new String[0][0]);
    
            topo_ = topo.toArray(new String[0]);


            DefaultTableModel modo = new DefaultTableModel(tabela_, topo_);
            
            jTable1.setModel(modo);
        }catch(Exception e){ System.out.println("ERROU " + e);}
    }//GEN-LAST:event_jButton1ActionPerformed

    public void mudaLista(){
	this.lista = connect.getView(conexao).toArray(new String[0]);

	DefaultListModel modo = new DefaultListModel();
	for (int i = 0; i < lista.length; i++) modo.addElement(lista[i]);
        
	jList1.setModel(modo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
