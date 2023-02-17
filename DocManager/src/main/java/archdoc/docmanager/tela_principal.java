/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package archdoc.docmanager;

import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URI;
import javax.swing.ImageIcon;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author super
 */

public class tela_principal extends javax.swing.JFrame {

    /**
     * Creates new form tela_inicial
     */
    private tela_login telaCadUser;
    private tela_login_criar telaCadCad;
    private javax.swing.JFrame frame;
    private connect connect = new connect();
    private Connection conexao;
    
    static boolean darkMode = true;
    
    private String htmlSobre = System.getProperty("user.dir") + "/HTML/main/index.html";
    private String htmlAjuda = System.getProperty("user.dir") + "/HTML/main/contato.html";
    
    Info telinha;
    
    public tela_principal() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        
        try{ conexao = connect.connectionMySql();
        }catch(Exception e) { ; }
        
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(System.getProperty("user.dir") + "/imgs/icons/principal.png");
        setIconImage(iconeTitulo);
        
        logo.setIcon(new ImageIcon(System.getProperty("user.dir") + "/imgs/fundo.png"));
        logo.setVisible(true);
        
        System.out.println(System.getProperty("user.dir") + "/imgs/fundo.png");

 
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
        logo = new javax.swing.JLabel();
        menu_telaprincipal = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        menuprincipal_usuario = new javax.swing.JMenu();
        menuitem_login = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuprincipal_opcoes = new javax.swing.JMenu();
        menuitem_sobre = new javax.swing.JMenuItem();
        menuitem_ajuda = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DocManager - Plataforma de Gestão");

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        pane_telaprincipal.setLayer(logo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pane_telaprincipalLayout = new javax.swing.GroupLayout(pane_telaprincipal);
        pane_telaprincipal.setLayout(pane_telaprincipalLayout);
        pane_telaprincipalLayout.setHorizontalGroup(
            pane_telaprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        pane_telaprincipalLayout.setVerticalGroup(
            pane_telaprincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        menu_telaprincipal.setBackground(new java.awt.Color(0, 0, 0));
        menu_telaprincipal.setToolTipText("");

        jMenu2.setText("archDoc");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        menu_telaprincipal.add(jMenu2);

        jMenu4.setText("|");
        jMenu4.setEnabled(false);
        jMenu4.setFocusable(false);
        menu_telaprincipal.add(jMenu4);

        menuprincipal_usuario.setText("Usuário");
        menuprincipal_usuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menuprincipal_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuprincipal_usuarioActionPerformed(evt);
            }
        });

