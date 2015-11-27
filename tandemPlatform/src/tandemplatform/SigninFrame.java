package tandemplatform;

import javax.swing.JFrame;

public class SigninFrame extends javax.swing.JFrame {

    User user = null;
    
    public SigninFrame() {
        initComponents();
    }

    public User getUser(){
        return user;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textfieldName = new javax.swing.JTextField();
        labelName = new javax.swing.JLabel();
        labelSurname = new javax.swing.JLabel();
        textfieldSurname = new javax.swing.JTextField();
        textfieldUsername = new javax.swing.JTextField();
        labelUsername = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        labelDateBirth = new javax.swing.JLabel();
        labelOccupation = new javax.swing.JLabel();
        textfieldDateBirth = new javax.swing.JTextField();
        comboboxOccupation = new javax.swing.JComboBox();
        submitButton = new javax.swing.JButton();
        labelEmail = new javax.swing.JLabel();
        LabelCOrigin = new javax.swing.JLabel();
        labelCResidence = new javax.swing.JLabel();
        textfieldEmail = new javax.swing.JTextField();
        textfieldCOrigin = new javax.swing.JTextField();
        textfieldCResidence = new javax.swing.JTextField();
        labelMotherLanguage = new javax.swing.JLabel();
        comboboxLanguages = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textfieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textfieldNameActionPerformed(evt);
            }
        });

        labelName.setText("NAME");

        labelSurname.setText("SURNAME");

        labelUsername.setText("USERNAME");

        labelPassword.setText("PASSWORD");

        labelDateBirth.setText("DATE OF BIRTH");

        labelOccupation.setText("OCCUPATION");

        comboboxOccupation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Student", "Unemployed", "Physician", "Lawyer", "Enginner", "Architect", "Others" }));
        comboboxOccupation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxOccupationActionPerformed(evt);
            }
        });

        submitButton.setText("Submit and Next Page");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        labelEmail.setText("E-MAIL ");

        LabelCOrigin.setText("COUNTRY OF ORIGIN");

        labelCResidence.setText("COUNTRY OF RESIDENCE");

        labelMotherLanguage.setText("MOTHER LANGUAGE");

        comboboxLanguages.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Portuguese", "English", "German", "Japanese", "Mandarin", "Korean", "French", "Italian", "Spanish", "Arabic" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelName)
                    .addComponent(labelSurname)
                    .addComponent(labelUsername)
                    .addComponent(labelPassword)
                    .addComponent(labelDateBirth)
                    .addComponent(labelOccupation))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textfieldSurname, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textfieldUsername, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(passwordField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textfieldDateBirth, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textfieldName, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboboxOccupation, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelEmail)
                    .addComponent(LabelCOrigin)
                    .addComponent(labelCResidence)
                    .addComponent(labelMotherLanguage))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textfieldEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textfieldCOrigin, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textfieldCResidence, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboboxLanguages, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(48, 48, 48))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(272, Short.MAX_VALUE)
                .addComponent(submitButton)
                .addGap(242, 242, 242))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelPassword)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textfieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelName)
                            .addComponent(labelEmail)
                            .addComponent(textfieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textfieldSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSurname)
                            .addComponent(LabelCOrigin)
                            .addComponent(textfieldCOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textfieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelUsername)
                            .addComponent(labelCResidence)
                            .addComponent(textfieldCResidence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelMotherLanguage)
                            .addComponent(comboboxLanguages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDateBirth)
                    .addComponent(textfieldDateBirth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelOccupation)
                    .addComponent(comboboxOccupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(submitButton)
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        
        ClientClass clientclass = new ClientClass();
        clientclass.startConnection();
        
        this.user = new User();
        user.setName(textfieldName.getText());
        user.setSurname(textfieldSurname.getText());
        user.setUsername(textfieldUsername.getText());
        user.setPassword(passwordField.getText());
        user.setBirthdate(textfieldDateBirth.getText());
        user.setOccupation((String) comboboxOccupation.getSelectedItem());
        user.setEmail(textfieldEmail.getText());
        user.setCOO(textfieldCOrigin.getText());
        user.setCOR(textfieldCResidence.getText());
        user.setNativeLanguage( (comboboxLanguages.getSelectedIndex() + 1) );
        
        clientclass.sendUser(user);
        
        //clientclass.closeConnection();
        
        
        SigninFrame2 sif2 = new SigninFrame2();
        sif2.setClient(clientclass);
        sif2.setLocationRelativeTo(null);
        sif2.setVisible(true);
        sif2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
        
    }//GEN-LAST:event_submitButtonActionPerformed

    private void comboboxOccupationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxOccupationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxOccupationActionPerformed

    private void textfieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textfieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textfieldNameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelCOrigin;
    private javax.swing.JComboBox comboboxLanguages;
    private javax.swing.JComboBox comboboxOccupation;
    private javax.swing.JLabel labelCResidence;
    private javax.swing.JLabel labelDateBirth;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelMotherLanguage;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelOccupation;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelSurname;
    private javax.swing.JLabel labelUsername;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField textfieldCOrigin;
    private javax.swing.JTextField textfieldCResidence;
    private javax.swing.JTextField textfieldDateBirth;
    private javax.swing.JTextField textfieldEmail;
    private javax.swing.JTextField textfieldName;
    private javax.swing.JTextField textfieldSurname;
    private javax.swing.JTextField textfieldUsername;
    // End of variables declaration//GEN-END:variables
}
