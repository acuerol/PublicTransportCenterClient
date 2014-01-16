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
 * 
 * @author Alexis Cuero Losada
 * 
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
	 * CentralSystem constructor with the JFrame apareance.
	 */
	private CentralSystem() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		SubstanceLookAndFeel.setSkin(new BusinessBlackSteelSkin());
	}

	/**
	 * Creates the PublicTransportCenter instance if this hasn't been create
	 * else return the instance.
	 * 
	 * @return the PublicTransportCenter instance if this has been already
	 *         create else create this.
	 */
	public static synchronized CentralSystem getCentralSystem() {
		if (centralSystem == null) {
			centralSystem = new CentralSystem();
		}

		return centralSystem;
	}

	public void createRefreshSystemGraphicThread()
	{
		refreshSystemGraphicThread = new RefreshSystemGraphicThread();
		refreshSystemGraphicThread.start();
	}
	
	public void interruptRefreshSystemGraphicThread()
	{
		refreshSystemGraphicThread.setInterrupt();
	}
	
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

	public void createWindowCreationController() {
		windowCreationController = new WindowCreationController();
		windowCreationController.setJButtonsMouseListener();
	}

	public WindowCreationController getWindowCreationController() {
		return windowCreationController;
	}

	public void createBusesWindowController() {
		busesWindowController = new BusesWindowController();
		busesWindowController.setJButtonsMouseListener();
		cretaeRefreshTableThread();
	}

	public BusesWindowController getBusesWindowController() {
		return busesWindowController;
	}

	public void runBusThread() {
		busThread = new BusThread();
		busThread.start();
	}

	public void cretaeRefreshTableThread() {
		refreshTableThread = new RefreshTableThread();
		refreshTableThread.start();
	}

	public void interruptRefreshTableThread() {
		refreshTableThread.setInterrupt();
	}

	public RefreshTableThread getRefreshTableThread() {
		return refreshTableThread;
	}

	public void sendInitialValuesRequest() {
		PublicTransportCenter pTC = PublicTransportCenter
				.getPublicTransportCenter();
		connectionWindowController.getConnectionWindow().getMainJP()
				.addTextInformationJTA("-----------------------");
		connectionWindowController.getConnectionWindow().getMainJP()
				.addTextInformationJTA("Try connect.");
		connectionWindowController.getConnectionWindow().getMainJP()
				.addTextInformationJTA("-----------------------");

		initialValuesConnection = new InitialValuesConnection(
				connectionWindowController.getConnectionWindow());

		try {
			pTC = initialValuesConnection
					.sendInitialValuesRequest(connectionWindowController
							.getConnectionWindow());
		} catch (NullPointerException e) {
			System.err.println("Null object receive.");
			e.printStackTrace();
		}
		
		if (pTC != null) {
			PublicTransportCenter.setPublicTransportCenter(pTC);
			connectionWindowController.getConnectionWindow().getButtonsJP()
					.setEnableStartSystemJB(true);
			connectionWindowController.getConnectionWindow().getMainJP()
					.refreshState(true);
		} else {
			connectionWindowController.getConnectionWindow().getMainJP()
					.addTextInformationJTA("Error loading initial values.");
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
