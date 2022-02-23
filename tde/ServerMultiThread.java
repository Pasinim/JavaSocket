import java.io.*;
import java.net.*;
//server multi thread TCP,gestisco le varie richieste contemporanee dei client facendo parallilismo con threads....
//devo isolare la parte che fa comunicazione con il client in una classe che estende la classe Thread
public class ServerMultiThread{
	public static void main(String[] args){
		ServerSocket server;
		Socket client;
		try{
			server=new ServerSocket(9876);
			System.out.println("Server in ascolto sulla porta 9876");
			while(true){
				client=server.accept();
				System.out.println("Ind client: "+client.getInetAddress()+ "; porta: "+client.getPort());
				//ora lo passo ad un Thread
				Thread t=new GestisciConnessione(client);
				t.start();
				//client.close() va chiusa quando termina il thread..non qui..non ora
			}
		}catch(Exception e){e.printStackTrace();}
	}
}