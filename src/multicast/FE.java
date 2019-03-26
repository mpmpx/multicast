package multicast;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class FE {

	public static void main (String[] args) throws Exception { 
		DatagramSocket socket = null;
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Client start....");
			socket = new DatagramSocket();
			byte[] message = "123456".getBytes();
			InetAddress aHost = InetAddress.getByName("localhost");
			
			while (true) {
				System.out.print("Please enter: ");
				String input = scanner.nextLine();
				DatagramPacket request = new DatagramPacket(input.getBytes(), input.getBytes().length, aHost, Port.SEQUENCER);
				    socket.send(request);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
}
