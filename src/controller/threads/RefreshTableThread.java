package controller.threads;

import controller.CentralSystem;
import model.PublicTransportCenter;

public class RefreshTableThread extends Thread {

	private boolean interrupt;

	public RefreshTableThread() {		
	}

	@Override
	public void run() {
		System.out.println("RefreshTableThread running...");
		refreshTable();
	}

	private void refreshTable() {
		CentralSystem centralSystem = CentralSystem.getCentralSystem();
		int seletedRow = 0;
		interrupt = false;
		
		while (true) {
			seletedRow = centralSystem.getBusesWindowController()
					.getBusesWindow().getTableJP().getBusesJT()
					.getSelectedRow();
			centralSystem.getBusesWindowController().refreshTable(seletedRow);
			
			try {
				if (!isInterrupted()) {
					sleep(1000);
					if (interrupt) {
						interrupt();
					}
				} else {
					break;
				}

			} catch (InterruptedException e) {
				System.err.println("Interrupted Exception");
				e.printStackTrace();
			}
		}
	}

	public void setInterrupt() {
		interrupt = true;
	}
}
