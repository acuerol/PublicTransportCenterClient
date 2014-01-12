package view.map;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.PublicTransportCenter;

public class MapJP extends JPanel {

	private Graphics graphics;

	public MapJP() {
		setLayout(new BorderLayout());
		setElements();
	}

	private void setElements() {
		graphics = getGraphics();

		graphics.drawLine(0, 0, 100, 100);
	}
}
