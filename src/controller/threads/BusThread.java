package controller.threads;

import controller.bus.SpeedPositionCalculator;
import model.Bus;
import model.PublicTransportCenter;
import model.Station;

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
			pTC = PublicTransportCenter.getPublicTransportCenter();
			
			if(pTC.getBuses() != null)
			{
				for (Bus bus : pTC.getBuses())
				{
					if(bus.getState())
					{
						System.out.println(bus.getPosition());
						bus.setPosition(SpeedPositionCalculator.refreshPosition(bus));
						bus.setSpeed(SpeedPositionCalculator.refreshSpeed(bus));
						
						if(bus.getStopNode() instanceof Station)
						{
							if(bus.getStopTime() < 8)
							{
								bus.setStopTime(bus.getStopTime() + 1);
							} else
							{
								bus.setStopTime(0);
								bus.setMovementState(3);
							}
						}
					}	
				}
				
				PublicTransportCenter.setPublicTransportCenter(pTC);
				
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
