package controller.threads;

import controller.connection.SendReportConnection;

/**
 * @author Alexis Cuero Losada
 * This is the thread for handle the class that send the report. This send the report every 500 milliseconds.
 */
public class SendReportConnectionThread extends Thread {

	private SendReportConnection sendReportConnection;
	private boolean isReporting;

	private void createReportConnection() {
		sendReportConnection = new SendReportConnection();
	}
	
	@Override
	public void run() { 
		while (true) {
			if (isReporting) {
				createReportConnection();
				sendReportConnection.sendSystemReport();
				try {
					sleep(500);
				} catch (InterruptedException e) {
					System.err.println("InterruptedException reportThread.");
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Starts to reporting the system.
	 */
	public void startToReport() {
		isReporting = true;
	}

	/**
	 * Stops of reporting the system.
	 */
	public void stopOfReport() {
		isReporting = false;
	}
}
