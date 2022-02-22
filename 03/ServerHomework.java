import java.io.*;
import java.net.*;

public class ServerHomework {
    public static void main(String[] args) {
        Socket toClient;
        ServerSocket sServer;

        int len_buffer = 100;
        byte[] buffer = new byte[len_buffer];
        try{
            //creo connessione
            sServer = new ServerSocket(0);
            System.out.println(String.format("Indirizzo %s, porta: %d", sServer.getInetAddress(), sServer.getLocalPort()));
            toClient = sServer.accept();
            
            //leggo input
            InputStream fromClient = toClient.getInputStream();
            while (true){
                fromClient.read(buffer);
                if (buffer[0] == '.') 
                    break;
                System.out.println(String.format("\t %s", new String(buffer)));

            }
            
            
        }catch(Exception e){
            System.out.println("Errore Server");
            e.printStackTrace();
        }    
    }
}
