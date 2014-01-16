package view.graphicSystem;

import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import util.UtilCalc;
import model.PublicTransportCenter;
import model.Route;

public class ToolsJP extends JPanel {

	private JLabel selectRoute;
	private JComboBox<String> routesJCB;
	private JSlider sliderJS;
	
	public ToolsJP() {
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
		sliderJS = new JSlider(0, (int) Math.round(getSliderMaxValue()), 0); 
		
		add(selectRoute);
		add(routesJCB);
		add(sliderJS);
	}
	
	public double getSliderMaxValue()
	{
		Route route = PublicTransportCenter.getPublicTransportCenter().getRouteByName((String) routesJCB.getSelectedItem());
		return route.getDistance();
	}
	
	public void setJComboBoxListener(ItemListener itemListener)
	{
		routesJCB.addItemListener(itemListener);
	}

	/**
	 * @return the routesJCB
	 */
	public JComboBox<String> getRoutesJCB() {
		return routesJCB;
	}

	/**
	 * @return the sliderJS
	 */
	public JSlider getSliderJS() {
		return sliderJS;
	}
	
	
}
