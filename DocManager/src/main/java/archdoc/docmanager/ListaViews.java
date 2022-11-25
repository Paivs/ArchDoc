/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package archdoc.docmanager;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Gustavo Paiva
 */
public class ListaViews extends javax.swing.JInternalFrame {

    Connection conexao;
    connect connect = new connect();
    tela_trabalho1 trabalhoNovo;
    ;
    
    boolean toDelete = false;
    int codAnalisar = 0;

    String ext;

    public ListaViews(tela_trabalho1 trabalhoNovo, String ext, JDesktopPane telaPrincipal) {
        initComponents();
        try {
            conexao = connect.connectionMySql();
        } catch (Exception e) {;
        }

        int lDesk = telaPrincipal.getWidth();
        int aDesk = telaPrincipal.getHeight();
        int lIFrame = this.getWidth();
        int aIFrame = this.getHeight();

        this.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);

        setFrameIcon(new ImageIcon(System.getProperty("user.dir") + "\\imgs\\icons\\lista.png"));

        this.ext = ext;
        this.trabalhoNovo = trabalhoNovo;

        String[] lista = connect.getView(conexao).toArray(new String[0]);

        DefaultListModel modo = new DefaultListModel();
        for (int i = 0; i < lista.length; i++) {
            modo.addElement(lista[i]);
        }

        jList1.setModel(modo);

        this.setTitle("Selecione a View para ser Exportada");
        toDelete = false;
    }

    public ListaViews(JDesktopPane telaPrincipal) {
        initComponents();
        try {
            conexao = connect.connectionMySql();
        } catch (Exception e) {;
        }

        int lDesk = telaPrincipal.getWidth();
        int aDesk = telaPrincipal.getHeight();
        int lIFrame = this.getWidth();
        int aIFrame = this.getHeight();

        this.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);

        setFrameIcon(new ImageIcon(System.getProperty("user.dir") + "\\imgs\\icons\\lista.png"));

        String[] lista = connect.getView(conexao).toArray(new String[0]);

        DefaultListModel modo = new DefaultListModel();
        for (int i = 0; i < lista.length; i++) {
            modo.addElement(lista[i]);
        }

        jList1.setModel(modo);

        this.setTitle("Selecione a View para ser Deletada");
        toDelete = true;
    }
    
    public ListaViews(tela_trabalho1 trabalhoNovo, JDesktopPane telaPrincipal, int codAnalisar) {
        initComponents();
        
        this.codAnalisar = codAnalisar;
                
        try{ conexao = connect.connectionMySql();
        }catch (Exception e) {;}

        int lDesk = telaPrincipal.getWidth();
        int aDesk = telaPrincipal.getHeight();
        int lIFrame = this.getWidth();
        int aIFrame = this.getHeight();

        this.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);

        setFrameIcon(new ImageIcon(System.getProperty("user.dir") + "\\imgs\\icons\\lista.png"));

        this.ext = ext;
        this.trabalhoNovo = trabalhoNovo;

        String[] lista = connect.getView(conexao).toArray(new String[0]);

        DefaultListModel modo = new DefaultListModel();
        for (int i = 0; i < lista.length; i++) {
            modo.addElement(lista[i]);
        }

        jList1.setModel(modo);

        this.setTitle("Selecione a View a ser analisada");
        toDelete = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                fechou(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
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

        jButton1.setText("Selecionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setToolTipText("");
        jScrollPane2.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (!toDelete) {
            trabalhoNovo.chooser.setDialogTitle("Selecione a pasta para fazer o export");
            trabalhoNovo.chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            if (trabalhoNovo.chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                String destino = trabalhoNovo.chooser.getSelectedFile().getPath();
                connect.exportar(conexao, jList1.getSelectedValue(), ext, destino);

                String pasta = trabalhoNovo.chooser.getSelectedFile().getAbsolutePath();
                String arquivo = trabalhoNovo.chooser.getName();

            } else {
                JOptionPane.showMessageDialog(null, "Você precisa selecionar uma pasta apra atualizar o diretório!");
            }
        } else if (toDelete) {
            connect.criarView(conexao, "drop view " + jList1.getSelectedValue() + ";");
        }

        JOptionPane.showMessageDialog(null, "Pronto!");

        try {
            java.awt.Desktop.getDesktop().open(trabalhoNovo.chooser.getSelectedFile());
        } catch (IOException ex) {
            Logger.getLogger(ListaViews.class.getName()).log(Level.SEVERE, null, ex);
        }

        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void fechou(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_fechou
        try {
            // TODO add your handling code here:
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(ListaViews.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_fechou


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
