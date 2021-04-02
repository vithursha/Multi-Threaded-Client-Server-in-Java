import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CarParkServerThread extends Thread {

	// define a single thread
	private Socket CarParkSocket = null;
	private SharedCarParkState mySharedCarParkStateObject;
	private String myCarParkServerThreadName;
	private int myCarInCarPark;

	// Setup the thread
	public CarParkServerThread(Socket CarParkSocket, String CarParkServerThreadName, SharedCarParkState SharedObject) {

//	  super(CarParkServerThreadName);
		this.CarParkSocket = CarParkSocket;
		mySharedCarParkStateObject = SharedObject;
		myCarParkServerThreadName = CarParkServerThreadName;
	}

	public void run() {
		try {
			System.out.println(myCarParkServerThreadName + "initialising.");
			PrintWriter out = new PrintWriter(CarParkSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(CarParkSocket.getInputStream()));
			String inputLine, outputLine;

			while ((inputLine = in.readLine()) != null) {
				// Get a lock first
				try {
					mySharedCarParkStateObject.acquireLock();
					// process the message from client to server
					outputLine = mySharedCarParkStateObject.processInput(myCarParkServerThreadName, inputLine);
					// send back message to client
					out.println(outputLine);
					// release lock
					mySharedCarParkStateObject.releaseLock();
				} catch (InterruptedException e) {
					System.err.println("Failed to get lock when reading:" + e);
				}
			}
			out.close();
			in.close();
			CarParkSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
