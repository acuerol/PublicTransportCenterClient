package controller.bus;

import controller.threads.BusThread;
import model.Bus;

public class SpeedPositionCalculator {
	public static final double SPEED_DELTA = 1.5;
	public static final double TIME = ((double)(BusThread.FREQUENCY) / 1000);

	public static double refreshPosition(Bus bus) {
		double position = bus.getPosition() + (bus.getSpeed() * TIME + ((bus.getAcceleration() / 2) * Math.pow(TIME, 2))) / 1000;
		
		return position;
	}
	
	public static double refreshSpeed(Bus bus) {
		double speed = bus.getSpeed() + bus.getAcceleration() * TIME;
		
		if(bus.getSpeed() < SPEED_DELTA && bus.getMovementState() == 5)
		{
			bus.setSpeed(0);
			bus.setMovementState(0);
			bus.setAcceleration(0);
		}
		
		return speed;
	}
}
