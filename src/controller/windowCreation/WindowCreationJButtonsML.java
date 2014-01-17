package controller.windowCreation;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import controller.CentralSystem;
import model.PublicTransportCenter;
import view.windowCreation.BusCreationJP;
import view.windowCreation.ButtonsJP;
import view.windowCreation.DriverCreationJP;
import view.windowCreation.WindowCreationJF;
import util.Alert;
import util.RandomClass;

/**
 * @author Alexis Cuero Losada
 * This class implements MouseListener for handle the event on the JButtons in the windowCreationJF.
 */
public class WindowCreationJButtonsML implements MouseListener {

	private DriverCreationJP driverCreationJP;
	private BusCreationJP busCreationJP;
	private ButtonsJP buttonsJP;
	private WindowCreationJF windowCreation;
	private WindowCreationController windowCreationController;

	/**
	 * Creates a WindowCreationButtonListener instance related with the
	 * windowCreation view and controller.
	 */
	public WindowCreationJButtonsML() {
		windowCreationController = CentralSystem.getCentralSystem().getWindowCreationController();
		windowCreation = windowCreationController.getWindowCreation();
		buttonsJP = windowCreationController.getWindowCreation().getButtonsJP();
		driverCreationJP = windowCreationController.getWindowCreation()
				.getDriverCreationJSP().getDriverCreationJP();
		busCreationJP = windowCreationController.getWindowCreation()
				.getBusCreationJSP().getBusCreationJP();
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		PublicTransportCenter pTC = PublicTransportCenter.getPublicTransportCenter();
		CentralSystem centralSystem = CentralSystem.getCentralSystem();
		JButton sourceJB = (JButton) event.getSource();
		
		if (sourceJB.equals(driverCreationJP.getCreateDriverJB())) {
			String id = driverCreationJP.getIdJTF().getText();
			String name = driverCreationJP.getNameJTF().getText();
			String lastName = driverCreationJP.getLastNameJTF().getText();

			if (windowCreationController.checkDriverFields(id, name, lastName)) {
				// System.out.println("Before: " + pTC.getDrivers().size());
				if (windowCreationController.addNewDriver(id, name, lastName, windowCreation)) {
					// System.out.println("After: " + pTC.getDrivers().size());
					Alert.launchInfoMessage("Driver added succefully.",
							windowCreation);
					driverCreationJP.clean();
				}
			} else {
				Alert.launchErrorMessage("All fields must be filled.",
						windowCreation);
			}
		} else {
			if (sourceJB.equals(busCreationJP.getCreateBusJB())) {
				String id = busCreationJP.getIdJTF().getText();
				String driver = busCreationJP.getSelectedDriver();
				String plate = busCreationJP.getPlateJTF().getText();
				String route = busCreationJP.getSelectedRoute();
				String position = busCreationJP.getPositionJTF().getText();

				if (windowCreationController.checkBusFields(id, driver, plate,
						route, position)) {
					// System.out.println("Before: " + pTC.getBuses().size());
					if (windowCreationController.addNewBus(id, driver, plate,
							route, position, windowCreation)) {
						// System.out.println("After: " +
						// pTC.getBuses().size());
						Alert.launchInfoMessage("Bus added succefully.",
								windowCreation);

						busCreationJP.clean();
					}
				} else {
					Alert.launchErrorMessage("All fields must be filled.",
							windowCreation);
				}
			} else {
				if (sourceJB.equals(driverCreationJP.getCleanDriverJB())) {
					driverCreationJP.clean();
				} else {
					if (sourceJB.equals(busCreationJP.getCleanBusJB())) {
						busCreationJP.clean();
					} else {
						if (sourceJB.equals(buttonsJP.getExitJB())) {
							windowCreation.dispose();
						} else {
							if (sourceJB.equals(buttonsJP.getShowBusesJB())) {
								centralSystem.createBusesWindowController();
							} else {
								if(sourceJB.equals(buttonsJP.getShowGraphicSystemJB())) {
									centralSystem.createGraphicSystemController();
									centralSystem.createRefreshSystemGraphicThread();
								}
							}
						}
					}
				}
			}
		}

		if (sourceJB.equals(busCreationJP.getRandomJB())) {
			busCreationJP.getIdJTF().setText(RandomClass.getRandomID());
			busCreationJP.getPlateJTF().setText(RandomClass.getRandomPlate());

			busCreationJP.getDriversJCB().setSelectedIndex(
					RandomClass.getRandomInt(0, busCreationJP.getDriversJCB()
							.getItemCount() - 1));

			int routeIndex = RandomClass.getRandomInt(0, busCreationJP
					.getRoutesJCB().getItemCount() - 1);
			busCreationJP.getRoutesJCB().setSelectedIndex(routeIndex);

			String route = (String) busCreationJP.getRoutesJCB()
					.getSelectedItem();

			busCreationJP.getPositionJTF().setText(
					String.valueOf(RandomClass.getRandomDistance(pTC
							.getRouteByName(route))));
		} else {
			if (sourceJB.equals(driverCreationJP.getRandomJB())) {
				driverCreationJP.getIdJTF().setText(RandomClass.getRandomID());
				driverCreationJP.getNameJTF().setText(
						RandomClass.getRandomName());
				driverCreationJP.getLastNameJTF().setText(
						RandomClass.getRandomLastName());
			}
		}

		if (sourceJB.equals(busCreationJP.getRandom10JB())) {
			generateRandomBuses(10);
		} else {
			if (sourceJB.equals(driverCreationJP.getRandom10JB())) {
				generateRandomDrivers(10);
			}
		}

	}

