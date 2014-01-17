package model.graphicSystem;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import model.Bus;

/**
 * 
 * @author Alexis Cuero Losada
 * Abstract class extends of JLabel, this class allow associate a bus instance to JLabel for get the attributes
 * easily.
 */
public class BusLabel extends JLabel {

	private static final long serialVersionUID = -5671332487192519614L;
	
	/**
	 * The pathName of image for the true state.
	 */
	public static final String BUS_TRUE_IMAGE = "images/busTrue.png";
	/**
	 * The pathName of image for the false state.
	 */
	public static final String BUS_FALSE_IMAGE = "images/busFalse.png";
	
	private int panelWidth;
	private int positionInPanel;
	private Bus bus;
	
	/**
	 * Constructor with the main parameters, the width of the panel and the bus instance associated. 
	 * @param bus the bus for associate with the JLabel
	 * @param panelWidth the panel with that contains the label
	 */
	public BusLabel(Bus bus, int panelWidth) {
		this.bus = bus;
		this.panelWidth = panelWidth;
		calculatePositionInPanel(panelWidth);
		
		if(bus.getState())
		{
			setIcon(new ImageIcon(BUS_TRUE_IMAGE));
		} else
		{
			setIcon(new ImageIcon(BUS_FALSE_IMAGE));
		}
	}
	
	private void calculatePositionInPanel(int panelWidth) {
		panelWidth -= 20;
		double width = bus.getRoute().getWay().getDistances().get(bus.getRoute().getWay().getDistances().size() -1);
		positionInPanel = (int) Math.floor(((panelWidth * bus.getPosition()) / width));
	}
	
	/**
	 * Returns the width of the panel that contains the label.
	 * @return the panelWidth
	 */
	public int getPanelWidth() {
		return panelWidth;
	}

	/**
	 * Returns the relative position in the panel.
	 * @return the positionInPanel
	 */
	public int getPositionInPanel() {
		return positionInPanel;
	}

	/**
	 * Returns the bus instance associated.
	 * @return the bus
	 */
	public Bus getBus() {
		return bus;
	}

	@Override
	public int getX() {
		return positionInPanel;
	}
}
