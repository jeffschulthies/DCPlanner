package itinerary;
import java.io.Serializable;

import location.Location;

public class Node implements Serializable
{

	private Object data;
	private Node next;
	
	public Node()
	{
		this.data = null;
		this.next = null;
	}
	
	public Object getData()
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
	
}
