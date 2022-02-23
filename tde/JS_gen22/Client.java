import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        int port = 7000;
        Socket sClient;
        InetSocketAddress isa;
        InetAddress ia;

        if(args.length<1) throw new IllegalArgumentException();
        
        port = Integer.parseInt(args[0]);
        sClient= new Socket();

        try {
            isa = new InetSocketAddress(InetAddress.getLocalHost(), port);
            sClient.connect(isa);

            int dim_buffer = 100;
            byte[] buffer = new byte[dim_buffer];

            int letti=0;

            String msgOut="";
            String msgIn="";
            byte[] b_msg;

            InputStreamReader tastiera = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(tastiera); 

            InputStream fromSrv = sClient.getInputStream();
            OutputStream toSrv = sClient.getOutputStream();

            while(true){

                //invio al serve un msg contentente il simbolo dell'operazione finche non ho viene validata
                do{
                    //Invio il simbolo
                    System.out.println("Inserisci simbolo per eseguire un operazione(*, -, +, /) oppure . per terminare :");
                    msgOut=br.readLine().trim();
                    b_msg = msgOut.getBytes();
                    toSrv.write(b_msg, 0, b_msg.length);

                    if(msgOut.equals(".")) break;

                    //Ricevo un feedback dal server
                    letti = fromSrv.read(buffer);
                    msgIn = new String(buffer, 0, letti);
                    System.out.println(msgIn);


                }while(!msgIn.equals("Y"));

                if(msgOut.equals(".")) break;


                //invio al serve un msg contentente il primo operando
                do{
                    //Invio il simbolo
                    System.out.println("Inserisci il primo operando:");
                    msgOut=br.readLine().trim();
                    b_msg = msgOut.getBytes();
                    toSrv.write(b_msg, 0, b_msg.length);

                    //Ricevo un feedback dal server
                    letti = fromSrv.read(buffer);
                    msgIn = new String(buffer, 0, letti);
                    System.out.println(msgIn);


                }while(!msgIn.equals("Y"));

               

                //invio al serve un msg contentente il secondo operando
                do{
                    //Invio il simbolo
                    System.out.println("Inserisci il secondo operando:");
                    msgOut=br.readLine().trim();
                    b_msg = msgOut.getBytes();
                    toSrv.write(b_msg, 0, b_msg.length);

                    //Ricevo un feedback dal server
                    letti = fromSrv.read(buffer);
                    msgIn = new String(buffer, 0, letti);
                    System.out.println(msgIn);

                


                }while(!msgIn.equals("Y"));

                //Ricevo il risultato dell'operazione
                letti = fromSrv.read(buffer);
                msgIn = new String(buffer, 0, letti);
                System.out.println("Risultato: " + msgIn);
            }
            sClient.close();




            
        } catch (Exception e) {
            //TODO: handle exception
        }

    }
    
}
