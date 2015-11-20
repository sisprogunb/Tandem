import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) throws IOException {
        /* 
        if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }
 
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        */ 
                
        try (
            Socket serversocket = new Socket("localhost", 4444);
            PrintWriter out = new PrintWriter(serversocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(serversocket.getInputStream()));
        ) {
            BufferedReader stdIn =
                new BufferedReader(new InputStreamReader(System.in));
            String fromUser;
            
            System.out.println("Digite o primeiro número: ");
            fromUser = stdIn.readLine();
            out.println(fromUser);
            System.out.println("Digite o segundo número: ");
            fromUser = stdIn.readLine();
            out.println(fromUser);
            
            double media = Double.parseDouble(in.readLine());
            
           System.out.printf("A media é: %.2f", media);
            
            
         } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + "localhost");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                "localhost");
            System.exit(1);
        }    
    
}
}
