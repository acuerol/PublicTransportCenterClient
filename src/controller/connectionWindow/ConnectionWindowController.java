package controller.connectionWindow;

import view.connectionWindow.ConnectionWindowJF;

/**
 * @author Alexis Cuero Losada
 * Controller for the connection window.
 */
public class ConnectionWindowController {

	private ConnectionWindowJF connectionWindowJF;

	/**
	 * Creates a ConnectionWindowController instance for manage the
	 * mainWindowbuttons listener.
	 */
	public ConnectionWindowController() {
		connectionWindowJF = new ConnectionWindowJF();
	}

	/**
	 * Returns the connectionWidnowJF instance.
	 * @return the connectionWindowJF instance.
	 */
	public ConnectionWindowJF getConnectionWindow() {
		return connectionWindowJF;
	}
}
