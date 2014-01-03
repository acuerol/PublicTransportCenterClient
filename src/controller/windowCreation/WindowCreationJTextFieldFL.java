package controller.windowCreation;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import controller.CentralSystem;
import view.windowCreation.BusCreationJP;
import view.windowCreation.DriverCreationJP;

/**
 * 
 * @author Alexis Cuero Losada
 *
 */
public class WindowCreationJTextFieldFL implements FocusListener {

	private CentralSystem centralSystem;
	private BusCreationJP busCreationJP;
	private DriverCreationJP driverCreationJP;
	private JTextField source;
	
	public WindowCreationJTextFieldFL()
	{
		centralSystem = CentralSystem.getCentralSystem();
		busCreationJP = centralSystem.getWindowCreationController().getWindowCreation().getBusCreationJSP().getBusCreationJP();
		driverCreationJP = centralSystem.getWindowCreationController().getWindowCreation().getDriverCreationJSP().getDriverCreationJP();
	}
	
	@Override
	public void focusGained(FocusEvent event) {
		source = (JTextField) event.getSource();
		String text = source.getText();
		
		if(source.equals(busCreationJP.getIdJTF()) && (text.equals("") || text.equals(BusCreationJP.ID)))
		{
			source.setForeground(Color.BLACK);
			source.setText("");
		}
		else
		{
			if(source.equals(busCreationJP.getPlateJTF()) && (text.equals("") || text.equals(BusCreationJP.PLATE)))
			{
				source.setForeground(Color.BLACK);
				source.setText("");
			}
			else
			{
				if(source.equals(busCreationJP.getPositionJTF()) && (text.equals("") || text.equals(BusCreationJP.POSITION)))
				{
					source.setForeground(Color.BLACK);
					source.setText("");
				}
			}
		}
		
		if(source.equals(driverCreationJP.getIdJTF()) && (text.equals("") || text.equals(DriverCreationJP.ID)))
		{
			source.setForeground(Color.BLACK);
			source.setText("");
		}
		else
		{
			if(source.equals(driverCreationJP.getNameJTF()) && (text.equals("") || text.equals(DriverCreationJP.NAME)))
			{
				source.setForeground(Color.BLACK);
				source.setText("");
			}
			else
			{
				if(source.equals(driverCreationJP.getLastNameJTF()) && (text.equals("") || text.equals(DriverCreationJP.LAST_NAME)))
				{
					source.setForeground(Color.BLACK);
					source.setText("");
				}
			}
		}
		
	}

	@Override
	public void focusLost(FocusEvent event) {
		source = (JTextField) event.getSource();
		
		if(source.equals(busCreationJP.getIdJTF()) && busCreationJP.getIdText().equals(""))
		{
			source.setForeground(Color.GRAY);
			source.setText(BusCreationJP.ID);
		}
		else
		{
			if(source.equals(busCreationJP.getPlateJTF()) && busCreationJP.getPlateText().equals(""))
			{
				source.setForeground(Color.GRAY);
				source.setText(BusCreationJP.PLATE);
			}
			else
			{
				if(source.equals(busCreationJP.getPositionJTF()) && busCreationJP.getPositionText().equals(""))
				{
					source.setForeground(Color.GRAY);
					source.setText(BusCreationJP.POSITION);	
				}
			}
		}
		
		if(source.equals(driverCreationJP.getIdJTF()) && driverCreationJP.getIdText().equals(""))
		{
			source.setForeground(Color.GRAY);
			source.setText(DriverCreationJP.ID);
		}
		else
		{
			if(source.equals(driverCreationJP.getNameJTF()) && driverCreationJP.getNameText().equals(""))
			{
				source.setForeground(Color.GRAY);
				source.setText(DriverCreationJP.NAME);
			}
			else
			{
				if(source.equals(driverCreationJP.getLastNameJTF()) && driverCreationJP.getLastNameText().equals(""))
				{
					source.setForeground(Color.GRAY);
					source.setText(DriverCreationJP.LAST_NAME);
				}
			}
		}
	}
}
