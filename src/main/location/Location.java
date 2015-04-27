package location;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public class Location implements LocationInterface, Serializable
{
	
	private String name;
	private String address;
	private long id;
	private String description;
	private double longitude;
	private double latitude;
	private BufferedImage image;
	private int[] hours;
	
	public Location(String name, String address, long id, String description, double longitude, double latitude, BufferedImage image, int openHour, int closeHour)
	{
		this.name = name;
		this.address = address;
		this.id = id;
		this.description = description;
		this.longitude = longitude;
		this.latitude = latitude;
		this.image = image;
		this.hours = new int[2];
		this.hours[0] = openHour;
		this.hours[1] = closeHour;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getAddress()
	{
		return this.address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
	public long getID()
	{
		return this.id;
	}
	
	public void setID(long id)
	{
		this.id = id;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}

	public double getLongitude()
	{
		return this.longitude;
	}

	public void setLongitude(double longitude)
	{
		this.longitude = longitude;
	}

	public double getLatitude()
	{
		return this.latitude;
	}

	public void setLatitude(double latitude)
	{
		this.latitude = latitude;
	}
	
	public BufferedImage getImage()
	{
		return this.image;
	}
	
	public void setImage(BufferedImage image)
	{
		this.image = image;
	}
	
	public int getOpenHour()
	{
		return this.hours[0];
	}
	
	public int getCloseHour()
	{
		return this.hours[1];
	}
	
	public void setHours(int open, int close)
	{
		this.hours[0] = open;
		this.hours[1] = close;
	}

}
