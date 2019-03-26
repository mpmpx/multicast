package multicast;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Base64;

public class UDPServer {

	public static void main(String[] args) {
		MulticastSocket aSocket = null;
		try {
			aSocket = new MulticastSocket(Port.MULTICAST);

			aSocket.joinGroup(InetAddress.getByName("230.1.1.5"));

			byte[] buffer = new byte[1000];
			System.out.println("Server Started............");

			while (true) {
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				aSocket.receive(request);
				System.out.println( new String(request.getData(), 0, request.getLength()));
				//DatagramPacket reply = new DatagramPacket("from server 1".getBytes(), "from server 1".getBytes().length, request.getAddress(),
				//		request.getPort());
				//aSocket.send(reply);
			}

		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (aSocket != null)
				aSocket.close();
		}
	}
}