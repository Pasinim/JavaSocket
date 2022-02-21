import java.net.InetAddress;
import java.net.UnknownHostException;

public class Indirizzi
{
    public static void main(String[] args) {

        String name="www.unimi.it";
        String name2="www.google.com";

        try{
            InetAddress ia = InetAddress.getByName(name);
            byte[] ndp = ia.getAddress();
            String hostAddress = String.format("Indirizzo: %d.%d.%d.%d", ndp[0] & 0xff, ndp[1] & 0xff, ndp[2] & 0xff, ndp[3] & 0xff);
            System.out.println(hostAddress);
            //Esercizio Casa

            //Local Host
            InetAddress lia = InetAddress.getLocalHost();
            byte[] lndp  = lia.getAddress();
            System.out.println("Indirizzo Locale :"+ (lndp[0] & 0xff) + "." + (lndp[1] & 0xff) + "." + (lndp[2] & 0xff) + "." + (lndp[3] & 0xff) );

            //All address of "www.google.com"
            
            InetAddress[] aia = InetAddress.getAllByName(name2);
            for (int i = 0; i < aia.length; i++){
                byte[] add = aia[i].getAddress();
                System.out.println(String.format("Indirizzo: %d.%d.%d.%d", add[0] & 0xff, add[1] & 0xff, add[2] & 0xff, add[3] & 0xff));
                
            }
        }catch (UnknownHostException uhe) {
            uhe.printStackTrace();
        }
        
    }
}