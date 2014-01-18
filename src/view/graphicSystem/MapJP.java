package view.graphicSystem;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import model.graphicSystem.BusLabel;
import model.graphicSystem.SemaphoreLabel;
import model.graphicSystem.StationLabel;

/**
 * @author Alexis Cuero Losada
 * The "main" JPanel in the {@link GraphicSystemJF} this contains the JLabels that represent the elements in the 
 * System.
 */
public class MapJP extends JPanel {

	private static final long serialVersionUID = -7600650443894000489L;
	
	/**
	 * Stations icon height.
	 */
	public static final int STATIONS_HEIGTH = 45;
	/**
	 * Buses icon height.
	 */
	public static final int BUSES_HEIGTH = 60;
	/**
	 * Semaphores icon height.
	 */
	public static final int SEMAPHORES_HEIGTH = 50;
	
	/**
	 * Instances all elements into this JPanel.
	 */
	public MapJP() {
		setBackground(Color.WHITE);
		setLayout(null);
		setBorder(BorderFactory.createTitledBorder("Map"));
	}

	/**
	 * Adds the nodes to this panel.
	 * @param busesLabel the List with the instances of {@link BusLabel}
	 * @param stationsLabel the List with the instances of {@link StationLabel}
	 * @param semaphoresLabel the List with the instances of {@link SemaphoreLabel}
	 * @param num num of option
	 */
	public void addNodes(ArrayList<BusLabel> busesLabel, ArrayList<StationLabel> stationsLabel, ArrayList<SemaphoreLabel> semaphoresLabel, int num) {
		int iconHeightMid = 0;
		int iconWidthMid = 0;
		int iconHeight = 0;
		int iconWidth = 0;
//		int sliderMin = 0;
//		int sliderMax = 0;
		
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
