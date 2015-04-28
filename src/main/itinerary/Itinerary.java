package itinerary;
import java.io.Serializable;
import location.Location;
import java.util.ArrayList;

public class Itinerary implements Serializable
{

	private Node first;
	private int tripStartTime;
	private int tripEndTime;
	private int[] diningTimes;
	private boolean freeOnly;
	private ArrayList<String> tripTags;

	public Itinerary(int tripStartTime, int tripEndTime, boolean freeOnly, ArrayList<String> tripTags)
	{
		this.first = null;
		this.tripStartTime = tripStartTime;
		this.tripEndTime = tripEndTime;
		this.diningTimes = new int[3];
		this.freeOnly = freeOnly;
		this.tripTags = tripTags;
	}

	public Node getFirstNode()
	{
		if (this.first == null)
		{
			System.out.println("Error: First is null");
			return null;
		}
		return this.first;
	}

	public Location getFirst()
	{
		if (this.first == null)
		{
			System.out.println("Error: First is null");
			return null;
		}
		return this.first.getData();
	}

	public void addFirst(Location newLocation, int startTime, int endTime)
	{
		Node newNode = new Node();
		newNode.setData(newLocation);
		newNode.setNext(this.first);
		newNode.setStartTime(startTime);
		newNode.setEndTime(endTime);
		this.first = newNode;
	}

	public Location removeFirst()
	{
		if (this.first == null)
		{
			System.out.println("Error: First is null");
			return null;
		}
		Location removeLocation = this.first.getData();
		this.first = this.first.getNext();
		return removeLocation;
	}

	public ItineraryIterator itineraryIterator()
	{
		return new ItineraryIterator(this);
	}

	public int getTripStartTime()
	{
		return this.tripStartTime;
	}

	public int getTripEndTime()
	{
		return this.tripEndTime;
	}

	public int[] getDiningTimes()
	{
		return this.diningTimes;
	}

	public void setDiningTimes(int timeOne, int timeTwo, int timeThree)
	{
		this.diningTimes[0] = timeOne;
		this.diningTimes[1] = timeTwo;
		this.diningTimes[2] = timeThree;
	}

	public boolean getFreeOnly()
	{
		return this.freeOnly;
	}

	public ArrayList<String> getTripTags()
	{
		return this.tripTags;
	}

}
