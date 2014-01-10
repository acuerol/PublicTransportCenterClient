package controller.windowCreation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.crypto.spec.RC2ParameterSpec;
import javax.swing.JButton;
import javax.swing.text.html.CSS;

import controller.CentralSystem;
import model.Driver;
import model.PublicTransportCenter;
import view.windowCreation.BusCreationJP;
import view.windowCreation.ButtonsJP;
import view.windowCreation.DriverCreationJP;
import view.windowCreation.WindowCreationJF;
import util.Alert;
import util.RandomClass;

/**
 * 
 * @author Alexis Cuero Losada
 *
 */
public class WindowCreationJButtonsML implements MouseListener {
	
	private CentralSystem centralSystem;
	private PublicTransportCenter pTC;
	private DriverCreationJP driverCreationJP;
	private BusCreationJP busCreationJP;
	private ButtonsJP buttonsJP;
	private WindowCreationJF windowCreation;
	private WindowCreationController windowCreationController;
	
	/**
	 * Creates a WindowCreationButtonListener instance related with the windowCreation view and cotroller.
	 * @param windowCreation the JFrame windowCreation
	 * @param windowCreationController the windowCreation controller.
	 */
	public WindowCreationJButtonsML()
	{
		pTC = PublicTransportCenter.getPublicTransportCenter();
		centralSystem = CentralSystem.getCentralSystem();
		windowCreationController = centralSystem.getWindowCreationController();
		windowCreation = windowCreationController.getWindowCreation();
		buttonsJP = windowCreationController.getWindowCreation().getButtonsJP();
		driverCreationJP = windowCreationController.getWindowCreation().getDriverCreationJSP().getDriverCreationJP();
		busCreationJP = windowCreationController.getWindowCreation().getBusCreationJSP().getBusCreationJP();
	}

	@Override
	public void mouseClicked(MouseEvent event) {
		JButton sourceJB = (JButton) event.getSource();
		
		if(sourceJB.equals(driverCreationJP.getCreateDriverJB()))
		{
			String id = driverCreationJP.getIdText();
			String name = driverCreationJP.getNameText();
			String lastName= driverCreationJP.getLastNameText();
			
			if(windowCreationController.checkDriverFields(id, name, lastName))
			{
				//System.out.println("Before: " + pTC.getDrivers().size());
				if(windowCreationController.addNewDriver(id, name, lastName))
				{
					//System.out.println("After: " + pTC.getDrivers().size());
					Alert.launchInfoMessage("Driver added succefully.", windowCreation);
					driverCreationJP.clean();
				}
			}
			else
			{
				Alert.launchErrorMessage("All fields must be filled.", windowCreation);
			}
		}
		else
		{
			if(sourceJB.equals(busCreationJP.getCreateBusJB()))
			{
				String id = busCreationJP.getIdText();
				String driver = busCreationJP.getSelectedDriver();
				String plate = busCreationJP.getPlateText();
				String route = busCreationJP.getSelectedRoute();
				String position = busCreationJP.getPositionText();
				
				if(windowCreationController.checkBusFields(id, driver, plate, route, position))
				{
//					System.out.println("Before: " + pTC.getBuses().size());
					if(windowCreationController.addNewBus(id, driver, plate, route, position))
					{
//						System.out.println("After: " + pTC.getBuses().size());
						Alert.launchInfoMessage("Bus added succefully.", windowCreation);

						busCreationJP.clean();
					}
				}
				else
				{
					Alert.launchErrorMessage("All fields must be filled.", windowCreation);
				}
			}
			else
			{
				if(sourceJB.equals(driverCreationJP.getCleanDriverJB()))
				{
					driverCreationJP.clean();
				}
				else
				{
					if(sourceJB.equals(busCreationJP.getCleanBusJB()))
					{
						busCreationJP.clean();
					}
					else
					{
						if(sourceJB.equals(buttonsJP.getExitJB()))
						{
							windowCreation.dispose();
						}
						else
						{
							if(sourceJB.equals(buttonsJP.getShowBusesJB()))
							{
								centralSystem.createBusesWindowController();
								centralSystem.cretaeRefreshTableThread();
								centralSystem.startRefreshTableThread();
							}
						}
					}
				}
			}
		}
		
		if(sourceJB.equals(busCreationJP.getRandomJB()))
		{
			busCreationJP.getIdJTF().setText(RandomClass.getRandomID());
			busCreationJP.getPlateJTF().setText(RandomClass.getRandomPlate());
			
			busCreationJP.getDriversJCB().setSelectedIndex(RandomClass.getRandomInt(0, busCreationJP.getDriversJCB().getItemCount() - 1));
			
			int routeIndex = RandomClass.getRandomInt(0, busCreationJP.getRoutesJCB().getItemCount() - 1);
			busCreationJP.getRoutesJCB().setSelectedIndex(routeIndex);
			
			String route = (String) busCreationJP.getRoutesJCB().getSelectedItem();
			
			busCreationJP.getPositionJTF().setText(String.valueOf(RandomClass.getRandomDistance(pTC.getRouteByName(route))));
		}
		else
		{
			if(sourceJB.equals(driverCreationJP.getRandomJB()))
			{
				driverCreationJP.getIdJTF().setText(RandomClass.getRandomID());
				driverCreationJP.getNameJTF().setText(RandomClass.getRandomName());
				driverCreationJP.getLastNameJTF().setText(RandomClass.getRandomLastName());
			}
		}
		
		if(sourceJB.equals(busCreationJP.getRandom10JB()))
		{
			generateRandomBuses(10);
		}
		else
		{
			if(sourceJB.equals(driverCreationJP.getRandom10JB()))
			{
				generateRandomDrivers(10);
			}
		}
		
	}

	public void generateTestBus()
	{
		String id = "001";
		String plate = "TES-123";
		
		String route = "T47A";
		String position = "0.0";
		windowCreationController.addNewBus(id, null, plate, route, position);
	}
	
	public void generateRandomDrivers(int num)
	{
		for (int i = 0; i < 10; i++) {
			String id = RandomClass.getRandomID();
			String name = RandomClass.getRandomName();
			String lastName = RandomClass.getRandomLastName();
			
			windowCreationController.addNewDriver(id, name, lastName);
		}
	}
	public void generateRandomBuses(int num)
	{
		for (int i = 0; i < num; i++)
		{
			String id = RandomClass.getRandomID();
			String plate = RandomClass.getRandomPlate();
			
			String driver = busCreationJP.getDriversJCB().getItemAt(RandomClass.getRandomInt(0, busCreationJP.getDriversJCB().getItemCount() - 1));
			String route = busCreationJP.getRoutesJCB().getItemAt((RandomClass.getRandomInt(0, busCreationJP.getRoutesJCB().getItemCount() - 1)));
			String position = String.valueOf(RandomClass.getRandomDistance(pTC.getRouteByName(route)));
			windowCreationController.addNewBus(id, driver, plate, route, position);
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mousePressed(MouseEvent arg0) {}

	@Override
	public void mouseReleased(MouseEvent arg0) {}
}