import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import location.types.Activity;
import location.types.Restaurant;
import user.types.RegUser;

public class FileManager implements Serializable
{

	private String[] activityFileNames;
	private String[] restaurantFileNames;
	private String[] userFileNames;

	public FileManager()
	{
		File activityDirectory = new File("data", "/activities/");
		File restaurantDirectory = new File("data", "/restaurants/");
		File userDirectory = new File("data", "/users/");
		this.activityFileNames = activityDirectory.list();
		this.restaurantFileNames = restaurantDirectory.list();
		this.userFileNames = userDirectory.list();
	}
	
	// TODO: Allow main.user to choose which directory serialized files are saved to.
	// TODO: Exceptions for first run and directory creation.

	public ArrayList<Activity> readActivityFiles()
	{
		ArrayList<Activity> activityList = new ArrayList<Activity>();
		//TODO Add organization
		for (int i = 0; i < this.activityFileNames.length; i++)
		{
			try
			{
				FileInputStream fileInput = new FileInputStream(new File("data", "/activities/" + this.activityFileNames[i]));
				ObjectInputStream objectInput = new ObjectInputStream(fileInput);
				activityList.add((Activity)(objectInput.readObject()));
				objectInput.close();
				fileInput.close();
			}
			catch (Exception e)
			{
				System.out.println("Exception: File not found!");
				return null;
			}
		}
		return activityList;
	}
	
	public ArrayList<Restaurant> readRestaurantFiles()
	{
		ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
		for (int i = 0; i < this.restaurantFileNames.length; i++)
		{
			try
			{
				FileInputStream fileInput = new FileInputStream(new File("data", "/restaurants/" + this.restaurantFileNames[i]));
				ObjectInputStream objectInput = new ObjectInputStream(fileInput);
				restaurantList.add((Restaurant)(objectInput.readObject()));
				objectInput.close();
				fileInput.close();
			}
			catch (Exception e)
			{
				System.out.println("Exception: File not found!");
				return null;
			}
		}
		return restaurantList;
	}
	
	public ArrayList<RegUser> readUserFiles()
	{
		ArrayList<RegUser> userList = new ArrayList<RegUser>();
		for (int i = 0; i < this.userFileNames.length; i++)
		{
			try
			{
				FileInputStream fileInput = new FileInputStream(new File("data", "/users/" + this.userFileNames[i]));
				ObjectInputStream objectInput = new ObjectInputStream(fileInput);
				userList.add((RegUser)(objectInput.readObject()));
				objectInput.close();
				fileInput.close();
			}
			catch (Exception e)
			{
				System.out.println("Exception: File not found!");
				return null;
			}
		}
		return userList;
	}
	
	public void writeActivityFiles(ArrayList<Activity> activityList)
	{
		for (int i = 0; i < activityList.size(); i++)
		{
			try
			{
				FileOutputStream fileOutput = new FileOutputStream(new File("data", "/activities/" + activityList.get(i).getName() + ".data"));
				ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
				objectOutput.writeObject(activityList.get(i));
				objectOutput.close();
				fileOutput.close();
			}
			catch (Exception e)
			{
				System.out.println("Exception: Unable to serialize and save file!");
				return;
			}
		}
	}
	
	public void writeRestaurantFiles(ArrayList<Restaurant> restaurantList)
	{
		for (int i = 0; i < restaurantList.size(); i++)
		{
			try
			{
				FileOutputStream fileOutput = new FileOutputStream(new File("data", "/restaurants/" + restaurantList.get(i).getName() + ".data"));
				ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
				objectOutput.writeObject(restaurantList.get(i));
				objectOutput.close();
				fileOutput.close();
			}
			catch (Exception e)
			{
				System.out.println("Exception: Unable to serialize and save file!");
				return;
			}
		}
	}
	
	public void writeUserFiles(ArrayList<RegUser> userList)
	{
		for (int i = 0; i < userList.size(); i++)
		{
			try
			{
				FileOutputStream fileOutput = new FileOutputStream(new File("data", "/users/" + userList.get(i).getUsername() + ".data"));
				ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
				objectOutput.writeObject(userList.get(i));
				objectOutput.close();
				fileOutput.close();
			}
			catch (Exception e)
			{
				System.out.println("Exception: Unable to serialize and save file!");
				return;
			}
		}
	}

}
