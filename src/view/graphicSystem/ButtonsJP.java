package view.graphicSystem;

import java.awt.FlowLayout;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsJP extends JPanel {

	private JButton exitJB;

	public ButtonsJP() {
		setLayout(new FlowLayout());
		setElements();
	}

	private void setElements() {
		exitJB = new JButton("Exit");

		add(exitJB);
	}

	public void setJButtonsMouseListener(MouseListener mouseListener) {
		exitJB.addMouseListener(mouseListener);
	}

	/**
	 * @return the exitJB
	 */
	public JButton getExitJB() {
		return exitJB;
	}

}
