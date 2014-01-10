package controller.threads;

import controller.bus.SpeedPositionCalculator;
import model.Bus;
import model.PublicTransportCenter;
import model.Semaphore;
import model.Station;

/**
 * 
 * @author Alexis Cuero Losada
 *
 */
public class BusThread extends Thread {
	public static final int FREQUENCY = 500;
	public static final int STOP_TIME = 20 * 1000 / FREQUENCY;
	
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
						bus.setPosition(SpeedPositionCalculator.refreshPosition(bus));
						bus.setSpeed(SpeedPositionCalculator.refreshSpeed(bus));
						
						if(bus.getSpeed() < SpeedPositionCalculator.SPEED_DELTA && bus.getMovementState() == 3)
						{
							bus.setSpeed(0);
							bus.setMovementState(0);
						}
						
//						System.out.println("Stop time: " + bus.getStopTime());
						
						if(bus.getNextNode() instanceof Station)
						{
							if(bus.getMovementState() == 0 || bus.getMovementState() == -1)
							{
//								System.out.println("Bus Thread set speed station 0");
								bus.setMovementState(-1);
								bus.setSpeed(0);
								
								if(bus.getStopTime() < STOP_TIME)
								{
//									System.out.println("Counting seconds");
									bus.setStopTime(bus.getStopTime() + 1);
								} else
								{
									bus.setStopTime(0);
									bus.setMovementState(2);
								}
							}
						} else
						{
							if(bus.getMovementState() == 0 || bus.getMovementState() == -2)
							{
//								System.out.println("Bus Thread set speed semaphore 0");
								bus.setSpeed(0);
								bus.setMovementState(-2);
								
								if(((Semaphore)(bus.getNextNode())).getState())
								{
									bus.setMovementState(2);
								}
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
