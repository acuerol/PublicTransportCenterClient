package view.windowCreation;

import java.awt.Color;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSplitPane;

/**
 * @author Alexis Cuero Losada
 * This class extends of JSplitPanel and is use for adjust the element to the {@link DriverCreationJP}.
 */
public class DriverCreationJSP extends JSplitPane {

	private static final long serialVersionUID = 4855750954479802690L;

	/**
	 * The split position.
	 */
	public static final int SPLIT_POSITION = 350;

	private DriverCreationJP driverCreationJP;
	private JLabel imageJL;

	/**
	 * Constructor that initialize the JSplitPanel with the {@link DriverCreationJP} and the split.
	 */
	public DriverCreationJSP() {
		setBackground(Color.WHITE);
		setOrientation(JSplitPane.VERTICAL_SPLIT);
		setDividerLocation(SPLIT_POSITION);
		setElements();
	}

	private void setElements() {
		imageJL = new JLabel();
		driverCreationJP = new DriverCreationJP();

		setRightComponent(driverCreationJP);
		setLeftComponent(imageJL);
	}

	/**
	 * Returns the {@link DriverCreationJP} instance create sin this class.
	 * @return the {@link DriverCreationJP} instance
	 */
	public DriverCreationJP getDriverCreationJP() {
		return driverCreationJP;
	}

	/**
	 * Sets the image and scale this to the imageJL.
	 */
	public void setImage() {
		ImageIcon imageIcon = new ImageIcon("images/driverWindowCreation.jpg");
		Icon icon = new ImageIcon(imageIcon.getImage().getScaledInstance(imageJL.getWidth(), imageJL.getHeight(), Image.SCALE_DEFAULT));
		imageJL.setIcon(icon);
		repaint();
	}
}