        menuitem_login.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuitem_login.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menuitem_login.setText("Login");
        menuitem_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitem_loginActionPerformed(evt);
            }
        });
        menuprincipal_usuario.add(menuitem_login);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem2.setText("Cadastrar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuprincipal_usuario.add(jMenuItem2);

        menu_telaprincipal.add(menuprincipal_usuario);

        jMenu1.setText("|");
        jMenu1.setEnabled(false);
        jMenu1.setFocusable(false);
        menu_telaprincipal.add(jMenu1);

        menuprincipal_opcoes.setText("Opções");
        menuprincipal_opcoes.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        menuitem_sobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        menuitem_sobre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menuitem_sobre.setText("Sobre");
        menuitem_sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitem_sobreActionPerformed(evt);
            }
        });
        menuprincipal_opcoes.add(menuitem_sobre);

        menuitem_ajuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        menuitem_ajuda.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        menuitem_ajuda.setText("Ajuda");
        menuitem_ajuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuitem_ajudaActionPerformed(evt);
            }
        });
        menuprincipal_opcoes.add(menuitem_ajuda);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F10, 0));
        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem1.setText("Mudar Tema");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuprincipal_opcoes.add(jMenuItem1);

        menu_telaprincipal.add(menuprincipal_opcoes);

        setJMenuBar(menu_telaprincipal);

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

    private void menuitem_sobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitem_sobreActionPerformed
        // TODO add your handling code here:
	try{
        Desktop desktop = Desktop.getDesktop();
	File htmlSobre_file = new File(htmlSobre);
        desktop.open(htmlSobre_file);
	}catch(Exception erro){
            System.out.println(erro);
        }
    }//GEN-LAST:event_menuitem_sobreActionPerformed

    private void menuprincipal_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuprincipal_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuprincipal_usuarioActionPerformed

    private void menuitem_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitem_loginActionPerformed
        // TODO add your handling code here:
	try{
	    if(!telaCadUser.isVisible()){
		telaCadUser = new tela_login(pane_telaprincipal, conexao, darkMode);
		pane_telaprincipal.add(telaCadUser);
		telaCadUser.setVisible(true);
	    }
	} catch(Exception e) { 
	    telaCadUser = new tela_login(pane_telaprincipal, conexao, darkMode);
	    pane_telaprincipal.add(telaCadUser);
	    telaCadUser.setVisible(true);
	    telaCadUser.moveToFront();
	}
    }//GEN-LAST:event_menuitem_loginActionPerformed

    private void menuitem_ajudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuitem_ajudaActionPerformed
        // TODO add your handling code here:
	try{
	    URI link = new URI("https://archdoc.acessoseguro.tec.br/contato.html");
            Desktop.getDesktop().browse(link);
	}catch(Exception erro){
            System.out.println(erro);
        }
    }//GEN-LAST:event_menuitem_ajudaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        try {
        if(javax.swing.UIManager.getLookAndFeel().getName() == "FlatLaf Darcula"){
            FlatLightLaf lookAndFeel1 = new FlatLightLaf();
            javax.swing.UIManager.setLookAndFeel(lookAndFeel1);
            darkMode = false;
	    logo.setIcon(new ImageIcon(System.getProperty("user.dir") + "/imgs/fundo_alter.png"));
	    logo.setVisible(true);
        } else{
            FlatDarculaLaf lookAndFeel2 = new FlatDarculaLaf();
            javax.swing.UIManager.setLookAndFeel(lookAndFeel2);
            darkMode = true;
	    logo.setIcon(new ImageIcon(System.getProperty("user.dir") + "/imgs/fundo.png"));
	    logo.setVisible(true);
        }
        
            
            for(java.awt.Frame f : java.awt.Frame.getFrames()) {
                javax.swing.SwingUtilities.updateComponentTreeUI(f);
            }
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        try{
	    if(!telinha.isVisible()){
		telinha = new Info(pane_telaprincipal);
		pane_telaprincipal.add(telinha);
		telinha.setVisible(true);
		telinha.moveToFront();
	    }
	}catch(Exception e) { 
	    telinha = new Info(pane_telaprincipal);
	    pane_telaprincipal.add(telinha);
	    telinha.setVisible(true);
	    telinha.moveToFront(); 
	}
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try{
	    if(!telaCadCad.isVisible()){
		telaCadCad = new tela_login_criar(pane_telaprincipal, conexao, darkMode);
		pane_telaprincipal.add(telaCadCad);
		telaCadCad.setVisible(true);
		telaCadCad.moveToFront();
	    }
	} catch(Exception e) { 
	    telaCadCad = new tela_login_criar(pane_telaprincipal, conexao, darkMode);
	    pane_telaprincipal.add(telaCadCad);
	    telaCadCad.setVisible(true);
	    telaCadCad.moveToFront();
	}
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    
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
            if(darkMode){
		//javax.swing.UIManager.setLookAndFeel( new FlatDarculaLaf() );
		javax.swing.UIManager.setLookAndFeel( new FlatDarculaLaf() );
	    }
            else {
		javax.swing.UIManager.setLookAndFeel( new FlatLightLaf() );
	    }
	    
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tela_principal().setVisible(true);
            }
        });
        
 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel logo;
    private javax.swing.JMenuBar menu_telaprincipal;
    private javax.swing.JMenuItem menuitem_ajuda;
    private javax.swing.JMenuItem menuitem_login;
    private javax.swing.JMenuItem menuitem_sobre;
    private javax.swing.JMenu menuprincipal_opcoes;
    private javax.swing.JMenu menuprincipal_usuario;
    private javax.swing.JDesktopPane pane_telaprincipal;
    // End of variables declaration//GEN-END:variables
}
