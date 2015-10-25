/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tandemplatform;

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
        User user = new User();
        
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
        sqlConnect.createUser(user);
        // TODO code application logic here
    }
    
}
