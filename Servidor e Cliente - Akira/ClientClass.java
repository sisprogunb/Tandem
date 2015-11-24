import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class ClientClass {

    private Socket connection = null;
    private ObjectOutputStream output = null;
    private ObjectInputStream input = null;
    private final String servername = "localhost";
    private boolean control = false;
    
    public void startConnection(){
        
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
    
    public void sendLanguages(UserLanguages userlan){
        
        try {
            
            String string = "cadastro2";
            output.writeObject(string);
            output.flush();

            //output.writeObject(user);
            //output.flush();
            output.writeObject(userlan);
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
