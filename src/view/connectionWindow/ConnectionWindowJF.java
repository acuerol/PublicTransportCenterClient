package view.connectionWindow;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.CentralSystem;
import controller.connectionWindow.ConnectionWindowJButtonsML;
import model.PublicTransportCenter;

/**
 * 
 * @author Alexis Cuero Losada
 * 
 */
public class ConnectionWindowJF extends JFrame {

	private static final long serialVersionUID = 3569827843202487590L;

	private CentralSystem centralSystem;
	private ConnectionWindowMainJP mainJP;
	private ConnectionWindowButtonsJP buttonsJP;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Instance all components in the MainWindowJF.
	 */
	private void setAppearance() {
		mainJP = new ConnectionWindowMainJP();
		buttonsJP = new ConnectionWindowButtonsJP();

		add(mainJP, BorderLayout.CENTER);
		add(buttonsJP, BorderLayout.SOUTH);
	}

	public void setJButtonsMouseListeners() {
		ConnectionWindowJButtonsML mouseListener = new ConnectionWindowJButtonsML();
		buttonsJP.setJButtonsMouseListener(mouseListener);
	}

	public ConnectionWindowMainJP getMainJP() {
		return mainJP;
	}

	public ConnectionWindowButtonsJP getButtonsJP() {
		return buttonsJP;
	}
}
