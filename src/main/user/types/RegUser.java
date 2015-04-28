package user.types;
import itinerary.Itinerary;
import user.User;

import java.io.Serializable;
import java.util.ArrayList;

public class RegUser extends User implements Serializable
{

	private ArrayList<Itinerary> itineraries;
	private ArrayList<String> interests;
	private ArrayList<String> foodTypePrefs;
	private ArrayList<String> foodGenrePrefs;
	
	public RegUser(String username, long userID, String password)
	{
		super(username, userID, password);
		this.itineraries = new ArrayList<Itinerary>();
		this.interests = new ArrayList<String>();
		this.foodTypePrefs = new ArrayList<String>();
		this.foodGenrePrefs = new ArrayList<String>();
	}
	
	public void addItinerary(Itinerary newItinerary)
	{
		this.itineraries.add(newItinerary);
	}
	
	public Itinerary getItinerary(int index)
	{
		return this.itineraries.get(index);
	}
	
	public int getNumItineraries()
	{
		return this.itineraries.size();
	}
	
	public void addInterest(String interest)
	{
		this.interests.add(interest);
	}
	
	public String getInterest(int index)
	{
		return this.interests.get(index);
	}
	
	public int getNumInterests()
	{
		return this.interests.size();
	}
	
	public void addFoodTypePref(String foodTypePref)
	{
		this.foodTypePrefs.add(foodTypePref);
	}
	
	public String getFoodTypePref(int index)
	{
		return this.foodTypePrefs.get(index);
	}
	
	public int getNumFoodTypePrefs()
	{
		return this.foodTypePrefs.size();
	}
	
	public void addFoodGenrePref(String foodGenrePref)
	{
		this.foodGenrePrefs.add(foodGenrePref);
	}
	
	public String getFoodGenrePref(int index)
	{
		return this.foodGenrePrefs.get(index);
	}
	
	public int getNumFoodGenrePrefs()
	{
		return this.foodGenrePrefs.size();
	}
	
}
