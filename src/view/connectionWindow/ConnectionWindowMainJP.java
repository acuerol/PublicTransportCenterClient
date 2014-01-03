package view.connectionWindow;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ConnectionWindowMainJP extends JPanel {
	private JLabel stateJL;
	private JTextArea informationJTA;
	private JScrollPane scrollJSP;
	
	public ConnectionWindowMainJP() {
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
	 * Refrehs the text in the JLabel stateJL with the connection state.
	 * @param state the connection state.
	 */
	public void refreshState(boolean state)
	{
		if(state)
		{
			stateJL.setText("Connected");
		}
		else
		{
			stateJL.setText("Disconnected");
		}
	}
	
	/**
	 * Adds the message to the informationJTA.
	 * @param message the message to add in the reportJTA.
	 */
	public void addTextInformationJTA(String text)
	{
		informationJTA.setText(informationJTA.getText() + "\n" + text);
	}
	
	/**
	 * Refresh (erase all text in the reportJTA) with the message.
	 * @param message the message to set in the reportJTA.
	 */
	public void refreshReport(String message)
	{
		informationJTA.setText(message);
	}
}
