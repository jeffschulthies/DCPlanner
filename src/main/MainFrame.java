import java.util.ArrayList;
import java.util.Scanner;
import location.Activity;
import location.Restaurant;
import user.RegUser;

public class MainFrame 
{
	
	private static Scanner scnr;
	private static FileManager files;
	private static ArrayList<Activity> activityList;
	private static ArrayList<Restaurant> restaurantList;
	private static ArrayList<RegUser> userList;
	private static boolean running;

	public static void main(String[] args)
	{
		scnr = new Scanner(System.in);
		files = new FileManager();
		activityList = files.readActivityFiles();
		restaurantList = files.readRestaurantFiles();
		userList = files.readUserFiles();
		running = true;
		
		while (running)
		{
			System.out.println("Please select an option:");
			System.out.println("1. Login as Admin");
			System.out.println("2. Print out activity names...");
			System.out.println("3. Print out restaurant names...");
			System.out.println("4. Print out usernames...");	
		}
	}
	
}
