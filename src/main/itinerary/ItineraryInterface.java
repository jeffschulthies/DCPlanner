package itinerary;
import location.Location;

public interface ItineraryInterface 
{
	
	public Location getFirst();
	
	public void addFirst(Location newLocation);
	
	public Location removeFirst();
	
	public ItineraryIterator itineraryIterator();
	
}
