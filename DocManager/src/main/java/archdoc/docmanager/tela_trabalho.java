/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package archdoc.docmanager;

/**
 *
 * @author super
 */
public class tela_trabalho extends javax.swing.JFrame {

    /**
     * Creates new form tela_inicial
     */
    tela_login telaCadUser;
    
    public tela_trabalho() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
	
	tiposArquivos popup_tiposArquivos = new tiposArquivos(pane_telaprincipal);
	pane_telaprincipal.add(popup_tiposArquivos);
	popup_tiposArquivos.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pane_telaprincipal = new javax.swing.JDesktopPane();
        menu_telatrabalho = new javax.swing.JMenuBar();
        menutrabalho_logo = new javax.swing.JMenu();
        menutrabalho_separador1 = new javax.swing.JMenu();
        menutrabalho_salvar = new javax.swing.JMenu();
        menutrabalho_separador2 = new javax.swing.JMenu();
        menutrabalho_exportar = new javax.swing.JMenu();
        menutrabalho_separador3 = new javax.swing.JMenu();
        menutrabalho_novoarquivo = new javax.swing.JMenu();
        menutrabalho_separador4 = new javax.swing.JMenu();
        menutrabalho_workpath = new javax.swing.JMenu();
        menutrabalho_separador5 = new javax.swing.JMenu();
        menutrabalho_opcoes = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout pane_telaprincipalLayout = new javax.swing.GroupLayout(pane_telaprincipal);
        pane_telaprincipal.setLayout(pane_telaprincipalLayout);
        pane_telaprincipalLayout.setHorizontalGroup(
            pane_telaprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 868, Short.MAX_VALUE)
        );
        pane_telaprincipalLayout.setVerticalGroup(
            pane_telaprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
        );

        menutrabalho_logo.setIcon(new javax.swing.ImageIcon("C:\\Users\\super\\Downloads\\logo (1).png")); // NOI18N
        menutrabalho_logo.setText("AD.LMTD");
        menutrabalho_logo.setFocusable(false);
        menutrabalho_logo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menu_telatrabalho.add(menutrabalho_logo);

        menutrabalho_separador1.setText("|");
        menutrabalho_separador1.setEnabled(false);
        menutrabalho_separador1.setFocusable(false);
        menu_telatrabalho.add(menutrabalho_separador1);

        menutrabalho_salvar.setText("Salvar");
        menutrabalho_salvar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menu_telatrabalho.add(menutrabalho_salvar);

        menutrabalho_separador2.setText("|");
        menutrabalho_separador2.setEnabled(false);
        menutrabalho_separador2.setFocusable(false);
        menu_telatrabalho.add(menutrabalho_separador2);

        menutrabalho_exportar.setText("Exportar Histórico");
        menutrabalho_exportar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menu_telatrabalho.add(menutrabalho_exportar);

        menutrabalho_separador3.setText("|");
        menutrabalho_separador3.setEnabled(false);
        menutrabalho_separador3.setFocusable(false);
        menu_telatrabalho.add(menutrabalho_separador3);

        menutrabalho_novoarquivo.setText("Novos Arquivos");
        menutrabalho_novoarquivo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menu_telatrabalho.add(menutrabalho_novoarquivo);

        menutrabalho_separador4.setText("|");
        menutrabalho_separador4.setEnabled(false);
        menutrabalho_separador4.setFocusable(false);
        menu_telatrabalho.add(menutrabalho_separador4);

        menutrabalho_workpath.setText("WorkPath");
        menutrabalho_workpath.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menu_telatrabalho.add(menutrabalho_workpath);

        menutrabalho_separador5.setText("|");
        menutrabalho_separador5.setEnabled(false);
        menutrabalho_separador5.setFocusable(false);
        menu_telatrabalho.add(menutrabalho_separador5);

        menutrabalho_opcoes.setText("Opções");
        menutrabalho_opcoes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menu_telatrabalho.add(menutrabalho_opcoes);

        setJMenuBar(menu_telatrabalho);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane_telaprincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane_telaprincipal)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tela_trabalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tela_trabalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tela_trabalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tela_trabalho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tela_trabalho().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar menu_telatrabalho;
    private javax.swing.JMenu menutrabalho_exportar;
    private javax.swing.JMenu menutrabalho_logo;
    private javax.swing.JMenu menutrabalho_novoarquivo;
    private javax.swing.JMenu menutrabalho_opcoes;
    private javax.swing.JMenu menutrabalho_salvar;
    private javax.swing.JMenu menutrabalho_separador1;
    private javax.swing.JMenu menutrabalho_separador2;
    private javax.swing.JMenu menutrabalho_separador3;
    private javax.swing.JMenu menutrabalho_separador4;
    private javax.swing.JMenu menutrabalho_separador5;
    private javax.swing.JMenu menutrabalho_workpath;
    private javax.swing.JDesktopPane pane_telaprincipal;
    // End of variables declaration//GEN-END:variables
}
