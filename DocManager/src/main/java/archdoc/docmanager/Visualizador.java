package archdoc.docmanager;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
/**
 *
 * @author Gustavo Paiva
 */
public class Visualizador extends javax.swing.JInternalFrame {

    /**
     * Creates new form Visualizador
     */
    ArrayList<String> tabela = new ArrayList<String>();
    ArrayList<String[]> campo = new ArrayList<String[]>();

    Connection conexao;
    connect connect = new connect();
    JDesktopPane telaPrincipal;

    public Visualizador(JDesktopPane telaPrincipal) {
        initComponents();
        
        this.telaPrincipal = telaPrincipal;

        try {
            conexao = connect.connectionMySql();
        } catch (Exception e) {;
        }

        int lDesk = telaPrincipal.getWidth();
        int aDesk = telaPrincipal.getHeight();
        int lIFrame = this.getWidth();
        int aIFrame = this.getHeight();

        this.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);

        setFrameIcon(new ImageIcon(System.getProperty("user.dir") + "\\imgs\\icons\\view.png"));
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for(int i = 0; i<connect.getView(conexao).toArray().length; i++){
            String[] row = {connect.getView(conexao).get(i)};
            model.addRow(row);
        }
        
	jTable1.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setClosable(true);
        setTitle("Criar Views");
        setToolTipText("");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                fechamento(evt);
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "arquivo", "revisao" }));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Campo:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Tabela:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arquivos", "Historizador" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Marcar como:");

        jButton1.setText("Adicionar Tabelas/Campos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Ignorar");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tabela", "Campos", "AKA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.setToolTipText("");
        jTable2.setEnabled(false);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Atual", jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N", "View"
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
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Lista", jScrollPane1);

        jMenu5.setText("Salvar");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        jMenu2.setText("|");
        jMenu2.setEnabled(false);
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Deletar");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox2))
                            .addComponent(jSeparator1))))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        DefaultComboBoxModel opa = new DefaultComboBoxModel();

        if (jComboBox2.getSelectedItem().equals("Historizador")) {
            opa.addElement("arquivo");
            opa.addElement("revisao");
            opa.addElement("acao");
            opa.addElement("AcaoDesc");
            opa.addElement("Data_historizador");
        } else {
            opa.addElement("arquivo");
            opa.addElement("revisao");
        }
        jComboBox1.setModel(opa);
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (!tabela.contains((String) jComboBox2.getSelectedItem() + " " + jComboBox2.getSelectedItem().toString().substring(0, 1))) {
            tabela.add((String) jComboBox2.getSelectedItem() + " " + jComboBox2.getSelectedItem().toString().substring(0, 1));
        }

        if (!campo.contains(jComboBox2.getSelectedItem().toString().substring(0, 1) + "." + (String) jComboBox1.getSelectedItem())) {
            if (jCheckBox2.isSelected()) {
                String[] Stemp = new String[2];
                Stemp[0] = (String) jComboBox2.getSelectedItem().toString().substring(0, 1) + "." + (String) jComboBox1.getSelectedItem();
                Stemp[1] = (String) jComboBox1.getSelectedItem();
                campo.add(Stemp);
            } else {
                String[] Stemp = new String[2];
                Stemp[0] = (String) jComboBox2.getSelectedItem().toString().substring(0, 1) + "." + (String) jComboBox1.getSelectedItem();
                Stemp[1] = jTextField2.getText();
                campo.add(Stemp);
            }
        }

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();

        String[] row = {tabela.get(tabela.toArray().length - 1), campo.get(campo.toArray().length - 1)[0], campo.get(campo.toArray().length - 1)[1]};

        model.addRow(row);
        jTable2.setModel(model);

        jTextField2.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu5ActionPerformed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        // TODO add your handling code here:
        String querry = "SELECT ";

        for (int i = 0; i < campo.toArray().length; i++) {
            if (i == 0) {
                if (campo.get(i)[1].equals("")) {
                    querry = querry + campo.get(i)[0];
                } else {
                    querry = querry + campo.get(i)[0] + " As \"" + campo.get(i)[1] + "\"";
                }
            } else {
                if (campo.get(i)[1].equals("")) {
                    querry = querry + ", " + campo.get(i)[0];
                } else {
                    querry = querry + ", " + campo.get(i)[0] + " As \"" + campo.get(i)[1] + "\"";
                }
            }
        }

        querry = querry + " from ";

        for (int i = 0; i < tabela.toArray().length; i++) {
            if (i == 0) {
                querry = querry + tabela.get(i);
            } else {
                querry = querry + ", " + tabela.get(i);
            }
        }

        if (tabela.toArray().length > 1) {
            querry = querry + " where A.cod_arquivos = H.cod_arquivos;";
        } else {
            querry = querry + ";";
        }

        querry = "CREATE VIEW " + JOptionPane.showInputDialog(null, "Nome da View") + " as " + querry;
        System.out.println(querry);
        
        connect.criarView(conexao, querry);

        tabela.clear();
        campo.clear();
        
        dispose();
    }//GEN-LAST:event_jMenu5MouseClicked

    private void fechamento(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_fechamento
        try {
            // TODO add your handling code here:
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_fechamento

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        // TODO add your handling code here:
        ListaViews tmp = new ListaViews(telaPrincipal);
        telaPrincipal.add(tmp);
        tmp.setVisible(true);
    }//GEN-LAST:event_jMenu3MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
