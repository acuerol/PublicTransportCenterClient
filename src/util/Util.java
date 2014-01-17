package util;

import java.io.File;
import java.util.ArrayList;

import model.Semaphore;
import model.Station;

/**
 * @author Alexis Cuero Losada
 * 
 */
public class Util {

	/**
	 * Returns true if a string is a integer.
	 * 
	 * @param string
	 *            a possible integer.
	 * @return true if the string is a integer.
	 */
	public static boolean isInteger(String string) {
		char[] characters = string.toCharArray();

		for (char ch : characters) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns true if the plate (String plate) is valid LLL-###.
	 * 
	 * @param plate
	 *            the plate must be validate.
	 * @return true if is a plate else false.
	 */
	public static boolean isPlate(String plate) {

		if (plate.length() == 7) {
			char[] charPlate = plate.toCharArray();

			for (int i = 0; i < charPlate.length; i++) {
				if (i < 3) {
					if (!Character.isLetter(charPlate[i])) {
						return false;
					}
				} else {
					if (i == 3) {
						if (charPlate[i] != '-') {
							return false;
						}
					} else {
						if (!Character.isDigit(charPlate[i])) {
							return false;
						}
					}
				}
			}
		} else {
			return false;
		}

		return true;
	}

	/**
	 * Returns the absolute path of a File[].
	 * @param files the file to get the absolutePath.
	 * @return a String with the absolute path of all files.
	 */
	public static String getAbsolutePaths(File[] files) {
		String pathNames = "";

		for (int i = 0; i < files.length; i++) {

			pathNames += files[i].getAbsolutePath();

			if (i < files.length - 1) {
				pathNames += ",";
			}

		}

		return pathNames;
	}

	/**
	 * Print for standard out a List of objects.
	 * @param objects the objects to print.
	 */
	public static void printObject(ArrayList<Object> objects) {
		System.out.println("-------------------------------");
		for (Object obj : objects) {
			if (obj instanceof Station)
				System.out.println(((Station) (obj)).getName());
			if (obj instanceof Semaphore)
				System.out.println(((Semaphore) (obj)).getID());
		}
	}

	/**
	 * Checks if the String is a double.
	 * @param number the number to check.
	 * @return true if the numDouble is a double else false.
	 */
	public static boolean isDouble(String number) {
		char[] characters = number.toCharArray();
		boolean dot = false;

		for (char c : characters) {
			if (!Character.isDigit(c)) {
				if (c == '.') {
					if (dot) {
						return false;
					}
				} else {
					return false;
				}
			}
		}

		return true;
	}
}
