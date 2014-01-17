package controller.windowCreation;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JFrame;

import model.Bus;
import model.Driver;
import model.PublicTransportCenter;
import model.Route;
import view.windowCreation.WindowCreationJF;
import util.Alert;
import util.Util;

/**
 * @author Alexis Cuero Losada
 * Controller for the window creation.
 */
public class WindowCreationController {
	private WindowCreationJF windowCreation;

	/**
	 * Creates a WindowCreationController instance for get windowCreation data.
	 */
	public WindowCreationController() {
		PublicTransportCenter pTC = PublicTransportCenter.getPublicTransportCenter();
		ArrayList<String> drivers = pTC.getDriversName();
		ArrayList<String> routes = pTC.getRoutesName();
		windowCreation = new WindowCreationJF(drivers, routes);
		windowCreation.getBusCreationJSP().setImage();
		windowCreation.getDriverCreationJSP().setImage();
	}

	/**
	 * Returns the windowCreationJF instance..
	 * @return the windowCreationJF instance.
	 */
	public WindowCreationJF getWindowCreation() {
		return windowCreation;
	}

	/**
	 * return true if the bus was created successful, if the bus exist then
	 * return false.
	 * 
	 * @param id
	 *            the bus's id.
	 * @param driver
	 *            the bus's driver name.
	 * @param plate
	 *            the bus's plate.
	 * @param route
	 *            the bus's route name.
	 * @param position
	 *            the bus's position.
	 * @param parent the parent send the alerts.
	 * @return true if the bus was created, else return false.
	 */
	public boolean addNewBus(String id, String driver, String plate, String route, String position, JFrame parent) {
		PublicTransportCenter pTC = PublicTransportCenter.getPublicTransportCenter();
		Driver tempDriver = pTC.getDriverByName(driver);
		Route tempRoute = pTC.getRouteByName(route);
		double tempPosition = Double.parseDouble(position);

		Bus bus = new Bus(id, tempDriver, plate, tempRoute, 0, tempPosition, true);
		bus.setStartTime(GregorianCalendar.getInstance());

		if(!pTC.getBuses().contains(bus))
		{
			pTC.addBus(bus);
			PublicTransportCenter.setPublicTransportCenter(pTC);
			return true;
		}
		
		Alert.launchErrorMessage("The bus exits.", parent);
		return false;
	}

	/**
	 * return true if the driver was created successful, if the driver exist
	 * then return false.
	 * 
	 * @param id the driver's id.
	 * @param name the driver's name.
	 * @param lastName the driver's lastName.
	 * @param parent the parent send the alerts.
	 * @return true if was created or false if not.
	 */
	public boolean addNewDriver(String id, String name, String lastName, JFrame parent) {
		PublicTransportCenter pTC = PublicTransportCenter.getPublicTransportCenter();
		Driver driver = new Driver(id, name, lastName);
		
		if(pTC.getDrivers().contains(driver))
		{
			pTC.addDriver(driver);
			refreshDrivers(name);
			return true;
		}
		
		Alert.launchErrorMessage("The driver exits.", parent);
		return false;
	}

	/**
	 * Returns a message with the fields that not be valid in the
	 * windowCreationBus.
	 * 
	 * @param id
	 *            the text of bus id field.
	 * @param driver
	 *            the text of bus driver field.
	 * @param plate
	 *            the text of bus plate field.
	 * @param route
	 *            the text of bus route field.
	 * @param position
	 *            the text of bus position field.
	 * @return a message with the invalid fields.
	 */
	public boolean checkBusFields(String id, String driver, String plate,
			String route, String position) {
		if (id.equals("") || plate.equals("") || route.equals("")) {
			return false;
		} else {
			if (!Util.isDouble(position)) {
				return false;
			} else {
				if (!Util.isPlate(plate)) {
					return false;
				}
			}
		}

		return true;
	}

	/**
	 * Returns a message with the fields that not be valid in the
	 * windowCreationDriver.
	 * 
	 * @param id
	 *            the text of driver id field.
	 * @param name
	 *            the text of driver name field.
	 * @param lastName
	 *            the text of the driver lastName field.
	 * @return a message with the invalid fields.
	 */
	public boolean checkDriverFields(String id, String name, String lastName) {
		if (id.equals("") || name.equals("") || lastName.equals("")) {
			return false;
		}

		return true;
	}

	/**
	 * Refresh in the windowCreationBus the added drivers.
	 * 
	 * @param name
	 *            the driver's name.
	 */
	private void refreshDrivers(String name) {
		windowCreation.getBusCreationJSP().getBusCreationJP().addDrivers(name);
	}

	/**
	 * Sets the JButtons MouseListener to the buttons in the WindowCreationJF. 
	 */
	public void setJButtonsMouseListener() {
		WindowCreationJButtonsML windowCreationBL = new WindowCreationJButtonsML();
		WindowCreationJTextFieldFL windowCreationFL = new WindowCreationJTextFieldFL();

		windowCreationBL.generateTestBus();
		// windowCreationBL.generateRandomDrivers(20);
		// windowCreationBL.generateRandomBuses(10);
		windowCreation.addJButtonsMouseListener(windowCreationBL);
		windowCreation.addJTextFieldFocusListener(windowCreationFL);
	}
}
