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
	/**
	 * Frequency in miliseconds for refresh the speed and position of every bus.
	 */
	public static final int FREQUENCY = 500;
	/**
	 * Stop time of every bus in a station.
	 */
	public static final int STOP_TIME = 5 * 1000 / FREQUENCY;
	// public static final int STOP_TIME = 20 * 1000 / FREQUENCY;

	private void refreshBuses() {
		PublicTransportCenter pTC;
		
		while (true) {
			pTC = PublicTransportCenter.getPublicTransportCenter();

			for (Bus bus : pTC.getBuses()) {
				if (bus.getState()) {
					bus.setPosition(SpeedPositionCalculator.refreshPosition(bus));
					bus.setSpeed(SpeedPositionCalculator.refreshSpeed(bus));

					if (bus.getSpeed() < SpeedPositionCalculator.SPEED_TOLERANCE) {
						if(bus.getMovementState() == 3)
						{
							bus.setSpeed(0);
							bus.setMovementState(0);
						} else {
							if(bus.getMovementState() == 6) {
								bus.setSpeed(0);
								bus.setMovementState(6);
							}
						}
						
					}

					if (bus.getNextNode() instanceof Station) {
						if (bus.getMovementState() == 0 || bus.getMovementState() == -1) {
							bus.setMovementState(-1);
							bus.setSpeed(0);

							if (bus.getStopTime() < STOP_TIME) {
								// System.out.println("Stop in station.");
								bus.setStopTime(bus.getStopTime() + 1);
							} else {
								// System.out.println("Running again...");
								bus.setStopTime(0);
								bus.setMovementState(5);
							}
						}
					} else {
						if (bus.getNextNode() instanceof Semaphore) {
							Semaphore semaphore = ((Semaphore)(bus.getNextNode()));
							int index = PublicTransportCenter.getPublicTransportCenter().getSemaphores().indexOf(semaphore);
							semaphore = PublicTransportCenter.getPublicTransportCenter().getSemaphores().get(index);
							
//							System.out.println("ID: " + semaphore.getId() + " --> State: " + semaphore.getState());
							if (bus.getMovementState() == 0 || bus.getMovementState() == -2) {
								
								bus.setSpeed(0);
								bus.setMovementState(-2);

								if (semaphore.getState()) {
									bus.setMovementState(5);
								}
							}
						}
					}
				}
			}

			PublicTransportCenter.setPublicTransportCenter(pTC);

			try {
				sleep(FREQUENCY);
			} catch (InterruptedException e) {
				System.err.println("Interruped Exception.");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		System.out.println("BusThread running...");
		refreshBuses();
	}
}
