import java.io.*;
import java.net.*;

public class ScambioDatiServer {
    public static void main(String[] args) {
        int dim_buffer= 100;
        byte[] buffer = new byte[dim_buffer];
        try{
            InputStream fromClient = toClient.getInputStream();
            int letti = fromClient.read(buffer);
            System.out.println(String.format("Ricevuta stringa: '%s' di %d byte", new String(buffer, 0, letti), letti ));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
