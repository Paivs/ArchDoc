package archdoc.docmanager;

import java.awt.Frame;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;


public class tela_login_criar extends javax.swing.JInternalFrame {
    
    JDesktopPane telaPrincipal;
    boolean fezLogin = false;
    Connection conexao;
    connect criaBD;
    boolean darkMode;
    
    
    public tela_login_criar(JDesktopPane telaPrincipal, Connection conexao, boolean darkMode) {
        initComponents();
        
        setFrameIcon(new ImageIcon(System.getProperty("user.dir") + "\\imgs\\icons\\login.png"));
        
        this.telaPrincipal = telaPrincipal;
        this.conexao = conexao;
        this.darkMode = darkMode;
        criaBD = new connect();
        
        int lDesk = telaPrincipal.getWidth();  
	int aDesk = telaPrincipal.getHeight();  
	int lIFrame = this.getWidth();  
	int aIFrame = this.getHeight();  

	this.setLocation(lDesk / 2 - lIFrame / 2, aDesk / 2 - aIFrame / 2);
        
        setBackground(new java.awt.Color(1.0f,1.0f,1.0f,0.0f));
 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        campo_usuario1 = new javax.swing.JTextField();
        label_usuario1 = new javax.swing.JLabel();
        label_senha1 = new javax.swing.JLabel();
        botao_entrar1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        notas1 = new javax.swing.JTextPane();
        label_notas1 = new javax.swing.JLabel();
        campo_senha1 = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        mostrarSenha = new javax.swing.JCheckBox();
        label_notas2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setClosable(true);

        campo_usuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_usuario1ActionPerformed(evt);
            }
        });

        label_usuario1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        label_usuario1.setText("Usuário");

        label_senha1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        label_senha1.setText("Senha");

        botao_entrar1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        botao_entrar1.setText("Enviar");
        botao_entrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_entrar1ActionPerformed(evt);
            }
        });

        notas1.setEditable(false);
        notas1.setText("Faça sua requisição de cadastro para o administrador");
        notas1.setFocusable(false);
        jScrollPane2.setViewportView(notas1);

        label_notas1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        label_notas1.setText("Notas");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        mostrarSenha.setText("Mostrar Senha");
        mostrarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarSenhaActionPerformed(evt);
            }
        });

        label_notas2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        label_notas2.setText("Motivação");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(410, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_notas2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 79, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label_usuario1)
                        .addComponent(campo_usuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_senha1)
                        .addComponent(campo_senha1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(mostrarSenha)
                        .addComponent(botao_entrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(40, 40, 40)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label_notas1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 80, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addComponent(label_notas2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 72, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(label_usuario1)
                            .addGap(6, 6, 6)
                            .addComponent(campo_usuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(label_senha1)
                            .addGap(6, 6, 6)
                            .addComponent(campo_senha1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(6, 6, 6)
                            .addComponent(mostrarSenha)
                            .addGap(18, 18, 18)
                            .addComponent(botao_entrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label_notas1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 74, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campo_usuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_usuario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_usuario1ActionPerformed

    private void botao_entrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_entrar1ActionPerformed
        // TODO add your handling code here:
        char[] password = campo_senha1.getPassword();

        if(criaBD.checkUser(conexao, campo_usuario1.getText(), String.valueOf(password))){

            loading Carr = new loading();
            Carr.setVisible(true);
            dispose();
            this.fezLogin = true;
            for(Frame v : tela_principal.getFrames()){
                if(v.getName().equals("frame0")) {
                    v.dispose();
                }
            }
        }
    }//GEN-LAST:event_botao_entrar1ActionPerformed

    private void mostrarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarSenhaActionPerformed
        // TODO add your handling code here:
        //campo_senha1.setAction(Action);
        if(mostrarSenha.isSelected())
        campo_senha1.setEchoChar((char)0);
        else
        campo_senha1.setEchoChar('•');
    }//GEN-LAST:event_mostrarSenhaActionPerformed

    public boolean isFezLogin() {
        return fezLogin;
    }

    public void setFezLogin(boolean fezLogin) {
        this.fezLogin = fezLogin;
    }

    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_entrar1;
    private javax.swing.JPasswordField campo_senha1;
    private javax.swing.JTextField campo_usuario1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel label_notas1;
    private javax.swing.JLabel label_notas2;
    private javax.swing.JLabel label_senha1;
    private javax.swing.JLabel label_usuario1;
    private javax.swing.JCheckBox mostrarSenha;
    private javax.swing.JTextPane notas1;
    // End of variables declaration//GEN-END:variables
}
