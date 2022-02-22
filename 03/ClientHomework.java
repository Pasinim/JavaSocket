import java.io.*;
import java.net.*;
import java.util.*;

public class ClientHomework {
    public static void main(String[] args) {
        try{
            //mi connetto al server
            Socket sClient = new Socket();
            InetAddress ia = InetAddress.getLocalHost();
            /**
             * Così facendo devo avviare il server, avviare il client (this) e inserire da
             * terminale la porta del server.
             */
            InetSocketAddress isa = new InetSocketAddress(ia, Integer.parseInt(args[0]));
            sClient.connect(isa);

            // InputStreamReader input = new InputStreamReader(System.in);
            // BufferedReader br = new BufferedReader(input);

            Scanner input = new Scanner(System.in);
            while (input.next() != "."){
                String line = input.nextLine();
                System.out.println(String.format("Sto mandando il messaggio %s...", line));

                //mando il messaggio al server
                OutputStream toServer = sClient.getOutputStream();
                toServer.write(line.getBytes());

              
            }
            input.close();
            sClient.close();

            


        }catch(Exception e ){
            e.printStackTrace();
        }

    }

    
}
