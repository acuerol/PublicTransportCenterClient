package util;

import java.util.ArrayList;

import model.Route;

/**
 * @author Alexis Cuero Losada
 * 
 */
public class RandomClass {

	/**
	 * Save the upperCase alphabet in a char array.
	 */
	public static final char[] ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
			.toCharArray();

	/**
	 * Returns a pseudo random double in the interval [min,max].
	 * 
	 * @param min
	 *            the minimum value for the random double.
	 * @param double1
	 *            the maximum value for the random double.
	 * @return a random double in the interval [min,max].
	 */
	public static double getRandomDouble(double min, double max) {
		return Math.random() * (max - min) + min;
	}

	/**
	 * Returns a pseudo random int in the interval [min,max].
	 * 
	 * @param min
	 *            the minimum value for the random int.
	 * @param max
	 *            the maximum value for the random int.
	 * @return a random int in the interval [min,max].
	 */
	public static int getRandomInt(int min, int max) {
		return (int) (Math.random() * (max - min + 1) + min);
	}

	/**
	 * Returns a random plate with this format LLL-###.
	 * 
	 * @return a random plate.
	 */
	public static String getRandomPlate() {
		String plate = getRandomString(3);

		plate += "-";
		plate += getRandomInt(0, 9);
		plate += getRandomInt(0, 9);
		plate += getRandomInt(0, 9);

		return plate;
	}

	/**
	 * Returns a random string with a size of lenght and randon char in each
	 * position.
	 * 
	 * @param length
	 *            the size of string.
	 * @return a random string with a lenght specified.
	 */
	public static String getRandomString(int length) {
		String str = "";

		for (int i = 0; i < length; i++) {
			str += ALPHABET[getRandomInt(0, ALPHABET.length - 1)];
		}

		return str;
	}

	public static String getRandomLine(ArrayList<String> lines) {
		return lines.get(getRandomInt(0, lines.size() - 1));
	}

	public static String getRandomName() {
		return getRandomLine(IOFiles.readFile("textFiles/nombresHombre.txt"));
	}

	public static String getRandomLastName() {
		return getRandomLine(IOFiles.readFile("textFiles/apellidos.txt"));
	}

	public static String getRandomID() {
		String id = "";

		for (int i = 0; i < 9; i++) {
			id += getRandomInt(0, 9);
		}

		return id;
	}

	public static double getRandomDistance(Route route) {
		double max;
		double distance;
		double dou;

		max = route.getWay().getDistances()
				.get(route.getWay().getDistances().size() - 1).doubleValue();
		dou = getRandomDouble(0, max);

		distance = UtilCalc.round(dou, 2);

		return distance;
	}
}
