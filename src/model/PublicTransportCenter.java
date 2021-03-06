package model;

import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.ArrayList;

import util.UtilCalc;

/**
 * @author Alexis Cuero Losada
 * The most important class in the system, is related with all other classes.
 */
public class PublicTransportCenter implements Serializable {
	
	private static PublicTransportCenter pTC;
	/**
	 * The PublicTransportCenter serialVersionUID.
	 */
	private static final long serialVersionUID = 8794930979020795777L;
	/**
	 * Return the PublicTransportCenter instance, if it is null then instance this, if it isn't null return the instance.
	 * @return the PublicTransportCenter instance.
	 */
	public static synchronized PublicTransportCenter getPublicTransportCenter()
	{
		if(pTC == null)
		{
			pTC = new PublicTransportCenter();
		}
		return pTC;
	}
	private ArrayList<Bus> buses;
	private ArrayList<Driver> drivers;
	private Graph graph;
	private ArrayList<Road> roads;
	private ArrayList<Route> routes;
	private Search search;
	private ArrayList<Semaphore> semaphores;
	private ArrayList<Station> stations;
	private ArrayList<Way> ways;
	
	/**
	 * Adds a bus to the ArrayList<Bus> buses. 
	 * @param bus the bus to add.
	 */
	public void addBus(Bus bus)
	{
		buses.add(bus);
	}
	
	/**
	 * Adds a driver to the ArrayList<Driver> drivers. 
	 * @param driver the driver to add.
	 */
	public void addDriver(Driver driver)
	{
		drivers.add(driver);
	}
	
	private PublicTransportCenter()
	{
		buses = new ArrayList<Bus>();
		stations = new ArrayList<Station>();
		routes = new ArrayList<Route>();
		semaphores= new ArrayList<Semaphore>();
		drivers= new ArrayList<Driver>();
		roads = new ArrayList<Road>();
		ways = new ArrayList<Way>();
		graph = new Graph();
		search = new Search();
	}
	
	/**
	 * Sets the all system with the receive as parameter.
	 * @param pTC the system to set.
	 */
	public static synchronized void setPublicTransportCenter(PublicTransportCenter pTC)
	{
		PublicTransportCenter.pTC = pTC;
	}
	
	/**
	 * Sets only the semaphores to the system.
	 * @param pTC the system to extract semaphores.
	 */
	public static synchronized void refreshSemaphores(PublicTransportCenter pTC)
	{
		PublicTransportCenter.pTC.setSemaphores(pTC.getSemaphores());
	}
	
	/**
	 * Sets only the buses to the system.
	 * @param pTC the system to extract buses.
	 */
	public static synchronized void refreshBuses(PublicTransportCenter pTC)
	{
		PublicTransportCenter.pTC.setBuses(pTC.getBuses());
	}
	
	/**
	 * Sets only some parameters of the system acceleration, movement state, nextStopStation
	 * nextNode, routes and semaphores. If a bus was added will be added too to this system.
	 * @param pTC the system to extract some parameters.
	 */
	public static synchronized void refreshBusesFromServer(PublicTransportCenter pTC)
	{
		ArrayList<Bus> buses = pTC.getBuses();
		int index = 0;
		
		for (Bus bus : buses)
		{
			index = PublicTransportCenter.pTC.getBuses().indexOf(bus);
			
			if(index == -1)
			{
				PublicTransportCenter.pTC.getBuses().add(bus);
			}else
			{
				PublicTransportCenter.pTC.getBuses().get(index).setAcceleration(bus.getAcceleration());
				PublicTransportCenter.pTC.getBuses().get(index).setMovementState(bus.getMovementState());
				PublicTransportCenter.pTC.getBuses().get(index).setNextStopStation(bus.getNextStopStation());
				PublicTransportCenter.pTC.getBuses().get(index).setNextNode(bus.getNextNode());
			}
		}
		
		PublicTransportCenter.pTC.setRoutes(pTC.getRoutes());
		PublicTransportCenter.pTC.setSemaphores(pTC.getSemaphores());
	}
	
