package view.graphicSystem;

import java.awt.FlowLayout;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import model.PublicTransportCenter;

public class BarJP extends JPanel {

	private JComboBox<String> routesJCB;

	public BarJP() {
		setLayout(new FlowLayout());
		setElements();
	}

	private void setElements() {
		PublicTransportCenter pTC = PublicTransportCenter
				.getPublicTransportCenter();
		routesJCB = new JComboBox<String>(pTC.getRoutesName().toArray(new String[0]));
		routesJCB.addItem("All routes.");
		routesJCB.setSelectedItem("All routes.");
		add(routesJCB);
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
	
	
}
