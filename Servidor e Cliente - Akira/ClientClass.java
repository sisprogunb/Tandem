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
            
            String string = "cadastro";
            output.writeObject(string);
            output.flush();
            
            output.writeObject(user);
            output.flush();
            System.out.println("Sended.");
        
        } catch (IOException ex) {
            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
        public void sendData(String string){
        
        try {
            
            String info = "login";
            output.writeObject(string);
            output.flush();
            
            output.writeObject(string);
            output.flush();
            System.out.println("Sended.");
        
        } catch (IOException ex) {
            Logger.getLogger(ClientClass.class.getName()).log(Level.SEVERE, null, ex);
        }    
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