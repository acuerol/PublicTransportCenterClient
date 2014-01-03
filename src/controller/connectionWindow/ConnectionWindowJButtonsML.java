package controller.connectionWindow;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import controller.CentralSystem;
import view.connectionWindow.ConnectionWindowButtonsJP;

/**
 * 
 * @author Alexis Cuero Losada
 *
 */
public class ConnectionWindowJButtonsML implements MouseListener {
	
	private CentralSystem centralSystem;
	private ConnectionWindowController connectionWindowController;
	
	/**
	 * Creates a listener for the buttons on ConnectionWindowJF.
	 */
	public ConnectionWindowJButtonsML()
	{
		this.centralSystem = CentralSystem.getCentralSystem();
		this.connectionWindowController = centralSystem.getConnectionWindowController();
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		JButton source = (JButton) event.getSource();
		ConnectionWindowButtonsJP buttonsJP = connectionWindowController.getConnectionWindow().getButtonsJP();  
		
		if(source.equals(buttonsJP.getConnectJB()))
		{
			centralSystem.sendInitialValuesRequest();
		}
		else
		{
			if(source.equals(buttonsJP.getExitJB()))
			{
				connectionWindowController.getConnectionWindow().dispose();
				centralSystem.createWindowCreationController();
			}else
			{
				if(source.equals(buttonsJP.getStartSystemJB()))
				{
					connectionWindowController.getConnectionWindow().dispose();
					centralSystem.createWindowCreationController();
					centralSystem.createReportConnectionThread();
					centralSystem.runBusThread();
				}				
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
