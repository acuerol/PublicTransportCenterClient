package controller.bus;

import controller.threads.BusThread;
import model.Bus;
import model.PublicTransportCenter;

public class SpeedPositionCalculator {
	public static final int DELTA = 1;
	public static final double TIME = BusThread.FREQUENCY;
	
	public static void refreshSpeed(Bus bus) {
		if(Math.abs(Math.ceil(bus.getIdealSpeed() - bus.getSpeed())) > DELTA)
		{
			acceleratedMovement(bus);
		}
	}

	public static void refreshPosition(Bus bus) {
		double position = bus.getPosition() + bus.getSpeed() * TIME * 3.6;
		bus.setPosition(position);
	}
	
	private static void acceleratedMovement(Bus bus) {
		double speed = bus.getSpeed() + bus.getAcceleration() * TIME;
		bus.setSpeed(speed);
	}
}
