package tandemplatform;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Serverclass {
    
    private ServerSocket server = null;
    public ArrayList <ObjectInputStream> clientinputstream = new ArrayList();
    public ArrayList <ObjectOutputStream> clientoutputstream = new ArrayList();
    
    public Serverclass(){
        InetAddress ip;
        String hostname;
    
        try {
            
            this.server = new ServerSocket(12345);
            
            System.out.println("Listening....");
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("IP: " + ip.getHostAddress());
            System.out.println("Hostname: " + hostname);
            
        } catch (IOException io){
            io.printStackTrace();
        }
    }
     
    public void runServer(){
        
        while(true){        
        
            try {
                
                Socket connection = server.accept();  
                
                IndServer indserver = new IndServer(connection);
                indserver.start();

                //clientinputstream.add( new ObjectInputStream( connection.getInputStream() ) );
                //clientoutputstream.add( new ObjectOutputStream( connection.getOutputStream() ) );
                
                
            } catch (IOException io){
                io.printStackTrace();
            }
        } 
    }
} 


