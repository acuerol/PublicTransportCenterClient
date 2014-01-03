package controller.connectionWindow;

import controller.CentralSystem;
import model.PublicTransportCenter;
import view.connectionWindow.ConnectionWindowJF;

/**
 * 
 * @author Alexis Cuero Losada
 *
 */
public class ConnectionWindowController {

	private ConnectionWindowJF connectionWindow;
	
	/**
	 * Creates a ConnectionWindowController instance for manage the mainWindowbuttons listener. 
	 */
	public ConnectionWindowController()
	{
		connectionWindow = new ConnectionWindowJF();
	}

	public ConnectionWindowJF getConnectionWindow() {
		return connectionWindow;
	}
}
