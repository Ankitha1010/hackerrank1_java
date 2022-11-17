import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientUDP{
   public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
     InetAddress ia=InetAddress.getByName("localhost");
     DatagramSocket ds=new DatagramSocket();
     //send
     String msg="Hello this is client...";
     byte b[]=msg.getBytes();
     DatagramPacket dp=new DatagramPacket(b, b.length, ia, 6666);
     ds.send(dp);
     //receive
     byte data[]=new byte[1000];
     DatagramPacket dp1=new DatagramPacket(data, data.length);
     ds.receive(dp1);
     String str=new String(dp1.getData(),0,dp1.getLength());
     System.out.println(str);
     ds.close();
   }
}