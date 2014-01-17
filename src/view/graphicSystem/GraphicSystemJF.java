package view.graphicSystem;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import controller.graphicSystem.GraphicSystemJButtonsML;
import controller.graphicSystem.GraphicSystemJComboBoxIL;

/**
 * @author Alexis Cuero Losada
 * This class extends of JFrame and is used for show the JPanels that contains the Components for show a graphic
 * representation of the system.
 */
public class GraphicSystemJF extends JFrame {

	private static final long serialVersionUID = -8043955655321742330L;
	
	private ButtonsJP buttonsJP;
	private MapJP mapJP;
	private ToolsJP toolsJP;
	
	/**
	 * Constructor that instance the elements into this JFrame.
	 */
	public GraphicSystemJF() {
		setTitle("System Map");
		setSize(400, 200);
		setApareance();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	private void setApareance() {
		setLayout(new BorderLayout());
		buttonsJP = new ButtonsJP();
		mapJP = new MapJP();
		toolsJP = new ToolsJP();
		add(toolsJP, BorderLayout.NORTH);
		add(mapJP, BorderLayout.CENTER);
		add(buttonsJP, BorderLayout.SOUTH);
	}

	/**
	 * Returns the {@link ButtonsJP} instance create in this JFrame.
	 * @return the {@link ButtonsJP} instance
	 */
	public ButtonsJP getButtonsJP() {
		return buttonsJP;
	}

	/**
	 * Returns the {@link MapJP} instance create in this JFrame.
	 * @return the {@link MapJP} instance
	 */
	public MapJP getMapJP() {
		return mapJP;
	}

	/**
	 * Returns the {@link ToolsJP} instance create in this JFrame.
	 * @return the {@link ToolsJP} instance
	 */
	public ToolsJP getToolsJP() {
		return toolsJP;
	}
	
	/**
	 * Sets the class for handle the mouseListener events into this JFrame.
	 */
	public void setJButtonsMouseListener()
	{
		GraphicSystemJButtonsML mouseListener = new GraphicSystemJButtonsML();
		buttonsJP.setJButtonsMouseListener(mouseListener);
	}

	/**
	 * Sets the class for handle the itemListener events into this JFrame.
	 */
	public void setJComboBoxItemListener() {
		GraphicSystemJComboBoxIL itemListener = new GraphicSystemJComboBoxIL();
		toolsJP.getRoutesJCB().addItemListener(itemListener);
	}
}
