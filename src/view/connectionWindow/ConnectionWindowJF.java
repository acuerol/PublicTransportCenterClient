package view.connectionWindow;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import controller.connectionWindow.ConnectionWindowJButtonsML;

/**
 * @author Alexis Cuero Losada
 * This class extends of JFrame and is the GUI for show the connection options. 
 */
public class ConnectionWindowJF extends JFrame {

	private static final long serialVersionUID = 3569827843202487590L;

	private MainJP mainJP;
	private ButtonsJP buttonsJP;

	/**
	 * Create a MainWindowJF instance.
	 */
	public ConnectionWindowJF() {
		setTitle("Public Trasport Center Client");
		setSize(350, 250);
		setLayout(new BorderLayout());
		setAppearance();
		setLocationRelativeTo(null);
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Instance all components in the MainWindowJF.
	 */
	private void setAppearance() {
		mainJP = new MainJP();
		buttonsJP = new ButtonsJP();

		add(mainJP, BorderLayout.CENTER);
		add(buttonsJP, BorderLayout.SOUTH);
	}

	/**
	 * Returns the {@link MainJP} instance in this JFrame.
	 * @return the {@link MainJP}
	 */
	public MainJP getMainJP() {
		return mainJP;
	}

	/**
	 * Returns the {@link ButtonsJP} instance in this JFrame.
	 * @return the {@link ButtonsJP}
	 */
	public ButtonsJP getButtonsJP() {
		return buttonsJP;
	}
	
	/**
	 * Sets the MouseListener class for handle the mouse events.
	 */
	public void setJButtonsMouseListeners() {
		ConnectionWindowJButtonsML mouseListener = new ConnectionWindowJButtonsML();
		buttonsJP.setJButtonsMouseListener(mouseListener);
	}
}
