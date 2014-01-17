package controller.threads;

import controller.CentralSystem;

/**
 * @author Alexis Cuero Losada
 * Class for refresh the table thread with the last buses state.
 */
public class RefreshTableThread extends Thread {

	private boolean interrupt;

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

	/**
	 * Sets interrup the thread.
	 */
	public void setInterrupt() {
		interrupt = true;
	}
}
