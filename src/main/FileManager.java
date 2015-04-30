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

	public ArrayList<Activity> readActivityFiles()
	{
		ArrayList<Activity> activityList = new ArrayList<Activity>();
		for (int i = 0; i < this.activityFileNames.length; i++)
		{
			try
			{
				FileInputStream fileInput = new FileInputStream(new File("data", "/activities/" + this.activityFileNames[i]));
				ObjectInputStream objectInput = new ObjectInputStream(fileInput);
				activityList.add((Activity) (objectInput.readObject()));
				objectInput.close();
				fileInput.close();
			}
			catch (Exception e)
			{
				System.out.println("Exception: File not found!");
				return null;
			}
		}
		activityList = this.mergeSortActivitiesByID(activityList, 0, activityList.size() - 1);
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
				restaurantList.add((Restaurant) (objectInput.readObject()));
				objectInput.close();
				fileInput.close();
			}
			catch (Exception e)
			{
				System.out.println("Exception: File not found!");
				return null;
			}
		}
		restaurantList = this.mergeSortRestaurantsByID(restaurantList, 0, restaurantList.size() - 1);
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
				userList.add((RegUser) (objectInput.readObject()));
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

	public ArrayList<Activity> mergeSortActivitiesByID(ArrayList<Activity> activityList, int start, int end)
	{
		if (start < end)
		{
			int mid = (start + end) / 2;
			if (end - start <= 50)
			{
				activityList = this.insertionSortActivitiesByID(activityList, start, end);
			}
			else
			{
				activityList = this.mergeSortActivitiesByID(activityList, start, mid);
				activityList = this.mergeSortActivitiesByID(activityList, mid + 1, end);
			}
			if (activityList.get(mid).getID() <= activityList.get(mid+1).getID())
			{
				return activityList;
			}
			activityList = this.mergeActivities(activityList, start, mid, end);
		}
		return activityList;
	}

	public ArrayList<Activity> mergeActivities(ArrayList<Activity> activityList, int min, int mid, int max)
	{
		ArrayList<Activity> temp = new ArrayList<Activity>();
		int i = min;
		int j = mid + 1;
		int k = min;
		while (i <= mid && j <= max)
		{
			if (activityList.get(i).getID() > activityList.get(j).getID())
			{
				temp.add(activityList.get(j));
				j++;
			}
			else
			{
				temp.add(activityList.get(i));
				i++;
			}
		}
		while (i <= mid)
		{
			temp.add(activityList.get(i));
			i++;
		}
		while (j <= max)
		{
			temp.add(activityList.get(j));
			j++;
		}
		for (int m = 0; m < temp.size(); m++, k++)
		{
			activityList.set(k, temp.get(m));
		}
		return activityList;
	}

	public ArrayList<Activity> insertionSortActivitiesByID(ArrayList<Activity> activityList, int min, int max)
	{
		Activity temp;
		for (int i = min + 1; i <= max; i++)
		{
			int j = i;
			temp = activityList.get(i);
			while (j > min && temp.getID() < activityList.get(j-1).getID())
			{
				activityList.set(j, activityList.get(j-1));
				j--;
			}
			activityList.set(j, temp);
		}
		return activityList;
	}

	public ArrayList<Restaurant> mergeSortRestaurantsByID(ArrayList<Restaurant> restaurantList, int start, int end)
	{
		if (start < end)
		{
			int mid = (start + end) / 2;
			if (end - start <= 50)
			{
				restaurantList = this.insertionSortRestaurantsByID(restaurantList, start, end);
			}
			else
			{
				restaurantList = this.mergeSortRestaurantsByID(restaurantList, start, mid);
				restaurantList = this.mergeSortRestaurantsByID(restaurantList, mid + 1, end);
			}
			if (restaurantList.get(mid).getID() <= restaurantList.get(mid + 1).getID())
			{
				return restaurantList;
			}
			restaurantList = this.mergeRestaurants(restaurantList, start, mid, end);
		}
		return restaurantList;
	}

	public ArrayList<Restaurant> mergeRestaurants(ArrayList<Restaurant> restaurantList, int min, int mid, int max)
	{
		ArrayList<Restaurant> temp = new ArrayList<Restaurant>();
		int i = min;
		int j = mid + 1;
		int k = min;
		while (i <= mid && j <= max)
		{
			if (restaurantList.get(i).getID() > restaurantList.get(j).getID())
			{
				temp.add(restaurantList.get(j));
				j++;
			}
			else
			{
				temp.add(restaurantList.get(i));
				i++;
			}
		}
		while (i <= mid)
		{
			temp.add(restaurantList.get(i));
			i++;
		}
		while (j <= max)
		{
			temp.add(restaurantList.get(j));
			j++;
		}
		for (int m = 0; m < temp.size(); m++, k++)
		{
			restaurantList.set(k, temp.get(m));
		}
		return restaurantList;
	}

	public ArrayList<Restaurant> insertionSortRestaurantsByID(ArrayList<Restaurant> restaurantList, int min, int max)
	{
		Restaurant temp;
		for (int i = min + 1; i <= max; i++)
		{
			int j = i;
			temp = restaurantList.get(i);
			while (j > min && temp.getID() < restaurantList.get(j-1).getID())
			{
				restaurantList.set(j, restaurantList.get(j-1));
				j--;
			}
			restaurantList.set(j, temp);
		}
		return restaurantList;
	}

}