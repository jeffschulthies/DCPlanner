package itinerary;
import java.io.Serializable;
import location.Location;

public class Node implements Serializable
{

	private Location data;
	private Node next;
	private int startTime;
	private int endTime;

	public Node()
	{
		this.data = null;
		this.next = null;
	}

	public Location getData()
	{
		return this.data;
	}

	public void setData(Location newLocation)
	{
		this.data = newLocation;
	}

	public Node getNext()
	{
		return this.next;
	}

	public void setNext(Node newNode)
	{
		this.next = newNode;
	}

	public int getStartTime()
	{
		return this.startTime;
	}

	public void setStartTime(int startTime)
	{
		this.startTime = startTime;
	}

	public int getEndTime()
	{
		return this.endTime;
	}

	public void setEndTime(int endTime)
	{
		this.endTime = endTime;
	}

}

