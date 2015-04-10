package itinerary;
import location.Location;

public interface ItineraryIteratorInterface 
{

	public Location next();
	
	public boolean hasNext();
	
	public void remove();
	
	public void set(Location newLocation);
	
	public void add(Location newLocation);
	
}
