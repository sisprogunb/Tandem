package tandemplatform;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class SigninFrame2 extends javax.swing.JFrame {

    public SigninFrame2() {
        initComponents();
    }
    
     public void setClient(ClientClass clientclass){
        this.clientclass = clientclass;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cboxlanguage = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cboxinterest = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cboxfluency = new javax.swing.JComboBox();
        button_sendadd = new javax.swing.JButton();
        button_send = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Choose your language: ");

        cboxlanguage.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Portuguese", "English", "German", "Japanese", "Mandarin", "Korean", "French", "Italian", "Spanish", "Arabic" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Choose one of the options below:");

        cboxinterest.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "I'd like to teach the selected language", "I'd like to learn the selected language" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Choose your fluency level:");

        cboxfluency.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0 - not fluent", "1", "2", "3", "4", "5 - fluent" }));

        button_sendadd.setText("submit & add more");
        button_sendadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_sendaddActionPerformed(evt);
            }
        });

        button_send.setText("submit");
        button_send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_sendActionPerformed(evt);
            }
        });

        jMenu2.setText("Help");

        jMenuItem1.setText("About");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboxlanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(75, 75, 75))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cboxfluency, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_sendadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cboxinterest, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(211, 211, 211))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cboxlanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_sendadd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboxinterest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_send, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboxfluency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void button_sendaddActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
        Language language = new Language();
        
        language.setID( ( cboxlanguage.getSelectedIndex() + 1 ) );
        language.setFluency( cboxfluency.getSelectedIndex() );
        language.setInterest( cboxinterest.getSelectedIndex());
        language.setNativity(0);

     
        clientclass.sendLanguages(language);
        
        cboxlanguage.setSelectedItem(null);
        cboxinterest.setSelectedItem(null);
        cboxfluency.setSelectedItem(null);
        
    }                                              

    private void button_sendActionPerformed(java.awt.event.ActionEvent evt) {                                            
        
        Language language = new Language();
        
        language.setID( ( cboxlanguage.getSelectedIndex() + 1 ) );
        language.setFluency( cboxfluency.getSelectedIndex() );
        language.setInterest( cboxinterest.getSelectedIndex() );
        language.setNativity(0);

     
        clientclass.sendLanguages(language);
        
        this.setVisible(false);
        InitialPanel o = new InitialPanel();
        o.setLocationRelativeTo(null);
        o.setVisible(true);
        o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }                                           

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        JFrame f = new JFrame("ABOUT");
        JPanel p = new JPanel(new BorderLayout());
        JTextArea a = new JTextArea();
        a.append("Projeto de Sistemas de Programação \n" +
                "Alunos: Daniel Ando e Marcos Guo \n" +
                "Plataforma de Aprendizagem de Idiomas TANDEM");
        a.setEditable(false);
        p.add(a);
        f.setContentPane(p);
        f.setVisible(true);
        f.setSize(400, 100);
        f.setLocationRelativeTo(null);
        
    }                                          

    private ClientClass clientclass = null;
    // Variables declaration - do not modify                     
    private javax.swing.JButton button_send;
    private javax.swing.JButton button_sendadd;
    private javax.swing.JComboBox cboxfluency;
    private javax.swing.JComboBox cboxinterest;
    private javax.swing.JComboBox cboxlanguage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration                   
}
