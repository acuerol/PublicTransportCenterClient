package controller.connectionWindow;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import controller.CentralSystem;
import view.connectionWindow.ButtonsJP;

/**
 * 
 * @author Alexis Cuero Losada
 * This class implements MouseListener for handle the event on the JButtons in the connectionWindowJF.  
 */
public class ConnectionWindowJButtonsML implements MouseListener {

	private ConnectionWindowController connectionWindowController;

	/**
	 * Creates a listener for the buttons on ConnectionWindowJF.
	 */
	public ConnectionWindowJButtonsML() {
		connectionWindowController = CentralSystem.getCentralSystem()
				.getConnectionWindowController();
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		CentralSystem centralSystem = CentralSystem.getCentralSystem();
		JButton source = (JButton) event.getSource();
		ButtonsJP buttonsJP = connectionWindowController
				.getConnectionWindow().getButtonsJP();

		if (source.equals(buttonsJP.getConnectJB())) {
			centralSystem.sendInitialValuesRequest();
		} else {
			if (source.equals(buttonsJP.getStartSystemJB()) && buttonsJP.getStartSystemJB().isEnabled()) {
				connectionWindowController.getConnectionWindow().dispose();
				centralSystem.createWindowCreationController();
				centralSystem.createReportConnectionThread();
				centralSystem.createBusThread();
			} else {
				if (source.equals(buttonsJP.getExitJB())) {
					connectionWindowController.getConnectionWindow().dispose();
					System.exit(0);
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
}
