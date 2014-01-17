package view.busesWindow;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * @author Alexis Cuero Losada
 * Class that exteds of JPanel for contain the Jtable of JFrame.
 */
public class TableJP extends JPanel {

	private static final long serialVersionUID = -6177183054257994205L;
	
	private JTable busesJT;
	private JScrollPane scrollJSP;
	private BusesWindowJTableModel tableModel;
	private Object[][] data;

	/**
	 * Contructor that initialize the element into the JPanel.
	 */
	public TableJP() {
		setElements();
	}

	/**
	 * Returns the JTable of the panel.
	 * @return the JTable of the panel
	 */
	public JTable getBusesJT() {
		return busesJT;
	}

	private void setElements() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Buses Information"));

		data = new Object[1][11];
		String[] columnsNames = {"id", "Driver", "Plate", "Route",
				"Next Stop Station", "State", "Speed", "Position", "Next Node",
				"Movement State", "Acceleration"};

		tableModel = new BusesWindowJTableModel(columnsNames, data);
		busesJT = new JTable(tableModel);
		scrollJSP = new JScrollPane(busesJT);

		busesJT.setFillsViewportHeight(true);

		add(scrollJSP, BorderLayout.CENTER);
	}

	/**
	 * Returns the JTableModel of the JTable in the panel.
	 * @return the JTableModel of the JTable in the panel
	 */
	public BusesWindowJTableModel getTableModel() {
		return tableModel;
	}

	/**
	 * Returns the ID of the bus selected in the JTable.
	 * @return the ID of the bus selected in the JTable
	 */
	public String getSelectedBusID() {
		int selectedRow = busesJT.getSelectedRow();

		if (selectedRow >= 0) {
			String id = (String) busesJT.getModel().getValueAt(selectedRow, 0);
			return id;
		}

		return "";
	}
}
