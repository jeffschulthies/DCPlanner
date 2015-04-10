package user;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import location.Activity;
import location.Restaurant;

public interface AdminInterface 
{
	
	public ArrayList<Activity> addActivity(ArrayList<Activity> activityList, String name, String address, long id, String description, BufferedImage image, int openHour, int closeHour, ArrayList<String> tags, double price);
	
	public ArrayList<Restaurant> addRestaurant(ArrayList<Restaurant> restaurantList, String name, String address, long id, String description, BufferedImage image, int openHour, int closeHour, String type, String genre, int priceRange);

	public ArrayList<Activity> deleteActivity(ArrayList<Activity> activityList, long activityID);
	
	public ArrayList<Restaurant> deleteRestaurant(ArrayList<Restaurant> restaurantList, long restaurantID);
	
	public ArrayList<RegUser> addUser(ArrayList<RegUser> userList, String username, long userID, String password);
	
	public ArrayList<RegUser> deleteUser(ArrayList<RegUser> userList, long userID);
	
}
