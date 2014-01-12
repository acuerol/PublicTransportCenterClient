package view.windowCreation;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonsJP extends JPanel {
	public static final String EXIT = "Exit";
	public static final String SHOW_BUSES = "Show Buses";
	public static final String SHOW_GRAPHIC_SYSTEM = "Show Graphic System";

	private JButton exitJB;
	private JButton showBusesJB;
	private JButton showGraphicSystemJB;
	
	public ButtonsJP() {
		setLayout(new FlowLayout());
		setElements();
	}

	private void setElements() {
		exitJB = new JButton(EXIT);
		showBusesJB = new JButton(SHOW_BUSES);
		showGraphicSystemJB = new JButton(SHOW_GRAPHIC_SYSTEM);
		
		add(showBusesJB);
		add(showGraphicSystemJB);
		add(exitJB);

	}

	public JButton getShowGraphicSystemJB() {
		return showGraphicSystemJB;
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
		showGraphicSystemJB.addMouseListener(mouseListener);;
	}

}
