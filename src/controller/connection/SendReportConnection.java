package controller.connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import model.PublicTransportCenter;

/**
 * 
 * @author Alexis Cuero Losada
 * Class for send a report to the server of the main program.
 */
public class SendReportConnection {

	/**
	 * The IP of server for send request.
	 */
	public static final String IP = "localhost";
	/**
	 * The port for communicate with the server. 
	 */
	public static final int PORT = 5001;

	private Socket clientSocket;

	/**
	 * Class constructor, create the client socket.
	 */
	public SendReportConnection() {
		createClientSocket();
	}

	/**
	 * Sends the report from the client to the server with the system update.
	 * @return true if all is correct or false if an error has occurred.
	 */
	public boolean sendSystemReport() {
		if (clientSocket != null) {
			String confirmation = "";
			PublicTransportCenter pTC = PublicTransportCenter.getPublicTransportCenter();

			try {
				ObjectInputStream serverDataSended = new ObjectInputStream(clientSocket.getInputStream());
				ObjectOutputStream sendData = new ObjectOutputStream(clientSocket.getOutputStream());

				sendData.writeObject(PublicTransportCenter.getPublicTransportCenter());

				confirmation = (String) serverDataSended.readObject();

				if (confirmation.equals("true")) {
					pTC = (PublicTransportCenter) serverDataSended.readObject();
					PublicTransportCenter.refreshBusesFromServer(pTC);

					return true;
				}

				System.err.println("Error reporting data.");

			} catch (IOException e) {
				System.err.println("Error Writing/Reading sendSystemReport.");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.err.println("ClassNotFoundException sendSystemReport.");
				e.printStackTrace();
			}
		} else {
			createClientSocket();
		}

		return false;
	}
	
	private void createClientSocket() {
		try {
			clientSocket = new Socket(IP, PORT);
		} catch (UnknownHostException e) {
			System.err.println("Unknown Host, port error.");
		} catch (IOException e) {
			System.err.println("Write/Read error, the server not responding.");
		}
	}
}
