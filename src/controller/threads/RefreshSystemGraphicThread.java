package controller.threads;

import controller.CentralSystem;

/**
 * 
 * @author Alexis Cuero Losada.
 * Update the GraphciSystem with the new system received from the server.
 */
public class RefreshSystemGraphicThread extends Thread {

	private boolean interrupt;

	@Override
	public void run() {
		System.out.println("RefreshSystemGraphicThread running...");
		refresh();
	}

	private void refresh() {
		CentralSystem centralSystem;
		while(true)
		{
			centralSystem = CentralSystem.getCentralSystem();
			centralSystem.getGraphicSystemController().refreshGraphic();
			
			try {
				if (!isInterrupted()) {
					sleep(500);
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
	 * Sets interrupt the thread of secure form.
	 */
	public void setInterrupt() {
		interrupt = true;
	}
	
	/**
	 * Starts the thread. 
	 */
	public void setRun() {
		interrupt = false;
	}
}
