package view.graphicSystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

import controller.graphicSystem.GraphicSystemJButtonsML;
import controller.graphicSystem.GraphicSystemJComboBoxIL;

public class GraphicSystemJF extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8043955655321742330L;
	private ButtonsJP buttonsJP;
	private MapJP mapJP;
	private ToolsJP toolsJP;
	private JScrollPane scrollJSP;
	
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
	 * @return the buttonsJP
	 */
	public ButtonsJP getButtonsJP() {
		return buttonsJP;
	}

	/**
	 * @return the mapJP
	 */
	public MapJP getMapJP() {
		return mapJP;
	}

	/**
	 * @return the barJP
	 */
	public ToolsJP getToolsJP() {
		return toolsJP;
	}
	
	public void setJButtonsMouseListener()
	{
		GraphicSystemJButtonsML mouseListener = new GraphicSystemJButtonsML();
		buttonsJP.setJButtonsMouseListener(mouseListener);
	}

	public void setJComboBoxItemListener() {
		GraphicSystemJComboBoxIL itemListener = new GraphicSystemJComboBoxIL();
		toolsJP.getRoutesJCB().addItemListener(itemListener);
	}
}
