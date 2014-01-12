package view.map;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MapJF extends JFrame {

	private ButtonsJP buttonsJP;
	private MapJP mapJP;
	private BarJP barJP;

	public MapJF() {
		setTitle("System Map");
		setSize(400, 400);
		setApareance();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void setApareance() {
		setLayout(new BorderLayout());
		buttonsJP = new ButtonsJP();
		mapJP = new MapJP();
		barJP = new BarJP();

		add(barJP, BorderLayout.NORTH);
		add(mapJP, BorderLayout.CENTER);
		add(buttonsJP, BorderLayout.SOUTH);
	}

	/**
	 * @return the buttonsJP
	 */
	public ButtonsJP getButtonsJP() {
		return buttonsJP;
	}

	/**
	 * @return the mapJP
	 */
	public MapJP getMapJP() {
		return mapJP;
	}

	/**
	 * @return the barJP
	 */
	public BarJP getBarJP() {
		return barJP;
	}

}
