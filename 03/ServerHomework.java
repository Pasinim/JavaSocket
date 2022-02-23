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
            System.out.println("Connessione accettata");
            
            //leggo input
            InputStream fromClient = toClient.getInputStream();
            
            //ciclo molto brutto ma mi serve per testare
            boolean x = true;
            while(x){
                fromClient.read(buffer);
                if (new String(buffer).trim().equals("."))
                    	break;
                System.out.println(String.format("\t %s", new String(buffer)));
                buffer = new byte[len_buffer];
            }
            
            
        }catch(Exception e){
            System.out.println("Errore Server");
            e.printStackTrace();
        }    
    }
}
