package multicast;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) throws Exception {
		udp("hello");
	}
	
	public static void udp(String message) {
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket();
			byte[] m = message.getBytes();
			InetAddress aHost = InetAddress.getByName("230.1.1.5");

			DatagramPacket request = new DatagramPacket(m, m.length, aHost, Port.MULTICAST);
			aSocket.send(request);
			
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			
			while(true) {
			aSocket.receive(reply);
			System.out.println( "Reply: " + new String(reply.getData(), "UTF-8"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

