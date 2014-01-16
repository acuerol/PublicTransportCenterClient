package view.graphicSystem;

import java.awt.FlowLayout;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsJP extends JPanel {

	private JButton closeJB;

	public ButtonsJP() {
		setLayout(new FlowLayout());
		setElements();
	}

	private void setElements() {
		closeJB = new JButton("Close");

		add(closeJB);
	}

	public void setJButtonsMouseListener(MouseListener mouseListener) {
		closeJB.addMouseListener(mouseListener);
	}

	/**
	 * @return the exitJB
	 */
	public JButton getCloseJB() {
		return closeJB;
	}

}
