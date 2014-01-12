package view.windowCreation;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JSplitPane;

public class BusCreationJSP extends JSplitPane {

	public static final int SPLIT_POSITION = 300;

	private BusCreationJP busCreationJP;
	private JLabel imageJL;

	public BusCreationJSP(ArrayList<String> drivers, ArrayList<String> routes) {
		setOrientation(JSplitPane.VERTICAL_SPLIT);
		setDividerLocation(SPLIT_POSITION);
		setElements(drivers, routes);
	}

	private void setElements(ArrayList<String> drivers, ArrayList<String> routes) {
		imageJL = new JLabel("Image...");
		busCreationJP = new BusCreationJP(drivers, routes);

		setRightComponent(busCreationJP);
		setLeftComponent(imageJL);
	}

	public BusCreationJP getBusCreationJP() {
		return busCreationJP;
	}
}
