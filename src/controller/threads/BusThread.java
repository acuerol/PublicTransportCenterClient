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
	public static final int STOP_TIME = 5 * 1000 / FREQUENCY;
//	public static final int STOP_TIME = 20 * 1000 / FREQUENCY;
	
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
//						System.out.println(bus.getMovementState());
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
								bus.setMovementState(-1);
								bus.setSpeed(0);
								
								if(bus.getStopTime() < STOP_TIME)
								{
//									System.out.println("Stop in station.");
									bus.setStopTime(bus.getStopTime() + 1);
								} else
								{
//									System.out.println("Running again...");
									bus.setStopTime(0);
									bus.setMovementState(5);
								}
							}
						} else
						{
							if(bus.getNextNode() instanceof Semaphore)
							{
								if(bus.getMovementState() == 0 || bus.getMovementState() == -2)
								{
									int index = pTC.getSemaphores().lastIndexOf(bus.getNextNode());
									Semaphore semaphore = pTC.getSemaphores().get(index);
									
									bus.setSpeed(0);
									bus.setMovementState(-2);
									
									if(semaphore.getState())
									{
										bus.setMovementState(5);
									}
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