	/**
	 * Generates the buses for make test.
	 */
	public void generateTestBus() {
		test00();
//		test01();
//		test02();
//		test03();
	}

	private void test00() {
		String id = "B001-Test";
		String plate = "TES-123";
		String route = "T47A";
		String position = "0.0";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B002-Test";
		plate = "TES-456";
		route = "T47A";
		position = "1";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B003-Test";
		plate = "TES-456";
		route = "T47A";
		position = "2";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B004-Test";
		plate = "TES-456";
		route = "T47A";
		position = "3.0";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B005-Test";
		plate = "TES-456";
		route = "T47A";
		position = "4.0";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B006-Test";
		plate = "TES-456";
		route = "T47A";
		position = "5.0";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B007-Test";
		plate = "TES-456";
		route = "T47A";
		position = "6.0";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
	}
	
	@SuppressWarnings("unused")
	private void test01() {
		String id = "B001-Test";
		String plate = "TES-123";
		String route = "T47A";
		String position = "2.0";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B002-Test";
		plate = "TES-456";
		route = "T47A";
		position = "1.7";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B003-Test";
		plate = "TES-456";
		route = "T47A";
		position = "1.0";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B004-Test";
		plate = "TES-456";
		route = "T47A";
		position = "0.73";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B005-Test";
		plate = "TES-456";
		route = "T47A";
		position = "0.5";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B006-Test";
		plate = "TES-456";
		route = "T47A";
		position = "0.2";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B007-Test";
		plate = "TES-456";
		route = "T47A";
		position = "0.0";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
	}
	
	@SuppressWarnings("unused")
	private void test02() {
		String id = "B001-Test";
		String plate = "TES-123";
		String route = "T47A";
		String position = "3.0";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B002-Test";
		plate = "TES-456";
		route = "T47A";
		position = "2.7";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B003-Test";
		plate = "TES-456";
		route = "T47A";
		position = "2.0";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B004-Test";
		plate = "TES-456";
		route = "T47A";
		position = "1.5";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B005-Test";
		plate = "TES-456";
		route = "T47A";
		position = "1";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B006-Test";
		plate = "TES-456";
		route = "T47A";
		position = "0.5";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B007-Test";
		plate = "TES-456";
		route = "T47A";
		position = "0.0";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
	}
	
	@SuppressWarnings("unused")
	private void test03() {
		String id = "B001-E21";
		String plate = "TES-123";
		String route = "T47A";
		String position = "3.0";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B002-E21";
		plate = "TES-456";
		route = "E21";
		position = "2.7";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B003-E21";
		plate = "TES-456";
		route = "E21";
		position = "2.0";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B004-E21";
		plate = "TES-456";
		route = "E21";
		position = "1.5";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B005-E21";
		plate = "TES-456";
		route = "E21";
		position = "1";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B006-E21";
		plate = "TES-456";
		route = "E21";
		position = "0.5";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
		
		id = "B007-E21";
		plate = "TES-456";
		route = "E21";
		position = "0.0";
		windowCreationController.addNewBus(id, null, plate, route, position, windowCreation);
	}
	
	/**
	 * Use for generate drivers for test.
	 * @param num the number of drivers to generate.
	 */
	public void generateRandomDrivers(int num) {
		for (int i = 0; i < 10; i++) {
			String id = RandomClass.getRandomID();
			String name = RandomClass.getRandomName();
			String lastName = RandomClass.getRandomLastName();

			windowCreationController.addNewDriver(id, name, lastName, windowCreation);
		}
	}
	
	/**
	 * Use for generate buses for test.
	 * @param num the number of buses to generate.
	 */
	public void generateRandomBuses(int num) {
		PublicTransportCenter pTC = PublicTransportCenter.getPublicTransportCenter();
		for (int i = 0; i < num; i++) {
			String id = RandomClass.getRandomID();
			String plate = RandomClass.getRandomPlate();

			String driver = busCreationJP.getDriversJCB().getItemAt(
					RandomClass.getRandomInt(0, busCreationJP.getDriversJCB()
							.getItemCount() - 1));
			String route = busCreationJP.getRoutesJCB().getItemAt(
					(RandomClass.getRandomInt(0, busCreationJP.getRoutesJCB()
							.getItemCount() - 1)));
			String position = String.valueOf(RandomClass.getRandomDistance(pTC
					.getRouteByName(route)));
			windowCreationController.addNewBus(id, driver, plate, route,
					position, windowCreation);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}
}