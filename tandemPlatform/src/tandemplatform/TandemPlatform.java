/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tandemplatform;

import javax.swing.JOptionPane;

/**
 *
 * @author gshimabuko
 */
public class TandemPlatform {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SqlComms sqlConnect = new SqlComms();
        int valida = 0;
        
       
        User user = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        User user5 = new User();
        User user6 = new User();
        
        User userTest = new User();
        
        do
        {
            String usuario = JOptionPane.showInputDialog("Digite seu usuario");
            String pass = JOptionPane.showInputDialog("Digite sua senha");
            valida  = sqlConnect.login(usuario, pass);
        }while (valida!=1);
        
        user.setName("Herp");
        user.setSurname("Derp");
        user.setUsername("HerpDerpy");
        user.setPassword("derpina");
        user.setEmail("herpderp@gmail.com");
        user.setOccupation("derper");
        user.setBirthdate("2015/10/25");
        user.setCOO("Brasil");
        user.setCOR("UK");
        user.setNativeLanguage(1);
        if(sqlConnect.userExist(user.getUsername())==0)
        {
            sqlConnect.createUser(user);
            sqlConnect.insertLanguage(user, 3, 4, 1);
        }
        userTest = user;

        sqlConnect.userExist("Derpina");
        
        user2.setName("Herp2");
        user2.setSurname("Derp2");
        user2.setUsername("HerpDerpy2");
        user2.setPassword("derpina2");
        user2.setEmail("herpder2p@gmail.com");
        user2.setOccupation("derper2");
        user2.setBirthdate("2015/10/25");
        user2.setCOO("Brasil");
        user2.setCOR("UK");
        user2.setNativeLanguage(2);
        if(sqlConnect.userExist(user2.getUsername())==0)
        {
            sqlConnect.createUser(user2);
            sqlConnect.insertLanguage(user2, 1, 4, 1);
        }
        
        user3.setName("Herp3");
        user3.setSurname("Derp3");
        user3.setUsername("HerpDerpy3");
        user3.setPassword("derpina3");
        user3.setEmail("herpderp3@gmail.com");
        user3.setOccupation("derper3");
        user3.setBirthdate("2015/10/25");
        user3.setCOO("Brasil");
        user3.setCOR("UK");
        user3.setNativeLanguage(3);
        if(sqlConnect.userExist(user3.getUsername())==0)
        {
            sqlConnect.createUser(user3);
            sqlConnect.insertLanguage(user3, 2, 3, 1);
        }
        user4.setName("Herp4");
        user4.setSurname("Derp4");
        user4.setUsername("HerpDerpy4");
        user4.setPassword("derpina4");
        user4.setEmail("herpderp4@gmail.com");
        user4.setOccupation("derper4");
        user4.setBirthdate("2015/10/25");
        user4.setCOO("Brasil");
        user4.setCOR("UK");
        user4.setNativeLanguage(3);
        if(sqlConnect.userExist(user4.getUsername())==0)
        {
            sqlConnect.createUser(user4);
            sqlConnect.insertLanguage(user4, 1, 2, 1);
        }
        
        user5.setName("Herp5");
        user5.setSurname("Derp5");
        user5.setUsername("HerpDerpy5");
        user5.setPassword("derpina5");
        user5.setEmail("herpderp5@gmail.com");
        user5.setOccupation("derper5");
        user5.setBirthdate("2015/10/25");
        user5.setCOO("Brasil");
        user5.setCOR("UK");
        user5.setNativeLanguage(3);
        if(sqlConnect.userExist(user5.getUsername())==0)
        {
            sqlConnect.createUser(user5);
            sqlConnect.insertLanguage(user5, 1, 1, 1);
        }
        
        user6.setName("Herp6");
        user6.setSurname("Derp6");
        user6.setUsername("HerpDerpy6");
        user6.setPassword("derpina6");
        user6.setEmail("herpderp@gmail.com");
        user6.setOccupation("derper");
        user6.setBirthdate("2015/10/25");
        user6.setCOO("Brasil");
        user6.setCOR("UK");
        user6.setNativeLanguage(9);
        if(sqlConnect.userExist(user6.getUsername())==0)
        {
            sqlConnect.createUser(user6);
            sqlConnect.insertLanguage(user6, 1, 2, 1);
            sqlConnect.insertLanguage(user6, 3, 4, 1);
        }
        // TODO code application logic here
        sqlConnect.searchLanguageUser(3, userTest, 3, 5);
        
        sqlConnect.updateLanguage(user5, 1, 5, 0);
        user4.setCOR("USA");
        sqlConnect.updateUser(user4);
        sqlConnect.logoff(user);
        sqlConnect.busy(user);
        User userTester = sqlConnect.searchByUsername(user3.getUsername());
        System.out.println("Username: " + userTester.getUsername());
        System.out.println("Name: " + userTester.getName());
        System.out.println("Surname: " + userTester.getSurname());
        System.out.println("Password: " + userTester.getPassword());
        System.out.println("Birthdate: " + userTester.getBirthdate());
        System.out.println("Occupation: " + userTester.getOccupation());
        System.out.println("Email: " + userTester.getEmail());
        System.out.println("Country of Residence: " + userTester.getCOR());
        System.out.println("Country of Origin: " + userTester.getCOO());
    }
    
}
