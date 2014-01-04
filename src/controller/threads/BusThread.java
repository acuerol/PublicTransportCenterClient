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
	
	public BusThread() {
		pTC = PublicTransportCenter.getPublicTransportCenter();
	}
	
	private void refreshBuses() {
		while(true)
		{
			if(pTC.getBuses() != null)
			{
				for (Bus bus : pTC.getBuses())
				{
					if(bus.getState())
					{
						SpeedPositionCalculator.refreshSpeed(bus);
						SpeedPositionCalculator.refreshPosition(bus);
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
		System.out.println("BusThread running...");
		refreshBuses();
	}
}
