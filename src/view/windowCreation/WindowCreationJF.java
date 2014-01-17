package view.windowCreation;

import java.awt.BorderLayout;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import view.busesWindow.BusesWindowJF;
import view.graphicSystem.GraphicSystemJF;

/**
 * @author Alexis Cuero Losada
 * This JFrame allow integrated several panels for create driver and buses, this so allow access to the
 *  {@link BusesWindowJF}, {@link GraphicSystemJF}. 
 */
public class WindowCreationJF extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5447761068423549318L;

	private BusCreationJSP busCreationJSP;
	private DriverCreationJSP driverCreationJSP;
	private ButtonsJP buttonsJP;

	private JTabbedPane tabsJTP;

	/**
	 * Creates a WindowCreationJF load the drivers names and routes names.
	 * @param drivers the list with the drivers names.
	 * @param routes the list with the routes names.
	 */
	public WindowCreationJF(ArrayList<String> drivers, ArrayList<String> routes) {
		setTitle("Window Creation");
		setSize(600, 600);
		setApareance(drivers, routes);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Returns the {@link ButtonsJP} instance create in this class.
	 * @return the {@link ButtonsJP} instance
	 */
	public ButtonsJP getButtonsJP() {
		return buttonsJP;
	}

	/**
	 * Add the listeners to the buttons in every panel.
	 * @param mouseListener the MouseListener.
	 */
	public void addJButtonsMouseListener(MouseListener mouseListener) {
		buttonsJP.setJButtonsMouseListener(mouseListener);

		driverCreationJSP.getDriverCreationJP().setButtonsActionListener(
				mouseListener);
		busCreationJSP.getBusCreationJP().setButtonsMouseListener(
				mouseListener);
	}

	/**
	 * Sets the FocusListener for handle JTextField creates in this JPanel. 
	 * @param focusListener the class for handle the focusEvent into this JPanel.
	 */
	public void addJTextFieldFocusListener(FocusListener focusListener) {
		driverCreationJSP.getDriverCreationJP().setJTextFieldFocusListener(
				focusListener);
		busCreationJSP.getBusCreationJP().setJTextFieldFocusListener(
				focusListener);
	}

	/**
	 * Returns the BusCreationJP used in the WindowCreationJF.
	 * 
	 * @return the BusCreationJP.
	 */
	public BusCreationJSP getBusCreationJSP() {
		return busCreationJSP;
	}

	/**
	 * Returns the DriverCreationJP used in the WindowCreationJF.
	 * 
	 * @return the DriverCreationJP.
	 */
	public DriverCreationJSP getDriverCreationJSP() {
		return driverCreationJSP;
	}

	/**
	 * Instance all components in the WindowCreationJF, so load the list of
	 * drivers names and routes names.
	 * 
	 * @param drivers
	 *            the drivers names.
	 * @param routes
	 *            the routes names.
	 */
	private void setApareance(ArrayList<String> drivers,
			ArrayList<String> routes) {
		setLayout(new BorderLayout());
		busCreationJSP = new BusCreationJSP(drivers, routes);
		driverCreationJSP = new DriverCreationJSP();
		buttonsJP = new ButtonsJP();

		tabsJTP = new JTabbedPane(SwingConstants.TOP);
		tabsJTP.addTab("Create Bus", busCreationJSP);
		tabsJTP.addTab("Create Driver", driverCreationJSP);

		add(tabsJTP, BorderLayout.CENTER);
		add(buttonsJP, BorderLayout.SOUTH);
	}
}
