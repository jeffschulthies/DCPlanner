package itinerary;
import location.Location;

public interface NodeInterface 
{

	public Location getData();
	
	public void setData(Location newLocation);
	
	public Node getNext();
	
	public void setNext(Node newNode);
	
}
