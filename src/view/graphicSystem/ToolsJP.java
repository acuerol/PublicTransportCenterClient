package view.graphicSystem;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import model.PublicTransportCenter;

/**
 * @author Alexis Cuero Losada
 * This class extends of JPanel is use for contain the element for filter the JLabel shown in the
 * GraphicSystemJF. 
 */
public class ToolsJP extends JPanel {

	private static final long serialVersionUID = 8088343923805856644L;
	
	private JLabel selectRoute;
	private JComboBox<String> routesJCB;
	private JSlider sliderJS;
	
	/**
	 * Constructor that instance the elements into this JPanel.
	 */
	public ToolsJP() {
		setBackground(Color.WHITE);
		setLayout(new FlowLayout());
		setElements();
	}

	private void setElements() {
		PublicTransportCenter pTC = PublicTransportCenter
				.getPublicTransportCenter();
		ArrayList<String> routesNames = new ArrayList<String>();
		
		selectRoute = new JLabel("Select route: ");
		routesNames.addAll(pTC.getRoutesName());
		
		routesJCB = new JComboBox<String>(routesNames.toArray(new String[0]));
		
		add(selectRoute);
		add(routesJCB);
//		add(sliderJS);
	}

	/**
	 * Returns the JComboBox instanced in this class.
	 * @return the routesJCB
	 */
	public JComboBox<String> getRoutesJCB() {
		return routesJCB;
	}

	/**
	 * Returns the Slider instanced in this class.
	 * @return the sliderJS
	 */
	public JSlider getSliderJS() {
		return sliderJS;
	}
	
	/**
	 * Sets the ItemListener for handle the item events into the routesJCB.
	 * @param itemListener the ItemListener for handle the item events
	 */
	public void setJComboBoxListener(ItemListener itemListener)
	{
		routesJCB.addItemListener(itemListener);
	}
}
