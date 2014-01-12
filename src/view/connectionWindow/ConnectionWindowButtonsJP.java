package view.connectionWindow;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.CentralSystem;

public class ConnectionWindowButtonsJP extends JPanel {

	public static final String CONNECT = "Connect";
	public static final String EXIT = "Exit";
	public static final String START = "Start System";

	private JButton connectJB;
	private JButton exitJB;
	private JButton startSystemJB;

	public ConnectionWindowButtonsJP() {
		setLayout(new FlowLayout());
		setBackground(Color.WHITE);
		setElements();
	}

	private void setElements() {
		connectJB = new JButton(CONNECT);
		connectJB.setActionCommand(CONNECT);

		startSystemJB = new JButton(START);
		startSystemJB.setActionCommand(START);
		startSystemJB.setEnabled(false);

		exitJB = new JButton(EXIT);
		exitJB.setActionCommand(EXIT);

		add(connectJB);
		add(startSystemJB);
		add(exitJB);
	}

	/**
	 * Enables or Disables the JButton startSystemJB depending of the state.
	 * 
	 * @param state
	 *            the state of button (enable or disable).
	 */
	public void setEnableStartSystemJB(boolean state) {
		startSystemJB.setEnabled(state);
	}

	/**
	 * Enables or Disables the JButton connectJB depending of the state.
	 * 
	 * @param state
	 *            the state of button (enable or disable).
	 */
	public void setEnableConnectJB(boolean state) {
		connectJB.setEnabled(state);
	}

	/**
	 * Adds a ActionListener to the JButton connectJB.
	 * 
	 * @param mouseListener
	 *            the ActionListener for connectJB.
	 */
	public void setJButtonsMouseListener(MouseListener mouseListener) {
		connectJB.addMouseListener(mouseListener);
		startSystemJB.addMouseListener(mouseListener);
		exitJB.addMouseListener(mouseListener);
	}

	public JButton getConnectJB() {
		return connectJB;
	}

	public JButton getExitJB() {
		return exitJB;
	}

	public JButton getStartSystemJB() {
		return startSystemJB;
	}
}
