import java.net.*;
/**
 * Per fare comunicare il client è ovviamente necessario avviare due cmd: uno per il server,
 * e quando ho ricvevuto il numero della porta, uno per il client
 */

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
            InetSocketAddress isa = new InetSocketAddress(ia, Integer.parseInt(args[0])); //57461 porta stampata in SocketServer da sServer.getLocalPort();
            sClient.connect(isa);
            System.out.println(String.format("Porta locale: %d, indirizzo: %s, porta: %d", sClient.getLocalPort(), sClient.getInetAddress(), sClient.getPort()));
            sClient.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        /**
         * NB: getInetAddress su serverSocket mostra l'indirizzo locale
         *                    su Socket mostra l'indirizzo remoto
         */
        
    }
}
