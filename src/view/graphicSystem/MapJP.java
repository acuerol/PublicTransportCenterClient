package view.graphicSystem;

import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import controller.CentralSystem;
import model.graphicSystem.BusLabel;
import model.graphicSystem.SemaphoreLabel;
import model.graphicSystem.StationLabel;

public class MapJP extends JPanel {

	public static final int STATIONS_HEIGTH = 45;
	public static final int BUSES_HEIGTH = 60;
	public static final int SEMAPHORES_HEIGTH = 50;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7600650443894000489L;
	
	public MapJP() {
		setLayout(null);
		setBorder(BorderFactory.createTitledBorder("Map"));
	}

	public void addNodes(ArrayList<BusLabel> busesLabel, ArrayList<StationLabel> stationsLabel, ArrayList<SemaphoreLabel> semaphoresLabel, int num) {
		int iconHeightMid = 0;
		int iconWidthMid = 0;
		int iconHeight = 0;
		int iconWidth = 0;
		int sliderMin = 0;
		int sliderMax = 0;
		
		if(num == 1)
		{
//			sliderMin = CentralSystem.getCentralSystem().getGraphicSystemController().getGraphicSystemJF().getToolsJP().getSliderJS().getValue();
//			sliderMax = sliderMin + 400;
			removeAll();
		}
		
		for (BusLabel busLabel : busesLabel) {
			iconHeight = busLabel.getIcon().getIconHeight();
			iconWidth = busLabel.getIcon().getIconWidth();
			iconHeightMid = iconHeight / 2;
			iconWidthMid = iconWidth / 2;
			busLabel.setBounds(busLabel.getX() - iconWidthMid, BUSES_HEIGTH - iconHeightMid, iconWidth, iconHeight);
			add(busLabel);
		}
		
		for (SemaphoreLabel semaphoreLabel : semaphoresLabel) {
			iconHeight = semaphoreLabel.getIcon().getIconHeight();
			iconWidth = semaphoreLabel.getIcon().getIconWidth();
			iconHeightMid = iconHeight / 2;
			iconWidthMid = iconWidth/ 2;
			
			if(semaphoreLabel.getBounds().y > 100)
			{
				System.out.println(semaphoreLabel.getSemaphore().getId());
			}
			
			semaphoreLabel.setBounds(semaphoreLabel.getX() - iconWidthMid , SEMAPHORES_HEIGTH - iconHeightMid, iconWidth, iconHeight);
			add(semaphoreLabel);
		}
		
		for (StationLabel stationLabel : stationsLabel) {
			iconHeight = stationLabel.getIcon().getIconHeight();
			iconWidth = stationLabel.getIcon().getIconWidth();
			iconHeightMid = iconHeight / 2;
			iconWidthMid = iconWidth/ 2;
			
			stationLabel.setBounds(stationLabel.getX() - iconWidthMid, STATIONS_HEIGTH - iconHeightMid, iconWidth, iconHeight);
			add(stationLabel);
		}
		
		repaint();
	}
}
