package controller.bus;

import controller.threads.BusThread;
import model.Bus;
import model.PublicTransportCenter;

public class SpeedPositionCalculator {
	public static final int DELTA = 1;
	public static final double TIME = 0.5;
	public static final double ACCELERATION = 3;
	public static final double DECELERATION = -2.4;
	
	private PublicTransportCenter pTC;
	
	public SpeedPositionCalculator() {
		pTC = PublicTransportCenter.getPublicTransportCenter();
	}
	
	public void refreshSpeed(Bus bus)
	{
		if(Math.abs(Math.ceil(bus.getIdealSpeed() - bus.getSpeed())) < DELTA)
		{
//			uniformMovement(bus);
		}
		else
		{
			if((bus.getIdealSpeed() - bus.getSpeed()) > DELTA)
			{
				acceleratedMovement(bus);
			}
			else
			{
				slowedMovement(bus);
			}
		}
	}
	
	public void refreshPosition(Bus bus) {
		double position = bus.getPosition() + bus.getSpeed() * TIME;
		bus.setPosition(position);
	}
	
	private void acceleratedMovement(Bus bus)
	{
		double speed = bus.getSpeed() + ACCELERATION * TIME;
		bus.setSpeed(speed);
	}
	
	private void slowedMovement(Bus bus)
	{
		double speed = bus.getSpeed() + DECELERATION * TIME;
		bus.setSpeed(speed);
	}
}
