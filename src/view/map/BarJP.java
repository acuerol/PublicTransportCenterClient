package view.map;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import model.PublicTransportCenter;

public class BarJP extends JPanel {

	private JComboBox<String> routes;
	
	public BarJP() {
		setLayout(new FlowLayout());
		setElements();
	}

	private void setElements() {
		PublicTransportCenter pTC = PublicTransportCenter.getPublicTransportCenter();
		routes = new JComboBox<String>(pTC.getRoutes().toArray(new String[0]));
		
		add(routes);
	}
}
