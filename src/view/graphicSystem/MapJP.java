package view.graphicSystem;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.graphicSystem.BusLabel;
import model.graphicSystem.SemaphoreLabel;
import model.graphicSystem.StationLabel;

public class MapJP extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7600650443894000489L;

	public MapJP() {
		setLayout(null);
		setBorder(BorderFactory.createTitledBorder("Map"));
	}

	public void addNodes(ArrayList<BusLabel> busesLabel, ArrayList<StationLabel> stationsLabel, ArrayList<SemaphoreLabel> semaphoresLabel, int num) {
		int iconMid = 0;
		
		if(num == 1) {
			removeAll();
		}
		
		for (BusLabel busLabel : busesLabel) {
			iconMid = busLabel.getIcon().getIconHeight() / 2;
			busLabel.setBounds(busLabel.getX(), 50 - iconMid, 20, 20);
			add(busLabel);
		}
		
		for (SemaphoreLabel semaphoreLabel : semaphoresLabel) {
			iconMid = semaphoreLabel.getIcon().getIconHeight() / 2;
			semaphoreLabel.setBounds(semaphoreLabel.getX(), 50 - iconMid, 10, 10);
			add(semaphoreLabel);
		}
		
		for (StationLabel stationLabel : stationsLabel) {
			iconMid = stationLabel.getIcon().getIconHeight() / 2;
			stationLabel.setBounds(stationLabel.getX(), 50 - iconMid, 25, 25);
			add(stationLabel);
		}
		
		repaint();
	}
}
