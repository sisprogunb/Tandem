/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tandemplatform;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

/**
 *
 * @author gshimabuko
 */
public class LangFrame extends javax.swing.JFrame {

    User user = new User();
    Language language = new Language();
    ArrayList <Language> langList = new ArrayList();
    String[] Fluency;
    String[] interest;
    String[] Native;
    String[] langName;
    int ArraySize;
    String[] columnNames = {"Language Name", "Fluency", "Interest", "Native"};
    String[][] data;
    private JButton jButton1;
    /**
     * Creates new form LanguagesFrame
     */
    public LangFrame(User user) 
    {
        this.user = user;
        langList = user.getLanguages();
        ArraySize = langList.size();
        langName = new String[ArraySize];
        data = new String[ArraySize][4];
        Fluency = new String[ArraySize];
        interest = new String[ArraySize];
        Native = new String[ArraySize];
        System.out.println("Array Size: "+ ArraySize);
        for(int i = 0; i<ArraySize; i++)
        {
            System.out.println("Linha: " + i);
            language = langList.get(i);
            data[i][0]= language.getName();
            data[i][1] = Integer.toString(language.getFluency());
            data[i][2] = Integer.toString(language.getInterest());
            data[i][3] = Integer.toString(language.getNativity());
        }
        initComponents();
        
    }

    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(data, columnNames);
        jTable1.setSelectionMode(SINGLE_SELECTION);
        jTable1.setAutoResizeMode(AUTO_RESIZE_ALL_COLUMNS);
        

        

        jLabel1.setText(user.getUsername());
        jButton1.setText("Update Language");
        jScrollPane1.setViewportView(jTable1);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt, jTable1.getSelectedRow());
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        

        pack();
    }// </editor-fold>                        
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt, int selectedRow) { 
        System.out.println("Selected Row: " + selectedRow);
        
        UpdateLanguageFrame updateLanguageFrame = new UpdateLanguageFrame(langList.get(selectedRow), user);
        this.setVisible(false);
        updateLanguageFrame.setVisible(true);
        updateLanguageFrame.setLocationRelativeTo(null);
        updateLanguageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   

   

    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration                   
}
