import java.io.*;
import java.util.ArrayList;

import location.types.Activity;
import location.types.Restaurant;
import user.User;
import user.types.Admin;
import user.types.RegUser;

public class FileManager implements Serializable
{

	private String[] activityFileNames;
	private String[] restaurantFileNames;
	private String[] userFileNames;

	public FileManager() {
		File activityDirectory = new File("data", "/activities/");
		File restaurantDirectory = new File("data", "/restaurants/");
		File userDirectory = new File("data", "/users/");
		File adminDirectory = new File("data", "/users/admin/");
		File regularDirectory = new File("data", "/users/regular/");

		if(adminDirectory.list().length == 0) {
			Admin admin = new Admin("admin", 1, "password");
			try {
				writeAdmin(admin);
			} catch(Exception e) {
				System.out.println("Exception");
			}
		}

		if(regularDirectory.list().length == 0) {
			RegUser user = new RegUser("user", 1, "password");
			try {
				writeUser(user);
			} catch(Exception e) {
				System.out.println("Exception");
			}
		}


		this.activityFileNames = activityDirectory.list();
		this.restaurantFileNames = restaurantDirectory.list();
		this.userFileNames = userDirectory.list();
	}

	public FileManager(String temp) {

	}

	// TODO: Allow main.user to choose which directory serialized files are saved to.
	// TODO: Exceptions for first run and directory creation.

	public ArrayList<Activity> readActivityFiles()
	{
		ArrayList<Activity> activityList = new ArrayList<Activity>();
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
		File regularDirectory = new File("data", "/users/regular/");
		ArrayList<RegUser> userList = new ArrayList<RegUser>();
			for (int i = 0; i < regularDirectory.list().length; i++) {
				try {
					FileInputStream fileInput = new FileInputStream(new File("data", "/users/regular/" + this.userFileNames[i]));
					ObjectInputStream objectInput = new ObjectInputStream(fileInput);
					userList.add((RegUser) (objectInput.readObject()));
					objectInput.close();
					fileInput.close();
				} catch (Exception e) {
					System.out.println("Read UserFiles");
					return null;
				}
			}

		return userList;

	}
	public ArrayList<String> listFilesForFolder(final File folder) {
		ArrayList<String> filesNames = new ArrayList<String>();
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				filesNames.add(fileEntry.getName());
			}
		}
		return filesNames;
	}
	public ArrayList<RegUser> readUserFilesTwo()
	{
		File regularDirectory = new File("data", "/users/regular/");
		ArrayList<RegUser> userList = new ArrayList<RegUser>();

		ArrayList<String> filesNames = listFilesForFolder(regularDirectory);

		for(int i = 0; i < filesNames.size(); i++) {
			System.out.println(filesNames.get(i));
		}

		for (int i = 0; i < regularDirectory.list().length; i++) {
			try {
				FileInputStream fileInput = new FileInputStream(new File("data", "/users/regular/" + filesNames.get(i)));
				ObjectInputStream objectInput = new ObjectInputStream(fileInput);
				userList.add((RegUser) (objectInput.readObject()));
				objectInput.close();
				fileInput.close();
			} catch (Exception e) {
				System.out.println("Not reading!");
				return null;
			}
		}

		return userList;

	}


	public ArrayList<Admin> readAdminFiles()
	{
		ArrayList<Admin> userList = new ArrayList<Admin>();
		for (int i = 0; i < this.userFileNames.length; i++)
		{
			try
			{
				FileInputStream fileInput = new FileInputStream(new File("data", "/users/admin/" + this.userFileNames[i]));
				ObjectInputStream objectInput = new ObjectInputStream(fileInput);
				userList.add((Admin)(objectInput.readObject()));
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
				FileOutputStream fileOutput = new FileOutputStream(new File("data", "/users/regular/" + userList.get(i).getUsername() + ".data"));
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

	public void writeUser(RegUser user) {
		try {
			FileOutputStream fileOutput = new FileOutputStream(new File("data", "/users/regular/" + user.getUsername() + ".data"));
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(user);
			objectOutput.close();
			fileOutput.close();
		} catch(Exception e) {
			System.out.println("Exception: Unable to serialize and save file!");
		}
	}

	public void writeAdmin(Admin user) {
		try {
			FileOutputStream fileOutput = new FileOutputStream(new File("data", "/users/admin/" + user.getUsername() + ".data"));
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(user);
			objectOutput.close();
			fileOutput.close();
		} catch(Exception e) {
			System.out.println("Exception: Unable to serialize and save file!");
		}
	}


}
