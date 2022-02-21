import java.net.*;

/**
 * Creazione di una connessione lato server
 */

 public class SocketServer{
     public static void main(String[] args) {
         try{
             ServerSocket sServer = new ServerSocket(0);

             /**
              * getInetAddress() permette di visualizzare l'indirizzo di trasporto
              * locale associato alla socket.
              */
             System.out.println(String.format("Indirizzo %s, porta %d\n", sServer.getInetAddress(), sServer.getLocalPort()));

             Socket toClient = sServer.accept();
             /**
              * getPort() permette di visualizzare l'indirizzo di trasporto del client
              */
             System.out.println(String.format("Indirizzo client: %s, porta %d\n", toClient.getPort(), sServer.getLocalPort()));

             Thread.sleep(1000);

         }catch(Exception e){
             e.printStackTrace();
         }
     }
 }
