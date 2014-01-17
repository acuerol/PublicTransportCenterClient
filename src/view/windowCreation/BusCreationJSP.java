package view.windowCreation;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

/**
 * @author Alexis Cuero Losada
 * This class extends of JSplitPanel and is use for adjust the element to the {@link BusCreationJP}.
 */
public class BusCreationJSP extends JSplitPane {

	private static final long serialVersionUID = 1013921833806648642L;

	/**
	 * The split position.
	 */
	public static final int SPLIT_POSITION = 300;

	private BusCreationJP busCreationJP;
	private JLabel imageJL;

	/**
	 * Constructor that initialize the JComboBoxes with the drivers and routes creates in the system
	 * @param drivers the driver names.
	 * @param routes the routes names.
	 */
	public BusCreationJSP(ArrayList<String> drivers, ArrayList<String> routes) {
		setOrientation(JSplitPane.VERTICAL_SPLIT);
		setDividerLocation(SPLIT_POSITION);
		setElements(drivers, routes);
	}

	private void setElements(ArrayList<String> drivers, ArrayList<String> routes) {
		imageJL = new JLabel();
		busCreationJP = new BusCreationJP(drivers, routes);

		setRightComponent(busCreationJP);
		setLeftComponent(imageJL);
	}

	/**
	 * Returns the {@link BusCreationJP} instance create sin this class.
	 * @return the {@link BusCreationJP} instance
	 */
	public BusCreationJP getBusCreationJP() {
		return busCreationJP;
	}
	
	/**
	 * Sets the image and scale this to the imageJL.
	 */
	public void setImage() {
		ImageIcon imageIcon = new ImageIcon("images/busWindowCreation.jpg");
		Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(imageJL.getWidth(), imageJL.getHeight(), Image.SCALE_DEFAULT));
		imageJL.setIcon(icon);
		repaint();
	}
}