	/**
	 * Sets the attributes that change in the server to this system (speed, position, movementState, stopTime
	 * state).
	 * @param pTC
	 */
	public static synchronized void refreshBusesFromClient(PublicTransportCenter pTC)
	{
		ArrayList<Bus> buses = pTC.getBuses();
		int index = 0;
		
		for (Bus bus : buses)
		{
			index = PublicTransportCenter.pTC.getBuses().indexOf(bus);
			
			if(index == -1)
			{
				PublicTransportCenter.pTC.getBuses().add(bus);
			}else
			{
				PublicTransportCenter.pTC.getBuses().get(index).setSpeed(bus.getSpeed());
				PublicTransportCenter.pTC.getBuses().get(index).setPosition(bus.getPosition());
				PublicTransportCenter.pTC.getBuses().get(index).setMovementState(bus.getMovementState());
				PublicTransportCenter.pTC.getBuses().get(index).setStopTime(bus.getStopTime());
				PublicTransportCenter.pTC.getBuses().get(index).setState(bus.getState());
			}
		}
	}
	
	@Override
	protected PublicTransportCenter clone()
	{
		return pTC;
	}
	
	/**
	 * Returns the list of all buses in the system. 
	 * @return all buses
	 */
	public ArrayList<Bus> getBuses() {
		return buses;
	}	
	
	/**
	 * Returns the List with all buses that have the route.
	 * @param route the route for filter the buses.
	 * @return the List with all buses that have the route
	 */
	public ArrayList<Bus> getBusesByRoute(Route route) {
		ArrayList<Bus> busesByRoute = new ArrayList<Bus>();
		for (Bus bus : buses) {
			if(bus.getRoute().equals(route))
			{
				busesByRoute.add(bus);
			}
		}
		
		return busesByRoute;
	}
	
	/**
	 * Adds a way to the list of the system.
	 * @param way the ways to set
	 */
	public void addWay(Way way) {
		ways.add(way);
	}

	/**
	 * Returns the path distance.  
	 * @param path the all nodes in the way.
	 * @return the path distance. 
	 */
	public double getDistanceAB(ArrayList<Object> path)
	{ 
		ArrayList<Object> nodes;
		double distance = 0.0;
		for(int i = 0 ; i < path.size() - 1 ; i++)
		{
			nodes = new ArrayList<Object>();
			nodes.add(path.get(i));
			nodes.add(path.get(i+1));
			
			for (Road road : roads) {
				if(road.getNodesAttached().containsAll(nodes))
				{
					distance += road.getDistance();
				}
			}
		}
		
		distance = UtilCalc.round(distance, 2);

		return distance;
	}
	
	/**
	 * returns a Driver instance from the driver name.
	 * @param name the driver name
	 * @return Driver with name.
	 */
	public Driver getDriverByName(String name)
	{
		for (Driver driver : drivers)
		{
			if(driver.getName().equals(name))
			{
				return driver;
			}
		}
		
		return null;
	}
	
	/**
	 * Returns the list of all drivers at the system. 
	 * @return all drivers at the system.
	 */
	public ArrayList<Driver> getDrivers() {
		return drivers;
	}
	
	/**
	 * Returns a list with all drivers name.
	 * @return drivers name.
	 */
	public ArrayList<String> getDriversName()
	{
		ArrayList<String> names = new ArrayList<String>();
		
		for (Driver driver : drivers) {
			names.add(driver.getName() + " " + driver.getLastName());
		}
		
		return names;
	}
	
	/**
	 * return the PublicTransportCenter graph. 
	 * @return the Graph instance.
	 */
	public Graph getGraph()
	{
		return graph;
	}

	/**
	 * Return a List with all roads at the system. 
	 * @return all roads in the system.
	 */
	public ArrayList<Road> getRoads() {
		return roads;
	}

	/**
	 * returns a Route instance from the driver name.
	 * @param name the route name
	 * @return Route with name.
	 */
	public Route getRouteByName(String name)
	{
		for (Route route : routes)
		{
			if(route.getName().equals(name))
			{
				return route;
			}
		}
		
		return null;
	}

	/**
	 * Returns the list of all routes at the system. 
	 * @return all routes at the system.
	 */
	public ArrayList<Route> getRoutes() {
		return routes;
	}

	/**
	 * Returns a list with all routes name.
	 * @return routes name.
	 */
	public ArrayList<String> getRoutesName()
	{
		ArrayList<String> names = new ArrayList<String>();
		
		if(routes != null)
		{
			for (Route route : routes) {
				names.add(route.getName());
			}
		}
		
		return names;
	}

	/**
	 * Returns the PublicTransportCenter search. 
	 * @return the Search instance.
	 */
	public Search getSearch()
	{
		return search;
	}

