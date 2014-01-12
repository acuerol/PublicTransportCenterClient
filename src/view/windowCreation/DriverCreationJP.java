package view.windowCreation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Alexis Cuero Losada
 * 
 */
public class DriverCreationJP extends JPanel {

	public static final String CLEAN_DRIVER = "Clean Driver";
	public static final String CREATE_DRIVER = "Create Driver";
	public static final String ID = "id";

	public static final String LAST_NAME = "Last name";
	public static final String NAME = "Name";
	private static final long serialVersionUID = 8140788547398954167L;

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
		setBorder(BorderFactory
				.createTitledBorder("Driver Creation Parameters"));

		dataJP = new JPanel(new GridLayout(3, 2, 8, 8));
		buttonsJP = new JPanel(new FlowLayout());

		createDriverJB = new JButton(CREATE_DRIVER);
		createDriverJB.setActionCommand(CREATE_DRIVER);
		cleanDriverJB = new JButton(CLEAN_DRIVER);
		cleanDriverJB.setActionCommand(CLEAN_DRIVER);

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
	 * Adds a ActionListener to the JButton createDriverJB.
	 * 
	 * @param mouseListener
	 *            the ActionListener for createDriverJB.
	 */
	public void setButtonsActionListener(MouseListener mouseListener) {
		createDriverJB.addMouseListener(mouseListener);
		cleanDriverJB.addMouseListener(mouseListener);

		randomJB.addMouseListener(mouseListener);
		random10JB.addMouseListener(mouseListener);
	}

	public void addJTextFieldFocusListener(FocusListener focusL) {
		idJTF.addFocusListener(focusL);
		nameJTF.addFocusListener(focusL);
		lastNameJTF.addFocusListener(focusL);
	}

	public JButton getRandomJB() {
		return randomJB;
	}

	public JButton getCleanDriverJB() {
		return cleanDriverJB;
	}

	public JButton getCreateDriverJB() {
		return createDriverJB;
	}

	/**
	 * Sets in all field a empty text.
	 */
	public void clean() {
		idJTF.setText(ID);
		idJTF.setForeground(Color.GRAY);
		nameJTF.setText(NAME);
		nameJTF.setForeground(Color.GRAY);
		lastNameJTF.setText(LAST_NAME);
		lastNameJTF.setForeground(Color.GRAY);
	}

	public JTextField getIdJTF() {
		return idJTF;
	}

	/**
	 * Returns the text in the idJTF.
	 * 
	 * @return the text in the idJTF.
	 */
	public String getIdText() {
		return idJTF.getText();
	}

	public JTextField getLastNameJTF() {
		return lastNameJTF;
	}

	/**
	 * Returns the text in the lastNameJTF.
	 * 
	 * @return the text in the lastNameJTF.
	 */
	public String getLastNameText() {
		return lastNameJTF.getText();
	}

	public JTextField getNameJTF() {
		return nameJTF;
	}

	/**
	 * Returns the text in the nameJTF.
	 * 
	 * @return the text in the nameJTF.
	 */
	public String getNameText() {
		return nameJTF.getText();
	}

	/**
	 * Sets a text (str) in this idJTF.
	 * 
	 * @param str
	 *            the text for set in the idJTF.
	 */
	public void setIdText(String str) {
		idJTF.setText(str);
	}

	/**
	 * Sets a text (str) in this lastNameJTF.
	 * 
	 * @param str
	 *            the text for set in the lastNameJTF.
	 */
	public void setLastNameText(String str) {
		lastNameJTF.setText(str);
	}

	/**
	 * Sets a text (str) in this nameJTF.
	 * 
	 * @param str
	 *            the text for set in the nameJTF.
	 */
	public void setNameText(String str) {
		nameJTF.setText(str);
	}

	public Object getRandom10JB() {
		return random10JB;
	}
}
