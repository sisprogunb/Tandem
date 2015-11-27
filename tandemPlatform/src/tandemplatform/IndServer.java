package tandemplatform;

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
    private User user = new User();
    private Language natlan, intlan;
    private String username;
    private String password;
    private String info;
    private String uname;
    
    public IndServer(Socket socket){
        
        this.socket = socket;
        
    }
    
    public void run(){    
            
        try {
            
            input = new ObjectInputStream( socket.getInputStream() );
            output = new ObjectOutputStream( socket.getOutputStream() );
            
        } catch (IOException ex) {
            Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Stream established");
            
            try {
                
                while (true) {
                    
                             
                    info = (String) input.readObject();                
                    
                    switch (info){
                        
                        case "cadastro1" :
                            
                            user = cadastro1();
                            System.out.println(user.getUsername());
                            break;
                            
                        case "cadastro2" :
                            
                            System.out.println(user.getUsername());
                            cadastro2(user);
                            break;
                            
                        case "login1" :
                            
                            login1();
                            break;
                            
                        case "login2" :
                            
                            login2();
                            break;
                            
                    }
          
                }

            } catch (IOException ex) {
                Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    
    private User cadastro1(){
        
        try {
            
            user = (User) input.readObject();
            
        } catch (IOException ex) {
            Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        SqlComms sqlConnect = new SqlComms();
        sqlConnect.createUser(user);

        System.out.println("User signed up");
        
        return user;
    }
    
    private void cadastro2(User user){
        
        try {
            
            natlan = (Language) input.readObject();
            intlan = (Language) input.readObject();
        
        } catch (IOException io){
            Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, io);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int language1 = natlan.getID();
        int fluency1 = natlan.getFluency();
        int language2 = intlan.getID();
        int fluency2 = intlan.getFluency();

        SqlComms sqlConnect = new SqlComms();

        sqlConnect.insertLanguage(user, language1, fluency1, 0);
        sqlConnect.insertLanguage(user, language2, fluency2, 1);

        System.out.println("Languages received");
       
    }
    
    private void login1(){
        
        try {
            
            username = (String) input.readObject();

            SqlComms sqlConnect = new SqlComms();

            if (sqlConnect.userExist(username) == 1){
                
                output.writeBoolean(true);
                output.flush();
                
            } else{
                
                output.writeBoolean(false);
                output.flush();
                
            }
            
        } catch(IOException io){
            io.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void login2(){
        
        try { 
            
            password = (String) input.readObject();

            SqlComms sqlConnect = new SqlComms();

            if ( sqlConnect.login(username, password) == 1 ){
                
                output.writeBoolean(true);
                output.flush();
                
            } else {
                
                output.writeBoolean(false);
                output.flush();
           
            }
            
        } catch(IOException io){
            io.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void setUsername(String username){
        this.uname = username;
    }
    
}