import java.io.*;
import java.net.*;

public class GestisciConnessione extends Thread {
	private Socket client;
	public GestisciConnessione(Socket socket){  //costruttore con argomento socket 
		this.client=socket;
		
	}
	
	public static void main(String[] args) {
	
	   //eseguito quando si fa partire il thread(Start)
	byte buffer[]=new byte[100];
	while(true){
		try{
			InputStream fromClient=client.getInputStream();
			OutputStream toClient=client.getOutputStream(); //se voglio ritornre qualcosa al client implemento anche BufferedReader
			int letti=fromClient.read(buffer);
			if(letti>0){
				String stampa=new String(buffer,0,letti); //converto i byte letti memorizzari in buffer in una stringa...client passa bytes
				System.out.println("Ho letto la frase: "+stampa+" dal client con indirizzo: "+client.getInetAddress()+" e il numero di porta: "+
				client.getPort());
				toClient.write(stampa.getBytes(),0,stampa.length()); //servizio Echo
				if(stampa.compareTo(".")==0){   //se ho letto la stringa "." chiudo la connessione e ritorno..
					client.close();
					return;
				}
			}
			else {//se leggo meno di 1
				client.close();
				return;
			}
			 
			
		}catch(Exception ex){ex.printStackTrace();}
	}
	}
	
			
	
	
	
}