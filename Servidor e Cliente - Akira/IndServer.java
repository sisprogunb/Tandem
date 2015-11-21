
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IndServer extends Thread {

    private Socket socket;
    
    public IndServer(Socket socket){
        
        this.socket = socket;
        
    }
    
    public void run(){
    
        try {      
            
            ObjectInputStream input = new ObjectInputStream( socket.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream( socket.getOutputStream());   
            
            System.out.println("Stream estabelecido");
            
            String info = (String) input.readObject();
            
            System.out.printf("%s", info);
            
            if (info.equalsIgnoreCase("cadastro")){
            
                User user = (User) input.readObject();
            
                SqlComms sqlConnect = new SqlComms();
                sqlConnect.createUser(user);
            
                System.out.println("Usuário cadastrado");
            }
            
            if (info.equalsIgnoreCase("login")){
                
                String username = (String) input.readObject();
                
                SqlComms sqlConnect = new SqlComms();
                sqlConnect.userExist(username);
                
            }
            
        } catch (IOException ex) {
            Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IndServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
