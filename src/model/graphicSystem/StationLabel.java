package model.graphicSystem;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Route;
import model.Station;

/**
 * @author Alexis Cuero Losada
 * Abstract class extends of JLabel, this class allow associate a station instance to JLabel for get the attributes
 * easily.
 */
public class StationLabel extends JLabel {

	private static final long serialVersionUID = -2448634885352580512L;
	/**
	 * The pathName of image for the true state.
	 */
	public static final String STATION_TRUE_IMAGE = "images/stationTrue.png";
	/**
	 * The pathName of image for the false state.
	 */
	public static final String STATION_FALSE_IMAGE = "images/stationFalse.png";
	
	private Route route;
	private Station station;
	private int positionInPanel;
	
	/**
	 * Constructor with the main parameters, the width of the panel and the semaphore and route instances associated.
	 * @param station the station instance associated to the label
	 * @param route the route associate to the label
	 * @param panelWidth  the panel with that contains the label
	 */
	public StationLabel(Station station, Route route, int panelWidth) {
		this.station = station;
		this.route = route;
		calculatePositionInPanel(panelWidth);
		setLabelImage();
	}
	
	private void setLabelImage() {
		if(station.getState())
		{
			setIcon(new ImageIcon(STATION_TRUE_IMAGE));
		} else
		{
			setIcon(new ImageIcon(STATION_FALSE_IMAGE));
		}	
	}

	private void calculatePositionInPanel(int panelWidth) {
		panelWidth -= 20;
		double width = route.getWay().getDistances().get(route.getWay().getDistances().size() - 1);
		int index = route.getWay().getNodes().indexOf(station);
		double position = route.getWay().getDistances().get(index);
		
		positionInPanel = (int) Math.floor(((panelWidth * position) / width));
	}
	
	@Override
	public int getX() {
		return positionInPanel;
	}
}
