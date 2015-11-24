
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IndServer extends Thread {

    private Socket socket;
    private ObjectInputStream input = null;
    private ObjectOutputStream output = null;
    private User user;
    private UserLanguages userlan;
    private String username;
    private String password;
    private String info;
    private int userid;
    
    public IndServer(Socket socket){
        
        this.socket = socket;
        
    }
    
    public void run(){    
            
        try {
            
            this.input = new ObjectInputStream( socket.getInputStream());
            this.output = new ObjectOutputStream( socket.getOutputStream());
            
        } catch (IOException ex) {
            Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Stream established");
        
        //while ( true ) {
            
            try {
                
                while (true) {
                
                    System.out.println("you are here");
                    this.info = (String) input.readObject();
                    System.out.println("you are here now");
                    //System.out.println("UserID : " + userid);
                    //System.out.println("UserID : " + user.getidUser());
                    this.chooseOperation(info);
                    System.out.println("you are now here");
                    //System.out.println("UserID : " + userid);
            
                }

            } catch (IOException ex) {
                Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        //}
    }
    
    private void chooseOperation(String info) {

        

        try{
            
            System.out.println("you reached here");

            if (info.equalsIgnoreCase("cadastro1")){

                System.out.println("1st if");
                this.user = (User) input.readObject();

                SqlComms sqlConnect = new SqlComms();
                sqlConnect.createUser(user);
                
                this.userid = sqlConnect.searchUserID(user.getUsername());
                user.setidUser(userid);

                System.out.println("User signed up");
                System.out.println("UserID : " + userid);
            }

            if (info.equalsIgnoreCase("cadastro2")){

                System.out.println("2nd if");
                //this.user = (User) input.readObject();
                //System.out.println(user.getidUser());
                this.userlan = (UserLanguages) input.readObject();

                int language1 = userlan.getLanguage1();
                int language2 = userlan.getLanguage2();
                int fluencylevel1 = userlan.getFluencyLevel1();
                int fluencylevel2 = userlan.getFluencyLevel2();

                System.out.println("UserID language : " + userid);
                System.out.println("UserID : " + user.getidUser());
                SqlComms sqlConnect = new SqlComms();
                //sqlConnect.createUser(user);
                //this.userid = sqlConnect.searchUserID(user.getUsername());
                //user.setidUser(userid);
                sqlConnect.insertLanguage(user, language1, fluencylevel1, 0);
                sqlConnect.insertLanguage(user, language2, fluencylevel2, 1);

                System.out.println("Languages received");

            }

            if (info.equalsIgnoreCase("login1")){

                this.username = (String) input.readObject();

                SqlComms sqlConnect = new SqlComms();

                if (sqlConnect.userExist(username) == 1){
                    output.writeBoolean(true);
                    output.flush();
                } else{
                    output.writeBoolean(false);
                    output.flush();
                }
            }

            if (info.equalsIgnoreCase("login2")){

                this.password = (String) input.readObject();

                SqlComms sqlConnect = new SqlComms();

                if ( sqlConnect.login(username, password) == 1 ){
                    output.writeBoolean(true);
                    output.flush();
                } else {
                    output.writeBoolean(false);
                    output.flush();
               }
            }
        
        } catch (IOException ex) {
            Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
