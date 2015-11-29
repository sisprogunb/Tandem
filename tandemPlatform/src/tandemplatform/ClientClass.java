package tandemplatform;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class ClientClass {

    private Socket connection = null;
    private ObjectOutputStream output = null;
    private ObjectInputStream input = null;
    private final String servername = "localhost";
    private boolean control = false;
    
    public void startConnection() {
        
        try {
            
            this.connection = new Socket(servername, 12345);
            this.output = new ObjectOutputStream( connection.getOutputStream());
            output.flush();
            this.input = new ObjectInputStream( connection.getInputStream());
            
            System.out.println("Connection succeded");
            
        } catch (IOException io){
            io.printStackTrace();
        }
    }
    
    public void sendUser(User user){
        
        try {
            
            String string = "cadastro1";
            output.writeObject(string);
            output.flush();
            
            output.writeObject(user);
            output.flush();
            System.out.println("Sended.");
        
        } catch (IOException ex) {
            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public User receiveUser() {
        
        User userx = null;
        
        try {
            
    
            userx = (User) input.readObject();
            System.out.println("user received");
        
        } catch (IOException ex) {
            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        return userx;
    }
    
    public void sendMatch(int Language, User user, int min, int max)
    {
        
        try {
            
            String string = "match";
            output.writeObject(string);
            output.flush();
            output.writeInt(Language);
            output.flush();
            output.writeObject(user);
            output.flush();
            output.writeInt(min);
            output.flush();
            output.writeInt(max);
            output.flush();
            
            System.out.println("Sent");
        
        } catch (IOException ex) {
            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public ArrayList<User> receiveMatch() {
        
        ArrayList<User> userArray = new ArrayList();
        
        try {
            
    
            userArray = (ArrayList <User>) input.readObject();
            System.out.println("user received");
        
        } catch (IOException ex) {
            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
        }    
        
        return userArray;
    }
    
    public void controlReceiveUser() {
        try {
            String receive = "user1";
            output.writeObject(receive);
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendLanguages(Language natlan, Language intlan){
        
        try {
            
            String string = "cadastro2";
            output.writeObject(string);
            output.flush();

            output.writeObject(natlan);
            output.flush();
            output.writeObject(intlan);
            output.flush();
            System.out.println("Sended.");
            
        } catch (IOException ex) {
            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    public void sendUsername(String string){
        
        try {
            
            String info = "login1";
            output.writeObject(info);
            output.flush();
            
            output.writeObject(string);
            output.flush();
            System.out.println("Sended.");
        
        } catch (IOException ex) {
            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public void sendPassword(String string){
        
        try {
            
            String info = "login2";
            output.writeObject(info);
            output.flush();
            
            output.writeObject(string);
            output.flush();
            System.out.println("Sended.");
        
        } catch (IOException ex) {
            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public void sendMessage(String message){
        
        try {
            
            output.writeObject(message);
            output.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public String receiveMessage(){
        
        String message = null;
        
        try {
            
            message = (String) input.readObject();
                        
        } catch (IOException ex) {
            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return message;
    }
    
    public boolean receiveData(){
        
        try {
            control = input.readBoolean();
        } catch (IOException ex) {
            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (control) return true;
                else return false;
    }
    
    public void closeConnection(){
        
        try {
            connection.close();
            System.out.println("Connection terminated");
        } catch (IOException ex) {
            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
