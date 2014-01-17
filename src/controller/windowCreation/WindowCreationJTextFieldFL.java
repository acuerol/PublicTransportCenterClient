package controller.windowCreation;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import controller.CentralSystem;
import view.windowCreation.BusCreationJP;
import view.windowCreation.DriverCreationJP;

/**
 * @author Alexis Cuero Losada
 * With this class the appearance of program is improved. The JTextField have a text with the name of parameter to write
 * if the text is erase and isn't fill the label is shown again.
 */
public class WindowCreationJTextFieldFL implements FocusListener {

	private BusCreationJP busCreationJP;
	private DriverCreationJP driverCreationJP;

	/**
	 * Constructo that get the panels for refresh the JTextField.
	 */
	public WindowCreationJTextFieldFL() {
		WindowCreationController windowCreationController = CentralSystem.getCentralSystem().getWindowCreationController();
		busCreationJP = windowCreationController.getWindowCreation().getBusCreationJSP().getBusCreationJP();
		driverCreationJP = windowCreationController.getWindowCreation().getDriverCreationJSP()
				.getDriverCreationJP();
	}

	@Override
	public void focusGained(FocusEvent event) {
		JTextField source = (JTextField) event.getSource();
		String text = source.getText();

		if (source.equals(busCreationJP.getIdJTF())
				&& (text.equals("") || text.equals(BusCreationJP.ID))) {
			source.setForeground(Color.BLACK);
			source.setText("");
		} else {
			if (source.equals(busCreationJP.getPlateJTF())
					&& (text.equals("") || text.equals(BusCreationJP.PLATE))) {
				source.setForeground(Color.BLACK);
				source.setText("");
			} else {
				if (source.equals(busCreationJP.getPositionJTF())
						&& (text.equals("") || text
								.equals(BusCreationJP.POSITION))) {
					source.setForeground(Color.BLACK);
					source.setText("");
				}
			}
		}

		if (source.equals(driverCreationJP.getIdJTF())
				&& (text.equals("") || text.equals(DriverCreationJP.ID))) {
			source.setForeground(Color.BLACK);
			source.setText("");
		} else {
			if (source.equals(driverCreationJP.getNameJTF())
					&& (text.equals("") || text.equals(DriverCreationJP.NAME))) {
				source.setForeground(Color.BLACK);
				source.setText("");
			} else {
				if (source.equals(driverCreationJP.getLastNameJTF())
						&& (text.equals("") || text
								.equals(DriverCreationJP.LAST_NAME))) {
					source.setForeground(Color.BLACK);
					source.setText("");
				}
			}
		}
	}

	@Override
	public void focusLost(FocusEvent event) {
		JTextField source = (JTextField) event.getSource();

		if (source.equals(busCreationJP.getIdJTF())
				&& busCreationJP.getIdJTF().getText().equals("")) {
			source.setForeground(Color.GRAY);
			source.setText(BusCreationJP.ID);
		} else {
			if (source.equals(busCreationJP.getPlateJTF())
					&& busCreationJP.getPlateJTF().getText().equals("")) {
				source.setForeground(Color.GRAY);
				source.setText(BusCreationJP.PLATE);
			} else {
				if (source.equals(busCreationJP.getPositionJTF())
						&& busCreationJP.getPositionJTF().getText().equals("")) {
					source.setForeground(Color.GRAY);
					source.setText(BusCreationJP.POSITION);
				}
			}
		}

		if (source.equals(driverCreationJP.getIdJTF())
				&& driverCreationJP.getIdJTF().getText().equals("")) {
			source.setForeground(Color.GRAY);
			source.setText(DriverCreationJP.ID);
		} else {
			if (source.equals(driverCreationJP.getNameJTF())
					&& driverCreationJP.getNameJTF().getText().equals("")) {
				source.setForeground(Color.GRAY);
				source.setText(DriverCreationJP.NAME);
			} else {
				if (source.equals(driverCreationJP.getLastNameJTF())
						&& driverCreationJP.getLastNameJTF().getText().equals("")) {
					source.setForeground(Color.GRAY);
					source.setText(DriverCreationJP.LAST_NAME);
				}
			}
		}
	}
}
