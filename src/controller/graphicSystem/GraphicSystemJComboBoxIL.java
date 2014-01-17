package controller.graphicSystem;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import controller.CentralSystem;

/**
 * @author Alexis Cuero Losada
 * This class implements ItemListener and handle the event of the JComboBox for filter
 * the buses shown in the GraphicSystemWindowJF.
 */
public class GraphicSystemJComboBoxIL implements ItemListener {

	@Override
	public void itemStateChanged(ItemEvent event) {
		CentralSystem centralSystem = CentralSystem.getCentralSystem();
		centralSystem.getGraphicSystemController().refreshGraphic();
	}

}
