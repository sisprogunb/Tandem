package tandemplatform;


import javax.swing.JFrame;

public class InitialPanel extends javax.swing.JFrame {
    
    User user = null;
    
    public User getUser(){
        return user;
    }

    public InitialPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        signinButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        labelPassword = new javax.swing.JLabel();
        labelUsername = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        textfieldUsername = new javax.swing.JTextField();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.white);

        signinButton.setText("SIGN IN NOW!");
        signinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinButtonActionPerformed(evt);
            }
        });

        labelPassword.setText("PASSWORD");

        labelUsername.setText("USERNAME");

        loginButton.setText("LOG IN NOW!");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("      TANDEM PLATFORM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(281, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordField)
                    .addComponent(textfieldUsername))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelUsername)
                    .addComponent(labelPassword))
                .addGap(87, 87, 87))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(signinButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsername)
                    .addComponent(textfieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(signinButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPassword))
                .addGap(18, 18, 18)
                .addComponent(loginButton)
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        
        String username = textfieldUsername.getText();
        
        
        String password;
        password = passwordField.getText();
        
        ClientClass clientclass = new ClientClass();       
        clientclass.startConnection();
        
        clientclass.sendUsername(username);
        

        boolean control = clientclass.receiveData();
        
        System.out.println(control);
        
        if (control){
            
            clientclass.sendPassword(password);
            boolean control2 = clientclass.receiveData();
            System.out.println(control2);
            
            if (control2){
                
                System.out.println("Login accepted");
                
                clientclass.controlReceiveUser();
                user = clientclass.receiveUser();
                
                ProfileFrame profile = new ProfileFrame();
                profile.setUser(user);
                
                profile.setUsername( textfieldUsername.getText() );
                profile.setName(user.getName());
                profile.setBirthdate(user.getBirthdate());
                profile.setSurname(user.getSurname());
                profile.setOccupation(user.getOccupation());
                profile.setEmail(user.getEmail());
                profile.setCOO(user.getCOO());
                profile.setCOR(user.getCOR());
                profile.setClient(clientclass);
                profile.setVisible(true);
                profile.setLocationRelativeTo(null);
                this.setVisible(false);
                
            } else{
                System.out.println("Login refused. Try again.");
                textfieldUsername.setText(null);
                passwordField.setText(null);
            }
            
        } else {
            System.out.println("User doesn't exist. Try again.");
            textfieldUsername.setText(null);
            passwordField.setText(null);    
        }
        
        
    }//GEN-LAST:event_loginButtonActionPerformed

    private void signinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinButtonActionPerformed
        
        SigninFrame signin = new SigninFrame();
        signin.setVisible(true);
        signin.setLocationRelativeTo(null);
        signin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
        
    }//GEN-LAST:event_signinButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton signinButton;
    private javax.swing.JTextField textfieldUsername;
    // End of variables declaration//GEN-END:variables
}
