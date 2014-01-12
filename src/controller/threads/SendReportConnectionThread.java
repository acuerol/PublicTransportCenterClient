package controller.threads;

import model.PublicTransportCenter;
import controller.CentralSystem;
import controller.connection.InitialValuesConnection;
import controller.connection.SendReportConnection;
import controller.connectionWindow.ConnectionWindowController;

public class SendReportConnectionThread extends Thread {

	private SendReportConnection reportConnection;
	private boolean isReporting;

	public SendReportConnectionThread() {
	}

	private void createReportConnection() {
		reportConnection = new SendReportConnection();
	}
	
	@Override
	public void run() {
		while (true) {
			if (isReporting) {
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
	
	public SendReportConnection getReportConnection() {
		return reportConnection;
	}

	public void startToReport() {
		isReporting = true;
	}

	public void stopOfReport() {
		isReporting = false;
	}
}
