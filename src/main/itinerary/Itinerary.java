package itinerary;
import java.io.Serializable;
import location.Location;

public class Itinerary implements Serializable
{

	private Node first;

	public Itinerary()
	{
		this.first = null;
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

	public void addFirst(Location newLocation)
	{
		Node newNode = new Node();
		newNode.setData(newLocation);
		newNode.setNext(this.first);
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

}
