import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EntryOneClient {
	public static void main(String[] args) throws IOException {
		// Set up the client socket, in and out variables
		// client designed to connect to server
		Socket CarParkClientSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		// same port as server and other clients
		int CarParkSocketNumber = 4321;
		String CarParkServerName = "localhost";
		String CarParkClientID = "CarParkClient1";
		try {
			// create a socket with the input
			CarParkClientSocket = new Socket(CarParkServerName, CarParkSocketNumber);
			out = new PrintWriter(CarParkClientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(CarParkClientSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: localhost ");
			System.exit(1);
		} catch (IOException e) {
			// if client is run before the server
			System.err.println("Couldn't get I/O for the connection to: " + CarParkSocketNumber);
			System.exit(1);
		}
		// // wait in queue if no space
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String fromServer;
		String fromUser;
		System.out.println("Initialised " + CarParkClientID + " client and IO connections");
		// This is modified as it's the client that speaks first
		// true = infinite loop
		while (true) {

			// sends message that car arrives
			// gets message back from server saying if car added to Q or CP
			// no decision making
			// readLine = waits for user to type something
			// the program reads a line and prints it on the server
			fromUser = stdIn.readLine();
			if (fromUser != null) {
				System.out.println(CarParkClientID + " sending " + fromUser + " to CarParkServer");
				out.println(fromUser);
			}
			fromServer = in.readLine();
			System.out.println(CarParkClientID + " received " + fromServer + " from CarParkServer");
		}

		// Tidy up - not really needed due to true condition in while loop
		// out.close();
		// in.close();
		// stdIn.close();
		// CarParkClientSocket.close();
	}
}
