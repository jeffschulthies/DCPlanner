package user.types;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.ArrayList;

import location.types.Activity;
import location.types.Restaurant;
import user.User;

public class Admin extends User implements Serializable
{
	
	public Admin(String username, long userID, String password)
	{
		super(username, userID, password);
	}
	
	public ArrayList<Activity> addActivity(ArrayList<Activity> activityList, String name, String address, long id, String description, BufferedImage image, int openHour, int closeHour, ArrayList<String> tags, double price)
	{
		Activity newActivity = new Activity(name, address, id, description, image, openHour, closeHour, tags, price);
		activityList.add(newActivity);
		return activityList;
	}
	
	public ArrayList<Restaurant> addRestaurant(ArrayList<Restaurant> restaurantList, String name, String address, long id, String description, BufferedImage image, int openHour, int closeHour, String type, String genre, int priceRange)
	{
		Restaurant newRestaurant = new Restaurant(name, address, id, description, image, openHour, closeHour, type, priceRange);
		restaurantList.add(newRestaurant);
		return restaurantList;
	}

	public ArrayList<Activity> deleteActivity(ArrayList<Activity> activityList, long activityID)
	{
		for (int i = 0; i < activityList.size(); i++)
		{
			if (activityList.get(i).getID() == activityID)
			{
				activityList.remove(i);
			}
		}
		return activityList;
	}
	
	public ArrayList<Restaurant> deleteRestaurant(ArrayList<Restaurant> restaurantList, long restaurantID)
	{
		for (int i = 0; i < restaurantList.size(); i++)
		{
			if (restaurantList.get(i).getID() == restaurantID)
			{
				restaurantList.remove(i);
			}
		}
		return restaurantList;
	}
	
	public ArrayList<RegUser> addUser(ArrayList<RegUser> userList, String username, long userID, String password)
	{
		RegUser newUser = new RegUser(username, userID, password);
		userList.add(newUser);
		return userList;
	}

	public ArrayList<RegUser> deleteUser(ArrayList<RegUser> userList, long userID)
	{
		int lo = 0;
		int hi  = userList.size() - 1;
		int mid = (lo + hi) / 2;

		if(userList.get(mid).getUserID() == userID) {
			userList.remove(mid);
			return userList;
		} else if(lo >= hi) {
			System.out.println("User not found");
			return userList;
		}

		if(userID > userList.get(mid).getUserID()) {
			userList = deleteUser(userList, userID, lo, mid - 1);
		}
		else {
			userList = deleteUser(userList, userID, mid + 1, hi);
		}

		return userList;
	}

	//Recursive deleteUser
	public ArrayList<RegUser> deleteUser(ArrayList<RegUser> userList, long userID, int lo, int hi)
	{
		int mid = (lo + hi) / 2;

		if(userList.get(mid).getUserID() == userID) {
			userList.remove(mid);
			return userList;
		} else if(lo >= hi) {
			System.out.println("User not found");
			return userList;
		}

		if(userID > userList.get(mid).getUserID()) {
			deleteUser(userList, userID, lo, mid - 1);
		} else {
			deleteUser(userList, userID, mid, hi);
		}

		return userList;

	}


}
