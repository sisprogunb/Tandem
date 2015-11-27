package tandemplatform;

import javax.swing.JFrame;

public class SigninFrame2 extends javax.swing.JFrame {

    private User user = null;
    private ClientClass clientclass = null;
    
    public SigninFrame2() {
        initComponents();
    }
    
    public void setClient(ClientClass clientclass){
        this.clientclass = clientclass;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cboxflulanguage = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboxintlanguage = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fluencylevel1 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        fluencylevel2 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        buttonaddlang = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        buttonsubmit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("ADD LANGUAGE YOU HAVE FLUENCY");

        jLabel2.setText("ADD LANGUAGUE YOU WOULD LIKE TO LEARN");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        cboxflulanguage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Portuguese", "English", "German", "Japanese", "Mandarin", "Korean", "French", "Italian", "Spanish", "Arabic" }));

        jLabel3.setText("LANGUAGE");

        jLabel4.setText("LANGUAGE");

        cboxintlanguage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Portuguese", "English", "German", "Japanese", "Mandarin", "Korean", "French", "Italian", "Spanish", "Arabic" }));

        jLabel5.setText("FROM 0 TO 5, 5 BEING FLUENT LEVEL, CHOOSE");

        jLabel6.setText("A CORRESPONDING NUMBER:");

        fluencylevel1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0 - not fluent", "1", "2", "3 - intermediate", "4", "5 - fluent" }));

        jLabel7.setText("A CORRESPONDING NUMBER:");

        fluencylevel2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0 - not fluent", "1", "2", "3 - intermediate", "4", "5 - fluent" }));

        jLabel8.setText("FROM 0 TO 5, 5 BEING FLUENT LEVEL, CHOOSE");

        jLabel9.setText("SEND AND ADD MORE LANGUAGUES");

        buttonaddlang.setText("SEND & ADD");
        buttonaddlang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonaddlangActionPerformed(evt);
            }
        });

        jLabel11.setText("IF YOU ALREADY WANT TO SUBMIT, ");

        buttonsubmit.setText("CLICK HERE");
        buttonsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonsubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(47, 47, 47)
                                    .addComponent(cboxflulanguage, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(78, 78, 78)
                                .addComponent(buttonaddlang))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(fluencylevel1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(73, 73, 73)
                                        .addComponent(cboxintlanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel11)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(fluencylevel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonsubmit)
                        .addGap(181, 181, 181))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cboxflulanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(cboxintlanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(fluencylevel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(fluencylevel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonaddlang)
                        .addComponent(buttonsubmit)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonaddlangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonaddlangActionPerformed
        
        //ClientClass clientclass = new ClientClass();
        //clientclass.startConnection();
        
        Language natlan = new Language();
        Language intlan = new Language();
        
        natlan.setID((cboxflulanguage.getSelectedIndex() + 1) );
        natlan.setFluency( fluencylevel1.getSelectedIndex() );
        natlan.setInterest(0);
        natlan.setNativity(0);
        
        intlan.setID((cboxintlanguage.getSelectedIndex() + 1) );
        intlan.setFluency( fluencylevel2.getSelectedIndex() );
        intlan.setInterest(1);
        intlan.setNativity(0);
     
        clientclass.sendLanguages(natlan, intlan);
        
        //clientclass.closeConnection();
        
        cboxflulanguage.setSelectedItem(null);
        cboxintlanguage.setSelectedItem(null);
        fluencylevel1.setSelectedItem(null);
        fluencylevel2.setSelectedItem(null);
        
        
    }//GEN-LAST:event_buttonaddlangActionPerformed

    private void buttonsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonsubmitActionPerformed
        
        //ClientClass clientclass = new ClientClass();
        //clientclass.startConnection();
        
        Language natlan = new Language();
        Language intlan = new Language();
        
        natlan.setID((cboxflulanguage.getSelectedIndex() + 1) );
        natlan.setFluency( fluencylevel1.getSelectedIndex() );
        natlan.setInterest(0);
        natlan.setNativity(0);
     
        intlan.setID((cboxintlanguage.getSelectedIndex() + 1) );
        intlan.setFluency( fluencylevel2.getSelectedIndex() );
        intlan.setInterest(1);
        intlan.setNativity(0);
     
        clientclass.sendLanguages(natlan, intlan);
        
        clientclass.closeConnection();
        
        this.setVisible(false);
        InitialPanel o = new InitialPanel();
        o.setLocationRelativeTo(null);
        o.setVisible(true);
        o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }//GEN-LAST:event_buttonsubmitActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonaddlang;
    private javax.swing.JButton buttonsubmit;
    private javax.swing.JComboBox cboxflulanguage;
    private javax.swing.JComboBox cboxintlanguage;
    private javax.swing.JComboBox fluencylevel1;
    private javax.swing.JComboBox fluencylevel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
