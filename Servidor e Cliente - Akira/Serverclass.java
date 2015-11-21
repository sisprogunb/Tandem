import java.net.*;
import java.io.*;
import javax.swing.JFrame;

public class Serverclass {
    
    ServerSocket server = null;
    
    public Serverclass(){
    
        try {
            
            this.server = new ServerSocket(12345);
            
            System.out.println("Listening....");
            
        } catch (IOException io){
            io.printStackTrace();
        }
    }
     
    public void runServer(){
        
        System.out.println("oi");
        
        while(true){        
        
            try {
                
                Socket connection = server.accept();  
                IndServer indserver = new IndServer(connection);
                indserver.start();
                
            } catch (IOException io){
                io.printStackTrace();
            }
        }
        
        /*
        InitialFrame o = new InitialFrame();
        o.setLocationRelativeTo(null);
        o.setVisible(true);
        o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        */  
    }
} 


