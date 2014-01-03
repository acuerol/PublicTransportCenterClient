package controller.threads;

import model.PublicTransportCenter;
import controller.CentralSystem;
import controller.connection.InitialValuesConnection;
import controller.connection.SendReportConnection;
import controller.connectionWindow.ConnectionWindowController;

public class SendReportConnectionThread extends Thread {

	private CentralSystem centralSystem;
	private PublicTransportCenter pTC;
	private SendReportConnection reportConnection;
	private boolean isReporting;
	
	public SendReportConnectionThread() {
		pTC = PublicTransportCenter.getPublicTransportCenter();
		centralSystem = CentralSystem.getCentralSystem();
	}
	
	private void createReportConnection()
	{
		reportConnection = new SendReportConnection();
	}
	
	public SendReportConnection getReportConnection()
	{
		return reportConnection;
	}

	@Override
	public void run() {
		while(true)
		{
			if(isReporting)
			{
				createReportConnection();
				reportConnection.sendSystemReport();
				try {
					sleep(500);
				} catch (InterruptedException e) {
					System.err.println("InterruptedException reportThread.");
					e.printStackTrace();
				}
			}
		}
	}
	
	public void startToReport()
	{
		isReporting = true;
	}
	
	public void stopOfReport()
	{
		isReporting = false;
	}
}
