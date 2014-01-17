package view.graphicSystem;

import java.awt.FlowLayout;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Alexis Cuero Losada
 * This class extends of JPanel and is used for contain the JButtons of the {@link GraphicSystemJF}. 
 */
public class ButtonsJP extends JPanel {

	private static final long serialVersionUID = 5201085521131230172L;
	private JButton closeJB;

	/**
	 * Constructor that instance the JButtons into this JPanel.
	 */
	public ButtonsJP() {
		setLayout(new FlowLayout());
		setElements();
	}

	private void setElements() {
		closeJB = new JButton("Close");

		add(closeJB);
	}

	/**
	 * @return the exitJB
	 */
	public JButton getCloseJB() {
		return closeJB;
	}

	/**
	 * Sets the class for handle the mouse events into the panel. 
	 * @param mouseListener the class for handle the mouse events into the panel
	 */
	public void setJButtonsMouseListener(MouseListener mouseListener) {
		closeJB.addMouseListener(mouseListener);
	}
}
