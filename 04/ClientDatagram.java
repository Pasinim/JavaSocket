import java.net.DatagramPacket;
import java.net.*;
import java.util.Scanner;

/**
 * È anche possibile evitare di creare due classi diverse (ServerSocket per il server)
 * e Socket per il client. È invece possibile utilizzare la classe DatagramSocket per
 * specificarfe una porta well known. 
 */
public class ClientDatagram {
    public static void main(String[] args) {
        try{
            DatagramSocket sClient = new DatagramSocket();


            InetSocketAddress isa = new InetSocketAddress("localhost", Integer.parseInt(args[0]));
            Scanner scan = new Scanner(System.in);
            String line = scan.nextLine();
            byte[] buffer = line.getBytes();
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            dp.setSocketAddress(isa);
            sClient.send(dp);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
