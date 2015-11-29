package tandemplatform;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.ArrayList;
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
                         
                        case "user1" :
                            
                            user1();
                            break;  
                        case "match":
                            match();
                            break;
                    }
          
                }

            } catch (IOException ex) {
                Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    private void match()
    {
        ArrayList <User> userArray = new ArrayList();
        int language = -1;
        User userData = new User();
        int min = -1;
        int max = -1;
        try 
        {
            language = input.readInt();
            userData = (User) input.readObject();
            min = input.readInt();
            max = input.readInt();
            
        } catch (IOException ex) {
            Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        SqlComms sqlConnect = new SqlComms();
        userArray = sqlConnect.searchLanguageUser(language, userData, min, max);

        System.out.println("User signed up");
        
        try {
            output.writeObject(userArray);
            output.flush();
        } catch (IOException ex) {
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
        
        } catch (IOException io){
            Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, io);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int language = natlan.getID();
        int fluency = natlan.getFluency();
        int interest = natlan.getInterest();

        SqlComms sqlConnect = new SqlComms();

        sqlConnect.insertLanguage(user, language, fluency, interest);

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
    
        private void user1(){
        
        try { 
            
            SqlComms sqlConnect = new SqlComms();

            User user2 = sqlConnect.searchByUsername(username);
            
            output.writeObject(user2);
            output.flush();
            
            
            
        } catch(IOException io){
            io.printStackTrace();
        } 
        
    }
    
}
