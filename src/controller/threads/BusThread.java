package controller.threads;

import controller.CentralSystem;
import controller.bus.SpeedPositionCalculator;
import controller.busesWindow.BusesWindowController;
import model.Bus;
import model.PublicTransportCenter;

/**
 * 
 * @author Alexis Cuero Losada
 *
 */
public class BusThread extends Thread {
	public static final int FREQUENCY = 500;
	
	private CentralSystem centralSystem;
	private PublicTransportCenter pTC;
	private SpeedPositionCalculator speedPositionCalculator;
	
	public BusThread()
	{
		pTC = PublicTransportCenter.getPublicTransportCenter();
		centralSystem = CentralSystem.getCentralSystem();
		speedPositionCalculator = new SpeedPositionCalculator();
		
		System.out.println("BusThread running...");
	}
	
	private void refreshBuses() {
		while(true)
		{
			if(pTC.getBuses() != null)
			{
				for (Bus bus : pTC.getBuses()) {
					if(bus.getState())
					{
						speedPositionCalculator.refreshSpeed(bus);
						speedPositionCalculator.refreshPosition(bus);
					}	
				}
				
				try
				{
					sleep(FREQUENCY);
				} catch (InterruptedException e)
				{
					System.err.println("Interruped Exception.");
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void run() {
		refreshBuses();
	}
}