	/**
	 * Returns the list of all semaphores at the system. 
	 * @return all semaphores at the system.
	 */
	public ArrayList<Semaphore> getSemaphores() {
		return semaphores;
	}

	/**
	 * Returns a Station object of stations by the name.
	 * @param name the Station name.
	 * @return the instance Station.
	 */
	public Station getStationByName(String name)
	{
		for (Station station : stations)
		{
			if(station.getName().trim().compareToIgnoreCase(name.trim()) == 0)
			{
				return station;
			}
		}
		
		return null;
	}

	/**
	 * Returns the list of all stations in the system. 
	 * @return all stations
	 */
	public ArrayList<Station> getStations() {
		return stations;
	}

	/**
	 * Searches in the roads the start and final point of each station and semaphore.
	 */
	public void loadNodesAttached()
	{
		ArrayList<Object> nodesAttached;
		Point2D.Double startPoint;
		Point2D.Double finalPoint;
		Point2D.Double position;
		
		for (Road road : roads)
		{
			nodesAttached = new ArrayList<Object>();
			
			startPoint = road.getStartPoint();
			finalPoint = road.getFinalPoint();
			
			for (Station station : stations)
			{
				position = station.getPosition();
				if(UtilCalc.comparePoints(startPoint, position))
				{
					nodesAttached.add(0, station);
				}
				else
				{
					if(UtilCalc.comparePoints(finalPoint, position))
					{
						if(nodesAttached.size() > 0)
						{
							nodesAttached.add(1, station);
						}
						else
						{
							nodesAttached.add(0, station);
						}
					}
				}
			}
			
			for (Semaphore semaphore : semaphores)
			{
				position = semaphore.getPosition();
				if(UtilCalc.comparePoints(startPoint, position))
				{
					nodesAttached.add(0, semaphore);
				}else
				{
					if(UtilCalc.comparePoints(finalPoint, position))
					{
						if(nodesAttached.size() > 0)
						{
							nodesAttached.add(1, semaphore);
						}
						else
						{
							nodesAttached.add(0, semaphore);
						}
					}
				}
			}
			
			road.addNodesAttached(nodesAttached);
			
			if(nodesAttached.size() < 2)
			{
				System.out.println(road.getName() + " --> " + road.getNodesAttached());
			}
		}
	}

	/**
	 * Sets the buses to the start at system.
	 * @param buses all buses to the start at system.
	 */
	public void setBuses(ArrayList<Bus> buses) {
		this.buses = buses;
	}
	
	
	/**
	 * Sets the drivers to the start at system.
	 * @param drivers all driver at the system.
	 */
	public void setDrivers(ArrayList<Driver> drivers) {
		this.drivers = drivers;
	}
	
	/**
	 * Sets the roads to the start at system.
	 * @param roads all roads at system.
	 */
	public void setRoads(ArrayList<Road> roads) {
		this.roads = roads;
	}
	
	/**
	 * Sets the routes to the start at system.
	 * @param routes all routes to the start at system.
	 */
	public void setRoutes(ArrayList<Route> routes) {
		this.routes = routes;
	}
	
	/**
	 * Sets the semaphores to the start at system.
	 * @param semaphores all semaphores at the system
	 */
	public void setSemaphores(ArrayList<Semaphore> semaphores) {
		this.semaphores = semaphores;
	}
	
	/**
	 * Sets the stations to the start at system.
	 * @param stations all stations to start at system.
	 */
	public void setStations(ArrayList<Station> stations) {
		this.stations = stations;
	}

	@Override
	public String toString() {
		return "PublicTransportCenter [buses = " + buses + ", Stations = "
				+ stations + ", routes = " + routes + ", semaphores = "
				+ semaphores + ", drivers = " + drivers + ", roads = " + roads + "]";
	}

	/**
	 * Returns a bus instance from the id
	 * @param id the id for compare with the buses at the system.
	 * @return a bus instance from the id
	 */
	public Bus getBusByID(String id) {
		for (Bus bus : buses) {
			if(bus.getId().equals(id))
			{
				return bus;
			}
		}
		
		return null;
	}

	/**
	 * Add a list of the nodes to the graph.
	 */
	public void addListNode() {
		graph.addListNode(semaphores);
		graph.addListNode(stations);
	}

	/**
	 * Adds a edge to all roads.
	 */
	public void addListBidirectionalEdge() {
		graph.addListBidirectionalEdge(roads);
	}
}
