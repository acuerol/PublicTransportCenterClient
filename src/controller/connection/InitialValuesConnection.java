package controller.connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import model.PublicTransportCenter;
import view.connectionWindow.ConnectionWindowJF;
import view.connectionWindow.MainJP;
import util.Alert;

/**
 * @author Alexis Cuero Losada
 * This class is used for send a request to the server for initial values.
 */
public class InitialValuesConnection {

	/**
	 * The IP of server for send request.
	 */
	public static final String IP = "localhost";
	/**
	 * The port for communicate with the server. 
	 */
	public static final int PORT = 5000;

	private Socket clientSocket;
	private JFrame parent;

	/**
	 * Initializes the client connection for send the initial values request.
	 * @param parent the JFrame that call this method for generate the alerts.
	 */
	public InitialValuesConnection(JFrame parent) {
		this.parent = parent;

		try {
			clientSocket = new Socket(IP, PORT);
		} catch (UnknownHostException e) {
			Alert.launchErrorMessage("Unknown Host, port error.", this.parent);
			System.err.println("Unknown Host, port error.");
		} catch (IOException e) {
			Alert.launchErrorMessage(
					"Write/Read error, the server not responding.", this.parent);
			System.err.println("Write/Read error, the server not responding.");
		}
	}

	/**
	 * Sends a initial value request to server for start the system. Returns a PublicTransportCenter instance
	 * for set in the actual system. 
	 * @param connectionWindow the connectionWindow for generate the alerts.
	 * @return the initial PublicTransportCenter instance.
	 */
	public PublicTransportCenter sendInitialValuesRequest(ConnectionWindowJF connectionWindow) {
		PublicTransportCenter pTC = PublicTransportCenter.getPublicTransportCenter();
		MainJP mainJP = connectionWindow.getMainJP();

		mainJP.addTextInformationJTA("ClientRequestSocket loading initial values...");
		mainJP.addTextInformationJTA("Send initial values request...");

		if (clientSocket == null) {
			mainJP.addTextInformationJTA("Error creating connection with server.");
			return null;
		}

		try {
			ObjectInputStream serverDataSended = new ObjectInputStream(
					clientSocket.getInputStream());
			ObjectOutputStream sendData = new ObjectOutputStream(
					clientSocket.getOutputStream());

			pTC = (PublicTransportCenter) serverDataSended.readObject();
			
			if (pTC != null) {
				sendData.writeObject("true");
				mainJP.addTextInformationJTA("Initial values loaded succefully.");
				
				return pTC;
			}

			sendData.writeObject("false");
			mainJP.addTextInformationJTA("Error load initial values.");
		} catch (IOException e) {
			Alert.launchErrorMessage("Error I/O ServerSocket.", this.parent);
			mainJP.addTextInformationJTA("Error I/O ServerSocket.");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			Alert.launchErrorMessage("Error object received class not found.",
					this.parent);
			mainJP.addTextInformationJTA("Error object received class not found.");
			e.printStackTrace();
		}

		return PublicTransportCenter.getPublicTransportCenter();
	}
}
