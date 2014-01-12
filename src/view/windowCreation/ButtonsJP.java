package view.windowCreation;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsJP extends JPanel {
	public static final String EXIT = "Exit";
	public static final String SHOW_BUSES = "Show Buses";

	private JButton exitJB;
	private JButton showBusesJB;

	public ButtonsJP() {
		setLayout(new FlowLayout());
		setElements();
	}

	private void setElements() {
		exitJB = new JButton(EXIT);
		showBusesJB = new JButton(SHOW_BUSES);

		add(showBusesJB);

		add(exitJB);

	}

	public JButton getExitJB() {
		return exitJB;
	}

	public JButton getShowBusesJB() {
		return showBusesJB;
	}

	public void setJButtonsMouseListener(MouseListener mouseListener) {
		showBusesJB.addMouseListener(mouseListener);
		exitJB.addMouseListener(mouseListener);
	}

}
