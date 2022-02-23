import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.net.Socket;

import javax.swing.InputMap;

public class ClientLoop {
    public static void main(String[] args) {
        try{
            Socket sc = new Socket();
            InetAddress ia = sc.getLocalAddress();
            InetSocketAddress isa = new InetSocketAddress(ia, Integer.parseInt(args[0]));
            sc.connect(isa);
            boolean x = true;
            while(x){
                InputStreamReader input = new InputStreamReader(System.in);
                BufferedReader br = new BufferedReader(input);
                String line = br.readLine();
                System.out.println("mando il  messaggio " + line.toString());
                
                
                OutputStream toServer = sc.getOutputStream();
                toServer.write(line.getBytes());
            }
            sc.close();        
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
