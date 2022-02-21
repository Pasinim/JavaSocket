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
            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(input);
            String line = br.readLine();
            System.out.println(String.format("Sto mandando il messaggio %s...", line));

            OutputStream toServer = sClient.getOutputStream();
            /**
             * La funzione write(byte[], offset, len) passa i dati a livello Transport (NON AL CANALE)
             */
            toServer.write(line.getBytes(), 0, line.length());             
        }catch(Exception e){
            e.printStackTrace();
        }

     }
 }