import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.*;

public class ServerDatagram {
    public static void main(String[] args) {
        DatagramSocket sServer;
        byte[] buffer = new byte[100];
        try {
            sServer = new DatagramSocket();
            System.out.println(String.format(
                "Indirizzo: %s, porta: %d", sServer.getLocalAddress(), sServer.getLocalPort()));            
            DatagramPacket dpin = new DatagramPacket(buffer, buffer.length);
            sServer.receive(dpin);

            String str = new String(buffer, 0, dpin.getLength());
            System.out.println("Ricevuto messaggio: " + str.toString());
            InetAddress ia = dpin.getAddress();
            int porta = dpin.getPort();
            System.out.println(String.format(
                    "Indirizzo %s, porta %d", ia.getHostAddress(), porta));
            sServer.close(); 
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
