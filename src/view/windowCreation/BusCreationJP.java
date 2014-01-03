package view.windowCreation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
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
 *
 */
public class BusCreationJP extends JPanel {
	private static final long serialVersionUID = 587673970249671790L;
	
	public static final String CLEAN_BUS = "Clean Bus";
	public static final String CREATE_BUS = "Create Bus";
	public static final String ID = "id";
	public static final String PLATE = "Plate";
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
	public BusCreationJP(ArrayList<String> drivers, ArrayList<String> routes)
	{
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Bus Creation Parameters"));
		
		createBusJB = new JButton(CREATE_BUS);
		cleanBusJB = new JButton(CLEAN_BUS);
		
		idJL =  new JLabel("id: ");
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
	 * @param mouseListener the ActionListener for createBusJB.
	 */
	public void setButtonsActionListener(MouseListener mouseListener)
	{
		createBusJB.addMouseListener(mouseListener);
		cleanBusJB.addMouseListener(mouseListener);
		
		randomJB.addMouseListener(mouseListener);
		random10JB.addMouseListener(mouseListener);
	}
	
	public JButton getRandomJB() {
		return randomJB;
	}

	/**
	 * Adds a driver to the driversJCB.
	 * @param name the driver name.
	 */
	public void addDrivers(String name)
	{
		driversJCB.addItem(name);
	}

	public void setJTextFieldFocusListener(FocusListener focusListener)
	{
		idJTF.addFocusListener(focusListener);
		plateJTF.addFocusListener(focusListener);
		positionJTF.addFocusListener(focusListener);
	}
	
	/**
	 * Adds a route to the routesJCB.
	 * @param name the route name.
	 */
	public void addRoute(String name)
	{
		routesJCB.addItem(name);
	}

	/**
	 * Sets in all field a empty text.  
	 */
	public void clean()
	{
		idJTF.setText(ID);
		idJTF.setForeground(Color.GRAY);
		plateJTF.setText(PLATE);
		plateJTF.setForeground(Color.GRAY);
		positionJTF.setText(POSITION);
		positionJTF.setForeground(Color.GRAY);
	}
	
	public JTextField getIdJTF() {
		return idJTF;
	}

	/**
	 * Returns the text in the id field.
	 * @return the text in the id field.
	 */
	public String getIdText() {
		return idJTF.getText();
	}
	
	public JTextField getPlateJTF() {
		return plateJTF;
	}
	
	public JComboBox<String> getDriversJCB() {
		return driversJCB;
	}

	public JComboBox<String> getRoutesJCB() {
		return routesJCB;
	}

	/**
	 * Returns the text in the plate field.
	 * @return the text in the plate field.
	 */
	public String getPlateText() {
		return plateJTF.getText();
	}

	public JTextField getPositionJTF() {
		return positionJTF;
	}
	
	public JButton getCleanBusJB() {
		return cleanBusJB;
	}

	public JButton getCreateBusJB() {
		return createBusJB;
	}

	/**
	 * Returns the text in the position field.
	 * @return the text in the position field.
	 */
	public String getPositionText() {
		return positionJTF.getText();
	}
	
	/**
	 * Returns the selected item in the driversJCB.
	 * @return the seleted item.
	 */
	public String getSelectedDriver() {
		return ((String)(driversJCB.getSelectedItem()));
	}
	
	/**
	 * Returns the selected item in the routesJCB.
	 * @return the seleted item.
	 */
	public String getSelectedRoute() {
		return ((String)(routesJCB.getSelectedItem()));
	}
	
	/**
	 * Sets a text (str) in this idJTF.
	 * @param str the text for set in the idJTF. 
	 */
	public void setIdText(String str) {
		idJTF.setText(str);
	}
	
	/**
	 * Sets a text (str) in this plateJTF.
	 * @param str the text for set in the plateJTF. 
	 */
	public void setPlateText(String str) {
		plateJTF.setText(str);;
	}
	
	/**
	 * Sets a text (str) in this positionJTF.
	 * @param str the text for set in the positionJTF. 
	 */
	public void setPositionText(String str) {
		positionJTF.setText(str);;
	}

	public Object getRandom10JB() {
		return random10JB;
	}
}
