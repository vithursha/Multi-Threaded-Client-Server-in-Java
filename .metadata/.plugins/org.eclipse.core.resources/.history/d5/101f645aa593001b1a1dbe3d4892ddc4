public class SharedCarParkState {
	// separate threads created
	// only one thread run/can use shared variable at one time
	private SharedCarParkState mySharedObj;
	private String myThreadName;
	private int myCarInCarPark;
	private int myEntranceOneQueue;
	private int myEntranceTwoQueue;
	private boolean accessing = false; // true a thread has a lock, false otherwise
	private int threadsWaiting = 0;// number of waiting writers

	// shared object has three variables
	// number of cars and queue variables

// Constructor	

	SharedCarParkState(int CarInCarPark, int entranceOneQUeue, int entranceTwoQUeue) {
		myCarInCarPark = CarInCarPark;
		myEntranceOneQueue = entranceOneQUeue;
		myEntranceTwoQueue = entranceTwoQUeue;
	}

//Attempt to aquire a lock

	public synchronized void acquireLock() throws InterruptedException {
		Thread me = Thread.currentThread(); // get a ref to the current thread
		System.out.println(me.getName() + " is attempting to acquire a lock!");
		++threadsWaiting;
		while (accessing) { // while someone else is accessing or threadsWaiting > 0
			System.out.println(me.getName() + " waiting to get a lock as someone else is accessing...");
			// wait for the lock to be released - see releaseLock() below
			wait();
		}
		// nobody has got a lock so get one
		--threadsWaiting;
		accessing = true;
		System.out.println(me.getName() + " got a lock!");
	}

	// Releases a lock to when a thread is finished

	public synchronized void releaseLock() {
		// release the lock and tell everyone
		accessing = false;
		notifyAll();
		Thread me = Thread.currentThread(); // get a ref to the current thread
		System.out.println(me.getName() + " released a lock!");
	}

	/* The processInput method */

	public synchronized String processInput(String myThreadName, String theInput) {
		System.out.println(myThreadName + " received " + theInput);
		String theOutput = null;
		// Check what the client said
		if (theInput.equalsIgnoreCase("ce")) {
			// Correct request
			if (myThreadName.equals("EntranceOneThread1")) {
				if (myCarInCarPark < 5 && myEntranceOneQueue == 0) {
					myCarInCarPark = myCarInCarPark + 1;
					System.out.println(myThreadName + " made the number of cars in the car park " + myCarInCarPark);
					theOutput = "Request complete. Number of cars on CP now = " + myCarInCarPark + " Queue One now= "
							+ myEntranceOneQueue + " Queue Two now= " + myEntranceTwoQueue;
				} else if (myCarInCarPark < 5 && myEntranceOneQueue != 0) {
					myEntranceOneQueue = myEntranceOneQueue - 1;
					System.out.println(myThreadName + " made the number of cars in the car park " + myCarInCarPark);
					theOutput = "Request complete. Number of cars on CP now = " + myCarInCarPark + " Queue One now= "
							+ myEntranceOneQueue + " Queue Two now= " + myEntranceTwoQueue;
				} else {
					myEntranceOneQueue = myEntranceOneQueue + 1;
					System.out.println(myThreadName + " made the number of cars in the car park " + myCarInCarPark);
					theOutput = "Request complete. Number of cars on CP now = " + myCarInCarPark + " Queue One now= "
							+ myEntranceOneQueue + " Queue Two now= " + myEntranceTwoQueue;
				}
			} else if (myThreadName.equals("EntranceTwoThread2")) {
				if (myCarInCarPark < 5 && myEntranceTwoQueue == 0) {
					myCarInCarPark = myCarInCarPark + 1;
					System.out.println(myThreadName + " made the number of cars in the car park " + myCarInCarPark);
					theOutput = "Request complete. Number of cars on CP now = " + myCarInCarPark + " Queue One now= "
							+ myEntranceOneQueue + " Queue Two now= " + myEntranceTwoQueue;
				} else if (myCarInCarPark < 5 && myEntranceTwoQueue != 0) {
					myEntranceTwoQueue = myEntranceTwoQueue - 1;
					System.out.println(myThreadName + " made the number of cars in the car park " + myCarInCarPark);
					theOutput = "Request complete. Number of cars on CP now = " + myCarInCarPark + " Queue One now= "
							+ myEntranceOneQueue + " Queue Two now= " + myEntranceTwoQueue;
				} else {
					myEntranceTwoQueue = myEntranceTwoQueue + 1;
					System.out.println(myThreadName + " made the number of cars in the car park " + myCarInCarPark);
					theOutput = "Request complete. Number of cars on CP now = " + myCarInCarPark + " Queue One now= "
							+ myEntranceOneQueue + " Queue Two now= " + myEntranceTwoQueue;
				}
			}

		} else if (theInput.equalsIgnoreCase("cl")) {
			if (myThreadName.equals("ExitOneThread3")) {
				if (myCarInCarPark < 6 && myCarInCarPark > 0) {
					if (myEntranceOneQueue == 0) {
						if (myEntranceTwoQueue == 0) {
							myCarInCarPark = myCarInCarPark - 1;
							System.out.println(
									myThreadName + " made the number of cars in the car park " + myCarInCarPark);
							theOutput = "Request complete. Number of cars on CP now = " + myCarInCarPark
									+ " Queue One now= " + myEntranceOneQueue + " Queue Two now= " + myEntranceTwoQueue;
						} else if (myEntranceTwoQueue != 0) {
							myEntranceTwoQueue = myEntranceTwoQueue - 1;
							System.out.println(
									myThreadName + "made the number of cars in the car park " + myCarInCarPark);
							theOutput = "Request complete. Number of cars on CP now = " + myCarInCarPark
									+ " Queue One now= " + myEntranceOneQueue + " Queue Two now= " + myEntranceTwoQueue;
						}
					} else if (myEntranceOneQueue != 0) {
						myEntranceOneQueue = myEntranceOneQueue - 1;
						System.out.println(myThreadName + " made the number of cars in the car park " + myCarInCarPark);
						theOutput = "Request complete. Number of cars on CP now = " + myCarInCarPark
								+ " Queue One now= " + myEntranceOneQueue + " Queue Two now= " + myEntranceTwoQueue;
					}
				}
			}

			if (myThreadName.equals("ExitTwoThread4")) {
				if (myCarInCarPark < 6 && myCarInCarPark > 0) {
					if (myEntranceOneQueue == 0) {
						if (myEntranceTwoQueue == 0) {
							myCarInCarPark = myCarInCarPark - 1;
							System.out.println(
									myThreadName + " made the number of cars in the car park " + myCarInCarPark);
							theOutput = "Request complete. Number of cars on CP now = " + myCarInCarPark
									+ " Queue One now= " + myEntranceOneQueue + " Queue Two now= " + myEntranceTwoQueue;
						} else if (myEntranceTwoQueue != 0) {
							myEntranceTwoQueue = myEntranceTwoQueue - 1;
							System.out.println(
									myThreadName + " made the number of cars in the car park " + myCarInCarPark);
							theOutput = "Request complete. Number of cars on CP now = " + myCarInCarPark
									+ " Queue One now= " + myEntranceOneQueue + " Queue Two now= " + myEntranceTwoQueue;
						}
					} else if (myEntranceOneQueue != 0) {
						myEntranceOneQueue = myEntranceOneQueue - 1;
						System.out.println(myThreadName + " made the number of cars in the car park " + myCarInCarPark);
						theOutput = "Request complete. Number of cars on CP now = " + myCarInCarPark
								+ " Queue One now= " + myEntranceOneQueue + " Queue Two now= " + myEntranceTwoQueue;
					}
				}
			}

			else {
				System.out.println("Error - thread call not recognised.");

			}
		}

		else { // incorrect request
			theOutput = myThreadName
					+ " received incorrect request - only understand \"ce\" (\"Car entering\") OR \"cl\" (\"Car leaving\")";

		}

		// Return the output message to the CarParkServer
		System.out.println(theOutput);
		return theOutput;
	}

}

