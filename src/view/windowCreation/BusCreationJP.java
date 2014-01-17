package view.windowCreation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Alexis Cuero Losada
 * This class extends of JPanel and is used for create the elements for the tag "Create Bus" 
 * in {@link WindowCreationJF}. 
 */
public class BusCreationJP extends JPanel {
	
	private static final long serialVersionUID = 587673970249671790L;

	/**
	 * The string in the JButton cleanBusJB.
	 */
	public static final String CLEAN_BUS = "Clean Bus";
	/**
	 * The string in the JButton createBusJB.
	 */
	public static final String CREATE_BUS = "Create Bus";
	/**
	 * The string for the JTextField idJTF.
	 */
	public static final String ID = "id";
	/**
	 * The string for the JTextField plateJTF.
	 */
	public static final String PLATE = "Plate";
	/**
	 * The string for the JTextField positionJTF.
	 */
	public static final String POSITION = "Position";

	private JPanel buttonsJP;
	private JPanel dataJP;
	private JButton cleanBusJB;
	private JButton createBusJB;
	private JLabel driversJL;
	private JLabel idJL;
	private JLabel plateJL;
	private JLabel positionJL;
	private JLabel routesJL;
	private JTextField idJTF;
	private JTextField plateJTF;
	private JTextField positionJTF;
	private JComboBox<String> driversJCB;
	private JComboBox<String> routesJCB;

	private JButton randomJB;
	private JButton random10JB;

	/**
	 * Creates a BusCreationJP for create drivers an buses.
	 * @param drivers the list with all drivers names.
	 * @param routes the list with all routes names.
	 */
	public BusCreationJP(ArrayList<String> drivers, ArrayList<String> routes) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Bus Creation Parameters"));

		createBusJB = new JButton(CREATE_BUS);
		cleanBusJB = new JButton(CLEAN_BUS);

		idJL = new JLabel("id: ");
		driversJL = new JLabel("Driver: ");
		plateJL = new JLabel("Plate: ");
		routesJL = new JLabel("Route: ");
		positionJL = new JLabel("Position: ");

		randomJB = new JButton("Random");
		random10JB = new JButton("10 Random");

		idJTF = new JTextField(ID);
		idJTF.setForeground(Color.GRAY);
		drivers.add(0, "Not asigned");
		driversJCB = new JComboBox<String>(drivers.toArray(new String[0]));
		plateJTF = new JTextField(PLATE);
		plateJTF.setForeground(Color.GRAY);
		routesJCB = new JComboBox<String>(routes.toArray(new String[0]));
		positionJTF = new JTextField(POSITION);
		positionJTF.setForeground(Color.GRAY);

		dataJP = new JPanel(new GridLayout(5, 2, 8, 8));
		buttonsJP = new JPanel(new FlowLayout(FlowLayout.CENTER));

		dataJP.add(idJL);
		dataJP.add(idJTF);
		dataJP.add(driversJL);
		dataJP.add(driversJCB);
		dataJP.add(plateJL);
		dataJP.add(plateJTF);
		dataJP.add(routesJL);
		dataJP.add(routesJCB);
		dataJP.add(positionJL);
		dataJP.add(positionJTF);

		buttonsJP.add(createBusJB);
		buttonsJP.add(cleanBusJB);

		buttonsJP.add(randomJB);
		buttonsJP.add(random10JB);

		add(dataJP, BorderLayout.CENTER);
		add(buttonsJP, BorderLayout.SOUTH);
	}

	/**
	 * Adds a ActionListener to the JButton createBusJB.
	 * @param mouseListener the MouseListener for createBusJB.
	 */
	public void setButtonsMouseListener(MouseListener mouseListener) {
		createBusJB.addMouseListener(mouseListener);
		cleanBusJB.addMouseListener(mouseListener);

		randomJB.addMouseListener(mouseListener);
		random10JB.addMouseListener(mouseListener);
	}

	/**
	 * Adds a driver name to the driversJCB.
	 * @param name the driver name.
	 */
	public void addDrivers(String name) {
		driversJCB.addItem(name);
	}

	/**
	 * Sets the FocusListener for handle JTextField creates in this JPanel. 
	 * @param focusListener the class for handle the focusEvent into this JPanel.
	 */
	public void setJTextFieldFocusListener(FocusListener focusListener) {
		idJTF.addFocusListener(focusListener);
		plateJTF.addFocusListener(focusListener);
		positionJTF.addFocusListener(focusListener);
	}

	/**
	 * Adds a route to the routesJCB.
	 * @param name the route name.
	 */
	public void addRoute(String name) {
		routesJCB.addItem(name);
	}

	/**
	 * Sets in all field a empty text.
	 */
	public void clean() {
		idJTF.setText(ID);
		idJTF.setForeground(Color.GRAY);
		plateJTF.setText(PLATE);
		plateJTF.setForeground(Color.GRAY);
		positionJTF.setText(POSITION);
		positionJTF.setForeground(Color.GRAY);
	}

	/**
	 * Returns the idJTF instance creates in this JPanel.
	 * @return the idJTF instance
	 */
	public JTextField getIdJTF() {
		return idJTF;
	}

	/**
	 * Returns the plateJTF instance creates in this JPanel.
	 * @return the plateJTF instance
	 */
	public JTextField getPlateJTF() {
		return plateJTF;
	}

	/**
	 * Returns the plateJTF instance creates in this JPanel.
	 * @return the plateJTF instance
	 */
	public JComboBox<String> getDriversJCB() {
		return driversJCB;
	}

	/**
	 * Returns the routesJCB instance creates in this JPanel.
	 * @return the routesJCB instance
	 */
	public JComboBox<String> getRoutesJCB() {
		return routesJCB;
	}

	/**
	 * Returns the positionJTF instance creates in this JPanel.
	 * @return the positionJTF instance
	 */
	public JTextField getPositionJTF() {
		return positionJTF;
	}

	/**
	 * Returns the cleanBusJB instance creates in this JPanel.
	 * @return the cleanBusJB instance
	 */
	public JButton getCleanBusJB() {
		return cleanBusJB;
	}

	/**
	 * Returns the createBusJB instance creates in this JPanel.
	 * @return the createBusJB instance
	 */
	public JButton getCreateBusJB() {
		return createBusJB;
	}

	/**
	 * Returns the selected item in the driversJCB.
	 * @return the selected item.
	 */
	public String getSelectedDriver() {
		return ((String) (driversJCB.getSelectedItem()));
	}

	/**
	 * Returns the selected item in the routesJCB.
	 * @return the selected item.
	 */
	public String getSelectedRoute() {
		return ((String) (routesJCB.getSelectedItem()));
	}

	/**
	 * Returns the random10JB instance creates in this JPanel.
	 * @return the random10JB instance
	 */
	public Object getRandom10JB() {
		return random10JB;
	}
	
	/**
	 * Returns the randomJB instance creates in this JPanel.
	 * @return the randomJB instance creates in this JPanel
	 */
	public JButton getRandomJB() {
		return randomJB;
	}
}
