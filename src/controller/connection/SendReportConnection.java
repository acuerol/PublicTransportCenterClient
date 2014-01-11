package controller.connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import model.Bus;
import model.PublicTransportCenter;
import util.Alert;

public class SendReportConnection {

	public static final String IP = "localhost";
	public static final int PORT = 5001;

	private PublicTransportCenter pTC;
	private Socket clientSocket;
	
	public SendReportConnection()
	{
		createClientSocket();
	}
	
	private void createClientSocket()
	{
		try {
			clientSocket = new Socket(IP, PORT);
		} catch (UnknownHostException e)
		{
			System.err.println("Unknown Host, port error.");
		} catch (IOException e)
		{
			System.err.println("Write/Read error, the server not responding.");
		}
	}
	
	public boolean sendSystemReport()
	{
		if(clientSocket != null)
		{		
			String confirmation = "";
			PublicTransportCenter pTC;
			
			try 
			{
				ObjectInputStream serverDataSended = new ObjectInputStream(clientSocket.getInputStream());
				ObjectOutputStream sendData = new ObjectOutputStream(clientSocket.getOutputStream());
				
				sendData.writeObject(PublicTransportCenter.getPublicTransportCenter());
				
				confirmation = (String) serverDataSended.readObject();
				
				if(confirmation.equals("true"))
				{
					pTC = (PublicTransportCenter) serverDataSended.readObject();
					this.pTC = pTC;
					PublicTransportCenter.refreshBusesFromServer(pTC);
				
					return true;
				}
				
				System.err.println("Error reporting data.");
				
			} catch (IOException e) {
				System.err.println("Error Writing/Reading sendSystemReport.");
				e.printStackTrace();
				return false;
			} catch (ClassNotFoundException e) {
				System.err.println("ClassNotFoundException sendSystemReport.");
				e.printStackTrace();
				return false;
			}
		}
		else
		{
			createClientSocket();
		}
		
		return false;
	}
}
