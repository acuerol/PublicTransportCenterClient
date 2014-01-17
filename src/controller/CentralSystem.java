package controller;

import javax.swing.JFrame;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.BusinessBlackSteelSkin;

import controller.busesWindow.BusesWindowController;
import controller.connection.InitialValuesConnection;
import controller.connectionWindow.ConnectionWindowController;
import controller.graphicSystem.GraphicSystemController;
import controller.threads.BusThread;
import controller.threads.RefreshSystemGraphicThread;
import controller.threads.SendReportConnectionThread;
import controller.threads.RefreshTableThread;
import controller.windowCreation.WindowCreationController;
import model.PublicTransportCenter;

/**
 * @author Alexis Cuero Losada
 * CentralSystem is the abstract class, this is the central controller, contains all sub controllers.
 * Implements Singleton for ensure have the same instances along of all program.
 */
public class CentralSystem {

	private ConnectionWindowController connectionWindowController;
	private WindowCreationController windowCreationController;
	private BusesWindowController busesWindowController;
	private InitialValuesConnection initialValuesConnection;
	private GraphicSystemController graphicSystemController;
	private BusThread busThread;
	private RefreshTableThread refreshTableThread;
	private SendReportConnectionThread reportConnectionThread;
	private RefreshSystemGraphicThread refreshSystemGraphicThread;
	
	private static CentralSystem centralSystem;

	/**
	 * CentralSystem constructor with the JFrame appearance.
	 */
	private CentralSystem() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		SubstanceLookAndFeel.setSkin(new BusinessBlackSteelSkin());
	}

	/**
	 * Returns the centralSystem if this was created, else create a new instance of this.
	 * Ensure that always the get instance will be the same.
	 * @return the CentralSystem instance
	 */
	public static synchronized CentralSystem getCentralSystem() {
		if (centralSystem == null) {
			centralSystem = new CentralSystem();
		}

		return centralSystem;
	}

	/**
	 * Creates the thread that handles the map with the label, these represent every element in the system.
	 */
	public void createRefreshSystemGraphicThread()
	{
		refreshSystemGraphicThread = new RefreshSystemGraphicThread();
		refreshSystemGraphicThread.start();
	}
	
	/**
	 * Interrupts the thread that handles the graphic system representation.
	 */
	public void interruptRefreshSystemGraphicThread()
	{
		refreshSystemGraphicThread.setInterrupt();
	}
	
	/**
	 * Creates the controller for the graphic system and set the listener for the change in the
	 * JComboBox an the mouse listener for the JButtons.
	 */
	public void createGraphicSystemController() {
		graphicSystemController = new GraphicSystemController();
		graphicSystemController.getGraphicSystemJF().setJComboBoxItemListener();
		graphicSystemController.getGraphicSystemJF().setJButtonsMouseListener();
	}
	
	/**
	 * Creates a ReportConnectionThread instance and start to send reports.
	 */
	public void createReportConnectionThread() {
		reportConnectionThread = new SendReportConnectionThread();
		reportConnectionThread.start();
		reportConnectionThread.startToReport();
	}

	/**
	 * Returns the ReportConnectionThread instance.
	 * 
	 * @return the ReportConnectionThread instance.
	 */
	public SendReportConnectionThread getReportConnectionThread() {
		return reportConnectionThread;
	}

	/**
	 * Creates a ConnectionWindowController instance and set the listeners for
	 * the JButtons on this.
	 */
	public void createConnectionWindowController() {
		connectionWindowController = new ConnectionWindowController();
		connectionWindowController.getConnectionWindow()
				.setJButtonsMouseListeners();
	}

	/**
	 * Returns the ConnectionWindowController instance creates in the system.
	 * 
	 * @return the ConnectionWindowController instance creates in the system.
	 */
	public ConnectionWindowController getConnectionWindowController() {
		return connectionWindowController;
	}

	/**
	 * Creates the controller and set the mouse listener for the WindowCreation (manage Buse and Driver).
	 */
	public void createWindowCreationController() {
		windowCreationController = new WindowCreationController();
		windowCreationController.setJButtonsMouseListener();
	}

	/**
	 * Returns the instance of WindowCreatioController for manage buses and drivers.
	 * @return the instance of WindowCreatioController 
	 */
	public WindowCreationController getWindowCreationController() {
		return windowCreationController;
	}

	/**
	 * Creates the controller for the window that allows wath the information of the buses in the system in an JTable. 
	 */
	public void createBusesWindowController() {
		busesWindowController = new BusesWindowController();
		busesWindowController.setJButtonsMouseListener();
		cretaeRefreshTableThread();
	}

	/**
	 * Returns the controller of BusesWindow for visualize the buses in the system in a JTable. 
	 * @return the controller of BusesWindow
	 */
	public BusesWindowController getBusesWindowController() {
		return busesWindowController;
	}

	/**
	 * Creates and starts the thread for handle the buses speed and position.
	 */
	public void createBusThread() {
		busThread = new BusThread();
		busThread.start();
	}

	/**
	 * Creates the thread that handle the updating of the busesWindow JTable for show the information about
	 * the buses in the system. 
	 */
	public void cretaeRefreshTableThread() {
		refreshTableThread = new RefreshTableThread();
		refreshTableThread.start();
	}

	/**
	 * Interrupts the refreshTableThread.
	 */
	public void interruptRefreshTableThread() {
		refreshTableThread.setInterrupt();
	}

	/**
	 * Sends a initialValueRequets to the server and set the system obtained. 
	 */
	public void sendInitialValuesRequest() {
		PublicTransportCenter pTC = PublicTransportCenter.getPublicTransportCenter();
		connectionWindowController.getConnectionWindow().getMainJP().addTextInformationJTA("-----------------------");
		connectionWindowController.getConnectionWindow().getMainJP().addTextInformationJTA("Try connect.");
		connectionWindowController.getConnectionWindow().getMainJP().addTextInformationJTA("-----------------------");

		initialValuesConnection = new InitialValuesConnection(	connectionWindowController.getConnectionWindow());

		try {
			pTC = initialValuesConnection.sendInitialValuesRequest(connectionWindowController.getConnectionWindow());
		} catch (NullPointerException e) {
			System.err.println("Null object receive.");
			e.printStackTrace();
		}
		
		if (pTC != null) {
			PublicTransportCenter.setPublicTransportCenter(pTC);
			connectionWindowController.getConnectionWindow().getButtonsJP().setEnableStartSystemJB(true);
			connectionWindowController.getConnectionWindow().getMainJP().refreshState(true);
		} else {
			connectionWindowController.getConnectionWindow().getMainJP().addTextInformationJTA("Error loading initial values.");
		}
	}

	/**
	 * @return the graphicSystemController
	 */
	public GraphicSystemController getGraphicSystemController() {
		return graphicSystemController;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return getCentralSystem();
	}
}
