package controller;

import javax.swing.JFrame;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.BusinessBlackSteelSkin;

import controller.busesWindow.BusesWindowController;
import controller.connection.InitialValuesConnection;
import controller.connectionWindow.ConnectionWindowController;
import controller.threads.BusThread;
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
	private BusThread busThread;
	private RefreshTableThread refreshTableThread;
	private SendReportConnectionThread reportConnectionThread;
	
	private PublicTransportCenter pTC;
	private static CentralSystem centralSystem;
	
	/**
	 * CentralSystem constructor with the JFrame apareance.
	 */
	private CentralSystem() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		SubstanceLookAndFeel.setSkin(new BusinessBlackSteelSkin());
		pTC = PublicTransportCenter.getPublicTransportCenter();
	}
	
	/**
	 * Creates the PublicTransportCenter instance if this hasn't been create else return the instance.
	 * @return the PublicTransportCenter instance if this has been already create else create this.
	 */
	public static synchronized CentralSystem getCentralSystem()
	{
		if(centralSystem == null)
		{
			centralSystem = new CentralSystem();
		}
		
		return centralSystem;
	}
	
	/**
	 * Creates a ReportConnectionThread instance and start to send reports.
	 */
	public void createReportConnectionThread()
	{
		reportConnectionThread = new SendReportConnectionThread();
		reportConnectionThread.start();
		reportConnectionThread.startToReport();
	}
	
	/**
	 * Returns the ReportConnectionThread instance.
	 * @return the ReportConnectionThread instance.
	 */
	public SendReportConnectionThread getReportConnectionThread()
	{
		return reportConnectionThread;
	}
	
	/**
	 * Creates a ConnectionWindowController instance and set the listeners for the JButtons on this.
	 */
	public void createConnectionWindowController()
	{
		connectionWindowController = new ConnectionWindowController();
		connectionWindowController.getConnectionWindow().setJButtonsActionListeners();
	}
	
	/**
	 * Returns the ConnectionWindowController instance creates in the system.
	 * @return the ConnectionWindowController instance creates in the system.
	 */
	public ConnectionWindowController getConnectionWindowController()
	{
		return connectionWindowController; 
	}
	
	public void createWindowCreationController()
	{
		windowCreationController = new WindowCreationController();
		windowCreationController.setJButtonsMouseListener();
	}
	
	public WindowCreationController getWindowCreationController()
	{
		return windowCreationController;
	}
	
	public void createBusesWindowController()
	{
		busesWindowController = new BusesWindowController();
		busesWindowController.setJButtonsMouseListener();
	}
	
	public BusesWindowController getBusesWindowController()
	{
		return busesWindowController;
	}
	
	public void runBusThread()
	{
		busThread = new BusThread();
		busThread.start();
	}
	
	public void cretaeRefreshTableThread() 
	{
		refreshTableThread = new RefreshTableThread();
	}
	
	public void startRefreshTableThread()
	{
		refreshTableThread.start();
	}
	
	public void interruptRefreshTableThread()
	{
		refreshTableThread.setInterrupt();
	}
	
	public RefreshTableThread getRefreshTableThread()
	{
		return refreshTableThread;
	}

	public void sendInitialValuesRequest()
	{
		PublicTransportCenter pTC = null;
		connectionWindowController.getConnectionWindow().getMainJP().addTextInformationJTA("-----------------------");
		connectionWindowController.getConnectionWindow().getMainJP().addTextInformationJTA("Try connect.");
		connectionWindowController.getConnectionWindow().getMainJP().addTextInformationJTA("-----------------------");
		
		initialValuesConnection = new InitialValuesConnection(connectionWindowController.getConnectionWindow());
		
		try {
			pTC = initialValuesConnection.sendInitialValuesRequest(connectionWindowController.getConnectionWindow());
		} catch (NullPointerException e) {
			System.err.println("Null object receive.");
			e.printStackTrace();
		}
		
		if(pTC != null)
		{
			this.pTC.setPublicTransportCenter(pTC);
			connectionWindowController.getConnectionWindow().getButtonsJP().setEnableStartSystemJB(true);
			connectionWindowController.getConnectionWindow().getMainJP().refreshState(true);
		}else
		{
			connectionWindowController.getConnectionWindow().getMainJP().addTextInformationJTA("Error loading initial values.");
		}
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return getCentralSystem();
	}
}
