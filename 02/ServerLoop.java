import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerLoop {
    public static void main(String[] args) {
        
        byte[] buffer = new byte[100];

        try{
            ServerSocket ss = new ServerSocket(0);
            System.out.println("" + ss.getInetAddress() + ss.getLocalPort());
            Socket toClient = ss.accept();
            boolean x = true;
            while(true){
                InputStream fromClient = toClient.getInputStream();
                fromClient.read(buffer);
                System.out.println("Messaggio ricevuto: " + new String(buffer));
                if (new String(buffer).trim().equals(".")) break;
                buffer = new byte[100];
            }
            ss.close();
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
