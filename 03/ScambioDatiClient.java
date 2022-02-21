import java.util.*;
import java.io.*;
import java.net.*;
/**
 * Ora è necessario scambiare i dati. Per fare ciò è necessario
 * tradurre i dati ricevuti nel formato appropriato a seconda sia BigEndian 
 * o LittleEndian. 
 * Quando viene realizzato l'unmarshalling è necessario avere accesso all'oggetto
 * (quindi al file .class) in modo da tradurre i dati ricevuti (?)
 * 
 */

 public class ScambioDatiClient{
     public static void main(String[] args) {

        Socket sClient = new Socket();
        /**
         * Per leggere i dati provenienti dalla socket si utilizza
         * InputStream Socket.getInputStream();
         */
        try{
            //Mi connetto al server
            InetAddress ia = InetAddress.getLocalHost();
            InetSocketAddress isa = new InetSocketAddress(ia, 65435);
            sClient.connect(isa);

            //leggo l'input da stdin
            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(input);
            String line = br.readLine();
            System.out.println(String.format("Sto mandando il messaggio %s...", line));

            /**
             * Mando l'input al server
             * La funzione write(byte[], offset, len) passa i dati a livello Transport (NON AL CANALE)
             */
            OutputStream toServer = sClient.getOutputStream();
            toServer.write(line.getBytes(), 0, line.length()); 
            
            sClient.close();
        }catch(Exception e){
            e.printStackTrace();
        }

     }
 }