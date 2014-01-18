package view.windowCreation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Alexis Cuero Losada
 * This class extends of JPanel and is used for contain the JButtons for the {@link WindowCreationJF} options.
 */
public class ButtonsJP extends JPanel {

	private static final long serialVersionUID = -7781689347547769900L;
	
	private JButton exitJB;
	private JButton showBusesJB;
	private JButton showGraphicSystemJB;
	
	/**
	 * Constructor that initialize all JButtons in th panel.
	 */
	public ButtonsJP() {
		setBackground(Color.WHITE);
		setLayout(new FlowLayout());
		setElements();
	}

	private void setElements() {
		exitJB = new JButton("Exit");
		showBusesJB = new JButton("Show Buses");
		showGraphicSystemJB = new JButton("Show Graphic System");
		
		add(showBusesJB);
		add(showGraphicSystemJB);
		add(exitJB);

	}

	/**
	 * Returns the showGraphicSystemJB instance creates in this class.
	 * @return the showGraphicSystemJB instance
	 */
	public JButton getShowGraphicSystemJB() {
		return showGraphicSystemJB;
	}
	
	/**
	 * Returns the exitJB instance creates in this class.
	 * @return the exitJB instance
	 */
	public JButton getExitJB() {
		return exitJB;
	}

	/**
	 * Returns the showBusesJB instance creates in this class.
	 * @return the showBusesJB instance
	 */
	public JButton getShowBusesJB() {
		return showBusesJB;
	}

	/**
	 * Sets the MouseListener for handle the event in this class.
	 * @param mouseListener the MouseListener instance
	 */
	public void setJButtonsMouseListener(MouseListener mouseListener) {
		showBusesJB.addMouseListener(mouseListener);
		exitJB.addMouseListener(mouseListener);
		showGraphicSystemJB.addMouseListener(mouseListener);;
	}

}
