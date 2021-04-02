import java.io.IOException;
import java.net.ServerSocket;

public class CarParkServer {
	public static void main(String[] args) throws IOException {
		// defining object
		// class called serversocket
		ServerSocket CarParkServerSocket = null;
		boolean listening = true;
		String CarParkServerName = "CarParkServer";
		// port number
		int CarParkServerNumber = 4321;
		int CarInCarPark = 0;
		int entranceOneQUeue = 0;
		int entranceTwoQUeue = 0;
		// Create the shared object in the global scope...
		SharedCarParkState ourSharedCarParkStateObject = new SharedCarParkState(CarInCarPark, entranceOneQUeue,
				entranceTwoQUeue);
		// Make the server socket
		try {
			CarParkServerSocket = new ServerSocket(CarParkServerNumber);
		} catch (IOException e) {
			System.err.println("Could not start " + CarParkServerName + " specified port.");
			System.exit(-1);
		}
		System.out.println(CarParkServerName + " started");
		// Got to do this in the correct order with only four clients
		// run in this order
		// if exit connects first, it wont connect to entrance
		while (listening) {
			// wait for a thread - client to connect
			new CarParkServerThread(CarParkServerSocket.accept(), "EntranceOneThread1", ourSharedCarParkStateObject)
					.start();
			new CarParkServerThread(CarParkServerSocket.accept(), "EntranceTwoThread2", ourSharedCarParkStateObject)
					.start();
			new CarParkServerThread(CarParkServerSocket.accept(), "ExitOneThread3", ourSharedCarParkStateObject)
					.start();
			new CarParkServerThread(CarParkServerSocket.accept(), "ExitTwoThread4", ourSharedCarParkStateObject)
					.start();
			System.out.println("New " + CarParkServerName + " thread started.");
		}
		CarParkServerSocket.close();
	}
}
