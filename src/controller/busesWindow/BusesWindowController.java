package controller.busesWindow;

import javax.swing.JTable;

import model.Bus;
import model.PublicTransportCenter;
import util.Alert;
import view.busesWindow.BusesWindowJF;
import view.busesWindow.BusesWindowJTableModel;
import view.busesWindow.BusesWindowButtonsJP;

/**
 * 
 * @author Alexis Cuero Losada
 * 
 */
public class BusesWindowController {

	private BusesWindowJF busesWindow;

	public BusesWindowController() {
		busesWindow = new BusesWindowJF();
	}

	public Object[][] generateData() {
		PublicTransportCenter pTC = PublicTransportCenter.getPublicTransportCenter();
		int numBuses = pTC.getBuses().size();
		Object[][] data = new Object[numBuses][8];

		for (int i = 0; i < numBuses; i++) {
			data[i] = pTC.getBuses().get(i).toArray();
		}

		return data;
	}
	
	public void refreshTable(int selectedRow) {
		JTable busesJT = busesWindow.getTableJP().getBusesJT();
		BusesWindowJTableModel tableModel = busesWindow.getTableJP()
				.getTableModel();
		Object[][] data = generateData();

		tableModel.setData(data);
		busesJT.repaint();

		busesJT.setColumnSelectionInterval(0, 0);

		if (selectedRow >= 0) {
			busesJT.setRowSelectionInterval(selectedRow, selectedRow);
		}
	}
	
	public void sendBusSelected() {
		PublicTransportCenter pTC = PublicTransportCenter.getPublicTransportCenter();
		String id = busesWindow.getTableJP().getSelectedBusID();

		if (!id.equals("")) {
			if (!pTC.getBusByID(id).getState()) {
				pTC.getBusByID(id).setState(true);
			} else {
				Alert.launchErrorMessage("The bus is running.", busesWindow);
			}
		} else {
			Alert.launchErrorMessage("Please select a bus.", busesWindow);
		}

		PublicTransportCenter.setPublicTransportCenter(pTC);
	}

	public void stopBusSelected() {
		PublicTransportCenter pTC = PublicTransportCenter.getPublicTransportCenter();
		String id = busesWindow.getTableJP().getSelectedBusID();

		if (!id.equals("")) {
			if (pTC.getBusByID(id).getState()) {
				pTC.getBusByID(id).setState(false);
			} else {
				Alert.launchErrorMessage("The bus is stopped.", busesWindow);
			}
		} else {
			Alert.launchErrorMessage("Please select a bus.", busesWindow);
		}
		
		PublicTransportCenter.setPublicTransportCenter(pTC);
	}
	
	public void setJButtonsMouseListener() {
		BusesWindowJButtonsML mouseListener = new BusesWindowJButtonsML();
		busesWindow.getButtonsJP().setButtonsMouseListener(mouseListener);
	}
	
	public BusesWindowJF getBusesWindow() {
		return busesWindow;
	}
}
