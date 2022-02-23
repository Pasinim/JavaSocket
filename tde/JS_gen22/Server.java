import java.io.*;
import java.net.*;
import java.util.*;

public class LeoServer{

    public static void main(String[] args) {
        ServerSocket sSrv;
        Socket toClient;
        int conn=0;

        List<Socket> clients = new ArrayList<>();
          
        
        toClient = new Socket();
        try{
            sSrv = new ServerSocket(0);
            System.out.println("Porta: " + sSrv.getLocalPort());

            while(true){
                try {
                    sSrv.setSoTimeout(1000*5);
                    while(conn<4){
                        
                        toClient = sSrv.accept();
                        if(toClient!=null) System.out.println("Nuovo client!\nAddress: "+toClient.getInetAddress() +"\nTot Client: " + (conn+1));
                        clients.add(toClient);
                        conn++;
                    }
                } catch (SocketException se) {
                    System.out.println("Errore di connessione");
                    se.printStackTrace();
                
                }catch(SocketTimeoutException ste){
                    System.out.println("TimeoutExpired!");
                }
                catch(IOException ioe){
                    ioe.printStackTrace();
                }

                int dim_buffer = 100;
                byte[] buffer = new byte[dim_buffer];

                int i=0;
                int letti = 0;

                String msgIn;
                String msgOut;
                byte[] b_msg;



                while(conn>0){
                    try{  
                        toClient = clients.get(i);
                        System.out.println((i+1)+"-Connesisone al client: " + toClient.getInetAddress());

                        InputStream fromClt = toClient.getInputStream();
                        OutputStream toClt = toClient.getOutputStream();

                        while(true){
                            char opt='o';
                            while(true){
                                //Ricevo simbolo operazione
                                letti = fromClt.read(buffer);
                                msgIn = new String(buffer,0,letti);
                                System.out.println(msgIn);
                                
                                
                        
                                //Invio al client un riscontro sull'operazione chiesta
                                if(msgIn.equals(".")) break;
                                else if( !(msgIn.equals("*") || msgIn.equals("+") || msgIn.equals("-") || msgIn.equals("/")) ) msgOut="N";
                                else msgOut="Y";

                                b_msg = msgOut.getBytes();
                                toClt.write(b_msg,0,b_msg.length);

                                if(msgOut.equals("Y")) {
                                    opt = msgIn.charAt(0);
                                    break;
                                }
                            };

                           
                            if(msgIn.equals(".")) break;

                            Double op1 = 0.0;
                            Double op2 = 0.0;

                            while(true){
                                //Attendo l'operando 1 dal client
                                letti = fromClt.read(buffer);
                                msgIn = new String(buffer,0,letti);
                                System.out.println(msgIn);

                                try {
                                    op1 = Double.parseDouble(msgIn);
                                    //Se l'operando é valido
                                    msgOut="Y";
                                    b_msg = msgOut.getBytes();
                                    toClt.write(b_msg,0,b_msg.length);
                                    break;
                                    
                                } catch (NumberFormatException ne) {
                                    //Se l'operando non é valido
                                    msgOut="N";
                                    b_msg = msgOut.getBytes();
                                    toClt.write(b_msg,0,b_msg.length);
                                }
                            }

                            while(true){
                                //Attendo l'operando 2 dal client
                                letti = fromClt.read(buffer);
                                msgIn = new String(buffer,0,letti);
                                System.out.println(msgIn);

                                try {
                                    op2 = Double.parseDouble(msgIn);
                                    //Se l'operando é valido
                                    msgOut="Y";
                                    b_msg = msgOut.getBytes();
                                    toClt.write(b_msg,0,b_msg.length);
                                    break;
                                    
                                } catch (NumberFormatException ne) {
                                    //Se l'operando non é valido
                                    msgOut="N";
                                    b_msg = msgOut.getBytes();
                                    toClt.write(b_msg,0,b_msg.length);
                                }
                            }

                            Double res=0.0;
                            //Eseguo l'operazione:
                            switch(opt){
                                case '*':
                                    res=op1*op2;
                                break;

                                case '+':
                                    res=op1+op2;
                                break;

                                case '-':
                                    res=op1-op2;
                                break;

                                case '/':
                                    res=op1/op2;
                                break;

                            }

                            //Invio il risultato al client

                            msgOut=""+res;
                            b_msg = msgOut.getBytes();
                            toClt.write(b_msg,0,b_msg.length);

                            
                        }
                    
                        toClient.close();
                        clients.remove(i);
                        i++;
                        conn--;
                        
                    }catch(SocketException se){
                        System.out.println("Errore di connesisone con il client: "+toClient.getInetAddress());
                        try{
                            toClient.close();
                        }catch(IOException ioe){
                            ioe.printStackTrace();
                        }
                        continue;
                    }catch(IOException ioe){
                        ioe.printStackTrace();
                    }



                }
            }
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
   


}
