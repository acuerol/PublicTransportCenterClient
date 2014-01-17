package controller.bus;

import controller.threads.BusThread;
import model.Bus;

/**
 * @author Alexis Cuero Losada
 * Abstract class for calculate the speed and the position of a bus based in her acceleration.
 */
public class SpeedPositionCalculator {
	/**
	 * The speed tolerance (the error in the measure).
	 */
	public static final double SPEED_TOLERANCE = 1;
	/**
	 * The time of movement based in the system refresh for the calculations. 
	 */
	public static final double TIME = ((double) (BusThread.FREQUENCY) / 1000);

	/**
	 * Returns the position of a bus based in her actual speed, the time and the acceleration.
	 * @param bus the bus for calculate the new position.
	 * @return the new position of the bus.
	 */
	public static double refreshPosition(Bus bus) {
		double position = bus.getPosition()
				+ (bus.getSpeed() * TIME + ((bus.getAcceleration() / 2) * Math
						.pow(TIME, 2))) / 1000;
		return position;
	}

	/**
	 * Returns the new speed of the bus based in her acceleration, the actual speed and the time.
	 * @param bus the bus for calculate the new speed.
	 * @return the new speed of the bus.
	 */
	public static double refreshSpeed(Bus bus) {
		double speed = bus.getSpeed() + bus.getAcceleration() * TIME;
		return speed;
	}
}
