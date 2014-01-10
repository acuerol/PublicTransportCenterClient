package view.busesWindow;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.plaf.SliderUI;

import controller.CentralSystem;
import controller.busesWindow.BusesWindowController;
import controller.threads.BusThread;
import model.PublicTransportCenter;

/**
 * 
 * @author Alexis Cuero Losada
 *
 */
public class BusesWindowTableJP extends JPanel {
	private JTable busesJT;
	private CentralSystem centralSystem;
	private BusesWindowController busesWindowController;
	private JScrollPane scroll;
	private BusesWindowJTableModel tableModel;
	private Object[][] data;
	
	public BusesWindowTableJP()
	{
		centralSystem = CentralSystem.getCentralSystem();
		
		setElements();
	}
	
	public JTable getBusesJT()
	{
		return busesJT;
	}
	
	private void setElements()
	{
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Buses Information"));
		
		data = new Object[1][11];
		String[] columnsNames = {"id", "Driver", "Plate", "Route", "Next Stop Station","State","Speed", "Position", "Next Node", "Movement State", "Acceleration"};
		
		tableModel = new BusesWindowJTableModel(columnsNames, data);
		busesJT = new JTable(tableModel);
		scroll = new JScrollPane(busesJT);
		
		busesJT.setFillsViewportHeight(true);
		
		add(scroll, BorderLayout.CENTER);
	}
	
	public BusesWindowJTableModel getTableModel() {
		return tableModel;
	}
	
	public String getSelectedBusID()
	{
		int selectedRow = busesJT.getSelectedRow();

		if(selectedRow >= 0)
		{
			String id = (String) busesJT.getModel().getValueAt(selectedRow, 0);
			return id;
		}
		
		return "";
	}
}
