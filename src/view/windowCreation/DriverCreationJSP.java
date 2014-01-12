package view.windowCreation;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JSplitPane;

public class DriverCreationJSP extends JSplitPane {

	public static final int SPLIT_POSITION = 350;

	private DriverCreationJP driverCreationJP;
	private JLabel imageJL;

	public DriverCreationJSP() {
		setOrientation(JSplitPane.VERTICAL_SPLIT);
		setDividerLocation(SPLIT_POSITION);
		setElements();
	}

	private void setElements() {
		imageJL = new JLabel("Image...");
		driverCreationJP = new DriverCreationJP();

		setRightComponent(driverCreationJP);
		setLeftComponent(imageJL);
	}

	public DriverCreationJP getDriverCreationJP() {
		return driverCreationJP;
	}

}
