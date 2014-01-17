package controller.graphicSystem;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import view.graphicSystem.ButtonsJP;
import controller.CentralSystem;

/**
 * 
 * @author Alexis Cuero Losada
 * This class implements MouseListener for handle the events above the buttons in the GraphicSystemJF.
 */
public class GraphicSystemJButtonsML implements MouseListener {

	private ButtonsJP buttonsJP;
	private GraphicSystemController graphicSystemController;

	@Override
	public void mouseClicked(MouseEvent event) {
		CentralSystem centralSystem = CentralSystem.getCentralSystem();
		graphicSystemController = centralSystem.getGraphicSystemController();
		buttonsJP = graphicSystemController.getGraphicSystemJF().getButtonsJP();
		JButton source = (JButton) event.getSource();

		if (source.equals(buttonsJP.getCloseJB())) {
			graphicSystemController.getGraphicSystemJF().dispose();
			centralSystem.interruptRefreshSystemGraphicThread();
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}
