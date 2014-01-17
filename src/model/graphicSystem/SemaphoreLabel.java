package model.graphicSystem;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.Route;
import model.Semaphore;

/**
 * @author Alexis Cuero Losada
 * Abstract class extends of JLabel, this class allow associate a semaphore and a route instance to JLabel for get the attributes
 * easily.
 */
public class SemaphoreLabel extends JLabel {

	private static final long serialVersionUID = 772964237206982817L;
	
	/**
	 * The pathName of image for the green light.
	 */
	public static final String RED_LIGHT_IMAGE = "images/redLight.png";
	/**
	 * The pathName of image for the red light.
	 */
	public static final String GREEN_LIGHT_IMAGE = "images/greenLight.png";
	
	private Semaphore semaphore;
	private Route route;
	private int positionInPanel;
	
	/**
	 * Constructor with the main parameters, the width of the panel and the semaphore and route instances associated.
	 * @param semaphore the semaphore associate to the label
	 * @param route the route associate to the label
	 * @param panelWidth  the panel with that contains the label
	 */
	public SemaphoreLabel(Semaphore semaphore, Route route, int panelWidth) {
		this.semaphore = semaphore;
		this.route = route;
		calculatePositionInPanel(panelWidth);
		setLabelImage();
		
	}

	private void setLabelImage() {
		if(semaphore.getState())
		{
			setIcon(new ImageIcon(GREEN_LIGHT_IMAGE));
		} else {
			setIcon(new ImageIcon(RED_LIGHT_IMAGE));
		}
		
	}

	private void calculatePositionInPanel(int panelWidth) {
		panelWidth -= 20;
		double width = route.getWay().getDistances().get(route.getWay().getDistances().size() - 1);
		int index = route.getWay().getNodes().indexOf(semaphore);
		double position = route.getWay().getDistances().get(index);
		
		positionInPanel = (int) Math.floor(((panelWidth * position) / width));
	}
	
	/**
	 * Returns the semaphore instance associated.
	 * @return the semaphore
	 */
	public Semaphore getSemaphore() {
		return semaphore;
	}

	/**
	 * Returns the route instance associated.
	 * @return the route
	 */
	public Route getRoute() {
		return route;
	}

	/**
	 * Returns the relative position in the panel. 
	 * @return the positionInPanel
	 */
	public int getPositionInPanel() {
		return positionInPanel;
	}

	@Override
	public int getX() {
		return positionInPanel;
	}
}
