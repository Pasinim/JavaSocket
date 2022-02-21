import java.net.*;

public class SocketClient {
    public static void main(String[] args) {

        /**
         * Creazone socket lato client:
         */
        Socket sClient = new Socket();

        try{
            /**
             * IP address Server
             */
            InetAddress ia =InetAddress.getLocalHost(); 
            /**
             * Indicando come porta la porta #0 il sistema operativo sceglie automaticamente
             * la port a da utilizzare, tuttavia non è la scelta ottimale per il server
             * Socket Address Server:
             */
            InetSocketAddress isa = new InetSocketAddress(ia, 57472); //57461 porta stampata in SocketServer da sServer.getLocalPort();
            sClient.bind(isa);
            System.out.println(String.format("Porta locale: %d, indirizzo: %s, porta: %d", sClient.getLocalPort(), sClient.getInetAddress(), sClient.getPort()));
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
