package user.types;
import itinerary.Itinerary;

public interface RegUserInterface 
{

	public void addItinerary(Itinerary newItinerary);
	
	public Itinerary getItinerary(int index);
	
	public int getNumItineraries();
	
	public void addInterest(String interest);
	
	public String getInterest(int index);
	
	public int getNumInterests();
	
	public void addFoodTypePref(String foodTypePref);
	
	public String getFoodTypePref(int index);
	
	public int getNumFoodTypePrefs();
	
	public void addFoodGenrePref(String foodGenrePref);
	
	public String getFoodGenrePref(int index);
	
	public int getNumFoodGenrePrefs();
	
}
