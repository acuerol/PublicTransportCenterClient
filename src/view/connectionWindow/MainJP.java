package view.connectionWindow;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Alexis Cuero Losada
 * This class extends of JPanel and is used for contain the principal elements in the {@link ConnectionWindowJF}.
 */
public class MainJP extends JPanel {

	private static final long serialVersionUID = -8659240175619229371L;
	
	private JLabel stateJL;
	private JTextArea informationJTA;
	private JScrollPane scrollJSP;

	/**
	 * Constructor that instance the elements into this JPanel.
	 */
	public MainJP() {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		setElements();
	}

	private void setElements() {
		setBorder(BorderFactory.createTitledBorder("Information"));

		stateJL = new JLabel("Disconnected.");

		informationJTA = new JTextArea("");
		informationJTA.setEditable(false);

		scrollJSP = new JScrollPane(informationJTA);

		add(stateJL, BorderLayout.NORTH);
		add(scrollJSP, BorderLayout.CENTER);
	}

	/**
	 * Refresh the text in the JLabel stateJL with the connection state.
	 * @param state the connection state.
	 */
	public void refreshState(boolean state) {
		if (state) {
			stateJL.setText("Connected");
		} else {
			stateJL.setText("Disconnected");
		}
	}

	/**
	 * Adds the message to the informationJTA.
	 * @param text the message to add in the reportJTA.
	 */
	public void addTextInformationJTA(String text) {
		informationJTA.setText(informationJTA.getText() + "\n" + text);
	}

	/**
	 * Refresh (erase all text in the reportJTA) with the message.
	 * @param message the message to set in the reportJTA.
	 */
	public void refreshReport(String message) {
		informationJTA.setText(message);
	}
}
