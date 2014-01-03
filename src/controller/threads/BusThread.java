package controller.threads;

import controller.bus.SpeedPositionCalculator;
import model.Bus;
import model.PublicTransportCenter;

/**
 * 
 * @author Alexis Cuero Losada
 *
 */
public class BusThread extends Thread {
	public static final int FREQUENCY = 500;
	
	private PublicTransportCenter pTC;
	private SpeedPositionCalculator speedPositionCalculator;
	
	public BusThread()
	{
		pTC = PublicTransportCenter.getPublicTransportCenter();
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
