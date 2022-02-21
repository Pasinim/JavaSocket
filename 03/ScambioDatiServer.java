import java.io.*;
import java.net.*;

public class ScambioDatiServer {
    public static void main(String[] args) {
        Socket toClient;
        ServerSocket sServer;

        int dim_buffer= 100;
        byte[] buffer = new byte[dim_buffer];
        
        try{
            //accetto la connessione del client
            sServer = new ServerSocket(0);
            System.out.println(String.format("Indirizzo %s, porta %d\n", sServer.getInetAddress(), sServer.getLocalPort()));
            toClient = sServer.accept();

            InputStream fromClient = toClient.getInputStream();
            int letti = fromClient.read(buffer);
            System.out.println(String.format("Ricevuta stringa: '%s' di %d byte", new String(buffer, 0, letti), letti ));
        }catch(Exception e){
            e.printStackTrace();
        }
     }
}
