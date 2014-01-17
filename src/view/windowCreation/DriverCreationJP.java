package view.windowCreation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Alexis Cuero Losada
 * This class extends of JPanel and is used for create the elements for the tag "Create Driver" 
 * in {@link WindowCreationJF}.
 */
public class DriverCreationJP extends JPanel {

	private static final long serialVersionUID = 8140788547398954167L;
	
	/**
	 * The string for the JTextField idJTF.
	 */
	public static final String ID = "id";
	/**
	 * The string for the JTextField lastNameJTF.
	 */
	public static final String LAST_NAME = "Last name";
	/**
	 * The string for the JTextField nameJTF.
	 */
	public static final String NAME = "Name";
	
	private JPanel buttonsJP;
	private JPanel dataJP;
	private JButton cleanDriverJB;
	private JButton createDriverJB;
	private JLabel idJL;
	private JLabel lastNameJL;
	private JLabel nameJL;
	private JTextField nameJTF;
	private JTextField idJTF;
	private JTextField lastNameJTF;

	private JButton randomJB;
	private JButton random10JB;

	/**
	 * Creates the JPanel DriverCreationJP.
	 */
	public DriverCreationJP() {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Driver Creation Parameters"));

		dataJP = new JPanel(new GridLayout(3, 2, 8, 8));
		buttonsJP = new JPanel(new FlowLayout());

		createDriverJB = new JButton("Create Driver");
		cleanDriverJB = new JButton("Clean fields");

		idJL = new JLabel("id: ");
		nameJL = new JLabel("Name: ");
		lastNameJL = new JLabel("Last name:");

		randomJB = new JButton("Random");
		random10JB = new JButton("10 Random");

		idJTF = new JTextField(ID);
		idJTF.setForeground(Color.GRAY);
		nameJTF = new JTextField(NAME);
		nameJTF.setForeground(Color.GRAY);
		lastNameJTF = new JTextField(LAST_NAME);
		lastNameJTF.setForeground(Color.GRAY);

		dataJP.add(idJL);
		dataJP.add(idJTF);
		dataJP.add(nameJL);
		dataJP.add(nameJTF);
		dataJP.add(lastNameJL);
		dataJP.add(lastNameJTF);

		buttonsJP.add(createDriverJB);
		buttonsJP.add(cleanDriverJB);

		buttonsJP.add(randomJB);
		buttonsJP.add(random10JB);

		add(dataJP, BorderLayout.CENTER);
		add(buttonsJP, BorderLayout.SOUTH);
	}

	/**
	 * Returns the cleanDriverJB instance creates in this JPanel.
	 * @return the cleanDriverJB instance
	 */
	public JButton getCleanDriverJB() {
		return cleanDriverJB;
	}

	/**
	 * Returns the createDriverJB instance creates in this JPanel.
	 * @return the createDriverJB instance
	 */
	public JButton getCreateDriverJB() {
		return createDriverJB;
	}

	/**
	 * Sets in all field the original format.
	 */
	public void clean() {
		idJTF.setText(ID);
		idJTF.setForeground(Color.GRAY);
		nameJTF.setText(NAME);
		nameJTF.setForeground(Color.GRAY);
		lastNameJTF.setText(LAST_NAME);
		lastNameJTF.setForeground(Color.GRAY);
	}

	/**
	 * Returns the idJTF instance creates in this JPanel.
	 * @return the idJTF instance
	 */
	public JTextField getIdJTF() {
		return idJTF;
	}

	/**
	 * Returns the lastNameJTF instance creates in this JPanel.
	 * @return the lastNameJTF instance
	 */
	public JTextField getLastNameJTF() {
		return lastNameJTF;
	}

	/**
	 * Returns the nameJTF instance creates in this JPanel.
	 * @return the nameJTF instance
	 */
	public JTextField getNameJTF() {
		return nameJTF;
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
	
	/**
	 * Adds a ActionListener to the JButton createDriverJB.
	 * @param mouseListener the ActionListener for createDriverJB.
	 */
	public void setButtonsActionListener(MouseListener mouseListener) {
		createDriverJB.addMouseListener(mouseListener);
		cleanDriverJB.addMouseListener(mouseListener);

		randomJB.addMouseListener(mouseListener);
		random10JB.addMouseListener(mouseListener);
	}

	/**
	 * Sets the FocusListener for handle JTextField creates in this JPanel. 
	 * @param focusListener the class for handle the focusEvent into this JPanel.
	 */
	public void setJTextFieldFocusListener(FocusListener focusListener) {
		idJTF.addFocusListener(focusListener);
		nameJTF.addFocusListener(focusListener);
		lastNameJTF.addFocusListener(focusListener);
	}
}
