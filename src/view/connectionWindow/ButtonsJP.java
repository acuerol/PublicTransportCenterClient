package view.connectionWindow;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Alexis Cuero Losada
 * This class extends of JPanel is used for contain the JButtons for connect, start the system and close the program.  
 */
public class ButtonsJP extends JPanel {

	private static final long serialVersionUID = 704879308197734584L;
	
	private JButton connectJB;
	private JButton exitJB;
	private JButton startSystemJB;

	/**
	 * Constructor that set elements into the this JPanel.
	 */
	public ButtonsJP() {
		setLayout(new FlowLayout());
		setBackground(Color.WHITE);
		setElements();
	}

	private void setElements() {
		connectJB = new JButton("Connect");
		startSystemJB = new JButton("Start System");
		startSystemJB.setEnabled(false);
		exitJB = new JButton("Exit");

		add(connectJB);
		add(startSystemJB);
		add(exitJB);
	}

	/**
	 * Enables or Disables the JButton startSystemJB depending of the state.
	 * @param state the state of button (enable or disable).
	 */
	public void setEnableStartSystemJB(boolean state) {
		startSystemJB.setEnabled(state);
	}

	/**
	 * Enables or Disables the JButton connectJB depending of the state.
	 * @param state the state of button (enable or disable).
	 */
	public void setEnableConnectJB(boolean state) {
		connectJB.setEnabled(state);
	}

	/**
	 * Adds a ActionListener to the JButton connectJB.
	 * @param mouseListener the MouseListener for connectJB.
	 */
	public void setJButtonsMouseListener(MouseListener mouseListener) {
		connectJB.addMouseListener(mouseListener);
		startSystemJB.addMouseListener(mouseListener);
		exitJB.addMouseListener(mouseListener);
	}

	/**
	 * Returns the JButton connectJB.
	 * @return the JButton connectJB
	 */
	public JButton getConnectJB() {
		return connectJB;
	}

	/**
	 * Returns the JButton exitJB.
	 * @return the JButton exitJB
	 */
	public JButton getExitJB() {
		return exitJB;
	}

	/**
	 * Returns the JButton startSystemJB.
	 * @return the JButton startSystemJB
	 */
	public JButton getStartSystemJB() {
		return startSystemJB;
	}
}
