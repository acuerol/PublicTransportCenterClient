
import java.util.ArrayList;

import controller.CentralSystem;

/**
 * @author Alexis Cuero Losada
 *
 */
public class Main {

	/**
	 * Main class, first excuted class.
	 * @param args program parameters.
	 */
	public static void main(String[] args) {
		System.out.println("Executing Client.");
		CentralSystem centralSystem = CentralSystem.getCentralSystem();
		centralSystem.createConnectionWindowController();
	}
}