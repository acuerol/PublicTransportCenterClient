package controller.graphicSystem;

import java.util.ArrayList;

import view.graphicSystem.GraphicSystemJF;
import model.Bus;
import model.PublicTransportCenter;
import model.Route;
import model.Semaphore;
import model.Station;
import model.graphicSystem.BusLabel;
import model.graphicSystem.SemaphoreLabel;
import model.graphicSystem.StationLabel;

/**
 * 
 * @author Alexis Cuero Losada
 * Class for controller the graphic system, from here the nodes are generate.
 */
public class GraphicSystemController {

	private GraphicSystemJF graphicSystemJF;

	/**
	 * Constructor that instance the graphicSystemJF and generate the initial nodes. 
	 */
	public GraphicSystemController() {
		graphicSystemJF = new GraphicSystemJF();
		generateNodes();
	}

	/**
	 * Generate the nodes for the GraphicSystem, creates all instances for everyone of the elments in the system.
	 */
	public void generateNodes() {
		String routeName = (String) graphicSystemJF.getToolsJP().getRoutesJCB().getSelectedItem();
		ArrayList<BusLabel> busesLabel = new ArrayList<BusLabel>();
		ArrayList<StationLabel> stationsLabel = new ArrayList<StationLabel>();
		ArrayList<SemaphoreLabel> semaphoresLabel = new ArrayList<SemaphoreLabel>();
		
		if(!routeName.equals("All routes."))
		{
			int panelWidth = getGraphicSystemJF().getMapJP().getWidth();
			Route route = PublicTransportCenter.getPublicTransportCenter().getRouteByName(routeName);
			ArrayList<Bus> buses = getBusesByRoute(route);
			ArrayList<Semaphore> semaphores = getSemaphoresByRoute(route);
			ArrayList<Station> stations = getStationsByRoute(route);
			
			for (Bus bus : buses) {
				BusLabel busLabel = new BusLabel(bus, panelWidth);
				busesLabel.add(busLabel);
			}
			
			for (Station station : stations) {
				StationLabel stationLabel = new StationLabel(station, route, panelWidth);
				stationsLabel.add(stationLabel);
			}
			
			for (Semaphore semaphore : semaphores) {
				SemaphoreLabel semaphoreLabel = new SemaphoreLabel(semaphore, route, panelWidth); 
				semaphoresLabel.add(semaphoreLabel);
			}
		} else {
			
		}
		
		graphicSystemJF.getMapJP().addNodes(busesLabel, stationsLabel, semaphoresLabel, 1);
	}
	
	private ArrayList<Station> getStationsByRoute(Route route) {
		PublicTransportCenter pTC = PublicTransportCenter.getPublicTransportCenter();
		
		ArrayList<Station> stations = new ArrayList<Station>();
		
		for (Object object : route.getWay().getNodes()) {
			if (object instanceof Station) {
				int index = pTC.getStations().indexOf(object);
				Station station = pTC.getStations().get(index);
				stations.add(station);
			}
		}
		
		return stations;
	}

	private ArrayList<Semaphore> getSemaphoresByRoute(Route route) {
		PublicTransportCenter pTC = PublicTransportCenter.getPublicTransportCenter();
		ArrayList<Semaphore> semaphores = new ArrayList<Semaphore>();
		
		for (Object object : route.getWay().getNodes()) {
			if (object instanceof Semaphore) {
				int index = pTC.getSemaphores().indexOf(object);
				Semaphore semaphore = pTC.getSemaphores().get(index);
				
				semaphores.add(semaphore);
			}
		}

		return semaphores;
	}

	private ArrayList<Bus> getBusesByRoute(Route route) {
		PublicTransportCenter pTC = PublicTransportCenter.getPublicTransportCenter();

		ArrayList<Bus> buses = new ArrayList<Bus>();

		for (Bus bus : pTC.getBuses()) {
			if (bus.getRoute().equals(route)) {
				buses.add(bus);
			}
		}

		return buses;
	}
	
	/**
	 * @return the graphicSystemJF
	 */
	public GraphicSystemJF getGraphicSystemJF() {
		return graphicSystemJF;
	}

	/**
	 * Generate the nodes again.
	 */
	public void refreshGraphic() {
		generateNodes();
	}
}
