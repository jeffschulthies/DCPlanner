package itinerary;
import java.io.Serializable;

import location.Location;

public class ItineraryIterator implements ItineraryIteratorInterface, Serializable
{

	private Node current;
	private Node previous;
	private Itinerary parent;
	
	public ItineraryIterator(Itinerary parent)
	{
		this.current = null;
		this.previous = null;
		this.parent = parent;
	}
	
	public Location next()
	{
		if (!this.hasNext())
		{
			System.out.println("Error: End of iteration has been surpassed.");
			return null;
		}
		this.previous = this.current;
		if (this.current == null)
		{
			this.current = this.parent.getFirstNode();
		}
		else
		{
			this.current = this.current.getNext();
		}
		return this.current.getData();
	}
	
	public boolean hasNext()
	{
		if ((this.current == null && this.parent.getFirst() == null) || (this.current.getNext() == null))
		{
			return false;
		}
		return true;
	}
	
	public void remove()
	{
		if (this.previous == this.current)
		{
			System.out.println("Error: Previous position node is equal to current position node.");
			return;
		}
		else if (this.current == this.parent.getFirstNode())
		{
			this.parent.removeFirst();
		}
		else
		{
			this.previous.setNext(this.current.getNext());
		}
		this.current = this.previous;
	}
	
	public void set(Location newLocation)
	{
		if (this.current == null)
		{
			System.out.println("Error: Current position node is null.");
			return;
		}
		this.current.setData(newLocation);
	}
	
	public void add(Location newLocation)
	{
		if (this.current == null)
		{
			this.parent.addFirst(newLocation);
			this.current = this.parent.getFirstNode();
		}
		else
		{
			Node newNode = new Node();
			newNode.setData(newLocation);
			newNode.setNext(this.current.getNext());
			this.current.setNext(newNode);
			this.current = newNode;
		}
		this.previous = this.current;
	}
	
}
